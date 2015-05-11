package magicBricks;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;
import jcifs.smb.SmbFileOutputStream;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;
import com.sun.jna.platform.unix.X11.XClientMessageEvent.Data;

public class SeleniumMethods {

	static int counter=0;
	static int counter_main=0;
	static int counter_floor=0;
	static int index =2;
	int waitDuration=10;
	WebDriverWait waitVar=null;
	SeleniumMethods(WebDriver driver)
	{

		waitVar=new WebDriverWait(driver,waitDuration);

	}
	
	public void Sleep(int time)
	{
		try{
			System.out.println("Sleeping");
			Thread.sleep(time * 1000);
		}catch(InterruptedException ex){
			ex.printStackTrace();
		}
		System.out.println("wake up");
	}
	
	
	public void click(WebDriver driver,String locateBy,String value)

	{
		System.out.println("waiting for "+locateBy+ " "+ value);
		if(locateBy.equals("id")){
			waitVar.until(ExpectedConditions.presenceOfElementLocated(By.id(value)));
			driver.findElement(By.id(value)).click();
			System.out.println("Clicked");
		}

		else if(locateBy.equals("class")){

			waitVar.until(ExpectedConditions.presenceOfElementLocated(By.className(value)));
			driver.findElement(By.className(value)).click();
			System.out.println("Clicked");


		}

		else if(locateBy.equals("xpath")){
			//waitVar.until(ExpectedConditions.presenceOfElementLocated(By.xpath(value)));
			driver.findElement(By.xpath(value)).click();
			System.out.println("Clicked");
		}

		else if(locateBy.equals("css")){
			waitVar.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(value)));
			driver.findElement(By.cssSelector(value)).click();
			System.out.println("Clicked");
		}

		else if(locateBy.equals("linkText")){
			waitVar.until(ExpectedConditions.presenceOfElementLocated(By.linkText(value)));
			driver.findElement(By.linkText(value)).click();
			System.out.println("Clicked ");
		}

		else if(locateBy.equals("tagName")){
			waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(value)));
			driver.findElement(By.tagName(value)).click();
			System.out.println("Clicked ");
		}

		else if(locateBy.equals("name")){
			waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
			driver.findElement(By.name(value)).click();
			System.out.println("Clicked ");
		}
		else if(locateBy.equals("cssselector"))
		{
			waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value)));
			driver.findElement(By.cssSelector("[name='"+value+"']")).click();
			System.out.println("clicked");
		}
		else if(locateBy.equals("cssSelector"))
		{
			System.out.println("in cssSelector");
			waitVar.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(value)));
			driver.findElements(By.cssSelector(value)).get(index).click();
			System.out.println("clicked");
			index++;
			System.out.println("value of index is "+index);
		}
	}

	public void dropdown(WebDriver driver,String locateBy,String value,String option,String value2)
	{
		try
		{
			System.out.println("waiting for "+locateBy+ " "+ value+" selecting "+option+" "+ value2);
			Select sel=null;
			if(locateBy.equals("id"))
			{
				System.out.println("in id");
				waitVar.until(ExpectedConditions.presenceOfElementLocated(By.id(value)));
				sel = new Select(driver.findElement(By.id(value)));

			}
			else if(locateBy.equals("class")){
				waitVar.until(ExpectedConditions.presenceOfElementLocated(By.className(value)));
				sel = new Select(driver.findElement(By.className(value)));
			}

			else if(locateBy.equals("xpath")){
				waitVar.until(ExpectedConditions.presenceOfElementLocated(By.xpath(value)));
				sel = new Select(driver.findElement(By.xpath(value)));
			}

			else if(locateBy.equals("css")){
				waitVar.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(value)));
				sel = new Select(driver.findElement(By.cssSelector(value)));
			}

			else if(locateBy.equals("name")){
				waitVar.until(ExpectedConditions.presenceOfElementLocated(By.name(value)));
				System.out.println("Waiting for dropdown OVER");
				sel = new Select(driver.findElement(By.name(value)));
			}

			else if(locateBy.equals("package"))
			{
				System.out.println("in id");
				waitVar.until(ExpectedConditions.presenceOfElementLocated(By.id(value)));
				sel = new Select(driver.findElement(By.id(value)));
				int options=sel.getOptions().size()-1;
				sel.selectByIndex(options);
			}

			if(option.equals("text"))
			{
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 
				sel.selectByVisibleText(value2);
			}
			else if(option.equals("index"))
				sel.selectByIndex(Integer.parseInt(value2));
			//sel.getOptions().get(0).getText();


			System.out.println("selected  "+value+"\t"+value2);
		}
		catch(NoSuchElementException e){
			e.printStackTrace();System.out.println("\nDidn't find dropdown menu.");
		}
	}

	public void textarea(WebDriver driver,String locateBy,String value,String text)
	{
		System.out.println("waiting for "+locateBy+ " "+ value+" entering "+text);
		if(locateBy.equals("id")){
			//System.out.println("welcome in id");
			waitVar.until(ExpectedConditions.presenceOfElementLocated(By.id(value)));
			//System.out.println("Waiting to type OVER");
			driver.findElement(By.id(value)).sendKeys(text);
			//driver.findElement(By.id(value)).getText();
			if(!value.equals("userName")||!value.equals("passwordExistingUser"))
				System.out.println("Typed " + text);
		}

		else if(locateBy.equals("class")){
			waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.className(value)));
			//System.out.println("Waiting to type OVER");

			driver.findElement(By.className(value)).sendKeys(text);
			if(!value.equals("userName")||!value.equals("passwordExistingUser"))
				System.out.println("Typed " + text);
		}

		else if(locateBy.equals("xpath")){
			//System.out.println("enter in xpath of text");
			waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
			//System.out.println("Waiting to type OVER");

			driver.findElement(By.xpath(value)).sendKeys(text);
			if(!value.equals("userName")||!value.equals("passwordExistingUser"))
				System.out.println("Typed " + text);
		}
		else if(locateBy.equals("name"))
		{
			waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
			//System.out.println("Waiting to type OVER");
			driver.findElement(By.name(value)).sendKeys(text);
		}


	}


	public void uploadPictures(WebDriver driver,String location,DatabaseOperation data,int max,String condition)
	{
		//int counter=0;
		try
		{

			String user = "image:favista@123";
			NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(user);
			String paths = "smb://192.168.0.252/Favista_Website_Image/hello.txt";
			SmbFile sFile = new SmbFile(paths, auth);
			SmbFileOutputStream sfos = new SmbFileOutputStream(sFile);
			//sfos.write("Mune".getBytes());

			System.out.println("\nWaiting to upload pic num ");
			String path="//192.168.0.252/Favista_Website_Image/";
			if(data.city.equals("Gurgaon"))
			{
				path=path+"Gurgaon Final/";
			}
			else if(data.city.equals("Noida"))
				path=path+"Noida Final/";
			else if(data.city.equals("Mumbai"))
				path=path+"Mumbai Final/";
			else
				path=path+data.city+"/";

			path=path+data.pjID+"/";
			String path1=path+"Main Image";
			String path2=path+"Floor Plan";
			if(condition.equals("both"))
			{
				System.out.println("the path to be searched is \t"+path1);
				File directory = new File(path1);  
				File[] files = directory.listFiles();  
			for (int index = counter; index < files.length; index++)  
			{  
				WebElement pu = driver.findElement(By.className(location));
				String pictureLoc=files[index].toString();
				String ext = FilenameUtils.getExtension(pictureLoc);
				if(!ext.equals("db"))
				{
					System.out.println(pictureLoc); 
					pu.sendKeys(pictureLoc);
					counter++;
				}
			}  
			while(counter<=max)
			{
				File directory2 = new File(path2);  
				File[] files2 = directory2.listFiles();  

				for (int index = counter; index < files2.length; index++)  
				{  
					WebElement pu = driver.findElement(By.className(location));  
					String pictureLoc=files2[index].toString();
					String ext = FilenameUtils.getExtension(pictureLoc);
					if(!ext.equals("db"))
					{
						System.out.println(pictureLoc); 
						pu.sendKeys(pictureLoc);
						counter++;
					}
					if(counter>=max)
						break;
				}
				break;
			}
			System.out.println("done image part");
			}
			else if(condition.equals("main"))
			{
				System.out.println("in main image part");

				File directory2 = new File(path1);  
				File[] files2 = directory2.listFiles();  

				for (int index = counter_main; index < files2.length; index++)  
				{  
					WebElement pu = driver.findElement(By.className(location));  
					String pictureLoc=files2[index].toString();
					String ext = FilenameUtils.getExtension(pictureLoc);
					if(!ext.equals("db"))
					{
						System.out.println(pictureLoc); 
						Sleep(8);
						pu.sendKeys(pictureLoc);
						counter_main++;
					}
					if(counter_main>=max)
						break;
				}
			}
			
			else if(condition.equals("floor"))
			{
				System.out.println("in floor image part");
				File directory3 = new File(path2);  
				File[] files3 = directory3.listFiles();  

				for (int index = counter_floor; index < files3.length; index++)  
				{  
					WebElement pu = driver.findElement(By.className(location));  
					String pictureLoc=files3[index].toString();
					String ext = FilenameUtils.getExtension(pictureLoc);
					/*String sections[]=pictureLoc.split("\\");
					String img_property_id[]=sections[5].split("-");*/
						if(!ext.equals("db"))
						{
						System.out.println(pictureLoc); 
						pu.sendKeys(pictureLoc);
						counter_floor++;
						}
					if(counter_floor>=max)
						break;
			}
			}
			System.out.println("done image part");
			sfos.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		/*try
		{
		String user = "image:favista@123";
        NtlmPasswordAuthentication auth = new NtlmPasswordAuthentication(user);
        String path = "smb://192.168.0.252/Favista_Website_Image/hello.txt";
        SmbFile sFile = new SmbFile(path, auth);
       SmbFileOutputStream sfos = new SmbFileOutputStream(sFile);
        sfos.write("Mune".getBytes());
        //System.out.println("Done");

    	String path3="//192.168.0.252/Favista_Website_Image/Gurgaon Final/34/";
    	String path1=path3+"Main Image";
		String path2=path3+"Floor Plan";
		 File directory = new File(path1);  
	        File[] files = directory.listFiles();  

	        for (int index = 0; index < files.length; index++)  
	        {  
	        	WebElement pu = driver.findElement(By.id(location));
	           //Print out the name of files in the directory  
	           System.out.println(files[index].toString());  
	           String pictureLoc=files[index].toString();
	           pu.sendKeys(pictureLoc);
	           try
	           {
	   			System.out.println("Sleeping");
	   			Thread.sleep(5* 1000);
	   			}
	           catch(InterruptedException ex)
	           {
	   			ex.printStackTrace();	
	   		   }
	           counter++;
	   			if(counter>=max)
	   				break;
	        }  
	        while(counter<max)
	        {
	        	File directory2 = new File(path2);  
		        File[] files2 = directory2.listFiles();  

		        for (int index = 0; index < files2.length; index++)  
		        {  
		        	WebElement pu = driver.findElement(By.id(location));
		           //Print out the name of files in the directory  
		           System.out.println(files2[index].toString());  
		           String pictureLoc=files2[index].toString();
		           pu.sendKeys(pictureLoc);
				counter++;
				if(counter>=max)
					break;
		        }
		        break;
	        }
	        System.out.println("done image part");
	        sfos.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}*/
	}


	public String returnText(WebDriver driver,String locateBy,String value)
	{
		System.out.println("waiting for returning text of "+locateBy+ " "+ value);
		String result=null;
		if(locateBy.equals("id")){
			waitVar.until(ExpectedConditions.presenceOfElementLocated(By.id(value)));
			result=driver.findElement(By.id(value)).getText();
		}

		else if(locateBy.equals("class")){
			waitVar.until(ExpectedConditions.presenceOfElementLocated(By.className(value)));
			System.out.println("Waiting to type OVER");
			result=driver.findElement(By.className(value)).getText();
		}

		else if(locateBy.equals("xpath")){
			waitVar.until(ExpectedConditions.presenceOfElementLocated(By.xpath(value)));
			result=driver.findElement(By.xpath(value)).getText();
		}
		else if(locateBy.equals("tagName")){
			waitVar.until(ExpectedConditions.presenceOfElementLocated(By.tagName(value)));
			System.out.println("Waiting to type OVER");
			result=driver.findElement(By.tagName(value)).getText();

		}
		if(!locateBy.equals("tagName"))
		System.out.println("spam string is "+ result);
		return result;

	}

}



/*	else if(locateBy.equals("css"))
{

	if(site_id == 304 && value.equals(".maininput"))
	{
		splitstring = text.split(",");
		for (int i = 0; i < splitstring.length; i++) 
		{
			driver.findElement(By.cssSelector(value)).sendKeys(splitstring[i]);
			sleep(2);
			driver.findElement(By.cssSelector(value)).sendKeys(",");
		}
	}
	else
	{
		waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value)));
		System.out.println("Waiting to type OVER");

		driver.findElement(By.cssSelector(value)).sendKeys(text);
		System.out.println("Typed " + text);

	}

}

else if(locateBy.equals("tagName")){
	waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(value)));
	System.out.println("Waiting to type OVER");

	driver.findElement(By.tagName(value)).sendKeys(text);
	System.out.println("Typed " + text);
}

else if(locateBy.equals("name")){
	waitVar.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
	System.out.println("Waiting to type OVER");

	driver.findElement(By.name(value)).sendKeys(text);
	System.out.println("Typed " + text);
}


}*/
