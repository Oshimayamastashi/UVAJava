package Data_Structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q11988_Broken_Keyboard {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str;
		while((str=br.readLine())!=null && str.length()!=0){		
			LinkedList<Character> ls=new LinkedList<>();
			int index=0;
			for(char c:str.toCharArray()){				
				if(c=='['){
					index=0;
					continue;
				}			
				else if(c==']'){
					index=ls.size();
					continue;
				}
				ls.add(index,c);
				index++;				
			}
			StringBuilder sb=new StringBuilder();
			for (char c : ls) sb.append(c);
			System.out.println(sb);
		}
	}
			
	
}
