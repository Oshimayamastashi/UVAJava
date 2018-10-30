package Introduction;
import java.util.Scanner;

public class Q11799_Horror_Dash {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int input_num=input.nextInt();	
		for(int i=0;i<input_num;i++){
			int stu_num=input.nextInt();
			int max=0;
			for(int x=0;x<stu_num;x++){
				int next=input.nextInt();
				if(max<next)
					max=next;				
			}
			System.out.println("Case "+(i+1)+": "+max);
		}
		input.close();
	}
}
