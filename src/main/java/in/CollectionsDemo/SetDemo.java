package in.CollectionsDemo;

import java.util.HashSet;
import java.util.Set;

public class SetDemo {


    public static void main(String[] args) {

        Set<String> s1 = new HashSet<String>();

        //add
        s1.add("Fanta");
        s1.add("Sprite");
        s1.add("Coca Cola");
        s1.add("Pepsi");
        s1.add("Red Bull");

        //remove
        s1.remove("Fanta");

        //size
        int size = s1.size();
        System.out.println("Size: " + size);

        //contains
        if(s1.contains("Pepsi")) {
            System.out.println("Pepsi is present in the list");
        }
    }
}