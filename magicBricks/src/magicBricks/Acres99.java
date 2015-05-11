package magicBricks;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;












import org.openqa.selenium.By;
//import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Acres99 {

	boolean project_name_flag=false;
	boolean locality_flag=false;
	boolean flag=true;
	WebDriver driver=null;
	String locateBy;
	String value;
	String value2;
	private String visText;
	private int groupNo=11;
	private int checkReadyToMove=0;
	private String listing_id="123";
	Acres99()
	{
		driver = new FirefoxDriver();
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


	public void propertyInfo(SeleniumMethods sel1,DatabaseOperation data,WebDriver driver)
	{
		Date date =new Date();
		//logger.debug("inside propertyInfo method method"+ date +"\n");
		switch(data.propClassId)
		{
		case 1:  {
			visText =  "Residential Apartment";
			groupNo=1;
			break;
		}
		case 2:  
		{
			visText =  "Space in Retail Mall";
			groupNo=6;
			break;
		}
		case 3:  {
			visText =  "junk";
			groupNo=11;
			break;
		}
		case 4:  {
			visText =  "Industrial Lands/Plots";
			groupNo=7;
			break;
		}
		case 5:  
		{
			visText =  "Residential Apartment";
			groupNo=1;
			break;
		}
		case 6: 
		{
			visText =  "Space in Retail Mall";
			groupNo=6;
			break;
		}
		case 7:
		{
			visText =  "Residential Land";
			groupNo=7;
			break;
		}
		case 8:  
		{
			visText =  "junk";
			groupNo=11;
			break;
		}
		case 9:  
		{
			visText =  "Office space in Business Park";
			groupNo=6;
			break;
		}
		case 10: 
		{
			visText =  "junk";
			groupNo=11;
			break;
		}
		case 11:
		{
			visText =  "Office space in IT Park";
			groupNo=8;
			break;
		}
		case 12: 
		{
			visText =  "junk";
			groupNo=11;
			break;
		}
		case 13: 
		{
			visText =  "junk";
			groupNo=11;
			break;
		}
		case 14: 
		{
			visText =  "Office space in IT Park";
			groupNo=8;
			break;
		}
		case 15: 
		{
			visText =  "Independent/Builder Floor";
			groupNo=1;
			break;
		}
		case 16: 
		{
			visText =  "Independent/Builder Floor";
			groupNo=1;
			break;
		}
		case 17: 
		{
			visText =  "Independent House/Villa";
			groupNo=1;
			break;
		}
		case 18:
		{
			visText =  "Commercial Land/Inst. Land";
			groupNo=7;
			break;
		}
		case 19: 
		{
			visText =  "Commercial Office/Space";
			groupNo=6;
			break;
		}
		case 20:
		{
			visText =  "Commercial Shop";
			groupNo=6;
			break;
		}
		case 21: 
		{
			visText =  "Commercial Office/Space";
			groupNo=6;
			break;
		}
		case 22: 
		{
			visText =  "Farm House";
			groupNo=2;
			break;
		}
		case 23:
		{
			visText =  "Studio Apartment";
			groupNo=3;
			break;
		}
		case 24: 
		{
			visText =  "junk";
			groupNo=11;
			break;
		}
		case 25:
		{
			visText =  "junk";
			groupNo=11;
			break;
		}
		case 26:
		{
			visText =  "Residential Apartment";
			groupNo=1;
			break;
		}
		case 27:
		{
			visText =  "Commercial Office/Space";
			groupNo=6;
			break;
		}
		case 28:
		{
			visText =  "Other Commercial";
			groupNo=7;
			break;
		}
		case 29:
		{
			visText =  "Office space in IT Park";
			groupNo=8;
			break;
		}
		case 30:
		{
			visText =  "Commercial Office/Space";
			groupNo=6;
			break;
		}
		case 31:
		{
			visText =  "Commercial Office/Space"; 
			groupNo=6;
			break;
		}
		case 32:
		{
			visText =  "Commercial Shop";
			groupNo=6;
			break;
		}
		case 33:
		{
			visText =  "Other Commercial";
			groupNo=7;
			break;
		}
		case 34:
		{
			visText =  "Other Commercial";
			groupNo=7;
			break;
		}
		case 35:
		{
			visText =  "Ware House";
			groupNo=6;
			break;
		}
		case 36:
		{
			visText =  "Hotel/Resorts";
			groupNo=9;
			break;
		}
		case 37:
		{
			visText =  "junk"; 
			groupNo=11;
			break;
		}
		case 38:
		{
			visText =  "Commercial Office/Space";
			groupNo=6;
			break;
		}
		case 39:
		{
			visText =  "junk";
			groupNo=11;
			break;
		}
		case 40:
		{
			visText =  "Space in Retail Mall";
			groupNo=6;
			break;
		}
		case 41:
		{
			visText =  "junk";
			groupNo=11;
			break;
		}
		case 42:
		{
			visText =  "junk";
			groupNo=11;
			break;
		}
		case 43:
		{
			visText =  "junk";
			groupNo=11;
			break;
		}
		case 44:
		{
			visText =  "junk";
			groupNo=11;
			break;
		}
		case 45: 
		{
			visText =  "junk";
			groupNo=11;
			break;
		}
		case 46:
		{
			visText =  "junk";
			groupNo=11;
			break;
		}
		case 47:
		{
			visText =  "junk"; 
			groupNo=11;
			break;
		}
		case 48:
		{
			visText =  "junk";
			groupNo=11;
			break;
		}
		case 49:
		{
			visText =  "Independent House/Villa";
			groupNo=2;
			break;
		}
		case 50:
		{
			visText =  "Independent/Builder Floor";
			groupNo=1;
			break;
		}
		case 51: 
		{
			visText =  "Independent House/Villa";
			groupNo=2;
			break;
		}
		case 52:
		{
			visText =  "Independent House/Villa";
			groupNo=2;
			break;
		}
		case 53:
		{
			visText =  "plot";
			groupNo=7;
			break;
		}
		case 54:
		{
			visText =  "Farm House";
			groupNo=2;
			break;
		}
		case 55:
		{
			visText =  "Studio Apartment";
			groupNo=3;
			break;
		}
		case 56:
		{
			visText =  "Serviced Apartments";
			groupNo=4;
			break;
		}
		case 57:
		{
			visText =  "Guest-House/Banquet-Halls";
			groupNo=9;
			break;
		}
		case 58:
		{
			visText =  "junk";
			groupNo=11;
			break;
		}
		case 59:
		{
			visText =  "Serviced Apartments";
			groupNo=4;
			break;
		}
		case 60: 
		{
			visText =  "Independent House/Villa";
			groupNo=2;
			break;
		}
		case 61:
		{
			visText =  "Independent House/Villa";
			groupNo=2;
			break;
		}
		case 62:
		{
			visText =  "Independent House/Villa";
			groupNo=2;
			break;
		}
		case 63:
		{
			visText =  "Independent House/Villa";
			groupNo=2;
			break;
		}
		case 64:
		{
			visText =  "Farm House";
			groupNo=2;
			break;
		}
		case 65: 
		{
			visText =  "Business center";
			groupNo=10;
			break;
		}
		default:
		{
			visText = "junk";
			groupNo=11;
		}
		}
		if(groupNo==11)
		{
			System.out.println("the property name is not correct");
			flag=false;
			data.count++;
		}
		else
		{
			sel1.dropdown(driver,"id","TypeId","text",visText);
			if(groupNo==1||groupNo==2||groupNo==3||groupNo==4||groupNo==6||groupNo==8||groupNo==9||groupNo==10)
			{
				if(groupNo!=3&&groupNo!=6&&groupNo!=8&&groupNo!=10)
				{
					if(data.bedrooms==0)
						data.bedrooms=1;
					sel1.dropdown(driver, "id","Bedroom_NumId","text",Integer.toString(data.bedrooms));
				}
				if(groupNo!=11)
				{
					if(data.bathrooms==0)
						data.bathrooms=1;
					sel1.dropdown(driver,"id","Bathroom_NumId","text",Integer.toString(data.bathrooms));
				}
				if(groupNo!=2&&groupNo!=6&&groupNo!=8&&groupNo!=9&&groupNo!=10)
				{
					/*int randomNum,totalFloor;
					int minimum=1;
					int maximum=40;
					randomNum = minimum + (int)(Math.random()*maximum); 
					sel1.dropdown(driver,"id","Floor_NumId","text",Integer.toString(randomNum));
					totalFloor = minimum+ (int)(Math.random()*maximum);
					while(totalFloor<=randomNum)
						totalFloor+=2;
					sel1.dropdown(driver,"id","Total_FloorId","text",Integer.toString(totalFloor));*/
					
					Random rg = new Random();

					int x, ttlflr;

					if (visText.equals("Showroom") || visText.equals("Independent/Builder Floor")
							||visText.equals("Other Residential")){
						x = 3;
						ttlflr = rg.nextInt(x - 1 + 1) + 1;
					}

					else{
						x = 15;
						ttlflr = rg.nextInt(x - 10 + 1) + 10;
					}

					int flr = rg.nextInt(ttlflr);
					if(flr==0)
						flr=1;
					sel1.dropdown(driver,"id","Floor_NumId","text",Integer.toString(flr));
					sel1.dropdown(driver,"id","Total_FloorId","text",Integer.toString(ttlflr));

				}
				if(groupNo==9)
				{
					sel1.dropdown(driver,"id","Quality_RatingId","text","No Rating");
				}

				if(data.newOrResale==2){
					System.out.println("\nWaiting for Resale radio button");
					sel1.click(driver,"xpath","//*[@id=\"Transact_TypeId1\"]");
					//System.out.println("Clicked Resale");
				}

				else if(data.newOrResale==1){
					System.out.println("\nWaiting for New Booking radio button");
					sel1.click(driver,"xpath","//*[@id=\"Transact_TypeId2\"]");
					//System.out.println("Clicked New Booking");
				}
				if(data.age.equals("Under-Construction") || data.age.equals("Recently launched") || data.age.equals("Scheduled to be launched soon") || data.age.equals("Planned to be launched soon")) {
					sel1.dropdown(driver, "id","AgeId","text","Under Construction ");
					Calendar ca1 = Calendar.getInstance();

					ca1.setTime(data.possession_date); 

					int year = ca1.get(Calendar.YEAR);
					int month = ca1.get(Calendar.MONTH);
					System.out.println("\nWaiting for possession year select");
					if (year == 2014)
					{
						sel1.dropdown(driver,"id","AvailabilityId","text","2014");
					}

					else if (year == 2015) sel1.dropdown(driver,"id","AvailabilityId","text","2015");

					else if (year == 2016) sel1.dropdown(driver,"id","AvailabilityId","text","2016");

					else if (year == 2017) sel1.dropdown(driver,"id","AvailabilityId","text","2017");
					else if (year == 2018)sel1.dropdown(driver,"id","AvailabilityId","text","2018");

					else if (year == 2019)sel1.dropdown(driver,"id","AvailabilityId","text","2019");

					else if (year == 2020)sel1.dropdown(driver,"id","AvailabilityId","text","2020");

					else if(year==2021) sel1.dropdown(driver,"id","AvailabilityId","text","2021");
					else sel1.dropdown(driver, "id", "AvailabilityId","text","Within 6 Months");
					if(year>=2014&&year<=2021)
					{
						System.out.println("month identify");

						if (month == 0) sel1.dropdown(driver,"id","AvailabilityMonthId","text","January");

						else if (month == 1) sel1.dropdown(driver,"id","AvailabilityMonthId","text","February");

						else if (month == 2) sel1.dropdown(driver,"id","AvailabilityMonthId","text","March");

						else if (month == 3) sel1.dropdown(driver,"id","AvailabilityMonthId","text","April");

						else if (month == 4) sel1.dropdown(driver,"id","AvailabilityMonthId","text","May");

						else if (month == 5)sel1.dropdown(driver,"id","AvailabilityMonthId","text","June");

						else if (month == 6)sel1.dropdown(driver,"id","AvailabilityMonthId","text","July");

						else if (month == 7) sel1.dropdown(driver,"id","AvailabilityMonthId","text","August");

						else if (month == 8) sel1.dropdown(driver,"id","AvailabilityMonthId","text","September");

						else if (month == 9) sel1.dropdown(driver,"id","AvailabilityMonthId","text","October");

						else if (month == 10) sel1.dropdown(driver,"id","AvailabilityMonthId","text","November");

						else if (month == 11) sel1.dropdown(driver,"id","AvailabilityMonthId","text","December");

						else sel1.dropdown(driver,"id","AvailabilityMonthId","text","December");
					}

				}

				else if(!data.age.equals(""))
				{
					checkReadyToMove=1;
					int age1  = Integer.parseInt(data.age);
					if (age1<5) sel1.dropdown(driver,"id","AgeId","text","1-5 Year Old Property ");
					else if (age1<10) sel1.dropdown(driver,"id","AgeId","text","5-10 Year Old Property") ;
					else sel1.dropdown(driver,"id","AgeId","text","10+ Year Old Property");
				}
				else if( data.age.equals("Ready-to-move-in")  || data.age.equals("Possession is readily available")) {
					sel1.dropdown(driver,"id","AvailabilityId","text","Ready To Move");
				}
				else
				{
					if(data.phase.equals("2"))
					{
						sel1.dropdown(driver, "id","AgeId","text","Under Construction");
						return ;
					}
					if(data.phase.equals("1")||data.phase.equals("3")||data.phase.equals("4")||data.phase.equals("5"))
					{
						sel1.dropdown(driver,"id","AvailabilityId","text","Ready To Move");
						return ;
					}
					if(checkReadyToMove==0)
						sel1.dropdown(driver,"id","AgeId","text","0-1 Year Old Property");
					String descriptor = "";


					//System.out.println("\nGetting description ...");

					try {
						URL ur = new URL("http://desc.favista.co/TemplateChimp/text.php?tid=60&type=%27Residential%20Project%27&mid=" +data.pID);
						Scanner s = new Scanner(ur.openStream());

						while(s.hasNext()){
							descriptor += " ";
							descriptor += s.next();
						}
						s.close();
						if("Building Reputation:".toLowerCase().contains(descriptor.toLowerCase()))
						{
						int begin=descriptor.indexOf("\"",descriptor.indexOf("Building Reputation:"))+17;
						int end=descriptor.indexOf(" phase",begin);
						String trans=descriptor.substring(begin,end).trim();
						if(trans.equals("Ready to Move"))
						{
							sel1.dropdown(driver,"id","AvailabilityId","text","Ready To Move");
						}
						else
						{
							Calendar ca1 = Calendar.getInstance();

							ca1.setTime(data.possession_date); 

							int year = ca1.get(Calendar.YEAR);
							int month = ca1.get(Calendar.MONTH);
							System.out.println("\nWaiting for possession year select");
							if (year == 2014)
							{
								sel1.dropdown(driver,"id","AvailabilityId","text","By 2014");
							}

							else if (year == 2015) sel1.dropdown(driver,"id","AvailabilityId","text","By 2015");

							else if (year == 2016) sel1.dropdown(driver,"id","AvailabilityId","text","By 2016");

							else if (year == 2017) sel1.dropdown(driver,"id","AvailabilityId","text","By 2015");
							else if (year == 2018)sel1.dropdown(driver,"id","AvailabilityId","text","By 2018");

							else if (year == 2019)sel1.dropdown(driver,"id","AvailabilityId","text","By 2019");

							else if (year == 2020)sel1.dropdown(driver,"id","AvailabilityId","text","By 2020");

							else if(year==2021) sel1.dropdown(driver,"id","AvailabilityId","text","By 2021");
							else sel1.dropdown(driver, "id", "AvailabilityId","text","Within 6 Months");
							if(year>=2014&&year<=2021)
							{
								System.out.println("month identify");

								if (month == 0) sel1.dropdown(driver,"id","AvailabilityMonthId","text","January");

								else if (month == 1) sel1.dropdown(driver,"id","AvailabilityMonthId","text","February");

								else if (month == 2) sel1.dropdown(driver,"id","AvailabilityMonthId","text","March");

								else if (month == 3) sel1.dropdown(driver,"id","AvailabilityMonthId","text","April");

								else if (month == 4) sel1.dropdown(driver,"id","AvailabilityMonthId","text","May");

								else if (month == 5)sel1.dropdown(driver,"id","AvailabilityMonthId","text","June");

								else if (month == 6)sel1.dropdown(driver,"id","AvailabilityMonthId","text","July");

								else if (month == 7) sel1.dropdown(driver,"id","AvailabilityMonthId","text","August");

								else if (month == 8) sel1.dropdown(driver,"id","AvailabilityMonthId","text","September");

								else if (month == 9) sel1.dropdown(driver,"id","AvailabilityMonthId","text","October");

								else if (month == 10) sel1.dropdown(driver,"id","AvailabilityMonthId","text","November");

								else if (month == 11) sel1.dropdown(driver,"id","AvailabilityMonthId","text","December");

								else sel1.dropdown(driver,"id","AvailabilityMonthId","text","December");
							}
						}
					}
						else
						{
							sel1.dropdown(driver, "id","AgeId","text","Under Construction");
							 sel1.dropdown(driver,"id","AvailabilityId","text","By 2021");
							 sel1.dropdown(driver,"id","AvailabilityMonthId","text","December");
						}
					}
					catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("finally transaction done");
			}

			else if(groupNo==5||groupNo==7)
			{
				if( data.age.equals("Ready-to-move-in")  || data.age.equals("Possession is readily available")) {
					sel1.dropdown(driver,"id","AvailabilityId","text","Ready To Move");
				}
				else
				{
					if(checkReadyToMove==0)
						sel1.dropdown(driver,"id","AgeId","text","0-1 Year Old Property");
					String descriptor = "";


					System.out.println("\nGetting description ...");

					try {
						URL ur = new URL("http://desc.favista.co/ClassifiedPaid/index.php?con=0&id=" +data.pID);
						Scanner s = new Scanner(ur.openStream());

						while(s.hasNext()){
							descriptor += " ";
							descriptor += s.next();
						}
						s.close();
						if("Building Reputation:".toLowerCase().contains(descriptor.toLowerCase()))
						{
						int begin=descriptor.indexOf("\"",descriptor.indexOf("Building Reputation:"))+17;
						int end=descriptor.indexOf(" phase",begin);
						String trans=descriptor.substring(begin,end).trim();
						if(trans.equals("Ready to Move"))
						{
							sel1.dropdown(driver,"id","AvailabilityId","text","Ready To Move");
						}
						else
						{
							Calendar ca1 = Calendar.getInstance();

							ca1.setTime(data.possession_date); 

							int year = ca1.get(Calendar.YEAR);
							int month = ca1.get(Calendar.MONTH);
							System.out.println("\nWaiting for possession year select");
							if (year == 2014)
							{
								sel1.dropdown(driver,"id","AvailabilityId","text","By 2014");
							}

							else if (year == 2015) sel1.dropdown(driver,"id","AvailabilityId","text","By 2015");

							else if (year == 2016) sel1.dropdown(driver,"id","AvailabilityId","text","By 2016");

							else if (year == 2017) sel1.dropdown(driver,"id","AvailabilityId","text","By 2015");
							else if (year == 2018)sel1.dropdown(driver,"id","AvailabilityId","text","By 2018");

							else if (year == 2019)sel1.dropdown(driver,"id","AvailabilityId","text","By 2019");

							else if (year == 2020)sel1.dropdown(driver,"id","AvailabilityId","text","By 2020");

							else if(year==2021) sel1.dropdown(driver,"id","AvailabilityId","text","By 2021");
							else sel1.dropdown(driver, "id", "AvailabilityId","text","Within 6 Months");
							if(year>=2014&&year<=2021)
							{
								System.out.println("month identify");

								if (month == 0) sel1.dropdown(driver,"id","AvailabilityMonthId","text","January");

								else if (month == 1) sel1.dropdown(driver,"id","AvailabilityMonthId","text","February");

								else if (month == 2) sel1.dropdown(driver,"id","AvailabilityMonthId","text","March");

								else if (month == 3) sel1.dropdown(driver,"id","AvailabilityMonthId","text","April");

								else if (month == 4) sel1.dropdown(driver,"id","AvailabilityMonthId","text","May");

								else if (month == 5)sel1.dropdown(driver,"id","AvailabilityMonthId","text","June");

								else if (month == 6)sel1.dropdown(driver,"id","AvailabilityMonthId","text","July");

								else if (month == 7) sel1.dropdown(driver,"id","AvailabilityMonthId","text","August");

								else if (month == 8) sel1.dropdown(driver,"id","AvailabilityMonthId","text","September");

								else if (month == 9) sel1.dropdown(driver,"id","AvailabilityMonthId","text","October");

								else if (month == 10) sel1.dropdown(driver,"id","AvailabilityMonthId","text","November");

								else if (month == 11) sel1.dropdown(driver,"id","AvailabilityMonthId","text","December");

								else sel1.dropdown(driver,"id","AvailabilityMonthId","text","December");
							}
						}
						}
						else
						{

							sel1.dropdown(driver, "id","AgeId","text","Under Construction ");
							 sel1.dropdown(driver,"id","AvailabilityId","text","By 2021");
							 sel1.dropdown(driver,"id","AvailabilityMonthId","text","December");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}

				}
			}
		}
	}


	public void location(SeleniumMethods sel1,DatabaseOperation data,WebDriver driver)
	{
		System.out.println("in location");
		sel1.dropdown(driver,"id","selectcity","text",data.city);
/*		try
		{
			File file=new File("location.txt");
			FileReader r=new FileReader(file);
			BufferedReader reader=new BufferedReader(r);
			String line;
			while((line=reader.readLine())!=null)
			{
				String content[]=line.split(":");
				if(content[0].equals(data.locality))
				{
					data.locality=content[1];
					locality_flag=true;
				}
			}
			reader.close();
		}
		catch(IOException ei)
		{
			System.out.println("error in reading file from location.txt");
			ei.printStackTrace();
		}
		*/
		try
		{
			File file=new File("project_name.txt");
			FileReader r=new FileReader(file);
			BufferedReader reader=new BufferedReader(r);
			String line;
			while((line=reader.readLine())!=null)
			{
				String content[]=line.split(":");
				if(content[0].equals(data.project_name))
				{
					if(!content[1].equals("Specify Others"))
					data.project_name=content[1];
					project_name_flag=true;
				}
			}
			reader.close();
		}
		catch(IOException e)
		{
			System.out.println("error in reading file from project_name.txt");
			e.printStackTrace();
		}
		if(project_name_flag)
		{
		sel1.dropdown(driver,"id","localityDD","text",data.locality);
		if(data.project_name.equals("Specify Others"))
		sel1.textarea(driver,"id","property_from_building",data.project_name);
		else
			sel1.dropdown(driver,"id","buildingDD","text",data.project_name);
		String address=data.project_name+","+data.locality+","+data.city;
		sel1.textarea(driver,"id","AddressId",address);
		}
		else 
		{
			System.out.println("project name or location is not matched with favista");
			driver.close();
		}
		project_name_flag=false;
		locality_flag=false;
	}

	public void area(SeleniumMethods sel1,DatabaseOperation data,WebDriver driver)
	{
		System.out.println("in area");
		if(visText.equals("Residential Land")||visText.equals("Commercial Land/Inst. Land")||visText.equals("Industrial Lands/Plots"))
		{
			sel1.textarea(driver,"id","plotSizeId",String.valueOf(data.bArea));
			sel1.dropdown(driver,"id","plotSizeIdUnit","text","Sq. Yards");
		}
		else
		{
			sel1.textarea(driver,"id","builtAreaId",String.valueOf(data.bArea));
		if(groupNo==6)
		{
			sel1.dropdown(driver,"id","builtAreaIdUnit","text","Sq. Yards");
		}
		else
			sel1.dropdown(driver,"id","builtAreaIdUnit","text","Sq.Ft.");
		}
	}


	public void price(SeleniumMethods sel1,DatabaseOperation data,WebDriver driver)
	{
		System.out.println("in price");
		if(data.postingStatus.equals("duplicate"))
		{
			double price;
			int minimum=1000;
			int maximum=4000;
			price = data.price + minimum + (int)(Math.random()*maximum);
			System.out.println("price is\t"+price);
			sel1.textarea(driver, "id","PriceId",String.valueOf(price));
		}
		else
		sel1.textarea(driver, "id","PriceId",String.valueOf(data.price));
	}

	public void description(SeleniumMethods sel1,DatabaseOperation data,WebDriver driver)
	{
		String description = "";


		System.out.println("\nGetting description ...");

		try {
			URL ur = new URL("http://desc.favista.co/ClassifiedPaid/index.php?con=0&id=" +data.pID);
			Scanner s = new Scanner(ur.openStream());

			while(s.hasNext()){
				description += " ";
				description += s.next();
			}
			s.close();
			String noHTMLString = description.replaceAll("\\<.*?>","");
			System.out.println("description is\t"+noHTMLString);
			sel1.textarea(driver,"id","DescriptionId",noHTMLString);
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Original Description : \n" + description);

	}

	public void login(SeleniumMethods sel1,DatabaseOperation data,WebDriver driver)

	{
		//data.username="favistagurgaon";
		//data.password="AB@CFq1";
		sel1.textarea(driver,"name","username",data.username);
		sel1.textarea(driver,"name","password",data.password);
		sel1.click(driver,"id","submit_query1");
	}

	public void selecting_package(SeleniumMethods sel1,DatabaseOperation data,WebDriver driver)
	{
		if(data.username.equals("favistagurgaon"))
		sel1.dropdown(driver,"id","ListingCodeId","index","1");
		else if(data.username.equals("Favistaplatinum")||data.username.equals("SaurabhFavista")||data.username.equals("NipunFavista"))
		{
			sel1.dropdown(driver,"package","ListingCodeId","","");
		}
		else if(data.username.equals("favista99")||data.username.equals("favista"))
		{
			sel1.dropdown(driver,"package","ListingCodeId","","");
		}
	}

	public void logout(SeleniumMethods sel1,DatabaseOperation data)
	{
		sel1.dropdown(driver,"class","lgnhdr","text","Logout");
		System.out.println("logged out");
	}
	
	public String getListing(SeleniumMethods sel1,DatabaseOperation data)
	{
		Sleep(10);
		String listing=null;
		listing=sel1.returnText(driver,"tagName","body");
		int begin=listing.indexOf("http://www.99acres.com/",listing.indexOf("Direct Link to your property ["));
		System.out.println(begin);
		int end=listing.indexOf(" ]",begin);
		begin+=23;
		listing_id=listing.substring(begin,end).trim();
		if(!listing_id.equals("123"))
		return listing_id;
		else return("not found");
		
	}
	

	public void driverClose()
	{
		driver.close();
	}
	
	public void insert_posting_record(SeleniumMethods sel1,DatabaseOperation data,String listing_id)
	{
		String sql4=null;
		try
		{
			DateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			Date date = new Date();

		
		sql4 = "insert into posted_queue(posting_id,property_id,project_id,site_id,posting_status,username,posting_date,auto_manual) values('"+listing_id+"','"+data.propClassId+"','"+data.pjID+"',1,'posted','"+data.username+"' , '"+dateFormat3.format(date)+"','auto')";

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
	
	public void upload_additional_photos(SeleniumMethods sel1,DatabaseOperation data,WebDriver driver)
	{
		//sel1.click(driver,"id","link5");
		sel1.uploadPictures(driver,"file_browse", data,10,"main");
		//sel1.uploadPictures(driver,"file_browse", data,1,"main");
		/*sel1.click(driver,"id","PhotoTabROOMS");
		sel1.uploadPictures(driver,"file_browse", data,1,"main");
		sel1.uploadPictures(driver,"file_browse", data,1,"main");
		sel1.uploadPictures(driver,"file_browse", data,1,"main");*/
		sel1.click(driver,"id","PhotoTabFLOOR_PLAN");
		sel1.uploadPictures(driver,"file_browse", data,10,"floor");
		/*sel1.click(driver,"id","PhotoTabOTHERS");
		sel1.uploadPictures(driver,"file_browse", data,1,"main");
		sel1.uploadPictures(driver,"file_browse", data,1,"main");*/
		sel1.click(driver, "cssSelector", "[class='yellowSubmit f16 floatl'][type='submit'][value='Save & Continue']");
		SeleniumMethods.counter_floor=0;
		SeleniumMethods.counter_main=0;
		
	}
	
	public void additional_info(SeleniumMethods sel1,DatabaseOperation data,WebDriver driver)
	{
		sel1.click(driver,"id","link3");
		if(data.balcony!=0 && data.balcony<=3)
		{
			sel1.dropdown(driver,"id","Balcony_Num","text",Integer.toString(data.balcony));
		}
		else if(data.balcony>3)
		{
			sel1.dropdown(driver,"id","Balcony_Num","text","More than 3");
		}
		if(data.servantRoom!=0)
		{
			sel1.click(driver,"id","3rooms");
		}
		if(data.furnishing.equals("Semi furnished"))
		{
			sel1.click(driver,"id","4furnish");
		}
		else if(data.furnishing.equals("Full furnished")||data.furnishing.equals("Fully Furnished"))
		{
			sel1.click(driver,"id","1furnish");
		}
		else
			sel1.click(driver,"id","2furnish");
		
		if(data.reserved_parking.equals("1"))
		{
			sel1.click(driver,"id","chbox floatl");
		}
		
		sel1.click(driver, "cssSelector","[class='yellowSubmit f16 floatl'][type='submit'][value='Save & Continue']");
		
		if(data.water_treatment.equals("1"))
		sel1.click(driver,"id","amenties32");
		
		if(data.water_supply.equals("1"))
		{
			sel1.click(driver,"id","amenties24");
		}
		
		if(data.visitors_parking.equals("1"))
		{
			sel1.click(driver, "id","amenties19");
		}
		
		if(data.swimming_pool.equals("1"))
		{
			sel1.click(driver, "id", "amenties1");
		}
		
		if(data.park.equals("1"))
		{
			sel1.click(driver, "id", "amenties6");
		}
		
		if(data.gym.equals("1"))
		{
			sel1.click(driver, "id", "amenties12");
		}
		
		if(data.party_area.equals("1"))
		{
			sel1.click(driver, "id","amenties3");
		}
		
		if(data.sewage_treatment.equals("1"))
		{
			sel1.click(driver, "id", "amenties25");
		}
		
		if(data.atm.equals("1"))
		{
			sel1.click(driver, "id", "amenties28");
		}
		
		sel1.click(driver, "cssSelector","[class='yellowSubmit f16 floatl'][type='submit'][value='Save & Continue']");
	}
	
	public void post(DatabaseOperation data)
	{
		String url="http://www.99acres.com/do/advertiseproperty/?p1=0&p2=S&p3=0&lstAcn=HP_R&lstAcnId=0";
		this.getstarted(url);
		SeleniumMethods sel1 = new SeleniumMethods(driver);
		//this.Sleep(10);
		login(sel1,data,driver);
		selecting_package(sel1,data,driver);
		propertyInfo(sel1,data,driver);
		if(flag)
		{
		location(sel1,data,driver);
		area(sel1,data,driver);
		price(sel1,data,driver);
		description(sel1, data, driver);
		sel1.uploadPictures(driver,"file_browse", data,1,"main");
		sel1.click(driver,"id","submitform1");
		additional_info(sel1,data,driver);
		upload_additional_photos(sel1,data,driver);
		sel1.click(driver,"id","submitform2");
		listing_id=getListing(sel1,data);
		if(!listing_id.equals("not found"))
		{
		insert_posting_record(sel1,data,listing_id);
		data.updatePosting();
		}
		//logout(sel1,data);
		Sleep(10);
		driverClose();
		System.out.println("done posting on 99acres");
		}
	}
}
