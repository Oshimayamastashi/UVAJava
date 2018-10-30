package Introduction;
import java.util.Arrays;
import java.util.Scanner;

public class Q11507_Bender_B_Rodriguez_Problem {

	public static void main(String[] args) {
		Scanner input= new Scanner(System.in);
		int L=input.nextInt();
		
		while(L>0){
			int[] total=new int[2];
			for(int i=1;i<L;i++){
				String str=input.next();
				dir(str,total);				
			}
			if(total[0]%2==1){
				if(total[0]==1)
					System.out.print("+");
				else
					System.out.print("-");
				System.out.println("y");
			}
			else if(total[1]%2==1){
				if(total[1]==1)
					System.out.print("+");
				else
					System.out.print("-");	
				System.out.println("z");
			}
			else{
				if((total[1]+total[0])%4==0)
					System.out.println("+x");
				else
					System.out.println("-x");
			}
			L=input.nextInt();
		}
	}
	
	public static void dir(String str,int[] total){
		if(str.equals("+y")){
			if(total[1]==0){
				total[0]++;	
				total[0]=decide(total[0]);
			}
			else if(total[1]==2){
				total[0]--;	
				total[0]=decide(total[0]);
			}
		}
		else if(str.equals("-y")){
			if(total[1]==0){
				total[0]--;	
				total[0]=decide(total[0]);
			}
			else if(total[1]==2){
				total[0]++;	
				total[0]=decide(total[0]);
			}
		}
		else if(str.equals("+z")){
			if(total[0]==0){
				total[1]++;		
				total[1]=decide(total[1]);
			}
			else if(total[0]==2){
				total[1]--;	
				total[1]=decide(total[1]);
			}
		}
		else if(str.equals("-z")){
			if(total[0]==0){
				total[1]--;	
				total[1]=decide(total[1]);
			}
			else if(total[0]==2){
				total[1]++;	
				total[1]=decide(total[1]);
			}	
		}
	}
	public static int decide(int a){		
			a=a%4;
			if(a<0){
				a+=4;
			}
		return a;
		
	}

}
