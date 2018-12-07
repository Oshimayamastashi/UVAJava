package Data_Structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11340_Newspaper {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int count=Integer.parseInt(br.readLine());
		while(count-->0){			
			int[]price_map=new int[2000];
			int al_num=Integer.parseInt(br.readLine());
			for(int i=0;i<al_num;i++){
				StringTokenizer tokens = new StringTokenizer(br.readLine());
				char c=tokens.nextToken().charAt(0);
				int price=Integer.parseInt(tokens.nextToken());
				price_map[c]=price;
			}
			int line_num=Integer.parseInt(br.readLine());
			double total=0; 
			for(int i=0;i<line_num;i++){				
				 for(char c: br.readLine().toCharArray()) {
					 //care\n
	                    if(c<1000&&c>0){
	                    	total+=price_map[c];
	              }
	            }
			}			
			System.out.printf("%.2f$\n",(total/100));
		}
	}

}
