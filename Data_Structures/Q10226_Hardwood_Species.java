package Data_Structures;
import java.io.*;
import java.util.*;

public class Q10226_Hardwood_Species {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int case_num=Integer.parseInt(br.readLine());
		br.readLine();
		while(case_num-->0){			
			Map<String, Double> forest = new TreeMap<>();			
			int tree_num=0;
			String tree;
			while((tree=br.readLine())!=null&&tree.length()!=0){		
				if(forest.containsKey(tree))
					forest.put(tree,forest.get(tree)+1);
				else
					forest.put(tree,1.0);
				tree_num++;
			}
			for(Object key:forest.keySet()){
				System.out.printf("%s %.4f\n",key.toString(),forest.get(key)*100.0/tree_num);				
			}
	        if(forest.size()!=0&&case_num!=0)
	        	System.out.println();
		}
	}
}
