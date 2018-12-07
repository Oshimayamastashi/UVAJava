package Data_Structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q11235_Frequent_values {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while (!(str = br.readLine()).equals("0")) {
			String[] str2 = str.split(" ");
			int list_num = Integer.parseInt(str2[0]);
			int query_num = Integer.parseInt(str2[1]);

			int[] list = new int[list_num];
			int[] p = new int[list_num];
			ArrayList<Integer> s = new ArrayList<Integer>();
			ArrayList<Integer> left = new ArrayList<Integer>();
			ArrayList<Integer> right = new ArrayList<Integer>();

			str2 = br.readLine().split(" ");
			for (int i = 0; i < list_num; i++) {
				list[i] = Integer.parseInt(str2[i]);
			}
			int time = 1;
			int kind = 0;
			left.add(0);
			for (int i = 1; i < list_num; ++i) {
				if (list[i] == list[i - 1]) {
					time++;
				} else {
					s.add(time);
					right.add(i - 1);
					left.add(i);
					time = 1;
					kind++;
				}
				p[i] = kind;
			}
			s.add(time);
			right.add(list_num - 1);

			segTree maxSegTree = new segTree(s);

			for (int i = 0; i < query_num; i++) {
				str2 = br.readLine().split(" ");
				int L = Integer.parseInt(str2[0]);
				int R = Integer.parseInt(str2[1]);
				int l = p[--L], r = p[--R];
				// System.out.println(l+" "+r);
				if (l == r)
					System.out.println(R - L + 1);
				else if (l + 1 == r) {
					System.out.println(max(right.get(l) - L + 1, R - left.get(r) + 1));
				} else {

					int temp = max(right.get(l) - L + 1, R - left.get(r) + 1);

					maxSegTree.query(1, s.size(), l + 2, r, 1);
					System.out.println(max(maxSegTree.answer, temp));
					maxSegTree.answer = 0;

				}

			}
		}
	}

	static int max(int a, int b) {
		if (a > b)
			return a;
		else
			return b;
	}

	private static class segTree {
		int[] segmentTree;
		int answer = Integer.MIN_VALUE;

		public segTree(ArrayList<Integer> arr) {
			int n = arr.size();
			n = getTreeNum(n);
			segmentTree = new int[2 * n];
			construct(arr, 1, arr.size(), 1);
			// System.out.println(Arrays.toString(segmentTree));
		}

		int getTreeNum(int a) {
			int i = 1;
			while (Math.pow(2, i) < a) {
				i++;
			}
			return (int) Math.pow(2, i);
		}

		void construct(ArrayList<Integer> arr, int left, int right, int pos) {

			if (left == right) {
				segmentTree[pos] = arr.get(left - 1);
				return;
			}

			int mid = (left + right) / 2;
			construct(arr, left, mid, 2 * pos);
			construct(arr, mid + 1, right, 2 * pos + 1);
			segmentTree[pos] = update(segmentTree[2 * pos], segmentTree[2 * pos + 1]);
		}

		private int update(int i, int j) {
			if (i > j)
				return i;
			else
				return j;
		}

		public void query(int left, int right, int start, int end, int pos) {
			// int answer=0;
			if (start <= left && right <= end) {
				answer = update(answer, segmentTree[pos]);
				return;
			}
			int mid = (left + right) / 2;
			if (mid >= start)
				query(left, mid, start, end, pos * 2);
			if (mid < end)
				query(mid + 1, right, start, end, pos * 2 + 1);
		}
	}
}
