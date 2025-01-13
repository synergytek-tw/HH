package deepspot.main;

import java.util.Iterator;

import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.QueryBean;
import deepspot.util.Util;

public class FlowQuery extends QueryBean{

	public FlowQuery() throws Exception {this.init();}
	
	public Field DateFrom;
    public void setDateFrom(String DateFrom){this.DateFrom.setValue(DateFrom);}
    public String getDateFrom(){return this.DateFrom.getValue();}

    public Field DateTo;
    public void setDateTo(String DateTo){this.DateTo.setValue(DateTo);}
    public String getDateTo(){return this.DateTo.getValue();}
    
    public Field ApplicantName;
    public void setApplicantName(String ApplicantName){this.ApplicantName.setValue(ApplicantName);}
    public String getApplicantName(){return this.ApplicantName.getValue();}
    
    public Field FlowName;
    public void setFlowName(String FlowName){this.FlowName.setValue(FlowName);}
    public String getFlowName(){return this.FlowName.getValue();}
    
    public void init() throws Exception {
        super.init();
        this.setProgramId("jsp.FlowQuery");

        this.DateFrom = new Field("DateFrom","FlowQuery");
        
        this.DateTo = new Field("DateTo","FlowQuery");
        
        this.ApplicantName = new Field("ApplicantName","FlowQuery");
        
        this.FlowName = new Field("FlowName","FlowQuery");
    }

    public String printMainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if(this.DateFrom.getValue().trim().length()==0){
        	this.DateFrom.setValue(Util.getDate());
        }
        if(this.DateTo.getValue().trim().length()==0){
        	this.DateTo.setValue(Util.getDate());
        }
        this.DateTo.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        
        this.DateFrom.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);
        this.DateFrom.setAnotherField(this.DateTo);
        rtnString += this.printHtml(this.DateFrom);
        
        this.ApplicantName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        
        this.FlowName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
        this.FlowName.setAnotherField(this.ApplicantName);
        rtnString += this.printHtml(this.FlowName);
        	
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
  			rtnString += newLine+"  <tr><td align='center' colspan='6'>"+
  				"<font size='3'><b>"+this.getUserInfo().getMsg("jsp.FlowQuery.title")+"</b></font></td></tr>";
		
  			String fieldNames1=this.getUserInfo().getMsg("jsp.menu.flowKey");
  			String fieldNames2=this.getUserInfo().getMsg("jsp.menu.flowName");
  			String fieldNames3=this.getUserInfo().getMsg("jsp.menu.createTime");
  			String fieldNames4=this.getUserInfo().getMsg("jsp.menu.applicant");
  			String fieldNames5=this.getUserInfo().getMsg("jsp.menu.step");
  			String fieldNames6=this.getUserInfo().getMsg("jsp.menu.finish");
		
  			rtnString += newLine + "<tr"+this.getThBgcolor()+">";
  			rtnString += "<td align='center' width='15%'>"+fieldNames1+"</td>";
  			rtnString += "<td align='center' width='50%'>"+fieldNames2+"</td>";
  			rtnString += "<td align='center' width='12%'>"+fieldNames3+"</td>";
  			rtnString += "<td align='center' width='15%'>"+fieldNames4+"</td>";
  			rtnString += "<td align='center' width='4%'>"+fieldNames5+"</td>";
  			rtnString += "<td align='center' width='4%'>"+fieldNames6+"</td>";
  			rtnString += newLine + "</tr>";
  			
  			String andStr = Cnstnts.EMPTY_STRING;
  			if(this.ApplicantName.getValue().trim().length()>0){
  				andStr = " and Applicant_name like '%"+this.ApplicantName.getValue()+"%'";
  			}
  			if(this.FlowName.getValue().trim().length()>0){
  				andStr = " and Flow_name like '%"+this.FlowName.getValue()+"%'";
  			}
		
  			String SQL = "select * from Flow where FlowKey in("+
  							"select FlowKey from Flow_detail "+
  							"where Signer_id='"+this.getUserInfo().getAttribute("emp_id")+"' "+
  								  "and Signed_time between '"+this.DateFrom.getValue()+" 00:00:00' and '"+
  								  this.DateTo.getValue()+" 23:59:59')"+andStr;
  			int i=0;
  			String bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
  			String printValue = Cnstnts.EMPTY_STRING;
  			for(Iterator itr=new Flow().getSQLList(SQL);itr.hasNext();i++){
  				Flow f = (Flow)itr.next();
				printValue =  "<td align='center'>"+f.FlowKey+"</td>";
				printValue += "<td align='left'>"+f.Flow_name+"</td>";
				printValue += "<td align='center'>"+f.Create_time+"</td>";
				printValue += "<td align='center'>"+f.Applicant_name+"</td>";
				printValue += "<td align='center'>"+f.Total_steps+"</td>";
				printValue += "<td align='center'>"+f.Finished_steps+"</td>";
				if(i%2==0){
					bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
				} else {
					bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
				}
				String onClick = " onClick='openAppendix(\""+f.getForm_tableName()+".jsp"+
				 						   "?_getDataFlag=true&_dbActionMode=sign&_modeLockFlag=true"+
				 						   "&_pageActionMode=maintain&_flowKey="+f.getFlowKey()+
				 						   "\",\"BudgetTransDetail\",900,600)'";
				rtnString += "<tr style='cursor:hand'"+bgColor+onClick+">"+printValue+"</tr>";
			}
  			if(i==0){
  				rtnString += "<tr "+bgColor+"><td colspan=6 align=center>"+this.getUserInfo().getMsg("jsp.common.noRecords")+"</td></tr>";
  			}
	  		rtnString+=newLine+"</table>";
  		}
		return rtnString;
    }

}