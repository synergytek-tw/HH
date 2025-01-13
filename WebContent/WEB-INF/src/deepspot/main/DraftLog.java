package deepspot.main;

import java.util.Iterator;
import java.util.List;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MultiDetail;

public class DraftLog extends MultiDetail {

    public DraftLog(){this.init();}

    public DraftLog(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field ParentId;
    public void setParentId(String ParentId){this.ParentId.setValue(ParentId);}
    public String getParentId(){return this.ParentId.getValue();}

    public Field LogTime;
    public void setLogTime(String LogTime){this.LogTime.setValue(LogTime);}
    public String getLogTime(){return this.LogTime.getValue();}

    public Field Logger;
    public void setLogger(String Logger){this.Logger.setValue(Logger);}
    public String getLogger(){return this.Logger.getValue();}

    public Field LogStatus;
    public void setLogStatus(String LogStatus){this.LogStatus.setValue(LogStatus);}
    public String getLogStatus(){return this.LogStatus.getValue();}
  
    public Field LogMemo;
    public void setLogMemo(String LogMemo){this.LogMemo.setValue(LogMemo);}
    public String getLogMemo(){return this.LogMemo.getValue();}
    
    final int FRAME_HEIGHT = 200;

    public void init() {
        super.init();
        this.setProgramId("jsp.DraftLog");
        this.setTableName("DraftLog");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");

        this.LogTime = new Field("LogTime", this.getTableName());
        this.LogTime.setCheckEmpty(true);
        this.LogTime.setDbType("varchar(20)");

        this.Logger = new Field("Logger", this.getTableName());
        this.Logger.setCheckEmpty(true);
        this.Logger.setDbType("varchar(50)");

        this.LogStatus = new Field("LogStatus", this.getTableName());
        this.LogStatus.setCheckEmpty(true);
        this.LogStatus.setDbType("nvarchar(50)");
        
        this.LogMemo = new Field("LogMemo", this.getTableName());
        this.LogMemo.setCheckEmpty(true);
        this.LogMemo.setDbType("varchar(500)");
        
        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);
        
        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.ParentId);

        this.DbFields.add(this.LogTime);

        this.DbFields.add(this.Logger);

        this.DbFields.add(this.LogStatus);
        
        this.DbFields.add(this.LogMemo);
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();

            this.LogTime.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.LogTime);
            
            this.LogStatus.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.LogStatus);
            
            this.LogMemo.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
        	rtnString += this.printHtml(this.LogMemo);
            
            this.Logger.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Logger);
        }
        return rtnString;
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            DraftLog preObj = (DraftLog) userInfo.getObj(this.getTableName());
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
    	String SQL = "select * from "+this.getTableName()+" where ParentId='"+this.getParentId()+"'";
		this.setDbFields();
		List<Field> fieldList = this.getDbFields();
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldList);
		
		if(findList.size()==0){
			return Cnstnts.EMPTY_STRING;
		}
		
		StringBuffer strBfr = new StringBuffer();

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText2="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.DraftLog.LogTime")+"</td>";
		String thText3="<td align='center' width='20%'>"+this.getUserInfo().getMsg("jsp.DraftLog.LogStatus")+"</td>";
		String thText4="<td align='center' width='50%'>"+this.getUserInfo().getMsg("jsp.DraftLog.LogMemo")+"</td>";
		String thText5="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.DraftLog.Logger")+"</td>";
		
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText2+thText3+thText4+thText5+"</tr>");
		
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		for(Iterator itr=findList.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			DraftLog obj = new DraftLog();
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("FlowKey")){
					obj.FlowKey.setValue(field.getValue());
				}
				if(field.getName().equals("LogTime")){
					obj.LogTime.setValue(field.getValue());
				}
				if(field.getName().equals("LogStatus")){
					obj.LogStatus.setValue(field.getValue());
				}
				if(field.getName().equals("LogMemo")){
					obj.LogMemo.setValue(field.getValue());
				}
				if(field.getName().equals("Logger")){
					obj.Logger.setValue(field.getValue());
				}
			}
			String tdText2="<td align='center'>"+obj.LogTime.getValue()+"</td>";
			String tdText3="<td>"+obj.LogStatus.getValue()+"</td>";
			String tdText4="<td>"+obj.LogMemo.getValue()+"</td>";
			String tdText5="<td align='center'>"+obj.Logger.getValue()+"</td>";
			printValue = tdText2+tdText3+tdText4+tdText5;
			if(i%2==0){
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
			} else {
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
			}
			String onClick = "";
			strBfr.append(newLine + "<tr "+bgColor+onClick+">"+printValue+"</tr>");
		}
		strBfr.append(newLine + "</table>");

		return strBfr.toString();
	}
    
    public boolean checkInsertError() throws Exception {
        if(super.checkInsertError()){
            return true;
        } else {
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
    public String printFunctionBar() throws Exception {
		return null;
	}
    
    protected String getAjaxReasult(UserBean userInfo,String parentId) throws Exception {
		this.setUserInfo(userInfo);
		this.ParentId.setValue(parentId);
		return this.printAjaxReasult();
    }
    
    public String printAjaxReasult() throws Exception {
		return this.printSearchReasult();
	}
}
