package Data_Structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q514_Rails {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int coach_num;
		coach_num=Integer.parseInt(br.readLine());
		while(coach_num!=0){
			int[] arr=new int[coach_num]; 
			String str=br.readLine();
			while(!str.equals("0")){
				StringTokenizer token=new StringTokenizer(str);
				for(int i=0;i<coach_num;i++){
					arr[i]=Integer.parseInt(token.nextToken());
				}
				Stack<Integer> stack=new Stack<Integer>();
				int now=0;
				for(int x=1;x<=coach_num;x++) {
					if(x==arr[now]){
						now++;
					}
					else if(!stack.empty()&&stack.peek()==arr[now]){
						while(!stack.empty()&&stack.peek()==arr[now]){						
						stack.pop();
						now++;
						}
						stack.push(x);
					}
					else{
						stack.push(x);
					}					
				}
				for(;now<coach_num&&!stack.empty();now++){
						if(stack.peek()!=arr[now]){
							sb.append("No\n");
							break;
						}
						stack.pop();
				}
				if(now==coach_num)
					sb.append("Yes\n");
				str=br.readLine();
			}
			sb.append("\n");
			coach_num=Integer.parseInt(br.readLine());
		}
		System.out.print(sb.toString());
	}
}
