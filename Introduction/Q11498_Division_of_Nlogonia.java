package Introduction;
import java.util.Scanner;

public class Q11498_Division_of_Nlogonia {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int input_num=input.nextInt();	
		while(input_num!=0){
			int d_p_x=input.nextInt();
			int d_p_y=input.nextInt();
			for(int i=0;i<input_num;i++){
				int r_x=input.nextInt();
				int r_y=input.nextInt();
				residence_location(r_x,r_y,d_p_x,d_p_y);
			}
			input_num=input.nextInt();
		}
		
	}
	
	
	
	public static void residence_location(int x,int y,int d_p_x,int d_p_y){
		if(x==d_p_x||y==d_p_y)
			System.out.println("divisa");
		else if(x>d_p_x&&y>d_p_y)
			System.out.println("NE");
		else if(x<d_p_x&&y>d_p_y)
			System.out.println("NO");
		else if(x<d_p_x&&y<d_p_y)
			System.out.println("SO");
		else if(x>d_p_x&&y<d_p_y)
			System.out.println("SE");
	}
}
