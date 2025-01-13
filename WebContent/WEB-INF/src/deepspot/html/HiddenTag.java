package deepspot.html;

import deepspot.basic.Cnstnts;
import deepspot.basic.Field;

import java.util.HashMap;
import java.util.Iterator;

public class HiddenTag{
	
	public HiddenTag(){};
	
	public HiddenTag(String idName,String hiddenValue){
		this.idName=idName;
		this.hiddenValue=hiddenValue;
	}
	
	public HiddenTag(Field field){
		this.idName=field.getName();
		this.hiddenValue=field.getValue();
	}
	
	private String idName=Cnstnts.EMPTY_STRING;
	public void setIdName(String idName){this.idName=idName;}
	public String getIdName(){return this.idName;}
	
	private String hiddenValue=Cnstnts.EMPTY_STRING;
	public void setHiddenValue(String hiddenValue){this.hiddenValue=hiddenValue;}
	public String getHiddenValue(){return this.hiddenValue;}
	
	public String toString(){
		if(this.idName.length()==0 || this.hiddenValue==null || this.idName==null) 
			return Cnstnts.EMPTY_STRING;
		String tagName = this.idName;
		if(tagName.length()>1){
			tagName = tagName.substring(0,1).toLowerCase()+tagName.substring(1,tagName.length());
		}
		StringBuffer rtnSB = new StringBuffer(Cnstnts.NEW_LINE
		       +"<input type='hidden' id='"+tagName+"' name='"+tagName+"'");
		String hiddenValueStr;
		if(this.hiddenValue.length()==0) hiddenValueStr=Cnstnts.EMPTY_STRING;
		else hiddenValueStr=" value='"+this.hiddenValue+"'";
		
		return rtnSB.append(hiddenValueStr+"/>").toString();
	}
	
	public String print(HashMap<?, ?> hiddenTagMap){
	  String rtnString=Cnstnts.EMPTY_STRING;
	  if(hiddenTagMap==null) return rtnString;
	  for(Iterator<?> itr=hiddenTagMap.keySet().iterator();itr.hasNext();){
		  String hiddenKey = (String)itr.next();
		  HiddenTag tagObj=new HiddenTag(hiddenKey,(String)hiddenTagMap.get(hiddenKey));
		  rtnString += tagObj.toString();
	  }
	  return rtnString;
	}
}