package Introduction;
import java.util.Arrays;
import java.util.Scanner;

public class Q11459_Snakes_and_Ladders {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int case_num=input.nextInt();
		while(case_num-->0){
			int player_num=input.nextInt();
			int snake_num=input.nextInt();
			int die_roll=input.nextInt();
			//System.out.println(player_num+" "+snake_num+" "+die_roll);
			int[] map=new int[101];
			for(int i=1;i<101;i++){
				map[i]=i;
			}
			int[] player=new int[player_num];
			for(int x=0;x<player_num;x++){
				player[x]=1;
			}			
			for(int i=0;i<snake_num;i++){
				int head=input.nextInt();
				int tail=input.nextInt();
				//System.out.println(head+" "+tail);
				map[head]=tail;
			}		
			//System.out.println(Arrays.toString(map));
			for(int i=0;i<die_roll;i++){
				int roll=input.nextInt();
				//System.out.println(roll);
				int position=player[i%player_num]+roll;			
				if(position>100){
					position=100;					
				}				
				player[i%player_num]=map[position];
				if(player[i%player_num]==100){
					for(int x=0;x<(die_roll-i-1);x++)
						input.nextInt();
						
					break;
				}
			}
			for(int x=0;x<player_num;x++)
			System.out.println("Position of player "+(x+1)+" is "+player[x]+".");
		}
	}
}
