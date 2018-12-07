package Data_Structures;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Q978_Lemmings_Battle {

	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));		
		StringBuilder sb=new StringBuilder();
		int case_num=Integer.parseInt(br.readLine());
		while(case_num-->0) {						
			StringTokenizer tk=new StringTokenizer(br.readLine());			
			int bf_size=Integer.parseInt(tk.nextToken());
			int G_num=Integer.parseInt(tk.nextToken());
			int B_num=Integer.parseInt(tk.nextToken());
			TreeMap<Integer,Integer> greenteam=new TreeMap<>(Collections.reverseOrder());
			TreeMap<Integer,Integer> blueteam=new TreeMap<>(Collections.reverseOrder());
			while(G_num-->0) {
				int man=Integer.parseInt(br.readLine().trim());
				addmen(greenteam,man);
			}
			while(B_num-->0) {
				int man=Integer.parseInt(br.readLine().trim());
				addmen(blueteam,man);
			}
			ArrayList<Integer> b_win=new ArrayList<>();
			ArrayList<Integer> g_win=new ArrayList<>();			
			while(!greenteam.isEmpty()&&!blueteam.isEmpty()) {
				for(int i=0;i<bf_size;i++) {
					if(greenteam.isEmpty()||blueteam.isEmpty()) {
						break;
					}
					else {
						int a=takeout(greenteam);
						int b=takeout(blueteam);
						battle(b,a,b_win,g_win);
					}
				}				
				for(int win:g_win){
					addmen(greenteam,win);
				}
				for(int win:b_win){
					addmen(blueteam,win);
				}		
				b_win.clear();
				g_win.clear();				
			}
			if(blueteam.isEmpty()&&greenteam.isEmpty()) {
				sb.append("green and blue died\n");
			}
			else if(blueteam.isEmpty()){
				sb.append("green wins\n");
				output(sb,greenteam);
			}
			else {
				sb.append("blue wins\n");
				output(sb,blueteam);
			}
			if(case_num!=0)
				sb.append("\n");
		}
		System.out.print(sb);
	}

	private static void output(StringBuilder sb, TreeMap<Integer, Integer> greenteam) {
		Set<Entry<Integer, Integer>> a=greenteam.entrySet();
		for(Entry<Integer, Integer> e:a){
			for(int i=e.getValue();i>0;i--){
				sb.append(e.getKey()+"\n");
			}
		}		
	}

	private static void battle(int b_mem, int g_mem, ArrayList<Integer> b_win, ArrayList<Integer> g_win) {
		if(b_mem>g_mem){
			b_win.add(b_mem-g_mem);
		}
		else if(b_mem<g_mem){
			g_win.add(g_mem-b_mem);
		}
	}

	private static int takeout(TreeMap<Integer, Integer>team) {
		Entry<Integer, Integer> powerest=team.pollFirstEntry();
		if(powerest.getValue()!=1){
			team.put(powerest.getKey(), powerest.getValue()-1);
		}
		return powerest.getKey();
	}

	private static void addmen(Map<Integer, Integer> team, int member) {
		if(team.containsKey(member)) {			
			team.put(member, team.get(member)+1);
		}
		else {
			team.put(member, 1);
		}		
	}
	
	
		
}
