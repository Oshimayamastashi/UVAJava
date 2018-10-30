package Introduction;
import java.util.Scanner;

public class Q489_Hangman_Judge {
	static public void main(String[] args){
		Scanner input=new Scanner(System.in);
		int case_num=input.nextInt();
		while(case_num!=-1){
			System.out.println("Round "+case_num);			
			String text=input.next();			
			String guess=input.next();
			guess=reduce(guess);
			int[] scoreboard=new int[text.length()];
			
			int wrong_time=0;
			for(int i=0;i<guess.length();i++){
				boolean status=contain(guess.charAt(i),text,scoreboard);
				if(!status){
					wrong_time++;				
				}
				if(wrong_time==7){
					System.out.println("You lose.");
					break;
				}		
				if(complete(scoreboard)){
					System.out.println("You win.");
					break;
				}
			}
			//System.out.println("guess:"+guess);
			//System.out.println("wrong_time:"+wrong_time);
				
			if(!complete(scoreboard)&&wrong_time<7){
				System.out.println("You chickened out.");
			}
			case_num=input.nextInt();
			
		}		
		
	}
	static boolean contain(char c,String str,int[] scoreboard){
		boolean status=false;
		for(int i=0;i<str.length();i++){
			if(str.charAt(i)==c){
				status=true;
				scoreboard[i]=1;
			}
		}
		return status;
	}
	static boolean complete(int[] scoreboard){
		for(int i=0;i<scoreboard.length;i++){
			if(scoreboard[i]==0)
				return false;
		}
		return true;
	}
	static String reduce(String str){
		String guesschar="";
		for(int i=0;i<str.length();i++)
		if(guesschar.contains(String.valueOf(str.charAt(i)))){			
			}
		else
			guesschar+=str.charAt(i);
		
		return guesschar;
	}
}
