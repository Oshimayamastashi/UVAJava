package Introduction;
import java.util.Scanner;

public class Q462_Bridge_Hand_Evaluator {
	static public void main(String[] args){
		Scanner input=new Scanner(System.in);
		while(input.hasNext()){
			int point=0;
			int[][] card=new int[4][13];
			int[] stop_list=new int[4];
			for(int i=0;i<13;i++){
				String str=input.next();
				card[getsuit(str.charAt(1))][getvalue(str.charAt(0))-1]=1;
				point+=countPoint1(getvalue(str.charAt(0)));				
			}			
			point+=countPoint2to4(card,stop_list);
			int point123=point;	
			point+=countPoint5to7(card);
			if(point123>=16&&notrumpcheck(stop_list))
				System.out.println("BID NO-TRUMP");
			else if(point>=14){
				System.out.print("BID ");
				switch(mostcard(card)){
				case 0:
					System.out.println("S");
					break;
				case 1:
					System.out.println("H");
					break;
				case 2:
					System.out.println("D");
					break;
				case 3:
					System.out.println("C");
					break;
				}				
			}
			else{
				System.out.println("PASS");
			}
		}
	} 
	
	static int getvalue(char c){
		if(c=='K')
			return 13;
		else if(c=='Q')
			return 12;
		else if(c=='J')
			return 11;
		else if(c=='A')
			return 1;
		else if(c=='T')
			return 10;
		else {
			return c-'0';
		}
	}
	
	static int getsuit(char c){
		if(c=='S')
			return 0;
		else if(c=='H')
			return 1;
		else if(c=='D')
			return 2;
		else if(c=='C')
			return 3;
		else 
			return -1;
	}	
	
	static boolean notrumpcheck(int[] stop_list){
		for(int i=0;i<4;i++){
			if(stop_list[i]==0)
				return false;
		}
		return true;
	}
	
	static int countPoint1(int card){
		if(card==13)
			return 3;
		else if(card==12)
			return 2;
		else if(card==11)
			return 1;
		else if(card==1)
			return 4;
		else
			return 0;
	}
	
	static int countPoint2to4(int[][] card,int[] stop_list){
		int point=0;
		for(int i=0;i<4;i++){
			if(card[i][12]==1){
				if(other_num(card[i])==0)
					point--;
			}				
			if(card[i][11]==1){
				if(other_num(card[i])<=1)
					point--;
			}
			if(card[i][10]==1){
				if(other_num(card[i])<=2)
					point--;
			}	
			if(isstop(card[i])){
				stop_list[i]=1;
			}
		}
		return point;
	}
	
	static int countPoint5to7(int[][] card){
		int point=0;
		for(int i=0;i<4;i++){
			if(other_num(card[i])+1==2)
				point++;
			else if(other_num(card[i])+1==1)
				point+=2;
			else if(other_num(card[i])+1==0)
				point+=2;
		}
		return point;
	}
	static boolean isstop(int card[]){
		if(card[12]==1){
			if(other_num(card)>0)
				return true;
		}				
		if(card[11]==1){
			if(other_num(card)>1)
				return true;
		}
		if(card[0]==1){
			return true;
		}
		return false;
		
	}
	
	static int other_num(int[] card){
		int num=0;
		for(int i=0;i<card.length;i++){			
			if(card[i]==1){				
				num++;
			}		
		}
		return num-1;
	}
	
	static int mostcard(int[][] card){
		int most=0;
		int b=0;
		for(int x=0;x<4;x++){
			
			int a=0;
			for(int i=0;i<13;i++){
				if(card[x][i]==1)
					a++;
			}			
			if(a>b){
				most=x;
				b=a;
			}			
		}
		return most;
		
	}
	
}
