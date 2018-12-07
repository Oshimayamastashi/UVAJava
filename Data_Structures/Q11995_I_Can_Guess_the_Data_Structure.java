package Data_Structures;

import java.io.*;
import java.util.*;

public class Q11995_I_Can_Guess_the_Data_Structure {
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();		
		String str;
		while((str=br.readLine())!=null) {
			Stack<Integer> stack=new Stack<>();
			Queue<Integer> queue=new LinkedList<>();
			Queue<Integer> priorityqueue=new PriorityQueue<>(Collections.reverseOrder());
			int case_num=Integer.parseInt(str);
			boolean isstack=true;
			boolean isqueue=true;
			boolean ispqueue=true;
			while(case_num-->0) {
				StringTokenizer tk=new StringTokenizer(br.readLine());				
				if(tk.nextToken().equals("1")) {
					int var=Integer.parseInt(tk.nextToken());
					stack.push(var);
					queue.offer(var);
					priorityqueue.offer(var);
				}
				else {					
					int var=Integer.parseInt(tk.nextToken());
					if(!stack.isEmpty()&&isstack){						
						if(stack.pop()!=var)
							isstack=false;
					}
					else {
						isstack=false;
					}
					if(!queue.isEmpty()&&isqueue){						
						if(queue.poll()!=var)
							isqueue=false;
					}
					else {
						isqueue=false;
					}
					if(!priorityqueue.isEmpty()&&ispqueue){						
						if(priorityqueue.poll()!=var)
							ispqueue=false;
					}
					else {
						ispqueue=false;
					}					
				}
			}
			sb.append(determine(isstack,isqueue,ispqueue)+"\n");
		}
		System.out.print(sb);
	}

	private static String determine(boolean isstack, boolean isqueue, boolean ispqueue) {
		if(isstack||isqueue||ispqueue) {
			if(isstack&&!isqueue&&!ispqueue)
				return "stack";
			else if(!isstack&&isqueue&&!ispqueue)
				return "queue";
			else if(!isstack&&!isqueue&&ispqueue)
				return "priority queue";
			else
				return "not sure";
		}
		return "impossible";
				
	}
}
