package Introduction;
import java.util.Arrays;
import java.util.Scanner;

public class Q584_Bowling {
	static public void main(String[] args){
		Scanner input=new Scanner(System.in);
		String str=input.nextLine();
		while(!str.equals("Game Over")){
			String[] str2=str.split(" ");
			int[] score=new int [24]; 
			int i=0;
			for(int x=0;x<10;x++){
				if(str2[i].equals("X")){
					if(str2[i+2].equals("/"))
						score[x]=20;
					else if(str2[i+1].equals("X")){
						if(str2[i+2].equals("X"))
							score[x]=30;
						else
							score[x]=20+Integer.parseInt(str2[i+2]);
					}						
					else
						score[x]=10+Integer.parseInt(str2[i+1])+Integer.parseInt(str2[i+2]);	
				}
				else if(str2[i+1].equals("/")){
					
					if(str2[i+2].equals("X"))
						score[x]=20;
					else{
						score[x]=10+Integer.parseInt(str2[i+2]);
					}
					i++;
				}
				else{
					score[x]=Integer.parseInt(str2[i])+Integer.parseInt(str2[i+1]);
					i++;
				}
				//System.out.println(score[i]+" "+x);
				i++;
				
			}			
			int sum=0;
			for(i=0;i<10;i++){
				sum+=score[i];
			}

			
			System.out.println(sum);
			/*---------------------------------------*/
			str=input.nextLine();
			
		}
	}
}
