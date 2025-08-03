package activities;

import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args) {
        //declaring Arraylist of String objects
        ArrayList<String> myList = new ArrayList<String>();
        //Adding objects to Array List at default index
        myList.add("Ravi");
        myList.add("Mani");
        myList.add("Bell");
        //Adding object at specific index
        myList.add(3, "Goody");
        myList.add(1, "BOB");
        
        System.out.println("Print All the Objects:");
        for(String s:myList){
            System.out.println(s);
        }
        
        System.out.println("3rd element in the list is: " + myList.get(2));
        System.out.println("Is Bell is in list: " + myList.contains("Bell"));
        System.out.println("Size of ArrayList: " + myList.size());
        System.out.println("my array: " + myList);
        
        myList.remove("BOB");
        
        System.out.println("New Size of ArrayList: " + myList.size());
        System.out.println("my array: " + myList);
    }
}