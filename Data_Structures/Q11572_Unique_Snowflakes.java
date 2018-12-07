package Data_Structures;

import java.io.*;
import java.util.*;

public class Q11572_Unique_Snowflakes {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb=new StringBuilder();
		int case_num=Integer.parseInt(br.readLine());
		while(case_num-->0) {
			int snowflake_num=Integer.parseInt(br.readLine());
			Map<Integer,Integer> snowflake = new TreeMap<>();
			int start=1;
			int max=0;
			int i;
			for(i=1;i<=snowflake_num;i++){				
				int s=Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());				
				if(snowflake.containsKey(s)) {					
					if(snowflake.get(s)>=start) {
						if(i-start>max) {
							max=i-start;						
						}
						start=snowflake.get(s)+1;							
					}
					snowflake.put(s,i);	
				}
				else {
					snowflake.put(s,i);		
					if(i==snowflake_num){
						if(max<i-start+1)
							max=i-start+1;
					}
				}
				
							
			}
			
			sb.append(max+"\n");
		}
		System.out.println(sb);
	}

}
