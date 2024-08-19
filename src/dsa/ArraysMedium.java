package dsa;

import java.util.HashMap;
import java.util.HashSet;

public class ArraysMedium {

	public static void main(String[] args) {

	}

	/**
	 * Two Sum Problem
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */

	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();
		int[] ans = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (res.get(target - nums[i]) != null) {
				ans[0] = res.get(target - nums[i]);
				ans[1] = i;
				break;
			}
			res.put(nums[i], i);
		}
		return ans;
	}

	/***
	 * Sort Colors Red, blue and green.
	 * 
	 * @param nums
	 */
	public void sortColors(int[] nums) {
		int[] temp = new int[3];

		for (int i : nums) {
			if (i == 0) {
				temp[0]++;
			} else if (i == 1) {
				temp[1]++;
			} else {
				temp[2]++;
			}
		}
		int i = 0;
		for (int k = 0; k < 3; k++) {
			for (int j = 0; j < temp[k]; j++) {
				nums[i] = k;
				i++;
			}
		}
		return;
	}

	/**
	 * Maximum subarray in an array Kadane's Algorithm
	 */

	public int maxSubArray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int curr = 0;

		for (int i = 0; i < nums.length; i++) {
			curr += nums[i]; // Current nums counter.
			max = Math.max(max, curr);
			if (curr < 0) {
				curr = 0;
			}
		}
		return max;
	}

	/**
	 * Rearrange the array in nums
	 */

	public int[] rearrangeArray(int[] nums) {
		int[] res = new int[nums.length];
		int i = 0;
		int j = 1;

		for (int k : nums) {
			if (k > 0) {
				res[i] = k;
				i = i + 2;
			} else {
				res[j] = k;
				j = j + 2;
			}
		}
		return res;
	}

	/***
	 * Longest Consecutive Sequence of numbers
	 * 
	 */

	public int longestConsecutive(int[] nums) {
		int count = 0;
		HashMap<Integer, Integer> res = new HashMap<Integer, Integer>();

		for (int i : nums) {
			res.put(i, res.getOrDefault(i, 0) + 1);
		}

		for (int i : nums) {
			if (res.get(i - 1) == null) {
				int k = i;
				int curr = 0;
				while (res.get(k) != null) {
					k++;
					curr++;
				}
				count = Math.max(curr, count);
			}
		}
		return count;

	}

	/***
	 * Set Matrix Zeroes
	 */

	public void setZeroes(int[][] matrix) {
		HashSet<Integer> row = new HashSet<Integer>();
		HashSet<Integer> col = new HashSet<Integer>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					row.add(i);
					col.add(j);
				}
			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (row.contains(i) || col.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
		return;
	}

}
