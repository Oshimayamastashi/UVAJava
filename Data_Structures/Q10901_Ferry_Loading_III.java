package Data_Structures;

import java.io.*;
import java.util.*;

public class Q10901_Ferry_Loading_III {
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int case_num=Integer.parseInt(br.readLine());
		while(case_num-->0){
			StringTokenizer tk=new StringTokenizer(br.readLine());
			int capacity=Integer.parseInt(tk.nextToken());
			int comsume_time=Integer.parseInt(tk.nextToken());
			int car_num=Integer.parseInt(tk.nextToken());
			Queue <Car> right=new LinkedList<>();
			Queue <Car> left=new LinkedList<>();
			LinkedList <Car> finish=new LinkedList<>();
			for(int i=0;i<car_num;i++){
				tk=new StringTokenizer(br.readLine());
				Car c=new Car(i,Integer.parseInt(tk.nextToken()),0);
				if(tk.nextToken().equals("left"))
					left.offer(c);				
				else
					right.offer(c);
			}
			boolean isleft=true;
			int time=0;						
			while(!right.isEmpty()||!left.isEmpty()){
				//System.out.println(time+" "+isleft);
				if(isleft){
					if(!left.isEmpty()&&time>=left.peek().show_time){
						load(finish, left, capacity, comsume_time, time);
						time+=comsume_time;
						isleft=!isleft;
					}
					else if(!right.isEmpty()&&time>=right.peek().show_time){
						time+=comsume_time;
						isleft=!isleft;
						load(finish, right, capacity, comsume_time, time);
						time+=comsume_time;
						isleft=!isleft;
					}
					else {
						time=wait(left,right);
					}
				}
				else{	
					if(!right.isEmpty()&&time>=right.peek().show_time){						
						load(finish, right, capacity, comsume_time, time);
						time+=comsume_time;
						isleft=!isleft;
					}
					else if(!left.isEmpty()&&time>=left.peek().show_time){
						time+=comsume_time;
						isleft=!isleft;
						load(finish, left, capacity, comsume_time, time);
						time+=comsume_time;
						isleft=!isleft;
					}					
					else {
						time=wait(left,right);
					}					
				}
			}
			Collections.sort(finish);
			for(Car c:finish){
				sb.append(c.arrive_time+"\n");
			}
					
			if(case_num!=0){
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}

	private static int wait(Queue<Car> left, Queue<Car> right) {
		if(left.isEmpty()) {
			return right.peek().show_time;
		}
		else if(right.isEmpty()) {
			return left.peek().show_time;
		}
		else {
			if(left.peek().show_time>right.peek().show_time) {
				return right.peek().show_time;
			}
			else
				return left.peek().show_time;		
		}
	}

	private static void load(LinkedList<Car> finish,Queue<Car> side, int capacity,int comsume,int time) {
		while(capacity-->0&&!side.isEmpty()){
			if(time>=side.peek().show_time){
				Car c=side.poll();
				c.arrive_time=time+comsume;
				finish.add(c);				
			}
			else
				break;
		} 		
	}
	
	static class Car implements Comparable<Car>{
		int arrive_time;
		int show_time;
		int No;
		Car(int no,int show,int arrive){
			arrive_time=arrive;
			show_time=show;
			No=no;
		}
		@Override
		public int compareTo(Car c) {		
			return this.No-c.No;
		}	
		
	}
}

