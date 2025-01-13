package deepspot.main;

import java.util.Iterator;
import java.util.List;

import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.QueryBean;
import deepspot.util.Util;

public class CustomerQuery extends QueryBean{

	public CustomerQuery()throws Exception{this.init();}
	
	public Field FlowKey;
    public void setFlowKey(String FlowKey){this.FlowKey.setValue(FlowKey);}
    public String getFlowKey(){return this.FlowKey.getValue();}

    public Field Names;
    public void setNames(String Names){this.Names.setValue(Names);}
    public String getNames(){return this.Names.getValue();}
    
    public Field TelNo;
    public void setTelNo(String TelNo){this.TelNo.setValue(TelNo);}
    public String getTelNo(){return this.TelNo.getValue();}
    
    public Field Address;
    public void setAddress(String Address){this.Address.setValue(Address);}
    public String getAddress(){return this.Address.getValue();}
    
    public void init() throws Exception{
        super.init();
        this.setProgramId("jsp.CustomerQuery");

        this.Names = new Field("Names","Customer");
        this.Names.setSearchCondition(Cnstnts.LIKE);
        
        this.TelNo = new Field("TelNo","Customer");
        this.TelNo.setSearchCondition(Cnstnts.LIKE);
        
        this.Address = new Field("Address","Customer");
        this.Address.setSearchCondition(Cnstnts.LIKE);
        
        this.FlowKey = new Field("FlowKey","Customer");
        this.FlowKey.setSearchCondition(Cnstnts.LIKE);
    }

    public String printMainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        
        this.Names.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        
        this.FlowKey.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.FlowKey.setAnotherField(this.Names);
        rtnString += this.printHtml(this.FlowKey);
        
        this.Address.setHtmlType(Cnstnts.HTML_TAG_TEXT);
    
    	this.TelNo.setHtmlType(Cnstnts.HTML_TAG_TEXT);
    	this.TelNo.setAnotherField(this.Address);
    	rtnString += this.printHtml(this.TelNo);
        	
        return rtnString;
    }
    
    public void doAction(UserBean userInfo) throws Exception{
    	this.setUserInfo(userInfo);
    	this.resetMessage();
  		if(this.onBtnSubmit()){
  			this.setRunFlag(true);
  		}
  	}
    
    @SuppressWarnings("unchecked")
	public String printResultTable() throws Exception{
  		String rtnString = Cnstnts.EMPTY_STRING;
  		if(this.onBtnSubmit() && this.runFlag()){
  			char newLine = Cnstnts.NEW_LINE;
  			rtnString+=newLine+"<table"+Cnstnts.DEFAULT_TABLE_BGCOLOR+">";
  			rtnString += newLine+"  <tr><td align='center' colspan='4'>"+
  				"<font size='3'><b>"+this.getUserInfo().getMsg("jsp.Customer.title")+"</b></font></td></tr>";
		
  			String fieldNames1=this.getUserInfo().getMsg("jsp.Customer.FlowKey");
  			String fieldNames2=this.getUserInfo().getMsg("jsp.Customer.Names");
  			String fieldNames3=this.getUserInfo().getMsg("jsp.Customer.TelNo");
  			String fieldNames4=this.getUserInfo().getMsg("jsp.Customer.Address");
		
  			rtnString += newLine + "<tr"+this.getThBgcolor()+">";
  			rtnString += "<td align='center' width='15%'>"+fieldNames1+"</td>";
  			rtnString += "<td align='center' width='25%'>"+fieldNames2+"</td>";
  			rtnString += "<td align='center' width='15%'>"+fieldNames3+"</td>";
  			rtnString += "<td align='center' width='45%'>"+fieldNames4+"</td>";
  			rtnString += newLine + "</tr>";
		
  			String whereSQL = Cnstnts.EMPTY_STRING;
  			whereSQL = Util.addWhereSQL(whereSQL, this.FlowKey);
  			whereSQL = Util.addWhereSQL(whereSQL, this.Names);
  			whereSQL = Util.addWhereSQL(whereSQL, this.TelNo);
  			whereSQL = Util.addWhereSQL(whereSQL, this.Address);
  			whereSQL = Util.addWhereSQL(whereSQL, new Field("CollectType"));
  			String SQL = "select * from Customer "+whereSQL;
  			Customer customer = new Customer();
  			customer.setDbFields();
  			List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, customer.getDbFields());
  			int i=0;
  			String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
  			String printValue = Cnstnts.EMPTY_STRING;
  			for(Iterator itr=findList.iterator();itr.hasNext();i++){
  				List<Field> dataFields = (List<Field>)itr.next();
  				String FlowKey = Cnstnts.EMPTY_STRING;
  				String Names = Cnstnts.EMPTY_STRING;
	  			String TelNo = Cnstnts.EMPTY_STRING;
	  			String Address = Cnstnts.EMPTY_STRING;
	  			String CollectType = Cnstnts.EMPTY_STRING;
				for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
					Field field = (Field)fieldsItr.next();
					if(field.getName().equals("FlowKey")){
						FlowKey = field.getValue();
					}
					if(field.getName().equals("Names")){
						Names = field.getValue();
					}
					if(field.getName().equals("TelNo")){
						TelNo = field.getValue();
					}
					if(field.getName().equals("Address")){
						Address = field.getValue();
					}
					if(field.getName().equals("CollectType")){
						CollectType = field.getValue();
					}
				}
				printValue =  "<td>"+FlowKey+"</td>";
				printValue += "<td>"+Names+"</td>";
				printValue += "<td>"+TelNo+"</td>";
				printValue += "<td>"+Address+"</td>";
				if(i%2==0){
					bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
				} else {
					bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
				}
				String onClick = " onClick='window.opener.input.customerId.value=\""+FlowKey+"\";"+
								 "window.opener.input.customerName.value=\""+Names+"\";"+
								 "window.opener.input.address.value=\""+Address+"\";"+
								 "window.opener.input.tel.value=\""+TelNo+"\";"+
								 "window.opener.input.paymentType.value=\""+CollectType+"\";" +
								 "window.opener.setValue();window.close()'";
				rtnString += "<tr style='cursor:hand'"+bgColor+onClick+">"+printValue+"</tr>";
			}
  			if(i==0){
  				rtnString += "<tr "+bgColor+"><td colspan=4 align=center>"+this.getUserInfo().getMsg("jsp.common.noRecords")+"</td></tr>";
  			}
	  		rtnString+=newLine+"</table>";
  		}
		return rtnString;
    }

}