package com.collection;

/**
 * 模拟实现的单向链表
 * @param <T>
 */
public class LinkedList<T> implements List<T>  {
    private Node<T> head;
    @Override
    public int size() {
        return 0;

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


    /**
     * 获取头元素
     * @return
     */
    public T getFrist(){
        return null;
    }


    /**
     * 获取尾元素
     * @return
     */
    public T getLast(){
        return null;
    }


    /**
     * 删除列表中的头元素
     * @return 原来的头元素
     */
    public T removeFrist(){
        return null;
    }

    /**
     * 添加头元素
     */
    public void addFrist(T t){
    }




    /**
     * 考虑为什么这里的Node需要static而不是非static？
     * @param <T>
     */
    private static class Node<T>{
        Object data;//节点存储数据
        Node next;// 下一个节点的引用


    }


}
