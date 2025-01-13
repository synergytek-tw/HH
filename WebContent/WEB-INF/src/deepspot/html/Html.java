package deepspot.html;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.SelectItem;
import deepspot.main.Category;
import deepspot.main.Employee;
import deepspot.main.Flow;
import deepspot.main.FlowEngin;
import deepspot.main.Flow_detail;
import deepspot.main.Program;
import deepspot.main.UserBean;

public class Html {
	
	private static String tableBgcolor = Cnstnts.DEFAULT_TABLE_BGCOLOR;
	private static String thBgcolor = Cnstnts.DEFAULT_TH_BGCOLOR;
	private static String tr1 = Cnstnts.DEFAULT_TR_BGCOLOR_1;
	private static String tr2 = Cnstnts.DEFAULT_TR_BGCOLOR_2;
	
	public static String printTag(Field field, UserBean userInfo) throws Exception{
		String rtnString=Cnstnts.EMPTY_STRING;
		String readonly=Cnstnts.EMPTY_STRING;
		if(field.getOnClick()==null){
			field.setOnClick(Cnstnts.EMPTY_STRING);
		}
		if(field.getHtmlType().equals(Cnstnts.HTML_TAG_TEXT)){
			if(field.getMapingPrpt()==null){
				readonly=" readonly";
				if(field.canEdit() && !field.readonly()){
					readonly=field.printLength()+field.printOnDblClick();
					if(field.getDbType().equals(Cnstnts.DB_TYPE_INT)){
						readonly+=" onChange='checkNumber(\""+field.getTagName()+"\")'";
					}
					if(field.getDbType().equals(Cnstnts.DB_TYPE_FLOAT)){
						readonly+=" onChange='checkFloat(\""+field.getTagName()+"\")'";
					}
				} 
				rtnString="<input type='text'"+field.printSize()+field.printLength()+
						  field.printName()+field.printValue()+field.printOnChange()+
						  field.printOnClick()+readonly+"/>";  
			} else {
				String mapingValue = Cnstnts.EMPTY_STRING;
				if(field.getMapingPrptValue()!=null){
					mapingValue = "-"+field.getMapingPrptValue();
				}
				rtnString=field.printHiddenTag()+
						  "<input type='text'"+field.printSize()+field.printLength()+
						  " value='"+field.getValue()+mapingValue+"' readonly/>";
			}
		} else
		if(field.getHtmlType().equals(Cnstnts.HTML_TAG_TEXTAREA)){
			readonly=" readonly";
			if(field.canEdit() && !field.readonly()){
				readonly=" title='"+userInfo.getMsg("jsp.Flow.DblClick")+"'" +
	              		 " onDblClick=\"openPhrase('"+field.getTagName()+"')\"" +
	              		 field.printLength()+field.printOnChange();
			}
			rtnString="<textarea"+field.printName()+
			  		  field.printRows()+field.printCols()+readonly+">"+
			  		  field.getValue()+"</textarea>";
		} else
		if(field.getHtmlType().equals(Cnstnts.HTML_TAG_RADIO)){
			String checked_Y = Cnstnts.EMPTY_STRING;
			if(field.getValue().equals("Y")){
				checked_Y = " checked";
			}
			String checked_N = Cnstnts.EMPTY_STRING;
			if(field.getValue().equals("N")){
				checked_N = " checked";
			}
			rtnString="<input type='radio' value='Y'"+field.printName()+checked_Y+"/>";
			rtnString+=userInfo.getMsg("jsp.common.Radio.Yes");
			rtnString+="&nbsp;&nbsp;&nbsp;<input type='radio' value='N'"+field.printName()+checked_N+"/>";
			rtnString+=userInfo.getMsg("jsp.common.Radio.No");
		} else
		if(field.getHtmlType().equals(Cnstnts.HTML_TAG_OPEN_CALENDAR)){
			readonly=" size='10' readonly";
			if(field.canEdit()){
				readonly+=" onClick='openCalendar(\""+field.getTagName()+"\")'";
			}
			rtnString="<input type='text'"+
						field.printName()+field.printValue()+readonly+"/>";
		} else
		if(field.getHtmlType().equals(Cnstnts.HTML_TAG_OPEN_DATETIME)){
			readonly=" size='16' readonly";
			if(field.canEdit()){
				readonly+=" onClick='openDateTime(\""+field.getTagName()+"\")'";
			}
			rtnString="<input type='text'"+
						field.printName()+field.printValue()+readonly+"/>";
		} else
		if(field.getHtmlType().equals(Cnstnts.HTML_TAG_OPEN_DATETIME1)){
			readonly=" size='16' readonly";
			if(field.canEdit()){
				readonly+=" onClick='openDateTime1(\""+field.getTagName()+"\")'";
			}
			rtnString="<input type='text'"+
						field.printName()+field.printValue()+readonly+"/>";
		} else
		if(field.getHtmlType().equals(Cnstnts.HTML_TAG_OPEN_DATETIME2)){
			readonly=" size='16' readonly";
			if(field.canEdit()){
				readonly+=" onClick='openDateTime2(\""+field.getTagName()+"\")'";
			}
			rtnString="<input type='text'"+
						field.printName()+field.printValue()+readonly+"/>";
		} else	
		if(field.getHtmlType().equals(Cnstnts.HTML_TAG_OPEN_UPLOAD)){
			readonly=" size='50' readonly";
			if(field.canEdit()){
				String onClick = " onClick='openUpload(\""+field.getTagName()+"\",\"Document/"+
	  					field.getTableName()+"/"+userInfo.getAttribute("emp_id")+"\",\"\")'";
				readonly += onClick;
				field.setBeforeText("<img src='img/clip.jpg' "+onClick+"/>");
			}
			rtnString=Cnstnts.NEW_LINE+"      <input type='text'"+
			  			field.printName()+field.printValue()+readonly+"/>";
			if(field.getValue().trim().length()>0){
				rtnString+="<input type='button' value='"+userInfo.getMsg("jsp.common.openFile")+
				  			 "' onClick='openAppendix(\""+field.getValue()+"\",\"openAppendix\",600,400)'/>";
				if(field.canEdit()){
					rtnString+="<input type='button' "+
								"value='"+userInfo.getMsg("jsp.common.clearFile")+"' "+
								"onClick='document.input."+field.getTagName()+".value=\"\"'/>";
				}
			}
		} else
		if(field.getHtmlType().equals(Cnstnts.HTML_TAG_OPEN_UPLOAD2)){
			readonly=" size='50' readonly";
			if(field.canEdit()){
				String onClick = " onClick='"+field.getOnClick()+"openUpload2(\""+field.getTagName()+"\",\"Document/"+
	  							field.getTableName()+"/"+userInfo.getAttribute("emp_id")+"\",\"\")'";
				readonly += onClick;
				field.setBeforeText("<img src='img/clip.jpg' "+onClick+"/>");
			}
			rtnString=Cnstnts.NEW_LINE+"      <input type='text'"+
			  			field.printName()+field.printValue()+readonly+"/>";
			if(field.getValue().trim().length()>0){
				rtnString+="<input type='button' value='"+userInfo.getMsg("jsp.common.openFile")+
				  			 "' onClick='openAppendix(\""+field.getValue()+"\",\"openAppendix\",600,400)'/>";
				if(field.canEdit()){
					rtnString+="<input type='button' "+
								"value='"+userInfo.getMsg("jsp.common.clearFile")+"' "+
								"onClick='document.input."+field.getTagName()+".value=\"\"'/>";
				}
			}
		} else
		if(field.getHtmlType().equals(Cnstnts.HTML_TAG_CHECKBOX)){
			readonly=Cnstnts.EMPTY_STRING;
			if(field.canEdit()){
				readonly=field.printOnClick();
				if(field.getValue().equals("Y")){
					readonly+=" checked";
				}
				rtnString="<input type='checkbox' value='Y'"+
				  			field.printName()+readonly+"/>";
			} else {
				readonly="img/cross.gif";
				if(field.getValue().equals("Y")){
					readonly="img/tick.gif";
				}
				rtnString=field.printHiddenTag()+"<img src='"+readonly+"'/>";
			}
		} else
		if(field.getHtmlType().equals(Cnstnts.HTML_TAG_SELECT_ONE)){
			if(field.canEdit()){
				rtnString=Cnstnts.NEW_LINE+"      <select"+field.printName()+field.printOnChange()+">";
				rtnString+=Cnstnts.NEW_LINE+"        <option value=''>"+
				  			 userInfo.getMsg("jsp.account.select")+"</option>";
				if(field.getSelectList()!=null && field.getSelectList().size()>0){
					int i=0;
					for(Iterator<?> itr=field.getSelectList().iterator();itr.hasNext();i++){
						SelectItem selectItem = (SelectItem)itr.next();
						String selected = Cnstnts.EMPTY_STRING;
						/*if(field.getValue().trim().length()==0 && field.checkEmpty() && i==0){
							selected = " selected";
							field.setValue(selectItem.getValue());
						} else*/ 
						if(selectItem.getKey().equals(field.getValue())){
							selected = " selected";
						}
						rtnString+=Cnstnts.NEW_LINE+"        "+
						  			 "<option value='"+selectItem.getKey()+"'"+selected+">"+
						  			 selectItem.getValue()+"</option>";
					}
				}
				rtnString+=Cnstnts.NEW_LINE+"      </select>";
			} else {
				if(field.getSelectList()==null || field.getSelectList().size()==0){
					rtnString="<input type='text'"+field.printSize()+
					  			field.printName()+field.printValue()+" readonly/>";
				} else {
					String itemName=Cnstnts.EMPTY_STRING;
					for(Iterator<?> itr=field.getSelectList().iterator();itr.hasNext();){
						SelectItem selectItem = (SelectItem)itr.next();
						if(selectItem.getKey().equals(field.getValue())){
							itemName = selectItem.getValue();
							break;
						}
					}
					rtnString="<input type='text'"+field.printSize()+" value='"+itemName+
					  			"' readonly/>"+field.printHiddenTag();
				}
			}
		} else 
		if(field.getHtmlType().equals(Cnstnts.HTML_TAG_PASSWORD)){
			readonly=" readonly";
			if(field.canEdit()){
				readonly = Cnstnts.EMPTY_STRING;
			}
			rtnString="<input type='password'"+field.printSize()+field.printLength()+
						field.printName()+field.printValue()+readonly+"/>";
		} else {
			rtnString=field.printHiddenTag();
		}
		return field.getBeforeText()+rtnString+field.getAfterText()+field.printButtonTag();
	}
	 
	public static String getAlias(Field field, UserBean userInfo) throws Exception{
		if(field.getAliasName()==null || field.getAliasName().trim().length()==0){
			return userInfo.getMsg("jsp."+field.getTableName()+"."+field.getName());
		} else {
			return field.getAliasName();
		}
	}
	
	public static String getHelpImg(String helpUrl, UserBean userInfo) throws Exception{
		return "<img src='img/help.jpg' style='cursor: hand' " +
			   "title='" + userInfo.getMsg("jsp.common.help") + "' " +
			   "onClick='openAppendix(\""+helpUrl+"\",\"openHelp\",800,800)'/>";
	}
	
	public static String getPrintBtn(String outputFile, UserBean userInfo) throws Exception{
		return "<input type='button' style='cursor: hand' " + 
			   "value='"+userInfo.getMsg("jsp.common.printPDF")+"' "+
			   "onClick='printPdf(\""+outputFile+"\")'/>";
	}
	
	public static String getReflashImg(UserBean userInfo) throws Exception{
		/*
		return "<img src='img/reflash.jpg' style='cursor: hand' border='0' " + 
	           "title='" + userInfo.getMsg("jsp.common.reflash") + "' " +
	           "onClick='setValue()'/>";
		*/
		return "<input type='button' style='cursor: hand' " + 
        	   "title='" + userInfo.getMsg("jsp.common.reflash.title") + "' " +
        	   "value='"+ userInfo.getMsg("jsp.common.reflash") +"' " +
        	   "onClick='setValue()'/>";
	}
	
	public static String getPrintImg(UserBean userInfo) throws Exception{
		/*
		return "<img src='img/Print-Active.gif' style='cursor: hand' border='0' " + 
	           "title='" + userInfo.getMsg("jsp.common.print") + "' " +
	           "onClick='window.print()'/>";
	    */
		return "<input type='button' style='cursor: hand' " + 
 	   		   "title='" + userInfo.getMsg("jsp.common.print.title") + "' " +
 	   		   "value='"+ userInfo.getMsg("jsp.common.print") +"' onClick='window.print()'/>";
	}
	
	public static String getBackImg(UserBean userInfo) throws Exception{
		return "<img src='img/back.png' style='cursor: hand' border='1' " + 
		       "title='" + userInfo.getMsg("jsp.common.back") + "' " +
		       "onClick='window.history.back()'/>";
	}

	public static String getSearchModeImg(UserBean userInfo) throws Exception {
		/*
		return "<img src='img/search02.gif' style='cursor: hand' border='1' " + 
			   "title='" + userInfo.getMsg("jsp.common.serchMode") + "' " + 
			   "onClick='document.input.pageActionMode.value=\""+Cnstnts.SEARCH+"\";" + 
			   "document.input.clearFlag.value=\"true\";setValue()'/>";
		*/
		return "<input type='button' style='cursor: hand' " + 
 		   	   "value='"+ userInfo.getMsg("jsp.common.serchMode") +"' "+
 		   	   "onClick='document.input.pageActionMode.value=\""+Cnstnts.SEARCH+"\";" + 
 		   	   			"document.input.clearFlag.value=\"true\";"+
 		   	   			"document.input.doSearchFlag.value=\"true\";setValue()'/>";
	}

	public static String getMaintainModeImg(UserBean userInfo) throws Exception {
		/*
		return "<img src='img/image013.png' style='cursor: hand' border='1' " + 
			   "title='" + userInfo.getMsg("jsp.common.operateMode") + "' " + 
			   "onClick='document.input.pageActionMode.value=\""+Cnstnts.MAINTAIN+"\";setValue()'/>";
		*/
		return "<input type='button' style='cursor: hand' " + 
	   	   	   "value='"+ userInfo.getMsg("jsp.common.operateMode") +"' "+
	   	   	   "onClick='document.input.pageActionMode.value=\""+Cnstnts.MAINTAIN+"\";"+
	   	   	   			"document.input.dbActionMode.value=\"insert\";"+
	   	   	   			"document.input.clearFlag.value=\"true\";setValue()'/>";
	}

	public static String getForwardImg(UserBean userInfo) throws Exception {
		return "<img src='img/forward.png' style='cursor: hand' border='1' " + 
			   "title='" + userInfo.getMsg("jsp.common.forward") + "' " +
			   "onClick='window.history.forward()'/>";
	}

	public static String getClearBtn(UserBean userInfo) throws Exception {
		return "<input type='button' style='cursor: hand' " +
		  	   "value='" + userInfo.getMsg("jsp.common.clear")+"' " +
		  	   "onClick='this.disabled=true;document.input.clearFlag.value=\"true\";setValue()'/>";
	}

	public static String getSubmitBtn(UserBean userInfo, String dbActionMode) throws Exception {
		String rtnString = Cnstnts.EMPTY_STRING;
		String BtnValue = Cnstnts.EMPTY_STRING;
		
		if(dbActionMode.equals(Cnstnts.INSERT)){
			BtnValue = userInfo.getMsg("jsp.common.Insert");
		}
		if(dbActionMode.equals(Cnstnts.UPDATE)){
			BtnValue = userInfo.getMsg("jsp.common.Update");
		}
		if(dbActionMode.equals(Cnstnts.DELETE)){
			BtnValue = userInfo.getMsg("jsp.common.Delete");
		}
		if(dbActionMode.equals(Cnstnts.PRINT)){
			BtnValue = userInfo.getMsg("jsp.common.makePrintFile");
		}
		if(BtnValue.trim().length()>0){
			rtnString = "<input type='button' style='cursor: hand' " +
			   			"value='" + BtnValue +"' " +
			   			"onClick='this.disabled=true;setSubmitValue(\""+dbActionMode+"\")'/>";
		}
		
		if(Cnstnts.INSERT.equals(dbActionMode)){
			rtnString += "<input type='button' style='cursor: hand' "+
						 "value='" + userInfo.getMsg("jsp.common.keepInsert")+"' " +
						 "onClick='document.input.keepProcessFlag.value=\"true\";"+
						 "this.disabled=true;setSubmitValue(\""+dbActionMode+"\")'/>";
		}
		return rtnString;
	}
	
	public static String getSubmitBtn(UserBean userInfo, String dbActionMode, String btnValue) throws Exception {
		String BtnValue = Cnstnts.EMPTY_STRING; 
		if(dbActionMode.equals(Cnstnts.INSERT)){
			BtnValue = userInfo.getMsg("jsp.common.Execute");
		}
		if(dbActionMode.equals(Cnstnts.UPDATE)){
			BtnValue = userInfo.getMsg("jsp.common.Execute");
		}
		if(dbActionMode.equals(Cnstnts.DELETE)){
			BtnValue = userInfo.getMsg("jsp.common.Execute");
		}
		if(dbActionMode.equals(Cnstnts.PRINT)){
			BtnValue = userInfo.getMsg("jsp.common.makePrintFile");
		}
		if(btnValue!=null && btnValue.trim().length()>0){
			BtnValue = btnValue;
		}
		String rtnString = "<input type='button' style='cursor: hand' " +
		   				   "value='" + BtnValue + "' " +
		   				   "onClick='this.disabled=true;setSubmitValue(\""+dbActionMode+"\")'/>";
		return rtnString;
	}
	
	public static String getDetailSubmitBtn(UserBean userInfo, String dbActionMode) throws Exception {
		String rtnString = "<input type='button' style='cursor: hand' " +
		   				   "value='" + userInfo.getMsg("jsp.common.submit")+"' " +
		   				   "onClick='this.disabled=true;setSubmitValue(\""+dbActionMode+"\")'/>";
		return rtnString;
	}
	
	public static String getSubmitBtn(String dbActionMode, String valutText) throws Exception {
		String rtnString = "<input type='button' style='cursor: hand' value='" + valutText +"' "+
		   				   "onClick='this.disabled=true;setSubmitValue(\""+dbActionMode+"\")'/>";
		return rtnString;
	}

	public static String getCloseBtn(UserBean userInfo) throws Exception {
		return "<input type='button' " +
		 	   "value='"+userInfo.getMsg("jsp.closeForm.close")+"' " +
		 	   "onClick='this.disabled=true;document.input.submitFlag.value=\"true\";setValue()'/>";
	}

	public static String getDoSearchImg(UserBean userInfo) throws Exception {
		/*
		return "<img src='img/C_Find_Sm_N.jpg' style='cursor: hand' border='1' " +
			   "title='" + userInfo.getMsg("jsp.common.doSerch")+"' " +
			   "onClick='this.disabled=true;document.input.doSearchFlag.value=\"true\";setValue()'/>";
		*/
		return "<input type='button' style='cursor: hand' " +
		   	   "value='" + userInfo.getMsg("jsp.common.doSerch") + "' " +
		   	   "onClick='this.disabled=true;document.input.doSearchFlag.value=\"true\";setValue()'/>";
	}
	
	public static String getFlowDetail(Field FlowKey, UserBean userInfo) throws Exception {
		StringBuffer strBfr = new StringBuffer();
		char newLine = Cnstnts.NEW_LINE;
		Vector<?> flowDetailVtr = new Flow(FlowKey.getValue()).getDetails();
		if(flowDetailVtr.size()>0){
			strBfr.append(newLine+"<br><table"+tableBgcolor+">");
			strBfr.append(newLine+"  <tr>");
			strBfr.append(newLine+"    <td colspan='7'>");
			strBfr.append(newLine+"      <B><font size='+1'>"+userInfo.getMsg("jsp.showFlow.title")+"</font></B>");
			strBfr.append(newLine+"    </td>");
			strBfr.append(newLine+"  </tr>");
			strBfr.append(newLine+"  <tr"+thBgcolor+">");
			strBfr.append(newLine+"    <td align='center' width='3%'>"+userInfo.getMsg("jsp.Flow_detail.Step")+"</td>");
			strBfr.append(newLine+"    <td align='center' width='20%'>"+userInfo.getMsg("jsp.Flow_detail.Step_name")+"</td>");
			strBfr.append(newLine+"    <td align='center' width='10%'>"+userInfo.getMsg("jsp.Flow_detail.Signer_name")+"</td>");
			strBfr.append(newLine+"    <td align='center' width='14%'>"+userInfo.getMsg("jsp.Flow_detail.Signed_time")+"</td>");
			strBfr.append(newLine+"    <td align='center' width='10%'>"+userInfo.getMsg("jsp.Flow_detail.Signed_result")+"</td>");
			strBfr.append(newLine+"    <td align='center' width='40%'>"+userInfo.getMsg("jsp.Flow_detail.Memo")+"</td>");
			strBfr.append(newLine+"    <td align='center' width='3%'>"+userInfo.getMsg("jsp.Flow_detail.Decided")+"</td>");
			strBfr.append(newLine+"  </tr>");
		}
		int i=0;
		for(Iterator<?> itr=new Flow_detail().getTimeOrderDetails(FlowKey.getValue()).iterator();itr.hasNext();i++){
			Flow_detail fd=(Flow_detail)itr.next();
			String trBgcolor=tr1;
			if(i%2==0) trBgcolor=tr2;
			String final_result = userInfo.getMsg("jsp.closeForm."+fd.getSigned_result());
			String imgStr = Cnstnts.EMPTY_STRING;
			if(fd.getDecided().equals("1")) imgStr="<img src='img/tick.gif'/>";
			strBfr.append(newLine+"  <tr"+trBgcolor+">");
			strBfr.append(newLine+"    <td align='center'>"+fd.getStep()+"</td>");
			strBfr.append(newLine+"    <td>"+fd.getStep_name()+"</td>");
			strBfr.append(newLine+"    <td align='center'>"+fd.getSigner_name()+"</td>");
			strBfr.append(newLine+"    <td align='center'>"+fd.getSigned_time()+"</td>");
			strBfr.append(newLine+"    <td align='center'>"+final_result+"</td>");
			strBfr.append(newLine+"    <td>"+fd.getMemo()+"</td>");
			strBfr.append(newLine+"    <td align='center'>"+imgStr+"</td>");
			strBfr.append(newLine+"  </tr>");
		}
		if(flowDetailVtr.size()>0){
			strBfr.append(newLine+"</table>");
		}
		return strBfr.toString();
	}
	
	public static String getSignForm(Field FlowKey, UserBean userInfo, 
									 String flowStepName) throws Exception {
		StringBuffer strBfr = new StringBuffer();
		Flow flow = new Flow(FlowKey.getValue());
		if(flow.getSigner_id().equals(userInfo.getAttribute("emp_id"))){
			char newLine=Cnstnts.NEW_LINE;
			strBfr.append(newLine+"<br><table"+tableBgcolor+">");
			strBfr.append(newLine+"  <tr>");
			strBfr.append(newLine+"    <td colspan='2'>");
			strBfr.append(newLine+"      <B><font size='3'>"+userInfo.getMsg("jsp.signForm.title")+
					"-"+flowStepName);
			if(!flow.getSigner_id().equals(flow.getSrcSigner_id())){
				Employee srcSigner = new Employee(flow.getSrcSigner_id());
				Category srcSignerJob = new Category(srcSigner.getTitle());
				strBfr.append(" ("+userInfo.getMsg("jsp.Flow_detail.SrcSigner_id")+" : "+
						srcSigner.Emp_name.getValue()+srcSignerJob.getNames()+")</font></B>");
				strBfr.append(newLine+"      <input type='button' value='" +
						userInfo.getMsg("jsp.Flow_detail.backToSrcSigner")+"' "+
						"onClick=\"document.input.backToSrcSigner.value='true';"+
						"document.input.submitFlag.value='true';setValue()\"/>");
			} else {
				strBfr.append("</font></B>");
			}
			strBfr.append(newLine+"    </td>");
			strBfr.append(newLine+"  </tr>");
			strBfr.append(newLine+"  <tr"+tr2+">");
			strBfr.append(newLine+"    <td align='center' valign='middle' colspan='2'>");
			strBfr.append(newLine+"      "+userInfo.getMsg("jsp.closeForm.reason"));
			strBfr.append(newLine+"      <textarea id='signMemo' name='signMemo' rows='4' cols='50' " +
					"title='"+userInfo.getMsg("jsp.Flow.DblClick")+"' " +
					"onDblClick=\"openPhrase('signMemo')\"></textarea>");
			strBfr.append(newLine+"    </td>");
			strBfr.append(newLine+"  </tr>");
			strBfr.append(newLine+"  <tr"+tr2+">");
			strBfr.append(newLine+"    <td align='center' colspan='2'>");
			strBfr.append(newLine+"      <input type='radio' id='agree' name='agree' value='1' checked/>");
			strBfr.append(newLine+"      "+userInfo.getMsg("jsp.signForm.agree"));
			strBfr.append(newLine+"      <input type='radio' id='agree' name='agree' value='0'/>");
			strBfr.append(newLine+"      "+userInfo.getMsg("jsp.signForm.reject"));
			Vector<?> vtr=flow.getDetails();
			boolean showBackSignerHtmlTag = false;
			for(Iterator<?> itr=vtr.iterator();itr.hasNext();){
				Flow_detail fd = (Flow_detail)itr.next();
				if(fd.getStep()>0 && flow.getFinished_steps()>fd.getStep()){
					showBackSignerHtmlTag = true;
				}
			}
			if(showBackSignerHtmlTag){
				strBfr.append(newLine+"      <input type='radio' id='agree' name='agree' value='2'/>");
				strBfr.append(newLine+"      "+userInfo.getMsg("jsp.signForm.backSigner"));
				strBfr.append(newLine+"      <select id='backStep' name='backStep'>");
				int lastStep = 0;
				for(Iterator<?> itr=new Flow_detail().getTimeOrderDetails(FlowKey.getValue()).iterator();itr.hasNext();){
					Flow_detail fd = (Flow_detail)itr.next();
					if(fd.getStep()>0 && fd.getStep()>lastStep){
						String selected = Cnstnts.EMPTY_STRING;
						if(!itr.hasNext()){
							selected = " selected";
						}
						strBfr.append(newLine+"        <option value='"+fd.getStep()+"-"+
																		fd.getSigner_id()+"-"+
																		fd.getSigner_name()+fd.getSigner_title()+"'"+selected+">"+
								fd.getStep()+"-"+fd.getStep_name()+"</option>");
					}
					if(lastStep<fd.getStep()){
						lastStep = fd.getStep();
					}
				}
				strBfr.append(newLine+"      </select>");
			}
			
			if(FlowEngin.getDecideFlag(FlowKey.getValue())){
				strBfr.append(newLine+"      <input type='checkBox' id='decide' name='decide' value='1'/>");
				strBfr.append(newLine+"      "+userInfo.getMsg("jsp.signForm.decide"));
			}
			strBfr.append(newLine+"      <input type='button' value='" + userInfo.getMsg("jsp.signForm.approve")+"' "+
					"onClick=\"this.disabled=true;document.input.submitFlag.value='true';setValue()\"/>");
			strBfr.append(newLine+"    </td>");
			strBfr.append(newLine+"  </tr>");
			strBfr.append(newLine+"</table>");
		}
		return strBfr.toString();
	}
	
	public static String getCloseForm(Field FlowKey, UserBean userInfo,
									  String programId) throws Exception {
		StringBuffer strBfr = new StringBuffer();
		Flow flow = new Flow(FlowKey.getValue());
		if(flow.getCloser_id().equals(userInfo.getAttribute("emp_id"))
				&& Cnstnts.APPROVE.equals(flow.getStatus())
						&& new Program(programId).closeCanReject()){
			char newLine=Cnstnts.NEW_LINE;
			strBfr.append(newLine+"<br><table"+tableBgcolor+">");
			strBfr.append(newLine+"  <tr>");
			strBfr.append(newLine+"    <td colspan='3'>");
			strBfr.append(newLine+"      <B><font size='3'>"+userInfo.getMsg("jsp.closeForm.title")+"</font></B>");
			strBfr.append(newLine+"    </td>");
			strBfr.append(newLine+"  </tr>");
			strBfr.append(newLine+"  <tr"+tr2+">");
			strBfr.append(newLine+"    <td align='right' width='20%'>");
			strBfr.append(newLine+"      "+userInfo.getMsg("jsp.closeForm.reason"));
			strBfr.append(newLine+"    </td>");
			strBfr.append(newLine+"    <td width='60%'>");
			strBfr.append(newLine+"      <textarea id='rejectReason' name='rejectReason' rows='3' cols='50'></textarea>");
			strBfr.append(newLine+"    </td>");
			strBfr.append(newLine+"    <td width='20%'>");
			strBfr.append(newLine+"      <input type='button' value='" + userInfo.getMsg("jsp.closeForm.reject") + 
					"' onClick=\"this.disabled=true;document.input.closeReject.value='true';" +
					"document.input.submitFlag.value='true';setValue()\"/>");
			strBfr.append(newLine+"    </td>");
			strBfr.append(newLine+"  </tr>");
			strBfr.append(newLine+"</table>");
		}
		return strBfr.toString();
	}
	
	public static String getEditImg(UserBean userInfo, int record) throws Exception {
		return "<img src='img/edit2.gif' style='cursor: hand' "+
			 		"title='"+userInfo.getMsg("jsp.Flow.edit")+"' "+
			 		"onClick='openDetail(\"update\",\""+record+"\")'>";
	}
	
	public static String getInsertImg(UserBean userInfo) throws Exception {
		return "<img src='img/addanchr.gif' style='cursor: hand' "+
					"title='"+userInfo.getMsg("jsp.Flow_detail.addNew")+"' "+
					"onClick='openDetail(\"insert\",\"0\")'>";
	}
	
	public static String getDeleteImg(UserBean userInfo) throws Exception {
		return "<img src='img/C_Delete_Md_N.png' style='cursor: hand' "+
					"title='"+userInfo.getMsg("jsp.usersDetail.delete")+"' "+
					"onClick='document.input.deleteDetail.value=\"true\";setValue()'>";
	}
	
	public static String getDeleteCheckbox(UserBean userInfo,int record) throws Exception {
		return "<input type='checkbox' id='delete' name='delete' value='"+record+"' "+
					  "title='"+ userInfo.getMsg("jsp.usersDetail.delete2")+"'>";
	}
	
	public static String getJavaScriptFunction(String tableName) throws Exception {
		char newLine = Cnstnts.NEW_LINE;
		String rtnString = newLine+"<script>";
		rtnString += newLine+"function openDetail(dbActionMode,recordIndex){";
		rtnString += newLine+"  var frameWidth=document.getElementById('functionBar').offsetWidth;";
		rtnString += newLine+"  var showDiv=document.getElementById('showDetail');";
		rtnString += newLine+"  var srcUrl='"+tableName+"_detail.jsp?_actionMode='+dbActionMode+"+
							 "'&_recordIndex='+recordIndex+'&_firstFlag=true';";
		rtnString += newLine+"  showDiv.innerHTML=\"<iframe id='detailFrame' "+
									"src='\"+srcUrl+\"' height='120' width='\"+(frameWidth-10)+\"'></iframe>\";";
		rtnString += newLine+"}";
		rtnString += newLine+"function closeDetail(){";
		rtnString += newLine+"  var showDiv=document.getElementById('showDetail');";
		rtnString += newLine+"  showDiv.innerHTML='';";
		rtnString += newLine+"}";
		rtnString += newLine+"</script>";
		return rtnString;
	}
	
	public static String getJavaScriptFunction(String tableName,int height) throws Exception {
		char newLine = Cnstnts.NEW_LINE;
		String rtnString = newLine+"<script>";
		rtnString += newLine+"function openDetail(dbActionMode,recordIndex){";
		rtnString += newLine+"  var frameWidth=document.getElementById('functionBar').offsetWidth;";
		rtnString += newLine+"  var showDiv=document.getElementById('showDetail');";
		rtnString += newLine+"  var srcUrl='"+tableName+"_detail.jsp?_actionMode='+dbActionMode+"+
							 "'&_recordIndex='+recordIndex+'&_firstFlag=true';";
		rtnString += newLine+"  showDiv.innerHTML=\"<iframe id='detailFrame' "+
									"src='\"+srcUrl+\"' height='"+height+"' width='\"+(frameWidth-10)+\"'></iframe>\";";
		rtnString += newLine+"}";
		rtnString += newLine+"function closeDetail(){";
		rtnString += newLine+"  var showDiv=document.getElementById('showDetail');";
		rtnString += newLine+"  showDiv.innerHTML='';";
		rtnString += newLine+"}";
		rtnString += newLine+"</script>";
		return rtnString;
	}
	
	@SuppressWarnings("unchecked")
	public static String printTable(String titleXmlTag, List<List<Field>> fields, UserBean userInfo) throws Exception {
		if(fields==null || fields.size()==0){
			return Cnstnts.EMPTY_STRING;
		}
		char newLine = Cnstnts.NEW_LINE;
		String rtnString = newLine+"<br><table"+tableBgcolor+">";
		String headerText = userInfo.getMsg(titleXmlTag);
		String bodyText = Cnstnts.EMPTY_STRING;
		int i=0, colspan=0;
		String bgColor = Cnstnts.EMPTY_STRING;
		for(Iterator itr=fields.iterator();itr.hasNext();i++){
			List<Field> dataFields = (List<Field>)itr.next();
			if(i==0){
				bodyText += newLine+"<tr"+thBgcolor+">";
				for(Iterator dataItr=dataFields.iterator();dataItr.hasNext();){
					Field field = (Field)dataItr.next();
					if(field.showFlag()){
						colspan++;
						String thTitle = field.getAliasName();
						if(thTitle==null || thTitle.trim().length()==0){
							thTitle = userInfo.getMsg("jsp."+field.getTableName()+"."+field.getName());
						}
						bodyText += newLine+"  <td align='center'"+field.printListWidth()+"><b>"+thTitle+"</b></td>";
					}
				}
				bodyText += newLine+"</tr>";
			}
			if(i%2==0){
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
			} else {
				bgColor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
			}
			String LinkFlowKey1 = Cnstnts.EMPTY_STRING;
			String LinkFlowKey2 = Cnstnts.EMPTY_STRING;
			String LinkPage1 = Cnstnts.EMPTY_STRING;
			String LinkPage2 = Cnstnts.EMPTY_STRING;
			bodyText += newLine+"<tr"+bgColor+">";
			for(Iterator dataItr=dataFields.iterator();dataItr.hasNext();){
				Field field = (Field)dataItr.next();
				if(field.getName().equals("LinkFlowKey1")){
					LinkFlowKey1 = field.getValue();
				}
				if(field.getName().equals("LinkFlowKey2")){
					LinkFlowKey2 = field.getValue();
				}
				if(field.getName().equals("LinkPage1")){
					LinkPage1 = field.getValue();
				}
				if(field.getName().equals("LinkPage2")){
					LinkPage2 = field.getValue();
				}
				if(field.showFlag()){
					String tdText = field.getValue();
					String linkText = Cnstnts.EMPTY_STRING;
					if(field.linkFlag1() && LinkFlowKey1.trim().length()>0){
						String dbActionMode = Cnstnts.QUERY;
						if(field.getDbActionMode1().trim().length()>0){
							dbActionMode = field.getDbActionMode1();
						}
						String linkParameter = field.getLinkParameter1();
						if(linkParameter==null){
							linkParameter = Cnstnts.EMPTY_STRING;
						}
						if(field.getLinkMode1().equals(Cnstnts.OPEN_APPENDIX)){
							linkText = " style='cursor: hand' onClick='openAppendix(\""+
									   LinkPage1+".jsp?_flowKey="+LinkFlowKey1+
									   "&_dbActionMode="+dbActionMode+"&_getDataFlag=true"+
									   "&_pageActionMode=maintain"+linkParameter+
									   "\",\"openAppendix\",800,600)'";
						}
						if(field.getLinkMode1().equals(Cnstnts.HREF)){
							tdText = "<a href='"+LinkPage1+".jsp?_flowKey="+LinkFlowKey1+
									   "&_dbActionMode="+dbActionMode+"&_getDataFlag=true"+
									   "&_pageActionMode=maintain"+linkParameter+"'>"+tdText+"</a>";
						}
					}
					if(field.linkFlag2() && LinkFlowKey2.trim().length()>0){
						String dbActionMode = Cnstnts.QUERY;
						if(field.getDbActionMode2().trim().length()>0){
							dbActionMode = field.getDbActionMode2();
						}
						String linkParameter = field.getLinkParameter2();
						if(linkParameter==null){
							linkParameter = Cnstnts.EMPTY_STRING;
						}
						if(field.getLinkMode2().equals(Cnstnts.OPEN_APPENDIX)){
							linkText = " style='cursor: hand' onClick='openAppendix(\""+
									   LinkPage2+".jsp?_flowKey="+LinkFlowKey2+
									   "&_dbActionMode="+dbActionMode+"&_getDataFlag=true"+
									   "&_pageActionMode=maintain"+linkParameter+
									   "\",\"openAppendix\",800,600)'";
						}
						if(field.getLinkMode2().equals(Cnstnts.HREF)){
							tdText = "<a href='"+LinkPage2+".jsp?_flowKey="+LinkFlowKey2+
									   "&_dbActionMode="+dbActionMode+"&_getDataFlag=true"+
									   "&_pageActionMode=maintain"+linkParameter+"'>"+tdText+"</a>";
						}
					}
					if(field.getHtmlType().equals(Cnstnts.HTML_TAG_OPEN_UPLOAD) && tdText.trim().length()>0){
						tdText = "<input type='button' value='"+userInfo.getMsg("jsp.common.openFile")+
								 	  "' onClick='openAppendix(\""+tdText+"\",\"Appendix\",800,600)'/>";
					}
					bodyText += newLine+"  <td"+field.printAlign()+linkText+">"+tdText+"</td>";
				}
			}
			bodyText += newLine+"</tr>";
		}
		if(headerText.trim().length()>0){
			rtnString += newLine+"<tr><td colspan='"+colspan+"' align='center' style='font-size: 16;'><b>"+
						 headerText+"</b></td></tr>";
		}
		rtnString += bodyText;
		rtnString += newLine+"</table>";
		return rtnString;
	}
	 
}