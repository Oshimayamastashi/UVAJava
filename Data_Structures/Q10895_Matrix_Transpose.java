package Data_Structures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Q10895_Matrix_Transpose {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		while ((str=br.readLine())!=null) {
			String[] str2=str.split(" ");
			int row_num = Integer.parseInt(str2[0]);
			int col_num= Integer.parseInt(str2[1]);
			ArrayList<Integer> [] col=new ArrayList[col_num];		
			ArrayList<Integer> [] matrix=new ArrayList[col_num];
			for(int i=0;i<matrix.length;i++) {
				matrix[i]=new ArrayList<Integer>();
				col[i]=new ArrayList<Integer>();
			}
			for (int k=0;k<row_num;k++) {
				String[] row=br.readLine().split(" ");
				String[] val=br.readLine().split(" ");				
				int a=Integer.parseInt(row[0]);	
				for(int i=0;i<a;i++) {
					matrix[Integer.parseInt(row[i+1])-1].add(Integer.parseInt(val[i]));
					col[Integer.parseInt(row[i+1])-1].add(k+1);
				}
			}
			
			System.out.println(col_num+" "+row_num);	
			for(int i=0;i<matrix.length;i++) {
				System.out.print(col[i].size());
				for(int x=0;x<col[i].size();x++) {
					System.out.print(" "+col[i].get(x));
				}
				System.out.println();
				for(int x=0;x<matrix[i].size();x++) {
					System.out.print(matrix[i].get(x));
					if(x<matrix[i].size()-1) {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}

	}	
}
