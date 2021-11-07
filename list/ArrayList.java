package com.luxoft.list;

public class ArrayList implements List{
    private Object[] array;
    private int size;

    public ArrayList() {
        this.array = new Object[10];
    }

    @Override
    public void add(Object value) {
        if(size == array.length){
            resize();
        }
        array[size++] = value;
    }

    @Override
    public void add(Object value, int index) {
        if(index > size){
            throw new IndexOutOfBoundsException("Index is larger than size of the Array List");
        }
        if(size == array.length){
            resize();
        }
        for (int i = size; i > index ; i--) {
            array[i] = array[i - 1];
        }

        this.set(value, index);
        size++;
    }
    public void resize(){
        Object[] resizedArray = new Object[(int)(array.length * 1.5)];
        for (int i = 0; i < size; i++) {
            resizedArray[i] = array[i];
        }
        array = resizedArray;
    }

    @Override
    public Object remove(int index) {
        if(index > size - 1){
            throw new IndexOutOfBoundsException("Error! Index should be <= size of the List");
        }
        Object obj = get(index);
        for (int i = index; i < size - 1; i++) {
            this.set(get(i+1), i);
        }

        size--;
        return obj;
    }

    @Override
    public Object get(int index) {
        if(index > size  - 1){
            throw new IndexOutOfBoundsException("Index is larger than size of the Array List");
        }
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        if(index > size){
            throw new IndexOutOfBoundsException("Index is larger than size of the Array List");
        }
        Object o = array[index];
        array[index] = value;
        return o;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < size; i++) {
            if(array[i].equals(value)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        for (int i = 0; i < size; i++) {
            if(array[i].equals(value)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object value) {
        for (int i = size - 1; i >=0 ; i--) {
            if(array[i].equals(value)){
                return i;
            }
        }
        return -1;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size - 1; i++) {

            stringBuilder.append(array[i] + ", ");
        }
        stringBuilder.append(array[size - 1] + "]");
        return stringBuilder.toString();
    }
}
