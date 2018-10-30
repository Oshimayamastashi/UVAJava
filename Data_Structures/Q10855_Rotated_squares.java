package Data_Structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q10855_Rotated_squares {

	public static void main(String[] args) throws IOException {		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));		
		String input=br.readLine();
		StringTokenizer tk=new StringTokenizer(input);
		int N=Integer.parseInt(tk.nextToken());
		int n=Integer.parseInt(tk.nextToken());
		while(!(N==0&&n==0)) {
			
			char[][] big_maze=new char[N][N];
			char[][] small_maze=new char[n][n];
			
			for(int i=0;i<N;i++) {
				input=br.readLine();
				for(int x=0;x<N;x++){
					big_maze[i][x]=input.charAt(x);
				}
			}
			for(int i=0;i<n;i++) {
				input=br.readLine();
				for(int x=0;x<n;x++){
					small_maze[i][x]=input.charAt(x);
				}
			}
			
			StringBuilder sb=new StringBuilder();			
			int total=matchmaze(big_maze,small_maze,N,n);
			sb.append(total);
			int count=3;
			while(count-->0) {
			rotate90(small_maze,n);
			//System.out.println(Arrays.deepToString(small_maze));
			total=matchmaze(big_maze,small_maze,N,n);
			sb.append(" "+total);
			}
			
			System.out.println(sb);
			
			input=br.readLine();
			tk=new StringTokenizer(input);
			N=Integer.parseInt(tk.nextToken());
			n=Integer.parseInt(tk.nextToken());
		}
	}

	private static int matchmaze(char[][] big_maze, char[][] small_maze, int N, int n) {
		int count=0;
		for(int i=0;i<=N-n;i++) {
			for(int x=0;x<=N-n;x++) {						
				if(compare(small_maze,big_maze,i,x))
					count++;
			}
		}
		
		return count;
	}
	private static boolean compare(char[][] m1,char[][] m2,int a,int b){
		for(int y=0;y<m1.length;y++) {
			for(int t=0;t<m1[y].length;t++){
				if(m1[y][t]!=m2[a+y][b+t]) {
					return false;
				}
			}
		}	
		return true;
	}

	private static void rotate90(char[][] small_maze,int n) {
		char[][] rot90_maze=new char[n][n];
		
		for(int i=0;i<n;i++) {
			for(int x=0;x<n;x++) {
				rot90_maze[x][n-i-1]=small_maze[i][x];
			}
		}
		
		for(int i=0;i<n;i++) {
			for(int x=0;x<n;x++) {
				small_maze[i][x]=rot90_maze[i][x];
			}
		}		
	}

}
