package HomeWork4;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        // task №1
        String[] colors = {"White", "Black", "Red", "Blue", "Orange", "Black", "Pink",
                "White", "Red", "White", "Red", "Blue", "Black", "Green",
                "Blue", "Dark", "Black", "Dark", "Pink", "Green"};
        System.out.println("Starting array: " + Arrays.asList(colors));
        Set<String> colorsUnique = new HashSet<>(Arrays.asList(colors));
        System.out.println("List of unique words of the starting array: " + colorsUnique);
        Map<String, Integer> colorsRepeat = new HashMap<>();
        for (String color : colors) {
            if (colorsRepeat.containsKey(color)) {
                colorsRepeat.put(color, colorsRepeat.get(color) + 1);
            } else {
                colorsRepeat.put(color, 1);
            }
        }
        System.out.println("Number of repetitions of each word: " + colorsRepeat + "\n");

        // task №2
        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();
        telephoneDirectory.add("Parker", "+995543223351");
        telephoneDirectory.add("Smith", "+995543223351");
        telephoneDirectory.add("Brown", "+995554723351");
        telephoneDirectory.add("Lee", "+995548533351");
        telephoneDirectory.add("Taylor", "+995545433351");
        telephoneDirectory.add("Jones", "+995543252351");
        telephoneDirectory.add("Smith", "+995543297551");
        telephoneDirectory.add("Brown", "+995543325351");
        telephoneDirectory.add("Parker", "+995544343351");
        telephoneDirectory.add("Lee", "+9955438763351");
        telephoneDirectory.add("Jones", "+995549873351");
        telephoneDirectory.add("Brown", "+995549543351");
        System.out.println(telephoneDirectory.get("Lee"));
        System.out.println(telephoneDirectory.get("Jones"));
        System.out.println(telephoneDirectory.get("Parker"));
        System.out.println(telephoneDirectory.get("Taylor"));
        System.out.println(telephoneDirectory.get("Brown"));
    }
}
