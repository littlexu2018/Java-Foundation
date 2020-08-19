package com.xuhh.foundation.twoSum;

import java.util.HashMap;
import java.util.Map;

public class App {

    public static void main(String[] args) {

    }

    /**
     * 给定一个整数数组 num和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     *
     *
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * 执行用时：
     * 101 ms
     * , 在所有 Java 提交中击败了
     * 8.16%
     * 的用户
     * 内存消耗：
     * 40.1 MB
     * , 在所有 Java 提交中击败了
     * 24.07%
     * 的用户
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        int[] indexs = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length-1; j >i ; j--) {
                if(nums[i]+nums[j] == target){
                    indexs[0] =i;
                    indexs[1]=j;
                }
            }
        }

        return indexs;
    }

    public int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
