package Data_Structures;

import java.io.*;
import java.util.*;

public class Q1062_Containers{
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		String ship;
		int case_num=0;
		while(!(ship=br.readLine()).equals("end")){
			sb.append("Case "+(++case_num)+": ");
			ArrayList<Stack<Character>> container=new ArrayList<>();
			for(char c:ship.toCharArray()){
				load(container,c);				
				}
			sb.append(container.size()+"\n");
		}
		
		System.out.print(sb);
	}

	private static void load(ArrayList<Stack<Character>> container, char c) {
		if(container.size()==0){
			Stack<Character> s=new Stack<Character>();
			s.push(c);
			container.add(s);
			return;
		}
		int max=-999;
		int stack_no=-1;
		for(int i=0;i<container.size();i++){
			int a=(int) c-(int)container.get(i).peek();
			if(a>max&&a<=0){
				stack_no=i;
				max=a;
			}
		}
		if(stack_no<0) {
			Stack<Character> s=new Stack<Character>();
			s.push(c);
			container.add(s);
		}
		else{
			container.get(stack_no).push(c);
		}	
	}
}
