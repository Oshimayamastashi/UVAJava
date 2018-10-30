package Introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q403_Postscript {
	static String C5[][] = {
		    {".***..", "*...*.", "*****.", "*...*.", "*...*."},//A
		    {"****..", "*...*.", "****..", "*...*.", "****.."},//B
		    {".****.", "*...*.", "*.....", "*.....", ".****."},//C
		    {"****..", "*...*.", "*...*.", "*...*.", "****.."},//D
		    {"*****.", "*.....", "***...", "*.....", "*****."},//E
		    {"*****.", "*.....", "***...", "*.....", "*....."},//F
		    {".****.", "*.....", "*..**.", "*...*.", ".***.."},//G
		    {"*...*.", "*...*.", "*****.", "*...*.", "*...*."},//H
		    {"*****.", "..*...", "..*...", "..*...", "*****."},//I
		    {"..***.", "...*..", "...*..", "*..*..", ".**..."},//J
		    {"*...*.", "*..*..", "***...", "*..*..", "*...*."},//K
		    {"*.....", "*.....", "*.....", "*.....", "*****."},//L
		    {"*...*.", "**.**.", "*.*.*.", "*...*.", "*...*."},//M
		    {"*...*.", "**..*.", "*.*.*.", "*..**.", "*...*."},//N
		    {".***..", "*...*.", "*...*.", "*...*.", ".***.."},//O
		    {"****..", "*...*.", "****..", "*.....", "*....."},//P
		    {".***..", "*...*.", "*...*.", "*..**.", ".****."},//Q
		    {"****..", "*...*.", "****..", "*..*..", "*...*."},//R
		    {".****.", "*.....", ".***..", "....*.", "****.."},//S
		    {"*****.", "*.*.*.", "..*...", "..*...", ".***.."},//T
		    {"*...*.", "*...*.", "*...*.", "*...*.", ".***.."},//U
		    {"*...*.", "*...*.", ".*.*..", ".*.*..", "..*..."},//V
		    {"*...*.", "*...*.", "*.*.*.", "**.**.", "*...*."},//W
		    {"*...*.", ".*.*..", "..*...", ".*.*..", "*...*."},//X
		    {"*...*.", ".*.*..", "..*...", "..*...", "..*..."},//Y
		    {"*****.", "...*..", "..*...", ".*....", "*****."},//Z
		    {"......", "......", "......", "......", "......"},//BLANK
		};
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		String str=br.readLine();
		while(str!=null && str.length()!=0){
			char[][]grid=new char[60][60];
			for(int i=0;i<grid.length;i++) {for(int x=0;x<grid[i].length;x++){grid[i][x]='.';}}			
			while(!str.equals(".EOP")) {
			StringTokenizer tokens = new StringTokenizer(str);
				String printtype=tokens.nextToken();
				String font=tokens.nextToken();			
				int line=Integer.parseInt(tokens.nextToken());
				int start=-1;
				if(printtype.equals(".P")){
					start=Integer.parseInt(tokens.nextToken())-1;
				}
				String text=str.substring(str.indexOf("|")+1,str.length()-1);
				if(font.equals("C1")){
					print(printtype,text,line,start,grid);
				}
				else{
					String[] c5text=new String[5];
					turnc5text(c5text,text);
					for(int i=0;i<c5text.length;i++) {
						if(line+i<61)
						printc5(printtype,c5text[i],line+i,start,grid);
					}
				}
				str=br.readLine();
			}
			printgrid(grid);
			str=br.readLine();
		}
		
	}
	private static void turnc5text(String[] c5text,String text){
		for(int i=0;i<c5text.length;i++) {
			c5text[i]="";
			for(char c:text.toCharArray()) {
				if(c==' ')
					c5text[i]+=C5[26][i];
				else
				c5text[i]+=C5[c-'A'][i];
			}
		}
	}
	private static void print(String printtype,String text, int line,int p_start, char[][] grid){
		if(printtype.equals(".C")) {
			int start=30-text.length()/2;		
			for(int i=start,k=0;k<text.length()&&i<60;i++,k++){
				if(i>=0) {
					if(text.charAt(k)!=' '){						
							grid[line-1][i]=text.charAt(k);
					}
				}
			}
		}
		else if(printtype.equals(".R")) {
			for(int i=59,k=text.length()-1;i>=0&&k>=0;i--,k--) {	
				if(text.charAt(k)!=' ')
					grid[line-1][i]=text.charAt(k);
			}
		}
		else if(printtype.equals(".L")) {
			for(int i=0;i<60&&i<text.length();i++)
				if(text.charAt(i)!=' ')
					grid[line-1][i]=text.charAt(i);
		}
		else if(printtype.equals(".P")){
			for(int i=0;p_start+i<60&&i<text.length();i++) {
				if(text.charAt(i)!=' ')
					grid[line-1][p_start+i]=text.charAt(i);
			}
		}
	}
	static void printc5(String printtype,String text, int line,int p_start, char[][] grid){
		if(printtype.equals(".C")) {
			int start=30-text.length()/2;		
			for(int i=start,k=0;k<text.length()&&i<60;i++,k++){
				if(i>=0) {
					if(text.charAt(k)=='*'){						
							grid[line-1][i]=text.charAt(k);
					}
				}
			}
		}
		else if(printtype.equals(".R")) {
			for(int i=59,k=text.length()-1;i>=0&&k>=0;i--,k--) {	
				if(text.charAt(k)=='*')	
					grid[line-1][i]=text.charAt(k);
			}
		}
		else if(printtype.equals(".L")) {
			for(int i=0;i<60&&i<text.length();i++)
				if(text.charAt(i)=='*')
					grid[line-1][i]=text.charAt(i);
		}
		else if(printtype.equals(".P")){
			for(int i=0;p_start+i<60&&i<text.length();i++) {
				if(text.charAt(i)=='*')
					grid[line-1][p_start+i]=text.charAt(i);
			}
		}
	}
	private static void printgrid(char[][] grid) {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<grid.length;i++) {
			for(int x=0;x<grid[i].length;x++) {
				sb.append(grid[i][x]);
			}	
			sb.append("\n");
		}
		sb.append("\n------------------------------------------------------------\n\n");
		
		System.out.print(sb);
		
	}

}
