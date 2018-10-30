package Introduction;
import java.util.Scanner;

public class Q10141_Request_for_Proposal {
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		
		int requirement=input.nextInt();
		int proposal_num=input.nextInt();
		//System.out.println(proposal_num);
		for(int count=1;requirement!=0;count++){
			input.nextLine();
			for(int i=0;i<requirement;i++){
				input.nextLine();
				}				
			int best_met=0,a;
			String best_name="",str;
			double best_price=9999999,p;
			for(int i=0;i<proposal_num;i++){					
				str=input.nextLine();				
				p=input.nextDouble();
				a=input.nextInt();
				input.nextLine();
				for(int x=0;x<a;x++){
					input.nextLine();
				}
				if(best_met<a){					
					best_met=a;
					best_price=p;
					best_name=str;
				}
				else if(best_met==a&&best_price>p){
					best_met=a;
					best_price=p;
					best_name=str;
				}
			}
				
			if(count>1){
					System.out.println();
			}
			System.out.println("RFP #"+count);
			System.out.println(best_name);					
			requirement=input.nextInt();
			proposal_num=input.nextInt();
		}	
	}
}
