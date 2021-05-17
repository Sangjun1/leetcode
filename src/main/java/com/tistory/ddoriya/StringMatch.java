/*
 * @(#) StringMatch.java 2021. 05. 17.
 *
 */
package com.tistory.ddoriya;

/**
 * @author 이상준
 */
public class StringMatch {

	/*
	Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

	'?' Matches any single character.
	'*' Matches any sequence of characters (including the empty sequence).
	The matching should cover the entire input string (not partial).

	Input: s = "aa", p = "a"
	Output: false
	Explanation: "a" does not match the entire string "aa".

	Input: s = "aa", p = "*"
	Output: true
	Explanation: '*' matches any sequence.

	Input: s = "cb", p = "?a"
	Output: false
	Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.

	Input: s = "acdcb", p = "a*c?b"
	Output: false
	 */

	public static void main(String[] args) {
		String s = "aa", p = "a";
		System.out.println(isMatch(s, p));

		s = "aa";
		p = "*";
		System.out.println(isMatch(s, p));

		s = "aa";
		p = "*";
		System.out.println(isMatch(s, p));

		s = "cb";
		p = "?a";
		System.out.println(isMatch(s, p));

		s = "acdcb";
		p = "a*c?b";
		System.out.println(isMatch(s, p));

		s = "acdcb";
		p = "a*b";
		System.out.println(isMatch(s, p));
	}

	public static boolean isMatch(String s, String p) {

		boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];

		for (int i = dp.length - 1; i >= 0; i--) {
			for (int j = dp[0].length - 1; j >= 0; j--) {
				if (i == dp.length - 1 && j == dp[0].length - 1) {
					dp[i][j] = true;
				} else if (i == dp.length - 1) {
					dp[i][j] = false;
				} else if (j == dp[0].length - 1) {
					if (p.charAt(i) == '*') {
						dp[i][j] = dp[i + 1][j];
					} else {
						dp[i][j] = false;
					}
				} else {
					if (p.charAt(i) == s.charAt(j)) {
						dp[i][j] = dp[i + 1][j + 1];
					} else if (p.charAt(i) == '?') {
						dp[i][j] = dp[i + 1][j + 1];
					} else if (p.charAt(i) == '*') {
						dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
					} else {
						dp[i][j] = false;
					}

				}
			}
		}

		return dp[0][0];
	}
}


