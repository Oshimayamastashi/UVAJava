package Data_Structures;

import java.io.*;
import java.util.*;

public class Q1203_Argus {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		String str;
		ArrayList<Register> al=new ArrayList<>();
		while(!(str=br.readLine()).equals("#")) {
			StringTokenizer tk=new StringTokenizer(str);
			tk.nextToken();
			Register r=new Register(Integer.parseInt(tk.nextToken()),Integer.parseInt(tk.nextToken()));
			al.add(r);
		}
		int K=Integer.parseInt(br.readLine());
		Queue<Register> argus=new PriorityQueue<>(new RegisterComp());
		for(int i=1;i<K;i++) {
			for(int x=0;x<al.size();x++){
				Register r=new Register(al.get(x).Q_num,al.get(x).time*i);
				argus.add(r);
			}
		}
		for(int i=0;i<K;i++) {
			Register r=argus.poll();
			sb.append(r.Q_num+"\n");
		}
		System.out.print(sb);
	}
	static class Register{
		int Q_num;
		int time;
		Register(int num,int p){
			Q_num=num;
			time=p;
		}		
	}
	static class RegisterComp implements Comparator<Register> {
		 
	    @Override
	    public int compare(Register a, Register b) {
	    	if (a.time == b.time) {
	            return a.Q_num-b.Q_num;
	        } 
	        else {
	            return a.time - b.time;
	        }
	    }
	}
}
