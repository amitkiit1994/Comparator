package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

import org.compare.TestUtil;


/**
 * Hello world!
 *
 */
public class TestBase 

{
	public static Properties prop;
	public TestBase() {
		// TODO Auto-generated constructor stub
		try {
		prop = new Properties();
		String propertiesFilePath = System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties";
		FileInputStream fis=new FileInputStream(propertiesFilePath);;
		prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public boolean compareCity(String City1, String City2) {
		if(City1.equalsIgnoreCase(City2)) {
			return true;
		}
		return false;
	}
	
	public boolean windComparison(String wind1, String wind2, String variance) {
		ArrayList<Double> d1=TestUtil.findDigits(wind2);
		ArrayList<Double> d2=TestUtil.findDigits(wind1);
		ArrayList<Double> d3=new ArrayList<Double>();
		for (Double double1 : d1) {
			d3.add(double1);
		}
		for (Double double1 : d2) {
			d3.add(double1);
		}
		
		Double max=d3.get(0);
		for (Double double1 : d3) {
			if(double1>max) {
				max=double1;
			}
		}
		d3.remove(max);
		//System.out.println(d3);
		Collections.sort(d3);
		if(d3.size()==2) {
			if(d3.get(1)-d3.get(0)<=Double.valueOf(variance)) {
				return true;
			}
		}
		else {
			return false;
		}
		return false;
	}
	public boolean valueComparison(String value1, String value2, String variance) {
		ArrayList<Double> d1=TestUtil.findDigits(value1);
		ArrayList<Double> d2=TestUtil.findDigits(value2);
		double n1=d1.get(0);
		double n2=d2.get(0);
		if(n1>n2) {
			if((n1-n2)<=Double.valueOf(variance)) {
				return true;
			}
		}
		else if(n2>n1) {
			if((n2-n1)<=Double.valueOf(variance)) {
				return true;
			}
		}
	return false;
	}

	

}