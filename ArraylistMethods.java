import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListDemo {

    public static void main(String[] args) {

        ArrayList<String> list1 = new ArrayList<>();

        list1.add("Java");
        list1.add("Python");
        list1.add("C++");
        list1.add("Java");   

        System.out.println("List1: " + list1);

        // 2. Constructor with initial capacity
        ArrayList<String> list2 = new ArrayList<>(5);
        list2.add("HTML");
        list2.add("CSS");

        System.out.println("List2: " + list2);

        // 3. Constructor using Collection
        ArrayList<String> list3 = new ArrayList<>(list1);
        System.out.println("List3 (copied from list1): " + list3);

        // addAll()
        list2.addAll(list1);
        System.out.println("After addAll(): " + list2);

        // get()
        System.out.println("Element at index 1: " + list1.get(1));

        // set()
        list1.set(1, "JavaScript");
        System.out.println("After set(): " + list1);

        // remove()
        list1.remove("C++");
        System.out.println("After remove(): " + list1);

        // size()
        System.out.println("Size: " + list1.size());

        // isEmpty()
        System.out.println("Is list empty? " + list1.isEmpty());

        // contains()
        System.out.println("Contains Java? " + list1.contains("Java"));

        // indexOf()
        System.out.println("Index of Java: " + list1.indexOf("Java"));

        // lastIndexOf()
        System.out.println("Last index of Java: " + list1.lastIndexOf("Java"));

        // iterator()
        System.out.println("Using Iterator:");
        Iterator<String> itr = list1.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // toArray()
        Object[] arr = list1.toArray();
        System.out.println("Array elements:");
        for (Object o : arr) {
            System.out.println(o);
        }

        // ensureCapacity()
        list1.ensureCapacity(10);
        System.out.println("Capacity ensured");

        // trimToSize()
        list1.trimToSize();
        System.out.println("Trimmed to size");

        // clear()
        list3.clear();
        System.out.println("List3 after clear(): " + list3);
    }
}
