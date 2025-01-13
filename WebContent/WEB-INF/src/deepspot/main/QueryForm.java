package deepspot.main;

import java.util.Iterator;
import java.util.List;

import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.QueryBean;

public class QueryForm extends QueryBean{

	public QueryForm()throws Exception{this.init();}
	
	public Field QueryClass;
    public void setQueryClass(String QueryClass){this.QueryClass.setValue(QueryClass);}
    public String getQueryClass(){return this.QueryClass.getValue();}
    
    public Field ReflashTag;
    public void setReflashTag(String ReflashTag){this.ReflashTag.setValue(ReflashTag);}
    public String getReflashTag(){return this.ReflashTag.getValue();}

    public Field QueryText1;
    public void setQueryText1(String QueryText1){this.QueryText1.setValue(QueryText1);}
    public String getQueryText1(){return this.QueryText1.getValue();}
    
    public Field QueryText2;
    public void setQueryText2(String QueryText2){this.QueryText2.setValue(QueryText2);}
    public String getQueryText2(){return this.QueryText2.getValue();}
    
    public Field QueryText3;
    public void setQueryText3(String QueryText3){this.QueryText3.setValue(QueryText3);}
    public String getQueryText3(){return this.QueryText3.getValue();}
    
    private Field QueryText4;
    public void setQueryText4(String QueryText4){this.QueryText4.setValue(QueryText4);}
    public String getQueryText4(){return this.QueryText4.getValue();}
    
    public void init() throws Exception {
        super.init();
        this.setProgramId("jsp.QueryForm");

        this.QueryClass = new Field("QueryClass","QueryForm");
        
        this.ReflashTag = new Field("ReflashTag","QueryForm");
        
        this.QueryText1 = new Field("QueryText1","QueryForm");
        
        this.QueryText2 = new Field("QueryText2","QueryForm");
        
        this.QueryText3 = new Field("QueryText3","QueryForm");
        
        this.QueryText4 = new Field("QueryText4","QueryForm");
    }
    
    private void setFieldsTableName(){
    	this.QueryClass.setTableName(this.QueryClass.getValue());
    	
    	this.ReflashTag.setTableName(this.QueryClass.getValue());
    	
    	this.QueryText1.setTableName(this.QueryClass.getValue());
    	
    	this.QueryText2.setTableName(this.QueryClass.getValue());
    	
    	this.QueryText3.setTableName(this.QueryClass.getValue());
    	
    	this.QueryText4.setTableName(this.QueryClass.getValue());
    }
    
    public String getSubmitBtn() throws Exception {
		String rtnString=Cnstnts.EMPTY_STRING;
		rtnString=Cnstnts.NEW_LINE +
				  "<input type='button' style='cursor: hand' " +
				  "value='" + this.getUserInfo().getMsg("jsp.common.Query")+"' " +
				  "onClick='document.input.submitFlag.value=\"true\";setValue()'/>";
		return rtnString;
  	}

    public String printMainTable() throws Exception {
    	this.setFieldsTableName();
    	
        String rtnString = Cnstnts.EMPTY_STRING;
        
        if(this.getQueryClass().equals("Client")){
        	this.QueryText1.setAliasName(this.getUserInfo().getMsg("jsp.Client.CompanyName"));
        	this.QueryText2.setAliasName(this.getUserInfo().getMsg("jsp.Client.Contact"));
        }
        if(this.getQueryClass().equals("Applicant")){
        	this.QueryText1.setAliasName(this.getUserInfo().getMsg("jsp.Applicant.Names"));
        	this.QueryText2.setAliasName(this.getUserInfo().getMsg("jsp.Applicant.CompanyReq"));
        	this.QueryText3.setAliasName(this.getUserInfo().getMsg("jsp.Applicant.Client"));
        }
        if(this.getQueryClass().equals("Attorney")){
        	this.QueryText1.setAliasName(this.getUserInfo().getMsg("jsp.Attorney.Firm"));
        	this.QueryText2.setAliasName(this.getUserInfo().getMsg("jsp.Attorney.FullName"));
        	this.QueryText3.setAliasName(this.getUserInfo().getMsg("jsp.Attorney.Nationality"));
        }
        if(this.getQueryClass().equals("Employee") 
        		|| this.getQueryClass().equals("Inventors")
        				|| this.getQueryClass().equals("TrademarkInventor")){
        	this.QueryText1.setAliasName(this.getUserInfo().getMsg("jsp.Employee.Emp_name"));
        	this.QueryText2.setAliasName(this.getUserInfo().getMsg("jsp.Employee.EngName"));
        	this.QueryText3.setAliasName(this.getUserInfo().getMsg("jsp.Employee.Skill"));
        	this.QueryText4.setAliasName(this.getUserInfo().getMsg("jsp.Employee.RegisterAddress"));
        }
        if(this.getQueryClass().equals("DraftRecommend")
        		|| this.getQueryClass().equals("DraftAssignExaminer")){
        	this.QueryText1.setAliasName(this.getUserInfo().getMsg("jsp.Employee.Emp_name"));
        	this.QueryText2.setAliasName(this.getUserInfo().getMsg("jsp.Employee.EngName"));
        	this.QueryText3.setAliasName(this.getUserInfo().getMsg("jsp.Employee.Skill"));
        	this.QueryText4.setAliasName(this.getUserInfo().getMsg("jsp.Employee.Address"));
        }
        
        this.QueryText2.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        if(this.getQueryClass().equals("Applicant")){
        	this.QueryText4.setHtmlType(Cnstnts.HTML_TAG_HIDDEN);
        	this.QueryText2.setAnotherField(this.QueryText4);
        }
        
        this.QueryText1.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.QueryText1.setAnotherField(this.QueryText2);
        rtnString += this.printHtml(this.QueryText1);
        
        if(this.getQueryClass().equals("Attorney")){
        	this.QueryText3.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        	this.QueryText3.setSelectList(new Category().getChildList("Nationality"));
            rtnString += this.printHtml(this.QueryText3);
        }
        
        if(this.getQueryClass().equals("Employee")
        		|| this.getQueryClass().equals("Inventors")
        			|| this.getQueryClass().equals("TrademarkInventor")
        				|| this.getQueryClass().equals("DraftRecommend")
        					|| this.getQueryClass().equals("DraftAssignExaminer")){
        	this.QueryText4.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        	
        	this.QueryText3.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
        	this.QueryText3.setSelectList(new Category().getChildList("Skill"));
        	this.QueryText3.setAnotherField(this.QueryText4);
            rtnString += this.printHtml(this.QueryText3);
        }
       
        rtnString += this.QueryClass.printHiddenTag();
        rtnString += this.ReflashTag.printHiddenTag();
        	
        return rtnString;
    }
    
    public void doAction(UserBean userInfo) throws Exception{
    	this.setUserInfo(userInfo);
    	if(this.getQueryClass().equals("Client")){
    		this.setPageTitle(userInfo.getMsg("jsp.Applicant.QueryClient"));
    		String buttonText = "<input type='button' "+
    								   "value='"+this.getUserInfo().getMsg("jsp.function.insert")+
    								   			 this.getUserInfo().getMsg("jsp.Client.title")+"' "+
    								   "onClick='openAppendix(\"Client.jsp?_pageActionMode=maintain"+
    								   			"&_dbActionMode=insert\",\"AddClient\",800,600)'/>";
    		this.setButtonText(buttonText);
    	}
    	if(this.getQueryClass().equals("Applicant")){
    		this.setPageTitle(userInfo.getMsg("jsp.PatentApplicant.QueryApplicant"));
    		String buttonText = "<input type='button' "+
			   "value='"+this.getUserInfo().getMsg("jsp.function.insert")+
			   			 this.getUserInfo().getMsg("jsp.Applicant.title")+"' "+
			   "onClick='openAppendix(\"Applicant.jsp?_pageActionMode=maintain"+
			   			"&_dbActionMode=insert\",\"AddApplicant\",800,600)'/>";
    		this.setButtonText(buttonText);
    	}
    	if(this.getQueryClass().equals("Attorney")){
    		this.setPageTitle(userInfo.getMsg("jsp.PatentAttorney.QueryAttorney"));
    		String buttonText = "<input type='button' "+
			   "value='"+this.getUserInfo().getMsg("jsp.function.insert")+
			   			 this.getUserInfo().getMsg("jsp.Attorney.title")+"' "+
			   "onClick='openAppendix(\"Attorney.jsp?_pageActionMode=maintain"+
			   			"&_dbActionMode=insert\",\"AddInventors\",800,600)'/>";
    		this.setButtonText(buttonText);
    	}
    	if(this.getQueryClass().equals("Employee") 
    			|| this.getQueryClass().equals("TrademarkInventor")
    				|| this.getQueryClass().equals("DraftRecommend")
    					|| this.getQueryClass().equals("DraftAssignExaminer")){
    		if(this.getQueryClass().equals("Employee")) {
    			this.setPageTitle(userInfo.getMsg("jsp.DraftInventor.QueryInventor"));
    		}
    		if(this.getQueryClass().equals("DraftRecommend")
    				|| this.getQueryClass().equals("DraftAssignExaminer")) {
    			this.setPageTitle(userInfo.getMsg("jsp.DraftRecommend.QueryRecommend"));
    		}
    		String buttonText = "<input type='button' "+
			   "value='"+this.getUserInfo().getMsg("jsp.function.insert")+
			   			 this.getUserInfo().getMsg("jsp.Employee.title")+"' "+
			   "onClick='openAppendix(\"Employee.jsp?_pageActionMode=maintain"+
			   			"&_dbActionMode=insert&_modeLockFlag=true\",\"AddEmployee\",800,600)'/>";
    		this.setButtonText(buttonText);
    	}
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
		
  			String fieldName1=Cnstnts.EMPTY_STRING,fieldName2=Cnstnts.EMPTY_STRING,
  				   fieldName3=Cnstnts.EMPTY_STRING,fieldName4=Cnstnts.EMPTY_STRING;
  			
  			String whereSQL = Cnstnts.EMPTY_STRING;
  			String SQL = Cnstnts.EMPTY_STRING;
  			List<List<Field>> findList = null;
  			if(this.getQueryClass().equals("Client")){
  				rtnString += newLine+"  <tr><td align='center' colspan='4'>"+
  										   "<H4><b>"+this.getUserInfo().getMsg("jsp.Client.title")+
  										   "</b></H4></td></tr>";
  				fieldName1 = this.getUserInfo().getMsg("jsp.Client.CompanyName");
  				fieldName2 = this.getUserInfo().getMsg("jsp.Client.Contact");
  				fieldName3 = this.getUserInfo().getMsg("jsp.Client.Tel1");
  				fieldName4 = this.getUserInfo().getMsg("jsp.Client.Address1");
  				rtnString += newLine + "<tr"+this.getThBgcolor()+">";
  	  			rtnString += "<td align='center' width='25%'>"+fieldName1+"</td>";
  	  			rtnString += "<td align='center' width='15%'>"+fieldName2+"</td>";
  	  			rtnString += "<td align='center' width='15%'>"+fieldName3+"</td>";
  	  			rtnString += "<td align='center' width='45%'>"+fieldName4+"</td>";
  	  			rtnString += newLine + "</tr>";
  	  			
  	  			if(this.QueryText1.getValue().trim().length()>0){
  	  				whereSQL = " where CompanyName like '%"+this.getQueryText1()+"%'";
  	  			}
  	  			
  	  			if(this.QueryText2.getValue().trim().length()>0){
  	  				if(this.QueryText1.getValue().trim().length()==0){
  	  					whereSQL = " where CompanyName like '%"+this.getQueryText2()+"%'";
  	  				} else {
  	  					whereSQL += " and Contact like '%"+this.getQueryText2()+"%'";
  	  				}
	  			}
  	  			
  	  			SQL = "select * from "+this.getQueryClass()+whereSQL;
  				Client queryClass = new Client();
  				queryClass.setDbFields();
  	  			findList = this.getDbUtil().getFieldsList(SQL, queryClass.getDbFields());
  			}
  			if(this.getQueryClass().equals("Applicant")){
  				rtnString += newLine+"  <tr><td align='center' colspan='4'>"+
  										   "<H4><b>"+this.getUserInfo().getMsg("jsp.Applicant.title")+
  										   "</b></H4></td></tr>";
  				fieldName1 = this.getUserInfo().getMsg("jsp.Applicant.Names");
  				fieldName2 = this.getUserInfo().getMsg("jsp.Applicant.CompanyReq");
  				fieldName3 = this.getUserInfo().getMsg("jsp.Applicant.TelNo");
  				fieldName4 = this.getUserInfo().getMsg("jsp.Applicant.Address");
  				rtnString += newLine + "<tr"+this.getThBgcolor()+">";
  	  			rtnString += "<td align='center' width='25%'>"+fieldName1+"</td>";
  	  			rtnString += "<td align='center' width='15%'>"+fieldName2+"</td>";
  	  			rtnString += "<td align='center' width='15%'>"+fieldName3+"</td>";
  	  			rtnString += "<td align='center' width='45%'>"+fieldName4+"</td>";
  	  			rtnString += newLine + "</tr>";
  	  			
  	  			if(this.QueryText1.getValue().trim().length()>0){
  	  				whereSQL = " where Names like '%"+this.getQueryText1()+"%'";
  	  			}
  	  			
  	  			if(this.QueryText2.getValue().trim().length()>0){
  	  				if(this.QueryText1.getValue().trim().length()==0){
  	  					whereSQL = " where CompanyReq like '%"+this.getQueryText2()+"%'";
  	  				} else {
  	  					whereSQL += " and CompanyReq like '%"+this.getQueryText2()+"%'";
  	  				}
	  			}
  	  			
  	  			
  	  			if(this.QueryText4.getValue().trim().length()>0){
	  	  			if(whereSQL.trim().length()==0){
	  	  				whereSQL=" where Client='" + this.getQueryText4() + "'";
	  	  			} else {
	  	  				whereSQL +=" and Client='" + this.getQueryText4() + "'";
	  	  			
	  	  			}
  	  			}
  	  			
  	  			SQL = "select * from "+this.getQueryClass()+whereSQL;
  	  			Applicant queryClass = new Applicant();
  	  			queryClass.setDbFields();
  	  			findList = this.getDbUtil().getFieldsList(SQL, queryClass.getDbFields());
  			}
  			/*
  			if(this.getQueryClass().equals("Inventors")){
  				rtnString += newLine+"  <tr><td align='center' colspan='4'>"+
  										   "<H4><b>"+this.getUserInfo().getMsg("jsp.Inventors.title")+
  										   "</b></H4></td></tr>";
  				fieldName1 = this.getUserInfo().getMsg("jsp.Inventors.FirstName");
  				fieldName2 = this.getUserInfo().getMsg("jsp.Inventors.LastName");
  				fieldName3 = this.getUserInfo().getMsg("jsp.Inventors.Nationality");
  				fieldName4 = this.getUserInfo().getMsg("jsp.Inventors.Address");
  				rtnString += newLine + "<tr"+this.getThBgcolor()+">";
  	  			rtnString += "<td align='center' width='15%'>"+fieldName1+"</td>";
  	  			rtnString += "<td align='center' width='15%'>"+fieldName2+"</td>";
  	  			rtnString += "<td align='center' width='20%'>"+fieldName3+"</td>";
  	  			rtnString += "<td align='center' width='50%'>"+fieldName4+"</td>";
  	  			rtnString += newLine + "</tr>";
  	  			
  	  			if(this.QueryText1.getValue().trim().length()>0){
  	  				whereSQL = " where FirstName like '%"+this.getQueryText1()+"%'";
  	  			}
  	  			
  	  			if(this.QueryText2.getValue().trim().length()>0){
  	  				if(this.QueryText1.getValue().trim().length()==0){
  	  					whereSQL = " where LastName like '%"+this.getQueryText2()+"%'";
  	  				} else {
  	  					whereSQL += " and LastName like '%"+this.getQueryText2()+"%'";
  	  				}
	  			}
  	  			if(this.QueryText4.getValue().trim().length()>0){
	  	  			if(whereSQL.trim().length()==0){
	  	  				whereSQL=" where Client='" + this.getQueryText4() + "'";
	  	  			} else {
	  	  				whereSQL +=" and Client='" + this.getQueryText4() + "'";
	  	  			
	  	  			}
	  			}
  	  			SQL = "select * from "+this.getQueryClass()+whereSQL;
  	  			Inventors queryClass = new Inventors();
  	  			queryClass.setDbFields();
  	  			findList = this.getDbUtil().getFieldsList(SQL, queryClass.getDbFields());
  			}
  			*/
  			if(this.getQueryClass().equals("Attorney")){
  				rtnString += newLine+"  <tr><td align='center' colspan='4'>"+
  										   "<H4><b>"+this.getUserInfo().getMsg("jsp.Attorney.title")+
  										   "</b></H4></td></tr>";
  				fieldName1 = this.getUserInfo().getMsg("jsp.Attorney.Firm");
  				fieldName2 = this.getUserInfo().getMsg("jsp.Attorney.FullName");
  				fieldName3 = this.getUserInfo().getMsg("jsp.Attorney.Tel1");
  				fieldName4 = this.getUserInfo().getMsg("jsp.Attorney.Address1");
  				rtnString += newLine + "<tr"+this.getThBgcolor()+">";
  	  			rtnString += "<td align='center' width='25%'>"+fieldName1+"</td>";
  	  			rtnString += "<td align='center' width='15%'>"+fieldName2+"</td>";
  	  			rtnString += "<td align='center' width='15%'>"+fieldName3+"</td>";
  	  			rtnString += "<td align='center' width='45%'>"+fieldName4+"</td>";
  	  			rtnString += newLine + "</tr>";
  	  			
  	  			if(this.QueryText1.getValue().trim().length()>0){
  	  				whereSQL = " where Firm like '%"+this.getQueryText1()+"%'";
  	  			}
  	  			
  	  			if(this.QueryText2.getValue().trim().length()>0){
  	  				if(this.QueryText1.getValue().trim().length()==0){
  	  					whereSQL = " where (LastName like '%"+this.getQueryText2()+"%' or "+
  	  									   "FirstName like '%"+this.getQueryText2()+"%')";
  	  				} else {
  	  					whereSQL += " and (LastName like '%"+this.getQueryText2()+"%' or "+
  	  									   "FirstName like '%"+this.getQueryText2()+"%')";
  	  				}
	  			}
  	  			
  	  			if(this.QueryText3.getValue().trim().length()>0){
	  				if(whereSQL.trim().length()==0){
	  					whereSQL = " where Nationality = '"+this.getQueryText3()+"'";
	  				} else {
	  					whereSQL += " and Nationality = '"+this.getQueryText3()+"'";
	  				}
  	  			}
  	  			
  	  			SQL = "select * from "+this.getQueryClass()+whereSQL;
  	  			Attorney queryClass = new Attorney();
  	  			queryClass.setDbFields();
  	  			findList = this.getDbUtil().getFieldsList(SQL, queryClass.getDbFields());
  			}
  			
  			if(this.getQueryClass().equals("Inventors")){
  				rtnString += newLine+"  <tr><td align='center' colspan='4'>"+
  										   "<H4><b>"+this.getUserInfo().getMsg("jsp.Employee.title")+
  										   "</b></H4></td></tr>";
  				fieldName1 = this.getUserInfo().getMsg("jsp.Employee.Emp_name");
  				fieldName2 = this.getUserInfo().getMsg("jsp.Employee.EngName");
  				fieldName3 = this.getUserInfo().getMsg("jsp.Employee.Skill");
  				fieldName4 = this.getUserInfo().getMsg("jsp.Employee.Address");
  				rtnString += newLine + "<tr"+this.getThBgcolor()+">";
  	  			rtnString += "<td align='center' width='15%'>"+fieldName1+"</td>";
  	  			rtnString += "<td align='center' width='15%'>"+fieldName2+"</td>";
  	  			rtnString += "<td align='center' width='20%'>"+fieldName3+"</td>";
  	  			rtnString += "<td align='center' width='50%'>"+fieldName4+"</td>";
  	  			rtnString += newLine + "</tr>";
  	  			
  	  			PatentCase parentObj = (PatentCase)this.getUserInfo().getObj("PatentCase");
  	  			
  	  			whereSQL = " where FlowKey not in(select InventorId from DraftInventor " +
  	  					"where ParentId='"+parentObj.getFlowKey()+"')";
  	  			
  	  			if(this.QueryText1.getValue().trim().length()>0){
  	  				whereSQL += " and Emp_name like '%"+this.getQueryText1()+"%'";
  	  			}
  	  			if(this.QueryText2.getValue().trim().length()>0){
  	  				whereSQL += " and EngName like '%"+this.getQueryText2()+"%'";
	  			}
  	  			if(this.QueryText3.getValue().trim().length()>0){
  	  				whereSQL +=" and Skill like '%"+this.getQueryText3()+"%'";
	  			}
  	  			if(this.QueryText4.getValue().trim().length()>0){
  	  				whereSQL +=" and RegisterAddress like '%"+this.getQueryText4()+"%'";
  	  			}
  	  			SQL = "select * from Employee "+whereSQL;
  	  			Employee queryClass = new Employee();
  	  			queryClass.setDbFields();
  	  			findList = this.getDbUtil().getFieldsList(SQL, queryClass.getDbFields());
  			}
  			
  			if(this.getQueryClass().equals("TrademarkInventor")){
  				rtnString += newLine+"  <tr><td align='center' colspan='4'>"+
  										   "<H4><b>"+this.getUserInfo().getMsg("jsp.Employee.title")+
  										   "</b></H4></td></tr>";
  				fieldName1 = this.getUserInfo().getMsg("jsp.Employee.Emp_name");
  				fieldName2 = this.getUserInfo().getMsg("jsp.Employee.EngName");
  				fieldName3 = this.getUserInfo().getMsg("jsp.Employee.Skill");
  				fieldName4 = this.getUserInfo().getMsg("jsp.Employee.Address");
  				rtnString += newLine + "<tr"+this.getThBgcolor()+">";
  	  			rtnString += "<td align='center' width='15%'>"+fieldName1+"</td>";
  	  			rtnString += "<td align='center' width='15%'>"+fieldName2+"</td>";
  	  			rtnString += "<td align='center' width='20%'>"+fieldName3+"</td>";
  	  			rtnString += "<td align='center' width='50%'>"+fieldName4+"</td>";
  	  			rtnString += newLine + "</tr>";
  	  			
  	  			TrademarkCase parentObj = (TrademarkCase)this.getUserInfo().getObj("TrademarkCase");
  	  			
  	  			whereSQL = " where FlowKey not in(select Inventor from TrademarkInventor " +
  	  					"where ParentId='"+parentObj.getFlowKey()+"')";
  	  			
  	  			if(this.QueryText1.getValue().trim().length()>0){
  	  				whereSQL += " and Emp_name like '%"+this.getQueryText1()+"%'";
  	  			}
  	  			if(this.QueryText2.getValue().trim().length()>0){
  	  				whereSQL += " and EngName like '%"+this.getQueryText2()+"%'";
	  			}
  	  			if(this.QueryText3.getValue().trim().length()>0){
  	  				whereSQL +=" and Skill like '%"+this.getQueryText3()+"%'";
	  			}
  	  			if(this.QueryText4.getValue().trim().length()>0){
  	  				whereSQL +=" and RegisterAddress like '%"+this.getQueryText4()+"%'";
  	  			}
  	  			SQL = "select * from Employee "+whereSQL;
  	  			Employee queryClass = new Employee();
  	  			queryClass.setDbFields();
  	  			findList = this.getDbUtil().getFieldsList(SQL, queryClass.getDbFields());
  			}
  			
  			if(this.getQueryClass().equals("Employee")){
  				rtnString += newLine+"  <tr><td align='center' colspan='4'>"+
  										   "<H4><b>"+this.getUserInfo().getMsg("jsp.Employee.title")+
  										   "</b></H4></td></tr>";
  				fieldName1 = this.getUserInfo().getMsg("jsp.Employee.Emp_name");
  				fieldName2 = this.getUserInfo().getMsg("jsp.Employee.EngName");
  				fieldName3 = this.getUserInfo().getMsg("jsp.Employee.skill");
  				fieldName4 = this.getUserInfo().getMsg("jsp.Employee.Address");
  				rtnString += newLine + "<tr"+this.getThBgcolor()+">";
  	  			rtnString += "<td align='center' width='15%'>"+fieldName1+"</td>";
  	  			rtnString += "<td align='center' width='15%'>"+fieldName2+"</td>";
  	  			rtnString += "<td align='center' width='20%'>"+fieldName3+"</td>";
  	  			rtnString += "<td align='center' width='50%'>"+fieldName4+"</td>";
  	  			rtnString += newLine + "</tr>";
  	  			
  	  			Draft parentObj = (Draft)this.getUserInfo().getObj("Draft");
  	  			
  	  			whereSQL = " where FlowKey not in(select InventorId from DraftInventor " +
  	  					"where ParentId='"+parentObj.getFlowKey()+"')";
  	  			
  	  			if(this.QueryText1.getValue().trim().length()>0){
  	  				whereSQL += " and Emp_name like '%"+this.getQueryText1()+"%'";
  	  			}
  	  			if(this.QueryText2.getValue().trim().length()>0){
  	  				whereSQL += " and EngName like '%"+this.getQueryText2()+"%'";
	  			}
  	  			if(this.QueryText3.getValue().trim().length()>0){
  	  				whereSQL +=" and Skill like '%"+this.getQueryText3()+"%'";
	  			}
  	  			if(this.QueryText4.getValue().trim().length()>0){
  	  				whereSQL +=" and RegisterAddress like '%"+this.getQueryText4()+"%'";
  	  			}
  	  			SQL = "select * from "+this.getQueryClass()+whereSQL;
  	  			Employee queryClass = new Employee();
  	  			queryClass.setDbFields();
  	  			findList = this.getDbUtil().getFieldsList(SQL, queryClass.getDbFields());
  			}
  			
  			if(this.getQueryClass().equals("DraftRecommend")
  					|| this.getQueryClass().equals("DraftAssignExaminer")){
  				rtnString += newLine+"  <tr><td align='center' colspan='4'>"+
  										   "<H4><b>"+this.getUserInfo().getMsg("jsp.Employee.title")+
  										   "</b></H4></td></tr>";
  				fieldName1 = this.getUserInfo().getMsg("jsp.Employee.Emp_name");
  				fieldName2 = this.getUserInfo().getMsg("jsp.Employee.EngName");
  				fieldName3 = this.getUserInfo().getMsg("jsp.Employee.Skill");
  				fieldName4 = this.getUserInfo().getMsg("jsp.Employee.Address");
  				rtnString += newLine + "<tr"+this.getThBgcolor()+">";
  	  			rtnString += "<td align='center' width='15%'>"+fieldName1+"</td>";
  	  			rtnString += "<td align='center' width='15%'>"+fieldName2+"</td>";
  	  			rtnString += "<td align='center' width='20%'>"+fieldName3+"</td>";
  	  			rtnString += "<td align='center' width='50%'>"+fieldName4+"</td>";
  	  			rtnString += newLine + "</tr>";
  	  			
	  	  		Draft parentObj = (Draft)this.getUserInfo().getObj("Draft");

	  	  		if(this.getQueryClass().equals("DraftRecommend")){
	  	  			whereSQL = " where FlowKey not in(select EmpId from DraftRecommend " +
	  	  						"where ParentId='"+parentObj.getFlowKey()+"')";
	  	  		} else {
	  	  			whereSQL = " where FlowKey!='' ";
	  	  		}
	  	  		if(this.QueryText1.getValue().trim().length()>0){
	  	  			whereSQL += " and Emp_name like '%"+this.getQueryText1()+"%'";
	  	  		}
	  	  		if(this.QueryText2.getValue().trim().length()>0){
	  	  			whereSQL += " and EngName like '%"+this.getQueryText2()+"%'";
	  			}
	  	  		if(this.QueryText3.getValue().trim().length()>0){
	  	  			whereSQL +=" and Skill like '%"+this.getQueryText3()+"%'";
	  			}
	  	  		if(this.QueryText4.getValue().trim().length()>0){
	  	  			whereSQL +=" and RegisterAddress like '%"+this.getQueryText4()+"%'";
	  	  		}
	  			
  	  			SQL = "select * from Employee "+whereSQL;
  	  			Employee queryClass = new Employee();
  	  			queryClass.setDbFields();
  	  			findList = this.getDbUtil().getFieldsList(SQL, queryClass.getDbFields());
  			}
  			
  			if(findList==null){
  				return Cnstnts.EMPTY_STRING;
  			}
  			int i=0;
  			String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
  			String printValue = Cnstnts.EMPTY_STRING;
  			for(Iterator itr=findList.iterator();itr.hasNext();i++){
  				List<Field> dataFields = (List<Field>)itr.next();
  				String FlowKey = Cnstnts.EMPTY_STRING;
  				String fiedlValue1 = Cnstnts.EMPTY_STRING;
  				String fiedlValue2 = Cnstnts.EMPTY_STRING;
	  			String fiedlValue3 = Cnstnts.EMPTY_STRING;
	  			String fiedlValue4 = Cnstnts.EMPTY_STRING;
	  			String firstName = Cnstnts.EMPTY_STRING;
	  			String lastName = Cnstnts.EMPTY_STRING;
				for(Iterator fieldsItr=dataFields.iterator(); fieldsItr.hasNext();){
					Field field = (Field)fieldsItr.next();
					if(field.getName().equals("FlowKey")){
						FlowKey = field.getValue();
					}
					if(field.getName().equals("CompanyName") 
							|| field.getName().equals("Names")
									|| field.getName().equals("FirstName")
											|| field.getName().equals("Firm")
													|| field.getName().equals("Emp_name")){
						if(this.getQueryClass().equals("Attorney")){
							if(field.getName().equals("Firm")){
								fiedlValue1 = field.getValue();
							}
						} else {
							fiedlValue1 = field.getValue();
						}
						if(field.getName().equals("FirstName")){
							firstName = field.getValue();
						}
					}
					if(field.getName().equals("Contact") 
							|| field.getName().equals("CompanyReq")
									|| field.getName().equals("LastName")
											|| field.getName().equals("EngName")){
						fiedlValue2 = field.getValue();
						if(field.getName().equals("LastName")){
							lastName = field.getValue();
						}
					}
					if(field.getName().equals("Tel1") 
							|| field.getName().equals("TelNo")
									|| field.getName().equals("Nationality")
											|| field.getName().equals("Email")){
						fiedlValue3 = field.getValue();
					}
					if(field.getName().equals("Address1") 
							|| field.getName().equals("Address")
									|| field.getName().equals("RegisterAddress")){
						if(this.getQueryClass().equals("Employee")){
							if(field.getName().equals("RegisterAddress")){
								fiedlValue4 = field.getValue();
							}
						} else {
							if(!field.getName().equals("RegisterAddress")){
								fiedlValue4 = field.getValue();
							}
						}
					}
				}
				if(this.getQueryClass().equals("Attorney")){
					fiedlValue2 = lastName + firstName;
				}
				printValue =  "<td>"+fiedlValue1+"</td>";
				printValue += "<td>"+fiedlValue2+"</td>";
				printValue += "<td>"+fiedlValue3+"</td>";
				printValue += "<td>"+fiedlValue4+"</td>";
				if(i%2==0){
					bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
				} else {
					bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
				}
				String onClick = " onClick='window.close()";
				if(this.QueryClass.getValue().equals("Client")){
					onClick += ";opener.input.client.value=\""+FlowKey+"\"";
					onClick += ";opener.input.clientName.value=\""+fiedlValue1+"\"";
				}
				if(this.QueryClass.getValue().equals("Applicant")){
					onClick += ";opener.input.applicantId.value=\""+FlowKey+"\"";
					onClick += ";opener.input.applicantName.value=\""+fiedlValue1+"\"";
				}
				if(this.QueryClass.getValue().equals("Inventors")){
					onClick += ";opener.input.inventor.value=\""+FlowKey+"\"";
					onClick += ";opener.input.inventorName.value=\""+fiedlValue1+"\"";
				}
				if(this.QueryClass.getValue().equals("TrademarkInventor")){
					onClick += ";opener.input.inventor.value=\""+FlowKey+"\"";
					onClick += ";opener.input.inventorName.value=\""+fiedlValue1+"\"";
				}
				if(this.QueryClass.getValue().equals("Attorney")){
					onClick += ";opener.input.attorney.value=\""+FlowKey+"\"";
					onClick += ";opener.input.attorneyName.value=\""+fiedlValue1+"\"";
				}
				if(this.QueryClass.getValue().equals("Employee")){
					onClick += ";opener.input.inventorId.value=\""+FlowKey+"\"";
					onClick += ";opener.input.chineseName.value=\""+fiedlValue1+"\"";
					onClick += ";opener.input.englishName.value=\""+fiedlValue2+"\"";
					onClick += ";opener.input.email.value=\""+fiedlValue3+"\"";
					onClick += ";opener.input.address.value=\""+fiedlValue4+"\"";
				}
				if(this.QueryClass.getValue().equals("DraftRecommend")
						|| this.getQueryClass().equals("DraftAssignExaminer")){
					Employee emp = new Employee(FlowKey);
					onClick += ";opener.input.empId.value=\""+emp.getFlowKey()+"\"";
					onClick += ";opener.input.groupType.value=\""+emp.getGroupType()+"\"";
					onClick += ";opener.input.name.value=\""+emp.getEmp_name()+"\"";
					onClick += ";opener.input.central.value=\""+emp.getMedicalCenter()+"\"";
					onClick += ";opener.input.institution.value=\""+emp.getResearchCenter()+"\"";
					onClick += ";opener.input.phone.value=\""+emp.getTel_no()+"\"";
					onClick += ";opener.input.title.value=\""+emp.getTitle()+"\"";
					onClick += ";opener.input.dept.value=\""+emp.getDept_id()+"\"";
					onClick += ";opener.input.email.value=\""+emp.getEmail()+"\"";
					onClick += ";opener.input.address.value=\""+emp.getAddress()+"\"";
				}
				onClick += "'";
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
