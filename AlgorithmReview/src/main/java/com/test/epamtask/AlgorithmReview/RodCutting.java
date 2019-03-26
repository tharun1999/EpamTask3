package com.test.epamtask.AlgorithmReview;

import java.io.*;

class RodCutting {

	static int numberOfSpecialRods(int n) {
		int specialRods = 0;
		int k = 3;
		while (k <= n) {
			k = (k << 1) + 1;
			specialRods++;
		}
		return specialRods;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		while (test-- > 0) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(numberOfSpecialRods(n));
		}

	}
}
