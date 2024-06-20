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
        //5. through clone  " Need to test"
        //6. Collections.copy();

        List<Student> studentList = new ArrayList<>(students);
        Collections.copy(studentList,students);  //size of  studentList must be >= students list size
        System.out.println("Before Shuffle " + studentList);

       // Write a Java program to shuffle elements in an array list.
        Collections.shuffle(studentList);
        System.out.println("After Shuffle " + studentList);

        //Write a Java program to reverse elements in an array list.
        Collections.reverse(studentList);
        System.out.println("Elements of Student List are reversed "+ studentList);

        //Write a Java program to extract a portion of an array list.
        List<Student> studentsSubList = studentList.subList(1,3);
        System.out.println("Sub List of Students "+ studentsSubList);

        //Write a Java program to compare two array lists.
        students = new ArrayList<>(studentList);
        //Write a Java program to compare two array lists.
        System.out.println(studentList.equals(students)); //Equals check if all the elements are in correct order.

        //Write a Java program that swaps two elements in an array list.
        System.out.println("-".repeat(30));
        System.out.println("Before Swapping : "+ studentList);
        Collections.swap(studentList,1,3);
        System.out.println("After Swapping : "+ studentList);

        //Write a Java program to join two array lists.
        System.out.println("Student sub list before adding "+ studentsSubList);
        studentList.addAll(studentsSubList);
        System.out.println(studentList);

        //Write a Java program to clone an array list to another array list.
        ArrayList<Student> clonedList = (ArrayList<Student>) ((ArrayList<Student>) studentList).clone();
        System.out.println("Clonned List : " + clonedList);
        //Write a Java program to empty an array list.
        clonedList.clear();
        System.out.println("Clonned List after Clear " + clonedList);

        //Write a Java program to test whether an array list is empty or not.
        System.out.println("Clonned List to check empty or not : "+clonedList.isEmpty());
        System.out.println("Student List to check empty or not : "+ studentList.isEmpty());

        //Write a Java program for trimming the capacity of an array list.
        System.out.println("Clonned List Size :" + clonedList.size());
        clonedList.trimToSize();
        System.out.println("Clonned List Capacity : "+ clonedList.size());

        //Write a Java program to increase an array list size.
        // There is no method in ArrayList to check the Capacity of ArrayList
        clonedList.ensureCapacity(20);
        System.out.println("Clonned List size after capacity :" + clonedList.size());

        //Write a Java program to replace the second element of an ArrayList with the specified element
        studentList.remove(1);
        studentList.add(1,new Student("S10","10"));
        System.out.println("Student is replaced at second position"+ studentList);

        students.set(1,new Student("S11","11"));
    }
}
