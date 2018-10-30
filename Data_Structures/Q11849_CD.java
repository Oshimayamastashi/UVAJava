package Data_Structures;

import java.io.*;
import java.util.*;

public class Q11849_CD {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		String str=br.readLine();
		while(!str.equals("0 0")) {
			StringTokenizer tk=new StringTokenizer(str);
			TreeSet <Integer>cdlist =new TreeSet<>();
			int same=0;
			int N=Integer.parseInt(tk.nextToken());
			int M=Integer.parseInt(tk.nextToken());
			for(int i=0;i<N;i++) {
				cdlist.add(Integer.parseInt(br.readLine()));
			}
			for(int i=0;i<M;i++) {
				if(cdlist.contains(Integer.parseInt(br.readLine())))
					same++;
			}
			sb.append(same+"\n");
			str=br.readLine();
		}
		System.out.print(sb);
	}

}
