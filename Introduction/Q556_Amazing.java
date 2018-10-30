package Introduction;
import java.awt.SystemColor;
import java.util.Scanner;

public class Q556_Amazing {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int col=input.nextInt();
		int row=input.nextInt();
		
		while(col!=0||row!=0){
			/**/
			input.nextLine();
			int[][] maze=new int[col+2][row+2];
			for(int i=0;i<col+2;i++){
				for(int x=0;x<row+2;x++){
					maze[i][x]=-1;
				}
			}			
			for(int i=0;i<col;i++){
				String s=input.nextLine();
				for(int x=0;x<row;x++){
					if(s.charAt(x)-48==0)
						maze[i+1][x+1]=0;
					else
						maze[i+1][x+1]=-1;
				}				
			}
			int start_y=col,start_x=1;
			maze[start_y][start_x]=-1;
			int dir=1;
			int[] num=new int[5];
			gopuzzle(start_x,start_y,maze,dir);
			//printmaze(maze);
			for(int i=0;i<col+2;i++){
				for(int x=0;x<row+2;x++){
					if(maze[i][x]>=0)
						num[maze[i][x]]++;
					
				}
			}
			for(int i=0;i<5;i++){
				
				if(num[i]>99)
					System.out.print(num[i]);
				else if(num[i]>9)
					System.out.print(" "+num[i]);
				else 
					System.out.print("  "+num[i]);
			}
			System.out.println();
			/*-----------------------------*/
			col=input.nextInt();
			row=input.nextInt();
		}
				

	}
	
	private static int pow(int i, int j) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void gopuzzle(int x,int y,int[][] maze,int dir){
		boolean status= hasright(maze,dir,x,y);
		if(maze[maze.length-2][1]==1){				
		}
		else if(status){			
			while(!hasroad(maze,dir,x,y)){
				dir=turnlift(dir);				
			}			
			maze[y][x]++;
			switch(dir){
				case 1:		
					x++;
					break;
				case 2:
					y--;				
					break;
				case 3:			
					x--;
					break;
				case 4:
					y++;				
					break;	
				}						
			gopuzzle(x,y,maze,dir);				
			
		}
		else{			
			dir=turnright(dir);
			maze[y][x]++;	
			switch(dir){
				case 1:		
					x++;
					break;
				case 2:
					y--;				
					break;
				case 3:			
					x--;
					break;
				case 4:
					y++;				
					break;	
			}										
			gopuzzle(x,y,maze,dir);
			
			
		}
		
	}


	private static int turnlift(int dir) {		
		dir++;
		if(dir>4)
			dir%=4;
		
		return dir;
	}
	
	private static int turnright(int dir) {		
		dir--;
		if(dir==0)
			dir=4;
		
		return dir;
	}
	
	private static boolean hasroad(int[][] maze, int dir,int x,int y) {	//右方有牆	
		switch(dir){
		case 1:
			if(maze[y][x+1]!=-1)				
				return true;
			else
				return false;
		case 2:
			if(maze[y-1][x]!=-1)
				return true;
			else
				return false;
		case 3:
			if(maze[y][x-1]!=-1)
				return true;
			else
				return false;
		case 4:
			if(maze[y+1][x]!=-1)
				return true;
			else
				return false;		
		}
		return false;
	}
	
	private static boolean hasright(int[][] maze, int dir,int x,int y) {	//右方有牆	
		switch(dir){
		case 1:
			if(maze[y+1][x]==-1)
				return true;
			break;
		case 2:
			if(maze[y][x+1]==-1)
				return true;
			break;
		case 3:
			if(maze[y-1][x]==-1)
				return true;
			break;
		case 4:
			if(maze[y][x-1]==-1)
				return true;
			break;
		
		}
		return false;
	}

	public static void printmaze(int[][] maze) {
		for(int i=1;i<maze.length-1;i++){
			for(int x=1;x<maze[0].length-1;x++){
				System.out.printf("%2d ",maze[i][x]);
			}
			System.out.println();
		}
		System.out.println();
	}

}
