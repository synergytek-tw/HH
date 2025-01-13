package deepspot.basic;

import java.util.List;
import java.util.Properties;

public class Field {
	
	public Field(String name) {
		this.name = name;
	}
	
	public Field(String name, String tableName) {
		this.name = name;
		this.tableName = tableName;
	}
	
	private String aliasName;
	public void setAliasName(String aliasName){
		this.aliasName=aliasName;
	}
	public String getAliasName(){
		return this.aliasName;
	}	
	
	private String tableName;
	public void setTableName(String tableName){
		this.tableName = tableName;
	}
	public String getTableName(){
		return this.tableName;
	}
	
	private boolean canEditFlag;
	public void setCanEdit(boolean canEditFlag){
		this.canEditFlag = canEditFlag;
	}
	public boolean canEdit(){
		return this.canEditFlag;
	}
	
	private Field anotherField;
	public void setAnotherField(Field field){
		this.anotherField=field;
	}
	public Field getAnotherField(){
		return this.anotherField;
	}

	private String name;
	public void setName(String name){this.name = name;}
	public String getName(){return this.name;}
	public String getTagName(){
		return this.name.substring(0,1).toLowerCase()+this.name.substring(1,this.name.length());
	}
	public String printName(){
		return " id='"+this.getTagName()+"' name='"+this.getTagName()+"'";
	}
	public String printHiddenTag(){
		return "<input type='hidden'"+this.printName()+this.printValue()+"/>";
	}
	
	private String value=Cnstnts.EMPTY_STRING;
	public void setValue(String value){this.value = value;}
	public String getValue(){
		if(this.value==null || this.value.trim().length()==0){
			if(this.dbType.equals(Cnstnts.DB_TYPE_INT) 
					|| this.dbType.equals(Cnstnts.DB_TYPE_FLOAT)){
				return "0";
			} else {
				return Cnstnts.EMPTY_STRING;
			}
		} else {
			return this.value;
		} 
	}
	
	private boolean ShowFlag=true;
	public void setShowFlag(boolean ShowFlag){
		this.ShowFlag = ShowFlag;
	}
	public boolean showFlag(){
		return this.ShowFlag;
	}
	
	private boolean LinkFlag1=false;
	public void setLinkFlag1(boolean LinkFlag1){
		this.LinkFlag1 = LinkFlag1;
	}
	public boolean linkFlag1(){
		return this.LinkFlag1;
	}
	
	private boolean LinkFlag2=false;
	public void setLinkFlag2(boolean LinkFlag2){
		this.LinkFlag2 = LinkFlag2;
	}
	public boolean linkFlag2(){
		return this.LinkFlag2;
	}
	
	private String LinkMode1;
	public void setLinkMode1(String LinkMode1){
		this.LinkMode1 = LinkMode1;
	}
	public String getLinkMode1(){
		return this.LinkMode1;
	}
	
	private String LinkMode2;
	public void setLinkMode2(String LinkMode2){
		this.LinkMode2 = LinkMode2;
	}
	public String getLinkMode2(){
		return this.LinkMode2;
	}
	
	private String LinkParameter1;
	public void setLinkParameter1(String LinkParameter1){
		this.LinkParameter1 = LinkParameter1;
	}
	public String getLinkParameter1(){
		return this.LinkParameter1;
	}
	
	private String LinkParameter2;
	public void setLinkParameter2(String LinkParameter2){
		this.LinkParameter2 = LinkParameter2;
	}
	public String getLinkParameter2(){
		return this.LinkParameter2;
	}
	
	private String LinkPage1;
	public void setLinkPage1(String LinkPage1){
		this.LinkPage1 = LinkPage1;
	}
	public String getLinkPage1(){
		return this.LinkPage1;
	}
	
	private String LinkPage2;
	public void setLinkPage2(String LinkPage2){
		this.LinkPage2 = LinkPage2;
	}
	public String getLinkPage2(){
		return this.LinkPage2;
	}
	
	private String LinkFlowKey1;
	public void setLinkFlowKey1(String LinkFlowKey1){
		this.LinkFlowKey1 = LinkFlowKey1;
	}
	public String getLinkFlowKey1(){
		return this.LinkFlowKey1;
	}
	
	private String LinkFlowKey2;
	public void setLinkFlowKey2(String LinkFlowKey2){
		this.LinkFlowKey2 = LinkFlowKey2;
	}
	public String getLinkFlowKey2(){
		return this.LinkFlowKey2;
	}
		
	private String DbActionMode1;
	public void setDbActionMode1(String DbActionMode1){
		this.DbActionMode1 = DbActionMode1;
	}
	public String getDbActionMode1(){
		return this.DbActionMode1;
	}
	
	private String DbActionMode2;
	public void setDbActionMode2(String DbActionMode2){
		this.DbActionMode2 = DbActionMode2;
	}
	public String getDbActionMode2(){
		return this.DbActionMode2;
	}
	
	private String BeforeText = Cnstnts.EMPTY_STRING;
	public void setBeforeText(String BeforeText){
		this.BeforeText = BeforeText;
	}
	public String getBeforeText(){
		return this.BeforeText;
	}
	
	private String AfterText = Cnstnts.EMPTY_STRING;;
	public void setAfterText(String AfterText){
		this.AfterText = AfterText;
	}
	public String getAfterText(){
		return this.AfterText;
	}
	
	public String printValue(){
		return " value='"+this.value+"'";
	}
	
	private String dbType=Cnstnts.STRING;
	public void setDbType(String dbType){
		this.dbType = dbType;
		if(this.dbType.equals(Cnstnts.INT)){
			this.align = Cnstnts.RIGHT;
		}
	}
	public String getDbType(){return this.dbType;}
	
	private int length=Cnstnts.DEFAULT_LENGTH;
	public void setLength(int length){this.length = length;}
	public int getLength(){return this.length;}
	public String printLength(){
		return " maxLength='"+this.length+"'";
	}
	
	private String htmlType=Cnstnts.HTML_TAG_TEXT;
	public void setHtmlType(String htmlType){this.htmlType = htmlType;}
	public String getHtmlType(){return this.htmlType;}
	
	private String align=Cnstnts.EMPTY_STRING;
	public void setAlign(String align){this.align=align;}
	public String getAlign(){return this.align;}
	public String printAlign(){
		if(this.align.trim().length()==0){
			return Cnstnts.EMPTY_STRING;
		} else {
			return " align='"+this.align+"'";
		}
	}
	public String printAlign(String align){
		if(this.align.trim().length()==0){
			return Cnstnts.EMPTY_STRING;
		} else {
			return " align='"+align+"'";
		}
	}
	
	private String width=Cnstnts.DEFAULT_WIDTH;
	public void setWidth(String width){this.width = width;}
	public String getWidth(){return this.width;}
	public String printWidth(){
		return " width='"+this.width+"'";
	}
	
	private int size=20;
	public void setSize(int size){this.size=size;}
	public int getSize(){return this.size;}
	public String printSize(){
		return " size='"+this.size+"'";
	}
	
	private int rows=3;
	public void setRows(int rows){this.rows=rows;}
	public int getRows(){return this.rows;}
	public String printRows(){
		return " rows='"+this.rows+"'";
	}
	
	private int cols=50;
	public void setCols(int cols){this.cols=cols;}
	public int getCols(){return this.cols;}
	public String printCols(){
		return " cols='"+this.cols+"'";
	}
	
	private int colspan=3;
	public void setColspan(int colspan){this.colspan=colspan;}
	public int getColspan(){return this.colspan;}
	public String printColspan(){
		if(this.colspan>1){
			return " colspan='"+this.colspan+"'";
		} else {
			return Cnstnts.EMPTY_STRING;
		}
	}
	
	private String listWidth=Cnstnts.DEFAULT_WIDTH;
	public void setListWidth(String listWidth){this.listWidth = listWidth;}
	public String getListWidth(){return this.listWidth;}
	public String printListWidth(){
		return " width='"+this.listWidth+"'";
	}
	
	private String searchCondition=Cnstnts.EQUAL;
	public void setSearchCondition(String searchCondition){
		this.searchCondition=searchCondition;
	}
	public String getSearchCondition(){return this.searchCondition;}
	
	private String bgcolor=Cnstnts.DEFAULT_TR_BGCOLOR_1;
	public void setBgcolor(String bgcolor){this.bgcolor = bgcolor;}
	public String getBgcolor(){return this.bgcolor;}
	
	private Properties mapingPrpt;
	public void setMapingPrpt(Properties mapingPrpt){
		this.mapingPrpt=mapingPrpt;
	}
	public Properties getMapingPrpt(){return this.mapingPrpt;}
	public String getMapingPrptValue(){
		if(this.mapingPrpt==null){
			return Cnstnts.EMPTY_STRING;
		} else {
			if(mapingPrpt.getProperty(this.getValue())!=null)
				return mapingPrpt.getProperty(this.getValue());
			else 
				return Cnstnts.EMPTY_STRING;
		}
	}
	
	private String onChange;
	public void setOnChange(String onChange){
		this.onChange=onChange;
	}
	public String getOnChange(){
		return this.onChange;
	}
	public String printOnChange(){
		if(this.onChange==null || this.onChange.trim().length()==0){
			return Cnstnts.EMPTY_STRING;
		} else {
			return " onChange='"+this.onChange+"'";
		}
	}
	
	private String onClick;
	public void setOnClick(String onClick){
		this.onClick=onClick;
	}
	public String getOnClick(){
		return this.onClick;
	}
	public String printOnClick(){
		if(this.onClick==null || this.onClick.trim().length()==0){
			return Cnstnts.EMPTY_STRING;
		} else {
			return " onClick='"+this.onClick+"'";
		}
	}
	
	private String onDblClick;
	public void setOnDblClick(String onDblClick){
		this.onDblClick=onDblClick;
	}
	public String getOnDblClick(){
		return this.onDblClick;
	}
	public String printOnDblClick(){
		if(this.onDblClick==null || this.onDblClick.trim().length()==0){
			return Cnstnts.EMPTY_STRING;
		} else {
			return " onDblClick='"+this.onDblClick+"'";
		}
	}
	
	private String buttonValue;
	public void setButtonValue(String buttonValue){
		this.buttonValue=buttonValue;
	}
	public String getButtonValue(){
		return this.buttonValue;
	}
	
	private String buttonClick;
	public void setButtonClick(String buttonClick){
		this.buttonClick=buttonClick;
	}
	public String getButtonClick(){
		return this.buttonClick;
	}
	public String printButtonTag(){
		if(this.buttonClick==null || this.buttonValue==null){
			return Cnstnts.EMPTY_STRING;
		}
		return "<input type='button' value='"+this.buttonValue+"'"+
								 " onClick='"+this.buttonClick+"'/>";
	}
	
	private List<SelectItem> selectList;
	public void setSelectList(List<SelectItem> selectList){
		this.selectList=selectList;
	}
	public List<SelectItem> getSelectList(){
		return this.selectList;
	}
	
	private boolean CheckEmpty=false;
	public void setCheckEmpty(boolean CheckEmpty){this.CheckEmpty=CheckEmpty;}
	public boolean checkEmpty(){return this.CheckEmpty;}
	
	private boolean Readonly=false;
	public void setReadonly(boolean Readonly){this.Readonly=Readonly;}
	public boolean readonly(){return this.Readonly;}
	
	private boolean SubTotalFlag=false;
	public void setSubTotalFlag(boolean SubTotalFlag){this.SubTotalFlag=SubTotalFlag;}
	public boolean subTotalFlag(){return this.SubTotalFlag;}
	
	private int subTotal;
	public void setSubtotal(int subTotal){
		this.subTotal = subTotal;
	}
	public int getSubTotal(){
		return this.subTotal;
	}
	
	private boolean NotShowCode=false;
	public void setNotShowCode(boolean NotShowCode){this.NotShowCode=NotShowCode;}
	public boolean notShowCode(){return this.NotShowCode;}
	
}