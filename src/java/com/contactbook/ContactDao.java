/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author NITESH
 */
public class ContactDao {

    public List<ContactResponse> create(ContactRequest Crequest) {
        List<ContactResponse> contactList = new ArrayList<ContactResponse>();
        try {
            DBConnection dbconnect = new DBConnection();
            Connection con = dbconnect.getDBConnection();
            DBConnectionRead dbconnect1 = new DBConnectionRead();
            Connection con1 = dbconnect1.getDBConnection();
            if (con != null && con1!=null) {

                String insertTableSQL = "INSERT INTO contactbook"
                        + "(Name, Email_ID, Contact_Number, City) VALUES"
                        + "(?,?,?,?);";
                PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
                preparedStatement.setString(1, Crequest.getName());
                preparedStatement.setString(2, Crequest.getEmail());
                preparedStatement.setString(3, Crequest.getContact());
                preparedStatement.setString(4, Crequest.getCity());
                // execute insert SQL stetement
                preparedStatement.executeUpdate();
                
                PreparedStatement preparedStatement1 = con1.prepareStatement(insertTableSQL);
                preparedStatement1.setString(1, Crequest.getName());
                preparedStatement1.setString(2, Crequest.getEmail());
                preparedStatement1.setString(3, Crequest.getContact());
                preparedStatement1.setString(4, Crequest.getCity());
                // execute insert SQL stetement
                preparedStatement1.executeUpdate();
                
                Statement st = con.createStatement();
                Statement st1 = con1.createStatement();
                String sql="select LAST_INSERT_ID()";
                ResultSet rs=st.executeQuery(sql);
                ResultSet rs1=st1.executeQuery(sql);
                rs.next();
                int id = rs.getInt(1);
                ContactResponse c = new ContactResponse("Contact Created");
                contactList.add(c);
                return contactList;
            } else {
                System.out.println("Failed to connect!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            String str = e.getMessage();
            ContactResponse c = new ContactResponse(str);
            contactList.add(c);
            return contactList;
        }
        return null;
    }


    List<ContactResponse> getSingleContact(String emailid) {
        List<ContactResponse> contactList = new ArrayList<ContactResponse>();
        try {
            DBConnectionRead dbconnect = new DBConnectionRead();
            Connection con = dbconnect.getDBConnection();
            if (con != null) {
                //DB connection established
                System.out.print(emailid);
                String insertTableSQL = "(select * from contactbook where Email_ID=?)";
                PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
                preparedStatement.setString(1, emailid);
                // execute insert SQL stetement
                ResultSet rs = preparedStatement.executeQuery();
                int counter = 0;
                while (rs.next()) {
                    System.out.print("record");
                    ContactResponse cr = new ContactResponse(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                    contactList.add(cr);
                    counter++;
                }

                if (counter == 0) {
                    //user record does not exists
                    System.out.print("No record");
                    ContactResponse CR = new ContactResponse("No records Exists");
                    contactList.add(CR);

                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return contactList;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    List<ContactResponse> getContacts(String name, int index, int length) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<ContactResponse> contactList = new ArrayList<ContactResponse>();
        try {
            DBConnectionRead dbconnect = new DBConnectionRead();
            Connection con = dbconnect.getDBConnection();
            if (con != null) {
                //start+length*index to start+length*index+length-1
                int pageStart = length * (index - 1);
                String insertTableSQL = "select * from contactbook where name=? limit ? offset ?";
                PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
                preparedStatement.setString(1, name);
                preparedStatement.setInt(2, length);
                preparedStatement.setInt(3, pageStart);
                
                System.out.print(length);
                System.out.print(pageStart);
                // execute insert SQL stetement
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    System.out.print("record");
                    ContactResponse cr = new ContactResponse(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
                    contactList.add(cr);
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contactList;
    }

    public List<ContactResponse> updatecon(ContactRequest Urequest) {
        List<ContactResponse> contactList = new ArrayList<ContactResponse>();
        try {
            DBConnection dbconnect = new DBConnection();
            Connection con = dbconnect.getDBConnection();
            DBConnectionRead dbconnect1 = new DBConnectionRead();
            Connection con1 = dbconnect1.getDBConnection();
            String name = "", contact = "", email = "", city = "";
            
            String temp = "";

            if (con != null && con1 !=null) {

                if (Urequest.getName() != null) {
                    name = Urequest.getName();
                    temp += "Name=?,";

                }
                if (Urequest.getEmail() != null) {
                    email = Urequest.getEmail();
                    temp += "Email_ID=?,";
                }
                if (Urequest.getContact() != null) {
                    contact = Urequest.getContact();
                    temp += "Contact_Number=?,";
                }
                if (Urequest.getCity() != null) {
                    city = Urequest.getCity();
                    temp += "City=?,";
                }

                temp = temp.substring(0, temp.length() - 1);

                String sqlQuery = "update contactbook set " + temp + " where Email_ID='"+email+"'";
                System.out.print(sqlQuery);
                PreparedStatement preparedStatement = con.prepareStatement(sqlQuery);
                PreparedStatement preparedStatement1 = con1.prepareStatement(sqlQuery);
                int queryCounter = 0;
                if (Urequest.getName() != null) {
                    queryCounter++;
                    preparedStatement.setString(queryCounter, Urequest.getName());
                    preparedStatement1.setString(queryCounter, Urequest.getName());
                }
                if (Urequest.getEmail() != null) {
                    queryCounter++;
                    preparedStatement.setString(queryCounter, Urequest.getEmail());
                    preparedStatement1.setString(queryCounter, Urequest.getEmail());
                }
                if (Urequest.getContact() != null) {
                    queryCounter++;
                    preparedStatement.setString(queryCounter, Urequest.getContact());
                    preparedStatement1.setString(queryCounter, Urequest.getContact());
                }
                if (Urequest.getCity() != null) {
                    queryCounter++;
                    preparedStatement.setString(queryCounter, Urequest.getCity());
                    preparedStatement1.setString(queryCounter, Urequest.getCity());
                }
                int rs = preparedStatement.executeUpdate(),rs1=preparedStatement1.executeUpdate();
                if (rs > 0 && rs1>0) {
                    ContactResponse c = new ContactResponse("Contact Updated");
                    contactList.add(c);
                    return contactList;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            String str = e.getMessage();
            ContactResponse c = new ContactResponse(str);
            contactList.add(c);
            return contactList;
        }
        ContactResponse c = new ContactResponse("No such ID exsits");
        contactList.add(c);
        return contactList;
    }

    List<ContactResponse> delete(String emailid) {
        List<ContactResponse> contactList = new ArrayList<ContactResponse>();
        try {
            DBConnection dbconnect = new DBConnection();
            Connection con = dbconnect.getDBConnection();
            DBConnectionRead dbconnect1 = new DBConnectionRead();
            Connection con1 = dbconnect1.getDBConnection();
            if (con != null && con1 !=null) {
                String insertTableSQL = "delete from contactbook where Email_ID=?";
                PreparedStatement preparedStatement = con.prepareStatement(insertTableSQL);
                PreparedStatement preparedStatement1 = con1.prepareStatement(insertTableSQL);
                preparedStatement.setString(1, emailid);
                preparedStatement1.setString(1, emailid);
                int rs = preparedStatement.executeUpdate();
                int rs1 = preparedStatement1.executeUpdate();
                if (rs > 0 && rs1>0) {
                    ContactResponse c = new ContactResponse("Contact Deleted");
                    contactList.add(c);
                    return contactList;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
            String str = e.getMessage();
            ContactResponse c = new ContactResponse(str);
            contactList.add(c);
            return contactList;
        }
        ContactResponse c = new ContactResponse("No such contact ID found");
        contactList.add(c);
        return contactList;
    }

}
