package litooong.com.github.ch3;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * ArrayList 的实现
 * @param <T>
 */
public class MyArrayList<T> implements Iterable<T> {

    private static final int DEFAULT_CAPACITY = 10;

    private int theSize;
    private T[] theItems;

    public MyArrayList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int getTheSize() {
        return theSize;
    }

    public boolean isEmpty() {
        return getTheSize() == 0;
    }

    public void trimToSize() {
        ensureCapacity(getTheSize());
    }

    public T get(int idx) {
        if (idx < 0 || idx >= getTheSize()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return theItems[idx];
    }

    public T set(int idx, T newVal) {
        if (idx < 0 || idx >= getTheSize()) {
            throw new ArrayIndexOutOfBoundsException();
        }
        T old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize) {
            return;
        }
        T[] old = theItems;
        theItems = (T[]) new Object[newCapacity];
        for (int i = 0; i < getTheSize(); i++) {
            theItems[i] = old[i];
        }
    }

    public boolean add(T x) {
        add(getTheSize(), x);
        return true;
    }

    public void add(int idx, T x) {
        if (theItems.length == getTheSize()) {
            ensureCapacity(getTheSize() * 2 + 1);
        }
        for (int i = getTheSize(); i > idx; i--) {
            theItems[i] = theItems[i - 1];
        }
        theItems[idx] = x;

        theSize++;
    }

    public T remove(int idx) {
        T removedItem = theItems[idx];
        for (int i = idx; i < getTheSize() - 1; i++) {
            theItems[i] = theItems[i + 1];
        }

        theSize--;
        return removedItem;
    }


    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }


    private class ArrayListIterator implements Iterator<T> {

        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < getTheSize();
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }
}
