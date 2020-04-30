package com.qa.listeners;



import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;



public class ExtendReportingTest {

	
	private static ExtentReports extent;
	private static ExtentTest test;
	private static Test test1;
	private static ExtentHtmlReporter htmlReporter;
	public static String filePath = "./extentreport.html";
	//public static String filePath = "./reports/extentreport.html";
	public static String folderName = "./extentreport.html";
	
	public static ExtentReports GetExtent(String projectName, String ReportName){
		
		if (extent != null)
                    return extent; //avoid creating new instance of html file
		
                extent = new ExtentReports();	
           //   klovReporter(projectName,ReportName);
                
		extent.attachReporter(getHtmlReporter(ReportName));
		return extent;
	}
 
	public static ExtentHtmlReporter getHtmlReporter(String ReportName) {
	
        htmlReporter = new ExtentHtmlReporter(filePath);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        
        
        htmlReporter.config().setDocumentTitle(ReportName);
        htmlReporter.config().setReportName(ReportName);
        String js = "var x = document.getElementsByTagName(\"img\");" + 
        		"var len = x.length;" + 
        		"for (i = 0; i < len; i++){"+ 
        		"x[i].removeAttribute(\"data-featherlight\");" + 
        		"x[i].setAttribute(\"width\",\"100%\");" + 
        		"}";
        htmlReporter.config().setJS(js);
        
        return htmlReporter;
	}
	
	public static ExtentTest createTest(String name, String description){
		
		test = extent.createTest(name, description);
		return test;
	}
	  public static ExtentTest createTest(String name) {
	        return createTest(name, null);
	    }

	public static ExtentTest pass( String description){
	
		test.pass(description);
		return test;
	}
	public static ExtentTest status( ){
		
		test.getStatus();
		return test;
	}
	public static ExtentTest failPEAL( String description){
		
		test.fail(description);
		return test;
		
	}
	public static ExtentTest fail( WebDriver driver,String description, String StepName) throws Exception
	{
		
		Date date = new Date(); 
		SimpleDateFormat formatter=new SimpleDateFormat("_dd_MM_yyyy_hh_mm_ss");
		String strDate = formatter.format(date);  
		String screenshotname=StepName.concat(strDate);

		String s=CaptureScreen(driver,screenshotname);
	
		test.fail(description).addScreenCaptureFromPath(s);

		//test.fail(description).addScreenCaptureFromPath(System.getProperty("user.dir") + File.separator+"screenshots"+File.separator+StepName+".png");

		
		return test;
	}
	

	public static ExtentTest category( String category){
		
		test.assignCategory(category);
		return test;
	}

	
	
	


	/*	public static void takescreenshot(WebDriver driver, String description) throws Exception
		{
			// Code to capture the screenshot file with date timestamp
			try
			{
				final Screenshot screenshot = new AShot().shootingStrategy(
						new ViewportPastingStrategy(1000)).takeScreenshot(driver);
					final BufferedImage image = screenshot.getImage();
					  ImageIO.write(image, "JPG", new File(System.getProperty("user.dir") + File.separator+"screenshots"+File.separator+description+".png"));	
				
			}
	
					 
					  
			catch (IOException e)
			 
			{
			  System.out.println(e.getMessage()) ;
			 }	
				
		}
		*/
		
	        
	        
	 

	
	/*public static void captureScreenShot(WebDriver driver,String description)
	{
		// Take screenshot and store as a file format   
		 
		 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);    
		// String src=((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);    
		try {
		// now copy the  screenshot to desired location using copyFile method
		 
		//FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "/screenshots/"+description+".png"));
			FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "/reports/screenshots/"+description+".jpg"));
			//FileUtils.copyFile(src, new File("C:/Compressed/screenshots/"+description+".jpg"));
			
		} catch (IOException e)
		 
		{
		  System.out.println(e.getMessage()) ;
		 }
		  }
	*/
	
	
	public static String  CaptureScreen(WebDriver driver, String description)
	{
		
	File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//String sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	
	String encodedBase64 = null;
	FileInputStream fileInputStreamReader = null;
	try {
	fileInputStreamReader = new FileInputStream(sourceFile);
	byte[] bytes = new byte[(int)sourceFile.length()];
	fileInputStreamReader.read(bytes);
	encodedBase64 = new String(Base64.encodeBase64(bytes));

        
	       String screenShotDestination = System.getProperty("user.dir") + "/reports/screenshots/"+description+".jpeg";
	       File destination = new File(screenShotDestination);
	       FileUtils.copyFile(sourceFile, destination);
	       
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	
	    return "data:image/jpeg;charset=utf-8;base64,"+encodedBase64;
	}
	
/*	public static void CaptureScreen(WebDriver driver, String description) throws Exception
    {
           // Code to capture the screenshot 
           try
           {
                 final Screenshot screenshot = new AShot().shootingStrategy(
                               new ViewportPastingStrategy(1000)).takeScreenshot(driver);
                        final BufferedImage image = screenshot.getImage();
                          ImageIO.write(image, "JPG", new File(System.getProperty("user.dir") + File.separator+"screenshots"+File.separator+description+".png")); 
                 
           }

                        
                          
           catch (IOException e)
           
           {
             System.out.println(e.getMessage()) ;
           }     
                 
    }
*/

	
	
	public static ExtentTest log( String description){
	
		test.info(description);
		return test;
	}
	public static ExtentTest remove( String description){
		
		extent.removeTest(test);;
		return test;
	}
	
	public static void flush(){
		
		extent.flush();
	}
	
	/*public static KlovReporter klovReporter(String projectName, String ReportName){
		KlovReporter klov = new KlovReporter();
		 
		// specify mongoDb connection
		klov.initMongoDbConnection("localhost", 27017);

		
		// specify project
		// ! you must specify a project, other a "Default project will be used"
		klov.setProjectName(projectName);

		// you must specify a reportName otherwise a default timestamp will be used
		klov.setReportName(ReportName);

		// URL of the KLOV server
		// you must specify the server URL to ensure all your runtime media is uploaded
		// to the server
		klov.setKlovUrl("http://localhost:9090");

		// finally, attach the reporter:
		extent.attachReporter(klov);
		return klov;
		
	}*/
	
	/*public void processPicture(String inputFilePath, String outputFilePath, int interpolationMethod, double sigmaFactor) 
	{

		double scaleFactor = 0.1;

		Opener opener = new Opener();

	    ImageProcessor ip = opener.openImage(inputFile).getProcessor();
	    

	 //  for medium sized screenshot use scaleFactor 0.15.
	    scaleFactor = 0.2;
	    	
	ip.blurGaussian(sigmaFactor / scaleFactor);
	ip.setInterpolationMethod(interpolationMethod);
	ImageProcessor outputProcessor = ip.resize((int)(ip.getWidth() * scaleFactor), (int)(ip.getHeight()*scaleFactor));
	IJ.saveAs(new ImagePlus("", outputProcessor), outputFilePath.substring(outputFilePath.lastIndexOf('.')+1), outputFilePath);
	    }*/
	
	 public static void resize(String destination,
	            String outputImagePath, int scaledWidth, int scaledHeight)
	            throws IOException
	 {
	        // reads input image
	        File inputFile = new File(destination);
	        BufferedImage inputImage = ImageIO.read(inputFile);
	 
	        // creates output image
	        BufferedImage outputImage = new BufferedImage(scaledWidth,
	                scaledHeight, inputImage.getType());
	 
	        // scales the input image to the output image
	        Graphics2D g2d = outputImage.createGraphics();
	        g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
	        g2d.dispose();
	 
	        // extracts extension of output file
	        String formatName = outputImagePath.substring(outputImagePath
	                .lastIndexOf(".") + 1);
	 
	        // writes to output file
	        ImageIO.write(outputImage, formatName, new File(outputImagePath));
	    }

}