/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactbook;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlAttribute;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author NITESH
 */
@XmlRootElement(name = "Contact")
public class ContactResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private String emailid;
    private String name;
    private String contact;
    private String city;
    private String message;

    public ContactResponse() {
    }
    
    public ContactResponse(String Message) {
        this.message = Message;
        
    }

    public ContactResponse(String name, String email, String contact, String city) {
        this.name = name;
        this.emailid = email;
        this.contact = contact;
        this.city = city;
    }

    public String getMessage() {
        return message;
    }

    @XmlElement
    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    @XmlElement
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return emailid;
    }

    @XmlElement
    public void setEmail(String email) {
        this.emailid = email;
    }

    public String getContact() {
        return contact;
    }

    @XmlElement
    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCity() {
        return city;
    }

    @XmlElement
    public void setCity(String city) {
        this.city = city;
    }

}
