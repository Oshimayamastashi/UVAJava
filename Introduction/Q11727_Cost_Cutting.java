package Introduction;
import java.util.Scanner;

public class Q11727_Cost_Cutting {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int input_num=input.nextInt();	
		for(int i=0;i<input_num;i++){
			int salary_1=input.nextInt();
			int salary_2=input.nextInt();
			int salary_3=input.nextInt();
			
			System.out.print("Case "+(i+1)+": ");
			System.out.println(find_mid(salary_1,salary_2,salary_3));
		}
		
	}
	public static int find_mid(int a,int b,int c){
		if(a>b){	
			if(c>a)
				return a;
			else if(c>b)
				return c;
			else
				return b;
		}
		else{
			if(c>b)
				return b;
			else if(a>c)
				return a;
			else
				return c;
		}
	}
	
}
