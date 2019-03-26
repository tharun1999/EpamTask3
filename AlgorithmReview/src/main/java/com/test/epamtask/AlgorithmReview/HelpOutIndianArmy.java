package com.test.epamtask.AlgorithmReview;


import java.util.*;
import java.io.*;

class HelpOutIndianArmy {
	
	public static long findSolution(long S, long E, TreeMap<Long, Long> t1, TreeMap<Long, Long> t2 ) {
		ArrayList<Long> l1 = new ArrayList<Long>(t1.keySet());
		ArrayList<Long> l2 = new ArrayList<Long>(t1.values());
		long c = l1.get(0);
		long d = l2.get(0);
		for (int i = 1; i < t1.size(); i++) {
			if (l1.get(i) <= d)
				d = Math.max(d, l2.get(i));
			else {
				t2.put(c, d);
				c = l1.get(i);
				d = l2.get(i);
			}
		}
		t2.put(c, d);
		int i;
		long ans = 0;
		l1 = new ArrayList<Long>(t2.keySet());
		l2 = new ArrayList<Long>(t2.values());

		for (i = 0; i < l1.size(); i++) {
			if (S >= E) {
				S = E;
				break;
			}
			if (l1.get(i) <= S && S <= l2.get(i))
				S = l2.get(i);

			else if (S <= l1.get(i) && E >= l2.get(i)) {
				ans += l1.get(i) - S;
				S = l2.get(i);

			} else if (S <= l1.get(i) && E >= l1.get(i) && E <= l2.get(i)) {
				ans += l1.get(i) - S;
				S = E;
			} else if (S <= l1.get(i) && E <= l1.get(i)) {
				ans += E - S;
				S = E;
			}
		}
		if (S < E) {
			ans += E - S;
		}
		return ans;
	}
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String l[] = br.readLine().split(" ");
		long N = Long.parseLong(l[0]);
		long S = Long.parseLong(l[1]);
		long E = Long.parseLong(l[2]);
		TreeMap<Long, Long> t1 = new TreeMap<>();
		TreeMap<Long, Long> t2 = new TreeMap<>();
		for (int i = 0; i < N; i++) {
			String s[] = br.readLine().split(" ");
			long x = Long.parseLong(s[0]);
			long p = Long.parseLong(s[1]);
			t1.put((x - p), (x + p));
		}
		br.close();
		System.out.println(findSolution(S, E, t1, t2));
		
	}
}
