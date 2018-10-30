package Introduction;
import java.util.Scanner;

public class Q12085_Mobile_Casanova {
	public static void main(String[] args) {
		
		Scanner input=new Scanner(System.in);
		int case_num=1;		
		int N=input.nextInt();
		input.nextLine();
		while(N>0){
			System.out.println("Case "+case_num+":");
			case_num++;
			String[] num_list=new String[N];
			int[] list=new int[N];
			for (int i=0;i<N;i++){
				num_list[i]=input.nextLine();
				list[i]=Integer.parseInt(num_list[i]);
			}
			int head = 0;
			for(int i=0;i<N;i++){					
				if(i==0){
				System.out.print(num_list[i]);
				head=0;
				}
				else if(list[i]!=list[i-1]+1){
					System.out.print("\n"+num_list[i]);
					head=i;
				}
				else if(i==N-1){
					printdiff(num_list[head],num_list[i]);
				}
				else if(list[i+1]!=list[i]+1){	
					printdiff(num_list[head],num_list[i]);
				}				
			}
			System.out.print("\n\n");
			N=input.nextInt();
			input.nextLine();
		}
	}
	
	public static void printdiff(String a,String b){
		int k=diff(a,b);
		String str=b.substring(k,b.length());
		System.out.print("-"+str);

	}
	
	public static int diff(String a,String b){
		for(int i=0;i<a.length();i++){			
			if(a.charAt(i)!=b.charAt(i)){
				return i;
			}
		}
		return -1;
	}
}
