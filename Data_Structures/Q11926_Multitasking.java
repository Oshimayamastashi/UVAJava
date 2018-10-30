package Data_Structures;

import java.io.*;
import java.util.*;

public class Q11926_Multitasking {
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		String str=br.readLine();		
		while(!str.equals("0 0")) {
			StringTokenizer tk=new StringTokenizer(str);			
			boolean[] calendar=new boolean[1000000];
			int m=Integer.parseInt(tk.nextToken());
			int n=Integer.parseInt(tk.nextToken());			
			boolean status=true;
			while(m>0&&status){				
				tk=new StringTokenizer(br.readLine());
				int start=Integer.parseInt(tk.nextToken());
				int end=Integer.parseInt(tk.nextToken());
				for(int i=start;i<end;i++){
					if(calendar[i]){
						sb.append("CONFLICT\n");
						status=false;
						break;						
					}
					calendar[i]=true;			
				}
				m--;
			}
			while(status&&n>0){				
				tk=new StringTokenizer(br.readLine());
				int start=Integer.parseInt(tk.nextToken());
				int end=Integer.parseInt(tk.nextToken());
				int task_l=end-start;
				int intervals=Integer.parseInt(tk.nextToken());
				for(int x=start;x<1000000&&status;x+=intervals) {
					//System.out.println(x);
					for(int i=0;i<task_l&&x+i<1000000;i++){
						if(calendar[x+i]){
							sb.append("CONFLICT\n");
							status=false;
							break;
						}
						calendar[x+i]=true;					
					}
				}
				n--;				
			}
			if(status)
				sb.append("NO CONFLICT\n");
			else {
				while(m-->0)
					br.readLine();					
				while(n-->0)
					br.readLine();
			}
			str=br.readLine();	
		}
		System.out.print(sb);
	}
}
