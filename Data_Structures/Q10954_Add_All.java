package Data_Structures;

import java.io.*;
import java.util.*;

public class Q10954_Add_All {

	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int case_num=Integer.parseInt(br.readLine());
		while(case_num!=0) {
			PriorityQueue<Integer> List=new PriorityQueue<Integer>();
			StringTokenizer tk=new StringTokenizer(br.readLine());
			for(int i=0;i<case_num;i++){
				List.add(Integer.parseInt(tk.nextToken()));
			}
			int total=0;
			while(List.size()!=1) {
				int var1=List.poll();
				int var2=List.poll();
				total+=var1+var2;
				List.add(var1+var2);				
			}
			sb.append(total+"\n");
			case_num=Integer.parseInt(br.readLine());
		}
		System.out.print(sb);
	}

}
