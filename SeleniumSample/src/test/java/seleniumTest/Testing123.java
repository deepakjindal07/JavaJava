package seleniumTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Testing123 {

	public static void main(String[] args) throws InterruptedException {

		int[] in = { 1, 2, 3, 4 }; // sum=6

		for (int i = 0; i < in.length; i++)
		{
			for (int j = i+1; j < in.length; j++)
			{
				//System.out.println("test");
				if (in[i] + in[j] == 6)
				{
					System.out.println("Found " + in[i] + "and" + in[j]);
					
				}
			}
		}

	}

}
