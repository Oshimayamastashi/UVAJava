package Introduction;
import java.util.Arrays;
import java.util.Scanner;

public class Q637_Booklet_Printing {
	public static void main(String[] args){
		Scanner input= new Scanner(System.in);
		int page=input.nextInt();
		while(page!=0){
			
			if(page==1){
				System.out.print("Printing order for 1 pages:\nSheet 1, front: Blank, 1\n");
			}
			else{
			createbook(page);
			}		
			
			page=input.nextInt();
		}
	}

	private static void createbook(int page) {
		int full;
		if(page%4==0){
			full=page;
		}
		else{
			full=page+4-page%4;
		}
		int[] book=new int[full];	
		for(int i=0;i<full/2;i++){
			if(i%2==0){
				book[2*i]=full-i;
				book[2*i+1]=i+1;
			}
			else{
				book[2*i+1]=full-i;
				book[2*i]=i+1;
			}
		}
		
		System.out.print("Printing order for "+page+" pages:");
		for(int i=0;i<book.length;i++){
			if(i%4==0){
				System.out.print("\nSheet "+(i/4+1)+", front:");
			}
			else if(i%4==2){
				System.out.print("\nSheet "+(i/4+1)+", back :");
			}
			if(book[i]>page){
				System.out.print(" Blank");
			}
			else{
				System.out.print(" "+book[i]);
			}
			if(i%2==0){
				System.out.print(",");
			}
		}
		System.out.println();
		//System.out.println(Arrays.toString(book));
	}
}
