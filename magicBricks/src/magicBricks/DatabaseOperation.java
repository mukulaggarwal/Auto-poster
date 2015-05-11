package magicBricks;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//import org.apache.log4j.Logger;

















import com.sun.jna.platform.unix.X11.XClientMessageEvent.Data;

public class DatabaseOperation {
	int count=1;
	int counter=0;
	static boolean flag=true;
	final String DB_URL = "jdbc:mysql://bo.favista.in/favista";
	Connection conn = null;
	int limit=1;
	private int queryTimeout=10;
	private  int site_id;
	String pID;

	String postingStatus="new";
	int is_hot;
	String extra_desc;
	int uid;
	String pjID;
	int propClassId;
	int location_id;
	int price;
	int bedrooms;
	int bathrooms;
	double bArea;
	String myTitle;
	String age;
	int possessionYear;
	int balcony;
	int study;
	int servantRoom;
	int newOrResale;
	String furnishing;
	String facing;
	java.sql.Date possession_date;
	private String USER="poster";
	private String PASS="SKW124dj";
	String locality;
	String city;
	private int pid;
	String username;
	String password;
	//private static Logger logger=Logger.getLogger(DatabaseOperation.class);
	String reserved_parking;
	String visitors_parking;
	String garbage;
	String water_supply;
	String gym;
	String kids_area;
	String party_area;
	String swimming_pool;
	String phase;
	String project_name;
	String water_treatment;
	String park;
	String sewage_treatment;
	String atm;
	static int posting;
	void establishConn(){

		// Register JDBC driver
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch (Exception c) {
			flag=false;
			System.out.println("\nO teri !!! error aa gyi : " + c);
			//sendmail("error : " + c);
		}


		//Open a connection
		System.out.println("\nConnecting to database...");

		try{
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
		}catch (java.sql.SQLException s){
			flag=false;
			//sendmail("error : " + s);
			System.out.println(("O teri !!! favista database se connect karne mein error aa gyi : " + s));}

	}

	/*public void sendmail(String msg)
	{
		System.out.println(msg + ". Sending email from poster.favista@gmail.com...");
		final String uname = "poster.favista@gmail.com";// USE VARIABLES HER WHICH ARE DEFINED ELSEWHERE
		final String password = "poster!@#$";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(uname, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("poster.favista@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("noEmail@nowhere.com"));
			message.setSubject("ace :  property id " + pID + " on site id " + site_id + " using username " + username);
			message.setText("" + msg);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("poster.favista@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("emailparsekarnewala@gmail.com"));
			message.setSubject("ace :property id " + pID + " on site id " + site_id + " using username " + username);
			message.setText( msg);

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}*/

	public void writeToFile(String sql4)
	{
		Date date =new Date();
		//logger.debug("error in inserting posting_id "+ date +"\n"+"\ndata is\n"+"posting_id is "+listing_id+"\nproperty_id is "+data.propClassId+"\nproject_id is "+data.pjID+"\nsite_id is "+5+"\nposting_status is posted\n"+"username is "+data.username);

		Calendar ca1 = Calendar.getInstance();

		ca1.setTime(date); 

		int year = ca1.get(Calendar.YEAR);
		int month = ca1.get(Calendar.MONTH);
		String pwd = System.getProperty("user.dir");
		String filename=pwd+"\\missed_leads_"+month+"_"+year+".txt";
		System.out.println("file name is "+filename);
		try {

			File file = new File(filename);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(sql4);
			bw.close();
			fw.close();

			System.out.println("Done writing in file");

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}


	public boolean getListing()
	{
		//fetch posting details and update database to indicate that this posting has been attempted

		System.out.println("\n\nLets start !!!\n\nCreating statement to fetch listing ...");

		String sql;

		DateFormat dateFormat3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date date = new Date();

		try{

			sql = "select * from posting_queue where is_lock = '0' and site_id=1 and posting_status <>'posted' and attempts<3 and posting_date <='"
					+dateFormat3.format(date)+"' LIMIT "+ limit +"  offset " +count+";";

			System.out.println("\n" + sql);
			PreparedStatement selQuery = conn.prepareStatement(sql);
			selQuery.setQueryTimeout(queryTimeout);

			ResultSet rs = selQuery.executeQuery();




			//Extract data from result set

			while(rs.next()){

				counter=1;

				site_id = rs.getInt("site_id");

				pID = rs.getString("property_id");

				username = rs.getString("username");

				password = rs.getString("password");

				postingStatus = rs.getString("posting_status");

				is_hot = rs.getInt("is_hot");

				extra_desc = rs.getString("extra_desc");

				uid = rs.getInt("uid");

			}

			if(counter==0){
				System.out.println("No listing found."); 
				//sendmail("not found");
				flag= false;
				return(flag);
			}

			System.out.println("\nPosting "+pID +" having posting status = " + postingStatus + " with " + "username "+ username + " and password " + password + " on site id " + site_id);

			//Clean-up environment
			selQuery.close();
			rs.close();




			String sql2;
			sql2 = "update posting_queue set attempts = attempts +1  where uid= '"+uid+"' and property_id=? ";

			System.out.println(sql2 + "\n? = " + pID);

			System.out.println("\nUpdating status 'attempts' in posting_queue ");

			PreparedStatement selQuery2 = conn.prepareStatement(sql2);
			selQuery2.setString(1, pID);
			selQuery2.setQueryTimeout(queryTimeout);

			//selQuery2.executeUpdate();
			selQuery2.close();
		}
		catch(Exception e)
		{
			System.out.println("error is present\n"+e);
			e.printStackTrace();
			count++;
		}
		return flag;


		/*site_id=5;
		pID="101367";
		return false;
		 */
	}

	void updatePosting()
	{
		String sql3=null;
		try
		{

			sql3 = "update posting_queue set posting_status='posted'  where uid= '"+uid+"' and property_id=? ";

			System.out.println(sql3 + "\n? = " + pID);

			System.out.println("\nUpdating status posting queue in posting_queue ");

			PreparedStatement selQuery5 = conn.prepareStatement(sql3);
			selQuery5.setString(1, pID);
			selQuery5.setQueryTimeout(queryTimeout);

			selQuery5.executeUpdate();
			selQuery5.close();
		}
		catch(SQLException e)
		{
			writeToFile(sql3);
			//logger.debug("error in update posting_status"+ date +"\n"+"\npsoted_status is posted\nproperty_id is "+propClassId);
			e.printStackTrace();
		}

	}

	public void getDetails()
	{
		try
		{
			//get details of the property

			System.out.println("\nCreating statement to fetch property details...");

			String sql3;
			sql3 = "SELECT p.project_id, p.location_id, p.study_room, p.balconies, p.servant_rooms, p.comes_from,"
					+ " p.super_area, p.furnishing, p.facing, p.project_name, p.bathrooms, p.possession_year, p.possession_date, "
					+ "p.price, p.bedrooms, p.property_class_id, p.super_area,p.age_of_construction, p.title "
					+ "FROM fv_properties as p "
					+ "WHERE p.id  = ? and p.is_deleted = '0' and p.is_verified = '1'; ";


			System.out.println("\n" + sql3 + "\n? = " + pID);

			PreparedStatement selQuery3 = conn.prepareStatement(sql3);
			selQuery3.setString(1, pID);
			selQuery3.setQueryTimeout(queryTimeout);

			ResultSet rs3 = selQuery3.executeQuery();

			if(!rs3.next()){
				System.out.println("\nDidn't get property details for id "+pID+" from fv_properties table in favista database");

			}
			rs3.beforeFirst();

			//Extract data from result set
			while(rs3.next()){

				//Retrieve by column name
				pjID = rs3.getString("project_id");

				propClassId = rs3.getInt("property_class_id");

				location_id = rs3.getInt("location_id");

				price = rs3.getInt("price");

				bedrooms = rs3.getInt("bedrooms");

				bathrooms = rs3.getInt("bathrooms");

				if (bathrooms==0) {bathrooms = bedrooms;}

				bArea = rs3.getDouble("super_area");

				myTitle = rs3.getString("title");

				age = rs3.getString("age_of_construction");

				possessionYear = rs3.getInt("possession_year");

				balcony = rs3.getInt("balconies");

				study = rs3.getInt("study_room");

				servantRoom = rs3.getInt("servant_rooms");

				newOrResale = rs3.getInt("comes_from");

				bArea = rs3.getInt("super_area");

				furnishing = rs3.getString("furnishing");

				if (furnishing.equals("")){furnishing = "Unfurnished";}

				facing = rs3.getString("facing");

				possession_date = rs3.getDate("possession_date");

			}

			System.out.println("\n\nproject id is\t"+pjID+"\nproperty class id is\t"+propClassId+"\nlocation id is\t"+location_id);
			System.out.println("price is\t"+price+"\nbedrooms\t"+bedrooms+"\nbathrooms \t"+bathrooms+"\narea is\t"+bArea);
			System.out.println("age os construction is\t"+age+"\nnew or resale\t"+newOrResale+"\npossession date is\t"+possession_date);
			//if possession date is null then remove it and email neelam
			/*if(possession_date == null){
				System.out.println("\nCreating statement to remove property id " + pID + " from posting_queue" );

				String sql0 = "delete from posting_queue where uid = ?;";

				System.out.println("\n" + sql0 + "\n? = " + uid);

				PreparedStatement selQuery0 = conn.prepareStatement(sql0);
				selQuery0.setInt(1, uid);
				selQuery0.setQueryTimeout(queryTimeout);

				int x = selQuery0.executeUpdate();
				System.out.println("\nNum of row deleted " + x);

				sendmail("Property id " + pID + " doesn't have possession date, removed it." );

				flag = false;
			}*/

			//Clean-up environment
			selQuery3.close();
			rs3.close();


			String sql5;
			sql5 = "SELECT c.1_loc, c.1_city"
					+ " FROM loc_map as c "
					+ "WHERE '"+location_id+"'=c.id; ";


			System.out.println("\n" + sql5 + "\n? = " + pID);

			PreparedStatement selQuery5 = conn.prepareStatement(sql5);
			selQuery3.setQueryTimeout(queryTimeout);

			ResultSet rs5 = selQuery5.executeQuery();

			if(!rs5.next()){
				System.out.println("\nDidn't get location details for id "+pID+" from fv_properties table in favista database");
				return ;
			}
			rs5.beforeFirst();

			//Extract data from result set
			while(rs5.next()){

				//Retrieve by column name
				locality = rs5.getString("1_loc");
				city = rs5.getString("1_city");
			}
			selQuery5.close();
			rs5.close();
			System.out.println("the city name is \t"+city+"and locality is\t"+locality);

			String sql7;
			sql7="select phase,name from fv_projects where id='"+pjID+"' and property_class_id='"+propClassId+"'";
			System.out.println("sql for project phase is "+sql7);
			PreparedStatement selQuery7 =conn.prepareStatement(sql7);
			selQuery7.setQueryTimeout(queryTimeout);

			ResultSet rs7=selQuery7.executeQuery();
			if(!rs7.next())
			{
				phase="2";
				System.out.println("didn't get the phase from the fv_projects table for project_id "+pjID+" and property_class_id is "+propClassId);
				return ;
			}

			rs7.beforeFirst();
			while(rs7.next())
			{
				phase=rs7.getString("phase");
				project_name=rs7.getString("name");
			}
			System.out.println("phase of project is "+phase+" and project_name is "+project_name);
		}

		catch(Exception e)
		{
			System.out.println("error is present"+e);
			count++;
		}
	}

	public void get_project_amenities()
	{
		String sql6;
		try
		{
			sql6 = "SELECT reserved_parking,visitor_parking,garbase_disposal_each_floor,"
					+ "water_supply_24x7,swimming_pool,gym,kids_play_area,community_party_area,water_treatment,park,sewage_treatment,campus_atm  from"
					+" fv_project_amenities where project_id='"+pjID+"'";


			System.out.println("\n" + sql6);

			PreparedStatement selQuery6 = conn.prepareStatement(sql6);
			selQuery6.setQueryTimeout(queryTimeout);

			ResultSet rs6 = selQuery6.executeQuery();

			if(!rs6.next()){
				System.out.println("\nDidn't get property additional  details for id "+pID+" from fv_project_amenities table in favista database");

			}
			rs6.beforeFirst();

			//Extract data from result set
			while(rs6.next()){

				//Retrieve by column name
				reserved_parking = rs6.getString("reserved_parking");
				visitors_parking = rs6.getString("visitor_parking");
				garbage = rs6.getString("garbase_disposal_each_floor");
				water_supply = rs6.getString("water_supply_24x7");
				swimming_pool = rs6.getString("swimming_pool");
				gym = rs6.getString("gym");
				kids_area = rs6.getString("kids_play_area");
				party_area = rs6.getString("community_party_area");
				water_treatment=rs6.getString("water_treatment");
				park=rs6.getString("park");
				sewage_treatment=rs6.getString("sewage_treatment");
				atm=rs6.getString("campus_atm");
			}
			System.out.println("reserved parking is "+reserved_parking+"\nvisitors parking is "+visitors_parking);
			System.out.println("space for garbage disposal is "+garbage+"\nservice for water supply is "+water_supply);
			System.out.println("swimming pool is "+swimming_pool+"\ngym is "+gym+"\nkids area for playing is "+kids_area);
			System.out.println("party area is "+party_area+"\nwater treatment facility is "+water_treatment);
			System.out.println("park is "+park+"\nsewage treatment is "+sewage_treatment+"\natm is "+atm);
			selQuery6.close();
			rs6.close();

		}
		catch(SQLException e)
		{
			e.printStackTrace();
			count++;
		}
	}

	public void connectionClose(DatabaseOperation data1)
	{
		try
		{
			data1.conn.close();
		}
		catch(java.sql.SQLException s)
		{
			s.printStackTrace();
		}
	}
	public static void main(String[] args) {
		DatabaseOperation data1 =new DatabaseOperation();

		while(flag)
		{
			data1.establishConn();
			flag=data1.getListing();
			if(!flag)
				break;
			data1.getDetails();
			data1.get_project_amenities();
			switch(data1.site_id)
			{

			case 5:
			{   System.out.println("inside magic brick"); //if the posting to be done at magic brick				
			MagicBricks brick =new MagicBricks();
			brick.post(data1);
			break;
			}
			case 1:
			{
				System.out.println("inside 99acres");		//if the posting to be done at 99acres
				Acres99 acre=new Acres99();
				acre.post(data1);
				break;
			}
			}
			data1.connectionClose(data1);
			posting++;
			System.out.println("no of posting done is "+posting);
		}
	}

}
