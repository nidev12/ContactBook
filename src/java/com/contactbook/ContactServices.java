/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactbook;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
/**
 *
 * @author NITESH
 */
@Path("/Contacts")
public class ContactServices {

    /*GET*/
    ContactDao contactdao = new ContactDao();

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public List<ContactResponse> getUsers(@DefaultValue("") @QueryParam("emailid") String emailid,
            @QueryParam("name") String name,
            @DefaultValue("10") @QueryParam("length") String length, //pagination
            @DefaultValue("1") @QueryParam("index") String index) {
        int pageLength = Integer.parseInt(length);
        int pageIndex = Integer.parseInt(index);
        String Email_ID=emailid;
        if (!Email_ID.equals("")) {  
            System.out.println("searching by email!!");
            return contactdao.getSingleContact(Email_ID); //unique email id
        } else if (!name.equals("")) {  
            int in=Integer.parseInt(index);
            int len=Integer.parseInt(length);
            return contactdao.getContacts(name,in,len);
        } 
        return null;

    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public List<ContactResponse> createContact(ContactRequest Crequest)
    {
        return contactdao.create(Crequest);
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public List<ContactResponse> updateContact(ContactRequest Urequest){
        return contactdao.updatecon(Urequest);
        
    }
    
    @DELETE
    @Path("/{emailid}")
    @Produces(MediaType.APPLICATION_XML)
    public List<ContactResponse> deletecontact(@PathParam("emailid") String emailid){
        return contactdao.delete(emailid);
    }

}
