package Introduction;
import java.util.Scanner;

public class Q11947_Cancer_or_Scorpio {
	public static void main(String[] args){
		Scanner input=new Scanner(System.in);
		int N=input.nextInt();
		int k=0;
		while(N-->0){
			
			int read=input.nextInt();
			int month=read/1000000;
			read%=1000000;
			int day=read/10000;
			read%=10000;
			int year=read;
			System.out.print(++k+" ");
			add(280,year,month,day);						
		}
	}
	public static void add(int after,int year,int month,int day){
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
		if(month<10){
			System.out.print("0");
		}
		System.out.print(month+"/");
		if(day<10){
				System.out.print("0");
		}
		System.out.print(day+"/");
		System.out.print(year);
			
		zodiac(day,month);
	}
	
	public static boolean isleap(int year){
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
	
	public static void zodiac(int day,int month){
		switch(month){
		case 1:
			if(day>20)
				System.out.println(" aquarius");
			else
				System.out.println(" capricorn");
			break;
		case 2:
			if(day>19)
				System.out.println(" pisces");
			else
				System.out.println(" aquarius");
			break;
		case 3:
			if(day>20)
				System.out.println(" aries");
			else
				System.out.println(" pisces");
			break;
		case 4:
			if(day>20)
				System.out.println(" taurus");
			else
				System.out.println(" aries");
			break;
		case 5:
			if(day>21)
				System.out.println(" gemini");
			else
				System.out.println(" taurus");
			break;
		case 6:
			if(day>21)
				System.out.println(" cancer");
			else
				System.out.println(" gemini");
			break;
		case 7:
			if(day>22)
				System.out.println(" leo");
			else
				System.out.println(" cancer");
			break;
		case 8:
			if(day>21)
				System.out.println(" virgo");
			else
				System.out.println(" leo");
			break;
		case 9:
			if(day>23)
				System.out.println(" libra");
			else
				System.out.println(" virgo");
			break;
		case 10:
			if(day>23)
				System.out.println(" scorpio");
			else
				System.out.println(" libra");
			break;
		case 11:
			if(day>22)
				System.out.println(" sagittarius");
			else
				System.out.println(" scorpio");
			break;
		case 12:
			if(day>22)
				System.out.println(" capricorn");
			else
				System.out.println(" sagittarius");
			break;
		
		}
	}
}
