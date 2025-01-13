<%@ include file="includePage/pageHeader.jsp" %>

<% final String program_id = "jsp.Authority";
   final String thisJspPage = "Authority.jsp";
   String title=userInfo.getProgramName(program_id);%>

<%@ include file="includePage/getFlags.jsp" %>

<% userInfo.setAttribute("requestUrl",request.getRequestURI());
   
   String authorityType = request.getParameter("authorityType");
   if(authorityType==null || authorityType.trim().length()==0)
     authorityType = "Department";
   
   String keyValue = request.getParameter("keyValue");
   if(keyValue==null)
     keyValue = "";
     
   String type = request.getParameter("type");
   if(type==null || !type.equals(authorityType))
     keyValue = "";
     
   String programId = request.getParameter("programId");
   if(programId==null)
     programId = "";
     
   String displayMenu = request.getParameter("displayMenu");
   if(displayMenu==null)
     displayMenu = "";
     
   String saveToDb = request.getParameter("saveToDb");
   if(saveToDb==null)
     saveToDb = "";
   
   String editRecord = request.getParameter("editRecord");
   if(editRecord==null)
     editRecord = "";
     
   Program progObj = new Program(programId);
   
   if(saveToDb.equals("true")){
     Authority auth = new Authority(authorityType,keyValue,programId);
     if(progObj.getIsMenu().equals("1")){
       if(auth.getDisplayMenu().equals("1")){
         auth.delete();
       } else {
         auth.setDisplayMenu("1");
         auth.insert();
       }
     } else {%>
     <jsp:useBean id="thisBean" scope="page" class="deepspot.main.Authority"/>
     <jsp:setProperty name="thisBean" property="*"/>
   <%thisBean.dbExcute();
     }
   }%>

<html>
<%@ include file="includePage/htmlHeader.jsp" %>
<body><center>
<form name="input" id="input" action="Authority.jsp" method="post">
<input type="hidden" id="setObjValue" name="setObjValue" value=""/>
<input type="hidden" id="type" name="type" value="<%=authorityType%>"/>
<input type="hidden" id="programId" name="programId" value="<%=programId%>"/>
<input type="hidden" id="displayMenu" name="displayMenu" value=""/>
<input type="hidden" id="saveToDb" name="saveToDb" value=""/>
<input type="hidden" id="editRecord" name="editRecord" value=""/>

<table border="0" cellpadding="1" cellspacing="1" bgcolor="#D7D7D7">
  <tr height="30"><td style="font-size: 20" colspan='12'><b><%=title%></b></td></tr>	
	     
  <tr height="40" bgcolor='#F7F7F7'>
    <td align="right">
      <%=userInfo.getMsg("jsp.Authority.AuthorityType")%>
    </td>
    <td colspan='11'>
  	<select id="authorityType" name="authorityType" onChange="setValue()">
	    <option value="Department"<%if(authorityType.equals("Department")){%> selected<%}%>>
	      <%=userInfo.getMsg("jsp.Authority.Department")%>
	    </option>
      <option value="Groups"<%if(authorityType.equals("Groups")){%> selected<%}%>>
	      <%=userInfo.getMsg("jsp.Authority.Groups")%>
	    </option>
	    <option value="Employee"<%if(authorityType.equals("Employee")){%> selected<%}%>>
	      <%=userInfo.getMsg("jsp.Authority.Employee")%>
	    </option>
    </select>
      
    <%=userInfo.getMsg("jsp.Authority.KeyValue")%>
    
	  <select id="keyValue" name="keyValue" onChange="setValue()">
	    <option value="">
        <%=userInfo.getMsg("jsp.account.select")%>
      </option>
	  <%if(authorityType.equals("Department")){
	      Iterator itr = new Department().getRootTreeList().iterator();
	      while(itr.hasNext()){
	        SelectItem obj = (SelectItem)itr.next();
	        boolean sFlag = false;
	        if(keyValue.equals(obj.getKey())) sFlag=true;%>
	      <option value="<%=obj.getKey()%>"<%if(sFlag){%> selected<%}%>>
	        <%=obj.getValue()%>
	      </option>
	    <%}
	    }
	    if(authorityType.equals("Groups")){
	      Groups Obj = new Groups();
	      Iterator itr = Obj.getList().iterator();
	      while(itr.hasNext()){
	        SelectItem obj = (SelectItem)itr.next();
	        String sNo = obj.getKey();
	        String sName = obj.getValue();
	        boolean sFlag = false;
	        if(keyValue.equals(sNo)) sFlag=true;%>
	      <option value="<%=sNo%>"<%if(sFlag){%> selected<%}%>>
	        <%=sName%>
	      </option>
	    <%}
	    }
	    if(authorityType.equals("Employee")){
	      Iterator itr = new Employee().getList().iterator();
	      while(itr.hasNext()){
	        SelectItem obj = (SelectItem)itr.next();
	        boolean sFlag = false;
	        if(keyValue.equals(obj.getKey())) sFlag=true;%>
	      <option value="<%=obj.getKey()%>"<%if(sFlag){%> selected<%}%>>
	        <%=obj.getValue()%>
	      </option>
	    <%}
	    }%>
    </select>
    <% 
    	if(authorityType.equals("Employee")){%>
    		<input type="button" value="<%=userInfo.getMsg("jsp.Authority.ResetPersonal")%>" onclick="resetPersonalAuthority();"/>
    		<%if(userInfo.getAttribute("emp_id").equalsIgnoreCase("Admin")){%>
    			<input type="button" value="<%=userInfo.getMsg("jsp.Authority.ResetAllPersonal")%>" onclick="resetAllPersonalAuthority();"/>
    		<%}%>
    		<input type="hidden" id="tmpField" name="tmpField" value=""/>
    	<%}
    	else if(authorityType.equals("Department")){%>
			<input type="button" value="<%=userInfo.getMsg("jsp.Authority.ResetDepartment")%>" onclick="resetDepartmentAuthority();"/>
			<%if(userInfo.getAttribute("emp_id").equalsIgnoreCase("Admin")){%>
				<input type="button" value="<%=userInfo.getMsg("jsp.Authority.ResetAllDepartment")%>" onclick="resetAllDepartmentAuthority();"/>
			<%}%>
			<input type="hidden" id="tmpField2" name="tmpField2" value=""/>
		<%}
    	else if(authorityType.equals("Groups")){%>
			<input type="button" value="<%=userInfo.getMsg("jsp.Authority.ResetGroups")%>" onclick="resetGroupsAuthority();"/>
			<%if(userInfo.getAttribute("emp_id").equalsIgnoreCase("Admin")){%>
				<input type="button" value="<%=userInfo.getMsg("jsp.Authority.ResetAllGroups")%>" onclick="resetAllGroupsAuthority();"/>
			<%}%>
			<input type="hidden" id="tmpField3" name="tmpField3" value=""/>
		<%}
    %>
    </td>
  </tr>
  
  <tr bgcolor='#CDEFD0' height="20">
    <td width="33%" align="center">
      <%=userInfo.getMsg("jsp.usersDetail.program_id")%>
    </td>
    <td width="25%" align="center">
      <%=userInfo.getMsg("jsp.usersDetail.programName")%>
    </td>
    <td width="4%" align="center">
      <img src="img/C_Find_Sm_N.png" 
           title="<%=userInfo.getMsg("jsp.usersDetail.query")%>"/>
    </td>
    <td width="4%" align="center">
      <img src="img/edit2.gif" 
           title="<%=userInfo.getMsg("jsp.usersDetail.edit")%>"/>
    </td>
    <td width="4%" align="center">
      <img src="img/addanchr.gif" 
           title="<%=userInfo.getMsg("jsp.usersDetail.add")%>"/>
    </td>
    <td width="4%" align="center">
      <img src="img/C_Delete_Md_N.png" 
           title="<%=userInfo.getMsg("jsp.usersDetail.del")%>"/>
    </td>
    <td width="4%" align="center">
      <img src="img/C_Print_Md_N.png" 
           title="<%=userInfo.getMsg("jsp.usersDetail.print")%>"/>
    </td>
    <td width="5%" align="center">
      <%=userInfo.getMsg("jsp.Authority.JobType")%>
    </td>
    <td width="5%" align="center">
      <%=userInfo.getMsg("jsp.Authority.CanUse")%>
    </td>
    <td width="4%" align="center">
      <img src="img/C_Find_Sm_N.png" 
           title="<%=userInfo.getMsg("jsp.usersDetail.query")%>"/>
    </td>
    <td width="4%" align="center">
      <img src="img/edit2.gif" 
           title="<%=userInfo.getMsg("jsp.usersDetail.edit")%>"/>
    </td>
    <td width="4%" align="center">
      <img src="img/C_Delete_Md_N.png" 
           title="<%=userInfo.getMsg("jsp.usersDetail.del")%>"/>
    </td>
  </tr>
    
<%if(keyValue.trim().length()>0){
   Vector progVtr = progObj.getTreeList();
   Authority authority = new Authority();
   progVtr = authority.getAuthority(authorityType,keyValue,progVtr);
   Iterator programs = progVtr.iterator();
   boolean display = false;
   Properties displayPrpt = new Properties();
   displayPrpt.setProperty("","display");
   Properties lastFlag = new Properties();
   int j=0;
   String bgcolor = "";
   while(programs.hasNext()) {
     Program p = (Program)programs.next();
     if(p.getDisplayMenu().equals("1")) {
       if(displayPrpt.getProperty(p.getParentId()).equals("display"))
         displayPrpt.setProperty(p.getProgramId(),"display");
       else
         displayPrpt.setProperty(p.getProgramId(),"no");
     } else { 
       displayPrpt.setProperty(p.getProgramId(),"no");
     }
     
     if(displayPrpt.getProperty(p.getParentId()).equals("display")) 
       display = true;
     else 
       display = false;
    
     String imgUrl = "img/edit2.gif";  
     if(p.getIsMenu().equals("1")){
       imgUrl = "img/folder.gif";
       if(p.getDisplayMenu().equals("1"))
         imgUrl = "img/ftv2folderopen.gif";
     }%>
     
  <%if(display){
    j++;
    if(j%2==1) bgcolor = "bgcolor='#F8F9DB'";
    else bgcolor = "bgcolor='#F7F7F7'";
    String indent = "";
    for(int i=1; i<=p.getLayer(); i++){
      if(lastFlag.getProperty(""+i)==null)
        lastFlag.setProperty(""+i,"false");
      if(p.getLastElement())
        lastFlag.setProperty(""+p.getLayer(),"true");
      if(i==p.getLayer()){
        if(p.getLastElement()){
          lastFlag.setProperty(""+i,"true");
          indent += "<img src=\"treeImage/ftv2lastnode.gif\"/>";
        } else {
          lastFlag.setProperty(""+i,"false");
          indent += "<img src=\"treeImage/ftv2node.gif\"/>";
        }
      } else {
        if(lastFlag.getProperty(""+i).equals("true"))
          indent += "&nbsp;&nbsp;&nbsp;&nbsp;";
        else
          indent += "<img src=\"treeImage/ftv2vertline.gif\"/>";
      }
    }
    boolean editFlag = false;
    if(p.getProgramId().equals(programId)) editFlag = true;%> 
    
  <tr <%=bgcolor%>>
    <td>
      <%=indent%>
      <img src="<%=imgUrl%>" 
      <%if(!editFlag){
          if(p.getIsMenu().equals("1")){%>
            title="<%=userInfo.getMsg("jsp.usersDetail.edit2")%>" style="cursor: hand;"
          <%if(display){%>
              onclick='saveToDB("<%=p.getProgramId()%>")'
          <%} else {%>
              onclick='document.input.displayMenu.value="1";saveToDB("<%=p.getProgramId()%>")'
          <%}
          } else {
            if(editRecord.equals("")){%>
              title="<%=userInfo.getMsg("jsp.usersDetail.edit2")%>" style="cursor: hand;"
	            onclick='setEditRecord("<%=p.getProgramId()%>")'
          <%}
          }
        } else {%>
              title="<%=userInfo.getMsg("jsp.usersDetail.edit2")%>" style="cursor: hand;"
        <%if(editRecord.equals(p.getProgramId()) || p.getIsMenu().equals("1")){%>
              onclick='saveToDB("<%=p.getProgramId()%>")'
        <%} else {%>
              onclick='setEditRecord("<%=p.getProgramId()%>")'
        <%}
        }%> />
      <%=p.getProgramId()%>
    </td>
      
    <td><%=p.getProgramName()%></td>
    <td align="center">
  <%if(!p.getIsMenu().equals("1") && p.getQueryFunction().equals("1")){
	    if(editFlag && !editRecord.equals("")){%>
      <input type="checkbox" id="allowQuery" name="allowQuery" value="1"
             <%if(p.getAllowQuery().equals("1")){%>checked<%}%>>
    <%} else {
	      if(p.getAllowQuery().equals("1")){%>
        <img src="img/tick.gif"/>
      <%} else {%>
	      <img src="img/cross.gif"/>
      <%}
	    }
	  }%>		
    </td>
      
    <td align="center">
  <%if(!p.getIsMenu().equals("1") && p.getUpdateFunction().equals("1")){
	    if(editFlag && !editRecord.equals("")){%>
        <input type="checkbox" id="allowUpdate" name="allowUpdate" value="1"
               <%if(p.getAllowUpdate().equals("1")){%>checked<%}%>>
    <%} else {
	      if(p.getAllowUpdate().equals("1")){%>
        <img src="img/tick.gif"/>
	    <%} else {%>
	      <img src="img/cross.gif"/>
	    <%}
	    }
	  }%>		
    </td>
      
    <td align="center">
  <%if(!p.getIsMenu().equals("1") && p.getInsertFunction().equals("1")){
	    if(editFlag && !editRecord.equals("")){%>
      <input type="checkbox" id="allowInsert" name="allowInsert" value="1"
             <%if(p.getAllowInsert().equals("1")){%>checked<%}%>>
    <%} else {
	      if(p.getAllowInsert().equals("1")){%>
        <img src="img/tick.gif"/>
      <%} else {%>
	      <img src="img/cross.gif"/>
      <%}
	    }
	  }%>		
    </td>
      
    <td align="center">
  <%if(!p.getIsMenu().equals("1") && p.getDeleteFunction().equals("1")){
	    if(editFlag && !editRecord.equals("")){%>
      <input type="checkbox" id="allowDelete" name="allowDelete" value="1"
      <%if(p.getAllowDelete().equals("1")){%>checked<%}%>>
    <%} else {
	      if(p.getAllowDelete().equals("1")){%>
	      <img src="img/tick.gif"/>
	    <%} else {%>
	      <img src="img/cross.gif"/>
	    <%}
	    }
	  }%>			
    </td>
      
    <td align="center">
  <%if(!p.getIsMenu().equals("1") && p.getPrintFunction().equals("1")){
	    if(editFlag && !editRecord.equals("")){%>
      <input type="checkbox" id="allowPrint" name="allowPrint" value="1"
               <%if(p.getAllowPrint().equals("1")){%>checked<%}%>>
    <%} else {
	      if(p.getAllowPrint().equals("1")){%>
	        <img src="img/tick.gif"/>
	    <%} else {%>
	      <img src="img/cross.gif"/>
	    <%}
	    }
	  }%>		
    </td>
      
    <td align="center">
    <%if(!p.getIsMenu().equals("1") && editFlag && !editRecord.equals("")){%>
      <select id="jobType" name="jobType">
        <option value="">
          <%=userInfo.getMsg("jsp.account.select")%>
        </option>
      <%Iterator JobTypeItr=new Category().getChildList("Title").iterator();
        while(JobTypeItr.hasNext()) {
          SelectItem obj=(SelectItem)JobTypeItr.next();
          boolean sFlag=false;
          if(p.getJobType().equals(obj.getKey())) sFlag=true;%>
        <option value="<%=obj.getKey()%>"<%if(sFlag){%> selected<%}%>>
          <%=obj.getValue()%>
        </option>
        <%}%>
        </select>
    <%} else {%>
        <%=p.getJobType()%>
    <%}%>
    </td>
      
    <td align="center">
    <%if(!p.getIsMenu().equals("1")){
	      if(editFlag && !editRecord.equals("")){%>
      <input type="checkbox" id="z" name="canUse" value="Y"
             <%if(p.getCanUse().equals("Y")){%>checked<%}%>>
      <%} else {
          if(!p.getJobType().equals("")){  
	          if(p.getCanUse().equals("Y")){%>
	    <img src="img/tick.gif"/>
	        <%} else {%>
	    <img src="img/cross.gif"/>
	        <%}
	        }
	      }
	    }%>		
    </td>
      
    <td align="center">
    <%if(!p.getIsMenu().equals("1") && p.getQueryFunction().equals("1")
                                    && p.getAllowQuery().equals("1")){
	      if(editFlag && !editRecord.equals("")){%>
      <select id="queryAuthority" name="queryAuthority">
        <option value="A"<%if(p.getQueryAuthority().equals("A")){%> selected<%}%>>
          <%=userInfo.getMsg("jsp.Authority.AllData")%>
        </option>
        <option value="D"<%if(p.getQueryAuthority().equals("D")){%> selected<%}%>>
          <%=userInfo.getMsg("jsp.Authority.DeptData")%>
        </option>
        <option value="S"<%if(p.getQueryAuthority().equals("S")){%> selected<%}%>>
          <%=userInfo.getMsg("jsp.Authority.SelfData")%>
        </option>
      </select>
      <%} else {%>
        <%=p.getQueryAuthority()%>
      <%}
      }%>
    </td>
      
    <td align="center">
    <%if(!p.getIsMenu().equals("1") && p.getUpdateFunction().equals("1")
                                    && p.getAllowUpdate().equals("1")){
	      if(editFlag && !editRecord.equals("")){%>
      <select id="updateAuthority" name="updateAuthority">
        <option value="A"<%if(p.getUpdateAuthority().equals("A")){%> selected<%}%>>
          <%=userInfo.getMsg("jsp.Authority.AllData")%>
        </option>
        <option value="D"<%if(p.getUpdateAuthority().equals("D")){%> selected<%}%>>
          <%=userInfo.getMsg("jsp.Authority.DeptData")%>
        </option>
        <option value="S"<%if(p.getUpdateAuthority().equals("S")){%> selected<%}%>>
          <%=userInfo.getMsg("jsp.Authority.SelfData")%>
        </option>
      </select>
      <%} else {%>
        <%=p.getUpdateAuthority()%>
      <%}
    }%>
    </td>
     
    <td align="center">
    <%if(!p.getIsMenu().equals("1") && p.getDeleteFunction().equals("1")
                                    && p.getAllowDelete().equals("1")){
	      if(editFlag && !editRecord.equals("")){%>
      <select id="deleteAuthority" name="deleteAuthority">
        <option value="A"<%if(p.getDeleteAuthority().equals("A")){%> selected<%}%>>
          <%=userInfo.getMsg("jsp.Authority.AllData")%>
        </option>
        <option value="D"<%if(p.getDeleteAuthority().equals("D")){%> selected<%}%>>
          <%=userInfo.getMsg("jsp.Authority.DeptData")%>
        </option>
        <option value="S"<%if(p.getDeleteAuthority().equals("S")){%> selected<%}%>>
          <%=userInfo.getMsg("jsp.Authority.SelfData")%>
        </option>
      </select>
      <%} else {%>
        <%=p.getDeleteAuthority()%>
      <%}
      }%>
    </td>
      
  </tr>
  <%}
  }
}%>
</table></form></center></body>
</html>
<script>
  function saveToDB(pid){
    document.input.saveToDb.value="true";
    document.input.programId.value=pid;
    setValue();
  }
  function setEditRecord(pid){
    document.input.editRecord.value=pid;
    document.input.programId.value=pid;
    setValue();
  }
  function resetPersonalAuthority(){
	if(confirm('<%=userInfo.getMsg("jsp.Authority.ResetNoticePersonal")%>')){
		doAjaxRequest('Authority','keyValue','ResetPersonalAuthority','tmpField','Value');
		alert('<%=userInfo.getMsg("jsp.Authority.ResetFinisPersonalh")%>');
		setValue();
	}
  }
  function resetAllPersonalAuthority(){
	if(confirm('<%=userInfo.getMsg("jsp.Authority.ResetAllNoticePersonal")%>')){
		doAjaxRequest('Authority','keyValue','ResetAllPersonalAuthority','tmpField','Value');
		alert('<%=userInfo.getMsg("jsp.Authority.ResetFinishPersonal")%>');
		setValue();
	}	
  }
  function resetDepartmentAuthority(){
	if(confirm('<%=userInfo.getMsg("jsp.Authority.ResetNoticeDepartment")%>')){
		doAjaxRequest('Authority','keyValue','ResetDepartmentAuthority','tmpField2','Value');
		alert('<%=userInfo.getMsg("jsp.Authority.ResetFinishDepartment")%>');
		setValue();
	}
  }
  function resetAllDepartmentAuthority(){
	if(confirm('<%=userInfo.getMsg("jsp.Authority.ResetAllNoticeDepartment")%>')){
		doAjaxRequest('Authority','keyValue','ResetAllDepartmentAuthority','tmpField2','Value');
		alert('<%=userInfo.getMsg("jsp.Authority.ResetFinishDepartment")%>');
		setValue();
	}	
  }
  function resetGroupsAuthority(){
	if(confirm('<%=userInfo.getMsg("jsp.Authority.ResetNoticeGroups")%>')){
		doAjaxRequest('Authority','keyValue','ResetGroupsAuthority','tmpField3','Value');
		alert('<%=userInfo.getMsg("jsp.Authority.ResetFinishGroups")%>');
		setValue();
	}
  }
  function resetAllGroupsAuthority(){
	if(confirm('<%=userInfo.getMsg("jsp.Authority.ResetAllNoticeGroups")%>')){
		doAjaxRequest('Authority','keyValue','ResetAllGroupsAuthority','tmpField3','Value');
		alert('<%=userInfo.getMsg("jsp.Authority.ResetFinishGroups")%>');
		setValue();
	}	
  }
</script>