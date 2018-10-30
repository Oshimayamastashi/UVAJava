package Introduction;
import java.util.Scanner;

public class Q11093_Just_Finish_it_up {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int case_num=input.nextInt();
		int a=1;
		while(case_num-->0){
			int gas_num=input.nextInt();			
			int[]gas_available=new int[gas_num];
			for(int i=0;i<gas_num;i++){
				gas_available[i]=input.nextInt();
			}
			int sum=0;
			for(int i=0;i<gas_num;i++){
				int gss=input.nextInt();
				gas_available[i]=gas_available[i]-gss;
				sum+=gas_available[i];
			}
			
			//System.out.println(Arrays.toString(gas_available));
			//System.out.println(Arrays.toString(gas_consume));
			
			boolean status=false;
			if(sum>=0){
				for(int i=0;i<gas_num;i++){
					if(gas_available[i]>=0)
					{
						if(test(gas_num,gas_available,i)){
							System.out.println("Case "+a+": Possible from station "+(i+1));
							status=true;
							break;
						}
					}
				}
			if(!status)
				System.out.println("Case "+a+": Not possible");			
			}
			else
				System.out.println("Case "+a+": Not possible");		
			a++;
		}
		input.close();
	}
	
	public static boolean test(int gas_num,int[]gas_available,int start){
		int car_gas=0;
		for(int i=0;i<gas_num;i++){				
				car_gas+=gas_available[start];
				if(car_gas<0){
					return false;
				}				
				start=(start+1)%gas_num;
			}
		return true;
		}	
		
}
