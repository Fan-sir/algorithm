package com.xk.leetcode.question.mid._622;

class MyCircularQueue {

    int[] arr;
    int length;
    int front;
    int rear;

    public MyCircularQueue(int k) {
        length = k + 1;
        arr = new int[length];
        front = rear = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        arr[rear] = value;
        rear = (rear + 1) % length;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % length;
        return true;
    }

    public int Front() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        return arr[(rear - 1 + length) % length];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % length == front;
    }
}

/*
  Your MyCircularQueue object will be instantiated and called as such:
  MyCircularQueue obj = new MyCircularQueue(k);
  boolean param_1 = obj.enQueue(value);
  boolean param_2 = obj.deQueue();
  int param_3 = obj.Front();
  int param_4 = obj.Rear();
  boolean param_5 = obj.isEmpty();
  boolean param_6 = obj.isFull();
 */
