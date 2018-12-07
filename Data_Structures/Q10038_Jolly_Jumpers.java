package Data_Structures;
import java.util.Scanner;

public class Q10038_Jolly_Jumpers {
	static public void main(String[] args) {
		Scanner input=new Scanner(System.in);
		while(input.hasNext()){			
			int n=input.nextInt();
			int[] ar=new int[n];
			for(int i=0;i<n;i++) {
				ar[i]=input.nextInt();
			}
			int[] map=new int[3000];
			
			for(int i=0;i<ar.length-1;i++){
				int diff=Math.abs(ar[i+1]-ar[i]);
				map[diff]++;
			}			
			//System.out.println(Arrays.toString(map));
		  	boolean status=true;
			for(int i=1;i<n;i++){
				if(map[i]==0){
					status=false;
					break;
				}					
			}
			if(status) {
				System.out.println("Jolly");
			}
			else {
				System.out.println("Not jolly");
			}						
		}		
		input.close();
	} 
}
