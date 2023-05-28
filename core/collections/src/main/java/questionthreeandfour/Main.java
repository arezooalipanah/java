package questionthreeandfour;

import questionthreeandfour.linkedlist.LinkedList;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------simple linked list");
        LinkedList list = new LinkedList();
        System.out.println(list.size());
        list.addFirst(10);
        list.appendToLast(20);
        list.appendToLast(30);
        System.out.println(list.size());
        list.addFirst(100);
        list.addFirst(200);
        list.appendToLast(300);
        System.out.println(list.find(300));
        System.out.println(list.size());
        System.out.println(list.contains(300));
        System.out.println("---------------remove");
        System.out.println(Arrays.toString(list.toArray()));
        list.remove(300);
        list.remove(10);
        list.remove(30);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println("---------------delete");
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.deleteNode(list.getNode(10), 300));
        System.out.println(Arrays.toString(list.toArray()));
    }
}