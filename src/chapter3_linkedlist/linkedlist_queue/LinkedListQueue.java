package chapter3_linkedlist.linkedlist_queue;

import chapter2_stack_queue.queue.MyQueue;

import java.util.LinkedList;

public class LinkedListQueue<E> implements MyQueue<E> {

    private LinkedList<E> linkedList;

    public LinkedListQueue(){
        linkedList = new LinkedList<>();
    }

    @Override
    public void enqueue(E e) {

    }

    @Override
    public E dequeue() {
        return null;
    }

    @Override
    public E getFront() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
