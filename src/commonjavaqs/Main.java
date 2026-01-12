package commonjavaqs;

import com.sun.source.tree.Tree;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // java goes left to right
        // 100 will be added to 100 to get 200, 200 casted to string to match res
        System.out.println(100 + 100 + " print");

        // string 100 00
        System.out.println("print " + 100 + 100);

        // Shallow Copy
        // ==============
        ExampleClass exampleOne = new ExampleClass();
        exampleOne.x = 100;
        ExampleClass exampleTwo = exampleOne;
        exampleTwo.x = 300;

        // Deep Copy
        // ==============
        // new operator essentially grows heap, gc shrinks it when variable out of scope
        exampleOne = new ExampleClass();
        exampleOne.x = 100;
        exampleTwo = new ExampleClass();
        exampleTwo.x = 300;

        // This will print 100 as a new object was instantiated for example2
        System.out.println(exampleOne.x);

        // Constructor vs Method
        // ==============
        ConstructorVsMethod cvs = new ConstructorVsMethod();
        cvs.method();

        // Abstract Class
        // ==============
//        Enemy enemy = new Enemy();
        Ghost enemyGhost = new Ghost();
        enemyGhost.attack();
        // defend comes from abstract class but abstract cant be instantiated
        enemyGhost.defend();

        // Super Keyword
        // ==============
        // Whenever we're in a child class, we can use super keyword to refer to parent
        enemyGhost.superClassAttack();

        // Generics
        // ==============
        // Should identify type in pointy braces
        // Hash set would've been REEEEAAAAALLLYY useful the other day
        Set<String> stringSet = new HashSet<>();

        List<?> unspecList = new ArrayList<>();
        List<Integer> intList = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        // A synchronized version of map that does not allow null values
        Hashtable<?, ?> table = new Hashtable<>();

        // Linked List vs Array
        // ==============
        List<Integer> linkedList = new LinkedList<>();
        linkedList.add(4);
        linkedList.add(2);
        linkedList.addAll(List.of(4, 7, 9, 3));
        // This removal op is constant, pointers are just updated but O(N) worst cost to traverse to it
        // Node fields withing linkedlist composition are marked transient for GC optimisation
        linkedList.remove(3);

        List<Integer> arrList = new ArrayList<>();
        arrList.add(4);
        arrList.add(7);
        arrList.addAll(List.of(4, 5, 7, 9, 12));
        // Access op is cheap but removal has a worst case linear reshuffle of array and a O(1.5-2N) op for resize
        arrList.remove(4);

        // Summary, LL is fast for qs and removals but expensive with memory gc etc.
        // AL is fast for access, cheap on memory but has a couple expensive ops like removal and reshuffle

        // Trees
        // ==============
        // We got Tree interface, TreeMap and TreeSet classes
        // When putting keys into map, they will be stored in natural order
        // insertion/deletion is worst case O(logN), print all is linear
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(20, "20");
        treeMap.put(30, "30");
        treeMap.put(40, "40");
        treeMap.put(50, "50");

        TreeMap<Integer, String> treeMap2 = new TreeMap<>();
        treeMap2.putAll(treeMap);
        System.out.println(treeMap);
        System.out.println(treeMap2);

        System.out.println(InputParserBasic.parseFile(new File("sample_input.txt")));

        // O(1): hashmap hash set lookup and put ops
        // O(logn): RBTree(TreeMap) and BinaryHeaps insertion and deletion
        // O(N): array traversals
        // O(NlogN): Mergesort and quicksort
        // O(N^2): Nested loop searches like bubble sort, insertion sort, selection sort
        // O(N^2): aaaaaaaaa
    }
}
