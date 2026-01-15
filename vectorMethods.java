package javaTraining;

import java.util.Vector;
import java.util.Enumeration;
import java.util.ArrayList;


public class vectorMethods {
	    public static void main(String[] args) {

	        // 1. Default constructor
	        Vector<String> v1 = new Vector<>();
	        v1.add("Java");
	        v1.add("Python");
	        v1.add("C++");

	        System.out.println("Vector v1: " + v1);

	        // 2. Constructor with initial capacity
	        Vector<String> v2 = new Vector<>(5);
	        v2.add("HTML");
	        v2.add("CSS");

	        System.out.println("Vector v2: " + v2);

	        // 3. Constructor with capacity increment
	        Vector<String> v3 = new Vector<>(3, 2);
	        v3.add("One");
	        v3.add("Two");
	        v3.add("Three");

	        System.out.println("Vector v3: " + v3);

	        // 4. Constructor using Collection
	        ArrayList<String> list = new ArrayList<>();
	        list.add("Spring");
	        list.add("Hibernate");

	        Vector<String> v4 = new Vector<>(list);
	        System.out.println("Vector v4 (from collection): " + v4);

	        // addElement()
	        v1.addElement("Java");
	        System.out.println("After addElement(): " + v1);

	        // addAll()
	        v2.addAll(v1);
	        System.out.println("After addAll(): " + v2);

	        // get()
	        System.out.println("Element at index 1: " + v1.get(1));

	        // set()
	        v1.set(1, "JavaScript");
	        System.out.println("After set(): " + v1);

	        // remove()
	        v1.remove("C++");
	        System.out.println("After remove(): " + v1);

	        // removeElement()
	        v1.removeElement("Java");
	        System.out.println("After removeElement(): " + v1);

	        // size()
	        System.out.println("Size: " + v1.size());

	        // capacity()
	        System.out.println("Capacity: " + v1.capacity());

	        // isEmpty()
	        System.out.println("Is empty? " + v1.isEmpty());

	        // contains()
	        System.out.println("Contains Java? " + v1.contains("Java"));

	        // firstElement()
	        System.out.println("First Element: " + v1.firstElement());

	        // lastElement()
	        System.out.println("Last Element: " + v1.lastElement());

	        // indexOf()
	        System.out.println("Index of Java: " + v1.indexOf("Java"));

	        // Enumeration using elements()
	        System.out.println("Using Enumeration:");
	        Enumeration<String> e = v1.elements();
	        while (e.hasMoreElements()) {
	            System.out.println(e.nextElement());
	        }

	        // clear()
	        v4.clear();
	        System.out.println("Vector v4 after clear(): " + v4);
	    }
	}

