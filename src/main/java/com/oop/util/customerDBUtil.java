package com.oop.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oop.model.Customer;

public class customerDBUtil {
	
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
	private static boolean isSuccess = false;
	
	public static boolean validatefornav(String userName, String password) {
		
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();

			String sql = "select * from customer where userName= '" + userName + "' and password= '" + password + "' ";

			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				isSuccess=true;
			}else {
				isSuccess=false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
		
	}

	public static List<Customer> validate(String userName, String password) {
		
		ArrayList<Customer> cus = new ArrayList<>();

		
		try {
		
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
		
			String sql = "select * from customer where userName= '" + userName + "' and password= '" + password + "' ";

			 rs = stmt.executeQuery(sql);
			 
			 
			if (rs.next()) {
				
				
				int idCustomer =rs.getInt(1);
				String userN = rs.getString(2);
				String passU = rs.getString(3);
				String name = rs.getString(4);
				String email = rs.getString(5);
				String phone = rs.getString(6);
				String nic = rs.getString(7);
				
			
				Customer c = new Customer(idCustomer, userN, passU, name, email, phone, nic);
				
			
				cus.add(c);
		
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	
		return cus;
	
	}
	
	public static Customer getCustomer(String userName) {
		
		Customer customer = new Customer();
		
		
	
		try {
		
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
			
			String sql = "select * from customer where userName= '" + userName + "'";
		
			 rs = stmt.executeQuery(sql);
			 
			 if (rs.next()) {
					
					int idCustomer =rs.getInt(1);
					String userN = rs.getString(2);
					String passU = rs.getString(3);
					String name = rs.getString(4);
					String email = rs.getString(5);
					String phone = rs.getString(6);
					String nic = rs.getString(7);
					
				
				 customer = new Customer(idCustomer, userN, passU, name, email, phone, nic);
					
			
				}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return customer;
		 

	}

	
	public static boolean updateCustomerData(String username,String id,String name,String email,String phone,String nic,String password) {
	
		try {
		
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
		
			String sql = "update customer set name= '"+name+"', email='"+email+"', phone='"+phone+"', password='"+password+"' where idCustomer='"+id+"'  " ;
			
			int rs= stmt.executeUpdate(sql);
			
			if(rs > 0){
				isSuccess=true;
			}else {
				isSuccess=false;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		return isSuccess;

		
	}
	
	public static List<Customer> getCustomerDetails(String Id) {

		
		
		int convertid = Integer.parseInt(Id);
		
	
		ArrayList<Customer> cus = new ArrayList<>();
		
		
		try {
		
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
		
			String sql = "select * from customer where idCustomer= '"+convertid+"'";
			
			
			 rs = stmt.executeQuery(sql);

			while(rs.next()) {
		
				int idCustomer =rs.getInt(1);
				String userN = rs.getString(2);
				String passU = rs.getString(3);
				String name = rs.getString(4);
				String email = rs.getString(5);
				String phone = rs.getString(6);
				String nic = rs.getString(7);
		
				
				Customer c = new Customer(idCustomer, userN, passU, name, email, phone, nic);
				
				
				cus.add(c);	
			
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	
		return cus;

	}
	
	public static boolean deleteCustomer(String id) {
	
		
		
		int conID = Integer.parseInt(id);
	
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();
			
		
			String sql = "delete from customer where idCustomer='"+conID+"' ";
			
			
			int rs=stmt.executeUpdate(sql);
			
			if(rs >0) {
				
				isSuccess = true;
				
			}else {
				isSuccess = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		return isSuccess;
	
	}
	
	
	public static boolean customerInser(String userName,String name,String email,String phone,String nic,String pass) {
		
		
		
		try {
			
			con = DBConnect.getConnection();
			stmt = con.createStatement();	
			
			String sql = "insert into customer values(0,'"+userName+"', '"+pass+"', '"+name+"', '"+email+"', '"+phone+"', '"+nic+"' )";
			
			int rs = stmt.executeUpdate(sql);
			
			if (rs>0) {
				isSuccess = true;
			} else {
				isSuccess = false;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	
		return isSuccess;
	
	}
	
	
	
}
