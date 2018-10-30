package Introduction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1061_Consanguine_Calculations {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));		
		String str=br.readLine();		
		int count=1;
		while(str.charAt(0)!='E'){
			StringBuilder sb=new StringBuilder();
			ArrayList<String>ABOmap=new ArrayList<String>();
			sb.append("Case "+count+":");
			count++;
			StringTokenizer tokens = new StringTokenizer(str);
			String p1=tokens.nextToken();
			String p2=tokens.nextToken();
			String p3=tokens.nextToken();
			
			if(p1.equals("?")){
				String ABO1=p3.substring(0,p3.length()-1);
				String RH1=p3.substring(p3.length()-1,p3.length());
				String ABO2=p2.substring(0,p2.length()-1);
				String RH2=p2.substring(p2.length()-1,p2.length());
				ArrayList<String>Blood_type=new ArrayList<String>();				
				findParentBlood(ABO1,ABO2,ABOmap);
				for(String s:ABOmap) {
					guessblood(s,Blood_type);
				}
				if(Blood_type.size()==0){
					sb.append(" IMPOSSIBLE ");
				}
				else{
					if(getPparentRHblood(RH1,RH2)&&Blood_type.size()==1){						
						sb.append(" "+Blood_type.get(0)+"+ \n");
					}
					else if(getPparentRHblood(RH1,RH2)) {
						for(int i=0;i<Blood_type.size();i++){
							if(i==0)								
								sb.append(" {"+Blood_type.get(i)+"+");
							else
								sb.append(", "+Blood_type.get(i)+"+");
						}
					}
					else{
						for(int i=0;i<Blood_type.size();i++){
							if(i==0)
								sb.append(" {"+Blood_type.get(i)+"-, "+Blood_type.get(i)+"+");
							else
								sb.append(", "+Blood_type.get(i)+"-, "+Blood_type.get(i)+"+");
						}					
					}
					sb.append("} ");
				}
				sb.append(p2+" "+p3+"\n");	
				
			}
			else if(p2.equals("?")){
				sb.append(" "+p1);
				String ABO1=p3.substring(0,p3.length()-1);
				String RH1=p3.substring(p3.length()-1,p3.length());
				String ABO2=p1.substring(0,p1.length()-1);
				String RH2=p1.substring(p1.length()-1,p1.length());
				ArrayList<String>Blood_type=new ArrayList<String>();
				
				findParentBlood(ABO1,ABO2,ABOmap);
				for(String s:ABOmap) {
					guessblood(s,Blood_type);
				}
				if(Blood_type.size()==0){
					sb.append(" IMPOSSIBLE ");
				}			
				else{
					if(getPparentRHblood(RH1,RH2)&&Blood_type.size()==1){						
						sb.append(" "+Blood_type.get(0)+"+ \n");
					}
					else if(getPparentRHblood(RH1,RH2)) {
						for(int i=0;i<Blood_type.size();i++){
							if(i==0)
								sb.append(" {"+Blood_type.get(i)+"+");
							else
								sb.append(", "+Blood_type.get(i)+"+");
						}
						sb.append("} ");
					}
					else{
						for(int i=0;i<Blood_type.size();i++){
							if(i==0)
								sb.append(" {"+Blood_type.get(i)+"-, "+Blood_type.get(i)+"+");
							else
								sb.append(", "+Blood_type.get(i)+"-, "+Blood_type.get(i)+"+");
						}
						sb.append("} ");
					}
					
				}
				sb.append(p3+"\n");
			}
			else{				
				String ABO1=p1.substring(0,p1.length()-1);
				String RH1=p1.substring(p1.length()-1,p1.length());
				String ABO2=p2.substring(0,p2.length()-1);
				String RH2=p2.substring(p2.length()-1,p2.length());				
				getkidABOblood(ABO1,ABO2,ABOmap);
				sb.append(" "+p1+" "+p2);
				if(getkidRHblood(RH1,RH2)&&ABOmap.size()==1){
					sb.append(" "+ABOmap.get(0)+"-\n");
				}
				else if(getkidRHblood(RH1,RH2)){
					for(int i=0;i<ABOmap.size();i++){
						if(i==0)
							sb.append(" {"+ABOmap.get(i)+RH1);
						else
							sb.append(", "+ABOmap.get(i)+RH1);
					}
					sb.append("}\n");
				}
				else {
					for(int i=0;i<ABOmap.size();i++){
						if(i==0)
						sb.append(" {"+ABOmap.get(i)+"-, "+ABOmap.get(i)+"+");
						else
							sb.append(", "+ABOmap.get(i)+"-, "+ABOmap.get(i)+"+");
					}
					sb.append("}\n");
				}
			}
			System.out.print(sb);
			str=br.readLine();	
		}
		
		
	}	
	public static void getkidABOblood(String ABO1,String ABO2,ArrayList<String>ABOmap){
		String[]b1_arr=new String[2];
		String[]b1_arr2=new String[2];
		String[]b2_arr=new String[2];
		String[]b2_arr2=new String[2];
		Boolean status1=false;
		Boolean status2=false;
		getblooda(ABO1,b1_arr,b1_arr2,status1);
		getblooda(ABO2,b2_arr,b2_arr2,status2);
		
		if(status1&&status2){
			calbloodtype(b1_arr,b2_arr,ABOmap);
			calbloodtype(b1_arr2,b2_arr,ABOmap);
			calbloodtype(b1_arr,b2_arr2,ABOmap);
			calbloodtype(b1_arr2,b2_arr2,ABOmap);
		}
		else if(status1) {
			calbloodtype(b1_arr,b2_arr,ABOmap);
			calbloodtype(b1_arr2,b2_arr,ABOmap);
		}
		else if(status2) {
			calbloodtype(b1_arr,b2_arr,ABOmap);
			calbloodtype(b1_arr,b2_arr2,ABOmap);
		}
		else {
			calbloodtype(b1_arr,b2_arr,ABOmap);
		}
	}	
	static void getblooda(String ABO,String[]str_arr,String[]str_arr2,Boolean status){
		switch(ABO){
		case"A":
			str_arr[0]="A";str_arr[1]="A";
			str_arr2[0]="A";str_arr[1]="O";
			status=true;
			break;
		case"B":
			str_arr[0]="B";str_arr[1]="B";
			str_arr2[0]="B";str_arr[1]="O";
			status=true;
			break;
		case"AB":
			str_arr[0]="A";str_arr[1]="B";
			break;
		case"O":
			str_arr[0]="O";str_arr[1]="O";
			break;
		}
	}
	static void calbloodtype(String[]a1,String[]a2,ArrayList<String>ABOmap) {
		for(String c1:a1) {
			for(String c2:a2){
				String str=c1+c2;
				if(!ABOmap.contains(whitchtype(str))) {
					ABOmap.add(whitchtype(str));
				}
			}
		}
		
	}
	static String whitchtype(String str){
		if(str.equals("BA")||str.equals("AB"))
			return "AB";
		else if(str.equals("AO")||str.equals("AA")||str.equals("OA"))
			return "A";
		else if(str.equals("OO"))
			return "O";
		else
			return "B";
	}
	public static boolean getkidRHblood(String RH1,String RH2){
		if(RH1.equals("-")&&RH2.equals("-")) {
			return true;
		}
			return false;
	}
	////////////FIND PARENT BLOOD TYPE
	static void findParentBlood(String ABO_k,String ABO_p,ArrayList<String> parent_map){		
		switch(ABO_k) {
		case "A":	
			D("AO",ABO_p,parent_map);
			D("AA",ABO_p,parent_map);
			break;
		case "B":
			D("BO",ABO_p,parent_map);
			D("BB",ABO_p,parent_map);
			break;
		case "O":
			D("OO",ABO_p,parent_map);
			break;
		case "AB":
			D("AB",ABO_p,parent_map);
			break;
		}
	}
	static void D(String ABO_k,String ABO_p,ArrayList<String> parent_map){
		switch(ABO_p) {
		case "A":	
			findparentgene(ABO_k,"AO",parent_map);
			findparentgene(ABO_k,"AA",parent_map);
			break;
		case "B":
			findparentgene(ABO_k,"BO",parent_map);
			findparentgene(ABO_k,"BB",parent_map);
			break;
		case "O":
			findparentgene(ABO_k,"OO",parent_map);
			break;
		case "AB":
			findparentgene(ABO_k,"AB",parent_map);
			break;
		}
	}
	static void findparentgene(String ABO_k,String ABO_p,ArrayList<String> parent_map){
		for(int i=0;i<2;i++){
			for(int x=0;x<2;x++){
				if(ABO_k.charAt(i)==ABO_p.charAt(x)){
					String s1=String.valueOf(ABO_k.charAt(0));
					String s2=String.valueOf(ABO_k.charAt(1));
					if(i==0){
						if(!parent_map.contains(s2))
						parent_map.add(s2);
					}
					else{
						if(!parent_map.contains(s1))
						parent_map.add(s1);
					}
				}
			}
		}
	}
	static void guessblood(String ABO,ArrayList<String>ABOmap){
	
		switch(ABO){
		case "A":
			if(!ABOmap.contains("AB")) {
				ABOmap.add("AB");
			}
			if(!ABOmap.contains("A")) {
				ABOmap.add("A");
			}
			break;
		case "B":
			if(!ABOmap.contains("AB")) {
				ABOmap.add("AB");
			}
			if(!ABOmap.contains("B")) {
				ABOmap.add("B");
			}
			break;
		case "O":
			if(!ABOmap.contains("O")) {
				ABOmap.add("O");
			}
			if(!ABOmap.contains("B")) {
				ABOmap.add("B");
			}
			if(!ABOmap.contains("A")) {
				ABOmap.add("A");
			}
			break;
		default:
			ABOmap.add("IMPOSSIBLE");
			break;
		}
	}
	static boolean getPparentRHblood(String RH1,String RH2){
		if(RH1.equals("+")&&RH2.equals("-")) {
			return true;
		}
			return false;
	}
}
