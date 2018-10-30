package Introduction;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q573_The_Snail {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int height=input.nextInt();
		while(height!=0){
			int climb=input.nextInt();
			int slide=input.nextInt();
			int fatigue=input.nextInt();			
			//calculate distance
			countday(height,climb,slide,fatigue);
			height=input.nextInt();
		}
	}
	
	public static void countday(int height,int climb,int slide,int fatigue){
		ArrayList<Double>climb_distance=new ArrayList<Double>();
		DecimalFormat df = new DecimalFormat("##.00");
		//calculate everyday diatance
		double a=climb;
		double rate=a*fatigue/100;
		//System.out.println(rate);
		while(a>0){			
			climb_distance.add(a);
			a=a-rate;				
		}
		//System.out.println(Arrays.toString(climb_distance.toArray()));
		double distance=0;
		int day=0;
		while(true){
			if(day<climb_distance.size())
			{
				distance+=climb_distance.get(day);
			}
			if(distance>height){
				System.out.println("success on day "+(day+1));
				break;
			}
			else{
				distance-=slide;
				day++;
				if(distance<0){
					System.out.println("failure on day "+(day));
					break;
				}
				
			}
			//System.out.println(distance);		
		}		
		
	}
}
