package Introduction;
import java.util.Arrays;
import java.util.Scanner;

public class Q10189_Minesweeper {
	public static void main(String[] args) {		
		Scanner input = new Scanner(System.in);
		int a=1;
		int row=input.nextInt();
		int col=input.nextInt();
		while(row!=0){			
			int[][]map=new int[row][col];
			
			for(int i=0;i<row;i++){
				String str=input.next();			
				for(int x=0;x<col;x++){
					if(str.charAt(x)=='*'){
						map[i][x]=-99;
						if(x+1<col)
							map[i][x+1]++;
						if(x-1>=0)
							map[i][x-1]++;
						if(i+1<row)
							map[i+1][x]++;
						if(i-1>=0)
							map[i-1][x]++;					
						if(x+1<col&&i+1<row)
							map[i+1][x+1]++;
						if(x-1>=0&&i+1<row)
							map[i+1][x-1]++;
						if(i-1>=0&&x+1<col)
							map[i-1][x+1]++;
						if(i-1>=0&&x-1>=0)
							map[i-1][x-1]++;
					}
				}
			}
			if(a!=1){
			System.out.println();
			}
			System.out.println("Field #"+a+":");
			a++;
			for(int i=0;i<row;i++){
				for(int x=0;x<col;x++){
					if(map[i][x]>=0){
						System.out.print(map[i][x]);
					}
					else
						System.out.print("*");
				}
				System.out.println();
			}
			
			
			row=input.nextInt();
			col=input.nextInt();
		}
		
		
	}
}
