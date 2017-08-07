package com.acme.karaf.example.rest;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Product class is just a plain old java object, with a few properties and getters and setters.
 * <p/>
 * By adding the @XmlRootElement annotation, we make it possible for JAXB to unmarshal this object into a XML document and
 * to marshal it back from the same XML document.
 * <p/>
 * The XML representation of a Product will look like this:
 * <Product>
 * <id>10010</id>
 * <description>Armadillo</description>
 * </Product>
 */
@XmlRootElement(name = "Product")
public class Product {
    private long id;
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String d) {
        this.description = d;
    }
}