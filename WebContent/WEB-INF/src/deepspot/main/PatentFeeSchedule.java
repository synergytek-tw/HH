package deepspot.main;

import java.util.Iterator;
import java.util.List;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MultiDetail;

public class PatentFeeSchedule extends MultiDetail {

    public PatentFeeSchedule(){this.init();}

    public PatentFeeSchedule(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field ParentId;
    public void setParentId(String ParentId){this.ParentId.setValue(ParentId);}
    public String getParentId(){return this.ParentId.getValue();}

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
    
    final int FRAME_HEIGHT = 150;

    public void init() {
        super.init();
        this.setProgramId("jsp.PatentFeeSchedule");
        this.setTableName("PatentFeeSchedule");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");

        this.KeepMaintain = new Field("KeepMaintain", this.getTableName());
        this.KeepMaintain.setDbType("char(1)");
        
        this.FeeDate = new Field("FeeDate", this.getTableName());
        this.FeeDate.setDbType("varchar(10)");
        
        this.PtoFee = new Field("PtoFee", this.getTableName());
        this.PtoFee.setDbType("int");

        this.ServiceFee = new Field("ServiceFee", this.getTableName());
        this.ServiceFee.setDbType("int");

        this.OtherFee = new Field("OtherFee", this.getTableName());
        this.OtherFee.setDbType("int");
        
        this.NextScheduleYear = new Field("NextScheduleYear", this.getTableName());
        this.NextScheduleYear.setDbType("varchar(10)");

        this.NextScheduleDate = new Field("NextScheduleDate", this.getTableName());
        this.NextScheduleDate.setDbType("varchar(10)");

        this.GiveupReason = new Field("GiveupReason", this.getTableName());
        this.GiveupReason.setDbType("nvarchar(500)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);
        
        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.ParentId);
        this.DbFields.add(this.KeepMaintain);
        this.DbFields.add(this.FeeDate);
        this.DbFields.add(this.PtoFee);
        this.DbFields.add(this.ServiceFee);
        this.DbFields.add(this.OtherFee);
        this.DbFields.add(this.NextScheduleYear);
        this.DbFields.add(this.NextScheduleDate);
        this.DbFields.add(this.GiveupReason);
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();
        	
            this.KeepMaintain.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            this.KeepMaintain.setOnClick("setValue()");
            if(this.getKeepMaintain().equals("Y")){
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
            } else {
            	rtnString += this.printHtml(this.KeepMaintain);
            	
            	this.GiveupReason.setCheckEmpty(true);
            	this.GiveupReason.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
                rtnString += this.printHtml(this.GiveupReason);
            }
        }
        return rtnString;
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            PatentFeeSchedule preObj = (PatentFeeSchedule) userInfo.getObj(this.getTableName());
            if(this.onBtnDeleteDetail()
                    && this.getDeleteItems()!=null
            				   && this.getDeleteItems().length>0){
                for(int i=0;i<this.getDeleteItems().length;i++){
                    int seqNo = Integer.parseInt(this.getDeleteItems()[i]);
                    preObj.getDetails().remove(seqNo-i);
                }
            }
            this.setSearchResult(preObj.getSearchResult());
            if (!this.getDataFromDB()) {
                this.setDetails(preObj.getDetails());
            }
        }
    }
    
    protected String getSearchReasult(UserBean userInfo,String parentId) throws Exception {
    	this.setDoSearchFlag(Cnstnts.TRUE_FLAG);
		this.setPageActionMode(Cnstnts.SEARCH);
		this.setUserInfo(userInfo);
		this.ParentId.setValue(parentId);
		return this.printSearchReasult();
    }
    
    @SuppressWarnings("unchecked")
	public String printSearchReasult() throws Exception {
		if (this.onBtnSearch()) {
			this.setSearchResult(this.getSearchList());
		}

		StringBuffer strBfr = new StringBuffer();
		if (this.getShowField() == null || this.getShowField().length == 0
				|| this.getSearchResult() == null) {
			return strBfr.toString();
		}
		
		boolean canAssesFlag = false;
		PatentCase parentObj = (PatentCase)this.getUserInfo().getObj("PatentCase");
		if(parentObj.getDbActionMode().equals(Cnstnts.UPDATE) 
				&& parentObj.getSignOutId().equals(this.getUserInfo().getAttribute("emp_id"))){
			canAssesFlag = true;
		}

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thInsert=Cnstnts.EMPTY_STRING;
		String thText1="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.PatentFeeSchedule.KeepMaintain")+"</td>";
		String thText2="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.PatentFeeSchedule.FeeDate")+"</td>";
		String thText3="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.PatentFeeSchedule.PtoFee")+"</td>";
		String thText4="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.PatentFeeSchedule.ServiceFee")+"</td>";
		String thText5="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.PatentFeeSchedule.OtherFee")+"</td>";
		String thText6="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.PatentFeeSchedule.NextScheduleYear")+"</td>";
		String thText7="<td align='center' width='10%'>"+this.getUserInfo().getMsg("jsp.PatentFeeSchedule.NextScheduleDate")+"</td>";
		String thText8="<td align='center' width='30%'>"+this.getUserInfo().getMsg("jsp.PatentFeeSchedule.GiveupReason")+"</td>";
		String thDelete=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			insertImg = "<img src='img/addanchr.gif' style='cursor: hand' "+
							 "title='"+this.getUserInfo().getMsg("jsp.Flow_detail.addNew")+"' "+
							 "onClick='openTabFrame(getElementById(\"tabText\").value,\"insert\",\""+
							 		  parentObj.getFlowKey()+"\","+this.FRAME_HEIGHT+")'/>";
			thInsert = "<td align='center' width='3%'>"+insertImg+"</td>";
			thDelete = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thInsert+thText1+thText2+thText3+
									thText4+thText5+thText6+thText7+thText8+thDelete+"</tr>");
		
		String SQL = "select * from PatentFeeSchedule "+
					 "where ParentId='"+this.getParentId()+"'";
		PatentFeeSchedule patentFeeSchedule = new PatentFeeSchedule();
		patentFeeSchedule.setDbFields();
		List<Field> fieldList = patentFeeSchedule.getDbFields();
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldList);
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		for(Iterator itr=findList.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			String FlowKey = Cnstnts.EMPTY_STRING;
			String KeepMaintain = Cnstnts.EMPTY_STRING;
			String FeeDate = Cnstnts.EMPTY_STRING;
			String PtoFee = Cnstnts.EMPTY_STRING;
			String ServiceFee = Cnstnts.EMPTY_STRING;
			String OtherFee = Cnstnts.EMPTY_STRING;
			String NextScheduleYear = Cnstnts.EMPTY_STRING;
			String NextScheduleDate = Cnstnts.EMPTY_STRING;
			String GiveupReason = Cnstnts.EMPTY_STRING;
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("FlowKey")){
					FlowKey = field.getValue();
				}				
				if(field.getName().equals("KeepMaintain")){
					KeepMaintain = field.getValue();
				}
				if(field.getName().equals("FeeDate")){
					FeeDate = field.getValue();
				}
				if(field.getName().equals("PtoFee")){
					PtoFee = field.getValue();
				}
				if(field.getName().equals("ServiceFee")){
					ServiceFee = field.getValue();
				}
				if(field.getName().equals("OtherFee")){
					OtherFee = field.getValue();
				}
				if(field.getName().equals("NextScheduleYear")){
					NextScheduleYear = field.getValue();
				}
				if(field.getName().equals("NextScheduleDate")){
					NextScheduleDate = field.getValue();
				}
				if(field.getName().equals("GiveupReason")){
					GiveupReason = field.getValue();
				}
			}
			String tdEdit=Cnstnts.EMPTY_STRING;
			String tdText1="<td align='center'>"+KeepMaintain+"</td>";
			String tdText2="<td align='center'>"+FeeDate+"</td>";
			String tdText3="<td align='right'>"+PtoFee+"</td>";
			String tdText4="<td align='right'>"+ServiceFee+"</td>";
			String tdText5="<td align='right'>"+OtherFee+"</td>";
			String tdText6="<td align='center'>"+NextScheduleYear+"</td>";
			String tdText7="<td align='center'>"+NextScheduleDate+"</td>";
			String tdText8="<td>"+GiveupReason+"</td>";
			String tdDelete=Cnstnts.EMPTY_STRING;
			if(canAssesFlag){ 
				String editImg = "<img src='img/edit2.gif' style='cursor: hand' "+
								 		"title='"+this.getUserInfo().getMsg("jsp.Flow.edit")+"' "+
								 		"onClick='openTabFrame(getElementById(\"tabText\").value,\"update\",\""+
								 		FlowKey+"\","+this.FRAME_HEIGHT+")'/>";
				tdEdit = "<td align='center'>"+editImg+"</td>";
				String deleteImg = "<img src='img/C_Delete_Md_N.png' style='cursor: hand' "+
				 						"title='"+this.getUserInfo().getMsg("jsp.common.delete")+"' "+
				 						"onClick='openTabFrame(getElementById(\"tabText\").value,\"delete\",\""+
				 						FlowKey+"\","+this.FRAME_HEIGHT+")'/>";
				tdDelete = "<td align='center'>"+deleteImg+"</td>";
			}
			printValue = tdEdit+tdText1+tdText2+tdText3+tdText4+tdText5+tdText6+tdText7+tdText8+tdDelete;
			if(i%2==0){
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
			} else {
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
			}
			
			strBfr.append(newLine + "<tr"+bgColor+">"+printValue+"</tr>");
		}
		strBfr.append(newLine + "</table>");

		return strBfr.toString();
	}
    
    public boolean checkInsertError() throws Exception {
        if(super.checkInsertError()){
            return true;
        } else {
        	if(this.getKeepMaintain().equals("Y")){
        		if(this.getFeeDate().trim().length()==0){
        			this.setErrorMessage(this.getErrorMessage(this.FeeDate));
        			return true;
        		}
        	} else {
        		if(this.getGiveupReason().trim().length()==0){
        			this.setErrorMessage(this.getErrorMessage(this.GiveupReason));
        			return true;
        		}
        	}
            return false;
        }
    }

    public boolean checkUpdateError() throws Exception {
        return this.checkInsertError();
    }

    public boolean checkDeleteError() throws Exception {
        if(super.checkDeleteError()){
            return true;
        } else {
            return false;
        }
    }

}