package com.shantom.structures;

import java.util.Arrays;

public class PQueue {
    private int[] nums = new int[]{6,3,7,9,5,4,12,8,9,5,3};

    private int size = 11;

    public static void main(String[] args) {
        PQueue pQueue = new PQueue();
        pQueue.heapify();
        pQueue.print();
        for (int i = 0; i < 4; i++) {
            pQueue.poll();
        }
        pQueue.add(10);
        pQueue.add(7);
        pQueue.print();

    }

    public void print(){
        int[] data = Arrays.copyOf(nums, nums.length);
        int nSize = size;
        while(size>0){
            System.out.print(poll()+" ");
        }
        System.out.println("");
        nums = data;
        size = nSize;
    }

    public int poll(){
        int res = nums[0];
        nums[0] = nums[--size];
        sink(0);
        return res;
    }

    public void add(int val){
        nums[size++] = val;
        rise(size-1);
    }

    private void sink(int k){
        while(k<size / 2) {
            int child = k * 2 + 1;
            int right = child + 1;
            if(nums[child]>nums[right]){
                child = right;
            }
            if(nums[k]<nums[child]){
                break;
            }
            swap(k, child);
            k = child;
        }
    }

    private void rise(int k){
        while(k>0){
            int parent = (k-1)/2;
            if(nums[parent]<nums[k]){
                break;
            }
            swap(k, parent);
            k = parent;
        }
    }

    public void heapify(){
        for (int i = size/2 - 1; i >= 0; i--) {
            sink(i);
        }
    }

    private void swap(int x, int y){
        int t = nums[x];
        nums[x] = nums[y];
        nums[y] = t;
    }
}
