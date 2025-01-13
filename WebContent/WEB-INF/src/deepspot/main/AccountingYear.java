package deepspot.main;

import java.util.List;
import java.util.Properties;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.basic.SelectItem;
import deepspot.util.Util;

public class AccountingYear extends MasterBean {

    public AccountingYear(){this.init();}

    public AccountingYear(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field Names;
    public void setNames(String Names){this.Names.setValue(Names);}
    public String getNames(){return this.Names.getValue();}

    public Field DateFrom;
    public void setDateFrom(String DateFrom){this.DateFrom.setValue(DateFrom);}
    public String getDateFrom(){return this.DateFrom.getValue();}

    public Field DateTo;
    public void setDateTo(String DateTo){this.DateTo.setValue(DateTo);}
    public String getDateTo(){return this.DateTo.getValue();}

    public Field CanQueryFlag;
    public void setCanQueryFlag(String CanQueryFlag){this.CanQueryFlag.setValue(CanQueryFlag);}
    public String getCanQueryFlag(){return this.CanQueryFlag.getValue();}

    public void init() {
        super.init();
        this.setProgramId("jsp.AccountingYear");
        this.setTableName("AccountingYear");

        this.Names = new Field("Names", this.getTableName());
        this.Names.setCheckEmpty(true);
        this.Names.setSearchCondition(Cnstnts.LIKE);

        this.DateFrom = new Field("DateFrom", this.getTableName());

        this.DateTo = new Field("DateTo", this.getTableName());

        this.CanQueryFlag = new Field("CanQueryFlag", this.getTableName());

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();

    }

    public void setDbFields() {
        super.setDbFields();
        this.Names.setDbType("nvarchar(50)");
        this.DbFields.add(this.Names);

        this.DateFrom.setDbType("varchar(10)");
        this.DbFields.add(this.DateFrom);

        this.DateTo.setDbType("varchar(10)");
        this.DbFields.add(this.DateTo);

        this.CanQueryFlag.setDbType("char(1)");
        this.DbFields.add(this.CanQueryFlag);

    }

    public String printSearchTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onSearchMode()) {
            this.Names.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Names);

            this.DateFrom.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            rtnString += this.printHtml(this.DateFrom);

            this.DateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            rtnString += this.printHtml(this.DateTo);

        }
        return rtnString;
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	this.CanQueryFlag.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
        	
            this.Names.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Names.setAnotherField(this.CanQueryFlag);
            rtnString += this.printHtml(this.Names);
            
            this.DateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);

            this.DateFrom.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.DateFrom.setAnotherField(this.DateTo);
            rtnString += this.printHtml(this.DateFrom);
         }
        return rtnString;
    }

    public void setSearchListPrpts() {
        this.FlowKey.setListWidth("20%");

        this.Names.setListWidth("35%");

        this.DateFrom.setListWidth("20%");

        this.DateTo.setListWidth("20%");

        this.CanQueryFlag.setListWidth("10%");

        Field[] showField = {this.FlowKey, this.Names, this.DateFrom, this.DateTo, this.CanQueryFlag};
        this.setShowField(showField);
        this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
    }

    public List<Object[]> getSearchList() throws Exception {
        String whereStr = Cnstnts.EMPTY_STRING;
        whereStr = Util.addWhereSQL(whereStr, this.Names);
        whereStr = Util.addWhereSQL(whereStr, this.DateFrom);
        whereStr = Util.addWhereSQL(whereStr, this.DateTo);
        return this.doSearch(whereStr);
    }

    public Properties getNamesPrpts() throws Exception {
        return super.getNamesPrpts(this.Names);
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            AccountingYear preObj = (AccountingYear) userInfo.getObj(this.getTableName());
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
    
    public List<SelectItem> getCanSelectList() throws Exception {
    	String SQL="select * from AccountingYear where '"+Util.getDate()+
    				"' between DateFrom and DateTo";
  	  	return this.getDbUtil().getSelectItemList(SQL, this.Names);
    }
    
    public String getFirstCanSelectList() throws Exception {
    	String rtnString = Cnstnts.EMPTY_STRING;
    	String SQL="select * from AccountingYear where '"+Util.getDate()+
    				"' between DateFrom and DateTo";
    	List<SelectItem> itemLst = this.getDbUtil().getSelectItemList(SQL, this.Names);
    	if(itemLst.size()>0){
    		SelectItem item = itemLst.get(0);
    		rtnString = item.getKey();
    	}
  	  	return rtnString;
    }

}