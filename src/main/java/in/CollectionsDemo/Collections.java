package in.CollectionsDemo;

import java.util.ArrayList;
import java.util.List;

public class Collections {

    public static void main(String[] args) {

        List<String> guestList = new ArrayList<>();

        //add
        guestList.add("Rahul");
        guestList.add("Raj");
        guestList.add("Ravi");
        guestList.add("Rohit");
        guestList.add("Rohit");

        //remove
        guestList.remove("Rohit");

        //size
        int size = guestList.size();
        System.out.println("Size: " + size);

        //get
        String name = guestList.get(1);
        System.out.println("Name: " + name);

        //contains
        if(guestList.contains("Rohit")) {
            System.out.println("Rohit is present on the list");
        }else {
            System.out.println("Rohit is not present ");
        }

        //list of names
        for(String name1: guestList) {
            System.out.println("Name: " + name1);
        }
    }
}