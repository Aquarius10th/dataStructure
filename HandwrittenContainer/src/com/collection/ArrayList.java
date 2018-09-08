package com.collection;

public class ArrayList<T> implements List<T> {
    // 已保存的元素个数
    private int size;
    // 用于保存元素
    private Object[] objects;

    /**
     * 空构造器，默认情况下初始化的ArrayList集合中
     * 包含长度为16的数组长度
     */
    public ArrayList() {
        this(16);
    }

    /**
     * 初始化指定长度数组的ArrayList集合
     */
    public ArrayList(int initialCapacity) {
        objects = new Object[initialCapacity];
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
    public boolean contains(T t) {
        for (int i = 0; i < size; ++i) {
            Object object = objects[i];
            if (t == object) {
                return true;
            }
            if (t != null && t.equals(object)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(T t) {
        return add(t, size);
    }

    @Override
    public boolean add(T t, int index) {
        checkRange(index, size);

        // 当元素个数达到上限时，进行扩容
        if (size == objects.length) {
            expand();
        }

        for (int i = size; i > index; --i) {
            objects[i] = objects[i - 1];
        }
        objects[index] = t;

        ++size; // 每增加1个元素，size自增1
        return true;
    }

    @Override
    public T remove(int index) {
        checkRange(index, size - 1);
        Object removedElem = objects[index];
        for (int i = index; i < size; ++i) {
            objects[i] = objects[i + 1];
        }
        objects[size - 1] = null;

        --size; // 每移除1个元素，size自减1
        return (T) removedElem;
    }

    @Override
    public T get(int index) {
        checkRange(index, size - 1);
        return (T) objects[index];
    }

    @Override
    public T set(int index, T t) {
        checkRange(index, size - 1);

        Object oldElem = objects[index];
        objects[index] = t;
        return (T) oldElem;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = new Iterator<T>() {
            // 游标，当前遍历的元素的位置
            int cursor = -1;

            @Override
            public boolean hasNext() {
                // 每次调用hasNext()，都令游标向后移动一位
                // 如果移动后的游标没有越界，说明还有下一个元素
                return ++cursor < size;
            }

            @Override
            public T next() {
                // 获取当前游标指向的元素
                return (T) objects[cursor];
            }
        };
        return iterator;
    }

    /**
     * 扩容：创建新数组，将原数组的内容复制到新数组中
     */
    private void expand() {
        int newCapacity = objects.length * 2;
        Object[] objects2 = new Object[newCapacity];
        for (int i = 0, len = objects.length; i < len; ++i) {
            objects2[i] = objects[i];
            objects[i] = null; // 手动解除多余的对象引用
        }
        objects = objects2;
    }

    // 检查给定的下标是否在[0, maxIndex]之内
    private void checkRange(int index, int maxIndex) {
        if (index < 0 || index > maxIndex) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(getClass().getSimpleName() + "[");
        for (int i = 0; i < size; ++i) {
            stringBuilder.append(objects[i]);
            if (i != size - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}
