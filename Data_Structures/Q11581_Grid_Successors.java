package Data_Structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q11581_Grid_Successors {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int case_num=Integer.parseInt(br.readLine());
		while(case_num-->0){
			br.readLine();
			int[][]maze=new int[3][3];
			ArrayList <String> ar =new ArrayList<>(); 
			for(int i=0;i<3;i++) {
				String str=br.readLine();
				for(int x=0;x<3;x++){
					maze[i][x]=str.charAt(x)-'0';
				}			
			}			
			while(!allzero(maze)){
				String a="";
				for(int i=0;i<3;i++) {						
					for(int x = 0;x<3;x++){
						a+=maze[i][x];
					}
				}
				if(!ar.contains(a)){
					ar.add(a);
				}
				f_trans(maze);				
			}
			System.out.println(ar.size()-1);
		}

	}

	private static boolean allzero(int[][] maze) {
		int sum=0;
		for(int i=0;i<3;i++) {						
			for(int x = 0;x<3;x++){
				sum+=maze[i][x];
			}
		}
		return sum==0;
	}

	private static void f_trans(int[][] maze) {
		int[][] f_a=new int[3][3];		
		for(int i=0;i<3;i++) {
			for(int x=0;x<3;x++){
				int count=0;
				if(x+1<3) {count+=maze[i][x+1];}
				if(x-1>=0) {count+=maze[i][x-1];}
				if(i+1<3) {count+=maze[i+1][x];}
				if(i-1>=0) {count+=maze[i-1][x];}
				f_a[i][x]=count%2;
			}
		}
		
		for(int i=0;i<3;i++) {
			for(int x=0;x<3;x++){
				maze[i][x]=f_a[i][x];
			}
		}
	}
	

}
