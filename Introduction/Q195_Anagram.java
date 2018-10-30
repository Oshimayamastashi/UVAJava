package Introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Q195_Anagram{

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int case_num=Integer.parseInt(br.readLine());
		while(case_num-->0){
			char[] word=br.readLine().toCharArray();			
			sort(word);
			sb.append(String.valueOf(word)+"\n");
			
			while(hasNextPermutation(word)){
				sb.append(String.valueOf(word)+"\n");
			}			
		}
		System.out.print(sb);
	}
	
	private static void sort(char[] word) {
		for(int i=0;i<word.length;i++) {
			for(int x=0;x<word.length-i-1;x++) {
				if(compare(word[x],word[x+1])>0){
					swap(word,x,x+1);					
				}
			}
		}		
	}

	private static boolean hasNextPermutation(char[] sw) {
		if (sw.length == 1)
			return false;
		int k;
		// find largest k such that sw[k] < sw[k+1]
		for (k = sw.length - 2; k >= 0; k--)
			if (compare(sw[k],sw[k+1])< 0) {					
				break;
			}

		if (k == -1) {
			return false;
		}

		int l = sw.length - 1;
		// find the largest l such that sw[k] < sw[l]
		while (compare(sw[k],sw[l]) >= 0)
			l--;

		// swap the contents of sw[k] and sw[l]
		swap(sw,k,l);

		// reverse the sequence from k+1 to n
		for (int i = k + 1, j = sw.length - 1; i < j; i++, j--)
			swap(sw,i,j);

		return true;
	}

	private static void swap(char[] sw,int a,int b) {
		char c = sw[a];
		sw[a] = sw[b];
		sw[b] = c;
	}
	
	private static int compare(char c1,char c2){
		if(Math.abs(c1-c2)=='a'-'A'){
			return c1-c2;
		}
		else {
			return lower(c1)-lower(c2);
		}
	}
	
	private static char lower(char c){
		if(c>='A'&&c<='Z'){
			return (char) (c-'A'+'a');
		}
		else 
			return c;
	}

}
