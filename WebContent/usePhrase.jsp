<%@ include file="includePage/pageHeader.jsp" %>
<%String obj_id = request.getParameter("obj_id");
  String requestType = request.getParameter("requestType");
  if(requestType==null) requestType="personal";%>
<html>
<script>
  function sendData() {
    var phrase = document.getElementById("phrase_id").value;
    var srcPhrase = window.opener.document.getElementById("<%=obj_id%>").value;
    window.opener.document.input.<%=obj_id%>.value = srcPhrase + phrase;
    window.close(); 
  }
  function selectPhrase(requestStr) {
    document.input.requestType.value = requestStr;
    document.input.submit();
  }
</script>

  <head>
    <title><%=userInfo.getMsg("jsp.account.selectPhrase")%></title>
  </head>
  <body>
  <center>
  <form name="input" id="input" action="usePhrase.jsp?" method="post">
  <input type="hidden" name="requestType" id="requestType" value="<%=requestType%>"/>
  <input type="hidden" name="obj_id" id="obj_id" value="<%=obj_id%>"/>
    <table>
      <tr>
        <td colspan="2" align="center">
          <select id="phrase_id" name="phrase_id" onChange="sendData()">
            <option value="">
              <%=userInfo.getMsg("jsp.account.selectPhrase")%>
            </option>
          <%Iterator PhraseItr=new Phrase().getList(userInfo.getAttribute("emp_id")).iterator();
            while(PhraseItr.hasNext()) {
              SelectItem obj=(SelectItem)PhraseItr.next();%>
              <option value="<%=obj.getValue()%>">
                <%=obj.getValue()%>
              </option>
          <%}%>
          </select>
        </td>
      </tr>
    </table>
  </form>
  </center>
  </body>
</html>