package Data_Structures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q11991_Easy_Problem_from_Rujia_Liu {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str;
		while((str=br.readLine())!=null){
			String[] str2=str.split("\\s+");
			int n=Integer.parseInt(str2[0]);
			int m=Integer.parseInt(str2[1]);			
			str2=br.readLine().split(" ");
			
			int[] num=new int[n];
			ArrayList<Integer>[] al=new ArrayList[n];
			int pos=0;
			for(int i=0;i<n;i++) {				
				int a=Integer.parseInt(str2[i]);
				int index=finda(a,num);			
				
				if(index<0) {
					al[pos]=new ArrayList<>();
					num[pos]=a;
					al[pos].add(i+1);
					pos++;
				}
				
				else {
					al[index].add(i+1);
				}
								
			}
				
			for(int i=0;i<m;i++) {
				str2 = br.readLine().split("\\s+");				
				int k=Integer.parseInt(str2[0]);
				int v=Integer.parseInt(str2[1]);
					
				int index=finda(v,num);
				if(al[index].size()>k-1)				
					System.out.println(al[index].get(k-1));
				else
					System.out.println("0");
			}
			
			
		}
	}

	private static int finda(int a,int[]num) {
		for(int i=0;i<num.length;i++) {
			if(num[i]==a)
				return i;
		}
		return -1;
	}	
}
