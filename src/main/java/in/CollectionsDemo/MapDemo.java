package in.CollectionsDemo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapDemo {


    public static void main(String[] args) {

        /*
         * Map is a data structure that holds key-value pairs.
         */
        Map<Integer, String> studentNames = new HashMap<Integer, String>();

        //add
        studentNames.put(1, "Rahul");
        studentNames.put(2, "Raj");
        studentNames.put(3, "Ravi");
        studentNames.put(4, "Rohit");
        studentNames.put(5, "Alex");
        studentNames.put(6, "John");

        //remove
//        studentNames.remove("Rohit");
//
//        //get
//        System.out.println("Name: " + studentNames.get(3));
//
//        //size
//        int size = studentNames.size();
//        System.out.println("Size: " + size);
//
//        // value iteration only prints the values in the map
//        for(String name : studentNames.values()) {
//            System.out.println("Name: " + name);
//        }
//
//        //iterate each entry in the map and prints the key and value
//        for(Map.Entry<Integer, String> entry : studentNames.entrySet()) {
//            System.out.println("Key: " + entry.getKey() + " Value: " + entry.getValue());
//        }

        //iterator Key while loop
        Iterator<Integer> iterator = studentNames.keySet().iterator();
        while(iterator.hasNext()) {
            System.out.println("Key: " + iterator.next());
        }

        //iterator Value while loop
        Iterator<String> iterator2 = studentNames.values().iterator();
        while(iterator2.hasNext()) {
            System.out.println("Value: " + iterator2.next());
        }

        //contains
        if(studentNames.containsKey("Rohit")) {
            System.out.println("Rohit is present on the list");
        }else {
            System.out.println("Rohit is not present on the list");
        }
    }
}