package Introduction;
import java.util.Scanner;

public class Q579_ClockHands {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		String[] str=input.nextLine().split(":");
		//System.out.println(str[0]+" "+str[1]);	
		
		while(!(str[0].equals("0")&&str[1].equals("00"))){			
			int hour=Integer.parseInt(str[0]);
			int min=Integer.parseInt(str[1]);				
			 
			double min_angle=min*6;
			double hour_angle=hour*30+(6.000*min/12);
			//
			double angle=Math.abs(hour_angle-min_angle);
			if(angle>180){
				angle=360-angle;
			}
			System.out.printf("%.3f\n",angle);
			str=input.nextLine().split(":");
		}
	}
}
