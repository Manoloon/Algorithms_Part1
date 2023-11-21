/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private static final int INITIALCAPACITY = 1;
    private Item[] items;
    private int size = 0;
    private int head = 0;
    private int tail = 0;


    public Deque() {
        items = (Item[]) new Object[INITIALCAPACITY];
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (size == items.length) resize(2 * size);
        head = (head - 1 + items.length) % items.length;
        items[head] = item;
        size++;
    }

    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException();
        }
        if (size == items.length) resize(2 * size);
        tail = (tail + 1) % items.length;
        items[tail] = item;
        size++;
    }

    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = items[head];
        items[head] = null;
        if (size == 1) {
            head = 0;
            tail = 0;
        }
        else head = (head + 1) % items.length;
        size--;
        return item;
    }

    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = items[tail];
        items[tail] = null;
        if (size == 1) {
            head = 0;
            tail = 0;
        }
        else tail = (tail - 1 + items.length) % items.length;
        size--;
        return item;
    }

    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    private void resize(int newCapacity) {
        if (newCapacity < INITIALCAPACITY) newCapacity = INITIALCAPACITY;
        Item[] copy = (Item[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            copy[i] = items[(head + i) % items.length];
        }
        items = copy;
        head = 0;
        tail = size == 0 ? 0 : size - 1;
    }

    private class QueueIterator implements Iterator<Item> {
        private int current = head;

        public void remove() {
            throw new UnsupportedOperationException("This operation is not supported");
        }

        public boolean hasNext() {
            return current != (tail + 1) % items.length;
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = items[current];
            current = (current + 1) % items.length;
            return item;
        }
    }

    public static void main(String[] args) {
        Deque<String> deque = new Deque<>();
        deque.addFirst("to chew bubblegum");
        deque.addLast("and");
        deque.addFirst("I'm here");
        deque.addLast("kick ass");
        for (String s : deque) {
            System.out.print(s + " ");
        }
        deque.removeFirst();
        deque.removeLast();
        deque.addLast("I'm all out of bubblegum");
        deque.removeFirst();
        System.out.println();
        for (String s : deque) {
            System.out.print(s + " ");
        }
    }
}
