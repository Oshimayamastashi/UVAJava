package Data_Structures;

import java.io.*;
import java.util.*;

public class Q10172_The_Lonesome_Cargo_Distributor {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int case_num=Integer.parseInt(br.readLine());
		while(case_num-->0){
		//Get Input 
		StringTokenizer tk=new StringTokenizer(br.readLine());
		Station[] country=new Station[Integer.parseInt(tk.nextToken())+1];
		int capacity=Integer.parseInt(tk.nextToken());
		int B_max=Integer.parseInt(tk.nextToken());
		Stack<Integer> car=new Stack<>();		
			for(int i=1;i<country.length;i++){
				country[i]=new Station();
				tk=new StringTokenizer(br.readLine());
				int cargoes_num=Integer.parseInt(tk.nextToken());
				while(cargoes_num-->0){
					country[i].B_side.offer(Integer.parseInt(tk.nextToken()));
				}
			}
		//	start trans job
			int pos=1;
			int time=0;
			while(!jobfinish(car,country)){
				time=unload(car,country[pos], pos, B_max, time);
				time=load(car,country[pos], pos, capacity, time);
				time+=2;
				pos=nextpos(pos,country.length);
			}
			sb.append(time-2+"\n");
		}
		System.out.print(sb);
	}

	private static int load(Stack<Integer> car, Station station, int pos, int capacity, int time) {
		while(car.size()<capacity){
			if(!station.B_side.isEmpty()){
				car.push(station.B_side.poll());
				time++;
			}				
			else
				break;
		}		
		return time;
	}

	private static int unload(Stack<Integer>car,Station station,int pos,int B_max,int time) {
		while(!car.isEmpty()){
			if(car.peek()==pos) {
				station.A_side.offer(car.pop());
				time++;
			}
			else {
				if(station.B_side.size()<B_max) {
					station.B_side.offer(car.pop());
					time++;
				}					
				else
					break;
			}
		}
		return time;
	}

	private static int nextpos(int pos,int n) {
		 if(pos<n-1)
			 pos++;
		 else
			 pos=1;
		return pos;
	}

	private static boolean jobfinish(Stack<Integer> car, Station[] country) {
		if(!car.empty())
			return false;
		else{
			for(int i=1;i<country.length;i++) {
				if(!country[i].B_side.isEmpty())
					return false;				
			}
		}
		return true;
	}	
}
class Station{
	Queue<Integer>A_side=new LinkedList<>();
	Queue<Integer>B_side=new LinkedList<>();	
}
