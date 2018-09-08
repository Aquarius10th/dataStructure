package com.collection;

/**
 * 模拟实现栈的操作：FILO:frist in last out
 */
public class Stack<T> {

    //使用自己编写的ArrayList
    private ArrayList<T> objects = new ArrayList<>();

    /**
     * 往栈中添加一个元素
     */
    public T push(T t){
        objects.add(t, 0);
        return t;
    }

    /**
     * 栈中弹出一个元素 弹出栈顶的元素
     */
    public T pop(){
        return objects.remove(0);
    }

    /**
     * 从栈中弹出第一个元素 栈顶元素
     */
    public T peek(){
        return objects.get(0);
    }


    /**
     * 查看当前栈中是否存在元素
     */
    public boolean empty() {
        return objects.isEmpty();
    }

    /**
     * 查询栈中是否存在t元素
     * @return 如果元素存在，返回该元素相对于栈顶的索引（从0开始）；否则返回-1
     */
    public int search(T t) {
        int i = 0;
        Iterator<T> iterator = objects.iterator();
        while (iterator.hasNext()) {
            T obj = iterator.next();
            if (t == obj) {
                return i;
            }
            if (t != null && t.equals(obj)) {
                return i;
            }
            ++i;
        }
        return -1;
    }

    @Override
    public String toString() {
        return objects.toString().replace(objects.getClass().getSimpleName(), getClass().getSimpleName());
    }
}
