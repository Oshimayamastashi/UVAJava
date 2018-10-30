package Introduction;
import java.util.ArrayList;
import java.util.Scanner;

public class Q10920_Spiral_Tap {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);		
		
		long n=input.nextInt();
		long target=input.nextLong();
		while(n!=0){
			long begin=0;
			long middle=(n+1)/2;
			
			for(long i=0;Math.pow(2*i+1,2)<target;i++){
			begin=i;
			}
			
			long move=2*(begin+1);
			long over=(target-(long)Math.pow(2*begin+1,2));	
			long x=middle+begin;
			long y=middle+begin;
			if(over>0){
				x=middle+begin;
				y=middle+begin+1;
				
				if(over>move){			
					x=x-move+1;
					over-=move;				
					if(over>move){
						y=y-move;
						over-=move;
						if(over>move){
							x=x+move;
							over-=move;
							y=y+over;
						}
						else{
							x=x+over;
						}
					}
					else{
						y=y-over;
					}			
				}
				else{
					x=x-over+1;
				}
			}
			System.out.println("Line = "+y+", column = "+x+".");
			
			n=input.nextInt();
			target=input.nextInt();
		}
	}

}
