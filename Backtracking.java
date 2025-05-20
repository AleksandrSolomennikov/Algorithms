import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class Backtracking {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(0, 3);
        System.err.println(list);

        //ArrayList<Item> items = fillList("sac4.txt");
        //System.out.println(sacBacktracking(items, capacity, 0, 0, new ArrayList<Item>()));
        //System.out.println(sacDP(items, capacity));
        //System.out.println(solution);
    }

    static int capacity;
    static ArrayList<Item> solution = new ArrayList<>();
    static int bestValue = 0;

    public static ArrayList<Item> fillList(String filePath) {
        ArrayList<Item> items = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            capacity = Integer.parseInt(br.readLine().trim());
            while ((line = br.readLine()) != null) {
                line = line.trim();
                String[] parts = line.split(" ");
                items.add(new Item(Integer.parseInt(parts[0]), Integer.parseInt(parts[1])));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return items;
    }

    public static int sacBacktracking(ArrayList<Item> items, int capacity, int index, int currentValue, ArrayList<Item> currentSolution) {
        if (index == items.size() || capacity == 0) {
            if (currentValue > bestValue) {
                bestValue = currentValue;
                solution = new ArrayList<>(currentSolution);
            }
            return currentValue;
        }

        Item currentItem = items.get(index);

        // On passe un objet courant
        int exclude = sacBacktracking(items, capacity, index + 1, currentValue, currentSolution); 

        // "include" et "exclude" sont des valeurs temporaires  

        // On prend l'objet courant si le poids le permet
        int include = 0;
        if (currentItem.weight() <= capacity) {
            currentSolution.add(currentItem);
            include = sacBacktracking(items, capacity - currentItem.weight(), index + 1, currentValue + currentItem.value(), currentSolution);
            currentSolution.remove(currentSolution.size() - 1);
        }

        return Math.max(exclude, include);
    }

    static int sacDP(ArrayList<Item> items, int capacity) {
        int n = items.size();
        int[][] dp = new int[n + 1][capacity + 1];
        boolean[][] selected = new boolean[n + 1][capacity + 1];

        // Chaque case represente le profit maximal d'objet

        for (int i = 1; i <= n; i++) { // Les objets
            Item item = items.get(i - 1);
            for (int w = 0; w <= capacity; w++) { // Les poids
                if (item.weight() > w) {
                    dp[i][w] = dp[i - 1][w];  // On ne prend pas l'objet
                } else {
                    int exclude = dp[i - 1][w];  // On ne prend pas l'objet
                    int include = dp[i - 1][w - item.weight()] + item.value(); // On le prend

                    if (include > exclude) {
                        dp[i][w] = include;
                        selected[i][w] = true; // On remarque qu'on prend l'objet
                    } else {
                        dp[i][w] = exclude;
                    }
                }
            }
        }


        int w = capacity;
        for (int i = n; i > 0 && w > 0; i--) {
            if (selected[i][w]) {
                Item item = items.get(i - 1);
                solution.add(item);
                w -= item.weight();
            }
        }

        return dp[n][capacity];
    }
}
