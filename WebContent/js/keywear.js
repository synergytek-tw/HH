function chkFather(fatherName){
  var myFather = window.opener;
  var fatherUrl = myFather["location"]+"";
  var find = fatherUrl.search(fatherName);
  if(find==-1){
    window.close();
  }
}

function printHTML(w,h,tagId){
  var pageUrl = "printHTML.jsp?printTagId="+tagId;
  var windowSize = 'width='+w+',height='+h+',scrollbars=yes,resizable,memu=on';
  window.open(pageUrl,'printHTML',windowSize);
}

function photoView(photoUrl){
  window.open(photoUrl,'Upload','scrollbars=yes,resizable');
}

function openHelp(docUrl){
  window.open(docUrl,'onlineHelp','scrollbars=yes,resizable');
}

function calculateTotalFee(hours,fee){
  return parseInt(hours * fee);
}

function countMoney(id_1,id_2){
  var n1 = document.getElementById(id_1).value;
  var n2 = document.getElementById(id_2).value;
  document.input.sub_amount.value = parseInt( n1 * n2) ;  
}

function countMoneyPlus(id_1,id_2,id_3){
  var n1 = document.getElementById(id_1).value;
  var n2 = document.getElementById(id_2).value;
  var n3 = document.getElementById(id_3).value;
  var n4 = (n1 * n2) * n3;
  document.input.sub_amount.value = parseInt(n4);
}

function getSubTotal(){
  var n1 = document.getElementById("qty").value;
  var n2 = document.getElementById("price").value;
  document.input.sub_total.value = parseInt( n1 * n2) ;  
}

function openPhrase(obj_id){
  var url = "usePhrase.jsp?obj_id=" + obj_id;
  window.open(url,"phrase","width=500,height=60");
}

function openCustomer(obj_id,setValue){
 
	var strUrl = "openCustomer.jsp?obj_id=" + obj_id;
	if(setValue){
		strUrl += "&parent_setValue=true"
	}
  window.open(strUrl,"openCustomer","width=800,height=600");
}
 

function openAgent(obj_id){
	var strUrl = "openAgent.jsp?obj_id=" + obj_id;
	window.open(strUrl,"openAgent","width=800,height=600");
}

function openDesigner(obj_id,c_id){
  var url = "useDesigner.jsp?c_id="+c_id+"&obj_id=" + obj_id;
  window.open(url,"phrase","width=500,height=60");
}
 

function openCaseInfo(obj_id,setValue){
  var strUrl = "openCaseInfo.jsp?obj_id=" + obj_id;
	if(setValue){
		strUrl += "&parent_setValue=true"
	}
  window.open(strUrl,"openCaseInfo","width=800,height=600");

}



function openUpload(obj_id,archive,fileName){
  var url = "upload.jsp?obj_id=" + obj_id + "&fileName=" + fileName + "&archive=" + archive;
  window.open(url,"upload","width=800,height=60,scrollbars=yes,resizable");
}
 

function openDetailUpload(obj_id,archive,fileName){
  var url = "upload.jsp?detail=yes&obj_id=" + obj_id + "&fileName=" + fileName + "&archive=" + archive;
  window.open(url,"upload","width=800,height=60,scrollbars=yes,resizable");
}


function ViewOvertime(applicant_id,date_id,kind_type){
  var applicant = document.getElementById(applicant_id).value;
  var aDate = document.getElementById(date_id).value;
  var aKind = document.getElementById(kind_type).value;
  var forwardPage = "OvertimeView.jsp?uid=" + applicant + "&aDate="+ aDate + "&aKind=" + aKind;
  window.open(forwardPage,'overtimeLog','height=400,width=650,scrollbars=yes');
}

function ViewPersonalData(applicant_id,date_id){
  var applicant = document.getElementById(applicant_id).value;
  var aDate = document.getElementById(date_id).value;
  var forwardPage = "PersonalView.jsp?uid=" + applicant + "&aDate="+ aDate;
  window.open(forwardPage,'personalView','height=600,width=900,scrollbars=yes');
}

function changePage(forwardPage) {
  var type = document.getElementById("type").value;
  forwardPage += "?dbAction=" + type;
  location.replace(forwardPage);
}

function deleteDetail() {
  var objForm = document.input;
  objForm.deleteDetailValue.value = "true";
  objForm.submit();
}

function delDetail() {
  document.input.delDetailValue.value = "true";
  document.input.submit();
}

function deleteMembers() {
  var objForm = document.members;
  objForm.deleteMembersValue.value = "true";
  objForm.submit();
}

function setValue() {
  var objForm = document.input;
  objForm.setObjValue.value = "true";
  objForm.submit();
}

function setShowDetail() {
  var objForm = document.input;
  objForm.showDetail.value = "true";
  objForm.submit();
}

function ClearValue() {
  var objForm = document.input;
  objForm.clearValue.value = "true";
  objForm.submit();
}

function getValue() {
  var objForm = document.input;
  objForm.getObjValue.value = "true";
  objForm.submit();
}

function refresh() {
  this.location = this.location;
}

function reload(URLStr) {
  this.location = URLStr;
}

function setSubmitValue(dbAction) {
  var go = false;
  if(dbAction=="delete") {
    var confirmValue = confirm("確定刪除本筆資料!");
    if(confirmValue) go = true;
  } else {
    go = true;
  }
  if(go){
    var objForm = document.input;
    objForm.submitValue.value = "true";
    objForm.submit();
  }
}

function setQueryValue() {
  var objForm = document.input;
  objForm.showDetail.value = "false";
  objForm.submit();
}

function setDataValue() {
  var objForm = document.input;
  objForm.setObjValue.value = "true";
  objForm.setData.value="true";
  objForm.submit();
}

function getData(obj_id) {
  var id = document.getElementById(obj_id).value;
  var type = document.getElementById("type").value;
  location.replace("getData.jsp?id=" + id + "&type=" + type);
}

function add(menu_id) {
  var url = "addUsersDetail.jsp?menu=" + menu_id;
  window.open(url,"addChild","width=600,height=300");
}

function show_detail(forwardPage) {
  window.open(forwardPage,"Flow_detail","scrollbars=yes,resizable",true);
}

function showDetail(forwardPage,windowId,w,h) {
  var windowSize = "width="+w+",height="+h+",scrollbars=yes,resizable";
  window.open(forwardPage,windowId,windowSize);
}

function openAppendix(docUrl,windowId,w,h){
  var windowSize = "width="+w+",height="+h+",scrollbars=yes,resizable";
  window.open(docUrl,windowId,windowSize);
}

function editAuthority(authorityType,keyValue,program_id) {
  var url = "editAuthority.jsp?keyType=" + authorityType + 
                            "&keyValue=" + keyValue +
                                "&prog=" + program_id;
  window.open(url,"editAuthority","width=600,height=300");
}

function cancel() {
  window.close();
  window.opener.location.reload();
}

function changeOrder() {
  location.replace("sales.jsp?changeOrder=true");
}

function addReport(){
  var url = "addReport.jsp";
  window.open(url,"addReport","width=600,height=500");
}

function setDate() {
  var YYF = document.getElementById("YYF").value;
  var MMF = document.getElementById("MMF").value;
  var DDF = document.getElementById("DDF").value;
  var HHF = document.getElementById("HHF").value;  
  var dateFrom = YYF + "-" + MMF + "-" + DDF + " " + HHF + ":00:00"; 
  document.all.date_from.value = dateFrom;
  var YYT = document.getElementById("YYT").value;
  var MMT = document.getElementById("MMT").value;
  var DDT = document.getElementById("DDT").value;
  var HHT = document.getElementById("HHT").value;
  var dateTo = YYT + "-" + MMT + "-" + DDT + " " + HHT + ":00:00";
  document.all.date_to.value = dateTo;
}

function setFilter(url){
  var forward = url;
  var year = document.getElementById("year").value;
  var month = document.getElementById("month").value;
  url += "?year=" + year + "&month=" + month;
  location.replace(url);
}

function getTotalHours(date_from,date_to,includeWeekend) {	
  var small_date = new Date(date_from.substr(0,4),date_from.substr(5,2) - 1,date_from.substr(8,2));
  var large_date = new Date(date_to.substr(0,4),date_to.substr(5,2) - 1,date_to.substr(8,2));
  var hour_from;
  if(date_from.substr(11,1)=='0')
    hour_from = parseInt(date_from.substr(12,1));
  else 
    hour_from = parseInt(date_from.substr(11,2));
  var hour_to;
  if(date_to.substr(11,1)=='0')
    hour_to = parseInt(date_to.substr(12,1));
  else 
    hour_to = parseInt(date_to.substr(11,2));
  var hours = 0;
  var baseHourFrom = 9;
  var baseHourTo = 18;
  var include = false;
  if(includeWeekend=="Yes") include = true;
  if(hour_from <= 8) {
    baseHourFrom = 8;
    baseHourTo = 17;
  }
  if(small_date.getTime() > large_date.getTime()) {
    return 0;
  }
  if(hour_from < baseHourFrom) hour_from = baseHourFrom;
  if(hour_to > baseHourTo) hour_to = baseHourTo;
  if(small_date.getTime()==large_date.getTime()) {
    if(hour_from > hour_to) {
      return 0;
    }
    hours = hour_to - hour_from;
    if(hour_from<=12 && hour_to >=13) {
      hours--;
    }
  } else {
    var days = 0;
    var holiday = 0;
    while(small_date.getTime() != large_date.getTime()) {
      if(!include && (small_date.getDay()==6 || small_date.getDay()==0)) holiday++;
      small_date.setDate(small_date.getDate() + 1);
      if(small_date.getTime() == large_date.getTime()) {
        days++;
        if(!include && (small_date.getDay()==6 || small_date.getDay()==0)) holiday++;
      }
      days++;
    } 
    hours = baseHourTo - hour_from;
    if(hour_from <=12) hours--;
    hours += hour_to - baseHourFrom;
    if(hour_to > 12) hours--;
    hours += (days-holiday-2)*8;
  }
  return hours;
}

function calculateDay(date_from_id, date_to_id,includeWeekend_id) {
  var date_from = document.getElementById(date_from_id).value;
  var date_to = document.getElementById(date_to_id).value; 
  var includeWeekend = document.getElementById(includeWeekend_id).value;
  if(date_from.length == 0 || date_to.length == 0) return;
  date_from += " 00:00:00";
  date_to += " 23:59:59";
  var hours = getTotalHours(date_from,date_to,includeWeekend);
  var days = (hours-(hours%8))/8;
  this.document.input.days.value = days;
}

function calculateDays(date_from_id, date_to_id) {
  var date_from = document.getElementById(date_from_id).value;
  var date_to = document.getElementById(date_to_id).value; 
  var includeWeekend = "No";
  if(date_from.length == 0 || date_to.length == 0) return;
  date_from += " 00:00:00";
  date_to += " 23:59:59";
  var hours = getTotalHours(date_from,date_to,includeWeekend);
  var days = (hours-(hours%8))/8;
  this.document.input.days.value = days;
}

function calculateDays_Hours(date_from_id, date_to_id, hour_from_id, hour_to_id) {
  var date_from = document.getElementById(date_from_id).value;
  var date_to = document.getElementById(date_to_id).value;
  var hour_from = document.getElementById(hour_from_id).value;
  var hour_to = document.getElementById(hour_to_id).value;
  var includeWeekend = "No";
  if(date_from.length == 0 || date_to.length == 0 || 
     hour_from.length == 0 || hour_to.length == 0) return;
  date_from += " " + hour_from + ":00:00";
  date_to += " " + hour_to + ":00:00";

  var hours = getTotalHours(date_from,date_to,includeWeekend);
  var hour = hours % 8;
  var days = (hours-hour)/8;
  this.document.input.days.value = days;
  this.document.input.hours.value = hour;
}
 
function calculateDay_Hour(date_from_id, date_to_id) {
  var date_from = document.getElementById(date_from_id).value;
  alert(date_from);
  var date_to = document.getElementById(date_to_id).value;
  var includeWeekend = "No";
  if(date_from.length == 0 || date_to.length == 0) return;
  var hours = getTotalHours(date_from,date_to,includeWeekend);
  var hour = hours % 8;
  var days = (hours-hour)/8;
  document.input.day.value = days;
  document.input.hour.value = hour;
}

function chkDays_Hours(number_id) {
  var numberStr = document.getElementById(number_id).value;
  var strLength = numberStr.length;
  flag = false;
  for(i=0;i<strLength;i++){
    var no = numberStr.charAt(i);
    if(no<'0' || no>'9'){
      document.input.days.value="0";
      document.input.hours.value="0";
      calculateDays_Hours("date_from", "date_to", "hour_from", "hour_to");
      break;
    }
  }
}

function chkDays(number_id) {
  var numberStr = document.getElementById(number_id).value;
  var strLength = numberStr.length;
  for(i=0;i<strLength;i++){
    var no = numberStr.charAt(i);
    if(no<'0' || no>'9'){
      document.input.days.value="0";
      calculateDays("date_from", "date_to");
      break;
    }
  }
}

function printPdf(pdfPath) {
  window.open(pdfPath,'printPdf','scrollbars=yes,resizable');
}

function openCsv(pdfPath) {
  window.open(pdfPath,'newCSV','','true');
}

function calculateHours(){
  var hour_from = document.getElementById("hour_from").value;
  var hour_to = document.getElementById("hour_to").value;
  document.input.hours.value = hour_to - hour_from;
}

function chkHours() {
  var numberStr = document.getElementById("hours").value;
  var strLength = numberStr.length;
  for(i=0;i<strLength;i++){
    var no = numberStr.charAt(i);
    if(no<'0' || no>'9'){
      document.input.hours.value="0";
      calculateHours();
      break;
    }
  }
}

function openCalendar(obj_id) {
  var url = "calendar.jsp?obj_id=" + obj_id + "&time=false";
  window.open(url,"calendar","width=650,height=600");
}

function checkNumber(obj_id) {
  var fieldValue = document.getElementById(obj_id).value;
  var strLength = fieldValue.length;
  for(i=0;i<strLength;i++){
    var no = fieldValue.charAt(i);
    if(no<'0' || no>'9'){
     	if(no!='.'){
        document.getElementById(obj_id).value="0";
        alert("數字欄位有非法字元!");
        break; 
      }
    }
  }
}

function checkMaxLength(obj_id,maxLength) {
  var fieldValue = document.getElementById(obj_id).value;
  var strLength = fieldValue.length;
  if(strLength>maxLength){
    alert("欄位長度不可超過 "+maxLength+" 字元");
  }
}

function openDateTime(obj_id) {
  var url = "calendar.jsp?obj_id=" + obj_id + "&time=true";
  window.open(url,"calendar","width=650,height=600");
}