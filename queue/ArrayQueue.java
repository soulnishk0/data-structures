package com.luxoft.queue;

public class ArrayQueue implements Queue{
    private int size;
    private int peq = 0;    //Point End Queue
    private int pbq = 0;    //Point Begin Queue
    private Object[] array;

    public ArrayQueue() {
        array = new Object[20];
    }
    public ArrayQueue(int initialCapacity) {
        if(size < 0) {
            throw new IllegalArgumentException("Size of queue must be >= 0");
        }
        array = new Object[size];
    }

    @Override
    public void enqueue(Object value) {
        if(array.length == pbq) {
            expandSize();
        }
        array[pbq++] = value;
    }

    @Override
    public Object dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        } else if (pbq == (size-1)){
            pbq = 0;
        }
        return array[pbq++];
    }

    @Override
    public Object peek() {
        return array[pbq];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(pbq == peq){
            return true;
        }else return false;
    }

    @Override
    public boolean contains(Object value) {
        for (int i = pbq; i < peq; ++i) {
            if(array[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        pbq = peq = 0;
    }

    private void expandSize() {
        Object[] newArrayQueue = new Object[(array.length == 0 ? 1 : array.length) * 2];
        for (int i = pbq, counter = 0; i < peq; ++i, ++counter) {
            newArrayQueue[counter] = array[i];
        }
        peq = size();
        pbq = 0;
        array = newArrayQueue;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = pbq; i < peq; ++i) {
            result.append(array[i]);
            if(i + 1 < peq) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }
}
