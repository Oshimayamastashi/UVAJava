package Introduction;
import java.util.Scanner;

public class Q278_Chess {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int a=input.nextInt();
		while(a-->0){
			String c=input.next();
			int row=input.nextInt();
			int col=input.nextInt();
			int[][] chess=new int[row][col];
			
			switch(c){
			case "r":
			case "Q":
				if(row>col)
					System.out.println(col);
				else
					System.out.println(row);
				break;
			case "k":
				int h=col*row/2;;
				 if(col*row%2==1)
					h++;

				System.out.println(h);
				break;	
			case "K":
				int b=col/2;
					if(col%2==1){
						b++;
					}	
				int d=row/2;
					if(row%2==1){
						d++;
					}
					System.out.println(b*d);
				break;
			}			
		}
	}	
}
