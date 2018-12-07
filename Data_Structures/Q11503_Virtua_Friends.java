package Data_Structures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Q11503_Virtua_Friends {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int case_num = Integer.parseInt(br.readLine());
		while (case_num-- > 0) {
			int fdship_num = Integer.parseInt(br.readLine());
			ArrayList<Set<String>> friend = new ArrayList<>();
			while (fdship_num-- > 0) {
				String[] str = br.readLine().split(" ");
				int p1 = indexof(str[0], friend);
				int p2 = indexof(str[1], friend);
				if (p1 >= 0 && p2 >= 0) {
					if (p1 != p2) {
						Set<String> s = friend.get(p2);
						friend.get(p1).addAll(s);

						friend.remove(p2);
					}

				} else if (p1 >= 0) {
					friend.get(p1).add(str[1]);
				} else if (p2 >= 0) {
					friend.get(p2).add(str[0]);
				} else {
					Set<String> s = new HashSet<String>();
					s.add(str[0]);
					s.add(str[1]);
					friend.add(s);
				}
				int a = indexof(str[0], friend);
				System.out.println(friend.get(a).size());
			}

		}

	}

	private static int indexof(String query, ArrayList<Set<String>> connect) {
		for (int i = 0; i < connect.size(); i++) {

			if (connect.get(i).contains(query)) {
				return i;
			}
		}
		return -1;
	}
}
