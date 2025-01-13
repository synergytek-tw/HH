package deepspot.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MultiDetail;
import deepspot.html.Html;
import deepspot.util.Util;

public class DraftTechExamine extends MultiDetail {

    public DraftTechExamine(){this.init();}

    public DraftTechExamine(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field ParentId;
    public void setParentId(String ParentId){this.ParentId.setValue(ParentId);}
    public String getParentId(){return this.ParentId.getValue();}

    public Field Reviewer;
    public void setReviewer(String Reviewer){this.Reviewer.setValue(Reviewer);}
    public String getReviewer(){return this.Reviewer.getValue();}
    
    public Field ReviewerName;
    public void setReviewerName(String ReviewerName){this.ReviewerName.setValue(ReviewerName);}
    public String getReviewerName(){return this.ReviewerName.getValue();}
    
    public Field Utilzation;
    public void setUtilzation(String Utilzation){this.Utilzation.setValue(Utilzation);}
    public String getUtilzation(){return this.Utilzation.getValue();}
    
    public Field Novelty;
    public void setNovelty(String Novelty){this.Novelty.setValue(Novelty);}
    public String getNovelty(){return this.Novelty.getValue();}
    
    public Field Advance;
    public void setAdvance(String Advance){this.Advance.setValue(Advance);}
    public String getAdvance(){return this.Advance.getValue();}

    public Field Suitable;
    public void setSuitable(String Suitable){this.Suitable.setValue(Suitable);}
    public String getSuitable(){return this.Suitable.getValue();}

    public Field ProvenData1;
    public void setProvenData1(String ProvenData1){this.ProvenData1.setValue(ProvenData1);}
    public String getProvenData1(){return this.ProvenData1.getValue();}
        
    public Field ProvenData2;
    public void setProvenData2(String ProvenData2){this.ProvenData2.setValue(ProvenData2);}
    public String getProvenData2(){return this.ProvenData2.getValue();}
    
    public Field ProvenData3;
    public void setProvenData3(String ProvenData3){this.ProvenData3.setValue(ProvenData3);}
    public String getProvenData3(){return this.ProvenData3.getValue();}
    
    public Field ProvenData4;
    public void setProvenData4(String ProvenData4){this.ProvenData4.setValue(ProvenData4);}
    public String getProvenData4(){return this.ProvenData4.getValue();}
    
    public Field UploadFile;
    public void setUploadFile(String UploadFile){this.UploadFile.setValue(UploadFile);}
    public String getUploadFile(){return this.UploadFile.getValue();}
    
    public Field CreateDate;
    public void setCreateDate(String CreateDate){this.CreateDate.setValue(CreateDate);}
    public String getCreateDate(){return this.CreateDate.getValue();}
    
    public Field NoticeDate;
    public void setNoticeDate(String NoticeDate){this.NoticeDate.setValue(NoticeDate);}
    public String getNoticeDate(){return this.NoticeDate.getValue();}
    
    public Field DeadlineDate;
    public void setDeadlineDate(String DeadlineDate){this.DeadlineDate.setValue(DeadlineDate);}
    public String getDeadlineDate(){return this.DeadlineDate.getValue();}
    
    public Field FinishedDate;
    public void setFinishedDate(String FinishedDate){this.FinishedDate.setValue(FinishedDate);}
    public String getFinishedDate(){return this.FinishedDate.getValue();}
    
    public Field TmpField;
    public void setTmpField(String TmpField){this.TmpField.setValue(TmpField);}
    public String getTmpField(){return this.TmpField.getValue();}
    
    final int FRAME_HEIGHT = 220;

    public void init() {
        super.init();
        this.setProgramId("jsp.DraftTechExamine");
        this.setTableName("DraftTechExamine");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");

        this.Reviewer = new Field("Reviewer",this.getTableName());
        this.Reviewer.setDbType("varchar(50)");
        
        this.ReviewerName = new Field("ReviewerName",this.getTableName());
        this.ReviewerName.setDbType("varchar(50)");
        
        this.Utilzation = new Field("Utilzation", this.getTableName());
        this.Utilzation.setDbType("char(1)");
        this.Utilzation.setCheckEmpty(true);
        
        this.Novelty = new Field("Novelty", this.getTableName());
        this.Novelty.setDbType("char(1)");
        this.Novelty.setCheckEmpty(true);
        
        this.Advance = new Field("Advance", this.getTableName());
        this.Advance.setDbType("char(1)");
        this.Advance.setCheckEmpty(true);

        this.Suitable = new Field("Suitable", this.getTableName());
        this.Suitable.setDbType("char(1)");
        this.Suitable.setCheckEmpty(true);

        this.ProvenData1 = new Field("ProvenData1",this.getTableName());
        this.ProvenData1.setDbType("char(1)");
        this.ProvenData1.setCheckEmpty(true);
        
        this.ProvenData2 = new Field("ProvenData2", this.getTableName());
        this.ProvenData2.setDbType("char(1)");
        this.ProvenData2.setCheckEmpty(true);
        
        this.ProvenData3 = new Field("ProvenData3", this.getTableName());
        this.ProvenData3.setDbType("char(1)");
        this.ProvenData3.setCheckEmpty(true);

        this.ProvenData4 = new Field("ProvenData4", this.getTableName());
        this.ProvenData4.setDbType("char(1)");
        this.ProvenData4.setCheckEmpty(true);
        
        this.UploadFile = new Field("UploadFile", this.getTableName());
        this.UploadFile.setDbType("nvarchar(50)");

        this.CreateDate = new Field("CreateDate", this.getTableName());
        this.CreateDate.setDbType("nvarchar(10)");
        
        this.NoticeDate = new Field("NoticeDate", this.getTableName());
        this.NoticeDate.setDbType("nvarchar(10)");
        
        this.DeadlineDate = new Field("DeadlineDate", this.getTableName());
        this.DeadlineDate.setDbType("nvarchar(10)");
        
        this.FinishedDate = new Field("FinishedDate", this.getTableName());
        this.FinishedDate.setDbType("nvarchar(10)");
        
        this.TmpField = new Field("TmpField", this.getTableName());
        
        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);
        
        this.setSearchListPrpts();
    }

    public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.ParentId);
        this.DbFields.add(this.Reviewer);
        this.DbFields.add(this.ReviewerName);
        this.DbFields.add(this.Utilzation);
        this.DbFields.add(this.Novelty);
        this.DbFields.add(this.Advance);
        this.DbFields.add(this.Suitable);
        this.DbFields.add(this.ProvenData1);
        this.DbFields.add(this.ProvenData2);
        this.DbFields.add(this.ProvenData3);
        this.DbFields.add(this.ProvenData4);
        this.DbFields.add(this.UploadFile);
        this.DbFields.add(this.CreateDate);
        this.DbFields.add(this.NoticeDate);
        this.DbFields.add(this.DeadlineDate);
        this.DbFields.add(this.FinishedDate);
    }

    @SuppressWarnings("unchecked")
	public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	rtnString += this.ParentId.printHiddenTag();
        	rtnString += this.Reviewer.printHiddenTag();
        	rtnString += this.TmpField.printHiddenTag();
        	
        	Draft parentObj = new Draft(this.getParentId());
        	
        	parentObj.Title.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
        	parentObj.Title.setReadonly(true);
        	parentObj.Title.setCheckEmpty(false);
        	parentObj.Title.setRows(2);
        	parentObj.Title.setCols(62);
        	rtnString += this.printHtml(parentObj.Title);
        	
        	parentObj.ApplicantName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	parentObj.ApplicantName.setReadonly(true);
        	rtnString += this.printHtml(parentObj.ApplicantName);
        	/*
        	parentObj.PatentType.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	parentObj.PatentType.setReadonly(true);
        	parentObj.PatentType.setCheckEmpty(false);
        	parentObj.setPatentType(new Category(parentObj.getPatentType()).getNames());
        	parentObj.PatentType.setAnotherField(parentObj.ApplicantName);
        	rtnString += this.printHtml(parentObj.PatentType);
        	*/
        	String BtnHtml = "<input type='button' " +
        				"value='"+this.getUserInfo().getMsg("jsp.DraftTechExamine.LinkParentPage")+"' " +
        				"onClick='openAppendix(\"Draft.jsp?_flowKey="+parentObj.getFlowKey()+
        				"&_getDataFlag=true&_dbActionMode=query&_pageActionMode=maintain" +
        				"&_modeLockFlag=true\",\"Draft\",900,800)'/>";
        	if(parentObj.getPreCaseDocument().trim().length()>0){
        		BtnHtml += "<input type='button' " +
        				"value='"+this.getUserInfo().getMsg("jsp.Draft.PreCaseIndex")+"' " +
        				"onClick='openAppendix(\""+parentObj.getPreCaseDocument()+"\"," +
						"\"openAppendix\",800,600)'/>";
        	}
        	/*
        	BtnHtml += "<input type='button' " +
						"value='"+this.getUserInfo().getMsg("jsp.DraftTechExamine.openContract")+"' " +
						"onClick='openAppendix(\"Document/Draft/system/contract.pdf\"," +
						"\"openAppendix\",800,600)'/>";
			*/
        	this.ReviewerName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.ReviewerName.setReadonly(true);
        	this.ReviewerName.setAfterText(BtnHtml);
        	rtnString += this.printHtml(this.ReviewerName);
        	
        	rtnString +="</table>"; 
        	
        	String tableBeginTag = "<table"+Cnstnts.DEFAULT_TABLE_BGCOLOR+" border=0 cellspacing=2 cellpadding=2 width=100%>";
        	String trBeginTag = "<tr"+Cnstnts.DEFAULT_TR_BGCOLOR_1+">";
        	
        	rtnString +="<br><fieldset><legend>"+this.getUserInfo().getMsg("jsp.DraftTechExamine.Block1.Legend")+"</legend>";
            rtnString +="<div class='indent'>";
            rtnString +=tableBeginTag;
            
            String checkEmpty = Cnstnts.EMPTY_STRING;
            if(this.getDbActionMode().equals(Cnstnts.UPDATE) 
            		&& this.getFinishedDate().trim().length()==0){
            	checkEmpty = "<font color='red'>"+this.getUserInfo().getMsg("jsp.common.Require")+"*</font>";
            }
            
            this.Novelty.setHtmlType(Cnstnts.HTML_TAG_RADIO);
        	rtnString += trBeginTag+"<td align='right' width='40%'>"+checkEmpty+
        				 this.getUserInfo().getMsg("jsp.DraftTechExamine.Novelty")+"</td>" +
        				 "<td>"+Html.printTag(this.Novelty, this.getUserInfo())+"</td></tr>"; 
        	
            this.Utilzation.setHtmlType(Cnstnts.HTML_TAG_RADIO);
            rtnString += trBeginTag+"<td align='right'>"+checkEmpty+
            			 this.getUserInfo().getMsg("jsp.DraftTechExamine.Utilzation")+"</td>" +
            			 "<td >"+Html.printTag(this.Utilzation, this.getUserInfo())+"</td></tr>"; 
    		
            this.Advance.setHtmlType(Cnstnts.HTML_TAG_RADIO);
            rtnString += trBeginTag+"<td align='right'>"+checkEmpty+
            			 this.getUserInfo().getMsg("jsp.DraftTechExamine.Advance")+"</td>" +
            			 "<td>"+Html.printTag(this.Advance, this.getUserInfo())+"</td></tr>"; 
            
            this.Suitable.setHtmlType(Cnstnts.HTML_TAG_RADIO);
            rtnString += trBeginTag+"<td align='right'>"+checkEmpty+
            			 this.getUserInfo().getMsg("jsp.DraftTechExamine.Suitable")+"</td>" +
            			 "<td>"+Html.printTag(this.Suitable, this.getUserInfo())+"</td></tr>"; 
            
            this.ProvenData1.setHtmlType(Cnstnts.HTML_TAG_RADIO);
            rtnString += trBeginTag+"<td align='right'>"+checkEmpty+
			 			 this.getUserInfo().getMsg("jsp.DraftTechExamine.ProvenData1")+"</td>" +
			 			 "<td>"+Html.printTag(this.ProvenData1, this.getUserInfo())+"</td></tr>";
            
            this.ProvenData2.setHtmlType(Cnstnts.HTML_TAG_RADIO);
            rtnString += trBeginTag+"<td align='right'>"+checkEmpty+
			 			 this.getUserInfo().getMsg("jsp.DraftTechExamine.ProvenData2")+"</td>" +
			 			 "<td>"+Html.printTag(this.ProvenData2, this.getUserInfo())+"</td></tr>";
            
            this.ProvenData3.setHtmlType(Cnstnts.HTML_TAG_RADIO);
            rtnString += trBeginTag+"<td align='right'>"+checkEmpty+
			 			 this.getUserInfo().getMsg("jsp.DraftTechExamine.ProvenData3")+"</td>" +
			 			 "<td>"+Html.printTag(this.ProvenData3, this.getUserInfo())+"</td></tr>";
            
            this.ProvenData4.setHtmlType(Cnstnts.HTML_TAG_RADIO);
            rtnString += trBeginTag+"<td align='right'>"+checkEmpty+
			 			 this.getUserInfo().getMsg("jsp.DraftTechExamine.ProvenData4")+"</td>" +
			 			 "<td>"+Html.printTag(this.ProvenData4, this.getUserInfo())+"</td></tr>";
            
            this.UploadFile.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
            rtnString += this.printHtml(this.UploadFile);
            
            rtnString +="</table>"; 
            rtnString +="</div>";
            rtnString +="</fieldset>"; 
            
            /*
            rtnString +="<br><fieldset><legend>"+this.getUserInfo().getMsg("jsp.DraftTechExamine.Block2.Legend")+"</legend>";
            rtnString +="<div class='indent'>";
            rtnString +=tableBeginTag;
            
            this.ProvenData1.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            this.ProvenData1.setCanEdit(true);
            rtnString += trBeginTag+"<td align='right' width='10%'>"+
            			 Html.printTag(this.ProvenData1, this.getUserInfo())+"</td>" +
            			 "<td width='40%'>"+this.getUserInfo().getMsg("jsp.DraftTechExamine.ProvenData1")+"</td>"; 
            
            this.ProvenData2.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            this.ProvenData2.setCanEdit(true);
            rtnString += "<td align='right' width='10%'>"+Html.printTag(this.ProvenData2, this.getUserInfo())+"</td>" +
            			 "<td width='40%'>"+this.getUserInfo().getMsg("jsp.DraftTechExamine.ProvenData2")+"</td></td>"; 
            
            this.ProvenData3.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            this.ProvenData3.setCanEdit(true);
            rtnString += trBeginTag+"<td align='right'>"+
            			 Html.printTag(this.ProvenData3, this.getUserInfo())+"</td>" +
            			 "<td>"+this.getUserInfo().getMsg("jsp.DraftTechExamine.ProvenData3")+"</td>"; 
            
            this.ProvenData4.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            this.ProvenData4.setCanEdit(true);
            rtnString += "<td align='right'>"+Html.printTag(this.ProvenData4, this.getUserInfo())+"</td>" +
							"<td>"+this.getUserInfo().getMsg("jsp.DraftTechExamine.ProvenData4")+"</td></td>"; 
            
            this.UploadFile.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD);
            rtnString += this.printHtml(this.UploadFile);
            
            rtnString +="</table>"; 
            rtnString +="</div>";
            rtnString +="</fieldset>"; 
            */
            
            rtnString +="<br><fieldset><legend>"+this.getUserInfo().getMsg("jsp.DraftTechExamine.Block3.Legend")+"</legend>";
            rtnString +="<div class='indent'>";
            rtnString +=tableBeginTag;
            
            String SQL = "select * from DraftTechExamineOffice where ParentId='"+this.getFlowKey()+"'";
            DraftTechExamineOffice obj = new DraftTechExamineOffice();
            obj.setPageActionMode(Cnstnts.MAINTAIN);
            obj.OfficeName.setAliasName(this.getUserInfo().getMsg("jsp.DraftTechExamineOffice.OfficeName"));
			obj.OfficeName.setReadonly(true);
			obj.Result.setAliasName(this.getUserInfo().getMsg("jsp.DraftTechExamineOffice.Result"));
			obj.Command.setAliasName(this.getUserInfo().getMsg("jsp.DraftTechExamineOffice.Command"));
			obj.UploadFile.setAliasName(this.getUserInfo().getMsg("jsp.DraftTechExamineOffice.UploadFile"));
            obj.setDbFields();
    		List<List<Field>> findList = obj.getDbUtil().getFieldsList(SQL, obj.getDbFields());
    		int i=0;
    		for(Iterator itr=findList.iterator();itr.hasNext();){
    			i++;
    			List<Field> dataFields = (List<Field>)itr.next();
    			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
    				Field field = (Field)fieldsItr.next();
    				if(field.getName().equals("FlowKey")){
    					obj.FlowKey.setValue(field.getValue());
    				}
    				if(field.getName().equals("OfficeName")){
    					obj.OfficeName.setValue(field.getValue());
    					obj.OfficeName.setName("OfficeName"+i);
    				}
    				if(field.getName().equals("Result")){
    					obj.Result.setValue(field.getValue());
    					obj.Result.setName("Result"+i);
    				}
    				if(field.getName().equals("Command")){
    					obj.Command.setValue(field.getValue());
    					obj.Command.setName("Command"+i);
    				}
    				if(field.getName().equals("UploadFile")){
    					obj.UploadFile.setValue(field.getValue());
    					obj.UploadFile.setName("UploadFile"+i);
    				}
    			}
    			obj.Result.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
    			obj.Result.setSelectList(new Category().getChildList("TechExamineOfficeResult"));
    			obj.Result.setOnChange("doAjaxRequest(\"DraftTechExamineOffice\",\"result"+i+"\",\"Result&"+obj.getFlowKey()+"\",\"tmpField\",\"Value\")");
    	    	obj.Result.setCheckEmpty(true);
    	    	rtnString += this.printHtml(obj.Result);
    			/*
    			obj.OfficeName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
    			obj.OfficeName.setAnotherField(obj.Result);
    			rtnString += this.printHtml(obj.OfficeName);
    	        */
    	    	obj.Command.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
    	    	obj.Command.setCols(60);
    	    	obj.Command.setOnChange("doAjaxPost(\"DraftTechExamineOffice\",\"command"+i+"\",\"Command&"+obj.getFlowKey()+"\",\"tmpField\",\"Value\")");
    	    	obj.Command.setCheckEmpty(true);
    	    	rtnString += this.printHtml(obj.Command);
    	        
    	        obj.UploadFile.setHtmlType(Cnstnts.HTML_TAG_OPEN_UPLOAD2);
    	        obj.UploadFile.setOnClick("document.input.tmpField.value=\""+obj.getFlowKey()+"\";");
    			rtnString += this.printHtml(obj.UploadFile);
    		}
            
            rtnString +="</table>"; 
            rtnString +="</div>";
            rtnString +="</fieldset>"; 
        }
        return rtnString;
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            DraftTechExamine preObj = (DraftTechExamine) userInfo.getObj(this.getTableName());
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
		this.setUserInfo(userInfo);
		this.ParentId.setValue(parentId);
		return this.printSearchReasult();
    }
    
    @SuppressWarnings("unchecked")
	public String printSearchReasult() throws Exception {
		StringBuffer strBfr = new StringBuffer();
		
		Draft parentObj = (Draft)this.getUserInfo().getObj("Draft");
		
		boolean inG01Group = false;
    	if(new Groups().inGorup("G01", this.getUserInfo().getAttribute("emp_id"))){
    		inG01Group = true;
    	}

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText0="<td align='center' width='8%'>"+this.getUserInfo().getMsg("jsp.DraftTechExamine.ReviewerName")+"</td>";
		String thText1="<td align='center' width='6%'>"+this.getUserInfo().getMsg("jsp.DraftTechExamine.Utilzation")+"</td>";
		String thText2="<td align='center' width='6%'>"+this.getUserInfo().getMsg("jsp.DraftTechExamine.Novelty")+"</td>";
		String thText3="<td align='center' width='6%'>"+this.getUserInfo().getMsg("jsp.DraftTechExamine.Advance")+"</td>";
		String thText4="<td align='center' width='6%'>"+this.getUserInfo().getMsg("jsp.DraftTechExamine.Suitable")+"</td>";
		String thText5="<td align='center' width='6%'>"+this.getUserInfo().getMsg("jsp.DraftTechExamine.ProvenData1")+"</td>";
		String thText6="<td align='center' width='6%'>"+this.getUserInfo().getMsg("jsp.DraftTechExamine.ProvenData2")+"</td>";
		String thText7="<td align='center' width='6%'>"+this.getUserInfo().getMsg("jsp.DraftTechExamine.ProvenData3")+"</td>";
		String thText8="<td align='center' width='6%'>"+this.getUserInfo().getMsg("jsp.DraftTechExamine.ProvenData4")+"</td>";
		String thText9="<td align='center' width='8%'>"+this.getUserInfo().getMsg("jsp.DraftTechExamine.UploadFile")+"</td>";
		String thText10="<td align='center' width='28%'>"+this.getUserInfo().getMsg("jsp.DraftTechExamineOffice.Result")+"</td>";
		String thText11="<td align='center' width='8%'>"+this.getUserInfo().getMsg("jsp.DraftTechExamine.FinishedDate")+"</td>";
		
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText0+thText1+thText2+thText3+thText4+
				thText5+thText6+thText7+thText8+thText9+thText10+thText11+"</tr>");
		
		String SQL = "select * from DraftTechExamine where ParentId='"+this.getParentId()+"'";
		this.setDbFields();
		List<Field> fieldList = this.getDbFields();
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldList);
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		for(Iterator itr=findList.iterator();itr.hasNext();){
			i++;
			List<Field> dataFields = (List<Field>)itr.next();
			DraftTechExamine obj = new DraftTechExamine();
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("FlowKey")){
					obj.FlowKey.setValue(field.getValue());
				}
				if(field.getName().equals("ReviewerName")){
					obj.ReviewerName.setValue(field.getValue());
				}
				if(field.getName().equals("Utilzation")){
					obj.Utilzation.setValue(Util.getTickImg(field.getValue()));
				}
				if(field.getName().equals("Novelty")){
					obj.Novelty.setValue(Util.getTickImg(field.getValue()));
				}
				if(field.getName().equals("Advance")){
					obj.Advance.setValue(Util.getTickImg(field.getValue()));
				}
				if(field.getName().equals("Suitable")){
					obj.Suitable.setValue(Util.getTickImg(field.getValue()));
				}
				if(field.getName().equals("ProvenData1")){
					obj.ProvenData1.setValue(Util.getTickImg(field.getValue()));
				}
				if(field.getName().equals("ProvenData2")){
					obj.ProvenData2.setValue(Util.getTickImg(field.getValue()));
				}
				if(field.getName().equals("ProvenData3")){
					obj.ProvenData3.setValue(Util.getTickImg(field.getValue()));
				}
				if(field.getName().equals("ProvenData4")){
					obj.ProvenData4.setValue(Util.getTickImg(field.getValue()));
				}
				if(field.getName().equals("UploadFile")){
					obj.UploadFile.setValue(Util.getOpenAppendixBtn(this.getUserInfo(),field.getValue()));
				}
				if(field.getName().equals("FinishedDate")){
					obj.FinishedDate.setValue(field.getValue());
				}
			}
			
			String onClick = Cnstnts.EMPTY_STRING;
			String reviewerName = "XXXX";
			if(inG01Group){
				reviewerName = obj.ReviewerName.getValue();
				onClick = " style='cursor: hand' onClick='openAppendix(\"" +
						   "DraftTechExamine.jsp?_flowKey="+obj.getFlowKey()+
						   "&_getDataFlag=true&_pageActionMode=maintain" +
						   "&_dbActionMode=query\",\"DraftTechExamine\",800,600)'";
			}
			String tdText0="<td align='center'"+onClick+">"+reviewerName+"</td>";
			String tdText1="<td align='center'>"+obj.Utilzation.getValue()+"</td>";
			String tdText2="<td align='center'>"+obj.Novelty.getValue()+"</td>";
			String tdText3="<td align='center'>"+obj.Advance.getValue()+"</td>";
			String tdText4="<td align='center'>"+obj.Suitable.getValue()+"</td>";
			String tdText5="<td align='center'>"+obj.ProvenData1.getValue()+"</td>";
			String tdText6="<td align='center'>"+obj.ProvenData2.getValue()+"</td>";
			String tdText7="<td align='center'>"+obj.ProvenData3.getValue()+"</td>";
			String tdText8="<td align='center'>"+obj.ProvenData4.getValue()+"</td>";
			String tdText9="<td align='center'>"+obj.UploadFile.getValue()+"</td>";
			String tdText10="<td align='center'>"+obj.getOfficeResult(parentObj.getUserInfo())+"</td>";
			String tdText11="<td align='center'>"+obj.FinishedDate.getValue()+"</td>";
			
			printValue = tdText0+tdText1+tdText2+tdText3+tdText4+tdText5+
						 tdText6+tdText7+tdText8+tdText9+tdText10+tdText11;
			if(i%2==0){
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
			} else {
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
			}
			
			strBfr.append(newLine + "<tr "+bgColor+">"+printValue+"</tr>");
		}
		strBfr.append(newLine + "</table>");
		
		if((parentObj.getStatus().equals("DS03") 
				|| parentObj.getStatus().equals("DS05")) && inG01Group){
			int ExamineCount = findList.size();
			SQL = "select count(*) as CountNum from DraftTechExamine " +
		      	  "where ParentId='"+parentObj.getFlowKey()+"' and FinishedDate!=''";
			Field CountNum = new Field("CountNum"); 
			int finishedCount = Integer.parseInt(this.getDbUtil().getFieldValue(SQL,CountNum));
			
			if(finishedCount==ExamineCount){
				/*
				String CreateReExamineBtn = "<input type='button' " +
						"value='"+this.getUserInfo().getMsg("jsp.DraftTechExamine.CreateReExamine")+"' "+
						"onClick='this.disabled=true;doAjaxRequest(\"Draft\",\"flowKey\",\"CreateReExamine\"," +
						"\"DraftReExamineDiv\",\"innerHTML\")'/>";
				strBfr.append(newLine + CreateReExamineBtn);
				*/
				String ApproveBtn = "<input type='button' " +
				"value='"+this.getUserInfo().getMsg("jsp.DraftReExamine.Approve")+"' "+
						"onClick='this.disabled=true;" +
						"document.input.status.value=\"DS06\";" +
						"document.input.dbActionMode.value=\"update\";" +
						"document.input.submitFlag.value=\"true\";setValue()'/>";
				strBfr.append(newLine + ApproveBtn);
				
				if(parentObj.getStatus().equals("DS03")){
					String ApplyLaterBtn = "<input type='button' " +
						"value='"+this.getUserInfo().getMsg("jsp.DraftTechExamine.ApplyLater")+"' "+
						"onClick='this.disabled=true;" +
						"document.input.status.value=\"DS05\";" +
						"document.input.dbActionMode.value=\"update\";" +
						"document.input.submitFlag.value=\"true\";setValue()'/>";
					strBfr.append(newLine + ApplyLaterBtn);
				}
				
				String RejectBtn = "<input type='button' " +
						"value='"+this.getUserInfo().getMsg("jsp.DraftReExamine.Reject")+"' "+
						"onClick='this.disabled=true;" +
						"document.input.status.value=\"DS07\";" +
						"document.input.dbActionMode.value=\"update\";" +
						"document.input.submitFlag.value=\"true\";setValue()'/>";
				strBfr.append(newLine + RejectBtn);
				
				String BackToEditBtn = "<div><input type='button' " +
						"value='"+this.getUserInfo().getMsg("jsp.DraftTechExamine.BackToEdit")+"' "+
						"onClick='this.disabled=true;" +
						"document.input.status.value=\"DS04\";" +
						"document.input.dbActionMode.value=\"update\";" +
						"document.input.submitFlag.value=\"true\";setValue()'/>"+
						this.getUserInfo().getMsg("jsp.Draft.LogMemo")+
						"<textarea rows='2' cols='60' id='logMemo' name='logMemo'></textarea></div>";
				strBfr.append(newLine + BackToEditBtn);
			}
		}
		return strBfr.toString();
	}
    
    @SuppressWarnings("unchecked")
	private String getOfficeResult(UserBean userInfo) throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		
		Properties ExamineResultPrpt = new Category().getNamesPrpts();
		
    	String SQL = "select * from DraftTechExamineOffice where ParentId='"+this.getFlowKey()+"'";
    	DraftTechExamineOffice obj = new DraftTechExamineOffice();
    	obj.setDbFields();
		List<List<Field>> findList = obj.getDbUtil().getFieldsList(SQL, obj.getDbFields());
		if(findList.size()==0){
			return rtnString;
		}
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		for(Iterator itr=findList.iterator();itr.hasNext();){
			i++;
			List<Field> dataFields = (List<Field>)itr.next();
			obj = new DraftTechExamineOffice();
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("OfficeName")){
					obj.OfficeName.setValue(field.getValue());
				}
				if(field.getName().equals("Result")){
					obj.Result.setValue(ExamineResultPrpt.getProperty(field.getValue()));
				}
				if(field.getName().equals("Command")){
					obj.Command.setValue(field.getValue());
				}
				if(field.getName().equals("UploadFile")){
					obj.UploadFile.setValue(Util.getOpenAppendixBtn(userInfo, field.getValue()));
				}
			}
			if(i%2==0){
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
			} else {
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
			}
			rtnString += "<tr "+bgColor+">" +
						 //"<td width='25%' align='center'>"+obj.getOfficeName()+"</td>" +
						 "<td width='80%' align='center'>"+obj.getResult()+"&nbsp;</td>" +
						 "<td align='center'>"+obj.getUploadFile()+"</td></tr>";
			//rtnString += "<tr "+bgColor+"><td colspan='2'>"+obj.getCommand()+"</td></tr>";
		}
		return "<table width='100%' " + this.getTableBgcolor() + ">"+rtnString+"</table>";
	}

	public boolean checkInsertError() throws Exception {
        if(super.checkInsertError()){
            return true;
        } else {
            return false;
        }
    }

	public boolean checkUpdateError() throws Exception {
    	if(this.checkInsertError()){
            return true;
        } else {
        	if(this.checkOfficeEmpty()){
        		this.setErrorMessage(this.getUserInfo().getMsg("jsp.DraftTechExamine.officeEmpty"));
        		return true;
        	}
        	this.setFinishedDate(Util.getDate());
            return false;
        }
    }

    private boolean checkOfficeEmpty() {
		String SQL = "select count(*) as RecordNum from DraftTechExamineOffice " +
					 "where ParentId='"+this.getFlowKey()+"' and (Result='' or Command='')";
		int recordNum = Integer.parseInt(this.getDbUtil().getFieldValue(SQL, new Field("RecordNum")));
		if(recordNum>0){
			return true;
		} else {
			return false;
		}
	}

    public boolean checkDeleteError() throws Exception {
        if(super.checkDeleteError()){
            return true;
        } else {
            return false;
        }
    }
    
    public boolean dbExecute() throws Exception {
		this.resetError();
		if (this.getUserInfo() == null) {
			this.setErrorMessage("no userInfo object");
			return false;
		}
		if (this.checkHasError()) {
			return false;
		} else {
			if (this.getApplicant().trim().length() == 0) {
				this.setApplicant(this.getUserInfo().getAttribute("emp_id"));
			}
			if (this.getCreateDept().trim().length() == 0) {
				this.setCreateDept(this.getUserInfo().getAttribute("dept_id"));
			}
			if (Cnstnts.INSERT.equals(this.getDbActionMode())) {
				if (this.insert()) {
					this.doOtherInsertProcess();
					this.setMessage(this.getUserInfo().getMsg("jsp.chkData.insert"));
				} else {
					this.setErrorMessage(this.getTableName() + ".insert() error!!");
					return false;
				}
			} else if (Cnstnts.UPDATE.equals(this.getDbActionMode())) {
				if (this.update()) {
					this.doOtherUpdateProcess();
					this.setMessage(this.getUserInfo().getMsg("jsp.DraftTechExamine.update.message"));
					this.setForwardPage("menu.jsp?resetMenuInfo=true");
				} else {
					this.setErrorMessage(this.getTableName() + ".update() error!!");
					return false;
				}
			} else if (Cnstnts.DELETE.equals(this.getDbActionMode())) {
				if (this.delete()) {
					this.doOtherDeleteProcess();
					this.clearAttribute();
					this.setMessage(this.getUserInfo().getMsg("jsp.chkData.delete"));
				} else {
					this.setErrorMessage(this.getTableName() + ".delete() error!!");
					return false;
				}
			}
			return true;
		}
	}
    
    public String printFunctionBar() throws Exception {
		char newLine = Cnstnts.NEW_LINE;
		StringBuffer strBfr = new StringBuffer();
		strBfr.append(newLine + "<table id='functionBar' " + this.getTableBgcolor() + ">");
		strBfr.append(newLine + "<tr>");
		strBfr.append(newLine + "<td width='60%'>");
		strBfr.append(newLine + "<div class='logTitle'>");
		strBfr.append(newLine + this.getPageTitle());
		strBfr.append(newLine + "</div>");
		strBfr.append(newLine + "</td>");
		strBfr.append(newLine + "<td align='right'>");
		if(!this.getDbActionMode().equals(Cnstnts.QUERY) 
				&& this.getFinishedDate().trim().length()==0){	
			strBfr.append(Html.getSubmitBtn(this.getDbActionMode(), 
					this.getUserInfo().getMsg("jsp.DraftTechExamine.submitBtn")));
		}
		strBfr.append(this.getDbActionSelectItem());
		strBfr.append(newLine + "</td>");
		strBfr.append(newLine + "</tr>");
		strBfr.append(newLine + "</table>");
		return strBfr.toString();
	}
    
    protected String getAjaxReasult(UserBean userInfo,String parentId) throws Exception {
		this.setUserInfo(userInfo);
		this.ParentId.setValue(parentId);
		return this.printAjaxReasult();
    }
    
    public String printAjaxReasult() throws Exception {
    	return this.printSearchReasult();
	}
    
    public List<List<Field>> getPersonalList(String empId, UserBean userInfo) throws Exception{
    	String SQL = "select 'DraftTechExamine' as LinkPage1, t.FlowKey as LinkFlowKey1, "+
    						"d.DeptName, d.ApplicantName, d.Title, "+
    						"'Draft' as LinkPage2, d.Flowkey as LinkFlowKey2 "+
    				 "from DraftTechExamine t "+
    				 "inner join Draft d on t.ParentId=d.FlowKey "+
    				 //"inner join Category c on d.PatentType=c.FlowKey "+
    				 "where t.Reviewer='"+empId+"' and FinishedDate=''";
    	List<Field> dataFields = new ArrayList<Field>();
    	
    	Field LinkPage1 = new Field("LinkPage1",this.getTableName());
    	LinkPage1.setShowFlag(false);
    	dataFields.add(LinkPage1);
    	
    	Field LinkFlowKey1 = new Field("LinkFlowKey1",this.getTableName());
    	LinkFlowKey1.setAliasName(userInfo.getMsg("jsp.DraftTechExamine.FlowKey"));
    	LinkFlowKey1.setLinkFlag1(true);
    	LinkFlowKey1.setLinkMode1(Cnstnts.HREF);
    	LinkFlowKey1.setLinkParameter1("&linkMode=href");
    	LinkFlowKey1.setDbActionMode1(Cnstnts.UPDATE);
    	dataFields.add(LinkFlowKey1);
    	
    	Field LinkPage2 = new Field("LinkPage2",this.getTableName());
    	LinkPage2.setShowFlag(false);
    	dataFields.add(LinkPage2);
    	
    	Field LinkFlowKey2 = new Field("LinkFlowKey2",this.getTableName());
    	LinkFlowKey2.setShowFlag(false);
    	dataFields.add(LinkFlowKey2);
    	
    	Field DeptName = new Field("DeptName","Draft");
    	DeptName.setAlign(Cnstnts.CENTER);
    	//PatentOffice.setListWidth("10%");
    	dataFields.add(DeptName);
    	
    	Field ApplicantName = new Field("ApplicantName","Draft");
    	ApplicantName.setAlign(Cnstnts.CENTER);
    	//PatentOffice.setListWidth("10%");
    	dataFields.add(ApplicantName);
    	/*
    	Field PatentType = new Field("PatentType","Draft");
    	PatentType.setAlign(Cnstnts.CENTER);
    	//PatentOffice.setListWidth("10%");
    	dataFields.add(PatentType);
    	*/
    	Field Title = new Field("Title","Draft");
    	//PatentOffice.setListWidth("10%");
    	dataFields.add(Title);
    	
    	return this.getDbUtil().getFieldsList(SQL, dataFields);
    }
    
}