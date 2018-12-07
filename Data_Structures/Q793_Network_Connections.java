package Data_Structures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Q793_Network_Connections {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int case_num = Integer.parseInt(br.readLine());
		br.readLine();
		while (case_num-- > 0) {
			int com_num = Integer.parseInt(br.readLine());
			ArrayList<Set<Integer>> connect = new ArrayList<>();
			for (int i = 0; i < com_num; i++) {
				Set<Integer> s = new HashSet<Integer>();
				s.add(i + 1);
				connect.add(s);
			}
			String str;
			int success = 0;
			int unsuccess = 0;

			while ((str = br.readLine()) != null) {
				if (str.equals("")) {
					break;
				}
				String[] str2 = str.split(" ");
				int c1 = Integer.parseInt(str2[1]);
				int c2 = Integer.parseInt(str2[2]);
				if (str2[0].equals("c")) {
					int a = indexof(c1, connect);
					int b = indexof(c2, connect);
					if (a != b) {
						Set<Integer> s = connect.get(b);
						connect.get(a).addAll(s);
						connect.remove(b);
					}
				} else {
					int a = indexof(c1, connect);
					int b = indexof(c2, connect);
					if (a == b) {
						success++;
					} else
						unsuccess++;
				}
			}
			System.out.println(success + "," + unsuccess);
			if (case_num != 0) {
				System.out.println();
			}

		}

	}

	private static int indexof(int query, ArrayList<Set<Integer>> connect) {
		for (int i = 0; i < connect.size(); i++) {

			if (connect.get(i).contains(query)) {
				return i;
			}
		}
		return 0;
	}
}
