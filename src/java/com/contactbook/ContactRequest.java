/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.contactbook;

import java.io.Serializable;
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
public class ContactRequest implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;
    private String email;
    private String contact;
    private String city;

    public ContactRequest() {
    }

    public ContactRequest(String name, String email, String contact, String city) {
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.city = city;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
