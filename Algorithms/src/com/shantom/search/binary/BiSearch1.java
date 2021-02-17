package com.shantom.search.binary;

public class BiSearch1 {
    public static void main(String[] args) {
        int[] nums = new int[]{3,3,4,5,5,5,6,6,6,8,9,9,12};
        System.out.println(new BiSearch1().rightBound(nums, 7));
    }

    /**
     * target的下标，没有则返回-1
     * @param nums
     * @param target
     * @return
     */
    public int simpleSearch(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left+right)>>>1;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]<target){
                left = mid+1;
            }else if(nums[mid]>target){
                right = mid-1;
            }
        }
        return -1;
    }

    /**
     * nums中有多少个数比target小
     * 或target的左界下标
     * @param nums
     * @param target
     * @return
     */
    public int leftBound(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left+right)>>>1;
            if(nums[mid]<target){
                left = mid+1;
            }else // nums[mid]>=target
            {
                right = mid-1;
            }
        }
        // 此时left可能会越界

        return left;
    }

    /**
     * 右界，没有返回-1
     * @param nums
     * @param target
     * @return
     */
    public int rightBound(int[] nums, int target){
        int left = 0;
        int right = nums.length-1;
        while(left<=right){
            int mid = (left+right)>>>1;
            if(nums[mid]>target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        if(right<0||nums[right]!=target) {
            return -1;
        }

        return right;
    }
}
