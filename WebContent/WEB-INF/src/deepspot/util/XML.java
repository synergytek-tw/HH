package deepspot.util;

import java.io.*;

import java.util.*;

import java.net.MalformedURLException;

import org.dom4j.*;
import org.dom4j.io.*;

public class XML {

  /** dom4j object model representation of a xml document. */
  private Document doc = null;
  private StringBuffer xmlString = null;
  static String defaultReduce = "  ";
  static int iLf = 10;
  static char newLine = (char)iLf;

  public XML() {
    DocumentFactory df = new DocumentFactory();
    this.doc = df.createDocument();
  }
  
  public XML(File xmlFile) throws DocumentException, MalformedURLException,
  FileNotFoundException, UnsupportedEncodingException, IOException
  { parseWithSAX(xmlFile); }
  
  public XML(File xmlFile, String enconding) throws DocumentException, MalformedURLException,
  FileNotFoundException, UnsupportedEncodingException, IOException
  { parseWithSAX(xmlFile,enconding); }

  /**
   * Loads a document from a file.
   *
   * @param aFile the data source
   * @throw a org.dom4j.DocumentExcepiton whenever the buildprocess fails.
   */
  public void parseWithSAX(File aFile) throws
  DocumentException, MalformedURLException,
  FileNotFoundException, UnsupportedEncodingException, IOException {
    Reader reader = null;
    SAXReader xmlReader = null;
    try {
      xmlReader = new SAXReader();
      reader = new InputStreamReader(new FileInputStream(aFile));
      this.doc = xmlReader.read(reader);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      reader.close();
    }
  }
  
  
  public void parseWithSAX(File aFile, String enconding) throws
  DocumentException, MalformedURLException,
  FileNotFoundException, UnsupportedEncodingException, IOException {
    Reader reader = null;
    SAXReader xmlReader = null;
    if (enconding==null || enconding.equals("")) {
      parseWithSAX(aFile);
    } else {
      try {
        xmlReader = new SAXReader();
        reader = new InputStreamReader(new FileInputStream(aFile), enconding);
        this.doc = xmlReader.read(reader);
      } finally {
        reader.close();
      }
    }
  }

  
  public Element getRootElement() {
    return this.doc.getRootElement();
  }
  
  
  public Vector<Element> getElements(String elementName) {	
    Element root = this.doc.getRootElement();
    Vector<Element> elements = new Vector<Element>();
    if (root.getName().equals(elementName)) {
      elements.add(root);
    }
    walkTree(root, elementName, elements);
    return elements;
  }
  
  
  public Element getElement(String elementName) {	
    Element element = null;
    Vector<?> v = this.getElements(elementName);
    Enumeration<?> elements = v.elements();
    if (elements.hasMoreElements()) element = (Element)elements.nextElement();
    return element;
  }
  
  
  public Element getElement(String elementName, String attName, String attValue) {	

    Vector<?> v = this.getElements(elementName);
    Enumeration<?> elements = v.elements();
    while (elements.hasMoreElements()) {
    	Element element = (Element)elements.nextElement();
    	Iterator<?> attributeIterator = element.attributeIterator();
        while(attributeIterator.hasNext()){
          Attribute att = (Attribute)attributeIterator.next();  
          if (att.getName().equals(attName) & att.getValue().equals(attValue))
            return element;      
        }
    }
    return null;
  }
 
 
  public void setAttributeValue(Element element, String attName, String attValue) {
    if (element == null) return;
    Iterator<?> attributeIterator = element.attributeIterator();
    while(attributeIterator.hasNext()){
      Attribute att = (Attribute)attributeIterator.next();  
      if (att.getName().equals(attName)) att.setValue(attValue);      
    }
  }
  
  
  public void replaceAttributeValue(String elementName, 
                                    String attValue, String attText) {
    Vector<?> elements = this.getElements(elementName);
    Enumeration<?> enumElements = elements.elements();
    while (enumElements.hasMoreElements()) {
      Element element = (Element)enumElements.nextElement();
      Iterator<?> attributeIterator = element.attributeIterator();
      while(attributeIterator.hasNext()){
        Attribute att = (Attribute)attributeIterator.next();  
        if (att.getValue().equals(attValue)) att.setValue(attText);      
      }
    } 
  }


  public void walkTree(Element element, String elementName, Vector<Element> elements) {
    Iterator<?> elementIterator = element.elementIterator();
    while(elementIterator.hasNext()){
      Element childElement = (Element)elementIterator.next(); 
      if (elementName != null) {
        if (childElement.getName().equals(elementName)) {      
          elements.add(childElement);  
        }
      } 
      walkTree(childElement, elementName, elements);
    }
  }
  
  
  public void printElement(Element element) {
    xmlString = new StringBuffer("");
    getXmlString(element,"");
    System.out.println(xmlString);
  }
  

  public void write(File outFile, String encode) throws IOException {
    FileWriter fileOut = null;
    XMLWriter XWriter = null;
    try {
      OutputFormat format = OutputFormat.createPrettyPrint();
      fileOut = new FileWriter(outFile);
      format.setEncoding(encode);
      XWriter = new XMLWriter(fileOut, format );
      XWriter.write(doc);
    } 
    catch (Exception e) {System.out.println("XML.write Exception:");}
    finally {
      XWriter.close();
      fileOut.close();
    }
  }


  public void writeToXML(File outFile) throws IOException {
    FileWriter fileOut = null;
    try {
      fileOut = new FileWriter(outFile);
      xmlString = null;
      getXmlString(this.doc.getRootElement(),"");
      fileOut.write(xmlString.toString());
      System.out.println(xmlString);
    } 
    catch (Exception e) {e.printStackTrace();}
    finally {   
      fileOut.close();
    }
  }


  public void getXmlString(Element element, String reduce) {
    if (xmlString == null) {
      xmlString = new StringBuffer();
      xmlString.append("<?xml version=\"1.0\" encoding=\"ms950\"?>"
                       + newLine);
    }
    Iterator<?> elementIterator = element.elementIterator();
    
    if (elementIterator.hasNext()) {
      xmlString.append(reduce + "<" + element.getName());
      getAttributeString(element);
      xmlString.append(">" + newLine);
    }      
    else {
      getElementString(element, reduce);
      return;
    }

    String orgReduce = reduce;
    reduce += defaultReduce;

    while(elementIterator.hasNext()){
      Element childElement = (Element)elementIterator.next(); 
      getXmlString(childElement, reduce);
    }
    
    xmlString.append(orgReduce + "</" + element.getName() +">" + newLine);
  }


  public void getAttributeString(Element element) {
    Iterator<?> attributeIterator = element.attributeIterator();
    while(attributeIterator.hasNext()){
      Attribute att = (Attribute)attributeIterator.next();  
      xmlString.append(" " + att.getName() + "=\"" + att.getValue() + "\"");      
    }
  }
  
  
  public void getElementString(Element element, String reduce) {
    xmlString.append(reduce + "<" + element.getName());
    getAttributeString(element);
    if (element.getTextTrim().equals(""))
      xmlString.append("/>" + newLine);
    else 
      xmlString.append(">" + element.getTextTrim() + "</" + element.getName() 
                       + ">" + newLine);
  }


  public void setRootElement(Element root) {
    this.doc.setRootElement(root);
  }


}