<%@ include file="includePage/pageHeader.jsp" %>
<%
  String title=userInfo.getMsg("jsp.menu.title");
  String emp_id = userInfo.getAttribute("emp_id");
  String tr1 = Cnstnts.DEFAULT_TR_BGCOLOR_1;
  String tr2 = Cnstnts.DEFAULT_TR_BGCOLOR_2;
  String bgcolor = Cnstnts.DEFAULT_PAGE_BGCOLOR;
  String table_bgcolor = Cnstnts.DEFAULT_TABLE_BGCOLOR;
  String th_bgcolor = Cnstnts.DEFAULT_TH_BGCOLOR;
%>
<html>
  <%@ include file="includePage/htmlHeader.jsp" %>
  <body>
  <center>
<%
  Employee emp;
  int i=0;
  List signedManageList = new SignedManage().getSignedList(emp_id, userInfo);
  List ToDoList = new ToDos().getNotFinishedList(emp_id, userInfo);
  List noticeList = new Notice().getPersonalList(emp_id,userInfo.getAttribute("dept_id"));

  //temporary close
  Quotation quotation = new Quotation();
  List QuotationList = null;//quotation.getQu02List(emp_id, userInfo);
  List QuotationList2 = null;//quotation.getQu11List(emp_id, userInfo);
%>
<%/* Flow infos �  �������  */
  List<Flow> signingList=null;
  List<Flow> signedList=null;
  List<Flow> rejectList=null;
  List<Flow> wait2SignList=null;
  List<Flow> agentSignList=null;
  List<Flow> wait2CloseList=null;
  List<Flow> wait2PayList=null;
  int signingCount = 0;
  int signedCount = 0;
  int rejectCount = 0;
  int wait2SignCount = 0;
  int agentSignCount = 0;
  int wait2CloseCount = 0;
  int wait2PayCount = 0;
  int totalCount = 0;
  Flow flow = new Flow(emp_id);
  if(Cnstnts.TRUE_FLAG.equals(request.getParameter("removeSigned"))){
    String [] removeSignedItems = request.getParameterValues("removeSignedItem");
    if(removeSignedItems!=null && removeSignedItems.length>0){
      flow.updateCloseFlag(removeSignedItems);
    }%>
    <script>
      top.frames[2].frames[1].location.href='MenuInfo.jsp';
    </script>
<%}
  if(Cnstnts.TRUE_FLAG.equals(request.getParameter("removeReject"))){
    String [] removeRejectItems = request.getParameterValues("removeRejectItem");
    if(removeRejectItems!=null && removeRejectItems.length>0){
      flow.updateCloseFlag(removeRejectItems);
    }%>
    <script>
      top.frames[2].frames[1].location.href='MenuInfo.jsp';
    </script>
<%}
  if(Cnstnts.TRUE_FLAG.equals(request.getParameter("batchClose"))){
    String [] batchCloseItems = request.getParameterValues("batchCloseItem");
    if(batchCloseItems!=null && batchCloseItems.length>0){
      flow.updateCloseTime(batchCloseItems);
    }%>
    <script>
      top.frames[2].frames[1].location.href='MenuInfo.jsp';
    </script>
<%}
  if(Cnstnts.TRUE_FLAG.equals(request.getParameter("batchAgree"))){
    String [] batchAgreeItems = request.getParameterValues("batchAgreeItem");
    if(batchAgreeItems!=null && batchAgreeItems.length>0){
      flow.batchAgree(batchAgreeItems,userInfo);
    }%>
    <script>
      top.frames[2].frames[1].location.href='MenuInfo.jsp';
    </script>
<%}
  String whereStr = "where closer_id='"+emp_id+"' or signer_id='"+emp_id+"' or applicant_id='"+emp_id+"'";
  Iterator itr = flow.getList(whereStr);
  if(itr.hasNext()){
    while(itr.hasNext()){
      Flow f = (Flow)itr.next();
      /* �signing list ��� */
      if(f.getStatus().equals("signing") && f.getApplicant_id().equals(emp_id)){
        if(signingList == null){
          signingList = new ArrayList<Flow>();
        }
        signingList.add(f);
        signingCount++;
        totalCount++;
      }
      /* approve list �Ǫ�� */
      if(f.getStatus().equals("approve") && !f.getCloseFlag().equals("Y") && f.getApplicant_id().equals(emp_id)){
        if(signedList == null){
          signedList = new ArrayList<Flow>();
        }
        signedList.add(f);
        signedCount++;
        totalCount++;
      }
      /* reject list ��� */
      if(f.getStatus().equals("reject") && !f.getCloseFlag().equals("Y") && f.getApplicant_id().equals(emp_id)){
        if(rejectList == null){
          rejectList = new ArrayList<Flow>();
        }
        rejectList.add(f);
        rejectCount++;
        totalCount++;
      }
      /* wait to signing list ��ñ�֪�� */
      if(f.getStatus().equals("signing") && f.getSigner_id().equals(emp_id) && f.getSigner_id().equals(f.getSrcSigner_id())){
        if(wait2SignList == null){
          wait2SignList = new ArrayList<Flow>();
        }
        wait2SignList.add(f);
        wait2SignCount++;
        totalCount++;
      }
      /* replace֪ signing list */
      if(f.getStatus().equals("signing") && f.getSigner_id().equals(emp_id) && !f.getSigner_id().equals(f.getSrcSigner_id())){
        if(agentSignList == null){
          agentSignList = new ArrayList<Flow>();
        }
        agentSignList.add(f);
        agentSignCount++;
        totalCount++;
      }
      /* wait to close list �ɪ�� */
      if((f.getStatus().equals("approve") || f.getStatus().equals("reject")) 
                                 && f.getCloser_id().equals(emp_id) 
      													 && f.getClosed_time().trim().length()==0){
        if(wait2CloseList == null){
          wait2CloseList = new ArrayList<Flow>();
        }
        wait2CloseList.add(f);
        wait2CloseCount++;
        totalCount++;
      }
    }
  }
  /* wait to pay list */
  wait2PayList = flow.getWait2PayList(emp_id);
  wait2PayCount+=wait2PayList.size();
  totalCount+=wait2PayList.size();
%>
<%if(noticeList.size()==0 && ToDoList.size()==0 && totalCount==0){%>
    <jsp:forward page="calendar.jsp" />
<%}%>
<%
  boolean showAll = false;
  String showFlag = request.getParameter("showFlag");
  if(showFlag==null){
    showFlag = userInfo.getAttribute("showFlag");
  }
  if(showFlag==null){
	  	if(ToDoList.size()>0){
	        showFlag="ToDos";
	      }
	if(signedManageList.size()>0){
	      showFlag="SignedManage";
	    }
  	else if(QuotationList != null && QuotationList.size()>0){
        showFlag="Quotation";
      }
  	else if(QuotationList2 != null && QuotationList.size()>0){
        showFlag="Quotation2";
      }
  	else if(wait2SignCount>0){
      showFlag="wait2Sign";
    } else
    if(agentSignCount>0){
      showFlag="agentSign";
    } else
    if(wait2PayCount>0){
      showFlag="wait2Pay";
    } else
    if(wait2CloseCount>0){
      showFlag="wait2Close";
    } else
    if(signingCount>0){
      showFlag="signing";
    } else
    if(signedCount>0){
      showFlag="signed";
    } else {
      showFlag="notice";
    }
  } else {
    if(showFlag.equals("showAll")){
      showAll = true;
    }
  }
  userInfo.setAttribute("showFlag",showFlag);
  boolean showNotice = false;
  boolean showQuotation = false;
  if(userInfo.getAttribute("showNotice")==null){
    userInfo.setAttribute("showNotice","true");
    showNotice = true;
  }
  if(userInfo.getAttribute("showQuotation")==null){
	    userInfo.setAttribute("showQuotation","true");
	    showQuotation = true;
	  }
  boolean showToDos = false;
  if(userInfo.getAttribute("showToDos")==null){
    userInfo.setAttribute("showToDos","true");
    showToDos = true;
  }
%>


<%/*-- Notice List �� --*/%>
<%if(noticeList.size()>0 && (showFlag.equals("notice") || showNotice || showAll)){%>
    <table <%=table_bgcolor%>>
      <tr height="35">
        <th colspan="4" >
          <%=userInfo.getMsg("jsp.menu.Notice")%>
        </th>
      </tr>
      <tr <%=th_bgcolor%>>
        <th width="15%"><%=userInfo.getMsg("jsp.menu.NoticeDate")%></th>
        <th width="55%"><%=userInfo.getMsg("jsp.menu.Summary")%></th>
        <th width="15%"><%=userInfo.getMsg("jsp.menu.NoticeUnit")%></th>
        <th width="15%"><%=userInfo.getMsg("jsp.menu.Noticer")%></th>
      </tr>
  <%Properties deptNames = new Department().getNamesPrpts();
    Properties empNames = new Employee().getNamesPrpts();
    i=0;
    for(itr=noticeList.iterator();itr.hasNext();i++) {
      if(i%2 == 1){bgcolor=tr1;} else {bgcolor=tr2;}
      Notice obj = (Notice)itr.next();%>
      <tr <%=bgcolor%>>
        <td align="center"><%=obj.getDateFrom()%></td>
        <td>
           <a href='viewNotice.jsp?FlowKey=<%=obj.getFlowKey()%>'
              title='<%=userInfo.getMsg("jsp.menu.NoticeTip")%>'>
             <%=obj.getSummary()%>
           </a>
        </td>
        <%String deptName = deptNames.getProperty(obj.getCreateDept());
          if(deptName==null) deptName="&nbsp;";%>
        <td><%=deptName%></td>
        <td><%=empNames.getProperty(obj.getApplicant())%></td>
      </tr>
  <%}%>
    </table><br>
<%}%>


<%if(signedManageList != null && signedManageList.size()>0 ){%>
    <%=Html.printTable("jsp.SignedManage.title", signedManageList, userInfo,false)%>
<%}%>



<%
if(showFlag.equals("legalList") || showAll){
	List LegalList = new LegalCase().getAssignList(emp_id, userInfo);
	if(LegalList.size()>0) {
%>
    <table <%=table_bgcolor%>>
      <tr height="35">
        <th colspan="4" >
          <%=userInfo.getMsg("jsp.LegalCase.Assigntitle")%>
        </th>
      </tr>
      <tr <%=th_bgcolor%>>
        <th width="20%"><%=userInfo.getMsg("jsp.LegalCase.CaseNo")%></th>
        <th width="20%"><%=userInfo.getMsg("jsp.LegalCase.ClientName")%></th>
        <th width="40%"><%=userInfo.getMsg("jsp.LegalCase.Title")%></th>
        <th width="20%"><%=userInfo.getMsg("jsp.LegalCase.MainType")%></th>
      </tr>
  <%
  	Properties clientNames = new Client().getNamesPrpts();
  	Properties cateNames = new Category().getNamesPrpts();
  	i=0;
    for(itr=LegalList.iterator();itr.hasNext();i++) {
      if(i%2 == 1){bgcolor=tr1;} else {bgcolor=tr2;}
      LegalCase obj = (LegalCase)itr.next();
  %>
      <tr <%=bgcolor%>>
        <td align="center"><a href='TimesheetManagement.jsp?_pageActionMode=maintain&_dbActionMode=insert&homeIn=true&_caseNo=<%=obj.getCaseNo()%>' target=_blank><%=obj.getCaseNo()%></a></td>
        <td align="center"><a href='TimesheetManagement.jsp?_pageActionMode=maintain&_dbActionMode=insert&homeIn=true&_caseNo=<%=obj.getCaseNo()%>' target=_blank><%=clientNames.getProperty(obj.getClient())%></a></td>
        <td align="center"><a href='TimesheetManagement.jsp?_pageActionMode=maintain&_dbActionMode=insert&homeIn=true&_caseNo=<%=obj.getCaseNo()%>' target=_blank><%=obj.getTitle()%></a></td>
        <td align="center"><a href='TimesheetManagement.jsp?_pageActionMode=maintain&_dbActionMode=insert&homeIn=true&_caseNo=<%=obj.getCaseNo()%>' target=_blank><%=cateNames.getProperty(obj.getMainType())%></a></td>
      </tr>
  <%} }%>
    </table><br>
<%}%>


<%if(QuotationList != null && QuotationList.size()>0 && (showFlag.equals("quotationList") || showAll)){%>
    <%=Html.printTable("jsp.Quotation.ListTitle", QuotationList, userInfo,false)%>
<%}%>

<%if(QuotationList2 != null && QuotationList2.size()>0 && (showFlag.equals("quotationList2") || showAll)){%>
    <%=Html.printTable("jsp.Quotation.ListTitle2", QuotationList2, userInfo,false)%>
<%}%>

<%/*-- ToDos List �� --*/%>
<%if(ToDoList.size()>0 && (showFlag.equals("ToDos") || showToDos || showAll)){%>
    <%=Html.printTable("jsp.ToDos.title", ToDoList, userInfo,false)%>
    <table cellpadding=8 cellspacing=8>
    	<tr>
    		<td nowrap><img src='img/1.gif'/></td><td nowrap><%=userInfo.getMsg("jsp.ToDos.Icon1Desc")%></td>
    		<td nowrap><img src='img/2.gif'/></td><td nowrap><%=userInfo.getMsg("jsp.ToDos.Icon2Desc")%></td>
    		<td nowrap><img src='img/3.gif'/></td><td nowrap><%=userInfo.getMsg("jsp.ToDos.Icon3Desc")%></td>
    		<td nowrap><img src='img/4.gif'/></td><td nowrap><%=userInfo.getMsg("jsp.ToDos.Icon4Desc")%></td>
    		<td width=100%></td>
    	</tr>
   	</table>
<%}%>


<%/* wait to sign list ��ñ�֪�� */%>
<%if(wait2SignCount>0 && (showFlag.equals("wait2Sign") || showAll)){
    boolean showBatchAgreeCheckbox = false;
    if(wait2SignCount>1){
      showBatchAgreeCheckbox = true;
    }%>
    <form id="agreeForm" name="agreeForm" method="post">
    <table <%=table_bgcolor%>>
      <tr>
        <td align="center" colspan="7">
          <B><font size="3"><%=userInfo.getMsg("jsp.menu.waitSign")%></font></B>
        </td>
      </tr>
      <tr <%=th_bgcolor%>>
        <td align="center" width="15%"><%=userInfo.getMsg("jsp.menu.flowKey")%></td>
        <td align="center" width="49%"><%=userInfo.getMsg("jsp.menu.flowName")%></td>
        <td align="center" width="12%"><%=userInfo.getMsg("jsp.menu.createTime")%></td>
        <td align="center" width="15%"><%=userInfo.getMsg("jsp.menu.applicant")%></td>
        <td align="center" width="3%"><%=userInfo.getMsg("jsp.menu.step")%></td>
        <td align="center" width="3%"><%=userInfo.getMsg("jsp.menu.finish")%></td>
        <td align="center" width="3%">
        <%if(showBatchAgreeCheckbox){%>
          <input type="checkbox" id="batchAgreeAll" name="batchAgreeAll" onClick="batchAgreeChecked()"/>
          <input type="hidden" id="checkedVaule" name="checkedVaule" value=''/>
          <script>
            function batchAgreeChecked(){
              var setValue = false;
              if(document.agreeForm.checkedVaule.value=='true'){
                document.agreeForm.checkedVaule.value='';
              } else {
                document.agreeForm.checkedVaule.value='true';
                setValue = true;
              }
              for(i=0;i<document.agreeForm["batchAgreeItem"].length;i++){
                document.agreeForm.batchAgreeItem[i].checked=setValue;
              }
            }
          </script>
        <%}%>
        </td>
      </tr>
  <%i=0; int canBatchSignRecord=0;
    for(itr=wait2SignList.iterator();itr.hasNext();i++) {
      if(i%2 == 1){bgcolor = tr1;} else {bgcolor = tr2;}
      Flow f = (Flow)itr.next();
      String flowKey = f.getFlowKey();
      String flowName = f.getFlow_name();%>
      <tr <%=bgcolor%>>
        <td align="center">
          <a href="<%=f.getForm_tableName()+".jsp?_getDataFlag=true&_dbActionMode=sign&_modeLockFlag=true&_pageActionMode=maintain&_flowKey="+f.getFlowKey()%>">
            <%=flowKey%>
          </a>
        </td>
        <td align="left"><%=flowName%></td>
        <td align="center"><%=f.getCreate_time()%></td>
        <td align="center"><%=f.getApplicant_name()%></td>
        <td align="center"><%=f.getTotal_steps()%></td>
        <td align="center"><%=f.getFinished_steps()%></td>
        <td align="center">
        <%if(f.getTotal_steps()-f.getFinished_steps()==1){
            canBatchSignRecord++;%>
          <input type="checkbox" id="batchAgreeItem" name="batchAgreeItem" value="<%=f.getFlowKey()%>"/>
        <%}%>
        </td>
      </tr>
  <%}%>
  <%if(canBatchSignRecord>0){%>
      <tr>
        <td colspan="7" align="right">
          <input type="button" value="<%=userInfo.getMsg("jsp.menu.batchAgreeButton")%>"
                 onClick="document.agreeForm.batchAgree.value='true';document.agreeForm.submit()"/>
        </td>
      </tr>
  <%}%>
    </table><br>
    <input type="hidden" id="batchAgree" name="batchAgree" value=""/>
    </form>
<%}%>
  
<%/* agent sing list �� */%>
<%if(agentSignCount>0 && (showFlag.equals("agentSign") || showAll)){%>
    <table <%=table_bgcolor%>>
      <tr><td colspan="7"><font size="3"><B><%=userInfo.getMsg("jsp.Flow_detail.agentSigner")%></B></font></td></tr>
      <tr <%=th_bgcolor%>>
        <td align="center" width="15%"><%=userInfo.getMsg("jsp.menu.flowKey")%></td>
        <td align="center" width="47%"><%=userInfo.getMsg("jsp.menu.flowName")%></td>
        <td align="center" width="12%"><%=userInfo.getMsg("jsp.menu.createTime")%></td>
        <td align="center" width="10%"><%=userInfo.getMsg("jsp.menu.applicant")%></td>
        <td align="center" width="3%"><%=userInfo.getMsg("jsp.menu.step")%></td>
        <td align="center" width="3%"><%=userInfo.getMsg("jsp.menu.finish")%></td>
        <td align="center" width="10%"><%=userInfo.getMsg("jsp.Flow_detail.SrcSigner_id")%></td>
      </tr>
  <%i=0;
  	for(itr=agentSignList.iterator();itr.hasNext();i++) {
      if(i%2 == 1){bgcolor = tr1;} else {bgcolor = tr2;}
      Flow f = (Flow)itr.next();
      String flowKey = f.getFlowKey();
      String flowName = f.getFlow_name();%>
      <tr<%=bgcolor%>>
        <td align="center">
          <a href="<%=f.getForm_tableName()+".jsp?_getDataFlag=true&_dbActionMode=sign&_modeLockFlag=true&_pageActionMode=maintain&_flowKey="+f.getFlowKey()%>">
            <%=flowKey%>
          </a>
        </td>
        <td align="left"><%=flowName%></td>
        <td align="center"><%=f.getCreate_time()%></td>
        <td align="center"><%=f.getApplicant_name()%></td>
        <td align="center"><%=f.getTotal_steps()%></td>
        <td align="center"><%=f.getFinished_steps()%></td>
        <td align="center">
        <%emp = new Employee(f.getSrcSigner_id());
          Category job = new Category(emp.getTitle());%>
          <%=emp.getEmp_name()%><%=job.getNames()%>
        </td>
      </tr>
  <%}%>
    </table><br>
<%}%>

<%/* wait to sign list ��� */%>
<%if(signingCount>0 && (showFlag.equals("signing") || showAll)){%>
    <table <%=table_bgcolor%>>
      <tr>
        <td align="center" colspan="6">
          <B><font size="3"><%=userInfo.getMsg("jsp.menu.signing")%></font></B>
        </td>
      </tr>
      <tr <%=th_bgcolor%>>
        <td align="center" width="15%"><%=userInfo.getMsg("jsp.menu.flowKey")%></td>
        <td align="center" width="52%"><%=userInfo.getMsg("jsp.menu.flowName")%></td>
        <td align="center" width="12%"><%=userInfo.getMsg("jsp.menu.createTime")%></td>
        <td align="center" width="15%"><%=userInfo.getMsg("jsp.menu.signer")%></td>
        <td align="center" width="3%"><%=userInfo.getMsg("jsp.menu.step")%></td>
        <td align="center" width="3%"><%=userInfo.getMsg("jsp.menu.finish")%></td>
      </tr>  
  <%i=0;
    for(itr=signingList.iterator();itr.hasNext();i++) {
      if(i%2 == 1){bgcolor = tr1;} else {bgcolor = tr2;}
      Flow f = (Flow)itr.next();
      String flowKey = f.getFlowKey();
      String flowName = f.getFlow_name();%>
      <tr<%=bgcolor%>>
        <td align="center">
          <a href="<%=f.getForm_tableName()+".jsp?_getDataFlag=true&_dbActionMode=query&_pageActionMode=maintain&_flowKey="+f.getFlowKey()%>">
            <%=flowKey%>
          </a>
        </td>
        <td align="left"><%=flowName%></td>
        <td align="center"><%=f.getCreate_time()%></td>
        <td align="center"><%=f.getSigner_name()%></td>
        <td align="center"><%=f.getTotal_steps()%></td>
        <td align="center"><%=f.getFinished_steps()%></td>
      </tr>
  <%}%>
    </table><br>
<%}%>
    
<%/*  ������� */%>
<%if(signedCount>0 && (showFlag.equals("signed") || showAll)){
    boolean showCheckAllCheckbox = false;
    if(signedCount>1){
      showCheckAllCheckbox = true;
    }%>
    <form id="signedForm" name="signedForm" method="post">
    <table <%=table_bgcolor%>>
      <tr>
        <td align="center" colspan="7">
          <B><font size="3"><%=userInfo.getMsg("jsp.menu.processed")%></font></B>
        </td>
      </tr>
      <tr <%=th_bgcolor%>>
        <td align="center" width="15%"><%=userInfo.getMsg("jsp.menu.flowKey")%></td>
        <td align="center" width="58%"><%=userInfo.getMsg("jsp.menu.flowName")%></td>
        <td align="center" width="12%"><%=userInfo.getMsg("jsp.menu.createTime")%></td>
        <td align="center" width="3%"><%=userInfo.getMsg("jsp.menu.step")%></td>
        <td align="center" width="3%"><%=userInfo.getMsg("jsp.menu.finish")%></td>
        <td align="center" width="6%"><%=userInfo.getMsg("jsp.menu.status")%></td>
        <td align="center" width="3%">
        <%if(showCheckAllCheckbox){%>
          <input type="checkbox" id="checkedAll" name="checkedAll" onClick="signedFormChecked()"/>
          <input type="hidden" id="checkedVaule" name="checkedVaule" value=''/>
          <script>
            function signedFormChecked(){
              var setValue = false;
              if(document.signedForm.checkedVaule.value=='true'){
                document.signedForm.checkedVaule.value='';
              } else {
                document.signedForm.checkedVaule.value='true';
                setValue = true;
              }
              for(i=0;i<document.signedForm["removeSignedItem"].length;i++){
                document.signedForm.removeSignedItem[i].checked=setValue;
              }
            }
          </script>
        <%}%>
        </td>
      </tr> 
  <%i=0;
  	for(itr=signedList.iterator();itr.hasNext();i++) {
      if(i%2 == 1){bgcolor = tr1;} else {bgcolor = tr2;}
      Flow f = (Flow)itr.next();
      String flowKey = f.getFlowKey();
      String flowName = f.getFlow_name();%>
      <tr<%=bgcolor%>>
        <td align="center">
          <a href="<%=f.getForm_tableName()+".jsp?_getDataFlag=true&_dbActionMode=query&_modeLockFlag=true&_pageActionMode=maintain&_flowKey="+f.getFlowKey()%>">
            <%=flowKey%>
          </a>
        </td>
        <td align="left"><%=flowName%></td>
        <td align="center"><%=f.getCreate_time()%></td>
        <td align="center"><%=f.getTotal_steps()%></td>
        <td align="center"><%=f.getFinished_steps()%></td>
        <td align="center"><%=Util.changeMsg(userInfo.getAttribute("language"),f.getStatus())%></td>
        <td align="center">
          <input type="checkbox" id="removeSignedItem" name="removeSignedItem" value="<%=f.getFlowKey()%>"/>
        </td>
      </tr>
  <%}%>
      <tr>
        <td colspan="7" align="right">
          <input type="button" value="<%=userInfo.getMsg("jsp.menu.removeButton")%>"
                 onClick="document.signedForm.removeSigned.value='true';document.signedForm.submit()"/>
        </td>
      </tr>
    </table><br>
    <input type="hidden" id="removeSigned" name="removeSigned" value=""/>
    </form>
<%}%>

<%/*  ��� */%>
<%if(rejectCount>0 && (showFlag.equals("reject") || showAll)){
    boolean showCheckAllCheckbox = false;
    if(rejectCount>1){
      showCheckAllCheckbox = true;
    }%>
    <form id="rejectForm" name="rejectForm" method="post">
    <table <%=table_bgcolor%>>
      <tr>
        <td align="center" colspan="7">
          <B><font size="3"><%=userInfo.getMsg("jsp.menu.reject")%></font></B>
        </td>
      </tr>
      <tr <%=th_bgcolor%>>
        <td align="center" width="15%"><%=userInfo.getMsg("jsp.menu.flowKey")%></td>
        <td align="center" width="58%"><%=userInfo.getMsg("jsp.menu.flowName")%></td>
        <td align="center" width="12%"><%=userInfo.getMsg("jsp.menu.createTime")%></td>
        <td align="center" width="3%"><%=userInfo.getMsg("jsp.menu.step")%></td>
        <td align="center" width="3%"><%=userInfo.getMsg("jsp.menu.finish")%></td>
        <td align="center" width="6%"><%=userInfo.getMsg("jsp.menu.status")%></td>
        <td align="center" width="3%">
        <%if(showCheckAllCheckbox){%>
          <input type="checkbox" id="checkedAll" name="checkedAll" onClick="rejectFormChecked()"/>
          <input type="hidden" id="checkedVaule" name="checkedVaule" value=''/>
          <script>
            function rejectFormChecked(){
              var setValue = false;
              if(document.rejectForm.checkedVaule.value=='true'){
                document.rejectForm.checkedVaule.value='';
              } else {
                document.rejectForm.checkedVaule.value='true';
                setValue = true;
              }
              for(i=0;i<document.rejectForm["removeRejectItem"].length;i++){
                document.rejectForm.removeRejectItem[i].checked=setValue;
              }
            }
          </script>
        <%}%>
        </td>
      </tr> 
  <%i=0;
  	for(itr=rejectList.iterator();itr.hasNext();i++) {
      if(i%2 == 1){bgcolor = tr1;} else {bgcolor = tr2;}
      Flow f = (Flow)itr.next();
      String flowKey = f.getFlowKey();
      String flowName = f.getFlow_name();%>
      <tr<%=bgcolor%>>
        <td align="center">
          <a href="<%=f.getForm_tableName()+".jsp?_getDataFlag=true&_dbActionMode=query&_modeLockFlag=true&_pageActionMode=maintain&_flowKey="+f.getFlowKey()%>">
            <%=flowKey%>
          </a>
        </td>
        <td align="left"><%=flowName%></td>
        <td align="center"><%=f.getCreate_time()%></td>
        <td align="center"><%=f.getTotal_steps()%></td>
        <td align="center"><%=f.getFinished_steps()%></td>
        <td align="center"><%=Util.changeMsg(userInfo.getAttribute("language"),f.getStatus())%></td>
        <td align="center">
          <input type="checkbox" id="removeRejectItem" name="removeRejectItem" value="<%=f.getFlowKey()%>"/>
        </td>
      </tr>
  <%}%>
      <tr>
        <td colspan="7" align="right">
          <input type="button" value="<%=userInfo.getMsg("jsp.menu.removeButton")%>"
                 onClick="document.rejectForm.removeReject.value='true';document.rejectForm.submit()"/>
        </td>
      </tr>
    </table><br>
    <input type="hidden" id="removeReject" name="removeReject" value=""/>
    </form>
<%}%>
    
<%/* ���k�ɪ�� */%>
<%if(wait2CloseCount>0 && (showFlag.equals("wait2Close") || showAll)){
    boolean showCheckAllCheckbox = false;
    int batchCount=0;
  	for(itr=wait2CloseList.iterator();itr.hasNext();) {
  	  Flow f = (Flow)itr.next();
      if(!f.getForm_tableName().equals("AssetAdd") && !f.getForm_tableName().equals("AssetDiscard")
      				&& !f.getForm_tableName().equals("AssetMove") && !f.getForm_tableName().equals("Depreciation")){
        batchCount++;
        if(batchCount>1){
          showCheckAllCheckbox=true;
          break;
        }
      }
    }%>
    <form id="closeForm" name="closeForm" method="post">
    <table <%=table_bgcolor%>>
      <tr>
        <td align="center" colspan="8">
          <B><font size="3"><%=userInfo.getMsg("jsp.menu.waitClose")%></font></B>
        </td>
      </tr>
      <tr <%=th_bgcolor%>>
        <td align="center" width="15%"><%=userInfo.getMsg("jsp.menu.flowKey")%></td>
        <td align="center" width="40%"><%=userInfo.getMsg("jsp.menu.flowName")%></td>
        <td align="center" width="15%"><%=userInfo.getMsg("jsp.menu.applicant")%></td>
        <td align="center" width="10%"><%=userInfo.getMsg("jsp.menu.decider")%></td>
        <td align="center" width="11%"><%=userInfo.getMsg("jsp.menu.decideTime")%></td>
        <td align="center" width="3%"><%=userInfo.getMsg("jsp.menu.step")%></td>
        <td align="center" width="3%"><%=userInfo.getMsg("jsp.menu.finish")%></td>
        <td align="center" width="3%">
        <%if(showCheckAllCheckbox){%>
          <input type="checkbox" id="checkedAll" name="checkedAll" onClick="closeFormChecked()"/>
          <input type="hidden" id="checkedVaule" name="checkedVaule" value=''/>
          <script>
            function closeFormChecked(){
              var setValue = false;
              if(document.closeForm.checkedVaule.value=='true'){
                document.closeForm.checkedVaule.value='';
              } else {
                document.closeForm.checkedVaule.value='true';
                setValue = true;
              }
              for(i=0;i<document.closeForm["batchCloseItem"].length;i++){
                document.closeForm.batchCloseItem[i].checked=setValue;
              }
            }
          </script>
        <%}%>
        </td>
      </tr>
  <%i=0;
  	for(itr=wait2CloseList.iterator();itr.hasNext();i++) {
      if(i%2 == 1){bgcolor = tr1;} else {bgcolor = tr2;}
      Flow f = (Flow)itr.next();
      boolean showCheckbox = true;
      if(f.getForm_tableName().equals("AssetAdd") || f.getForm_tableName().equals("AssetDiscard")
      				|| f.getForm_tableName().equals("AssetMove") || f.getForm_tableName().equals("Depreciation")){
        showCheckbox = false;
      }
      String flowKey = f.getFlowKey();
      String flowName = f.getFlow_name();%>
      <tr<%=bgcolor%>>
        <td align="center">
          <a href="<%=f.getForm_tableName()+".jsp?_getDataFlag=true&_dbActionMode=close&_modeLockFlag=true&_pageActionMode=maintain&_flowKey="+f.getFlowKey()%>">
            <%=flowKey%>
          </a>
        </td>
        <td align="left"><%=flowName%></td>
        <td align="center"><%=f.getApplicant_name()%></td>
        <td align="center"><%=f.getDecider_name()%></td>
        <td align="center"><%=f.getDecide_time()%></td>
        <td align="center"><%=f.getTotal_steps()%></td>
        <td align="center"><%=f.getFinished_steps()%></td>
        <td align="center">
        <%if(showCheckbox){%>
          <input type="checkbox" id="batchCloseItem" name="batchCloseItem" value="<%=f.getFlowKey()%>"/>
        <%}%>
        </td>
      </tr>
  <%}%>
    <tr>
        <td colspan="8" align="right">
          <input type="button" value="<%=userInfo.getMsg("jsp.menu.batchClose")%>"
                 onClick="document.closeForm.batchClose.value='true';document.closeForm.submit()"/>
        </td>
      </tr>
    </table><br>
    <input type="hidden" id="batchClose" name="batchClose" value=""/>
    </form>
<%}%>

<%/* �ݥI�ڽ��ʳ� */%>
<%
  if(wait2PayCount>0 && (showFlag.equals("wait2Pay") || showAll)){%>
    <table <%=table_bgcolor%>>
      <tr>
        <td align="center" colspan="7">
          <B><font size="3"><%=userInfo.getMsg("jsp.menu.wait2Pay")%></font></B>
        </td>
      </tr>
      <tr <%=th_bgcolor%>>
        <td align="center" width="15%"><%=userInfo.getMsg("jsp.menu.flowKey")%></td>
        <td align="center" width="47%"><%=userInfo.getMsg("jsp.menu.flowName")%></td>
        <td align="center" width="10%"><%=userInfo.getMsg("jsp.menu.applicant")%></td>
        <td align="center" width="10%"><%=userInfo.getMsg("jsp.menu.decider")%></td>
        <td align="center" width="12%"><%=userInfo.getMsg("jsp.menu.decideTime")%></td>
        <td align="center" width="3%"><%=userInfo.getMsg("jsp.menu.step")%></td>
        <td align="center" width="3%"><%=userInfo.getMsg("jsp.menu.finish")%></td>
      </tr>
  <%i=0;
  	for(itr=wait2PayList.iterator();itr.hasNext();i++) {
      if(i%2 == 1){bgcolor = tr1;} else {bgcolor = tr2;}
      Flow f = (Flow)itr.next();
      String flowKey = f.getFlowKey();
      String flowName = f.getFlow_name();%>
      <tr<%=bgcolor%>>
        <td align="center">
          <a href="<%=f.getForm_tableName()+".jsp?_getDataFlag=true&_dbActionMode=query&_modeLockFlag=true&_pageActionMode=maintain&_flowKey="+f.getFlowKey()%>">
            <%=flowKey%>
          </a>
        </td>
        <td align="left"><%=flowName%></td>
        <td align="center"><%=f.getApplicant_name()%></td>
        <td align="center"><%=f.getDecider_name()%></td>
        <td align="center"><%=f.getDecide_time()%></td>
        <td align="center"><%=f.getTotal_steps()%></td>
        <td align="center"><%=f.getFinished_steps()%></td>
      </tr>
  <%}%>
    </table><br>
<%}%>

	<%
	String canShowTmMonitor = "true"; 
	String host = request.getServerName();
	int port = request.getServerPort();
	if(canShowTmMonitor.equals(userInfo.getAttribute("showTmMonitor"))){ %>
	
	<%if((showFlag.equals("tmMonitorResult") || showAll)){%>
	
	<iframe src="http://<%=host%>:<%=port%>/PlusProject/TrademarkMonitorResultList_New.jsp?conToDb=hh" width="100%" height="90%" frameborder="0" scrolling="auto"></iframe>
	
	<%} %>
	
	<%} %>
  </center>
  </body>
</html>