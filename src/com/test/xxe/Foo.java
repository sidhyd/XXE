package com.test.xxe;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;
 
@XmlRootElement
public class Foo {
 
    private String value;
 
    @XmlValue
    public String getValue() {
        return value;
    }
 
    public void setValue(String value) {
        this.value = value;
    }
 
}