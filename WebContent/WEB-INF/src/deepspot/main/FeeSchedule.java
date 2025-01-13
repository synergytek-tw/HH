package deepspot.main;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.QueryBean;
import deepspot.html.HiddenTag;
import deepspot.util.Util;

public class FeeSchedule extends QueryBean{

	public FeeSchedule() throws Exception{
		this.init();
	}
    
    private Field FeeScheduleDate;
    public void setFeeScheduleDate(String FeeScheduleDate){this.FeeScheduleDate.setValue(FeeScheduleDate);}
    public String getFeeScheduleDate(){return this.FeeScheduleDate.getValue();}
    
    private Field FeeScheduleDateTo;
    public void setFeeScheduleDateTo(String FeeScheduleDateTo){this.FeeScheduleDateTo.setValue(FeeScheduleDateTo);}
    public String getFeeScheduleDateTo(){return this.FeeScheduleDateTo.getValue();}
    
    public Field KeepMaintain;
    public void setKeepMaintain(String KeepMaintain){this.KeepMaintain.setValue(KeepMaintain);}
    public String getKeepMaintain(){return this.KeepMaintain.getValue();}
    
    public Field FeeDate;
    public void setFeeDate(String FeeDate){this.FeeDate.setValue(FeeDate);}
    public String getFeeDate(){return this.FeeDate.getValue();}
    
    public Field PtoFee;
    public void setPtoFee(String PtoFee){this.PtoFee.setValue(PtoFee);}
    public String getPtoFee(){return this.PtoFee.getValue();}

    public Field ServiceFee;
    public void setServiceFee(String ServiceFee){this.ServiceFee.setValue(ServiceFee);}
    public String getServiceFee(){return this.ServiceFee.getValue();}

    public Field OtherFee;
    public void setOtherFee(String OtherFee){this.OtherFee.setValue(OtherFee);}
    public String getOtherFee(){return this.OtherFee.getValue();}
    
    public Field NextScheduleYear;
    public void setNextScheduleYear(String NextScheduleYear){this.NextScheduleYear.setValue(NextScheduleYear);}
    public String getNextScheduleYear(){return this.NextScheduleYear.getValue();}

    public Field NextScheduleDate;
    public void setNextScheduleDate(String NextScheduleDate){this.NextScheduleDate.setValue(NextScheduleDate);}
    public String getNextScheduleDate(){return this.NextScheduleDate.getValue();}

    public Field GiveupReason;
    public void setGiveupReason(String GiveupReason){this.GiveupReason.setValue(GiveupReason);}
    public String getGiveupReason(){return this.GiveupReason.getValue();}
    
    private Field DoProcessFlag;
    public void setDoProcessFlag(String DoProcessFlag){this.DoProcessFlag.setValue(DoProcessFlag);}
    public String getDoProcessFlag(){return this.DoProcessFlag.getValue();}
    
    private String[] MarkKeys;
    public void setMarkKeys(String[] markKeys){this.MarkKeys=markKeys;}
    public String[] getMarkKeys(){return this.MarkKeys;}
    
    public void init() throws Exception {
        super.init();
        this.setProgramId("jsp.FeeSchedule");
        
        this.FeeScheduleDate = new Field("FeeScheduleDate","FeeSchedule");

        this.FeeScheduleDateTo = new Field("FeeScheduleDateTo","FeeSchedule");
        
        this.KeepMaintain = new Field("KeepMaintain", "PatentFeeSchedule");
        this.KeepMaintain.setDbType("char(1)");
        
        this.FeeDate = new Field("FeeDate", "PatentFeeSchedule");
        this.FeeDate.setDbType("varchar(10)");
        
        this.PtoFee = new Field("PtoFee", "PatentFeeSchedule");
        this.PtoFee.setDbType("int");

        this.ServiceFee = new Field("ServiceFee", "PatentFeeSchedule");
        this.ServiceFee.setDbType("int");

        this.OtherFee = new Field("OtherFee", "PatentFeeSchedule");
        this.OtherFee.setDbType("int");
        
        this.NextScheduleYear = new Field("NextScheduleYear", "PatentFeeSchedule");
        this.NextScheduleYear.setDbType("varchar(10)");

        this.NextScheduleDate = new Field("NextScheduleDate", "PatentFeeSchedule");
        this.NextScheduleDate.setDbType("varchar(10)");

        this.GiveupReason = new Field("GiveupReason", "PatentFeeSchedule");
        this.GiveupReason.setDbType("nvarchar(500)");
        
        this.DoProcessFlag = new Field("DoProcessFlag","FeeSchedule");
        
        this.MarkKeys = null;
    }
    
    public String printHiddenTags(){
  		HashMap<String,String> hm = new HashMap<String,String>();
  		hm.put("submitFlag",Cnstnts.EMPTY_STRING);
  		hm.put("doProcessFlag",Cnstnts.EMPTY_STRING);
  		hm.put("tagId",Cnstnts.EMPTY_STRING);
  		return new HiddenTag().print(hm);
  	}

    public String printMainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        
        if(this.FeeScheduleDate.getValue().trim().length()==0){
			this.setFeeScheduleDate(Util.firstOfMonth());
		}
		if(this.FeeScheduleDateTo.getValue().trim().length()==0){
			this.setFeeScheduleDateTo(Util.lastOfMonth());
		}
        
        this.FeeScheduleDateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        
        this.FeeScheduleDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        this.FeeScheduleDate.setAnotherField(this.FeeScheduleDateTo);
    	rtnString += this.printHtml(this.FeeScheduleDate);
        	
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
  		boolean canSubmit = false;
  		String whereSQL = null;
  		if(this.MarkKeys!=null && this.MarkKeys.length>0){
  			 for(int i=0;i<this.MarkKeys.length;i++){
 				if(i==0){
 					whereSQL="'"+this.MarkKeys[i]+"'";
 				} else {
 					whereSQL+=",'"+this.MarkKeys[i]+"'";
 				}
 			}
 			whereSQL = " where FlowKey in("+whereSQL+")";
 			
 			canSubmit = true;
  		}
  		
  		if(this.onBtnSubmit() && this.runFlag()){
  			if(whereSQL==null){
				whereSQL = "where Status!='RS05'";
				whereSQL = Util.addBetweenSQL(whereSQL, this.FeeScheduleDate, this.FeeScheduleDateTo);
			}
  			String SQL = "select * from PatentCase "+whereSQL;
  			//System.out.println(SQL);
  			PatentCase patentCase = new PatentCase();
  			patentCase.setDbFields();
  			List<Field> fieldLst = patentCase.getDbFields();
  			List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldLst);
  			
  			String bgColor = " bgcolor='#FFFFFF'";
  			rtnString+="<br><table border='0' cellpadding='1' cellspacing='1' width='100%'><tr><td align='center'>"+
					"<font size='3'><b>"+this.getUserInfo().getMsg("jsp.PatentCase.title")+"</b></font></td></tr></table>";
  			
  			rtnString+="<table  border='0' cellpadding='1' cellspacing='1' bgcolor='#D7D7D7' width='100%'>";
  			String tdTitle1, tdTitle2, tdTitle3, tdTitle4, 
  				   tdTitle5, tdTitle6, tdTitle7;
  			tdTitle1="<td align='center' width='15%'>"+
				this.getUserInfo().getMsg("jsp.PatentCase.FlowKey")+"</td>";
  			tdTitle2="<td align='center' width='10%'>"+
				this.getUserInfo().getMsg("jsp.PatentCase.PatentOffice")+"</td>";
  			tdTitle3="<td align='center' width='10%'>"+
				this.getUserInfo().getMsg("jsp.PatentCase.PatentType")+"</td>";
  			tdTitle4="<td align='center' width='37%'>"+
				this.getUserInfo().getMsg("jsp.PatentCase.Title")+"</td>";
  			tdTitle5="<td align='center' width='15%'>"+
				this.getUserInfo().getMsg("jsp.PatentCase.FeeScheduleDate")+"</td>";
			tdTitle6="<td align='center' width='10%'>"+
				this.getUserInfo().getMsg("jsp.PatentCase.Status")+"</td>";
			if(findList.size()>1){
				tdTitle7="<td align='center'  width='3%'><input type='CheckBox' onClick='markAll()'/></td>";
			} else {
				tdTitle7="<td align='center'  width='3%'>&nbsp;</td>";
			}
			
			rtnString += "<tr"+bgColor+">"+tdTitle1+tdTitle2+tdTitle3+tdTitle4+
  									tdTitle5+tdTitle6+tdTitle7+"</tr>";
		
  			if(findList.size()==0){
  				rtnString += "<tr "+bgColor+"><td colspan=7 align=center>"+this.getUserInfo().getMsg("jsp.common.noRecords")+"</td></tr>";
  				return rtnString;
  			}
  			
  			Properties categoryPrpt = new Category().getNamesPrpts();
  			
  			String printValue = Cnstnts.EMPTY_STRING;
  			for(Iterator itr=findList.iterator();itr.hasNext();){
  				boolean showFlag = false;
  				List<Field> dataFields = (List<Field>)itr.next();
  				String tdText1 = Cnstnts.EMPTY_STRING;
  				String tdText2 = Cnstnts.EMPTY_STRING;
  				String tdText3 = Cnstnts.EMPTY_STRING;
  				String tdText4 = Cnstnts.EMPTY_STRING;
  				String tdText5 = Cnstnts.EMPTY_STRING;
  				String tdText6 = Cnstnts.EMPTY_STRING;
  				String tdText7 = Cnstnts.EMPTY_STRING;
				for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
					Field field = (Field)fieldsItr.next();
					
					showFlag = true;
					String fieldValue = "&nbsp;";
					if(field.getValue().trim().length()>0){
						fieldValue = field.getValue();
					}
					if(field.getName().equals("FlowKey")){
						tdText1 = "<td align=center>"+fieldValue+"</td>";
						String checked = Cnstnts.EMPTY_STRING;
						if(canSubmit){
							checked = " checked";
						}
						tdText7 = "<td align=center><input type='CheckBox' " +
						"id='markKey' name='markKey' value='"+fieldValue+"'"+checked+"/></td>";
					}
					if(field.getName().equals("PatentOffice")){
						tdText2 = "<td align=center>"+categoryPrpt.getProperty(fieldValue)+"</td>";
					}
					if(field.getName().equals("PatentType")){
						tdText3 = "<td align=center>"+categoryPrpt.getProperty(fieldValue)+"</td>";
					}
					if(field.getName().equals("Title")){
						tdText4 = "<td>"+fieldValue+"</td>";
					}
					if(field.getName().equals("FeeScheduleDate")){
						tdText5 = "<td align=center>"+fieldValue+"</td>";
					}
					if(field.getName().equals("Status")){
						tdText6 = "<td align=center>"+categoryPrpt.getProperty(fieldValue)+"</td>";
					}
				}
				if(showFlag){
					printValue = tdText1+tdText2+tdText3+tdText4+tdText5+tdText6+tdText7;
					rtnString += "<tr"+bgColor+">"+printValue+"</tr>";
				}
			}
  			
  			
  			if(canSubmit){
  				rtnString+="<tr><td colspan='7'>" +
  						   "<table width='100%' border='0' cellpadding='1' cellspacing='1'>";
  				this.KeepMaintain.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
  	            
  	            	this.FeeDate.setCheckEmpty(true);
  	            	this.FeeDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
  	            	this.KeepMaintain.setAnotherField(this.FeeDate);
  	            	rtnString += this.printHtml(this.KeepMaintain);
  	            	
  	            	this.OtherFee.setHtmlType(Cnstnts.HTML_TAG_TEXT);
  	            	this.OtherFee.setSize(5);
  	            	
  	            	this.ServiceFee.setHtmlType(Cnstnts.HTML_TAG_TEXT);
  	            	this.ServiceFee.setSize(5);
  	            	this.ServiceFee.setAnotherField(this.OtherFee);
  	            	
  	            	this.PtoFee.setHtmlType(Cnstnts.HTML_TAG_TEXT);
  	            	this.PtoFee.setSize(5);
  	            	this.PtoFee.setAnotherField(this.ServiceFee);
  	            	rtnString += this.printHtml(this.PtoFee);
  	            	
  	            	this.NextScheduleDate.setHtmlType(Cnstnts.HTML_TAG_TEXT);
  	                this.NextScheduleDate.setSize(1);
  	                
  	                this.NextScheduleYear.setHtmlType(Cnstnts.HTML_TAG_TEXT);
  	            	this.NextScheduleYear.setSize(1);
  	            	this.NextScheduleYear.setAnotherField(this.NextScheduleDate);
  	                rtnString += this.printHtml(this.NextScheduleYear);
  	              	            	
  	            	this.GiveupReason.setCheckEmpty(true);
  	            	this.GiveupReason.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
  	                rtnString += this.printHtml(this.GiveupReason);
  	            
  				rtnString+="<tr><td colspan='4' align='center'><input type='button' value='"+
  							this.getUserInfo().getMsg("jsp.FeeSchedule.ProcessBtn")+"' "+
  							"onClick='document.input.doProcessFlag.value=\"true\";" +
  							"document.input.submitFlag.value=\"true\";setValue()'></td></tr>" +
  							"</table></td></tr>";
  			} else {
  				rtnString+="<tr><td colspan='7' align='right'><input type='button' value='"+
					this.getUserInfo().getMsg("jsp.FeeSchedule.FeeProcess")+"' "+
					"onClick='document.input.submitFlag.value=\"true\";setValue()'></td></tr>";
  			}
  			
  			rtnString+="</table>" +
  					"<input type='hidden' id='checkedVaule' name='checkedVaule'/>";
  			rtnString+="<script>"+
				 "function markAll(){"+
				 	"var setValue = false;"+
				 	"if(document.input.checkedVaule.value=='true'){"+
				 		"document.input.checkedVaule.value='';"+
				 	"} else {"+
				 		"document.input.checkedVaule.value='true';"+
				 		"setValue = true;"+
				 	"}"+
				 	"for(i=0;i<document.input[\"markKey\"].length;i++){"+
				 		"document.input.markKey[i].checked=setValue;"+
				 	"}"+
				 "}"+
			   "</script>";
  		}
		return rtnString;
    }

}