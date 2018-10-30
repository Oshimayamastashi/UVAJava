package Introduction;
import java.util.Scanner;

public class Q11559_Event_Planning {
	public static void main(String[] args){
		
		Scanner input=new Scanner(System.in);
		while(input.hasNextInt()){
			int part_num=input.nextInt();
			int budget=input.nextInt();
			int hotel_num=input.nextInt();
			int week_num=input.nextInt();
			
			int mincost=999999;		
			for(int i=0;i<hotel_num;i++){
				int cost=input.nextInt();					
				for(int x=0;x<week_num;x++){
					int freespace=input.nextInt();	
					if(freespace>=part_num&&mincost>=part_num*cost)
					{
						mincost=part_num*cost;
					}						
				}				
			}
			if(budget>=mincost)
				System.out.println(mincost);
			else
				System.out.println("stay home");
		}
	}
	

}
