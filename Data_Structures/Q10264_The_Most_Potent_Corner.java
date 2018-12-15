package Data_Structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q10264_The_Most_Potent_Corner {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringBuilder sb = new StringBuilder();
		while ((str = br.readLine()) != null) {
			int dimension = Integer.parseInt(str);
			int num = (int) Math.pow(2, dimension);
			int[] corner = new int[num];
			int[] potency= new int[num];
			for (int i = 0; i < num; i++) {
				corner[i] = Integer.parseInt(br.readLine());
			}
			for (int i = 0; i < num; i++) {
				int sum = 0;
				for (int j = 0; j < dimension; j++) {
					int b = i ^ (1 << j);
					sum += corner[b];
				}
				potency[i] = sum;
			}
			int max_p=0;
			for (int i = 0; i < num; i++) {
				int a;
				for (int j = 0; j < dimension; j++) {
					int b = i ^ (1 << j);
					a=potency[i]+potency[b];
					if(max_p<a) {
						max_p=a;
					}
				}
			}
			sb.append(max_p+"\n");
		}
		System.out.print(sb);
	}
}
