package linkedList;

import java.util.HashSet;

/**
 * Created by da.teng on 2/20/17.
 */
public class ctci6Chapter2 {

    /**
     * Remove Dups: Write code to remove duplicates from an unsorted linked list.*/
    public static LinkedList removeDups(LinkedList linkedList) {
        HashSet<Integer> buff = new HashSet<>();
        LinkedList pre = linkedList;
        LinkedList next = linkedList.getNext();
        buff.add(pre.getData());

        while (next != null) {
            if (!buff.contains(next.getData())) {
                buff.add(next.getData());
                pre = pre.getNext();
            } else {
                pre.setNext(next.getNext());
            }
            next = next.getNext();

        }
        return linkedList;
    }

    public static void removeDupsNoBuff(LinkedList linkedList) {
        LinkedList pre = linkedList;
        LinkedList current = linkedList.getNext();

        while (current != null) {
            if (isDups(current)) {
                pre.setNext(current.getNext());
            } else {
                pre = pre.getNext();
            }
            current = current.getNext();
        }

        // making sure first and second are not duplicated;
        if (linkedList != null && linkedList.getNext() != null) {
            if (linkedList.getData() == linkedList.getNext().getData()) {
                linkedList.setNext(linkedList.getNext().getNext());
            }
        }
    }

    private static boolean isDups(LinkedList current) {
        LinkedList runner = current.getNext();
        while (runner != null) {
            if (current.getData() == runner.getData()) {
                return true;
            }
            runner = runner.getNext();
        }
        return false;
    }

    /**
     * Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.*/
    public static int kthToLastReturnIndex(LinkedList linkedList, int k) {
        if (linkedList == null) {
            return 0;
        }

        int index = kthToLastReturnIndex(linkedList.getNext(), k) + 1;
        if (index == k) {
            System.out.print(linkedList.getData());
        }
        return index;
    }

    public static LinkedList kthToLast(LinkedList linkedList, int k) {
        LinkedList current = linkedList;
        LinkedList runner = linkedList;
        for (int count = 0; count < k; count ++) {
            runner = runner.getNext();
        }
        while (runner != null) {
            runner = runner.getNext();
            current = current.getNext();
        }
        return current;
    }

    public static void main(String[] args) {
        LinkedList node1 = new LinkedList(1);
        LinkedList node2 = new LinkedList(2);
        LinkedList node3 = new LinkedList(3);
        node1.setNext(node2);
        node2.setNext(node3);
        node1.printAll();
        removeDups(node1).printAll();
        removeDupsNoBuff(node1);
        node1.printAll();

        kthToLastReturnIndex(node1, 1);
        kthToLast(node1, 3).printAll();
    }
}
