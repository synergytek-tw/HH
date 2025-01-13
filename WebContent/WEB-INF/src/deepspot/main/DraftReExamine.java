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

public class DraftReExamine extends MultiDetail {

    public DraftReExamine(){this.init();}

    public DraftReExamine(String FlowKey) {
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
        this.setProgramId("jsp.DraftReExamine");
        this.setTableName("DraftReExamine");

        this.ParentId = new Field("ParentId", this.getTableName());
        this.ParentId.setDbType("varchar(50)");

        this.Reviewer = new Field("Reviewer",this.getTableName());
        this.Reviewer.setDbType("varchar(50)");
        
        this.ReviewerName = new Field("ReviewerName",this.getTableName());
        this.ReviewerName.setDbType("varchar(50)");

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
        	parentObj.ApplicantName.setSize(15);
        	parentObj.ApplicantName.setReadonly(true);
        	
        	parentObj.PatentType.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	parentObj.PatentType.setSize(15);
        	parentObj.PatentType.setReadonly(true);
        	parentObj.PatentType.setCheckEmpty(false);
        	parentObj.setPatentType(new Category(parentObj.getPatentType()).getNames());
        	parentObj.PatentType.setAnotherField(parentObj.ApplicantName);
        	rtnString += this.printHtml(parentObj.PatentType);
        	
        	this.ReviewerName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.ReviewerName.setReadonly(true);
        	rtnString += this.printHtml(this.ReviewerName);
        	
        	String tableBeginTag = "<table"+Cnstnts.DEFAULT_TABLE_BGCOLOR+" " +
									"border=0 cellspacing=2 cellpadding=2 width=100%>";
        	String trBeginTag = "<tr"+Cnstnts.DEFAULT_TR_BGCOLOR_1+">";
        	
        	int inventorNum = Integer.parseInt(parentObj.getInventorNum());
        	
        	String parentLinkBtn = "<input type='button' " +
        			"value='"+this.getUserInfo().getMsg("jsp.DraftTechExamine.LinkParentPage")+"' " +
        			"onClick='openAppendix(\"Draft.jsp?_flowKey="+parentObj.getFlowKey()+
        									"&_getDataFlag=true&_dbActionMode=query&_pageActionMode=maintain" +
        									"&_modeLockFlag=true\",\"Draft\",900,800)'/>";
        	if(parentObj.getPreCaseDocument().trim().length()>0){
        		parentLinkBtn += this.getUserInfo().getMsg("jsp.DraftReExamine.Text051")+
        			"<input type='button' " +
        			"value='"+this.getUserInfo().getMsg("jsp.Draft.PreCaseIndex")+"' " +
        			"onClick='openAppendix(\""+parentObj.getPreCaseDocument()+"\"," +
        			"\"openAppendix\",800,600)'/>";;
        	}
        	rtnString += trBeginTag+"<td colspan='4'>"+tableBeginTag;
        	rtnString += trBeginTag+"<td><h4>"+this.getUserInfo().getMsg("jsp.DraftReExamine.Text01")+"<br><br>"+
        				this.getUserInfo().getMsg("jsp.DraftReExamine.Text02")+"<br><br>"+
        				this.getUserInfo().getMsg("jsp.DraftReExamine.Text03")+parentObj.getApplicantName()+
        				this.getUserInfo().getMsg("jsp.DraftReExamine.Text04")+inventorNum+
        				this.getUserInfo().getMsg("jsp.DraftReExamine.Text05")+parentLinkBtn+
        				this.getUserInfo().getMsg("jsp.DraftReExamine.Text06")+"<br><br>";
        	
        	String costText = Cnstnts.EMPTY_STRING;
        	if(parentObj.getProjectFlag().equals("Y")){
        		rtnString += this.getUserInfo().getMsg("jsp.DraftReExamine.Text07")+parentObj.getProjectNo()+
        					 this.getUserInfo().getMsg("jsp.DraftReExamine.Text071");
        	} else {
        		costText = this.getUserInfo().getMsg("jsp.DraftReExamine.Text08");
        	}
        	
        	String SQL = "select Names as FlowKey, Memo from Category where ParentId='PatentOffice'";
        	Properties costPrpt = this.getDbUtil().getFieldPrpts(SQL, "Memo");
        	
        	String officeHtml = Cnstnts.EMPTY_STRING;
        	SQL = "select * from DraftReExamineOffice where ParentId='"+this.getFlowKey()+"'";
        	DraftReExamineOffice obj = new DraftReExamineOffice();
 			obj.setDbFields();
     		List<List<Field>> findList = obj.getDbUtil().getFieldsList(SQL, obj.getDbFields());
     		int i=0;
     		for(Iterator itr=findList.iterator();itr.hasNext();){
     			i++;
     			List<Field> dataFields = (List<Field>)itr.next();
     			String checked_A = Cnstnts.EMPTY_STRING;
     			String checked_B = Cnstnts.EMPTY_STRING;
     			String checked_C = Cnstnts.EMPTY_STRING;
     			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
     				Field field = (Field)fieldsItr.next();
     				if(field.getName().equals("FlowKey")){
     					obj.FlowKey.setValue(field.getValue());
     				}
     				if(field.getName().equals("OfficeName")){
     					obj.OfficeName.setValue(field.getValue());
     					if(!parentObj.getProjectFlag().equals("Y")){
     						costText += "["+field.getValue()+":";
         					if(costPrpt.getProperty(field.getValue())!=null 
         							&& costPrpt.getProperty(field.getValue()).trim().length()>0){
         						costText += costPrpt.getProperty(field.getValue());
         					}
         					costText += "]";
     					}
     				}
     				if(field.getName().equals("Result")){
     					obj.Result.setValue(field.getValue());
     				}
     			}
     			officeHtml += trBeginTag+"<td colspan='4'>"+tableBeginTag+trBeginTag+"<td><h4>";
     			if(obj.getResult().equals("A.")){
     				checked_A = " checked";
     			} else
     			if(obj.getResult().equals("B.")){
     				checked_B = " checked";
     			} else
     			if(obj.getResult().equals("C.")){
     				checked_C = " checked";
     			}
     			String onClick_A = Cnstnts.EMPTY_STRING;
     			String onClick_B = Cnstnts.EMPTY_STRING;
     			String onClick_C = Cnstnts.EMPTY_STRING;
     			String checkEmpty = Cnstnts.EMPTY_STRING;
     			if(this.getDbActionMode().equals(Cnstnts.UPDATE)){
     				onClick_A = " onClick='doAjaxRequest(\"DraftReExamineOffice\",\"result"+i+"\"," +
     									"\"Result&"+obj.getFlowKey()+"&A.\",\"tmpField\",\"Value\")'";
         			onClick_B = " onClick='doAjaxRequest(\"DraftReExamineOffice\",\"result"+i+"\"," +
         								"\"Result&"+obj.getFlowKey()+"&B.\",\"tmpField\",\"Value\")'";
         			onClick_C = " onClick='doAjaxRequest(\"DraftReExamineOffice\",\"result"+i+"\"," +
         								"\"Result&"+obj.getFlowKey()+"&C.\",\"tmpField\",\"Value\")'";
         			checkEmpty = "<font color='red'>"+this.getUserInfo().getMsg("jsp.common.Require")+"*</font>";
     			}
     			officeHtml += checkEmpty;
     			if(findList.size()>1){
     				officeHtml += i+".";;
     			}
     			officeHtml += this.getUserInfo().getMsg("jsp.DraftReExamine.Text09")+obj.getOfficeName()+
     						 this.getUserInfo().getMsg("jsp.DraftReExamine.Text10")+"<br>"+
     						 "<input type='radio' id='result"+i+"' name='result"+i+"' value='A.'"+checked_A+onClick_A+">"+
     						 "A."+this.getUserInfo().getMsg("jsp.DraftReExamine.Text11")+obj.getOfficeName()+
     						 	  this.getUserInfo().getMsg("jsp.DraftReExamine.Text12")+"<br>"+
     						 "<input type='radio' id='result"+i+"' name='result"+i+"' value='B.'"+checked_B+onClick_B+">"+
     						 "B."+this.getUserInfo().getMsg("jsp.DraftReExamine.Text11")+obj.getOfficeName()+
   						 	  	  this.getUserInfo().getMsg("jsp.DraftReExamine.Text13")+"<br>"+
   						 	 "<input type='radio' id='result"+i+"' name='result"+i+"' value='C.'"+checked_C+onClick_C+">"+
   						 	 "C."+this.getUserInfo().getMsg("jsp.DraftReExamine.Text14");;
   				officeHtml += "</h4></td></tr></table></td></tr>";
     		}
     		rtnString += costText+"</h4></td></tr></table></td></tr>"+officeHtml;
        }
        return rtnString;
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            DraftReExamine preObj = (DraftReExamine) userInfo.getObj(this.getTableName());
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
		
		String SQL = "select * from DraftReExamine where ParentId='"+this.getParentId()+"'";
		this.setDbFields();
		List<Field> fieldList = this.getDbFields();
		List<List<Field>> findList = this.getDbUtil().getFieldsList(SQL, fieldList);
		
		if(findList.size()==0){
			return Cnstnts.EMPTY_STRING;
		}

		char newLine = Cnstnts.NEW_LINE;

		strBfr.append(newLine + "<br><fieldset><legend>"+this.getUserInfo().getMsg("jsp.DraftReExamine.title")+"</legend>");
		strBfr.append(newLine + "<div class='indent'>");
		strBfr.append(newLine + "<table width='100%' " + this.getTableBgcolor() + ">");
		
		String thText1="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.DraftReExamine.ReviewerName")+"</td>";
		String thText2="<td align='center' width='70%'>"+this.getUserInfo().getMsg("jsp.DraftReExamineOffice.Result")+"</td>";
		String thText3="<td align='center' width='15%'>"+this.getUserInfo().getMsg("jsp.DraftReExamine.FinishedDate")+"</td>";
		
		strBfr.append(newLine + "<tr"+this.getThBgcolor()+">"+thText1+thText2+thText3+"</tr>");
		
		int i=0;
		String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
		String printValue = Cnstnts.EMPTY_STRING;
		for(Iterator itr=findList.iterator();itr.hasNext();){
			i++;
			List<Field> dataFields = (List<Field>)itr.next();
			DraftReExamine obj = new DraftReExamine();
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("FlowKey")){
					obj.FlowKey.setValue(field.getValue());
				}
				if(field.getName().equals("ReviewerName")){
					obj.ReviewerName.setValue(field.getValue());
				}
				if(field.getName().equals("FinishedDate")){
					obj.FinishedDate.setValue(field.getValue());
				}
			}
			
			String onClick = " style='cursor: hand' onClick='openAppendix(\"" +
							"DraftReExamine.jsp?_flowKey="+obj.getFlowKey()+
							"&_getDataFlag=true&_pageActionMode=maintain" +
							"&_dbActionMode=query\",\"DraftReExamine\",800,600)'";
			
			String tdText1="<td align='center'"+onClick+">"+obj.ReviewerName.getValue()+"</td>";
			String tdText2="<td align='center'>"+obj.getOfficeResult(parentObj.getUserInfo())+"</td>";
			String tdText3="<td align='center'>"+obj.FinishedDate.getValue()+"</td>";
			
			printValue = tdText1+tdText2+tdText3;
			if(i%2==0){
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
			} else {
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
			}
			
			strBfr.append(newLine + "<tr "+bgColor+">"+printValue+"</tr>");
		}
		strBfr.append(newLine + "</td></tr></table>");
		
		if(parentObj.getStatus().equals("DS05") 
				&& new Groups().inGorup("G01", parentObj.getUserInfo().getAttribute("emp_id"))){
			SQL = "select count(*) as CountNum from DraftReExamine " +
			      "where ParentId='"+parentObj.getFlowKey()+"'";
			Field CountNum = new Field("CountNum"); 
			int ExamineCount = Integer.parseInt(this.getDbUtil().getFieldValue(SQL,CountNum));
			
			SQL += " and FinishedDate!=''";
			int finishedCount = Integer.parseInt(this.getDbUtil().getFieldValue(SQL,CountNum));
			if(finishedCount==ExamineCount){
				String ApproveBtn = "<input type='button' " +
						"value='"+this.getUserInfo().getMsg("jsp.DraftReExamine.Approve")+"' "+
								"onClick='this.disabled=true;" +
								"document.input.status.value=\"DS06\";" +
								"document.input.dbActionMode.value=\"update\";" +
								"document.input.submitFlag.value=\"true\";setValue()'/>";
				strBfr.append(newLine + ApproveBtn);
				
				String RejectBtn = "<input type='button' " +
						"value='"+this.getUserInfo().getMsg("jsp.DraftReExamine.Reject")+"' "+
						"onClick='this.disabled=true;" +
								"document.input.status.value=\"DS07\";" +
								"document.input.dbActionMode.value=\"update\";" +
								"document.input.submitFlag.value=\"true\";setValue()'/>";
				strBfr.append(newLine + RejectBtn);
			}
		}
		
		strBfr.append(newLine + "</div></fieldset>");
		
		return strBfr.toString();
	}
    
    @SuppressWarnings("unchecked")
	private String getOfficeResult(UserBean userInfo) throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		
		Properties ExamineResultPrpt = new Category().getChildPrpts(("ReExamineResult"));
		
    	String SQL = "select * from DraftReExamineOffice where ParentId='"+this.getFlowKey()+"'";
    	DraftReExamineOffice obj = new DraftReExamineOffice();
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
			obj = new DraftReExamineOffice();
			for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
				Field field = (Field)fieldsItr.next();
				if(field.getName().equals("OfficeName")){
					obj.OfficeName.setValue(field.getValue());
				}
				if(field.getName().equals("Result")){
					obj.Result.setValue(ExamineResultPrpt.getProperty(field.getValue()));
				}
			}
			if(i%2==0){
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
			} else {
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
			}
			rtnString += "<tr "+bgColor+"><td width='20%' align='center'>"+obj.getOfficeName()+"</td>" +
						 "<td width='80%'>"+obj.getResult()+"</td></tr>";
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
        		this.setErrorMessage(this.getUserInfo().getMsg("jsp.DraftReExamine.officeEmpty"));
        		return true;
        	}
        	this.setFinishedDate(Util.getDate());
            return false;
        }
    }

    private boolean checkOfficeEmpty() {
		String SQL = "select count(*) as RecordNum from DraftReExamineOffice " +
					 "where ParentId='"+this.getFlowKey()+"' and Result=''";
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
					this.setMessage(this.getUserInfo().getMsg("jsp.DraftReExamine.update.message"));
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
					this.getUserInfo().getMsg("jsp.DraftReExamine.submitBtn")));
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
    	String SQL = "select 'DraftReExamine' as LinkPage1, t.FlowKey as LinkFlowKey1, "+
    						"d.DeptName, d.ApplicantName, d.Title, c.Names as PatentType,"+
    						"'Draft' as LinkPage2, d.Flowkey as LinkFlowKey2 "+
    				 "from DraftReExamine t "+
    				 "inner join Draft d on t.ParentId=d.FlowKey "+
    				 "inner join Category c on d.PatentType=c.FlowKey "+
    				 "where t.Reviewer='"+empId+"' and FinishedDate=''";
    	List<Field> dataFields = new ArrayList<Field>();
    	
    	Field LinkPage1 = new Field("LinkPage1",this.getTableName());
    	LinkPage1.setShowFlag(false);
    	dataFields.add(LinkPage1);
    	
    	Field LinkFlowKey1 = new Field("LinkFlowKey1",this.getTableName());
    	LinkFlowKey1.setAliasName(userInfo.getMsg("jsp.DraftReExamine.FlowKey"));
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
    	
    	Field PatentType = new Field("PatentType","Draft");
    	PatentType.setAlign(Cnstnts.CENTER);
    	//PatentOffice.setListWidth("10%");
    	dataFields.add(PatentType);
    	
    	Field Title = new Field("Title","Draft");
    	//PatentOffice.setListWidth("10%");
    	dataFields.add(Title);
    	
    	return this.getDbUtil().getFieldsList(SQL, dataFields);
    }
    
}