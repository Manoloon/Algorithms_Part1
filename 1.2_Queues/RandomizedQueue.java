/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    // construct an empty randomized queue
    private Item[] items;
    private int size = 0;

    public RandomizedQueue() {
        items = (Item[]) new Object[1];
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return size;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("cannot add, item is null");
        }
        if (size == items.length) {
            resize(2 * items.length);
        }
        items[size++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty.");
        }
        int randomIndex = StdRandom.uniformInt(size);
        Item item = items[randomIndex];
        if (randomIndex < size - 1) {
            items[randomIndex] = items[size - 1];
        }
        items[--size] = null;
        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        int randomIndex = StdRandom.uniformInt(size);
        return items[randomIndex];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomQIterator();
    }

    private void resize(int cap) {
        Item[] copy = (Item[]) new Object[cap];
        for (int i = 0; i < size; i++) {
            copy[i] = items[i];
        }
        items = copy;
    }

    private class RandomQIterator implements Iterator<Item> {
        private int current = 0;
        private final int[] indexes = new int[size];

        public RandomQIterator() {
            for (int i = 0; i < size; i++) {
                indexes[i] = i;
            }
            StdRandom.shuffle(indexes);
        }

        public void remove() {
            throw new UnsupportedOperationException("This operation is not supported");
        }

        public boolean hasNext() {
            return current < size;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items[indexes[current++]];
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        System.out.println("Adding 1-5");
        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");
        queue.enqueue("5");
        for (String s : queue) {
            System.out.print(s + " ");
        }
        System.out.printf("\nRandom item: %s\n", queue.sample());
        System.out.println("Removing 2 items");
        queue.dequeue();
        queue.dequeue();
        for (String s : queue) {
            System.out.print(s + " ");
        }
        System.out.printf("\nSize: %d", queue.size());
    }
}
