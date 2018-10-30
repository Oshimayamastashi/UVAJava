package Data_Structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q10107_What_is_the_Median {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Long> ls=new ArrayList<Long>();
		String str;
		while((str=br.readLine())!=null&&str.length()!=0){
			long num=Long.parseLong(new StringTokenizer(str).nextToken());
			ls.add(num);			
			Collections.sort(ls);
			int s=ls.size();
			if(s%2==1){
				System.out.println(ls.get(ls.size()/2));
			}
			else{
				System.out.println((ls.get(ls.size()/2)+ls.get((ls.size()/2)-1))/2);
			}
		}
	}
}
