package com.test.xxe;

import java.io.FileReader;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;
import java.util.Properties;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
 
public class Demo {
 
    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Foo.class);
       


        Properties systemprop = System.getProperties();
        systemprop.setProperty("-DentityExpansionLimit","1000000");
        												
       // System.out.println(systemprop.getProperty("-DentityExpansionLimit"));
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, false);
        XMLReader xmlReader = spf.newSAXParser().getXMLReader();
        InputSource inputSource = new InputSource(new FileReader("C:\\JBOSS\\abc.xml"));
        SAXSource source = new SAXSource(xmlReader, inputSource);
 
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Foo foo = (Foo) unmarshaller.unmarshal(source);
        System.out.println(foo.getValue());
    }
 
}