package Data_Structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q599_The_Forrest_for_the_Trees {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int case_num=Integer.parseInt(br.readLine());
		while(case_num-->0) {
			String str;
			ArrayList<String> edge=new ArrayList<>();
			while(!(str=br.readLine()).contains("*")) {
				edge.add(str);
			}
			String[] point=br.readLine().split(",");
			
			int point_num=point.length;
			boolean[] node=new boolean[point_num];
			boolean[][] connect=new boolean [point_num][point_num];
			for(int i=0;i<edge.size();i++){
				str=edge.get(i);
				int p1=getnum(point,str.charAt(1)+"");
				int p2=getnum(point,str.charAt(3)+"");				
				connect[p1][p2]=true;
				connect[p2][p1]=true;
			}
			int tree=0;
			int acorn=0;
			
			for(int i=0;i<point_num;i++) {		
				if(!node[i]) {
					if (dfs(connect,i,node) > 1) {
						tree ++;
					}else {
						acorn ++;
					}		
				}
			}
			
			System.out.println("There are "+tree+" tree(s) and "+acorn+" acorn(s).");
		}
	}
	
	static int getnum(String[] point,String query) {
		for(int i=0;i<point.length;i++) {
			if(point[i].equals(query))
				return i;
		}
		return -1; 
	}
	
	static int dfs(boolean[][] connect, int a,boolean[] node) {
		int ans = 1;
		node[a]=true;
		for (int i = 0; i <node.length; i++) {
			if (connect[a][i]&&!node[i]) {
				ans += dfs(connect,i,node);
			}
		}
		return ans;
	}
}
