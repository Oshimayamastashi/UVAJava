package Data_Structures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Q10507_Waking_up_brain {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while ((str = br.readLine()) != null) {
			int area_num = Integer.parseInt(str);

			ArrayList<String> area_name = new ArrayList<>();
			ArrayList<Set<String>> connect = new ArrayList<>();
			for (int i = 0; i < area_num; i++) {
				Set<String> s = new HashSet<>();
				connect.add(s);
			}
			// area that is wake up
			Set<String> wakeup = new HashSet<>();

			int connect_num = Integer.parseInt(br.readLine());
			String dir_area = br.readLine();
			for (int i = 0; i < 3; i++) {
				String area = dir_area.charAt(i) + "";
				wakeup.add(area);
			}
			while (connect_num-- > 0) {
				str = br.readLine();
				String area1 = str.charAt(0) + "";
				String area2 = str.charAt(1) + "";

				int a = indexof(area1, area_name);
				int b = indexof(area2, area_name);

				connect.get(a).add(area2);
				connect.get(b).add(area1);
			}

			int a = 3;
			int runtime = 0;
			while (a < area_num) {
				runtime++;
				int k = active(wakeup, connect, area_name);
				a += k;
				if (k == 0) {
					System.out.println("THIS BRAIN NEVER WAKES UP");
					break;
				}
			}

			if (a == area_num) {
				System.out.println("WAKE UP IN, " + runtime + ", YEARS");
			}

			br.readLine();
		}

	}

	private static int active(Set<String> wakeup, ArrayList<Set<String>> connect, ArrayList<String> area_name) {
		ArrayList<Integer> newactive = new ArrayList<>();
		for (int i = 0; i < connect.size(); i++) {
			int a = 0;
			for (String s : wakeup) {
				if (connect.get(i).contains(s))
					a++;
			}
			if (a >= 3) {
				newactive.add(i);
			}
		}
		int newarea = 0;
		for (int i : newactive) {
			if (!wakeup.contains(area_name.get(i))) {
				wakeup.add(area_name.get(i));
				newarea++;
			}
		}

		return newarea;
	}

	private static int indexof(String query, ArrayList<String> area_name) {
		int a = -1;
		for (int i = 0; i < area_name.size(); i++) {
			if (area_name.get(i).equals(query)) {
				a = i;
			}
		}
		if (a < 0) {
			a = area_name.size();
			area_name.add(query);
		}

		return a;
	}
}
