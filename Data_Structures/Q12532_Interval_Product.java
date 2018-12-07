package Data_Structures;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Q12532_Interval_Product {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringBuilder sb=new StringBuilder();
		while((str=br.readLine())!=null) {
			String[] str2=str.split(" ");
			int N=Integer.parseInt(str2[0]);
			int K=Integer.parseInt(str2[1]);
			int[] arr=new int[N];
			str2=br.readLine().split(" ");
			for(int i=0;i<N;i++) {
				arr[i]=Integer.parseInt(str2[i]);
			}
			SumSegTree segtree=new SumSegTree(arr);
			while(K-->0) {
				str2=br.readLine().split(" ");
				if(str2[0].equals("C")) {
					int I=Integer.parseInt(str2[1])-1;
					int V=Integer.parseInt(str2[2]);
					segtree.update(0, N-1, 0, V, I);
				}
				else {
					int I=Integer.parseInt(str2[1])-1;
					int J=Integer.parseInt(str2[2])-1;
					int ans=segtree.query(0, N-1, I, J, 0);
					if(ans==0) 
						sb.append("0");		
					else if(ans>0) 
						sb.append("+");
					else 
						sb.append("-");					
				}				
			}
			sb.append("\n");			
		}
		System.out.print(sb);
	}
	
	
	
	private static class SumSegTree{
		int[] SegTree;
		
		SumSegTree(int[] arr){
			SegTree=new int[treeSize(arr.length)*2];
			build(0,arr.length-1,arr,0);
		}
	
		int treeSize(int arr_size) {
			int x=0;
			for(int i=0;x<arr_size;i++) {
				x=(int) Math.pow(2, i);				
			}
			return x;
		}
		
		void printSegTree(){
			System.out.println(Arrays.toString(SegTree));
		}
		
		void build(int L,int R,int[] arr,int pos) {
			if(L==R) {
				SegTree[pos]=arr[L];
				return;
			}
			int mid=(L+R)/2;
			build(L,mid,arr,pos*2+1);
			build(mid+1,R,arr,pos*2+2);
			SegTree[pos]=sum(SegTree[pos*2+1],SegTree[pos*2+2]);			
		}
		
		int sum(int a,int b) {	
			if(a==0||b==0) {
				return 0;
			}
			else if(a>0&&b>0){
				return 1;
			}
			else if(a<0&&b<0) {
				return 1;
			}
			else{
				return -1;
			}
			
		}
		
		void update(int L,int R,int pos,int V, int I) {
			if(L==R) {
				SegTree[pos] = V;
		        return;
			}			
			int mid=(L+R)/2;
			if(mid>=I)
				update(L,mid,pos*2+1,V,I);
			if(mid<I)
				update(mid+1,R,pos*2+2,V,I);
			SegTree[pos]=sum(SegTree[pos*2+1],SegTree[pos*2+2]);	
		}
		
		int query(int L,int R,int ll,int rr,int pos) {
			int ans=1;
			if(ll<=L&&R<=rr) {
				return SegTree[pos];
			}
			int mid=(L+R)/2;
			if(ll<=mid)
				ans=sum(query(L,mid,ll,rr,pos*2+1),ans);				
			if(mid<rr)				
				ans=sum(query(mid+1,R,ll,rr,pos*2+2),ans);			
			return ans;
		}
	}
}
