package com.collection;

/**
 * List接口：
 *  ArrayList以及LinkedList需要实现它
 */
public interface List<T> {

    /**
     * 查看当前集合中的容量
     * @return 当前容量
     */
    int size();

    /**
     * 查看当前集合是否为空
     * @return 空true 非空false
     */
    boolean isEmpty();

    /**
     * 查看当前集合中是否包含T元素
     * @param t 是否包含元素
     * @return 包含true 不包含false
     */
    boolean contains(T t);

    /**
     * 往集合中添加元素
     * @param t 要添加的元素
     * @return 如果添加成功true 添加失败false
     */
    boolean add(T t);


    /**
     * 往指定的集合中添加元素
     * @param t 要添加的元素
     * @param index 要添加的索引
     * @return 如果添加成功true 添加失败false
     */
    boolean add(T t, int index);


    /**
     *  从集合中删除指定索引的元素
     * @param index 要删除的索引
     * @return 删除的元素 如果不存在null
     */
    T remove(int index);

    /**
     * 清空容器
     */
    void clear();

    /**
     * 从集合中获取指定索引的元素
     * @param index 要获取的索引
     * @return 查看的元素 如果元素不存在返回null
     */
    T get(int index);

    /**
     * 设置当前集合中的元素
     * @param index 要设置的索引
     * @param t 要设置的值
     * @return 覆盖掉的值
     */
    T set(int index, T t);


    /**
     * 获取迭代器
     * @return 返回对应的迭代器
     */
    Iterator<T> iterator();

}
