package Introduction;
import java.util.Scanner;

public class Q893_Y3K_Problem {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		
		long after=input.nextLong();
		long day=input.nextInt();
		int month=input.nextInt();
		long year=input.nextLong();
				
		while(after!=0||day!=0||month!=0||year!=0){			
			add(after,year,month,day);
			/*-------------------------------------------*/
			after=input.nextLong();
			day=input.nextInt();
			month=input.nextInt();
			year=input.nextLong();
		}
	}
	
	public static void add(long after,long year,int month,long day){
		int[] regular_year={0,31,28,31,30,31,30,31,31,30,31,30,31};
		day=day+after;
		while(day>regular_year[month]){					
			if(month==2&&isleap(year)){
					if(day==29){
						break;
					}
					else{
						day-=29;
						month++;	
					}								
			}
			else{
				day-=regular_year[month];
				month++;				
			}
			if(month>12){
				month=month%12;
				year++;
			}
			
		}
		System.out.println(day+" "+month+" "+year);
	}
	
	public static boolean isleap(long year){
		if(year%4==0){
			if(year%100==0){
				if(year%400==0){
					return true;
				}
				return false;
			}
			return true;
		}
		return false;
	}

}
