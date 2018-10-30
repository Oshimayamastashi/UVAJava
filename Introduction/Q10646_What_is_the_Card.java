package Introduction;
import java.util.Arrays;
import java.util.Scanner;

public class Q10646_What_is_the_Card {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int case_num=input.nextInt();
		for(int i=1;i<=case_num;i++){
			
			String[] card=new String[52];
			int a=52;
			for(int x=0;x<52;x++){
				card[x]=input.next();				
			}
			//System.out.println(Arrays.toString(card));
			int Y=0;
			int start=0;
			int X=getvalue(card[start].charAt(0));
			int time=3;
			while(time-->0){
				Y+=X;
				takeaway(card,start,11-X);
				X=getvalue(card[start].charAt(0));
			}
			System.out.println("Case "+i+": "+card[Y-1]);
		
		}
	}
	
	static int getvalue(char c){
		if(c=='A'||c=='K'||c=='Q'||c=='J'||c=='T'){
			return 10;
		}
		else{
			return c-'0';
		}
	}
	
	static void takeaway(String[] card,int start,int num){
		int a=52-num;
		
		for(int i=start;i<a;i++){
			card[i]=card[i+num];
		}		
		//System.out.println(Arrays.toString(card));
	}
}
