package questionthreeandfour.linkedlist;

public class LinkedList {
    private Node first;
    private Node last;
    private int size;

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public Node getNode(int item) {
        Node current = first;
        while (current != null) {
            if (current.value == item) {
                System.out.println(current.value);
                return current;
            }
            current = current.next;
        }
        return new Node(item);
    }

    private boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public void appendToLast(int item) {
        Node node = new Node(item);
        if (isEmpty()) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public void addFirst(int item) {
        Node node = new Node(item);
        if (isEmpty()) {
            first = last = node;
        } else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public int find(int item) {
        int index = 0;
        Node current = first;
        while (current != null) {
            if (current.value == item) return index;
            current = current.next;
            index++;
        }

        return -1;
    }

    public boolean contains(int item) {
        return find(item) != -1;
    }

    public Node getPrevious(Node node) {
        Node current = first;
        while (current != null) {
            if (current.next == node) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void removeLast() {
        Node previous = getPrevious(last);
        last = previous;
        last.next = null;
    }

    public void removeFirst() {
        Node second = first.next;
        first.next = null;
        first = second;
    }

    public void remove(int item) {
        Node current = first;
        while (current != null) {
            if (current.value == item) {
                Node previous = getPrevious(current);
                if (current.next != null) {
                    previous.next = current.next;
                    current = previous;
                } else {
                    last = previous;
                    last.next = null;
                }
                size--;
            }
            current = current.next;
        }
    }

    public Node deleteNode(Node head, int item) {
        if (head == null) {
            return null;
        }
        Node previous = getPrevious(head);
        if (previous == null && head.value == item) {
            removeFirst();
            size--;
            return head;
        }

        while (head != null) {
            if (head.value == item) {
                size--;
                Node result = head;
                if (head.next != null) {
                    head = getPrevious(head);
                    head.next = result.next;
                } else {
                    removeLast();
                }
                return result;
            }
            head = head.next;
        }

        return null;
    }

    public int[] toArray() {
        int[] array = new int[size];
        Node current = first;
        int index = 0;
        while (current != null) {
            array[index++] = current.value;
            current = current.next;
        }
        return array;
    }
}
