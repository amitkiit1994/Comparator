package org.compare;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class TestUtil 
{
    public static List<String> readFileContents(String filePath) throws IOException
    {
        	
			//FileReader fileReader =new FileReader(filePath);
    	 BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
			ArrayList<String> listOfInformation = new ArrayList<String>();
			 String line= fileReader.readLine();    
	          while(line!=null) {   
	        	  listOfInformation.add(line);
	        	  line=fileReader.readLine();
	          }
			fileReader.close();
		
        return listOfInformation;
        
    }
    public static ArrayList<Double> findDigits(String text){
    	ArrayList<Double> digit=new ArrayList<Double>();
        Matcher m = Pattern.compile("(?!=\\d\\.\\d\\.)([\\d.]+)").matcher(text);
        while (m.find())
        {
           digit.add(Double.parseDouble(m.group(1)));
            
        }
        return digit;
     }
}
