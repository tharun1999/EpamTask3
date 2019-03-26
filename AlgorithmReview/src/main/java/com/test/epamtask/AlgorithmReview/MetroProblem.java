package com.test.epamtask.AlgorithmReview;

import java.util.*;
import java.io.*;

public class MetroProblem {
	public static void main(String[] args) {
		Metro metro = new Metro();
		metro.solve();
	}

	static class Metro {
		ArrayList<Edge>[] adj;
		long[] min_time;

		public void solve() {
			Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			int m = s.nextInt();
			adj = new ArrayList[n];
			min_time = new long[n];
			for (int i = 0; i < n; ++i)
				adj[i] = new ArrayList<>();
			for (int i = 0; i < m; ++i) {
				int k = s.nextInt();
				int t = s.nextInt();
				int[] ar1 = new int[k];
				for (int j = 0; j < k; ++j) {
					ar1[j] = s.nextInt() - 1;
				}
				long max = t;
				for (int j = 1; j < k; ++j) {
					long cur = s.nextLong();
					adj[ar1[j - 1]].add(new Edge(max, ar1[j], cur));
					max += cur;
				}
			}
			int start = s.nextInt() - 1, end = s.nextInt() - 1;
			PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {

				public int compare(Integer o1, Integer o2) {
					return Long.compare(min_time[o1], min_time[o2]);
				}
			});
			pq.add(start);
			Arrays.fill(min_time, Long.MAX_VALUE);
			min_time[start] = 0;
			while (!pq.isEmpty()) {
				int pop = pq.poll();
				for (Edge g : adj[pop]) {
					int go = g.to;
					if (min_time[pop] + g.time < min_time[go] && min_time[pop] <= g.max_time) {
						min_time[go] = g.time + min_time[pop];
						pq.add(go);
					}
				}
			}
			if (min_time[end] != Long.MAX_VALUE) {
				System.out.print(min_time[end]);
			} else {
				System.out.print(-1);
			}
		}

		public class Edge {
			long time;
			long max_time;
			int to;

			public Edge(long max_time, int to, long time) {
				this.max_time = max_time;
				this.to = to;
				this.time = time;
			}

		}

	}

}
