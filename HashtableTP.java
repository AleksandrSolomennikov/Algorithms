//Le tp de Aleksandr Solomennikov du groupe L2MI

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashMap;

public class HashtableTP {
    public static void main(String[] args) {
        String p = "salutchat";
        String u = "salut";

        long startTime = System.currentTimeMillis();
        System.out.println(twoSum(p, u));

        //System.out.println(twoSum(p));
        long endTime = System.currentTimeMillis();
        
        System.out.println(endTime - startTime + " ms " + "2-somme");
        
    }
    
    public static ArrayList<Integer> toIntList(String str) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            int elt = str.charAt(i);   
            result.add(elt);
        }
        return result;
    }

    public static String fromCharListToString(ArrayList<Integer> list) {
        return list.stream().map(e -> Character.toString((char) e.intValue())).reduce("", (acc, e) -> acc + e);
    }

    public static void fillHashMap(HashMap<Integer, HashMap<String, List<String>>> map, String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                String word = line;
                String sortedWord = sortWord(word);
                Integer hash = sortedWord.hashCode();
                HashMap<String, List<String>> innerMap = new HashMap<>();
                map.putIfAbsent(hash, innerMap);

                map.compute(hash, (k,v) -> {
                    v.putIfAbsent(sortedWord, new ArrayList<>());

                    v.compute(sortedWord, (key, value) -> {
                        value.add(word);
                        return value;
                });

                return v;
            });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String sortWord(String unsorted) {
        return fromCharListToString(Algos.quickSort(toIntList(unsorted), 0, toIntList(unsorted).size()-1));
    }
    
    public static String substractionWords(String p, String u) {
        String orderedP = sortWord(p);
        String orderedU = sortWord(u);

        int i = 0;
        while (i < orderedU.length()) {
            if (orderedP.contains(Character.toString(orderedU.charAt(i)))) {
                int index = orderedP.indexOf(Character.toString(orderedU.charAt(i)));
                orderedU = orderedU.substring(0, i) + " " + orderedU.substring(i+1);
                orderedP = orderedP.substring(0, index) + " " + orderedP.substring(index+1);
            }
            i++;
        }

        orderedU = orderedU.replaceAll(" ", "");
        orderedP = orderedP.replaceAll(" ", "");

        if (orderedU.isEmpty()) {
            return orderedP;
        } else {
            return "-1";
        }
    }

    public static String twoSum(String p, String u) {
        HashMap<Integer, HashMap<String, List<String>>> map = new HashMap<>();
        String filePath = "Hashtable tests/dico_test.txt";
        fillHashMap(map, filePath);

        String v = substractionWords(p, u);

        if (v.equals("-1")) {
            return v;
        } else {
            int hash = v.hashCode();
            if (map.containsKey(hash)) {
                if (map.get(hash).containsKey(v)) {
                    return "true: " + map.get(hash).get(v).toString();
                }
            }
            return "false";
        }

    }

    /*public static String twoSum(String p) {
        HashMap<Integer, HashMap<String, List<String>>> map = new HashMap<>();
        String filePath = "Hashtable tests/dico_test.txt";
        fillHashMap(map, filePath);

        String result = "";
        Set<Integer> keys = map.keySet();

        for (Integer key : keys) {
            String word = map.get(key).keySet().toArray()[0].toString();
            String v = substractionWords(p, word);
            if ((!v.equals("-1"))) {
                result += map.get(key).get(v).toString();
            }
        }

        if (result.length() > 0) {
            return "true: " + result;
            
        }
        return "false";
    }*/
}