package com.company;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<T> implements List<T> {

    private Node first;
    private Node last;
    private int size;

    public MyLinkedList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    @Override
    public void add(int index, T element) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(element);
        } else if (index == size) {
            add(element);
        } else {
            Node node = getNode(index);
            Node newNode = new Node();
            newNode.prev = node.prev;
            newNode.next = node;
            newNode.value = element;
            node.prev.next = newNode;
            node.prev = newNode;
            size++;
        }
    }

    @Override
    public boolean add(T t) {
        Node newNode = new Node();
        newNode.value = t;
        newNode.next = null;
        newNode.prev = last;
        if (last != null) {
            last.next = newNode;
        }
        last = newNode;
        if (first == null) {
            first = newNode;
        }
        size++;
        return true;
    }

    @Override
    public T remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T temp;
        if (size == 1) {
            temp = first.value;
            clear();
        } else {
            if (index == 0) {
                temp = first.value;
                first = first.next;
                first.prev = null;
            } else if (index == size - 1) {
                temp = last.value;
                last = last.prev;
                last.next = null;
            } else {
                Node node = getNode(index);
                temp = node.value;
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            size--;
        }
        return temp;
    }

    @Override
    public boolean remove(Object o) {
        Node nextNode = first;
        for (int i = 0; i < size; i++) {
            if (nextNode.value.equals(o)) {
                remove(i);
                return true;
            }
            nextNode = nextNode.next;
        }
        return false;
    }

    @Override
    public T get(int index) {
        return getNode(index).value;
    }

    @Override
    public T set(int index, T element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T temp;
        if (index == 0) {
            temp = first.value;
            first.value = element;
        } else if (index == size - 1) {
            temp = last.value;
            last.value = element;
        } else {
            Node node = getNode(index);
            temp = node.value;
            node.value = element;
        }
        return temp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    private Node getNode(int index) {
        Node nextNode = first;
        for (int i = 0; i < index; i++) {
            nextNode = nextNode.next;
        }
        return nextNode;
    }

    private void addFirst(T element) {
        Node newNode = new Node();
        newNode.value = element;
        newNode.next = first;
        newNode.prev = null;
        if (first != null) {
            first.prev = newNode;
        }
        first = newNode;
        if (last == null) {
            last = newNode;
        }
        size++;
    }

    private class Node {
        Node prev;
        T value;
        Node next;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node nextNode = first;
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                stringBuilder.append(nextNode.value);
            } else {
                stringBuilder.append(nextNode.value).append(", ");
            }
            nextNode = nextNode.next;
        }
        return '[' + stringBuilder.toString() + ']';
    }


    @Override
    public Iterator<T> iterator() {
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

}
