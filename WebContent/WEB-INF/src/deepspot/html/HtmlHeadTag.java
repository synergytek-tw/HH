package deepspot.html;

import java.util.List;
import java.util.ArrayList; 

import deepspot.basic.Cnstnts;

public class HtmlHeadTag{
	
	public HtmlHeadTag(){};
	
	public HtmlHeadTag(String innerHtml){this.innerHtml=innerHtml;}
	
	public HtmlHeadTag(String titleVale,List<?> linkTagList,List<?> scriptTagList){
	  this.titleVale=titleVale;
	  this.linkTagList=linkTagList;
	  this.scriptTagList=scriptTagList;
	}
	
	String innerHtml="";
	public void setInnerHtml(String innerHtml){this.innerHtml=innerHtml;}
	public String getInnerHtml(){return this.innerHtml;}
	
	String titleVale="";
	public void setTitleVale(String titleVale){this.titleVale=titleVale;}
	public String getTitleVale(){return this.titleVale;}
	
	@SuppressWarnings("unchecked")
	List<?> linkTagList=new ArrayList();
	public void setLinkTagList(List<?> linkTagList){this.linkTagList=linkTagList;}
	public List<?> getLinkTagList(){return this.linkTagList;}
	
	@SuppressWarnings("unchecked")
	List<?> scriptTagList=new ArrayList();
	public void setScriptTagList(List<?> scriptTagList){this.scriptTagList=scriptTagList;}
	public List<?> getScriptTagList(){return this.scriptTagList;}	
  
	public String toString() {
		StringBuffer strBfr = new StringBuffer("");
    
		strBfr.append(Cnstnts.NEW_LINE+"<head>");
		strBfr.append(Cnstnts.NEW_LINE+innerHtml);
		return strBfr.append(Cnstnts.NEW_LINE+"</head>").toString();
	}
  
	public String print() {
  	StringBuffer strBfr = new StringBuffer();
    strBfr.append(new TitleTag(titleVale).toString());
    strBfr.append(new HeadLinkTag().print(linkTagList));
    strBfr.append(new HeadScriptTag().print(scriptTagList));
   
    this.innerHtml=strBfr.toString();
   
    return this.toString();
  }
    
}