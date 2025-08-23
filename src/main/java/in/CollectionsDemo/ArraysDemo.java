package in.CollectionsDemo;

import java.util.Arrays;

public class ArraysDemo {


        // Study time llll
    public static void main(String[] args) {

        String[] names = {"Rahul", "Raj", "Ravi", "Rohit", "Alex"};
        Arrays.sort(names);
        for(String s : names) {
            System.out.println(s);
        }
    }
}