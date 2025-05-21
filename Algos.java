import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import Graphs.Arc;
import Graphs.Graph;

public class Algos {
    public static void main(String[] args) {
        Graph graph = new Graph("Graphs/Graph tests/graph50.txt");

        Graph randomGraph1 = new Graph(100, 0.1);
        randomGraph1.addArc(new Arc(0, 4, 1));
        randomGraph1.addArc(new Arc(1, 2, 4));
        randomGraph1.addArc(new Arc(4, 3, 2));

        long startTime1 = System.currentTimeMillis();
        System.out.println(graph.algoDijkstra(0, 7));
        long endTime1 = System.currentTimeMillis() - startTime1;

        System.out.println("Time for the first algo " + endTime1);

        long startTime2 = System.currentTimeMillis();
        System.out.println(randomGraph1.algoDijkstra(0, 7));
        long endTime2 = System.currentTimeMillis() - startTime2;

        System.out.println("Time for the second algo " + endTime2);

        System.out.println("Way " + graph.showTheWay());
        System.out.println("Way " + randomGraph1.showTheWay());

    }

    public static ArrayList<Integer> generateRandomInts(int lowerBound, int upperBound, int n) {
        List<Integer> result = new ArrayList<>();
        Random random = new Random();
        result = random.ints((long) n, lowerBound, upperBound).boxed().toList();
        return new ArrayList<>(result);
    }

    public static List<LinkedList<Integer>> splitInHalf(LinkedList<Integer> list){
        LinkedList<Integer> copyList = new LinkedList<>(list);
        List<LinkedList<Integer>> result = new ArrayList<>();
        int halfLength = list.size() / 2;
        LinkedList<Integer> firstHalf = new LinkedList<>();

        for (int i = 0; i < halfLength; i++) {
            firstHalf.add(copyList.pollFirst());
        }

        result.add(firstHalf);
        result.add(copyList);
        return result;
    }

    public static LinkedList<Integer> fusionSort(LinkedList<Integer> unsortedList) {
        if (unsortedList.size() > 1) {
            List<LinkedList<Integer>> twoLists = splitInHalf(unsortedList);
            twoLists.set(0, fusionSort(twoLists.get(0)));
            twoLists.set(1, fusionSort(twoLists.get(1)));

            unsortedList = fusion(twoLists.get(0), twoLists.get(1));
        }
        return unsortedList;
    }

    public static LinkedList<Integer> fusion(LinkedList<Integer> s1, LinkedList<Integer> s2) {
        LinkedList<Integer> result = new LinkedList<>();
        while (Math.min(s1.size(), s2.size()) != 0) {
            if (s1.peekFirst() <= s2.peekFirst()) {
                result.offerLast(s1.pollFirst());
            }
            else {
                result.offerLast(s2.pollFirst());
            }
        }
        if (s1.size() > s2.size()) {
            result.addAll(s1);
            return result;
        }
        if (s2.size() > s1.size()) {
            result.addAll(s2);
            return result;
        }
        return result;
    }

    public static ArrayList<Integer> bubbleSort(ArrayList<Integer> unsortedList){
        for (int i = unsortedList.size(); i > 1; i--) {
            for (int j = 0; j < i-1; j++) {
                if (unsortedList.get(j) >= unsortedList.get(j+1)) {
                    Integer temp = unsortedList.get(j);
                    unsortedList.set(j, unsortedList.get(j+1));
                    unsortedList.set(j+1, temp);
                }
            }
        }

        return unsortedList;
    }


    public static ArrayList<Integer> quickSort(ArrayList<Integer> unsortedList, int leftBound, int rightBound) {
        if (leftBound < rightBound) {
            int pivot = unsortedList.get((leftBound + rightBound) / 2);
            int tempL = leftBound;
            int tempR = rightBound;

            while (tempL <= tempR) {
                while (unsortedList.get(tempL) < pivot) {
                    tempL++;
                }
                while (unsortedList.get(tempR) > pivot) {
                    tempR--;
                }  

                if (tempL <= tempR) {
                    permute(unsortedList, tempL, tempR);
                    tempL++;
                    tempR--;
                }
            }

            quickSort(unsortedList, leftBound, tempR);
            quickSort(unsortedList, tempL, rightBound);
        }
        return unsortedList;
    }

    public static ArrayList<Integer> quickSortDrapeau(ArrayList<Integer> unsortedList, int leftBound, int rightBound) {
        if (leftBound < rightBound) {
            ArrayList<Integer> pivotList = partitionDrapeau(unsortedList, leftBound, rightBound);
            quickSortDrapeau(unsortedList, leftBound, pivotList.get(0));
            quickSortDrapeau(unsortedList, pivotList.get(1), rightBound);
        }
        return unsortedList;
    }

    public static ArrayList<Integer> partitionDrapeau(ArrayList<Integer> listPivots, int leftBound, int rightBound) {
        int pivot = listPivots.get(leftBound);
        int i = leftBound;
        int g = leftBound;
        int d = rightBound;
        while (i <= d) {
            int currentElement = listPivots.get(i);
            if (currentElement < pivot) {
                permute(listPivots, g, i);
                g++;
                i++;
            }
            else if (currentElement == pivot) {
                i++;
            }
            else {
                permute(listPivots, i, d);
                d--;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(g);
        result.add(d+1);
        return result;
    }




    public static void permute(ArrayList<Integer> list, int index1, int index2){
        int temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }
}
