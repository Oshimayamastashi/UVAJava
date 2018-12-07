package Data_Structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Q732_Anagrams_by_Stack {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		String word;
		while((word=br.readLine())!=null && word.length()!=0){
			String target=br.readLine();
			sb.append("[\n");
			if(insameana(word,target)){
				Stack<Character> path=new Stack<Character>();
				Stack<Character> stack=new Stack<Character>();
				int cur=0;
				dfs(word,target,path,stack,cur,sb);
			}			
			sb.append("]\n");
					
		}
		System.out.print(sb);
	}
	
	private static void dfs(String word, String target, Stack<Character>path, Stack<Character>stack,int cur,StringBuilder sb) {
		if (cur==target.length()){
			for(int i=0;i<path.size();i++) {
				if(i!=path.size()-1) {
					sb.append(path.get(i)+" ");
				}
				else {
					sb.append(path.get(i)+"\n");
				}
			}
        }
		else {			
			if(word.length()>0){
				char c=word.charAt(0);
				word=word.substring(1,word.length());
				path.push('i');
				stack.push(c);
				dfs(word,target,path,stack,cur,sb);
				stack.pop();
				path.pop();
				word=c+word;			
			}		
			if(!stack.isEmpty()&&(stack.peek()==target.charAt(cur))){				
				char c=stack.peek();
				path.push('o');
				stack.pop();				
				dfs(word,target,path,stack,++cur,sb);
				cur--;
				path.pop();
				stack.push(c);
			}
		}
	}

	static boolean insameana(String str1,String str2){
		if(str1.length()==str2.length()) {
			char[] c1=str1.toCharArray();
			char[] c2=str2.toCharArray();
			Arrays.sort(c1);
			Arrays.sort(c2);
			for(int i=0;i<c1.length;i++){
				if(c1[i]!=c2[i])
					return false;
			}
			return true;
		}
		return false;
	}	
		
}
