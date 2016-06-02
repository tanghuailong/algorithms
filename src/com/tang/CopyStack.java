package com.tang;

/**
 * Created by tanghuailong on 2016/6/3.
 */


import java.util.Iterator;
import java.util.Stack;

/**
 *   实现Iterable接口
 */
public class CopyStack<T> implements Iterable<T> {

    private Node first;
    private int N;
    //节点内部类
    private class Node {
        Node next;
        T item;
    }

    public boolean isEmpty() {
        return first!=null;
    }

    public void push(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        N++;
    }
    public T pop() {
        if(isEmpty()) {
            throw new  RuntimeException("越界");
        }else {
            T item = first.item;
            first = first.next;
            N--;
            return item;
        }
    }

//    public static Stack copyStack(CopyStack stack) {
//        CopyStack copyStack = new CopyStack<>();
//        copyStack.first = stack.first;
//
//
//        Iterator iterator = stack.iterator();
//        while(iterator.hasNext()) {
//            copyStack.first.item = stack.first.item;
//            copyStack.first.next = stack.first.next;
//            iterator.next();
//
//        }
//
//        return null;
//    }
    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {

        private Node current = first;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public T next() {
            T item = current.item;
            current = current.next;
            return item;
        }
    }
}
