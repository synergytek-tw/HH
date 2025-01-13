package deepspot.html;

import java.util.Iterator;
import java.util.List;

import deepspot.basic.Cnstnts;

public class SelectOneTag {
	
	public SelectOneTag(){}
	
	public SelectOneTag(String idName, String onChange,
			            String currentValue, List<?> optionList){
		this.idName=idName;
		this.onChange=onChange;
		this.currentValue=currentValue;
		this.optionList=optionList;
	}
	
	private String idName=Cnstnts.EMPTY_STRING;
	public void setIdName(String idName){
		this.idName=idName;
	}
	public String getIdName(){
		return this.idName;
	}
	
	private String onChange=Cnstnts.EMPTY_STRING;
	public void setOnChange(String onChange){
		this.onChange=onChange;
	}
	public String getOnChange(){
		return this.onChange;
	}
	
	private String currentValue=Cnstnts.EMPTY_STRING;
	public void setCurrentValue(String currentValue){
		this.currentValue=currentValue;
	}
	public String getCurrentValue(){
		return this.currentValue;
	}
	
	private List<?> optionList;
	public void setOptionList(List<?> optionList){
		this.optionList=optionList;
	}
	public List<?> getOptionList(){
		return this.optionList;
	}
	
	
	public String toString(){
		if(this.idName.trim().length()==0 || this.optionList==null) 
			return Cnstnts.EMPTY_STRING;
		char newLine = Cnstnts.NEW_LINE;
		StringBuffer strBfr=new StringBuffer(newLine+"<select");
		strBfr.append(" id='"+this.idName+"' name='"+this.idName+"'"+
				      " onChange='"+this.onChange+"'>");
		for(Iterator<?> itr=this.optionList.iterator();itr.hasNext();){
			String[] option = (String[])itr.next();
			String selected = Cnstnts.EMPTY_STRING;
			if(this.currentValue.equals(option[0])) 
				selected=Cnstnts.SELECTED;
			strBfr.append(newLine+"  <option value='"+option[0]+"'"+selected+">"+
					      option[1]+"</option>");
		}
		strBfr.append(newLine+"</select>");
		return strBfr.toString();
	}

}
