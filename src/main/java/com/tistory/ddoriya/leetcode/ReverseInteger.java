/*
 * @(#) ReverseInteger.java 2021. 06. 08.
 */
package com.tistory.ddoriya.leetcode;

/**
 * @author 이상준
 */
public class ReverseInteger {
	public int reverse(int x) {
		char[] reverseChars = String.valueOf(x).toCharArray();
		boolean isMinus = reverseChars[0] == '-';
		int limit = isMinus ? 1 : 0;

		StringBuilder stringBuilder = new StringBuilder();
		if (isMinus) {
			stringBuilder.append("-");
		}

		stringBuilder.reverse();

		for (int i = reverseChars.length - 1; i >= limit; i--) {
			stringBuilder.append(reverseChars[i]);
		}

		if (Integer.MAX_VALUE <= Long.valueOf(stringBuilder.toString().replace("-", ""))) {
			return 0;
		}

		return Integer.parseInt(stringBuilder.toString());
	}

	public int reverse1(int x) {
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
			if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
			rev = rev * 10 + pop;
		}
		return rev;
	}

	public int reverse2(int x) {
		String ans = x < 0 ? new StringBuilder(String.valueOf(-x)).append("-").reverse().toString()
				: new StringBuilder(String.valueOf(x)).reverse().toString();
		try {
			return Integer.parseInt(ans);
		} catch (Exception e) {
			return 0;
		}
	}

	public void print() {
		System.out.println(reverse(123));
		System.out.println(reverse(-123));
		System.out.println(reverse(1534236469));
		System.out.println(reverse1(12345));
	}

	public static void main(String[] args) {
		new ReverseInteger().print();
	}

}
