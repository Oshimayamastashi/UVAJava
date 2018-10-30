package Introduction;
import java.util.Scanner;

public class Q696_How_Many_Knights {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int col=input.nextInt();
		int row=input.nextInt();
		while(col!=0||row!=0){	
			if(row==0||col==0){
				System.out.print(0);
			}
			else if(row==1||col==1){
				System.out.print(bigger(row,col));
			}
			else if(row==2||col==2){
				int a=bigger(row,col);
				if(a%4==1){
					a=((a/4)*4)+2;
					System.out.print(a);
				}
				else if(a%4==0){
					System.out.print(a);
					
				}
				else{
					a=((a/4)*4)+4;
					System.out.print(a);
				}
			}
			else{
				if(row*col%2==1){
					System.out.print(row*col/2+1);
				}
				else
					System.out.print(row*col/2);					
			}
			System.out.println(" knights may be placed on a "+col+" row "+row+" column board.");
			/*-------------------------------*/
			col=input.nextInt();
			row=input.nextInt();
		}
	}

	private static int bigger(int row, int col) {
		if(row>col)
			return row;
		else
			return col;
		
	}
}
