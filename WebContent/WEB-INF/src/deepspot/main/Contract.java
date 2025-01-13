package deepspot.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.basic.SelectItem;
import deepspot.html.HiddenTag;
import deepspot.html.SelectOneTag;
import deepspot.util.Util;

public class Contract extends MasterBean {

    public Contract(){this.init();}

    public Contract(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field CreateTime;
    public void setCreateTime(String CreateTime){this.CreateTime.setValue(CreateTime);}
    public String getCreateTime(){return this.CreateTime.getValue();}

    public Field Summary;
    public void setSummary(String Summary){this.Summary.setValue(Summary);}
    public String getSummary(){return this.Summary.getValue();}
    
    public Field Names;
    public void setNames(String Names){this.Names.setValue(Names);}
    public String getNames(){return this.Names.getValue();}

    public Field WorkPlan;
    public void setWorkPlan(String WorkPlan){this.WorkPlan.setValue(WorkPlan);}
    public String getWorkPlan(){return this.WorkPlan.getValue();}

    public Field PlanType;
    public void setPlanType(String PlanType){this.PlanType.setValue(PlanType);}
    public String getPlanType(){return this.PlanType.getValue();}
    
    public Field PlanDept;
    public void setPlanDept(String PlanDept){this.PlanDept.setValue(PlanDept);}
    public String getPlanDept(){return this.PlanDept.getValue();}

    public Field PlanLeader;
    public void setPlanLeader(String PlanLeader){this.PlanLeader.setValue(PlanLeader);}
    public String getPlanLeader(){return this.PlanLeader.getValue();}

    public Field Target;
    public void setTarget(String Target){this.Target.setValue(Target);}
    public String getTarget(){return this.Target.getValue();}
    
    public Field Status;
    public void setStatus(String Status){this.Status.setValue(Status);}
    public String getStatus(){return this.Status.getValue();}

    public Field CloseReason;
    public void setCloseReason(String CloseReason){this.CloseReason.setValue(CloseReason);}
    public String getCloseReason(){return this.CloseReason.getValue();}

    public Field ContractDate;
    public void setContractDate(String ContractDate){this.ContractDate.setValue(ContractDate);}
    public String getContractDate(){return this.ContractDate.getValue();}

    public Field CloseDate;
    public void setCloseDate(String CloseDate){this.CloseDate.setValue(CloseDate);}
    public String getCloseDate(){return this.CloseDate.getValue();}

    public Field EndDate;
    public void setEndDate(String EndDate){this.EndDate.setValue(EndDate);}
    public String getEndDate(){return this.EndDate.getValue();}
    
    public Field SignOutId;
    public void setSignOutId(String SignOutId){this.SignOutId.setValue(SignOutId);}
    public String getSignOutId(){return this.SignOutId.getValue();}
    
    public Field SignOutName;
    public void setSignOutName(String SignOutName){this.SignOutName.setValue(SignOutName);}
    public String getSignOutName(){return this.SignOutName.getValue();}
    
    public Field SignOutTime;
    public void setSignOutTime(String SignOutTime){this.SignOutTime.setValue(SignOutTime);}
    public String getSignOutTime(){return this.SignOutTime.getValue();}
    
    public Field UpdateTime;
    public void setUpdateTime(String UpdateTime){this.UpdateTime.setValue(UpdateTime);}
    public String getUpdateTime(){return this.UpdateTime.getValue();}
    
    public Field Updater;
    public void setUpdater(String Updater){this.Updater.setValue(Updater);}
    public String getUpdater(){return this.Updater.getValue();}
    
    public Field Creator;
    public void setCreator(String Creator){this.Creator.setValue(Creator);}
    public String getCreator(){return this.Creator.getValue();}
    
    public String SignOutFlag;
    public void setSignOutFlag(String SignOutFlag){this.SignOutFlag=SignOutFlag;}
    public String getSignOutFlag(){return this.SignOutFlag;}
    
    public Field TabText;
    public void setTabText(String TabText){this.TabText.setValue(TabText);}
    public String getTabText(){return this.TabText.getValue();}

    public void init() {
        super.init();
        this.setProgramId("jsp.Contract");
        this.setTableName("Contract");

        this.CreateTime = new Field("CreateTime", this.getTableName());
        this.CreateTime.setDbType("varchar(20)");

        this.Summary = new Field("Summary", this.getTableName());
        this.Summary.setDbType("nvarchar(200)");

        this.Names = new Field("Names", this.getTableName());
        this.Names.setDbType("nvarchar(200)");

        this.WorkPlan = new Field("WorkPlan", this.getTableName());
        this.WorkPlan.setDbType("varchar(50)");
        
        this.PlanType = new Field("PlanType", this.getTableName());
        this.PlanType.setDbType("varchar(50)");

        this.PlanDept = new Field("PlanDept", this.getTableName());
        this.PlanDept.setDbType("varchar(50)");

        this.PlanLeader = new Field("PlanLeader", this.getTableName());
        this.PlanLeader.setDbType("varchar(50)");

        this.Target = new Field("Target", this.getTableName());
        this.Target.setDbType("nvarchar(200)");

        this.Status = new Field("Status", this.getTableName());
        this.Status.setDbType("varchar(50)");
        
        this.CloseReason = new Field("CloseReason", this.getTableName());
        this.CloseReason.setDbType("varchar(50)");
        
        this.CloseDate = new Field("CloseDate", this.getTableName());
        this.CloseDate.setDbType("varchar(10)");
        
        this.ContractDate = new Field("ContractDate", this.getTableName());
        this.ContractDate.setDbType("varchar(10)");
        
        this.EndDate = new Field("EndDate", this.getTableName());
        this.EndDate.setDbType("varchar(10)");
        
        this.SignOutId = new Field("SignOutId", this.getTableName());
        this.SignOutId.setDbType("varchar(50)");
        
        this.SignOutTime = new Field("SignOutTime", this.getTableName());
        this.SignOutTime.setDbType("varchar(20)");
        
        this.SignOutName = new Field("SignOutName", this.getTableName());
        this.SignOutName.setDbType("nvarchar(50)");
        
        this.UpdateTime = new Field("UpdateTime", this.getTableName());
        this.UpdateTime.setDbType("varchar(20)");
        
        this.Updater = new Field("Updater", this.getTableName());
        this.Updater.setDbType("varchar(50)");
        
        this.Creator = new Field("Creator", this.getTableName());
        this.Creator.setDbType("nvarchar(50)");
        
        this.TabText = new Field("TabText", this.getTableName());

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();
    }

    private List<List<Field>> InventorDetails;
    
    public void setInventorDetails(ArrayList<List<Field>> Details) {
    	this.InventorDetails = Details;
	}
    
    public List<List<Field>> getInventorDetails(String FlowKey) {
		return null;
	}
    
    public List<List<Field>> getInventorDetails() {
    	return this.InventorDetails;
	}

	public void setDbFields() {
        super.setDbFields();
        this.DbFields.add(this.CreateTime);

        this.DbFields.add(this.Summary);

        this.DbFields.add(this.Names);

        this.DbFields.add(this.WorkPlan);
        
        this.DbFields.add(this.PlanType);

        this.DbFields.add(this.PlanDept);

        this.DbFields.add(this.PlanLeader);

        this.DbFields.add(this.Target);

        this.DbFields.add(this.Status);
        
        this.DbFields.add(this.CloseReason);
        
        this.DbFields.add(this.CloseDate);
        
        this.DbFields.add(this.ContractDate);
        
        this.DbFields.add(this.EndDate);
        
        this.DbFields.add(this.SignOutId);
        
        this.DbFields.add(this.SignOutName);
        
        this.DbFields.add(this.SignOutTime);
        
        this.DbFields.add(this.UpdateTime);
        
        this.DbFields.add(this.Updater);
        
        this.DbFields.add(this.Creator);
    }
	
	protected String getDbActionSelectItem() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;

		if ((Cnstnts.TRUE_FLAG.equals(this.getModeLockFlag()) 
				&& !this.getProgramMode().equals("M"))
					|| (Cnstnts.MAINTAIN.equals(this.getPageActionMode()) 
						&& (Cnstnts.SIGN.equals(this.getDbActionMode())
							|| Cnstnts.CLOSE.equals(this.getDbActionMode()) 
								|| Cnstnts.ENDING.equals(this.getDbActionMode())))
									|| Cnstnts.SEARCH.equals(this.getPageActionMode())) {
			rtnString = new HiddenTag("dbActionMode", this.getDbActionMode()).toString();
			return rtnString;
		}
		if (Cnstnts.MAINTAIN.equals(this.getPageActionMode())
				&& this.getDbActionList() == null) {
			this.setDbActionList(getUserInfo().getDbActionList(this.getProgramId()));
		}

		if (Cnstnts.MAINTAIN.equals(this.getPageActionMode())){
			String onChange = "doAjaxRequest(\"Contract\",\"dbActionMode\",\"dbActionMode\",\"bodyDiv\",\"innerHTML\")";
			SelectOneTag selectItem = new SelectOneTag(Cnstnts.DB_ACTION_MODE,
					onChange, this.getDbActionMode(), this.getDbActionList());

			rtnString = selectItem.toString();
		}
		return rtnString;
	}

    
    public String printHiddenTags(){
    	String rtnString = super.printHiddenTags();
    	HashMap<String,String> hm = new HashMap<String,String>();
    	hm.put("signOutFlag",Cnstnts.EMPTY_STRING);
  	  	rtnString += new HiddenTag().print(hm);
  	  	return rtnString;
    }

    public String printSearchTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onSearchMode()) {
        	this.Names.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Names);
            
            this.Target.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.Target);
            
            this.WorkPlan.setHtmlType(Cnstnts.HTML_TAG_TEXT);

            this.Status.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Status.setSelectList(new Category().getChildList("RightStatus"));
            this.Status.setAnotherField(this.WorkPlan);
            rtnString += this.printHtml(this.Status);
        }
        return rtnString;
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
        	this.Names.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	this.Names.setSize(80);
            rtnString += this.printHtml(this.Names);
            
            this.PlanType.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.WorkPlan.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.WorkPlan.setAnotherField(this.PlanType);
            this.WorkPlan.setColspan(1);
            rtnString += this.printHtml(this.WorkPlan);
            
            this.PlanLeader.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            
            this.PlanDept.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.PlanDept.setAnotherField(this.PlanLeader);
            this.PlanDept.setColspan(1);
            rtnString += this.printHtml(this.PlanDept);

            this.Status.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Status.setSelectList(new Category().getChildList("RightStatus"));

            this.Target.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Target.setAnotherField(this.Status);
            this.Target.setColspan(1);
            rtnString += this.printHtml(this.Target);

            this.EndDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            
            this.ContractDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.ContractDate.setAnotherField(this.EndDate);
            this.ContractDate.setColspan(1);
            rtnString += this.printHtml(this.ContractDate);
            
            this.CloseReason.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.CloseReason.setSelectList(new Category().getChildList("CloseReason"));

            this.CloseDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
            this.CloseDate.setAnotherField(this.CloseReason);
            this.CloseDate.setColspan(1);
            rtnString += this.printHtml(this.CloseDate);
            
            if(this.getSignOutId().trim().length()>0){
            	this.SignOutName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
                this.SignOutName.setReadonly(true);
                
                this.SignOutTime.setHtmlType(Cnstnts.HTML_TAG_TEXT);
                this.SignOutTime.setReadonly(true);
                this.SignOutTime.setAnotherField(this.SignOutName);
                this.SignOutTime.setColspan(1);
                rtnString += this.printHtml(this.SignOutTime);
            } else {
            	rtnString += this.SignOutName.printHiddenTag();
            	rtnString += this.SignOutTime.printHiddenTag();
            }
            
            rtnString += this.SignOutId.printHiddenTag();
            
            rtnString += this.Summary.printHiddenTag();
            
            if(this.TabText.getValue().trim().length()==0){
            	this.TabText.setValue("ContractDocument");
            }
            rtnString += this.TabText.printHiddenTag();
            
            if(this.FlowKey.getValue().trim().length()>0){
            	String scriptText = Cnstnts.EMPTY_STRING;
            	String tabDivText = Cnstnts.EMPTY_STRING;
            	String resetBtn = "resetBtn('"+this.getTabText()+"');";   
            	scriptText = "<script>"+resetBtn+
								"function openTabFrame(jspName,dbActionMode,flowkey,frameHight){"+
								"  var frameWidth=document.getElementById('functionBar').offsetWidth;"+
								"  var tabFramDiv=document.getElementById('tabDiv');"+
								"  var srcUrl=jspName+'.jsp?_pageActionMode=maintain&_dbActionMode='+dbActionMode;"+
								"  if(dbActionMode=='insert'){"+
								"    srcUrl += '&parentId='+flowkey;"+
								"  } else {"+
								"    srcUrl += '&_getDataFlag=true&flowKey='+flowkey;"+
								"  }"+
								"  tabFramDiv.innerHTML=\"<iframe "+
									"src='\"+srcUrl+\"' height='\"+frameHight+\"' width='\"+(frameWidth-10)+\"'></iframe>\";"+
								"}"+
								"function closeTabFrame(){"+
								"  var tabFramDiv=document.getElementById('tabDiv');"+
								"  tabFramDiv.innerHTML='';"+
								"}"+
								"function resetBtn(newTabText){"+
								"  for(x=0;x<document.input.elements.length;x++){"+
								"    if(document.input.elements[x].type=='button'){"+
								"      document.input.elements[x].disabled=false;"+
								"    }"+
								"  }"+
								"  document.getElementById(newTabText).disabled=true;"+
								"}"+
								"function resetFrame(newTabText){"+
								"  resetBtn(newTabText);"+
								"  document.getElementById(newTabText).disabled=true;"+
								"  document.input.tabText.value=newTabText;"+
								"  closeTabFrame();"+
								"  doAjaxRequest('Contract','tabText','tabText','detailDiv','innerHTML')"+
								"}"+
								"</script>";
            	tabDivText = "<tr><td><div id='tabDiv' name='tabDiv'></div></td></tr>";
            	
            	rtnString += "<tr><td colspan=4>"+
            					"<input type='button' value='"+this.getUserInfo().getMsg("jsp.ContractDocument.title")+"' "+
            						   	"id='ContractDocument' onClick='resetFrame(\"ContractDocument\")'/>"+
            					"<input type='button' value='"+this.getUserInfo().getMsg("jsp.ContractAuthorize.title")+"' "+
            							"id='ContractAuthorize' onClick='resetFrame(\"ContractAuthorize\")'/>"+
            					"<input type='button' value='"+this.getUserInfo().getMsg("jsp.ContractRoyalties.title")+"' "+
            							"id='ContractRoyalties' onClick='resetFrame(\"ContractRoyalties\")'/>"+
            				 "</td></tr>"+scriptText+
            				 "<tr"+Cnstnts.DEFAULT_TR_BGCOLOR_1+"><td colspan='4'>"+
            				 "<table width='100%'>"+tabDivText+
            				 	"<tr><td><div id='detailDiv' name='detailDiv'>"+
            				 					this.printDetailTable()+"</div></td></tr>"+
            				 "</table></td></tr>";
            }
           
        }
        return rtnString;
    }

    public void setSearchListPrpts() {		
        this.FlowKey.setListWidth("15%");

        this.Names.setListWidth("35%");

        this.WorkPlan.setListWidth("10%");

        this.ContractDate.setListWidth("10%");
        this.ContractDate.setAlign(Cnstnts.CENTER);

        this.EndDate.setListWidth("10%");
        this.EndDate.setAlign(Cnstnts.CENTER);

        this.Target.setListWidth("10%");

        this.Status.setListWidth("10%");
        this.Status.setNotShowCode(true);

        Field[] showField = {this.FlowKey, this.Names, this.WorkPlan, 
        		this.ContractDate, this.EndDate, this.Target, this.Status};
        this.setShowField(showField);
        this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
    }

    public List<Object[]> getSearchList() throws Exception {
        String whereStr = Cnstnts.EMPTY_STRING;
        whereStr = Util.addWhereSQL(whereStr, this.Names);
        whereStr = Util.addWhereSQL(whereStr, this.WorkPlan);
        whereStr = Util.addWhereSQL(whereStr, this.Target);
        whereStr = Util.addWhereSQL(whereStr, this.Status);
        return this.doSearch(whereStr);
    }

    public Properties getNamesPrpts() throws Exception {
        return super.getNamesPrpts(this.Summary);
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
        	Contract preObj = (Contract) userInfo.getObj(this.getTableName());
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
        	Contract orginalCase = new Contract(this.getFlowKey());
        	if(orginalCase.getSignOutId().trim().length()>0){
        		if(!orginalCase.getSignOutId().equals(this.getUserInfo().getAttribute("emp_id"))){
        			this.setErrorMessage(this.getErrorMessage(this.SignOutId)+" ["+
        					this.getUserInfo().getMsg("jsp.Contract.SignOutName")+" : "+
        					orginalCase.getSignOutName()+"]["+
        					this.getUserInfo().getMsg("jsp.Contract.SignOutTime")+" : "+
        					orginalCase.getSignOutTime()+"]");
        			return true;
        		} else {
        			this.setSignOutId(Cnstnts.EMPTY_STRING);
        		}
        	}
        	if(Cnstnts.INSERT.equals(this.getDbActionMode()) 
        			&& this.getCreateTime().trim().length()==0){
        		this.setCreateTime(Util.getDateTime());
        		this.setCreator(this.getUserInfo().getAttribute("user_name"));
        	}
        	if(Cnstnts.UPDATE.equals(this.getDbActionMode()) 
        			|| Cnstnts.INSERT.equals(this.getDbActionMode())){
        		this.setUpdateTime(Util.getDateTime());
        		this.setUpdater(this.getUserInfo().getAttribute("user_name"));
        		if(Cnstnts.TRUE_FLAG.equals(this.getSignOutFlag())){
            		orginalCase.setSignOutId(this.getUserInfo().getAttribute("emp_id"));
            		orginalCase.setSignOutName(this.getUserInfo().getAttribute("user_name"));
            		orginalCase.setSignOutTime(Util.getDateTime());
            		orginalCase.update();
            		this.getAttribute();
            		this.setErrorMessage(this.getUserInfo().getMsg("jsp.Contract.SignOut"));
            		return true;
        		} else {
        			this.setSignOutId(Cnstnts.EMPTY_STRING);
            		this.setSignOutName(Cnstnts.EMPTY_STRING);
            		this.setSignOutTime(Cnstnts.EMPTY_STRING);
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
    
    public void doAction(UserBean userInfo) throws Exception {
    	super.doAction(userInfo);
    	if(this.getPageActionMode().equals(Cnstnts.MAINTAIN)){
    		if(this.getSignOutId().equals(userInfo.getAttribute("emp_id"))
    				&& (!this.getDbActionMode().equals(Cnstnts.UPDATE) 
    						&& !this.getDbActionMode().equals(Cnstnts.PRINT))){
    			this.setDbActionMode(Cnstnts.UPDATE);
    		}
    	}
    }
    
    public String getSubmitBtn() throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		if(this.getDbActionMode().equals(Cnstnts.PRINT)){
			List<SelectItem> sampleDocs = new ReportDefine().getList(this.getProgramId());
			if(sampleDocs.size()==0){
				return Cnstnts.EMPTY_STRING;
			} else {
				rtnString = "<select id='sampleDoc' name='sampleDoc'>";
				for(Iterator<SelectItem> itr=sampleDocs.iterator();itr.hasNext();){
					SelectItem option = (SelectItem)itr.next();
					String selected = Cnstnts.EMPTY_STRING;
					if(this.getSampleDoc().equals(option.getKey())){
						selected=Cnstnts.SELECTED;
					}
					rtnString += "  <option value='"+option.getKey()+"'"+selected+">"+
									option.getValue()+"</option>";
				}
				rtnString += "</select>";
			}
		}
		if(this.getSignOutId().trim().length()==0 
				&& Cnstnts.UPDATE.equals(this.getDbActionMode())
						&& this.getFlowKey().trim().length()>0){
			rtnString += "<input type='button' style='cursor: hand' " +
			   "value='" + this.getUserInfo().getMsg("jsp.common.signOut")+"' " +
			   "onClick='this.disabled=true;document.input.signOutFlag.value=\"true\";setSubmitValue(\"update\")'/>";;
			return rtnString;
		} else {
			if(this.getSignOutId().equals(this.getUserInfo().getAttribute("emp_id")) 
					|| Cnstnts.INSERT.equals(this.getDbActionMode()) 
							|| Cnstnts.PRINT.equals(this.getDbActionMode())){
				return rtnString+super.getSubmitBtn();
			}
		}
		return rtnString;
	}
    
    public String printDetailTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if(this.getTabText().equals("ContractDocument")){
        	rtnString = new ContractDocument().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        if(this.getTabText().equals("ContractAuthorize")){
        	rtnString = new ContractAuthorize().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        if(this.getTabText().equals("ContractRoyalties")){
        	rtnString = new ContractRoyalties().getSearchReasult(this.getUserInfo(),this.getFlowKey());
        }
        return rtnString;
    }
    
    public boolean canEdit() {
		if (this.getFlowKey() == null) {
			return false;
		}
		if (Cnstnts.MAINTAIN.equals(this.getPageActionMode())){
			if(Cnstnts.INSERT.equals(this.getDbActionMode())){
				return true;
			} else {
				if(Cnstnts.UPDATE.equals(this.getDbActionMode())){
					if(this.getFlowKey().trim().length()>0 
							&& this.getSignOutId().equals(this.getUserInfo().getAttribute("emp_id"))) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}		
			}		
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
			if (Cnstnts.SIGN.equals(this.getDbActionMode())) {
				this.doSignProcess();
				this.doApproveProcess();
				this.setMessage(this.getUserInfo().getMsg("jsp.signForm.send"));
				this.setForwardPage("menu.jsp");
			} else if (Cnstnts.CLOSE.equals(this.getDbActionMode())) {
				this.doCloseProcess();
				this.setMessage(this.getUserInfo().getMsg("jsp.closeForm.closed"));
				this.setForwardPage("menu.jsp");
			} else if (Cnstnts.INSERT.equals(this.getDbActionMode())) {
				if (this.insert()) {
					if (this.hasBindingFlow()) {
						FlowEngin.run(this.getDbActionMode(), 
									  this.FlowKey.getValue(), 
									  this.getProgramId(), 
									  this.getUserInfo().getAttribute("emp_id"), 
									  this.getApplicant(),
									  this.getTableName(), 
									  this.getAliasName());
					}
					this.doOtherInsertProcess();
					this.setMessage(this.getUserInfo().getMsg("jsp.chkData.insert"));
					if(Cnstnts.TRUE_FLAG.equals(this.getKeepProcessFlag())){
						this.setForwardPage(this.getTableName()+".jsp?_pageActionMode=maintain"+
																	"&_clearFlag=true");
					} else {
						this.setForwardPage(this.getTableName()+".jsp?_pageActionMode=maintain"+
									"&_dbActionMode=update&_getDataFlag=true&_flowKey="+this.getFlowKey());
					}
				} else {
					this.setErrorMessage(this.getTableName() + ".insert() error!!");
					return false;
				}
			} else if (Cnstnts.UPDATE.equals(this.getDbActionMode())) {
				if (this.update()) {
					if (this.hasBindingFlow()) {
						FlowEngin.run(this.getDbActionMode(), 
								  	  this.FlowKey.getValue(), 
								  	  this.getProgramId(), 
								  	  this.getUserInfo().getAttribute("emp_id"), 
								  	  this.getApplicant(),
								  	  this.getTableName(), 
								  	  this.getAliasName());
					}
					this.doOtherUpdateProcess();
					this.setMessage(this.getUserInfo().getMsg("jsp.chkData.update"));
					this.setForwardPage(this.getTableName()+".jsp?_pageActionMode=search"+
																"&doSearchFlag=true");
				} else {
					this.setErrorMessage(this.getTableName() + ".update() error!!");
					return false;
				}
			} else if (Cnstnts.DELETE.equals(this.getDbActionMode())) {
				if (this.delete()) {
					this.doOtherDeleteProcess();
					this.clearAttribute();
					this.setMessage(this.getUserInfo().getMsg("jsp.chkData.delete"));
					this.setForwardPage(this.getTableName()+".jsp?_pageActionMode=search"+
									   "&doSearchFlag=true");
				} else {
					this.setErrorMessage(this.getTableName() + ".delete() error!!");
					return false;
				}
			}
			return true;
		}
	}
    
    public boolean delete() throws Exception {
		List<String> sqlList = new ArrayList<String>();
		this.setDbFields();
		if (this.hasBindingFlow()) {
			sqlList.add("delete from Flow where FlowKey='" + this.getFlowKey()
					+ "'");
			sqlList.add("delete from Flow_detail where FlowKey='"
					+ this.getFlowKey() + "'");
		}
		sqlList.add("delete from ContractDocument where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from ContractAuthorize where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from ContractRoyalties where ParentId='"+this.getFlowKey()+"'");
		sqlList.add("delete from "+this.getTableName()+" where FlowKey='"+this.getFlowKey()+"'");
		if (this.getDetails() != null) {
			sqlList.add("delete from " + this.getTableName()
					+ "_detail where FlowKey='" + this.getFlowKey() + "'");
		}
		if (new Program(this.getProgramId()).getLogDelete().equals("1")) {
			sqlList.add(this.getLogSQL(null));
		}
		return this.getDbUtil().executeUpdate(sqlList);
	}
    
    public void doPrintProcess() throws Exception {
    	
	}
}