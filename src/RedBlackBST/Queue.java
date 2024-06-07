package RedBlackBST;

import java.util.NoSuchElementException;

public class Queue<Item> {
    private Node<Item> first; // beginning of queue
    private Node<Item> last; // end of queue
    private int size; // number of elements on queue

    // helper linked list class
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }

    /**
     * Initializes an empty queue.
     */
    public Queue() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Is this queue empty?
     * 
     * @return true if this queue is empty; false otherwise
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Returns the number of items in the queue.
     * 
     * @return the number of items in the queue
     */
    public int size() {
        return size;
    }

    /**
     * Adds the item to this queue.
     * 
     * @param item the item to add
     */
    public void enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if (isEmpty())
            first = last;
        else
            oldlast.next = last;
        size++;
    }

    /**
     * Removes and returns the item on this queue that was least recently added.
     * 
     * @return the item on this queue that was least recently added
     * @throws NoSuchElementException if this queue is empty
     */
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");
        Item item = first.item;
        first = first.next;
        size--;
        if (isEmpty())
            last = null; // to avoid loitering
        return item;
    }

    /**
     * Returns the item least recently added to this queue.
     * 
     * @return the item least recently added to this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public Item peek() {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow");
        return first.item;
    }

    /**
     * Returns a string representation of this queue.
     * 
     * @return the sequence of items in FIFO order, separated by spaces
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        java.util.Iterator<Item> iterator = iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }


    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements java.util.Iterator<Item> {
        private Node<Item> current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    /**
     * Returns an iterator that iterates over the items in this queue in FIFO order.
     * 
     * @return an iterator that iterates over the items in this queue in FIFO order
     */
    public java.util.Iterator<Item> iterator() {
        return new ListIterator();
    }

    /**
     * Unit tests the {@code Queue} data type.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        
        // Should print: 1 2 3
        System.out.println(queue);

        System.out.println("Dequeuing: " + queue.dequeue()); // Should print: Dequeuing: 1
        
        // Should print: 2 3
        System.out.println(queue);

        System.out.println("Peeking: " + queue.peek()); // Should print: Peeking: 2
    }
}

