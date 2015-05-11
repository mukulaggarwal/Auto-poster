package magicBricks;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
//import java.util.NoSuchElementException;





import java.util.Date;
import java.util.Random;
import java.util.Scanner;




//import jxl.common.Logger;












import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbFile;


//import org.apache.log4j.Logger;
//import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import com.sun.jna.platform.unix.X11.XClientMessageEvent.Data;


public class MagicBricks {
	boolean flag=true;
	private String username="";
	private String password="";
	WebDriver driver=null;
	String locateBy;
	String value;
	String value2;
	String listing_id="property_id is: 123";  //as in getListing() we are dividing this listing_id into parts and to check base condition
	String parts[];
	MagicBricks()
	{
		driver = new FirefoxDriver();
		//driver = new ChromeDriver();
	}
	//private static Logger logger=Logger.getLogger(MagicBricks.class);

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

	//in this url of magic brick if opened in firefox

	public void getstarted(String url)
	{
		Date date =new Date();
		//logger.debug("inside getstarted method"+ date +"\n");
		try
		{
			driver.get(url);
		}

		catch(Exception e)
		{
			System.out.println("stuck up"+e);
		}

		System.out.println("\nposting is started");
	}

	//in this the property information is posted
	//groups are made according to the property information

	public void propertyInfo(SeleniumMethods sel1,DatabaseOperation data,WebDriver driver)
	{
		Date date =new Date();

		//logger.debug("inside propertyInfo method method"+ date +"\n");
		//it includes villa and residential house
		if(data.propClassId==1|| data.propClassId==5||data.propClassId==17||data.propClassId==26||data.propClassId==49||data.propClassId==51||data.propClassId==52||data.propClassId==60||data.propClassId==61)
		{
			if(data.propClassId==17||data.propClassId==61)
				sel1.dropdown(driver,"id","propertyType","text","Villa");
			else
				sel1.dropdown(driver,"id","propertyType","text","Residential House");
			sel1.dropdown(driver,"id","bedrooms","text",Integer.toString(data.bedrooms));
			sel1.dropdown(driver,"id","bathrooms","text",Integer.toString(data.bathrooms));
			/*System.out.println(Integer.toString(data.balcony)+"this is the balconies");
			if(Integer.toString(data.balcony).equals('0'))
			{
				sel1.dropdown(driver,"id","balconies","text","None");
			}
			else
			sel1.dropdown(driver,"id","balconies","text",Integer.toString(data.balcony));*/
			sel1.dropdown(driver,"id","furnished","text",data.furnishing); //sometime furnishing also give null valu
			int randomNum;
			int minimum=1;
			int maximum=20;
			randomNum = minimum + (int)(Math.random()*maximum);
			sel1.dropdown(driver,"id","totalFloorNumber","text",Integer.toString(randomNum));

		}

		//it include Builder Floor Apartment and service apartment
		else if(data.propClassId==16||data.propClassId==50||data.propClassId==56||data.propClassId==59)
		{
			if(data.propClassId==16||data.propClassId==50)
			{
				sel1.dropdown(driver,"id","propertyType","text","Builder Floor Apartment");
				sel1.dropdown(driver,"id","coveredAreaType","text","Sq-yrd");
			}
			else
				sel1.dropdown(driver,"id","propertyType","text","Service Apartment");
			sel1.dropdown(driver,"id","bedrooms","text",Integer.toString(data.bedrooms));
			sel1.dropdown(driver,"id","bathrooms","text",Integer.toString(data.bathrooms));
			//sel1.dropdown(driver,"id","balconies","text",Integer.toString(data.balcony));
			sel1.dropdown(driver,"id","furnished","text",data.furnishing);
			/*int randomNum;
			int minimum=1;
			int maximum=200;
			randomNum = minimum + (int)(Math.random()*maximum);
			sel1.dropdown(driver,"id","totalFloorNumber","text",Integer.toString(randomNum));
			sel1.dropdown(driver,"id","floorNumber","text",Integer.toString(randomNum));*/

			Random rg = new Random();

			int x, ttlflr;


				x = 3;
				ttlflr = rg.nextInt(x - 1 + 1) + 1;
			int flr = rg.nextInt(ttlflr);
			if(flr==0)
				flr=1;
			sel1.dropdown(driver,"id","floorNumber","text",Integer.toString(flr));
			sel1.dropdown(driver,"id","totalFloorNumber","text",Integer.toString(ttlflr));

		}

		//it include residential plot

		else if(data.propClassId==7||data.propClassId==53)
		{
			sel1.dropdown(driver,"id","propertyType","text","Residential Plot");
			sel1.dropdown(driver,"id","landAreaType","text","Sq-yrd");
		}

		//it include stdio apartment
		else if(data.propClassId==55)
		{
			sel1.dropdown(driver,"id","propertyType","text","Studio Apartment");
			sel1.dropdown(driver,"id","bathrooms","text",Integer.toString(data.bathrooms));
			//sel1.dropdown(driver,"id","balconies","text",Integer.toString(data.balcony));
			sel1.dropdown(driver,"id","furnished","id",data.furnishing);
			int randomNum;
			int minimum=1;
			int maximum=20;
			randomNum = minimum + (int)(Math.random()*maximum);
			sel1.dropdown(driver,"id","totalFloorNumber","text",Integer.toString(randomNum));
			sel1.dropdown(driver,"id","floorNumber","text",Integer.toString(randomNum));
		}

		//it include commercial office space, office in IT parks/SEZ and shopping mall
		else if(data.propClassId==12||data.propClassId==13||data.propClassId==21||data.propClassId==11||data.propClassId==14||data.propClassId==29||data.propClassId==2||data.propClassId==6||data.propClassId==37||data.propClassId==40)
		{
			if(data.propClassId==12||data.propClassId==13||data.propClassId==21)
			{
				sel1.dropdown(driver,"id","propertyType","text","Commercial Office Space");
			}
			else if(data.propClassId==11||data.propClassId==14||data.propClassId==29)
			{
				sel1.dropdown(driver,"id","propertyType","text","Office in IT Park/ SEZ");
			}
			else
			{
				sel1.dropdown(driver,"id","propertyType","text","Space in Shopping Mall");
			}

			sel1.dropdown(driver,"id","bathrooms","text",Integer.toString(data.bathrooms));
			sel1.dropdown(driver,"id","furnished","text",data.furnishing);
			int randomNum;
			int minimum=1;
			int maximum=20;
			randomNum = minimum + (int)(Math.random()*maximum);
			sel1.dropdown(driver,"id","totalFloorNumber","text",Integer.toString(randomNum));
			sel1.dropdown(driver,"id","floorNumber","text",Integer.toString(randomNum));
		}

		//it include commercial shop
		else if(data.propClassId==20||data.propClassId==27||data.propClassId==32||data.propClassId==38)
		{
			sel1.dropdown(driver,"id","propertyType","text","Commercial Shop");
			sel1.dropdown(driver,"id","furnished","text",data.furnishing);
			int randomNum;
			int minimum=1;
			int maximum=20;
			randomNum = minimum + (int)(Math.random()*maximum);
			sel1.dropdown(driver,"id","totalFloorNumber","text",Integer.toString(randomNum));
			sel1.dropdown(driver,"id","floorNumber","text",Integer.toString(randomNum));
		}

		//,commercial land
		else if(data.propClassId==18)
		{
			sel1.dropdown(driver,"id","propertyType","text","Commercial Land");
		}

		//, warehouse
		else if(data.propClassId==35||data.propClassId==45)
		{
			sel1.dropdown(driver,"id","propertyType","text","Warehouse/ Godown");
			sel1.dropdown(driver,"id","furnished","text",data.furnishing);
			int randomNum;
			int minimum=1;
			int maximum=20;
			randomNum = minimum + (int)(Math.random()*maximum);
			sel1.dropdown(driver,"id","totalFloorNumber","text",Integer.toString(randomNum));
			sel1.dropdown(driver,"id","floorNumber","text",Integer.toString(randomNum));
		}

		//, guest house
		else if(data.propClassId==57)
		{
			sel1.dropdown(driver,"id","propertyType","text","Guest House");
			sel1.dropdown(driver,"id","bedrooms","text",Integer.toString(data.bedrooms));
			sel1.dropdown(driver,"id","bathrooms","text",Integer.toString(data.bathrooms));
			//sel1.dropdown(driver,"id","balconies","text",Integer.toString(data.balcony));
			sel1.dropdown(driver,"id","furnished","text",data.furnishing);
			int randomNum;
			int minimum=1;
			int maximum=20;
			randomNum = minimum + (int)(Math.random()*maximum);
			sel1.dropdown(driver,"id","totalFloorNumber","text",Integer.toString(randomNum));
		}

		//hotel
		else if(data.propClassId==47)
		{
			sel1.dropdown(driver,"id","propertyType","text","Hotel");
			sel1.dropdown(driver,"id","bedrooms","text",Integer.toString(data.bedrooms));
			sel1.dropdown(driver,"id","bathrooms","text",Integer.toString(data.bathrooms));
			sel1.dropdown(driver,"id","furnished","text",data.furnishing);
			int randomNum;
			int minimum=1;
			int maximum=20;
			randomNum = minimum + (int)(Math.random()*maximum);
			sel1.dropdown(driver,"id","totalFloorNumber","text",Integer.toString(randomNum));
		}

		//hotel sites
		else if(data.propClassId==46||data.propClassId==48)
		{
			sel1.dropdown(driver,"id","propertyType","text","Hotel Sites");
		}

		//industrial land

		else if(data.propClassId==4||data.propClassId==58)
		{
			sel1.dropdown(driver,"id","propertyType","text","Industrial Land");
		}

		//industrial building
		else if(data.propClassId==28||data.propClassId==33)
		{
			sel1.dropdown(driver,"id","propertyType","text","Industrial Building");
			int randomNum;
			int minimum=1;
			int maximum=20;
			randomNum = minimum + (int)(Math.random()*maximum);
			sel1.dropdown(driver,"id","totalFloorNumber","text",Integer.toString(randomNum));
		}

		//farm house
		else if(data.propClassId==22||data.propClassId==54||data.propClassId==64)
		{
			sel1.dropdown(driver,"id","propertyType","text","Farm House");
			sel1.dropdown(driver,"id","furnished","text",data.furnishing);
			int randomNum;
			int minimum=1;
			int maximum=20;
			randomNum = minimum + (int)(Math.random()*maximum);
			sel1.dropdown(driver,"id","totalFloorNumber","text",Integer.toString(randomNum));
		}

		//not present in favista list
		else
		{
			System.out.println("sorry can't be processed");
			flag=false;
		}

	}

	//details like location and city is posted


	public void location(SeleniumMethods sel1,DatabaseOperation data,WebDriver driver)
	{
		//Date date =new Date();
		//logger.debug("inside location method"+ date +"\n");
		//first.click(driver,"linkText","Post Property");
		sel1.dropdown(driver,"id","quickCity","text",data.city);
		if(data.locality.startsWith("Sec"))
			data.locality=data.locality.replace(' ','-');
		System.out.println("this is the locality"+data.locality);
		sel1.dropdown(driver, "id","locatityDropDown","text",data.locality);
		//first.textarea(driver, "visibility", "societyText","data.");

	}

	//details like area is posted

	public void area(SeleniumMethods sel1,DatabaseOperation data,WebDriver driver)
	{
		//Date date =new Date();
		//logger.debug("inside area method"+ date +"\n");
		if(data.propClassId==7||data.propClassId==53||data.propClassId==18||data.propClassId==46||data.propClassId==48||data.propClassId==4||data.propClassId==58)
		{
			sel1.textarea(driver,"id","plotArea",String.valueOf(data.bArea));
		}
		else
		sel1.textarea(driver,"id","coveredArea",String.valueOf(data.bArea));
	}


	//details like price is posted


	public void price(SeleniumMethods sel1,DatabaseOperation data,WebDriver driver)
	{
		//Date date =new Date();
		//logger.debug("inside price method"+ date +"\n");
		sel1.textarea(driver,"id","totalPrice",String.valueOf(data.price));
		//sel1.textarea(driver,"id","totalPrice","1000000");
		//first.textarea(driver,"id","perUnitPrice","");
	}

	//details about transaction is posted


	public void transaction(SeleniumMethods sel1,DatabaseOperation data)
	{
		//Date date =new Date();
		//logger.debug("inside transaction method"+ date +"\n");
		if(data.newOrResale==2){
			System.out.println("\nWaiting for Resale radio button");
			sel1.click(driver,"xpath","//*[@id=\"transactionType\"]");
			System.out.println("Clicked Resale");
		}

		else if(data.newOrResale==1){
			System.out.println("\nWaiting for New Booking radio button");
			sel1.click(driver,"xpath","//*[@id=\"transactionType\"]");
			System.out.println("Clicked New Booking");
		}

		if(data.age.equals("Under-Construction") || data.age.equals("Recently launched") || data.age.equals("Scheduled to be launched soon") || data.age.equals("Planned to be launched soon")) {
			sel1.click(driver,"xpath","//*[@id=\"possessionStatus\"]");
			Calendar ca1 = Calendar.getInstance();

			ca1.setTime(data.possession_date);

			int year = ca1.get(Calendar.YEAR);
			int month = ca1.get(Calendar.MONTH);

			System.out.println("\nWaiting for possession year select");

			if (year == 2014) {
				sel1.dropdown(driver,"id","availFromYear","text","2014");
			}

			else if (year == 2015) sel1.dropdown(driver,"id","availFromYear","text","2015");

			else if (year == 2016) sel1.dropdown(driver,"id","availFromYear","text","2016");

			else if (year == 2017) sel1.dropdown(driver,"id","availFromYear","text","2017");
			else if (year == 2018)sel1.dropdown(driver,"id","availFromYear","text","2018");

			else if (year == 2019)sel1.dropdown(driver,"id","availFromYear","text","2019");

			else if (year == 2020)sel1.dropdown(driver,"id","availFromYear","text","2020");

			else sel1.dropdown(driver,"id","availFromYear","text","2024");
			System.out.println("month identify");

			if (month == 0) sel1.dropdown(driver,"id","availFromMonth","text","January");

			else if (month == 1) sel1.dropdown(driver,"id","availFromMonth","text","February");

			else if (month == 2) sel1.dropdown(driver,"id","availFromMonth","text","March");

			else if (month == 3) sel1.dropdown(driver,"id","availFromMonth","text","April");

			else if (month == 4) sel1.dropdown(driver,"id","availFromMonth","text","May");

			else if (month == 5)sel1.dropdown(driver,"id","availFromMonth","text","June");

			else if (month == 6)sel1.dropdown(driver,"id","availFromMonth","text","July");

			else if (month == 7) sel1.dropdown(driver,"id","availFromMonth","text","August");

			else if (month == 8) sel1.dropdown(driver,"id","availFromMonth","text","September");

			else if (month == 9) sel1.dropdown(driver,"id","availFromMonth","text","October");

			else if (month == 10) sel1.dropdown(driver,"id","availFromMonth","text","November");

			else if (month == 11) sel1.dropdown(driver,"id","availFromMonth","text","December");

			else sel1.dropdown(driver,"id","availFromMonth","text","December");
		}
		else if( data.age.equals("Ready-to-move-in")  || data.age.equals("Possession is readily available")) {
			sel1.click(driver,"xpath","//*[@id=\"possessionStatus\"]");
			sel1.dropdown(driver,"id","ageofcons","text","Age of Construction");
		}
		else if(!data.age.equals(""))
		{


			int age1  = Integer.parseInt(data.age);

			if (age1<5) sel1.dropdown(driver,"id","ageofcons","text","Less than 5 years");
			else if (age1<10) sel1.dropdown(driver,"id","ageofcons","text","5 to 10 years") ;
			else sel1.dropdown(driver,"id","ageofcons","text","Above 20 years");
		}

		//fetching of data about underconstruction or ready to move from description


		else
		{
			if(data.phase.equals("2"))
			{
				sel1.click(driver,"xpath","//*[@id=\"possessionStatus\"]");
				return ;
			}
			else if(data.phase.equals("1")||data.phase.equals("3")||data.phase.equals("4")||data.phase.equals("5"))
			{
				sel1.click(driver,"xpath","//*[@id=\"possessionStatus\"]");
				return ;
			}
			String descriptor = "";


			System.out.println("\nGetting description ...");

			try {
				URL ur = new URL("http://desc.favista.co/TemplateChimp/text.php?tid=60&type=%27Residential%20Project%27&mid=" +data.pID);
				Scanner s = new Scanner(ur.openStream());

				while(s.hasNext()){
					descriptor += " ";
					descriptor += s.next();
				}
				s.close();
				int begin=descriptor.indexOf("\"",descriptor.indexOf("Building Reputation:"))+17;
				int end=descriptor.indexOf(" phase",begin);
				String trans=descriptor.substring(begin,end).trim();
				if(trans.equals("Ready to Move"))
				{
					sel1.click(driver,"xpath","//*[@id=\"possessionStatus\"]");
				}
				else
				{
					sel1.click(driver,"xpath","//*[@id=\"possessionStatus\"]");
				}
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("finally transaction done");
	}


	//description is fetched from a url and all html tags are removed
	public void description(SeleniumMethods sel1,DatabaseOperation data)
	{
		//Date date =new Date();
		//logger.debug("inside description method"+ date +"\n");
		String description = "";


		System.out.println("\nGetting description ...");

		try {
			URL ur = new URL("http://desc.favista.co/TemplateChimp/text.php?tid=60&type=%27Residential%20Project%27&mid=" +data.pID);
			Scanner s = new Scanner(ur.openStream());

			while(s.hasNext()){
				description += " ";
				description += s.next();
			}
			s.close();
			String noHTMLString = description.replaceAll("\\<.*?>","");
			System.out.println("description is\t"+noHTMLString);
			sel1.textarea(driver,"id","propertyDescription",noHTMLString);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Original Description : \n" + description);
	}


	//spam check is evaluated


	public void spam(SeleniumMethods sel1,DatabaseOperation data,WebDriver driver)
	{
		//Date date =new Date();
		//logger.debug("inside spam method"+ date +"\n");
		String spam=sel1.returnText(driver,"id","captchaEquation");
		String []parts=spam.split(" ");
		int ans;
		if(parts[1].equals("+"))
			ans=(Integer.parseInt(parts[0])+Integer.parseInt(parts[2]));
		else if(parts[1].equals("-"))
			ans=(Integer.parseInt(parts[0])-Integer.parseInt(parts[2]));
		else if(parts[1].equals("*"))
			ans=(Integer.parseInt(parts[0])*Integer.parseInt(parts[2]));
		else
			ans=(Integer.parseInt(parts[0])/Integer.parseInt(parts[2]));


		System.out.println("spam result is "+ans);
		sel1.textarea(driver,"id","j_captcha_response",String.valueOf(ans));
	}


	// login is made via favista login id and password


	public void login(SeleniumMethods sel1,DatabaseOperation data)

	{
		//sel1.click(driver,"linkText","loginFb");
		//sel1.click(driver,"class","login_blk flt_rht");
		sel1.textarea(driver,"id","userName",username);
		System.out.println("username is entered");
		sel1.textarea(driver,"id","passwordExistingUser",password);
		System.out.println("password is entered");
		sel1.click(driver,"id","buttonLogin");
		System.out.println("click on login button");
	}

	//additional information is processed

	public void propertyFeature(SeleniumMethods sel1,DatabaseOperation data)
	{
		sel1.click(driver,"class","login_button");
		String address;
		address=data.project_name+","+data.locality+","+data.city;
		sel1.textarea(driver,"id","propAddress",address);
		sel1.dropdown(driver,"id","myTypeOwnVals","text","Freehold");
		int no_units=1;
		int maximum=7;
		no_units = (int)(Math.random()*maximum);
		sel1.textarea(driver,"id","unitsAvailable",Integer.toString(no_units));
		if(data.servantRoom!=0)
			sel1.click(driver,"id","additionalRoom4");
		if(data.study>=1)
			sel1.click(driver,"id","additionalRoom2");
		/*if(data.facing.equals("East CRM"))
			data.facing="East";
		sel1.dropdown(driver,"id","myFacingVals","text",data.facing);*/
		Sleep(10);
		//sel1.click(driver,"cssselector","Submit My Property");
		//System.out.println("clicked final postDone button");
		//System.out.println("property is posted on magicBrick");
	}

	public void insert_posting_record(SeleniumMethods sel1,DatabaseOperation data,String listing_id)
	{

		String sql4=null;
		try
		{
			DateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			Date date = new Date();


		sql4 = "insert into posted_queue(posting_id,property_id,project_id,site_id,posting_status,username,posting_date,auto_manual) values('"+listing_id+"','"+data.propClassId+"','"+data.pjID+"',5,'posted','"+data.username+"' , '"+dateFormat3.format(date)+"','auto')";

		System.out.println(sql4 + "\n" + listing_id);

		System.out.println("\ninserting property_id in posted queue");

		PreparedStatement selQuery2 = data.conn.prepareStatement(sql4);
		selQuery2.setQueryTimeout(10);

		selQuery2.executeUpdate();
		selQuery2.close();
		}
		catch(Exception e)
		{
			data.writeToFile(sql4);
			e.printStackTrace();
		}
	}


		public String getListing(SeleniumMethods sel1,DatabaseOperation data)
		{

			listing_id=sel1.returnText(driver,"class","confirmBrief");
			 String []parts=listing_id.split(" ");
			if(parts[2].equals("123"))
			{
				System.out.println("listing_id is not found");
			}
			else
			{
				listing_id=parts[2];
				return listing_id;
			}
			return "not found";
		}


		public void logout(SeleniumMethods sel1,DatabaseOperation data)
		{
			int counter=0;
			while(true)
			{
				try
				{
					sel1.click(driver,"id","signoutHeader");
					if(counter>15)
						break;
					sel1.click(driver,"id","buyRentType");
					break;
				}
				catch(Exception e)
				{
					counter++;
					System.out.println("trying to click on signout button");
				}
			}
			System.out.println("logged out");
		}

		public void driverClose()
		{
			driver.close();
		}


		//this function made call to other function according to need\\
	public void post(DatabaseOperation data)
	{
		String url="http://www.magicbricks.com/postproperty/post-property-for-sale-rent/residential-commercial";
		this.getstarted(url);
		SeleniumMethods sel1 = new SeleniumMethods(driver);
		System.out.println("working");
		//this.Sleep(10);
		login(sel1,data);
		propertyInfo(sel1,data,driver);
		if(flag==false)
		{
			System.out.println("nothing can be done");
		}
		else
		{
			try
			{
				sel1.dropdown(driver,"id","projectSocietySelect","text",data.project_name);
			}
			catch(Exception e)
			{
				System.out.println("project name for project id "+data.pjID+" can't be selected");
			}
			location(sel1,data,driver);
			area(sel1,data,driver);
			price(sel1,data,driver);
			if(data.propClassId==7||data.propClassId==53||data.propClassId==46||data.propClassId==48||data.propClassId==4||data.propClassId==58||data.propClassId==18)
			{
				if(data.newOrResale==2){
					System.out.println("\nWaiting for Resale radio button");
					sel1.click(driver,"xpath","//*[@id=\"transactionTypeLi\"]/div[2]/label[2]");
					System.out.println("Clicked Resale");
				}

				else if(data.newOrResale==1){
					System.out.println("\nWaiting for New Booking radio button");
					sel1.click(driver,"xpath","//*[@id=\"transactionTypeLi\"]/div[2]/label[1]");
					System.out.println("Clicked New Booking");
				}

			}
			else
			{
				transaction(sel1,data);
			}
			description(sel1, data);
			spam(sel1,data,driver);
			sel1.uploadPictures(driver,"fileupload",data,20,"both");//remeber to change id in selenium when using for magicbricks
			propertyFeature(sel1, data);
			while(true)
			{
				try
				{
					sel1.click(driver,"class","postDone");
					System.out.println("clicked final postDone button");
					listing_id=sel1.returnText(driver,"class","confirmBrief");
					break;
				}
				catch(Exception e)
				{
					System.out.println("not found the final submit button");
				}
			}

			listing_id=getListing(sel1,data);
			if(!listing_id.equals("not found"))
			{
			insert_posting_record(sel1,data,listing_id);
			data.updatePosting();
			}
			logout(sel1,data);
			driverClose();
		}
		System.out.println("psoted om magic bricks");
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
