package Data_Structures;

import java.io.*;
import java.util.*;

public class Q11136_Hoax_or_what {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int day=Integer.parseInt(br.readLine());
		while(day!=0){
			long total=0;//Care
			TreeMap<Integer,Integer> urn=new TreeMap<>();
			while(day-->0) {				
				StringTokenizer tk=new StringTokenizer(br.readLine());
				int bill_num=Integer.parseInt(tk.nextToken());				
				while(bill_num-->0){
					int bill=Integer.parseInt(tk.nextToken());
					addbill(bill,urn);
				}
				int max=urn.lastKey();
				int min=urn.firstKey();				
				total+=max-min;
				deletebill(urn,max);
				deletebill(urn,min);
			}
			sb.append(total+"\n");
			//urn.clear();
			day=Integer.parseInt(br.readLine());
			
		}
		System.out.print(sb);
	}

	private static void deletebill(TreeMap<Integer, Integer> urn, int key) {
		if(urn.get(key)==1) {
			urn.remove(key);
		}
		else {
			urn.put(key,urn.get(key)-1);
		}
		
	}

	private static void addbill(int bill, TreeMap<Integer, Integer> urn) {
		if(urn.containsKey(bill)) {
			urn.put(bill, urn.get(bill)+1);
		}
		else {
			urn.put(bill, 1);
		}		
	} 
	

}
