/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactbook;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author NITESH
 */
public class ContactDaoTest {
    
    public ContactDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of create method, of class ContactDao.
     */
    @org.junit.Test
    public void testCreate() {
        System.out.println("create");
        ContactRequest Crequest = new ContactRequest("DN Verma","dnvv@gmail.com","9006745345","faizabad");
        ContactDao instance = new ContactDao();
        List<ContactResponse> expResult = new ArrayList<ContactResponse>();;
        List<ContactResponse> result = instance.create(Crequest);
        expResult=instance.getSingleContact("dnvv@gmail.com");
        String s="Duplicate entry 'dnvv@gmail.com' for key 1";
        if(!result.get(0).getMessage().equals(s))
        {
            assertEquals(expResult.get(0).getName(), result.get(0).getName());
            assertEquals(expResult.get(0).getEmail(), result.get(0).getEmail());
            assertEquals(expResult.get(0).getCity(), result.get(0).getCity());
            assertEquals(expResult.get(0).getContact(), result.get(0).getContact());
        }
    }

    /**
     * Test of getSingleContact method, of class ContactDao.
     */
    @org.junit.Test
    public void testGetSingleContact() {
        System.out.println("getSingleContact");
        String emailid = "dnv@gmail.com";
        ContactDao instance = new ContactDao();
        List<ContactResponse> expResult = new ArrayList<ContactResponse>();
        ContactResponse cr = new ContactResponse("DN Verma1","dnv@gmail.com","9006847351","DBG");
        expResult.add(cr);
        List<ContactResponse> result = instance.getSingleContact(emailid);
        String s="No records Exists";
        if(result.get(0).getMessage()==null)
        {
            assertEquals(expResult.get(0).getName(), result.get(0).getName());
            assertEquals(expResult.get(0).getMessage(), result.get(0).getMessage());
            assertEquals(expResult.get(0).getEmail(), result.get(0).getEmail());
            assertEquals(expResult.get(0).getCity(), result.get(0).getCity());
            assertEquals(expResult.get(0).getContact(), result.get(0).getContact());
        }
        // TODO review the generated test code and remove the default call to fail.
    }
    /**
     * Test of updatecon method, of class ContactDao.
     */
    @org.junit.Test
    public void testUpdatecon() {
        System.out.println("updatecon");
        ContactRequest Urequest = new ContactRequest("DN Verma1","dnv4@gmail.com","9006847351","DBG");
        ContactDao instance = new ContactDao();
        List<ContactResponse> expResult = new ArrayList<ContactResponse>();
        ContactResponse c = new ContactResponse("Contact Updated");
        expResult.add(c);
        List<ContactResponse> result = instance.updatecon(Urequest);
        String s="No such ID exsits";
        if(!result.get(0).getMessage().equals(s))
        assertEquals(expResult.get(0).getMessage(), result.get(0).getMessage());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of delete method, of class ContactDao.
     */
    @org.junit.Test
    public void testDelete() {
        System.out.println("delete");
        String emailid = "dnv3@gmail.com";
        ContactDao instance = new ContactDao();
        List<ContactResponse> expResult = new ArrayList<ContactResponse>();
        ContactResponse c = new ContactResponse("Contact Deleted");
        expResult.add(c);
        List<ContactResponse> result = instance.delete(emailid);
        String s="No such contact ID found";
        if(!result.get(0).getMessage().equals(s))
        assertEquals(expResult.get(0).getMessage(), result.get(0).getMessage());
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
