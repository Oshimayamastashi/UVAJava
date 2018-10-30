package Introduction;
import java.util.Arrays;
import java.util.Scanner;

public class Q11221_Magic_square_palindromes {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int case_num=input.nextInt();
		input.nextLine();
		for(int i=0;i<case_num;i++){
			System.out.println("Case #"+(i+1)+":");
			String str=input.nextLine();
			str=reduce(str);
			int a=(int)Math.sqrt(str.length());
			char[][] square=new char[a][a];
			if(str.length()-a*a>0){
				System.out.println("No magic :(");
			}
			else{
				int k=0; 
				for(int x=0;x<a;x++){
					for(int j=0;j<a;j++){
						square[x][j]=str.charAt(k);
						k++;
					}
				}
				if(checkMagic(square))
					System.out.println(a);
				else
					System.out.println("No magic :(");
			}
		}
	}

	private static boolean checkMagic(char[][] square) {
		String str="",str2="",str3="",str4="";
		for(int x=0;x<square.length;x++){
			for(int j=0;j<square[x].length;j++){
				str+=square[x][j];
				str2+=square[j][x];
			}
		}
		
		
		for(int x=square.length-1;x>=0;x--){
			for(int j=square.length-1;j>=0;j--){
				str3+=square[x][j];
				str4+=square[j][x];
			}
		}
		if(str.equals(str2)&&str4.equals(str3)){
			if(str.equals(str4))
				return true;
		}	
		
		
		return false;
	}

	private static String reduce(String str) {
		String str2="";
		for(int i=0;i<str.length();i++){
			if((int)str.charAt(i)>=97&&(int)str.charAt(i)<=122){
				str2+=str.charAt(i);
			}			
		}
		return str2;
	}
}
