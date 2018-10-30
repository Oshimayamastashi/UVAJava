package Introduction;
import java.util.Scanner;

public class Q10813_Traditional_BINGO {
	static Scanner input=new Scanner(System.in);	
	public static void main(String[] args){			
		int case_num=input.nextInt();		
		while(case_num-->0){
			int[][] puzzle=new int[5][5];
			readpuzzle(puzzle);
			//printpuzzle(puzzle);
			
			int roll=75; 
			while(roll-->0){
				int ball=input.nextInt();
				mark(ball,puzzle);
				//printpuzzle(puzzle);
				if(bingo(puzzle)){
					System.out.println("BINGO after "+(75-roll)+" numbers announced");
					while(roll-->0){
						input.nextInt();
					}
				}			
			}
		}
	}

	private static void mark(int ball, int[][] puzzle) {
		for(int i=0;i<5;i++)
			for(int x=0;x<5;x++){
				if(puzzle[i][x]==ball){
					puzzle[i][x]=-1;
					break;
				}
			}
		
	}

	private static boolean bingo(int[][] puzzle) {
		//¾î
		for(int i=0;i<5;i++){
			boolean status=true;
			for(int x:puzzle[i]){
				if(x!=-1){
					status=false;
					break;
				}
			}
			if(status){
				return true;
			}
		}
		//ª½
		for(int i=0;i<5;i++){
			boolean status=true;
			for(int x=0;x<5;x++){
				if(puzzle[x][i]!=-1){
					status=false;
					break;
				}
			}
			if(status){
				return true;
			}
		}
		//¹ï¨¤½u
		boolean status=true;
		for(int i=0;i<5;i++){			
			if(puzzle[i][i]!=-1){
				status=false;
				break;
			}			
		}
		if(status){
			return true;
		}
		
		status=true;
		for(int i=0;i<5;i++){			
			if(puzzle[i][4-i]!=-1){
				status=false;
				break;
			}			
		}
		if(status){
			return true;
		}		
		return false;
	}

	private static void printpuzzle(int[][] puzzle) {
		for(int i=0;i<5;i++){
			for(int x:puzzle[i]){
				System.out.print(x+" ");
			}
			System.out.println();
		}
		
	}

	private static void readpuzzle(int[][] puzzle) {		
		for(int i=0;i<5;i++)
			for(int x=0;x<5;x++){
				if(x==2&&i==2){
					puzzle[i][x]=-1;
					x++;					
				}
				puzzle[i][x]=input.nextInt();
			}
	}
	
	
	
}
