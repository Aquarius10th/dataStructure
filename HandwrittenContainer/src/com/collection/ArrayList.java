package com.collection;



public class ArrayList<T> implements List<T>{

    private int size;//默认容量大小

    private Object[] objs = new Object[size];
    /**
     * 空构造器，默认情况下初始化的ArrayList集合中
     * 包含长度为16的数组长度
     */
    public ArrayList(){

    }

    /**
     * 初始化指定长度数组的ArrayList集合
     */
    public ArrayList(int initialCapacity){

    }


    @Override
    public int size() {
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(T t) {
        return false;
    }

    @Override
    public boolean add(T t) {
        return false;
    }

    @Override
    public boolean add(T t, int index) {
        return false;
    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index, T t) {
        return null;
    }

    @Override
    public Iterator iterator() {
        return null;
    }



}
