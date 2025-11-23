
package com.TestUtil;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

//import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.codesetup.Core;

public class Screenshotz extends Core {

	/*
	 * public static void captureScreenshot(WebDriver driver) throws IOException {
	 * // Capture screenshot using AShot library Screenshot screenshot = new
	 * AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).
	 * takeScreenshot(driver); // Specify the file path and name String filename =
	 * "c:\\tmp\\ElementScreenshot.jpg"; // Save the screenshot as a JPG file
	 * ImageIO.write(screenshot.getImage(), "jpg", new File(filename)); }
	 *
	 * public static void captureFullScreenshot(WebDriver driver) throws IOException
	 * { // Capture full page screenshot using AShot library Screenshot screenshot =
	 * new AShot().takeScreenshot(driver); // Specify the file path and name String
	 * filename = "c:\\tmp\\FullScreenshot.jpg"; // Save the screenshot as a JPG
	 * file ImageIO.write(screenshot.getImage(), "jpg", new File(filename)); }
	 *
	 * public static void captureElementScreenshot(WebDriver driver) throws
	 * IOException { // Capture screenshot of a specific element using AShot library
	 * Screenshot screenshot = new
	 * AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).
	 * takeScreenshot(driver); // Specify the file path and name String filename =
	 * "c:\\tmp\\ElementScreenshot.jpg"; // Save the screenshot as a JPG file
	 * ImageIO.write(screenshot.getImage(), "jpg", new File(filename)); }
	 */

    public static void captureScreenshotWithTimestamp(WebDriver driver) throws IOException {
        // Capture screenshot using Selenium's TakesScreenshot interface
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // Create a timestamp for the file name
        String timestamp = new SimpleDateFormat("yyyy MM dd   hh mm ss").format(new Date());
        // Specify the file path and name
        String filename = "c:\\tmp\\" + timestamp + ".png";
        // Save the screenshot
        FileUtils.copyFile(scrFile, new File(filename));
    }
}