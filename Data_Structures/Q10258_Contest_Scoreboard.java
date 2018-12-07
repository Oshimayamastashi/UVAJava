package Data_Structures;

import java.io.*;
import java.util.*;

public class Q10258_Contest_Scoreboard {

	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		int case_num=Integer.parseInt(br.readLine());
		br.readLine();
		while(case_num-->0){			
			String str;
			Contestant[] scoreboard=new Contestant[100];
			for(int i=0;i<100;i++){
				scoreboard[i]=new Contestant();
			}
			while((str=br.readLine())!=null&&str.length()!=0){
				StringTokenizer tk=new StringTokenizer(str);
				int person=Integer.parseInt(tk.nextToken());
				int problem=Integer.parseInt(tk.nextToken());
				int time=Integer.parseInt(tk.nextToken());
				String correct=tk.nextToken();				

				scoreboard[person-1].participate=true;
				if(correct.equals("C")&&!scoreboard[person-1].submission[problem-1].finish){
				scoreboard[person-1].submission[problem-1].finish=true;
				scoreboard[person-1].submission[problem-1].comsumetime=time;
				}
				else if(correct.equals("I")&&!scoreboard[person-1].submission[problem-1].finish){
					scoreboard[person-1].submission[problem-1].sub_time++;
				}				
			}
			List<Result> al =new ArrayList<Result>();
			for(int i=0;i<100;i++){
				if(scoreboard[i].participate){					
					int totaltime=0;
					int totalproblem=0;
					for(int x=0;x<10;x++){
						if(scoreboard[i].submission[x].finish){
							totaltime+=scoreboard[i].submission[x].sub_time*20+scoreboard[i].submission[x].comsumetime;
							totalproblem++;
						}
					}
					Result R=new Result(i+1,totalproblem,totaltime);
					al.add(R);
				}
			}
			Collections.sort(al, new ResultComparator());
			for(Result r:al){
				sb.append(r.No+" "+r.f_problem+" "+r.time+"\n");
			}
			if(case_num!=0){
				sb.append("\n");
			}
		}		
		System.out.print(sb);
	}
	static class Contestant{
		Qusetion[] submission=new Qusetion[10];
		boolean participate;	
		
		public Contestant(){
			for(int i=0;i<10;i++)
				submission[i]=new Qusetion();
			participate=false;
		}
	}
	static class Qusetion{
		int comsumetime;
		int sub_time;
		boolean finish;
		public Qusetion(){
			comsumetime=0;
			sub_time=0;
			finish=false;
		}
	}
	static class Result {
		int No;
		int f_problem;
		int time;
		Result(int num1,int num2,int num3){
			No=num1;
			f_problem=num2;
			time=num3;
		}
	}
	static class ResultComparator implements Comparator<Result> {
	    @Override
	    public int compare(Result a, Result b) {
	    	if(a.f_problem!=b.f_problem){
	    		return b.f_problem-a.f_problem;
	    	}
	    	else if(a.time!=b.time){
	    		return a.time-b.time;
	    	}
	    	else{
	    		return a.No-b.No;
	    	}
	    }
	}

}
