package Data_Structures;

import java.io.*;
import java.util.*;

public class Q11034_Ferry_Loading_IV {
	public static void main(String[] atgs)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int case_num=Integer.parseInt(br.readLine());
		while(case_num-->0){
			StringTokenizer tk=new StringTokenizer(br.readLine());
			int max_l=Integer.parseInt(tk.nextToken())*100;
			int car_num=Integer.parseInt(tk.nextToken());
			Queue <Integer> left=new LinkedList<>(); 
			Queue <Integer> right=new LinkedList<>();
			while(car_num-->0){
				tk=new StringTokenizer(br.readLine());
				int car_l=Integer.parseInt(tk.nextToken());
				if(tk.nextToken().equals("left"))
					left.offer(car_l);
				else
					right.offer(car_l);
			}
			int time=0;
			boolean isleft=true;
			while(!left.isEmpty()||!right.isEmpty()){				
				if(isleft){
					if(!left.isEmpty()){
						int total=0;
						load(left,total,max_l);
					}
				}
				else {
					if(!right.isEmpty()) {
						int total=0;
						load(right,total,max_l);
					}					
				}				
				isleft=!isleft;
				time++;				
			}
			sb.append(time+"\n");
		}
		System.out.print(sb);
	}	

	
	private static void load(Queue<Integer> side, int total,int max_l) {
		while(!side.isEmpty()){
			if(total+side.peek()<=max_l) {
				total+=side.peek();
				side.poll();
			}
			else{
				break;
			}
		}
	}	
}


