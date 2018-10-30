package Introduction;
import java.util.Scanner;
public class Q10945_Mother_bear{

  public static void main(String[] args) {
   Scanner input=new Scanner(System.in);
   String str=input.nextLine();
   while(!str.equals("DONE")){    
     str=reduce(str);    
     //System.out.println(str);
     boolean status=true;
     for(int i=0;i<str.length()/2;i++){
       if(str.charAt(i)!=str.charAt(str.length()-1-i)){
         status=false;
         break;
      }
     }
     if(status){
    	 System.out.println("You won't be eaten!");
     }
     else{
    	 System.out.println("Uh oh..");
     }
     str=input.nextLine();
   }
  }
  
  static String reduce(String str){
    str=str.replace(" ","");
    str=str.replace("!","");
    str=str.replace(",","");
    str=str.replace("'","");
    str=str.replace(".","");
    str=str.replace("?","");
    String str2="";
    for(int i=0;i<str.length();i++){
       char c=str.charAt(i);
       if((int)c<97){
         c+=32;
     }
       str2+=c;
    }
    return str2;
  }
}