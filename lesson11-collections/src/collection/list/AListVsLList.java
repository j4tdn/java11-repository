package collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AListVsLList {
	// Manipulation: Add, Update(set), Remove, Get(select)
    private static int COUNT = 50000;

    public static void main(String[] args) {
        List<String> alist = new ArrayList<>();
        List<String> llist = new LinkedList<>();

        // Add (to the end)
        long start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            alist.add("element # " + i);
        }
        System.out.println("Add " + COUNT + " elements: ArrayList took "
                + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            llist.add("element # " + i);
        }
        System.out.println("Add " + COUNT + " elements: LikedList took "
                + (System.currentTimeMillis() - start) + "ms");

        // Add at index: 0 999 49999
        for (int i = 0; i < COUNT; i++) {
            alist.add(49999, "element # " + i);
        }
        System.out.println("Add at index 49999: " + COUNT
                + " elements: ArrayList took "
                + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            llist.add(49999, "element # " + i);
        }
        System.out.println("Add at index 49999: " + COUNT
                + " elements: LinkedList took "
                + (System.currentTimeMillis() - start) + "ms");

        // Get
        start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            alist.get(i);
        }
        System.out.println("Get element: ArrayList took "
                + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            llist.get(i);
        }
        System.out.println("Get element: LinkedList took "
                + (System.currentTimeMillis() - start) + "ms");

        // Update
        start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            alist.set(i, "modified element # " + i);
        }
        System.out.println("Update element: ArrayList took "
                + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            llist.set(i, "modified element # " + i);
        }
        System.out.println("Update element: LinkedList took "
                + (System.currentTimeMillis() - start) + "ms");

        // Remove 0 49999
        start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            alist.remove(49999);
        }
        System.out.println("Remove element: ArrayList took "
                + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            llist.remove(49999);
        }
        System.out.println("Remove element: LinkedList took "
                + (System.currentTimeMillis() - start) + "ms");
    }

}