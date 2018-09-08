package com.collection;

import java.util.NoSuchElementException;

/**
 * 模拟实现的单向链表
 *
 * @param <T>
 */
public class LinkedList<T> implements List<T> {
    private Node<T> head;

    @Override
    public int size() {
        int i = 0;
        Node<T> current = head;
        while (current != null) {
            ++i;
            current = current.next;
        }
        return i;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean contains(T t) {
        Node<T> current = head;
        while (current != null) {
            if (t == current.data) {
                return true;
            }
            if (t != null && t.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public boolean add(T t) {
        Node<T> newNode = new Node<T>(t);
        Node<T> current = head;
        if (head == null) {
            head = newNode;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        return true;
    }

    @Override
    public boolean add(T t, int index) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> newNode = new Node<T>(t);

        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> prevNode = getNodeByIndex(index - 1);
            newNode.next = prevNode.next;
            prevNode.next = newNode;
        }
        return true;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        T removedValue;
        if (index == 0) {
            removedValue = head.data;
            head = head.next;
        } else {
            // 获取被删除节点的前驱节点
            Node<T> prevNode = getNodeByIndex(index - 1);
            // 保留被删除节点的数据
            removedValue = prevNode.next.data;
            // 删除节点
            prevNode.next = prevNode.next.next;
        }
        return removedValue;
    }

    @Override
    public T get(int index) {
        return getNodeByIndex(index).data;
    }

    @Override
    public T set(int index, T t) {
        Node<T> node = getNodeByIndex(index);
        T oldValue = node.data;
        node.data = t;
        return oldValue;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> nextNode = head;
            private T nextValue;

            @Override
            public boolean hasNext() {
                boolean flag = false;
                if (nextNode != null) {
                    flag = true;
                    nextValue = nextNode.data;
                    nextNode = nextNode.next;
                }
                return flag;
            }

            @Override
            public T next() {
                return nextValue;
            }
        };
    }

    /**
     * 获取头元素
     *
     * @return
     */
    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return head.data;
    }


    /**
     * 获取尾元素
     *
     * @return
     */
    public T getLast() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        return getNodeByIndex(size() - 1).data;
    }


    /**
     * 删除列表中的头元素
     *
     * @return 原来的头元素
     */
    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T removedValue = head.data;
        head = head.next;
        return removedValue;
    }

    /**
     * 添加头元素
     */
    public void addFirst(T t) {
        Node<T> newNode = new Node<T>(t);
        newNode.next = head;
        head = newNode;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(getClass().getSimpleName() + "[");
        Node<T> currentNode = head;
        while (currentNode != null) {
            stringBuilder.append(currentNode.data);
            currentNode = currentNode.next;
            if (currentNode != null) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    // ---- 以下为私有工具 ---------------------------

    /**
     * 考虑为什么这里的Node需要static而不是非static？
     */
    private static class Node<T> {
        T data;//节点存储数据
        Node<T> next;// 下一个节点的引用

        Node() {
        }

        Node(T t) {
            this.data = t;
        }
    }

    // 获取指定索引上的节点
    private Node<T> getNodeByIndex(int index) {
        // 如果不在[0, size-1]范围内，则索引越界
        if (index < 0 || index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = head;
        for (int i = 0; i < index; ++i) {
            current = current.next;
        }
        return current;
    }
}
