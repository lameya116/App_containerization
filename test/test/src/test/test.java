package test;

import java.io.File; 
import java.io.FileNotFoundException;  
import java.util.Scanner;

public class test {
	public static void getResult(String cur, String [][]data_info, int len,int num, String main_url) {
		
		String new_u="";
		boolean chk;
		String dicts=data_info[num][1];
		int index = cur.lastIndexOf('/');
  	    if (index > 0) { 	    	
  		    new_u=cur.substring(0, index); 		    
	  		for (int i = 0; i < len; i++) {	  			
		    	chk=(new String(data_info[i][0]).equals(new_u));		    	
		    	if (chk==true) {		    		
			        String parent[] =data_info[i][1].split(",");
			        for(int p=0; p < parent.length; p++) {
			            dicts = dicts.replace(parent[p]+",","");
			        }
		    	}	 
		    }
	  		System.out.println(main_url+" -> "+dicts);
  	     }
	  }

	
	public static void main(String[] args) {
		
		try {
		      File myObj = new File("file.txt");	//input -> first list	      
		      Scanner myRead = new Scanner(myObj);
		      int len=0,i=0;
		      boolean a;
		      while (myRead.hasNextLine()) {
		    	  myRead.nextLine();
			      len++;
			  }
		      
		      myRead.close();
		      String data_info[][]= new String[len][2];
		      Scanner myReader = new Scanner(myObj);
		      
		      while (myReader.hasNextLine()) {
		    	
		        String data = new String(myReader.nextLine());
		        String str[] = data.trim().split("->");
		        String before= str[0].replaceAll("\\s", "");
		        char last_1=before.charAt(before.length()-1);
		        
		        if(last_1=='/') {
		    		  before=before.substring(0, before.length() - 1);
		    		  
		    	}
		        data_info[i][0] = before;
		        data_info[i][1] = str[1];
		        i++;
		      }
		      
		      myReader.close();
		      try {
			      File in = new File("in.txt");  //test cases		      
			      Scanner sc = new Scanner(in);		      
			      while (sc.hasNextLine()) {
			    	  String cur = new String(sc.nextLine().trim());
			    	  String main_url=cur;
			    	  char last=cur.charAt(cur.length()-1);
			    	  if(last=='/') {
			    		  cur=cur.substring(0, cur.length() - 1);
			    		  
			    	  }
			    	  
			    	  for (int num = 0; num < len; num++) {
			    	    	a=(new String(data_info[num][0]).equals(cur));
			    	    	if (a==true) {
			    	    		getResult(cur,data_info,len,num,main_url);     
			    	    	} 	 
			    	  }
			    	  
			      }
			      sc.close();
			      
			      }catch (FileNotFoundException e) {
				  System.out.println("An error occurred.");
				  e.printStackTrace();
				  }
		      
		      
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

	}

}
