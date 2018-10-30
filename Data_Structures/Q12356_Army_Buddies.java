package Data_Structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q12356_Army_Buddies {
	static public void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader input = new BufferedReader(isr);
		String[] str=input.readLine().split(" ");
		int s_num=Integer.parseInt(str[0]);
		int b_num=Integer.parseInt(str[1]);
		while(s_num!=0||b_num!=0) {
			Soldier[] line=new Soldier[s_num+2];
			for(int i=0;i<line.length;i++) {
				line[i]=new Soldier();
				line[i].left=i-1;
				line[i].right=i+1;
			}
			StringBuilder sb = new StringBuilder();
			while(b_num-->0){
				str=input.readLine().split(" ");				
				int L=Integer.parseInt(str[0]);
				int R=Integer.parseInt(str[1]);
				
				String left = line[L].left < 1 ? "*" : line[L].left + "";
				String right = line[R].right > s_num ? "*" : line[R].right + "";
				sb.append(left + " " + right + "\n");
				
				line[line[L].left].right=line[R].right;
				line[line[R].right].left=line[L].left;
			}
			sb.append("-");
			System.out.println(sb);
			
			str=input.readLine().split(" ");
			s_num=Integer.parseInt(str[0]);
			b_num=Integer.parseInt(str[1]);
		}		
		input.close();
	}
	
	static class Soldier{
		int right,left;
	}
		
}
