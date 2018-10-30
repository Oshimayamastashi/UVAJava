package Data_Structures;

import java.io.*;
import java.util.*;

public class Q11286_Conformity {

	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb=new StringBuilder();
		int stu_num;
		while((stu_num=Integer.parseInt(br.readLine()))!=0) {
			Map<String,Integer> combinations = new HashMap<>();
			int max=1;
			while(stu_num-->0) {				
				StringTokenizer tk=new StringTokenizer(br.readLine());
				int[] course=new int[5];
				for(int i=0;i<course.length;i++){
					course[i]=Integer.parseInt(tk.nextToken());
				}
				String str=getcoursestr(course);
				if(combinations.containsKey(str)) {
					int value=combinations.get(str)+1;
					if(value>max) {
						max=value;
					}
					combinations.put(str,value);
				}
				else {
					combinations.put(str,1);
				}
			}
			Collection<Integer> value = combinations.values();
			int a=0;
			for(int var:value) {				
				if(var==max){
					a++;
				}
			}			
			sb.append(a*max+"\n");
		}
		System.out.print(sb);

	}

	private static String getcoursestr(int[] course) {
		String str="";
		Arrays.sort(course);
		for(int i:course){
			str+=String.valueOf(i);
		}
		return str;
	}

}
