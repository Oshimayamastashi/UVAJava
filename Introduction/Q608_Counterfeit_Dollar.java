package Introduction;
import java.util.Scanner;

public class Q608_Counterfeit_Dollar {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int case_num=input.nextInt();
		input.nextLine();
		while(case_num-->0){
			int[] coin=new int[12];
			String[] str1=input.nextLine().split(" ");
			String[] str2=input.nextLine().split(" ");
			String[] str3=input.nextLine().split(" ");
			
							
			for(int x=0;x<12;x++){
				clear(coin);
				coin[x]=0;
				if(test(str1,coin)){
					if(test(str2,coin)){
						if(test(str3,coin)){
							output(coin);
							break;
						}
					}
				}				
			}
			
			for(int x=0;x<12;x++){
				clear(coin);
				coin[x]=2;
				if(test(str1,coin)){
					if(test(str2,coin)){
						if(test(str3,coin)){
							output(coin);
							break;
						}
					}
				}				
			}
		}
		input.close();
	}

	private static void output(int[] coin) {
		for(int i=0;i<12;i++){
			if(coin[i]!=1){
				if(coin[i]==0)
					System.out.println((char)('A'+i)+" is the counterfeit coin and it is light.");
				else
					System.out.println((char)('A'+i)+" is the counterfeit coin and it is heavy.");
			}
		}
		
	}

	private static void clear(int[] coin) {
		for(int i=0;i<coin.length;i++){
			coin[i]=1;
		}		
	}

	private static boolean test(String[] str, int[] coin) {
		int left=0;
		for(int i=0;i<str[0].length();i++){
			left+=coin[str[0].charAt(i)-'A'];
		}
		int right=0;
		for(int i=0;i<str[1].length();i++){
			right+=coin[str[1].charAt(i)-'A'];
		}
		boolean status=false;
		
		switch(str[2]){
		case "even":
			if(right==left)
				status=true;
			break;
		case "up":
			if(right<left)
				status=true;
			break;
		case "down":
			if(right>left)
				status=true;
			break;
		}
		
		return status;
	}
}
