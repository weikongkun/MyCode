package com.JianZhiOffer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class E64_MidNumInStream {
	 // 大顶堆，存储左半边元�?
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    // 小顶堆，存储右半边元素，并且右半边元素都大于左半�?
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    // 当前数据流读入的元素个数
    private int N = 0;

    public void Insert(Integer val) {
        // 插入要保证两个堆存于平衡状�??
        if (N % 2 == 0) {
            // N 为偶数的情况下插入到右半边�??
            // 因为右半边元素都要大于左半边，但是新插入的元素不�?定比左半边元素来的大�?
            // 因此�?要先将元素插入左半边，然后利用左半边为大顶堆的特点，取出堆顶元素即为�?大元素，此时插入右半�?
            left.add(val);
            right.add(left.poll());
        } else {
            right.add(val);
            left.add(right.poll());
        }
        N++;
    }

    public Double GetMedian() {
        if (N % 2 == 0)
            return (left.peek() + right.peek()) / 2.0;
        else
            return (double) right.peek();
    }
}
class Solution2 {
	ArrayList<Integer> heap;
	public void Insert(Integer val) {
        if (heap == null) heap = new ArrayList<>();
    }

}
