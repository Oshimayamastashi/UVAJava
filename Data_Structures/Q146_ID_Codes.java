package Data_Structures;

import java.io.*;
import java.util.Arrays;

public class Q146_ID_Codes {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String word;
		while(!(word=br.readLine()).equals("#")){
			nextword(word);
		}
	}

	private static void nextword(String word) {
		char[] arr=word.toCharArray();
		int i=arr.length-2;
		for(;i>=0;i--){
			if(arr[i]<arr[i+1])
				break;
		}		
		if(i==-1)
			System.out.println("No Successor");
		else {
			int l=arr.length-1;
			while (arr[i]>=arr[l])
				l--;
			swap(arr,i,l);
			
			char[]a=new char[arr.length-i-1];
			for(int s=0;s<a.length;s++){
				a[s]=arr[i+1+s];
			}
			Arrays.sort(a);
			for(int s=0;s<a.length;s++){
				arr[i+1+s]=a[s];
			}
			
			System.out.println(String.valueOf(arr));
		}
		
	}

	private static void swap(char[] arr, int i, int j) {
		char c=arr[i];
		arr[i]=arr[j];
		arr[j]=c;
	}
}
