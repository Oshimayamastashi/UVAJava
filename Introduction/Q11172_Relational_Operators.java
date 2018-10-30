package Introduction;
import java.util.Scanner;

public class Q11172_Relational_Operators {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int input_num=input.nextInt();	
		
		for(int i=0;i<input_num;i++){
			int left=input.nextInt();			
			int right=input.nextInt();
			
			if(left<right){
				System.out.println("<");
			}
			else if(left>right){
				System.out.println(">");
			}
			else if(left==right){
				System.out.println("=");
			}
		}	
		
	}
}
