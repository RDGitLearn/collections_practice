package arraylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ArrayListRevision {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("s4", "4"));
        students.add(new Student("s7", "7"));
        students.add(new Student("s2", "2"));
        students.add(new Student("s1", "1"));
        students.add(new Student("s9", "9"));

       // Write a Java program to iterate through all elements in an array list.
        for(Student s : students){
            System.out.println(s);
        }
        System.out.println("-".repeat(30));
        System.out.println("Iterating through iterator");
        // Iterate through Iterator
        Iterator iterator = students.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

       //Write a Java program to insert an element into the array list at the first position.
       students.add(0,new Student("s6", "6"));
        System.out.println("Student at first place " + students.get(0));  //Write a Java program to retrieve an element (at a specified index) from a given array list.

       //Write a Java program to update an array element by the given element.
        students.set(3,new Student("s3","3"));
        System.out.println(students);  // Removed s2 with new student s3

       //Write a Java program to remove the third element from an array list.
        System.out.println(students.remove(2));
        System.out.println(students);

        //Write a Java program to search for an element in an array list.
        students.contains(new Student("s3","3"));  //returns the boolean
        System.out.println(students.indexOf(new Student("s3","3")));

        //Write a Java program to sort a given array list.
        Collections.sort(students,new StudentNameComparator());
        System.out.println("-".repeat(30));
        System.out.println("Students list is sorted now");
        System.out.println(students);

        //Write a Java program to copy one array list into another.
          //1. Using for loop
          //2. Using Iterator
          //3. Using Constructor
        //4. through serialization
        //5. through clone

        List<Student> studentList = new ArrayList<>(students);


    }
}
