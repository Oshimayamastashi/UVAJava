package Introduction;
import java.util.Arrays;
import java.util.Scanner;

public class Q10284_Chessboard_in_FEN {
	public static void main(String [] args){		
		Scanner input=new Scanner(System.in);
		while(input.hasNext()){
			int[][] chess=new int[8][8];		
			String str=input.nextLine();
			readmap(chess,str);
			
			for(int i=0;i<8;i++)
				for(int x=0;x<8;x++){					
					switch(chess[i][x]){
					
					case 1:
						caseP(chess,x,i);
						
						break;
					case 2:
						casep(chess,x,i);
						
						break;
					case 3:
						caseN(chess,x,i);
						
						break;
					case 4:
						caseB(chess,x,i);
						
						break;
					case 5:case 'r':
						caseR(chess,x,i);	
						
						break;
					case 6:
						caseQ(chess,x,i);
						
						break;
					case 7:
						caseK(chess,x,i);
						
						break;
					}
				}
			int a=0;
			for(int i=0;i<8;i++){
				for(int x=0;x<8;x++)
					if(chess[i][x]==0){
						a++;	
					}
			}
			System.out.println(a);			
		}
	}
	static void readmap(int[][]chessbroad,String str){
		int x=0,y=0;
		for(int num=0;num<str.length();num++){			
			switch(str.charAt(num)){
			case 'P':{		
				chessbroad[y][x]=1;
				x++;
			}
				break;
			case 'p':{
				chessbroad[y][x]=2;				
				x++;
			}
				break;
			case 'N':
			case 'n':{
				chessbroad[y][x]=3;	
				x++;
			}
				break;
			case 'B':
			case 'b':{
				chessbroad[y][x]=4;	
				x++;
			}
				break;
			case 'R':
			case 'r':{	
				chessbroad[y][x]=5;	
				x++;
			}
				break;
			case 'Q':
			case 'q':{
				chessbroad[y][x]=6;	
				x++;
			}
				break;
			case 'K':
			case 'k':{
				chessbroad[y][x]=7;	
				x++;
			}
				break;
			case '/':
				x=0;
				y++;
				break;
			default:{
				int a=str.charAt(num)-'0';
				for(int i=0;i<a;i++)
					x++;
				}
			}
		}
	}
	static void caseR(int[][] chess,int x,int y){
		int z;
		//右
		for(z=1;x+z<8;z++){		
			if(chess[y][x+z]<1)
				chess[y][x+z]=-1;
			else
				break;
		}
		//左
		for(z=1;x-z>=0;z++){
			if(chess[y][x-z]<1)
				chess[y][x-z]=-1;
			else
				break;			
		}
		//前
		for(z=1;y+z<8;z++){
			if(chess[y+z][x]<1)
				chess[y+z][x]=-1;
			else
				break;
		}
		//後
		for(z=1;y-z>=0;z++){
			if(chess[y-z][x]<1)
				chess[y-z][x]=-1;
			else
				break;
		}
	}
	static void caseP(int[][] chess,int x,int y){		
		if(y-1>=0&&x+1<8&&chess[y-1][x+1]==0){
			chess[y-1][x+1]=-1;					
		}
		if(y-1>=0&&x-1>=0&&chess[y-1][x-1]==0)
			chess[y-1][x-1]=-1;
	}
	static void casep(int[][] chess,int x,int y){
		if(y+1<8&&x+1<8&&chess[y+1][x+1]==0)
			chess[y+1][x+1]=-1;		
		if(y+1<8&&x-1>=0&&chess[y+1][x-1]==0)
			chess[y+1][x-1]=-1;
	}
	static void caseK(int[][] chess,int x,int y){
		caseP(chess,x,y);
		casep(chess,x,y);
		if(x+1<8&&chess[y][x+1]==0)
			chess[y][x+1]=-1;
		if(x-1>=0&&chess[y][x-1]==0)
			chess[y][x-1]=-1;
		if(y+1<8&&chess[y+1][x]==0)	
			chess[y+1][x]=-1;
		if(y-1>=0&&chess[y-1][x]==0)
			chess[y-1][x]=-1;
	}
	static void caseB(int[][] chess,int x,int y){
		int z;
		//右下
		for(z=1;x+z<8&&y+z<8;z++){		
			if(chess[y+z][x+z]<1)
				chess[y+z][x+z]=-1;
			else
				break;
		}
		//左下
		for(z=1;x-z>=0&&y+z<8;z++){			
			if(chess[y+z][x-z]<1){
				chess[y+z][x-z]=-1;
			}
			else
				break;			
		}
		//右上
		for(z=1;x+z<8&&y-z>=0;z++){
			if(chess[y-z][x+z]<1)
				chess[y-z][x+z]=-1;
			else
				break;
		}
		//左上
		for(z=1;y-z>=0&&x-z>=0;z++){
			if(chess[y-z][x-z]<1){				
				chess[y-z][x-z]=-1;
			}
			else
				break;
		}
	}
	static void caseQ(int[][] chess,int x,int y){
		caseR(chess,x,y);
		caseB(chess,x,y);
	}
	static void caseN(int[][] chess,int x,int y){
		//右下
		if(y+1<8&&x+2<8&&chess[y+1][x+2]==0){
			chess[y+1][x+2]=-1;					
		}
		if(y+2<8&&x+1<8&&chess[y+2][x+1]==0){
			chess[y+2][x+1]=-1;					
		}
		//左上
		if(y-1>=0&&x-2>=0&&chess[y-1][x-2]==0)
			chess[y-1][x-2]=-1;
		if(y-2>=0&&x-1>=0&&chess[y-2][x-1]==0)
			chess[y-2][x-1]=-1;
		//左下
		if(y+1<8&&x-2>=0&&chess[y+1][x-2]==0){
			chess[y+1][x-2]=-1;					
		}
		if(y+2<8&&x-1>=0&&chess[y+2][x-1]==0){
			chess[y+2][x-1]=-1;					
		}
		//右上
		if(y-1>=0&&x+2<8&&chess[y-1][x+2]==0)
			chess[y-1][x+2]=-1;
		if(y-2>=0&&x+1<8&&chess[y-2][x+1]==0)
			chess[y-2][x+1]=-1;
	}
	static void printmap(int[][] chess){
		for(int i=0;i<8;i++){
			for(int x=0;x<8;x++){
				System.out.printf("%2d ",chess[i][x]);}
		System.out.println();
		}
		System.out.println();
	}
}
