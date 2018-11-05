package hocba.util;
import net.htmlparser.jericho.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.*;

import com.google.gson.Gson;
public class Utilities {
    public Utilities() {

    }

    public static String encode(String strUni){
        return CharacterReference.encode(strUni);
    }

    public static String decode(String strUni){
        return CharacterReference.decode(strUni);
    }


    public static int getIntParameter(ServletRequest request, String name){
        int value = -1;
        String strValue = request.getParameter(name);
        
        if(strValue != null && !strValue.equals("")){
            try{
                value = Integer.parseInt(strValue);
            }catch(Exception e){
                e.printStackTrace();
            }

        }

        return value;
    }

    public static short averageScore(short score_15, short score_45_1,short score_45_2) {
    	
    	short rs = (short) ((double)(score_45_1 + score_45_2 + score_15)/3 + 0.5);
    	return rs;
    }
    
    public static short finalScore(short test_score, short average_score) {
    	return (short) ((double)(test_score*2 + average_score)/3 + 0.5);
    }
    
  public static short getScoreParameter(ServletRequest request, String name) {
	  short value = -1;
      String strValue = request.getParameter(name);
      
      
      
      if(strValue != null && !strValue.equals("")){
    	  int indexof = strValue.indexOf(".");
    	  if(indexof == -1) {
    		  return -1;
    	  }
    	  
    	  if(strValue.length() > 5) {
    		  return -1;
    	  }
    	  
    	  if(indexof == 0 || indexof == (strValue.length() - 1)) {
    		  return -1;
    	  }
    	  
    	 
          try{
              value = Short.parseShort(strValue.substring(0, indexof));
              if(value < 0 || value >= 100) {
            	  return -1;
              }
              
              short right = Short.parseShort(strValue.substring(indexof + 1));
              if(right < 0 || right >= 100) {
            	  return -1;
              }
              
              value = (short) (value*100 + right);
              
          }catch(Exception e){
              return -1;
          }

      }

      return value;
  }
    
   public static String ObjectToJson(Object o) {
	   String tmp = "";
	   Gson gson = new Gson();
	   tmp = gson.toJson(o);
	   
	   return tmp;
   }
   public static String getValue(String str){

       return str != null? str.trim() : "";
   }
   
   
   public static String getDateFromString(String dateString){
	   String rs = "";
	   if(dateString.length() != 10) {
		   return null;
	   }
	   if(dateString.charAt(4) != '-' || dateString.charAt(7) != '-') {
		   return null;
	   }
	   try {
		   rs += dateString.substring(8) + "/";
		   rs += dateString.substring(5, 7) + "/";
		   rs += dateString.substring(0, 4);
		   
		   return rs;
	   }catch (Exception e) {
		   return null; 
	   }
	   
	   

	}
   
   public static String coverDateForHTML(String dateString) {
	   // 31/03/2018
	   // 2018-03-31
	   

	   try {
		   int tail = dateString.lastIndexOf('/');
		   int head = dateString.indexOf('/');
		   
		   String y = dateString.substring(tail + 1);
		   String m = dateString.substring(head + 1, tail);
		   String d = dateString.substring(0,head);
		   
		   
		   
		   d = d.length() <= 1? "0" + d : d ;
		   
		   m = m.length() <= 1? "0" + m : m;
		   return y + "-" + m  +  "-" + d;
		   
		   
	   }catch (Exception e) {
		   e.printStackTrace();
		   return null; 
	   }
   }
   
   public static void main(String []args) {
	  
	   System.out.println((short)Utilities.finalScore((short)700,(short) 800));
	   
   }
   
   
   

}
