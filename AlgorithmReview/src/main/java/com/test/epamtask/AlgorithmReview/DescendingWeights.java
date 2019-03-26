package com.test.epamtask.AlgorithmReview;

import java.util.*;
import static java.lang.System.out;

public class DescendingWeights {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int N = s.nextInt();
		int K = s.nextInt();

		int[] array = new int[N];
		ArrayList<Integer>[] weights = new ArrayList[K];
		for (int i = 0; i < K; i++)
			weights[i] = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			int value = s.nextInt();
			array[i] = value;
			int w = value % K;
			weights[w].add(value);
		}
		s.close();
		for (int i = K - 1; i >= 0; i--) {
			Collections.sort(weights[i]);
			for (int j = 0; j < weights[i].size(); j++) {
				out.print(weights[i].get(j));
				out.print(" ");
			}
		}
	}
}
