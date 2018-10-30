package Introduction;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q161_Traffic_Lights {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);		
		while(input.hasNextInt()){
			int cycle=input.nextInt();
			ArrayList<Integer> al=new ArrayList<>();
			while(cycle!=0){				
				al.add(cycle);
				cycle=input.nextInt();
			}			
			if(al.size()>0){
				Collections.sort(al);
				int[][] time=new int[al.size()][18001];			
				for(int x=0;x<al.size();x++){
					cycle=al.get(x);
					for(int i=0;i<time[x].length;i++){
						if(i%(cycle*2)>=cycle){
							time[x][i]=3;
						}
						else if(i%cycle>=cycle-5){
							time[x][i]=2;
						}
						else{
							time[x][i]=1;
						}
					}
				}
				int k=getgreen(time,al.get(0)*2);
				if(k>0){
					printtime(k);
				}
				else{
					System.out.println("Signals fail to synchronise in 5 hours");
				}
				al.clear();
			}
		}
		input.close();
	}

	private static void printtime(int k) {
		int hour=k/3600;
		int minute=(k-hour*3600)/60;
		int second=k%60;
		if(hour<10)
			System.out.print(0);
		System.out.print(hour+":");
		if(minute<10)
			System.out.print(0);
		System.out.print(minute+":");
		if(second<10)
			System.out.print(0);
		System.out.println(second);
	}

	private static int getgreen(int[][] time,int start) {
		for(int x=start;x<time[0].length;x++){
			boolean status=true;
			for(int i=0;i<time.length;i++){
				if(time[i][x]!=1){
				status=false;
				break;
				}			
			}
			if(status){
			return x;
			}
		}		
		return -1;
	}
}

