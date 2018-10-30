package Data_Structures;

import java.io.*;
import java.util.*;

public class Q11933_Splitting_Numbers {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int num;
		while((num=Integer.parseInt(br.readLine()))!=0){
			int[] arr_2bit=new int[31]; 
			get2bit(num,arr_2bit);
			LinkedList<Integer>a=new LinkedList<>();
			LinkedList<Integer>b=new LinkedList<>();
			int index=0;
			for(int i=0;i<arr_2bit.length;i++) {
				if(arr_2bit[i]==1) {
					if(index%2==0) {
						a.add(i);
						index++;
					}
					else {
						b.add(i);
						index++;
					}
				}
			}
			int[] a_2bit=new int[31];
			int[] b_2bit=new int[31];
			trans(a_2bit,a);
			trans(b_2bit,b);
			sb.append(to10bit(a_2bit)+" "+to10bit(b_2bit)+"\n");
		}
		System.out.print(sb);
	}

	private static void trans(int[] a_2bit, LinkedList<Integer> a) {
		for(int i=0;i<a.size();i++){
			a_2bit[a.get(i)]=1;
		}	
	}

	private static void get2bit(int num, int[] arr_2bit) {
		int i=0;
		while(num>0){
			if(num%2==1)
				arr_2bit[i]=1;
			num/=2;
			i++;
		}
		
	}
	static int to10bit(int[] a_2bit){
		int total=0;
		for(int i=0;i<a_2bit.length;i++){
			if(a_2bit[i]==1) {
				total+=Math.pow(2,i);				
			}
		}
		return total;
	}
}
