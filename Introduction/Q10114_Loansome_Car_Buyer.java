package Introduction;
import java.util.Arrays;
import java.util.Scanner;

public class Q10114_Loansome_Car_Buyer {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		
		int month=input.nextInt();
		double down_payment=input.nextDouble();
		double loan=input.nextDouble();
		int depreciation_num=input.nextInt();
		while(month>0){
			double[] d_rate=new double[month+1];
			while(depreciation_num-->0){
				int m=input.nextInt();
				double rate=input.nextDouble();
				for(int i=m;i<d_rate.length;i++){
					d_rate[i]=rate;
			}}
			//System.out.println(Arrays.toString(d_rate));		
			double car_value=down_payment+loan;
			double monthpay=loan/month;	
			int ans=0;
			
			car_value*=(1-d_rate[0]);
			for(ans=1;car_value<loan;ans++){
				car_value*=(1-d_rate[ans]);
				loan-=monthpay;
			}
			if(ans==2)
				System.out.println("1 month");
			else
				System.out.println(ans-1+" months");
			month=input.nextInt();
			down_payment=input.nextDouble();
			loan=input.nextDouble();
			depreciation_num=input.nextInt();
		}
	}
}
