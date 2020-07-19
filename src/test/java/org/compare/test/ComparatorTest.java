package org.compare.test;


import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.List;

import org.compare.TestUtil;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestBase;

/**
 * Unit test for simple App.
 */
public class ComparatorTest extends TestBase
{
	TestBase testbase;
	String api_path;
	String ui_path;
    /**
     * Rigorous Test :-)
     */
    @BeforeMethod
	public void setUp() {
		testbase = new TestBase();
		api_path=System.getProperty("user.home")+"\\weatherReportAPI.txt";
		ui_path=System.getProperty("user.home")+"\\weatherReportGUI.txt";


	}
    
    @Test
    public void weatherComparator() throws IOException {
//		System.out.println(TestUtil.readFileContents(api_path));
//		System.out.println(TestUtil.readFileContents(ui_path));
		List<String> apiList=TestUtil.readFileContents(api_path);
		List<String> guiList=TestUtil.readFileContents(ui_path);
		if(testbase.compareCity(apiList.get(0), guiList.get(0))) {
			System.out.println("-----------------------------------------------------------------");
			System.out.println("-----------------------------------------------------------------");
			System.out.println("Comparison for "+guiList.get(0));
			System.out.println("-----------------------------------------------------------------");
			System.out.println("-----------------------------------------------------------------");
			System.out.println(guiList.get(1));
			if(testbase.windComparison(apiList.get(2),guiList.get(2),prop.getProperty("Wind_variance"))) {
				System.out.println("Wind comparison successful as per variance");
			}
			else {
				System.out.println("Wind comparison failed");
			}
			if(testbase.valueComparison(apiList.get(3), guiList.get(3), prop.getProperty("Humidity_variance"))) {
				System.out.println("Humidity comparison successful as per variance");
			}
			else {
				System.out.println("Humidity comparison failed");
			}
			if(testbase.valueComparison(apiList.get(4), guiList.get(4), prop.getProperty("Temperature_variance"))) {
				System.out.println("Temperature comparison successful as per variance");
			}
			else {
				System.out.println("Temperature comparison failed");
			}
		}
		else {
			fail("City names do not match, Please rerun the test to compare same cities");
		}
		System.out.println("-----------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------");
		
		
    }
}
