package com.company;

import java.util.*;

public class MyArrayList<T> implements List<T>, Iterator<T>, Iterable<T> {

    T[] values;
    private int size = 0;

    MyArrayList() {
        this.values = (T[]) new Object[16];
    }


    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOfRange(values, 0, size));
    }

    @Override
    public boolean add(T t) {
        add(size, t);
        return true;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        T[] temp;
        if (values.length == size) {
            temp = Arrays.copyOf(values,values.length);
            values = (T[]) new Object[(int) (values.length * 1.5)];
            System.arraycopy(temp, 0, values, 0, temp.length);
        }
        if (index == size) {
            values[index] = element;
        } else {
            temp = Arrays.copyOfRange(values, index, size);
            values[index] = element;
            System.arraycopy(temp, 0, values, index + 1, temp.length);
        }
        size++;

    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index > size + 1) {
            throw new IndexOutOfBoundsException();
        }
        T temp = values[index];
        values[index] = element;
        return temp;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size - 1) {
            values[index] = null;
        } else {
            T[] temp = Arrays.copyOfRange(values, index + 1, size);
            values[index] = null;
            System.arraycopy(temp, 0, values, index, temp.length);
        }
        size--;
        return null;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (values[i].equals(o)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        return values[index];
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }


    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException();
    }

    @Override
    public T next() {
        throw new UnsupportedOperationException();
    }
}