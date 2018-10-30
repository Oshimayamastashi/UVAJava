package Introduction;
import java.util.Scanner;

public class Q401_Palindromes {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		while(input.hasNext()){
			String str=input.nextLine();
			if(isPalindrome(str)){
				if(ismirror(str)){
					System.out.println(str+" -- is a mirrored palindrome.\n");
				}
				else{
					System.out.println(str+" -- is a regular palindrome.\n");	
				}
			}
			else{
				if(ismirror(str)){
					System.out.println(str+" -- is a mirrored string.\n");			
				}
				else{
					System.out.println(str+" -- is not a palindrome.\n");
				}
			}
		}

	}

	private static boolean ismirror(String str) {
		char[] reverse1={'A','M','Y','Z','O','1','2','E','3','S','5','H','T','I','U','J','V','8','W','L','X'};
		char[] reverse2={'A','M','Y','5','O','1','S','3','E','2','Z','H','T','I','U','L','V','8','W','J','X'};
		int length=str.length()-1;
		int k=str.length()/2;
		if(str.length()%2==1){
			k++;
		}
		for(int i=0;i<k;i++){
			int loc=getindex(reverse1,str.charAt(i));			
			if(loc<0)
				return false;
			else if(reverse2[loc]!=str.charAt(length-i))
				return false;
		}
		return true;
	}

	private static int getindex(char[] reverse1,char c) {
		for(int x=0;x<reverse1.length;x++){
			if(c==reverse1[x])
				return x;
		}
		return -1;
	}

	private static boolean isPalindrome(String str){
		int length=str.length()-1;
		for(int i=0;i<str.length()/2;i++){
			if(str.charAt(i)!=str.charAt(length-i)){
				return false;
			}
		}

		return true;
	}

}
