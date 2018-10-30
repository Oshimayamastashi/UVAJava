package Introduction;
import java.util.Scanner;

public class Q12060_All_Integer_Average {

	public static void main(String[] args) {
			Scanner input=new Scanner(System.in);			
			int num=input.nextInt();
			int a=1;
			while(num!=0){
				double sum=0;
				int i=num;
				while(i-->0){
					sum+=input.nextInt();
				}
				
				/*--------------------------------------------*/
				System.out.println("Case "+a+":");
				answer(sum,num);
				num=input.nextInt();
				a++;
			}

	}
	public static int findgcd(int a,int b){
		int temp;
		int divid=b;
		while(a!=0){
			divid=divid%a;
			temp=divid;
			divid=a;
			a=temp;
		}
		return divid;
	}
	
	public static void answer(double sum,int num){
		int top_part=Math.abs((int) (sum%num));		
		int integer_part=(int) (sum/num);		
		int gcd=findgcd(top_part,num);
		top_part/=gcd;
		num/=gcd;
		int bar_num=(int) Math.log10(num);
		int but_space;
		if(Math.abs(integer_part)>=1)
			but_space= (int) Math.log10(Math.abs(integer_part));		
		else
			but_space=-1;		
		int top_space=but_space+((int)Math.log10(num)-(int)Math.log10(top_part));
		if(sum<0){
			but_space+=2;
			top_space+=2;
		}
				
		if(top_part!=0){	
			while(top_space-->=0)
				System.out.print(" ");
			System.out.println(top_part);
		}
		if(sum<0){
			System.out.print("- ");
		}
		if(integer_part!=0){
			System.out.print(Math.abs(integer_part));			
		}else if(top_part ==0){
			System.out.print("0");
		}		
		if(top_part!=0){
			while(bar_num-->=0){
				System.out.print("-");
			}	
		}
		System.out.println();
		if(top_part!=0){
			while(but_space-->=0)
				System.out.print(" ");
			System.out.println(num);		
		}
		
		
	}

}
