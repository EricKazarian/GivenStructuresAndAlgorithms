package RedBlackBST;

import RedBlackBST.RedBlackBST;
import java.util.Iterator;

public class Iterable<Key extends Comparable<Key>, Value> {
    
    // Your existing RedBlackBST code here...

    // Nested class to implement Iterable<Key>
    private class KeyIterator implements Iterator<Key> {
        private Queue<Key> queue;

        public KeyIterator() {
            queue = new Queue<Key>();
            inOrderTraversal(root);
        }

        private void inOrderTraversal(Node x) {
            if (x == null) return;
            inOrderTraversal(x.left);
            queue.enqueue(x.key);
            inOrderTraversal(x.right);
        }

        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public Key next() {
            return queue.dequeue();
        }
    }

    // Return an Iterable<Key> for the keys in the symbol table
    public Iterable<Key> keys() {
        return new Iterable<Key>() {
            public Iterator<Key> iterator() {
                return new KeyIterator();
            }
        };
    }

    // Your 
