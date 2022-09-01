package com.xk.leetcode.jianzhioffer2._41;

import java.util.PriorityQueue;

class MedianFinder {

    PriorityQueue<Integer> minQue;
    PriorityQueue<Integer> maxQue;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        minQue = new PriorityQueue<>((a, b) -> (b - a));
        maxQue = new PriorityQueue<>((a, b) -> (a - b));
    }

    public void addNum(int num) {
        if (minQue.isEmpty() || num < minQue.peek()) {
            minQue.offer(num);
            if (minQue.size() > maxQue.size() + 1) {
                maxQue.offer(minQue.poll());
            }
        } else {
            maxQue.offer(num);
            if (minQue.size() < maxQue.size()) {
                minQue.offer(maxQue.poll());
            }
        }
    }

    public double findMedian() {
        if (minQue.size() > maxQue.size()) {
            return minQue.peek();
        }
        return (minQue.peek() + maxQue.peek()) / 2.0;
    }
}

/*
  Your MedianFinder object will be instantiated and called as such:
  MedianFinder obj = new MedianFinder();
  obj.addNum(num);
  double param_2 = obj.findMedian();
 */