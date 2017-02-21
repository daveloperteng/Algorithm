package linkedList;

/**
 * Created by da.teng on 2/20/17.
 */
public class LinkedList {

    private int data;
    private LinkedList next;

    public LinkedList(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LinkedList getNext() {
        return next;
    }

    public void setNext(LinkedList next) {
        this.next = next;
    }

    public void printAll() {
        LinkedList temp = this;

        while (temp != null) {
            System.out.print(temp.getData());
            temp = temp.getNext();
        }
        System.out.println();
    }
}
