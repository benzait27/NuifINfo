package org.lip6.struts.domain;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/*import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import javax.naming.InitialContext;*/

import org.lip6.struts.domain.Contact.Contact;

public class DAOContact {

	//private final static String RESOURCE_JDBC = "java:comp/env/jdbc/dsMyDB";
	 String host = "localhost";
	 String base = "contact";
	 String url = "jdbc:mysql://localhost:3306/jee";
	 String driver = "com.mysql.jdbc.Driver";
		String uid = "root"; String passwd = "zaki";
		java.sql.Connection cx = null;
		java.sql.PreparedStatement preparedStatement;
		
		
		public ArrayList<Group> afficheGroup() throws ClassNotFoundException, SQLException{
			ArrayList<Group> group = new ArrayList<Group>(); 
			String Query = "select * from groupe";
			Class.forName(driver);
			cx = DriverManager.getConnection(url, uid, passwd);
			 preparedStatement = cx.prepareStatement(Query);
			 
			 ResultSet result = preparedStatement.executeQuery();
	          
				while (result.next()) {
					Group ctc = new Group(); 
					ctc.setNom(result.getString("groupName"));
					group.add(ctc);
				}

				preparedStatement.close();
				return group;
		}
		
	public ArrayList<Contact> afficheContact () throws ClassNotFoundException, SQLException{
		ArrayList<Contact> contacts = new ArrayList<Contact>(); 
		String Query = "select * from contact";
		Class.forName(driver);
		cx = DriverManager.getConnection(url, uid, passwd);
		 preparedStatement = cx.prepareStatement(Query);
		 
		 ResultSet result = preparedStatement.executeQuery();
          
			while (result.next()) {
				Contact ctc = new Contact(); 
				ctc.setNum(result.getInt("ID_CONTACT"));
				ctc.setNom(result.getString("FIRSTNAME"));
				ctc.setPrenom(result.getString("LASTNAME"));
				ctc.setMail(result.getString("EMAIL"));
				System.out.println("******");
	address ad = new address(result.getString("street"), result.getString("city"),result.getString("zip"), result.getString("country"));
			    ctc.setAd(ad);
	             contacts.add(ctc);
			}

			preparedStatement.close();
			return contacts;
	}
	
	/*public String addContact(Contact c) {
		try {
			final Context lContext = new InitialContext();
			final DataSource lDataSource = (DataSource) lContext.lookup(RESOURCE_JDBC);
			final Connection lConnection  = lDataSource.getConnection();
			
			// adding a new contact
			final PreparedStatement lPreparedStatementCreation = 
					
			lConnection.prepareStatement("INSERT INTO contact(ID_CONTACT, FIRSTNAME, LASTNAME, EMAIL) VALUES(?, ?, ?, ?)");
			
			lPreparedStatementCreation.setLong(1, c.getNum());
			lPreparedStatementCreation.setString(2, c.getNom());
			lPreparedStatementCreation.setString(3, c.getPrenom());
			lPreparedStatementCreation.setString(4, c.getMail());
			lPreparedStatementCreation.executeUpdate();
			
			return null;
		} catch (NamingException e) {
		
			return "NamingException : " + e.getMessage();
		
		} catch (SQLException e) {

			return "SQLException : " + e.getMessage();
			
		}
	}*/
	
public String addContact(Contact c ) throws ClassNotFoundException{
		
		String msg = null;
	
		try{
		
			 String insertAddressQuery = "INSERT INTO contact(ID_CONTACT, FIRSTNAME, LASTNAME, EMAIL,street,city,zip,country) VALUES (?,?,?,?,?,?,?,?)";
			
		
			
				Class.forName(driver);
				cx = DriverManager.getConnection(url, uid, passwd);
				 preparedStatement = cx.prepareStatement(insertAddressQuery);
				 preparedStatement.setInt(1, (int) c.getNum());
					preparedStatement.setString(2, c.getNom());
					preparedStatement.setString(3, c.getPrenom());
					preparedStatement.setString(4, c.getMail());
					preparedStatement.setString(5, c.getAd().getStreet());
					preparedStatement.setString(6, c.getAd().getCity());
					preparedStatement.setString(7, c.getAd().getZip());
					preparedStatement.setString(8, c.getAd().getContry());
					preparedStatement.executeUpdate();

					preparedStatement.close();
				} catch (ClassNotFoundException e) {
					msg =  "classe du pilote introuvable";
				// 
				} catch (SQLException e) {
					msg= "accès à la base refusé";
				// 
				} finally {
				try { if (cx != null) cx.close(); }
				catch (SQLException e) { msg =  "error"; }
				}
	
			
		return msg;

		//Set values of parameters in the query.
		
	
	}
public String addGroup(Group c ) throws ClassNotFoundException{
	
	String msg = null;

	try{
	
		 String insertAddressQuery = "INSERT INTO groupe(groupName) VALUES (?)";
		
	
		
			Class.forName(driver);
			cx = DriverManager.getConnection(url, uid, passwd);
			 preparedStatement = cx.prepareStatement(insertAddressQuery);
				preparedStatement.setString(1, c.getNom());
	

				preparedStatement.executeUpdate();

				preparedStatement.close();
			} catch (ClassNotFoundException e) {
				msg =  "classe du pilote introuvable";
			// 
			} catch (SQLException e) {
				msg= "accès à la base refusé";
			// 
			} finally {
			try { if (cx != null) cx.close(); }
			catch (SQLException e) { msg =  "error"; }
			}

		
	return msg;

	//Set values of parameters in the query.
	

}

public String addPhone(Phone p, long id ) throws ClassNotFoundException{
	
	String msg = null;

	try{
	
		 String insertAddressQuery = "INSERT INTO phone(kind,num,ID_CONTACT) VALUES (?,?,?)";
		
	
		
			Class.forName(driver);
			cx = DriverManager.getConnection(url, uid, passwd);
			 preparedStatement = cx.prepareStatement(insertAddressQuery);
				preparedStatement.setString(1, p.getKind());
				preparedStatement.setLong(2, p.getNum());
				preparedStatement.setLong(3, id);
				preparedStatement.executeUpdate();

				preparedStatement.close();
			} catch (ClassNotFoundException e) {
				msg =  "classe du pilote introuvable";
			// 
			} catch (SQLException e) {
				msg= "accès à la base refusé";
			// 
			} finally {
			try { if (cx != null) cx.close(); }
			catch (SQLException e) { msg =  "error"; }
			}

		
	return msg;

	//Set values of parameters in the query.
	

}
	
	public ArrayList<Contact> SearchContact( String nom) throws SQLException, ClassNotFoundException{
		String Query = "select * from contact where FIRSTNAME = '"+nom+"' ";
		Class.forName(driver);
		cx = DriverManager.getConnection(url, uid, passwd);
		
		
		 preparedStatement = cx.prepareStatement(Query);
		 	
			ResultSet result = preparedStatement.executeQuery();
            ArrayList<Contact> contacts = new ArrayList<Contact>();
			while (result.next()) {
				
				Contact ctc = new Contact(); 
				ctc.setNum(result.getInt("ID_CONTACT"));
				ctc.setNom(result.getString("FIRSTNAME"));
				ctc.setPrenom(result.getString("LASTNAME"));
				ctc.setMail(result.getString("EMAIL"));
				address ad = new address(result.getString("street"), result.getString("city"),result.getString("zip"), result.getString("country"));
	            ctc.setAd(ad);
                contacts.add(ctc);
			}
			preparedStatement.close();
		return contacts;		
	}
	
	
	public ArrayList<Object> affichePhone() throws SQLException, ClassNotFoundException{
		ArrayList<Object> ph = new ArrayList<Object>(); 
		String Query = "select * from phone INNER JOIN contact ON phone.ID_CONTACT = contact.ID_CONTACT";
		Class.forName(driver);
		cx = DriverManager.getConnection(url, uid, passwd);
		 preparedStatement = cx.prepareStatement(Query);
		 
		 ResultSet result = preparedStatement.executeQuery();
          
			while (result.next()) {
				ph.add(result.getString("kind"));
				ph.add(result.getInt("num"));
				ph.add(result.getInt("ID_CONTACT"));
				ph.add(result.getString("FIRSTNAME"));
				ph.add(result.getString("LASTNAME"));
				ph.add(result.getString("EMAIL"));
				ph.add(result.getString("street"));
				ph.add(result.getString("city"));
				ph.add(result.getString("zip"));
				ph.add(result.getString("country"));
			}
         int ms = 0;
			Query = "select * from phone where phone.ID_CONTACT ='"+ms+"'";
			 preparedStatement = cx.prepareStatement(Query);
			  
			result = preparedStatement.executeQuery();
	          
				while (result.next()) {
					ph.add(result.getString("kind"));
					ph.add(result.getInt("num"));
					ph.add("");
					ph.add("");
					ph.add("");
					ph.add("");
					ph.add("");
					ph.add("");
					ph.add("");
					ph.add("");
				}

				preparedStatement.close();
			return ph;
	}

		
	
	
	
	
	
	public String UpdateContact(long id , Contact c) throws ClassNotFoundException, SQLException{
		
		String requp = "UPDATE contact SET   FIRSTNAME ='"+c.getNom()+"' , LASTNAME= '"+ c.getPrenom()+"' , EMAIL = '"+ c.getMail()+
				"', street='"+c.getAd().getStreet()+"', city='"+c.getAd().getCity()+"', zip='"+c.getAd().getZip()+"', country='"+c.getAd().getContry()+"' where ID_CONTACT ='"+id+"' ";
		Class.forName(driver);
		cx = DriverManager.getConnection(url, uid, passwd);
		Contact ctc = new Contact(); 
		
		 preparedStatement = cx.prepareStatement(requp);
		 preparedStatement.executeUpdate();
		 
		/* ctc.setNum(c.getNum());
		 ctc.setNom(c.getNom());
		 ctc.setPrenom(c.getPrenom());
		 ctc.setMail(c.getMail());
		 ctc.setNum(c.get);
		 ctc.setNom(c.getNom());
		 ctc.setPrenom(c.getPrenom());
		 ctc.setMail(c.getMail());*/
		 
		System.out.println("on veut modifier le contact num :"+ id +"par les nouvelles infos ");
		
		return null ; 
		
	}
	public void DeleteContact(int num) throws SQLException, ClassNotFoundException{

		String update = "DELETE FROM contact WHERE ID_CONTACT="+num+"";
		Class.forName(driver);
		cx = DriverManager.getConnection(url, uid, passwd);
		java.sql.PreparedStatement preparedStatement = cx.prepareStatement(update);
		preparedStatement.executeUpdate();	
		// DELETE FROM PHONE
		update = "DELETE FROM phone WHERE ID_CONTACT="+num+"";
	    preparedStatement = cx.prepareStatement(update);
		preparedStatement.executeUpdate();	
		preparedStatement.close();

	}

	public String addaddresse(address ad) {
		String msg = null;

		try{
		
			 String insertAddressQuery = "INSERT INTO address(street,city,zip,country) VALUES (?,?,?,?)";
			
		
			
				Class.forName(driver);
				cx = DriverManager.getConnection(url, uid, passwd);
				 preparedStatement = cx.prepareStatement(insertAddressQuery);
					preparedStatement.setString(1, ad.getStreet());
					preparedStatement.setString(2, ad.getCity());
					preparedStatement.setString(3, ad.getZip());
					preparedStatement.setString(4, ad.getContry());
					preparedStatement.executeUpdate();

					preparedStatement.close();
				} catch (ClassNotFoundException e) {
					msg =  "classe du pilote introuvable";
				// 
				} catch (SQLException e) {
					msg= "accès à la base refusé";
				// 
				} finally {
				try { if (cx != null) cx.close(); }
				catch (SQLException e) { msg =  "error"; }
				}

			
		return msg;

		//Set values of parameters in the query.
	}

	public ArrayList<Object> SearchPhone(String search) throws SQLException, ClassNotFoundException {
		ArrayList<Object> ph = new ArrayList<Object>(); 
		String Query = "select * from phone INNER JOIN contact ON phone.ID_CONTACT = contact.ID_CONTACT where phone.num='"+search+"'";
		Class.forName(driver);
		cx = DriverManager.getConnection(url, uid, passwd);
		 preparedStatement = cx.prepareStatement(Query);
		 
		 ResultSet result = preparedStatement.executeQuery();
          int i = 0;
			while (result.next()) {
				i++;
				ph.add(result.getString("kind"));
				ph.add(result.getInt("num"));
				ph.add(result.getInt("ID_CONTACT"));
				ph.add(result.getString("FIRSTNAME"));
				ph.add(result.getString("LASTNAME"));
				ph.add(result.getString("EMAIL"));
				ph.add(result.getString("street"));
				ph.add(result.getString("city"));
				ph.add(result.getString("zip"));
				ph.add(result.getString("country"));
			}
           if (i==0)
           {
            Query = "select * from phone where phone.num='"+search+"'";
       		 preparedStatement = cx.prepareStatement(Query);

       		 result = preparedStatement.executeQuery();
       			while (result.next()) {
       				ph.add(result.getString("kind"));
       				ph.add(result.getInt("num"));
       				ph.add(result.getInt("ID_CONTACT"));
       				ph.add(null);
       				ph.add(null);
       				ph.add(null);
       				ph.add(null);
       				ph.add(null);
       				ph.add(null);
       				ph.add(null);
       			} 
           }
			preparedStatement.close();
			return ph;
	}

	public Contact SearchContact(int num)throws SQLException, ClassNotFoundException{
		String Query = "select * from contact where ID_CONTACT = '"+num+"' ";
		Class.forName(driver);
		cx = DriverManager.getConnection(url, uid, passwd);
		Contact ctc = new Contact(); 
		//ctc=null;
		 preparedStatement = cx.prepareStatement(Query);
		 	
			ResultSet result = preparedStatement.executeQuery();
			int i=0;
			while (result.next()) {
				i++;
				ctc.setNum(result.getInt("ID_CONTACT"));
				ctc.setNom(result.getString("FIRSTNAME"));
				ctc.setPrenom(result.getString("LASTNAME"));
				ctc.setMail(result.getString("EMAIL"));
	address ad = new address(result.getString("street"), result.getString("city"),result.getString("zip"), result.getString("country"));
	            ctc.setAd(ad);
			}
			preparedStatement.close();
			if (i==0) ctc=null;
		return ctc;		
	}

	public void DeleteContact(ArrayList<Object> attribute) throws SQLException, ClassNotFoundException {
		String update = "DELETE FROM phone WHERE kind='"+(String)attribute.get(0)+"' and num='"+(int)attribute.get(1)+"' ";
		Class.forName(driver);
		cx = DriverManager.getConnection(url, uid, passwd);
		java.sql.PreparedStatement preparedStatement = cx.prepareStatement(update);
		preparedStatement.executeUpdate();	
		
		preparedStatement.close();
		
	}

	public String UpdatePhone(String kind, int num, Phone c) throws SQLException, ClassNotFoundException {
		String requp = "UPDATE phone SET   kind ='"+c.getKind()+"' , num= '"+ c.getNum()+"' where kind ='"+kind+"' and num= '"+num+"' ";
		Class.forName(driver);
		cx = DriverManager.getConnection(url, uid, passwd);
		Contact ctc = new Contact(); 
		
		 preparedStatement = cx.prepareStatement(requp);
		 preparedStatement.executeUpdate();
		
		return null ; 
		
	}


	public String update(String groupname, String id) throws SQLException, ClassNotFoundException {
		String requp = "UPDATE groupe SET   groupName ='"+groupname+"' where groupName ='"+id+"' ";
		Class.forName(driver);
		cx = DriverManager.getConnection(url, uid, passwd);
		 preparedStatement = cx.prepareStatement(requp);
		 preparedStatement.executeUpdate();
		
		return null ; 
		
	}

	public void DeleteGroup(String attribute)  throws SQLException, ClassNotFoundException {
		String update = "DELETE FROM groupe WHERE groupName='"+attribute+"' ";
		Class.forName(driver);
		cx = DriverManager.getConnection(url, uid, passwd);
		java.sql.PreparedStatement preparedStatement = cx.prepareStatement(update);
		preparedStatement.executeUpdate();	
		preparedStatement.close();
		
	}

	public Group SearchGroup(String search)throws SQLException, ClassNotFoundException{
		String Query = "select * from groupe where groupName = '"+search+"' ";
		Class.forName(driver);
		cx = DriverManager.getConnection(url, uid, passwd);
		
		
		 preparedStatement = cx.prepareStatement(Query);
		 	
			ResultSet result = preparedStatement.executeQuery();
			Group ctc = new Group();
			int i=0;
			while (result.next()) {
                 i++;
				ctc.setNom(result.getString("groupName"));
			}
			preparedStatement.close();
			if (i==0) ctc=null;
		return ctc;		
	}

	public ArrayList<Object> SearchPhoneList(int num) throws SQLException, ClassNotFoundException {
		ArrayList<Object> ph = new ArrayList<Object>(); 
		String Query = "select * from phone  where phone.ID_CONTACT='"+num+"'";
		Class.forName(driver);
		cx = DriverManager.getConnection(url, uid, passwd);
		 preparedStatement = cx.prepareStatement(Query);
		 
		 ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				ph.add(result.getString("kind"));
				ph.add(result.getInt("num"));
				
			}
			preparedStatement.close();
			return ph;
	}

	public ArrayList<Contact> SearchContactList(String num) throws SQLException, ClassNotFoundException {
		ArrayList<Contact> ph = new ArrayList<Contact>(); 
		String Query = "select * from groupcontact INNER JOIN contact ON groupcontact.ID_CONTACT = contact.ID_CONTACT where groupcontact.GroupName='"+num+"'";
		Class.forName(driver);
		cx = DriverManager.getConnection(url, uid, passwd);
		 preparedStatement = cx.prepareStatement(Query);
		 
		 ResultSet result = preparedStatement.executeQuery();
			while (result.next()) {
				Contact c = new Contact();
				
				c.setNum(result.getInt("ID_CONTACT"));
				c.setPrenom(result.getString("FIRSTNAME"));
				c.setNom(result.getString("LASTNAME"));
				c.setMail(result.getString("EMAIL"));
            address ad = new address(result.getString("street"),result.getString("city"),result.getString("zip"),result.getString("country"));
                c.setAd(ad);
                ph.add(c);
			}
			preparedStatement.close();
			return ph;
	}

	public void AssoccietGroupContact(String num, int id) {
		String msg = null;

		try{
		
			 String insertAddressQuery = "INSERT INTO groupContact(GroupName,ID_CONTACT) VALUES (?,?)";
			
				Class.forName(driver);
				cx = DriverManager.getConnection(url, uid, passwd);
				 preparedStatement = cx.prepareStatement(insertAddressQuery);
					preparedStatement.setString(1,num);
					preparedStatement.setLong(2, id);
					preparedStatement.executeUpdate();

					preparedStatement.close();
				} catch (ClassNotFoundException e) {
					msg =  "classe du pilote introuvable";
				// 
				} catch (SQLException e) {
					msg= "accès à la base refusé";
				// 
				} finally {
				try { if (cx != null) cx.close(); }
				catch (SQLException e) { msg =  "error"; }
				}

	

		//Set values of parameters in the query.
		
	}

	public void DeleteContactFromGroup(int num, String nom) throws SQLException, ClassNotFoundException {
		String update = "DELETE FROM groupcontact WHERE groupName='"+nom+"' and ID_CONTACT='"+num+"'";
		Class.forName(driver);
		cx = DriverManager.getConnection(url, uid, passwd);
		java.sql.PreparedStatement preparedStatement = cx.prepareStatement(update);
		preparedStatement.executeUpdate();	
		preparedStatement.close();
		
	}
	
	
}



