package deepspot.html;

import java.util.List;
import java.util.Iterator;

import deepspot.basic.Cnstnts;

public class HeadScriptTag{
	
	public HeadScriptTag(){};
	
	public HeadScriptTag(String srcValue){
		this.srcValue=srcValue;
	}
	
	public HeadScriptTag(String srcValue,String relValue){
		this.srcValue=srcValue;
		if(relValue!=null && relValue.trim().length()>0) this.srcValue=srcValue;
	}
	
	private String srcValue="";
	public void setSrcValue(String srcValue){this.srcValue=srcValue;}
	public String getSrcValue(){return this.srcValue;}
	
	private String languageValue="JavaScript";
	public void setLanguageValue(String languageValue){this.languageValue=languageValue;}
	public String getLanguageValue(){return this.languageValue;}
	
	public String toString(){
		if(this.srcValue.trim().length()==0) return "";
		return (Cnstnts.NEW_LINE+"<script language='"+this.languageValue+"' src='"+this.srcValue+"'></script>");
	}
	
	public String print(List<?> scriptTagList) {
		String rtnString="";
    for(Iterator<?> itr=scriptTagList.iterator();itr.hasNext();){
    	HeadScriptTag tagObj=new HeadScriptTag((String)itr.next());
    	rtnString+=tagObj.toString();
    }
    return rtnString;
  }
	
}