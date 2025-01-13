package deepspot.html;

import java.util.List;
import java.util.Iterator;

import deepspot.basic.Cnstnts;

public class HeadLinkTag{
	
	public HeadLinkTag(){};
	
	public HeadLinkTag(String hrefValue){
		this.hrefValue=hrefValue;
	}
	
	public HeadLinkTag(String hrefValue,String relValue,String typeValue){
		this.hrefValue=hrefValue;
		if(relValue!=null && relValue.trim().length()>0) this.relValue=relValue;
		if(typeValue!=null && typeValue.trim().length()>0) this.typeValue=typeValue;
	}
	
	private String hrefValue=Cnstnts.EMPTY_STRING;
	public void setHrefValue(String hrefValue){this.hrefValue=hrefValue;}
	public String getHrefValue(){return this.hrefValue;}
	
	private String relValue="stylesheet";
	public void setRelValue(String relValue){this.relValue=relValue;}
	public String getRelValue(){return this.relValue;}
	
	private String typeValue="text/css";
	public void setTypeValue(String typeValue){this.typeValue=typeValue;}
	public String getTypeValue(){return this.typeValue;}
	
	public String toString(){
		if(this.hrefValue.trim().length()==0) return "";
		StringBuffer rtnSB = new StringBuffer(Cnstnts.NEW_LINE+"<link href='"+this.hrefValue+"'");
		rtnSB.append(" rel='"+this.relValue+"' type='"+this.typeValue+"'>");
		return rtnSB.toString();
	}
	
	public String print(List<?> linkTagList) {
		String rtnString=Cnstnts.EMPTY_STRING;
    for(Iterator<?> itr=linkTagList.iterator();itr.hasNext();){
    	HeadLinkTag tagObj=new HeadLinkTag((String)itr.next());
    	rtnString+=tagObj.toString();
    }
    return rtnString;
  }
	
}