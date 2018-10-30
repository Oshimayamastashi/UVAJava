package Introduction;
import java.util.Scanner;

public class Q10812_Beat_the_Spread {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);	
		 long case_num=input.nextInt();
		while(case_num-->0){
			 long sum=input.nextInt();
			 long diff=input.nextInt();
			if((sum+diff)%2==0){
				 long high=(sum+diff)/2;		
				 long low=high-diff;
				
				if(high>=0&&low>=0)
					System.out.println(high+" "+low);
				else 
					System.out.println("impossible");
			}
			else			
				System.out.println("impossible");
			
		}
		input.close();
	}
}
