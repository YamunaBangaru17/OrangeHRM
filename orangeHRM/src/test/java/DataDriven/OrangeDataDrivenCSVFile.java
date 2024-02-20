package DataDriven;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import orangeHRM.SetUpOrangeHRM;

public class OrangeDataDrivenCSVFile  extends SetUpOrangeHRM{
	
	@Test()
	public void test()
	{
		//Reads the file
		CSVReader reader = new CSVReader(new FileReader("//./src/test/DataDrivenCSVFile.csv"));
	}

}
