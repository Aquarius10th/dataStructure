package com.collection;

/**
 * Iterator接口：
 *  用来迭代集合的。这是一个功能可以单拎出来
 * */
public interface Iterator<T> {

    boolean hasNext();

    T next();

}
