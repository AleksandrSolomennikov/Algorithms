package Graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;


public class Graph {
    private ArrayList<Arc> arcs;
    private ArrayList<Vertex> vertices;
    private int nbVertices;

    private ArrayList<Vertex> shortestWay;
    private int localEnd;

    public Graph (int nbVertices, double densityValue) {
        this.nbVertices = nbVertices;
        this.arcs = new ArrayList<>();
        this.vertices = new ArrayList<>();

        int maxNbArcs = nbVertices * (nbVertices - 1) / 2;
        Random random = new Random();

        while (((double) arcs.size() / (double) maxNbArcs) < densityValue) {
            int origin = random.nextInt(nbVertices);
            int destination;
            do {
                destination = random.nextInt(nbVertices);
            } while (destination == origin);
            int value = random.nextInt(100);
            Arc arc = new Arc(origin, value, destination);
            if (arcs.stream().noneMatch(a -> a.origin() == arc.origin() && a.destination() == arc.destination())) {
                arcs.add(arc);
                vertices.add(new Vertex(origin, Integer.MAX_VALUE));
                vertices.add(new Vertex(destination, Integer.MAX_VALUE));
            }
        }
    }

    public Graph (String filePath) {
        this.arcs = new ArrayList<>();
        this.vertices = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            this.nbVertices = Integer.parseInt(br.readLine().trim());

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");

                int origin = Integer.parseInt(parts[0]);
                int destination = Integer.parseInt(parts[1]);
                int value = Integer.parseInt(parts[2]);
                Arc arc = new Arc(origin, value, destination);

                addArc(arc);

                if (vertices.stream().noneMatch(v -> v.getName() == origin)) {
                    vertices.add(new Vertex(origin, Integer.MAX_VALUE));
                }
                if (vertices.stream().noneMatch(v -> v.getName() == destination)) {
                    vertices.add(new Vertex(destination, Integer.MAX_VALUE));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void addArc(Arc arc) {
        if (arcs.stream().noneMatch(a -> a.origin() == arc.origin() && a.destination() == arc.destination())) {
            arcs.add(arc);
        }
    }

    public ArrayList<Arc> findHeighbours(int vertex){
        ArrayList<Arc> neighbours = new ArrayList<>();
        for (Arc arc : arcs) {
            if (arc.origin() == vertex) {
                neighbours.add(arc);
            }
        }
        return neighbours;
    }


    public int algoDijkstra(int start, int end) {
        this.localEnd = end;
        this.shortestWay = new ArrayList<>();
        Map<Integer, Vertex> vertexMap = new HashMap<>();
        Map<Integer, Integer> previous = new HashMap<>();

        for (Vertex v : vertices) {
            v.setDistance(Integer.MAX_VALUE);
            vertexMap.put(v.getName(), v);
        }
        
        Vertex startVertex = vertexMap.get(start);
        startVertex.setDistance(0);

        Set<Integer> unvisited = new HashSet<>();
        for (Vertex v : vertices) {
            unvisited.add(v.getName());
        }

        while (!unvisited.isEmpty()) {
            // Le sommet avec la distance minimale
            Vertex u = unvisited.stream()
                .map(vertexMap::get)
                .filter(v -> v.getDistance() != Integer.MAX_VALUE)
                .min(Comparator.comparingInt(Vertex::getDistance))
                .orElse(null);

            if (u == null) break; // Tous les sommets atteints

            unvisited.remove(u.getName());

            for (Arc arc : findHeighbours(u.getName())) {
                int vIndex = arc.destination();
                if (!unvisited.contains(vIndex)) continue;

                Vertex v = vertexMap.get(vIndex);
                int newDistance = u.getDistance() + arc.value();
                if (newDistance < v.getDistance()) {
                    v.setDistance(newDistance);
                    previous.put(vIndex, u.getName());
                }
            }
        }

        Vertex endVertex = vertexMap.get(end);
        if (endVertex.getDistance() == Integer.MAX_VALUE) {
            return -1;
        }

        // Récupération du chemin
        LinkedList<Vertex> path = new LinkedList<>();
        Integer current = end;
        while (current != null && current != start) {
            path.addFirst(vertexMap.get(current));
            current = previous.get(current);
        }
        path.addFirst(startVertex);
        this.shortestWay = new ArrayList<>(path);
        return endVertex.getDistance();
    }



    public int algoDijkstraPriorityQueue(int start, int end) {
        this.localEnd = end;
        this.shortestWay = new ArrayList<>();
        Map<Integer, Integer> previous = new HashMap<>();
        PriorityQueue<Arc> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(Arc::value));
    
        for (Vertex vertex : vertices) {
            vertex.setDistance(Integer.MAX_VALUE);
        }
        vertices.get(start).setDistance(0);
    
        // Ajout de l'arc de départ à la file de priorité
        for (Arc arc : findHeighbours(start)) {
            int distanceThroughArc = vertices.get(start).getDistance() + arc.value();
            priorityQueue.add(new Arc(arc.origin(), distanceThroughArc, arc.destination()));
        }
    
        while (!priorityQueue.isEmpty()) {
            Arc currentArc = priorityQueue.poll();
            int uIndex = currentArc.origin();
            int vIndex = currentArc.destination();
            int l = currentArc.value();
    
            Vertex v = vertices.get(vIndex);
    
            if (l >= v.getDistance()) continue; // Si la distance actuelle est déjà plus courte
    
            v.setDistance(l);
            previous.put(vIndex, uIndex);
    
            // Ajout des voisins de v à la file de priorité
            for (Arc arc : findHeighbours(vIndex)) {
                int newDistance = v.getDistance() + arc.value();
                priorityQueue.add(new Arc(arc.origin(), newDistance, arc.destination()));
            }
        }

        // Récupération du chemin
        Vertex endVertex = vertices.get(end);

        if (endVertex.getDistance() == Integer.MAX_VALUE) {
            return -1; 
        }
    
        LinkedList<Vertex> path = new LinkedList<>();
        Integer current = end;
        while (current != null && current != start) {
            Integer finalCurrent = current;
            path.addFirst(vertices.stream().filter(v -> v.getName() == finalCurrent).findFirst().orElse(null));
            current = previous.get(current);
        }
        path.addFirst(vertices.get(start));

        this.shortestWay = new ArrayList<>(path);
        return endVertex.getDistance();
    }
    



    public String showTheWay() {
        String way = "";
        
        for (Vertex vertex : shortestWay) {
            way += vertex.getName() + " (" + vertex.getDistance() + ")" + " -> ";
        }

        if (way != "") {
            way = way.substring(0, way.length() - 4);
        }
        return way;
    }
}
