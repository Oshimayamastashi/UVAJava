package Introduction;
import java.util.Arrays;
import java.util.Scanner;

public class Q12247_Jollo {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int a=input.nextInt();
		while(a!=0){
			int[] prince=new int[2];
			int[] princess=new int[3];
			int[] card=new int[53];
			princess[0]=a;
			card[a]=1;
			for(int i=1;i<3;i++){
				princess[i]=input.nextInt();
				card[princess[i]]=1;
			}
			for(int i=0;i<2;i++){
				prince[i]=input.nextInt();
				card[prince[i]]=1;
			}			
			Arrays.sort(prince);
			Arrays.sort(princess);			
			int success=0;
			for(int i=0;i<3;i++){
				for(int x=0;x<2;x++){
					if(princess[i]>prince[x]){						
						success++;
						prince[x]=53;
						princess[i]=-1;
						break;
					}
				}
			}
			//System.out.println(Arrays.toString(princess));
			Arrays.sort(princess);					
			
			if(success==2){
				System.out.println(-1);
			}
			else if(success==1){
				int k=princess[2];
				while(card[k]==1){
					if(k<52)
						k++;				
					else{
						k=-1;
						break;
					}
				}
				System.out.println(k);
			}
			else{
				int small=1;
				while(card[small]==1){
					small++;
				}
				System.out.println(small);
			}
			
			a=input.nextInt();
		}
	}
}
