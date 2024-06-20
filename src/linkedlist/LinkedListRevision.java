package linkedlist;

import arraylist.Student;

import java.sql.SQLOutput;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListRevision {
    public static void main(String[] args) {
        LinkedList<Student> students = new LinkedList<>();

        //Write a Java program to append the specified element to the end of a linked list.
        students.add(new Student("s4", "4"));
        students.add(new Student("s7", "7"));
        students.add(new Student("s2", "2"));
        students.add(new Student("s1", "1"));
        students.add(new Student("s9", "9"));

       // Write a Java program to iterate through all elements in a linked list.
        Iterator iterator = students.listIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("-".repeat(40));
        //Write a Java program to iterate through all elements in a linked list starting at the specified position.
        Iterator iterator1 = students.listIterator(1);
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
        System.out.println("-".repeat(40));
        //Write a Java program to iterate a linked list in reverse order.
        Iterator revIterator = students.descendingIterator();
        while (revIterator.hasNext()){
            System.out.println(revIterator.next());
        }

        System.out.println("-".repeat(40));

        //Write a Java program to insert the specified element at the specified position in the linked list.
        students.add(2,new Student("s15", "15"));


        //Write a Java program to insert elements into the linked list at the first and last positions.
        System.out.println("Add Element at first and Last position....");
        students.addFirst(new Student("s11", "11"));
        students.push(new Student("s12", "12"));
        students.offerFirst(new Student("s16", "16"));
        students.addLast(new Student("s14", "14"));
        students.offerLast(new Student("s17", "17"));
        System.out.println(students);

       // Write a Java program to insert some elements at the specified position into a linked list.
        students.addAll(1,students);

        //Write a Java program to get the first and last elements of a linked list.
        System.out.println("Get First Element "+ students.getFirst());
        System.out.println("Get First Element "+ students.peekFirst());
        System.out.println("Get Last Element "+ students.getLast());
        System.out.println("Get Last Element "+ students.peekLast());

        //Write a Java program to remove a specified element from a linked list.
        System.out.println("Student removed from the list " + students.remove(2));
        System.out.println("-".repeat(50));
        //Write a Java program to remove the first and last elements from a linked list.
        System.out.println(students);
        System.out.println("Removed First Element from Student List "+ students.removeFirst() );
        System.out.println("Removed First Element from Student List "+ students.pollFirst());
        System.out.println("Removed Last Element from Student List "+ students.removeLast());
        System.out.println("Removed Lastt Element from Student List "+ students.pollLast());

        System.out.println("-".repeat(50));
        System.out.println("Check if an element is present in the linked list " + students.contains(new Student("s17", "17")));


    }
}
