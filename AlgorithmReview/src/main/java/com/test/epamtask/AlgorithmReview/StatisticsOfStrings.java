package com.test.epamtask.AlgorithmReview;

import java.util.*;

public class StatisticsOfStrings {
	static int[] dsu;
	
	static int power(int a, int b, int mod) {
		if (b == 0) {
			return 1;
		}
		int p = power(a, b / 2, mod);
		p = (int) ((long) p * p % mod);
		if (b % 2 == 1) {
			p = (int) ((long) p * a % mod);
		}
		return p;
	}
	
	static int find(int i) {
		if (dsu[i] < 0) {
			return i;
		} else {
			return dsu[i] = find(dsu[i]);
		}
	}
	
	static boolean join(int i, int j) {
		i = find(i);
		j = find(j);
		if (i == j)
			return false;
		if (dsu[i] > dsu[j])
			dsu[i] = j;
		else {
			if (dsu[i] == dsu[j])
				dsu[i]--;
			dsu[j] = i;
		}
		return true;
	}
	
	static int solve(int k, int v, int n, int a, int mod) {
		Arrays.fill(dsu, -1);
		int bcnt = 0, cnt = n;
		for (int i = 1; i < n; i++)
			if ((v & 1 << i) > 0) {
				for (int j = i; j < i + k; j++)
					if (join(j, j - i))
						cnt--;
				bcnt++;
			}
		int sum = power(a, cnt, mod);
		return bcnt % 2 == 1 ? sum : (mod - sum) % mod;
	}
	
	static int findSolution(int n, int a, int mod) {
		dsu = new int[n];
		int sum = 0;
		for (int k = 1; k < n; k++) {
			for (int v = 2; v < 1 << n - k + 1; v += 2) {
				sum = (sum + solve(k, v, n, a, mod)) % mod;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int a = s.nextInt();
		int mod = s.nextInt();
		System.out.println(findSolution(n, a, mod));
	}
}
