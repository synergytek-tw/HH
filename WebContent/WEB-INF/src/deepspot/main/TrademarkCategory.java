package deepspot.main;

import java.util.Iterator;
import java.util.List;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MultiDetail;

public class TrademarkCategory extends MultiDetail {

    public TrademarkCategory(){this.init();}

    public TrademarkCategory(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field ParentId;
    public void setParentId(String ParentId){this.ParentId.setValue(ParentId);}
    public String getParentId(){return this.ParentId.getValue();}

    public Field NiceClassification;
    public void setNiceClassification(String NiceClassification){this.NiceClassification.setValue(NiceClassification);}
    public String getNiceClassification(){return this.NiceClassification.getValue();}

    public Field GoodsServices;
    public void setGoodsServices(String GoodsServices){this.GoodsServices.setValue(GoodsServices);}
    public String getGoodsServices(){return this.GoodsServices.getValue();}

    public Field GroupCode;
    public void setGroupCode(String GroupCode){this.GroupCode.setValue(GroupCode);}
    public String getGroupCode(){return this.GroupCode.getValue();}
    
    final int FRAME_HEIGHT = 120;

    public void init() {
        super.init();
        this.setProgramId("jsp.TrademarkCategory");
        this.setTableName("TrademarkCategory");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");

        this.NiceClassification = new Field("NiceClassification", this.getTableName());
        this.NiceClassification.setCheckEmpty(true);
        this.NiceClassification.setDbType("varchar(50)");

        this.GoodsServices = new Field("GoodsServices", this.getTableName());
        this.GoodsServices.setCheckEmpty(true);
        this.GoodsServices.setDbType("varchar(50)");

        this.GroupCode = new Field("GroupCode", this.getTableName());
        this.GroupCode.setCheckEmpty(true);
        this.GroupCode.setDbType("nvarchar(200)");

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);
        
        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.ParentId);

        this.DbFields.add(this.NiceClassification);

        this.DbFields.add(this.GoodsServices);

        this.DbFields.add(this.GroupCode);
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();

            this.GoodsServices.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.GoodsServices.setSize(40);
            
            this.NiceClassification.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.NiceClassification.setAnotherField(this.GoodsServices);
            rtnString += this.printHtml(this.NiceClassification);
            
            this.GroupCode.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.GroupCode.setRows(2);
            this.GroupCode.setCols(80);
            rtnString += this.printHtml(this.GroupCode);
        }
        return rtnString;
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            TrademarkCategory preObj = (TrademarkCategory) userInfo.getObj(this.getTableName());
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
		TrademarkCase parentObj = (TrademarkCase)this.getUserInfo().getObj("TrademarkCase");
		if(parentObj.getDbActionMode().equals(Cnstnts.UPDATE)){
			canAssesFlag = true;
		}

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1=Cnstnts.EMPTY_STRING;
		String thText2="<td align='center' width='20%'>"+this.getUserInfo().getMsg("jsp.TrademarkCategory.NiceClassification")+"</td>";
		String thText3="<td align='center' width='20%'>"+this.getUserInfo().getMsg("jsp.TrademarkCategory.GoodsServices")+"</td>";
		String thText4="<td align='center' width='60%'>"+this.getUserInfo().getMsg("jsp.TrademarkCategory.GroupCode")+"</td>";
		String thText5=Cnstnts.EMPTY_STRING;
		if(canAssesFlag){
			String insertImg = Cnstnts.EMPTY_STRING;  
			insertImg = "<img src='img/addanchr.gif' style='cursor: hand' "+
							 "title='"+this.getUserInfo().getMsg("jsp.Flow_detail.addNew")+"' "+
							 "onClick='openTabFrame(getElementById(\"tabText\").value,\"insert\",\""+
							 		  parentObj.getFlowKey()+"\","+this.FRAME_HEIGHT+")'/>";
			thText1 = "<td align='center' width='3%'>"+insertImg+"</td>";
			thText5 = "<td align='center' width='3%'></td>";
		}
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText3+thText4+thText5+"</tr>");
		
		String SQL = "select * from TrademarkCategory where ParentId='"+this.getParentId()+"'";
		this.setDbFields();
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, this.getDbFields());
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		for(Iterator itr=findList.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			String NiceClassification = Cnstnts.EMPTY_STRING;
			String GoodsServices = Cnstnts.EMPTY_STRING;
			String FlowKey = Cnstnts.EMPTY_STRING;
			String GroupCode = Cnstnts.EMPTY_STRING;
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("NiceClassification")){
					NiceClassification = field.getValue();
				}
				if(field.getName().equals("GoodsServices")){
					GoodsServices = field.getValue();
				}
				if(field.getName().equals("FlowKey")){
					FlowKey = field.getValue();
				}
				if(field.getName().equals("GroupCode")){
					GroupCode = field.getValue();
				}
			}
			String tdText1=Cnstnts.EMPTY_STRING;
			String tdText2="<td>"+NiceClassification+"</td>";
			String tdText3="<td>"+GoodsServices+"</td>";
			String tdText4="<td>"+GroupCode+"</td>";
			String tdText5=Cnstnts.EMPTY_STRING;
			if(canAssesFlag){ 
				String insertImg = "<img src='img/edit2.gif' style='cursor: hand' "+
								 		"title='"+this.getUserInfo().getMsg("jsp.Flow.edit")+"' "+
								 		"onClick='openTabFrame(getElementById(\"tabText\").value,\"update\",\""+
								 		FlowKey+"\","+this.FRAME_HEIGHT+")'/>";
				tdText1 = "<td align='center'>"+insertImg+"</td>";
				String deleteImg = "<img src='img/C_Delete_Md_N.png' style='cursor: hand' "+
				 						"title='"+this.getUserInfo().getMsg("jsp.common.delete")+"' "+
				 						"onClick='openTabFrame(getElementById(\"tabText\").value,\"delete\",\""+
				 						FlowKey+"\","+this.FRAME_HEIGHT+")'/>";
				tdText5 = "<td align='center'>"+deleteImg+"</td>";
			}
			printValue = tdText1+tdText2+tdText3+tdText4+tdText5;
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
