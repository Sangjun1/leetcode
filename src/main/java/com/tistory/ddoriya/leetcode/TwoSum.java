/*
 * @(#) TwoSum.java 2021. 06. 08.
 *
 * Copyright 2021. PlayD Corp. All rights Reserved.
 */
package com.tistory.ddoriya.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 이상준
 */
public class TwoSum {
	/*
	Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
	You may assume that each input would have exactly one solution, and you may not use the same element twice.
	You can return the answer in any order.

	Input: nums = [2,7,11,15], target = 9
	Output: [0,1]
	Output: Because nums[0] + nums[1] == 9, we return [0, 1].

	Input: nums = [3,2,4], target = 6
	Output: [1,2]

	Input: nums = [3,3], target = 6
	Output: [0,1]
	 */

	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int sum = nums[i] + nums[j];
				if (sum == target) {
					return new int[]{i, j};
				}
			}
		}

		return null;
	}

	public int[] twoSum1(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i])) {
				return new int[] { i, map.get(target - nums[i]) };
			}

			map.put(nums[i], i);
		}

		return new int[0];
	}

	public void print() {
//		int[] nums = {2, 7, 11, 15};
//		int target = 9;
		int[] nums = {3,2,4};
		int target = 6;

		int[] result = twoSum(nums, target);
		int[] result2 = twoSum1(nums, target);
		for(int r : result2){
			System.out.println(r);
		}
	}


	public static void main(String[] args) {
		new TwoSum().print();
	}
}
