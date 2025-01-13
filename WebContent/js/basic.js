﻿﻿function IsValidDate(val) {

    var RetVal = false;
    var ValidDate;

    try {
        ValidDate = $.datepicker.parseDate("yy/mm/dd", val.replace(/\-/g, "/"));
        RetVal = true;
    }
    catch (ex) {
    	//console.log(ex);
    }

    return RetVal;
}

//add by alextsai, 2010/08/06
function checkAllCheckBox(obj,name){
	var objs = document.getElementsByName(name);
	//var type = document.input.type;
	var checked = obj.checked;
	if(objs){
		for(var i=0;i<objs.length;i++) {
			objs[i].checked = checked;
		}
	}
}

function resetCountryValue() {
	var data = "";
	var country = document.input.country;
	if(country){
		for(var i=0;i<country.length;i++) {
			if(country[i].checked) {
				data += country[i].value + ", ";
			}
		}
		document.input.countryData.value = data;
	}	
}

function resetTypeValue() {
	var data = "";
	var type = document.input.type;
	if(type){
		for(var i=0;i<type.length;i++) {
			if(type[i].checked) {
				data += type[i].value + ", ";
			}
		}
		document.input.typeData.value = data;
	}
}

function calTaxed() {
	if(!document.getElementById('taxed').checked) {
		document.input.taxAmount.value = '0';
		document.input.amountIncludeTax.value = '0';
		return;
	}
	
	var NtdwoTaxAmount = document.input.ntdwoTaxAmount.value;
	if(!NtdwoTaxAmount) {
		document.input.taxAmount.value = '0';
		document.input.amountIncludeTax.value = '0';
	}
  else {
	  document.input.taxAmount.value = Math.round(NtdwoTaxAmount * 0.05);
		document.input.amountIncludeTax.value = Math.round(NtdwoTaxAmount * 1.05);
  }
}
function calAttorneyIncomeTax() {
	if (!document.getElementById('attorneyIncomeTax').checked) {
		document.input.taxAmount2.value = '0';
		document.input.shouldPay.value = '0';
		return;
	}

	var NtdwoTaxAmount = 0;
	NtdwoTaxAmount = document.input.ntdwoTaxAmount.value;
	if (!NtdwoTaxAmount) {
		document.input.taxAmount2.value = '0';
		document.input.shouldPay.value = '0';
	} else {
		document.input.taxAmount2.value = Math.round(NtdwoTaxAmount * 0.1);

		if (!document.input.taxAmount.value) {
			document.input.shouldPay.value = parseInt(NtdwoTaxAmount, 10) + 0
					- Math.round(NtdwoTaxAmount * 0.1);
		} else {
			document.input.shouldPay.value = parseInt(NtdwoTaxAmount, 10)
					+ parseInt(document.input.taxAmount.value, 10)
					- Math.round(NtdwoTaxAmount * 0.1);
		}
	}
}


function calNtdwoTaxAmount() {
    var selecter = document.getElementById('currency');
    var currency = selecter[selecter.selectedIndex].value;
    var rate = rates[currency];
    
    var invoiceAmount = document.input.invoiceAmount.value;
    if(!invoiceAmount || selecter.selectedIndex == 0) {
        document.input.ntdwoTaxAmount.value = 0;
    }
    else {
        document.input.ntdwoTaxAmount.value = rate * invoiceAmount;
    }
    
    calTaxed();
    calAttorneyIncomeTax();
}

function resetConfigItemValue() {
	var data = "";
	var configItem = document.getElementsByName("configItem");
	for(var i=0;i<configItem.length;i++) {
		if(configItem[i].checked) {
			data += configItem[i].value + ",";
		}
	}
	document.input.configItemData.value = data;
}

function resetConfigItemValue2() {
	var data = "";
	var configItem = document.getElementsByName("configItem");
	for(var i=0;i<configItem.length;i++) {
		if(configItem[i].checked) {
			var value = "";
			value = configItem[i].value + ",";
			
			value += document.getElementById("baseDate" + i).value + ",";
			
			value += document.getElementById("remindDate" + i).value + ",";
			
			value += document.getElementById("legalDueDate1" + i).value + ",";
			
			value += document.getElementById("assignedTo" + i).value + ",";
			
			value += document.getElementById("assignStatus" + i).value + ";";
			
//			if(document.getElementById("isPoints" + i).checked) {
//				value += "Y;";
//			}
//			else {
//				value += "N;";
//			}
			
//			if(document.getElementById("isCharge" + i).checked) {
//				value += "Y,";
//			}
//			else {
//				value += ",";
//			}
//			if(document.getElementById("isPayment" + i).checked) {
//				value += "Y,";
//			}
//			else {
//				value += ",";
//			}
//				
//			value += document.getElementById("accountTitle" + i).value + "," +
//				document.getElementById("currency" + i).value + "," +
//				document.getElementById("amount" + i).value + "," +
//				document.getElementById("twdAmount" + i).value + ";";

			data += value;
		}
	}

	document.input.configItemData.value = data;
}

function gotoSelectedPatentCase(){
	var selecter = document.getElementById('searchCaseList');
	document.input.currentRecord.value = selecter.selectedIndex + 1;
	document.input.flowKey.value = selecter.options[selecter.selectedIndex].value;
	document.input.pageActionMode.value='maintain';
	document.input.getDataFlag.value='true';
	
	setValue();
}

function resetResultFieldValue() {
	var data = "";
	var resultFields = document.input.resultField;
	for(var i=0;i<resultFields.length;i++) {
		if(resultFields[i].checked) {
			data += resultFields[i].value + ",";
		}
	}
	document.input.resultFieldValue.value = data;
}

//給connectlist使用
function resetResultFieldValue2() {
	var data = "";
//	var resultFields = document.input.resultField;
//	for(var i=0;i<resultFields.length;i++) {
//		if(resultFields[i].checked) {
//			data += resultFields[i].value + ",";
//		}
//	}
	$("#sortable2").find('li').each(function(index) {
		data += $(this).attr('id') + ",";
	});

	document.input.resultFieldValue.value = data;
	document.input.exportCsv2.value="true";
	setValue();
}



function showFlash(w,h,srcFlash){
  AC_FL_RunContent( '','','width',w,'height',h,
                    'src',srcFlash,'','','','','',srcFlash)
;;
}
 

function printHTML(w,h,tagId){
  var pageUrl = "printHTML.jsp?printTagId="+tagId;
  var windowSize = 'width='+w+',height='+h+',scrollbars=yes,resizable,memu=on';
  window.open(pageUrl,'printHTML',windowSize);
}

function openPhrase(obj_id){
  var url = "usePhrase.jsp?obj_id=" + obj_id;
  window.open(url,"phrase","width=500,height=60");
}

function openQueringForm(formName,obj_id,setValue,widthLength,heightLength){
 
	var strUrl = formName+".jsp?obj_id=" + obj_id;
	if(setValue){
		strUrl += "&parentSetValue=true"
	}
  window.open(strUrl,formName,"width="+widthLength+",height="+heightLength);
}

function openUpload(obj_id,archive,fileName){
  var url = "upload.jsp?obj_id=" + obj_id + "&fileName=" + fileName + "&archive=" + archive;
  window.open(url,"upload","width=800,height=60,scrollbars=yes,resizable");
}

function openUpload(obj_id,archive,fileName,descriptionField){
	  var url = "upload.jsp?obj_id=" + obj_id + "&fileName=" + fileName + "&archive=" + archive + "&descriptionField=" + descriptionField ;
	  window.open(url,"upload","width=800,height=60,scrollbars=yes,resizable");
}
 

function openDetailUpload(obj_id,archive,fileName){
  var url = "upload.jsp?detail=yes&obj_id=" + obj_id + "&fileName=" + fileName + "&archive=" + archive;
  window.open(url,"upload","width=800,height=60,scrollbars=yes,resizable");
}

function switchPage(forwardPage,dbActionMode,objKey) {
 
  if(objKey.length>0) objKey = "&flowKey="+objKey;
  forwardPage += "?dbActionMode=" + dbActionMode +objKey;
  location.replace(forwardPage);
}

function setValue(){
  document.input.submit();
}
function setDraftValue(){
  if(document.input.dbActionMode.value=='insert') {
	document.input.flowKey.value='';  
  }
  setSubmit();
}

function setPatentCaseValue(){
	if(document.input.dbActionMode.value=='insert' && document.input.oldCaseFlowKeyValue== null) {
		document.input.fromCase.value = '';
		document.input.oldCaseFlowKey.value = document.input.flowKey.value;
	}
	setSubmit();
}

function AjaxSetValue(className,tagId,tagValue,reflashTagId,reflashMode){
  doAjaxRequest(className,tagId,tagValue,reflashTagId,reflashMode);
}

function gotoData(objKey){
	document.input.flowKey.value=objKey;
  document.input.pageActionMode.value='maintain';
  document.input.getDataFlag.value='true';
  setValue();
}

function setOrderKey(orderValue){
	var srcOrderKey = document.input.orderKey.value;
 
	if(srcOrderKey!=orderValue){
		document.input.orderSequence.value='asc';
	} else {
		if(document.input.
orderSequence.value=='asc'){
			document.input.orderSequence.value='desc'; 
		} else {
			document.input.orderSequence.value='asc';
		}
	}
	document.input.orderKey.value=orderValue;
	document.input.doSearchFlag.value='true';
  setValue();
}

function refresh() {
  this.location = this.location;
}

function reload(forwardPage) {
  this.location = forwardPage;
}


function openAppendix(docUrl,windowId,w,h){
  if(docUrl.indexOf('.jsp') == -1) {
	  downloadFile(docUrl);
  }
  else {
	  var windowSize = "width="+w+",height="+h+",scrollbars=yes,resizable";
	  window.open(docUrl,windowId,windowSize);
  }
}

function printPdf(pdfPath) {
  window.open(pdfPath,'printPdf','scrollbars=yes,resizable');
}

function openCsv(pdfPath) {
  window.open(pdfPath,'newCSV','','true');
}

function openCalendar(obj_id) {
  var url = "calendar.jsp?obj_id=" + obj_id + "&time=false";
  window.open(url,"calendar","width=640,height=480");
}
function openCalendarAndChange(obj_id,changeFunction) {
	  var DataChangeFunction = changeFunction;
	  var url = "calendar.jsp?obj_id=" + obj_id + "&time=false&OnChangeFunction="+changeFunction;
	  window.open(url,"calendar","width=640,height=480");
	}

function openDateTime(obj_id) {
  var url = "calendar.jsp?obj_id=" + obj_id + "&time=true";
  window.open(url,"calendar","width=640,height=520");
}

function openDateTime1(obj_id) {
  var url = "calendar.jsp?obj_id=" + obj_id + "&time=true&hour=9";
  window.open(url,"calendar","width=640,height=520");
}

function openDateTime2(obj_id) {
  var url = "calendar.jsp?obj_id=" + obj_id + "&time=true&hour=18";
  window.open(url,"calendar","width=640,height=520");
}

function openDateTime1AndChange(obj_id,changeFunction) {
  var DataChangeFunction = changeFunction;
  var url = "calendar.jsp?obj_id=" + obj_id + "&time=true&hour=9&OnChangeFunction="+changeFunction;
  window.open(url,"calendar","width=640,height=520");
}

function openDateTime2AndChange(obj_id,changeFunction) {
  var DataChangeFunction = changeFunction;
  var url = "calendar.jsp?obj_id=" + obj_id + "&time=true&hour=18&OnChangeFunction="+changeFunction;
  window.open(url,"calendar","width=640,height=520");
}

function countLeaveDay() {
	var date_from = document.getElementById('dateFrom').value;
  var date_to = document.getElementById('dateTo').value;
  var includeWeekend = "No";
  if(date_from.length == 0 || date_to.length == 0) return;
  var hours = getTotalHours(date_from,date_to,includeWeekend);
  var hour = hours % 8;
  var days = (hours-hour)/8;
  document.input.day.value = days;
  document.input.hour.value = hour;
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

function checkMaxLength(obj_id,maxLength) {
  var fieldValue = document.getElementById(obj_id).value;
  var strLength = fieldValue.length;
  if(strLength>maxLength){
    alert( "欄位長度不可超過 "+maxLength+" 字元" );
  }
}


function checkInt(obj) {
  var fieldValue = obj.value;
  var strLength = fieldValue.length;
  for(i=0;i<strLength;i++){
    var no = fieldValue.charAt(i);
    if(no<'0' || no>'9'){
     	if(no!='-' || i>0){
     		obj.value="0";
        alert( "數字欄位有非法字元!" );
        break;
      }
    }
  }
}

function checkNumber(obj_id) {
  var fieldValue = document.getElementById(obj_id).value;
  var strLength = fieldValue.length;
  for(i=0;i<strLength;i++){
    var no = fieldValue.charAt(i);
    if(no<'0' || no>'9'){
     	if(no!='-' || i>0){
        document.getElementById(obj_id).value="0";
        alert( "數字欄位有非法字元!" );
        break;
      }
    }
  }
}
 

function checkNumberDefault(obj_id,defaultValue) {
  var fieldValue = document.getElementById(obj_id).value;
  var strLength = fieldValue.length;
  for(i=0;i<strLength;i++){
    var no = fieldValue.charAt(i);
    if(no<'0' || no>'9'){
      if(no!='-' || i>0){
        document.getElementById(obj_id).value=defaultValue;
        alert( "數字欄位有非法字元!" );
        break;
      }
    }
  }
}

function checkFloat(obj_id) {
	  var fieldValue = document.getElementById(obj_id).value;
	  fieldValue = replaceAll(fieldValue, ",", "");
	  
	  var reg = /^[0-9]+(\.[0-9]{1,})?$/;
	  
	  if(!reg.test(fieldValue)) {
	        document.getElementById(obj_id).value="0";
	        alert( "數字欄位有非法字元!" );
	  }
	}

function checkFloat(obj_id, decimal) {
	  var fieldValue = document.getElementById(obj_id).value;
	  fieldValue = replaceAll(fieldValue, ",", "");
	  
	  var reg = /^[0-9]+(\.[0-9]{1,})?$/;
	  
	  if(!reg.test(fieldValue)) {
	        document.getElementById(obj_id).value="0";
	        alert( "數字欄位有非法字元!" );
	  }
	  
	  if(fieldValue.indexOf('.') != -1) {
		  if(fieldValue.length - fieldValue.indexOf('.') > decimal + 1) {
			  alert( "數字欄位超過規定的" + decimal + '位小數!' );
		  }
	  }
	}

function checkNumberLength(obj_id, length) {
	  var fieldValue = document.getElementById(obj_id).value;
	  if(fieldValue.length != length) {
		  alert('請輸入' + length + '位數字');
	  }
	  var reg =  /^[0-9]*$/;
	  
	  if(!reg.test(fieldValue)) {
		  alert('請輸入' + length + '位數字');
	  }
	}

function replaceAll(strOrg,strFind,strReplace){
	 var index = 0;
	 while(strOrg.indexOf(strFind,index) != -1){
	  strOrg = strOrg.replace(strFind,strReplace);
	  index = strOrg.indexOf(strFind,index);
	 }
	 return strOrg
	} 

function setSubmitValue(dbAction){
  var go = false;
  if(dbAction=="delete"){
    var confirmValue=confirm( "確定刪除本筆資料!" );
    if(confirmValue) go=true;
  } else {
    go=true;
  }
  if(go){
    var objForm = document.input;
    objForm.submitFlag.value="true";
    objForm.submit();
  }
}
function DateAdd(interval,number,date)
{
	switch(interval.toLowerCase())
	{
		case "y": return new Date(date.setFullYear(date.getFullYear()+number));
		case "m": return new Date(date.setMonth(date.getMonth()+number));
		case "d": return new Date(date.setDate(date.getDate()+number));
		case "w": return new Date(date.setDate(date.getDate()+7*number));
		case "h": return new Date(date.setHours(date.getHours()+number));
		case "n": return new Date(date.setMinutes(date.getMinutes()+number));
		case "s": return new Date(date.setSeconds(date.getSeconds()+number));
		case "l": return new Date(date.setMilliseconds(date.getMilliseconds()+number));
	} 
}
function AddZero(varValue)
{
	if(varValue.length==1)
	{
    	return '0'+varValue+'';
    }
    else
    {
    	return varValue;
    }
 }

function regDate(sDate){
	sDate = sDate.replace(new RegExp('/', 'g'),  '');
	if(isNaN(sDate)) {
		return false;
	}
	var date = new String(sDate);
	if(date.length!=8) {
		return false;
	}

	var year = date.substring(0,4);
	var month = date.substring(4,6);
	var day = date.substring(6,8);

	var arrayMonth = new Array(31,28,31,30,31,30,31,31,30,31,30,31);
				
	if(year.charAt(0) == '0'){
			year = year.charAt(1) + year.charAt(2);
	}

	if(month > 12) {
		return false;
	}
	var checkDay = 0;
	if(month == 2){
		if( ( (0 == year % 4) && (0 != (year % 100)) ) || (0 == year % 400) ){
			checkDay = 29;
		}else{
			checkDay = 28;
		}
	}else{
		checkDay = arrayMonth[month-1];
	}
	if(day<1){
		return false;
	}else if(day > checkDay){
		return false;
	} else {
		return true;
	}
			
	return false;
}

/*
Date regular expression (YYYY-MM-DD)
*/
function checkdate(obj) {
  var p_date = obj.value;
  var result = false;
  var re1 = /^\d{4}\-(0[1-9]|1[0-2])\-(3[0-1]|[0-2][0-9])$/;
  var len = p_date.length;        
  if(p_date != null && p_date != ""){
	if(!regDate(p_date))
		  result = false;
  	if(len==10){
      if(!p_date.match(re1)) { 
    	  result = false ;
      }else{ 
    	  result = true ;
      } 
  	}
  	else if(len==8) { //yyyymmdd自動變成yyyy-mm-dd
  		var newDate = p_date.substring(0, 4) + "-" + p_date.substring(4, 6) + "-" + p_date.substring(6, 8);
  		if(!newDate.match(re1)) { 
      	  result = false ;
        }
  		else{ 
      	  result = true ;
          obj.value = newDate;
        } 
  	}//日期欄位可預設當年度年份(仍可手動修改)，eg.:輸入1015即可自動代為2012-10-15 
  	else if(len==4) {
  		var newDate = new Date().getFullYear() + "-" + p_date.substring(0, 2) + "-" + p_date.substring(2, 4);
  		if(!newDate.match(re1)) { 
      	  result = false ;
        }
  		else{ 
      	  result = true ;
          obj.value = newDate;
        } 
  	}
  	else {
  		result = false;
  	}
  }else{
	  result = true ;
  }
  
  if(!result) {
	  alert('請輸入正確的日期格式字串');
	  window.setTimeout("document.getElementById('" + obj.id + "').focus();",50);
  }
  else {
	  if (!IsValidDate(obj.value)) {
			alert('請輸入正確的日期格式字串');
			  window.setTimeout("document.getElementById('" + obj.id + "').focus();",50);
		}
  }
}

/*
Date regular expression (YYYY-MM-DD HH:MM:SS)
*/
function checkDateTime(obj) {
	  var p_time = obj.value;
	  var result = false;
	  var re =/^\d{4}\-(0[1-9]|1[0-2])\-(3[0-1]|[0-2][0-9]) ([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$/;
	  var len=p_time.length;
	  if(p_time != null && p_time != ""){
		  if(len==19){
			  if(!p_time.match(re)) { 
				  result =  false ;
			  }else{ 
				  result =  true ;
			  } 
		  }
		  else{
			  result =  false ;
		  }
	  }
	  else{
		  result = true ;
	  }
	  if(!result) {
		  alert('請輸入正確的日期時間格式字串');
		  window.setTimeout("document.getElementById('" + obj.id + "').focus();",50);
	  }
}

function getPatentFlowKey() {
	if(document.input.patentOffice.value == '') {
		alert('請輸入申請國家!');
		return;
	}
	if(document.input.patentType.value == '') {
		alert('請選擇案件類別!');
		return;
	}
	if(document.input.client.value == '') {
		alert('請選擇客戶!');
		return;
	}
	document.input.genFlowKeyFlag.value='true';
	setValue();
}


function getPatentFlowKey2() {
	if(document.input.patentOffice.value == '') {
		alert('請輸入申請國家!');
		return;
	}
	if(document.input.patentType.value == '') {
		alert('請選擇案件類別!');
		return;
	}
	if(document.input.client.value == '') {
		alert('請選擇客戶!');
		return;
	}
	document.input.genFlowKeyFlag2.value='true';
	setValue();
}

function getTrademarkFlowKey() {
	if(document.input.office.value == '') {
		alert('請輸入申請國家!');
		return;
	}
	
	if(document.input.client.value == '') {
		alert('請選擇客戶!');
		return;
	}		
	
	
	document.input.genFlowKeyFlag.value='true';
	setValue();
}

function getTrademarkFlowKey2() {
	if(document.input.office.value == '') {
		alert('請輸入申請國家!');
		return;
	}
	
	if(document.input.client.value == '') {
		alert('請選擇客戶!');
		return;
	}		
	
	document.input.genFlowKeyFlag2.value='true';
	setValue();
}

function getCopyrightFlowKey() {
	if(document.input.office.value == '') {
		alert('請輸入申請國家!');
		return;
	}
	document.input.genFlowKeyFlag.value='true';
	setValue();
}

function getCopyrightFlowKey2() {
	if(document.input.office.value == '') {
		alert('請輸入申請國家!');
		return;
	}
	document.input.genFlowKeyFlag2.value='true';
	setValue();
}



function getLegalFlowKey() {
	document.input.genFlowKeyFlag.value='true';
	setValue();
}

function getLegalFlowKey2() {
	document.input.genFlowKeyFlag2.value='true';
	setValue();
}

function getStandardFlowKey() {
	if(document.input.caseKind.value == '') {
		alert('請輸入案件類型!');
		return;
	}
	if(document.input.matterName.value == '') {
		alert('請輸入程序名稱!');
		return;
	}
	document.input.genFlowKeyFlag.value='true';
	setValue();
}

function resetFinishedCheckbox(index) {
	var finishedItem = document.getElementsByName("finished");
	finishedItem[index].checked = "checked";
}

function resetFinishedValue() {
	var data = "";
	var finishedItem = document.getElementsByName("finished");
	for(var i=0;i<finishedItem.length;i++) {
		if(finishedItem[i].checked) {
			data += finishedItem[i].value + ",";
		}
	}
	document.input.finishedItemData.value = data;
}

function resetFinishedDateValue() {
	var data = "";
	var finishedItem = document.getElementsByName("finished");
	for(var i=0;i<finishedItem.length;i++) {
		if(finishedItem[i].checked) {
			data += document.input['finishedDate' + i].value + ",";
		}
	}

	document.input.finishedDateData.value = data;
}

function addMonthToDate(month, id){
	var d = new Date();
	document.getElementById(id).value=d.format('yyyy-MM-dd');
	var d2=DateAdd('m',month,d);
	document.getElementById(id).value=d2.format('yyyy-MM-dd');
}

function addDayToDate(day, id){
	var d = new Date();
	document.getElementById(id).value=d.format('yyyy-MM-dd');
	var d2=DateAdd('d',day,d);
	document.getElementById(id).value=d2.format('yyyy-MM-dd');
}

function round(value,num){
  return Math.round(value * Math.pow(10,num)) / Math.pow(10,num);
}

function multiplicationById(id1, id2, toId, scale) {
try {
	var reg = /^[0-9]+(\.[0-9]{1,})?$/;
	var value1 = document.getElementById(id1).value;
	var value2 = document.getElementById(id2).value;

	value1 = replaceAll(value1, ",", "");
	value2 = replaceAll(value2, ",", "");
	
	if(!reg.test(value1)) {
		value1 = 0;
	}
	
	if(!reg.test(value2)) {
		value2 = 0;
	}
	
	document.getElementById(toId).value = round(value1 * value2, scale);;
}
catch(e){
	alert(e);
}
}

function multiplicationByValue(value1, value2, toId, scale) {
	var reg = /^[0-9]+(\.[0-9]{1,})?$/;
	
	value1 = replaceAll(value1, ",", "");
	value2 = replaceAll(value2, ",", "");
	
	if(!reg.test(value1)) {
		value1 = 0;
	}
	
	if(!reg.test(value2)) {
		value2 = 0;
	}
	
	document.getElementById(toId).value = round(value1 * value2, scale);;
}


function multiplicationBy3Value(value1, value2, value3, toId, scale) {
	var reg = /^[0-9]+(\.[0-9]{1,})?$/;
	
	value1 = replaceAll(value1, ",", "");
	value2 = replaceAll(value2, ",", "");
	value3 = replaceAll(value3, ",", "");
	
	if(!reg.test(value1)) {
		value1 = 0;
	}

	if(!reg.test(value2)) {
		value2 = 0;
	}
	
	if(!reg.test(value3)) {
		value3 = 0;
	}
	
	//alert(value1+" " +value2+" " +value3);
	
	
	document.getElementById(toId).value = round(value1 * value2 * value3, scale);;
}


function multiplicationByIdCheck(checkId, id1, id2, id3, scale) {
	if(document.getElementById(checkId).checked) {
		multiplicationById(id1, id2, id3, scale);
	}
}

function multiplicationByValueCheck(checkId, value1, value2, id3, scale) {
	if(document.getElementById(checkId).checked) {
		multiplicationByValue(value1, value2, id3, scale);
	}
}

function subtractionById(id1, id2, toId) {
	var reg = /^[0-9]+(\.[0-9]{1,})?$/;
	var value1 = document.getElementById(id1).value;
	var value2 = document.getElementById(id2).value;

	value1 = replaceAll(value1, ",", "");
	value2 = replaceAll(value2, ",", "");
	
	if(!reg.test(value1)) {
		value1 = 0;
	}
	
	if(!reg.test(value2)) {
		value2 = 0;
	}
	
	document.getElementById(toId).value = value1 - value2;
}

function subtractionByValue(value1, value2, toId) {
	var reg = /^[0-9]+(\.[0-9]{1,})?$/;

	value1 = replaceAll(value1, ",", "");
	value2 = replaceAll(value2, ",", "");
	
	if(!reg.test(value1)) {
		value1 = 0;
	}
	
	if(!reg.test(value2)) {
		value2 = 0;
	}
	
	document.getElementById(toId).value = value1 - value2;
}


function selectAllResultField(obj) {
	var resultField = document.getElementsByName('resultField');
	var len = resultField.length;
    var checked = false;

    for (i = 0; i < len; i++)
    {
        if (obj.checked)
        {
        	resultField[i].checked = "true";
        }
        else {
        	resultField[i].checked = "";
        }
    } 
    
    resetResultFieldValue();
}

Date.prototype.format = function(format){
var o = {
"M+" : this.getMonth()+1, //month
"d+" : this.getDate(), //day
"h+" : this.getHours(), //hour
"m+" : this.getMinutes(), //minute
"s+" : this.getSeconds(), //second
"q+" : Math.floor((this.getMonth()+3)/3), //quarter
"S" : this.getMilliseconds() //millisecond
}
if(/(y+)/.test(format)) 
format=format.replace(RegExp.$1,(this.getFullYear()+"").substr(4 - RegExp.$1.length));
for(var k in o)if(new RegExp("("+ k +")").test(format))
format = format.replace(RegExp.$1,RegExp.$1.length==1 ? o[k] :("00"+ o[k]).substr((""+ o[k]).length));
return format;
}

function setTodayToField(obj, fieldId) {
	if(!obj.checked) {
		document.getElementById(fieldId).value = '';
	}
	else {
		var date = new Date();
		
		var month = date.getMonth() + 1;
		if(month < 10) {
			month = "0" + month;
		}
		
		var day = date.getDate();
		if(day < 10) {
			day = "0" + day;
		}
		
		
		document.getElementById(fieldId).value = date.getFullYear() + "-" + month + "-" + day;
	}
}


function setTodayToField2(obj, fieldId) {
	var date = new Date();
	if(obj.value != 'TDS02') {
		document.getElementById(fieldId).value = '';
	}
	else {
		var month = date.getMonth() + 1;
		if(month < 10) {
			month = "0" + month;
		}
		
		var day = date.getDate();
		if(day < 10) {
			day = "0" + day;
		}
		
		
		document.getElementById(fieldId).value = date.getFullYear() + "-" + month + "-" + day;
	}
}

//廢除，因為TDS01=未完成，不需要判斷承辦人
function setTodosStatus(obj) {
  if (obj.value != '' && document.input.finishedDate.value == '') {
      //document.input.toDosStatus.value = 'TDS01';
  }
}
function setTodosStatus2(obj) {
	if(obj.value != '') {
		document.input.toDosStatus.value = 'TDS02';
	}
	else {
		document.input.toDosStatus.value = 'TDS01';
	}
}

function multiplicationById(id1, id2, toId, scale) {
try {
	var reg = /^[0-9]+(\.[0-9]{1,})?$/;
	var value1 = document.getElementById(id1).value;
	var value2 = document.getElementById(id2).value;

	value1 = replaceAll(value1, ",", "");
	value2 = replaceAll(value2, ",", "");
	
	if(!reg.test(value1)) {
		value1 = 0;
	}
	
	if(!reg.test(value2)) {
		value2 = 0;
	}
	
	document.getElementById(toId).value = round(value1 * value2, scale);;
}
catch(e){}
}

function multiplicationByValue(value1, value2, toId, scale) {
	var reg = /^[0-9]+(\.[0-9]{1,})?$/;
	
	value1 = replaceAll(value1, ",", "");
	value2 = replaceAll(value2, ",", "");
	
	if(!reg.test(value1)) {
		value1 = 0;
	}
	
	if(!reg.test(value2)) {
		value2 = 0;
	}
	
	document.getElementById(toId).value = round(value1 * value2, scale);;
}

function multiplicationByValue2(value1, value2, toId, scale) {
	var reg = /^[0-9]+(\.[0-9]{1,})?$/;
	
	value1 = replaceAll(value1, ",", "");
	value2 = replaceAll(value2, ",", "");
	
	if(!reg.test(value1)) {
		value1 = 0;
	}
	
	if(!reg.test(value2)) {
		value2 = 0;
	}
	
	document.getElementById(toId).value = round(value1-(value1 / value2), scale);;
}

function multiplicationByIdCheck(checkId, id1, id2, id3, scale) {
	if(document.getElementById(checkId).checked) {
		multiplicationById(id1, id2, id3, scale);
	}
}

function multiplicationByValueCheck(checkId, value1, value2, id3, scale) {
	if(document.getElementById(checkId).checked) {
		multiplicationByValue(value1, value2, id3, scale);
	}
}

function multiplicationByValueCheck2(checkId, value1, value2, id3, scale) {
	if(document.getElementById(checkId).checked) {
		multiplicationByValue2(value1, value2, id3, scale);
	}
}

function resetCheckDraftDataValue() {
	var data = "";
	var checkDatas = document.input.checkDraftData;
	if(checkDatas.length) {
		for(var i=0;i<checkDatas.length;i++) {
			if(checkDatas[i].checked) {
				data += checkDatas[i].value + ",";
			}
		}
	}
	else {
		data = checkDatas.value + ",";
	}
	document.input.checkDataValue.value = data;
}


function selectAllMarkKey(obj) {
	var resultField = document.getElementsByName('markKey');
	var len = resultField.length;
    var checked = false;

    for (i = 0; i < len; i++)
    {
        if (obj.checked)
        {
        	resultField[i].checked = "true";
        }
        else {
        	resultField[i].checked = "";
        }
    } 
}

function todosClickByThePiece(obj) {
	var checked = obj.checked;
	if(!checked) {
		document.input.accountTitle.value = 'AccountTitle03';
	}
	else {
		if(document.input.accountTitle.value == 'AccountTitle03') {
			document.input.accountTitle.value = '';
		}
	}
}


function todosUpdateValue(obj) {
	if($("input[name=markKey]:checked").length == 0) {
		alert('您尚未勾選待辦事項');
	}
	else if($("#updateItem").val() == '' && $("#finishedDate2").val() == ''
		 && $("#legalDueDate2").val() == '' && $("#attorneyDueDate2").val() == '') {
		alert('您尚未選擇更新項目');
	}
	else if($("#finishedDate2").val() == '' && $("#updateValue").val() == 'TDS02') {
		alert('請輸入完成日期');
	}
	else if($("#updateValue").val() == '' && $("#updateItem").val() == 'AttorneyDueDate') {
		alert('請輸入事務所日期');
	}
	else if($("#updateValue").val() == '' && $("#updateItem").val() == 'LegalDueDate') {
		alert('請輸入法定到期日');
	}
	else if($("#updateValue").val() == '' && $("#updateItem").val() == 'FinishedDate') {
		alert('請輸入完成日');
	}
	else {
		document.input.updateFlag.value="true";
		document.input.doSearchFlag.value="true";
		setValue();
	}
}


function importStandardTask(obj) {
	if($("input[name=markKey]:checked").length == 0) {
		alert('您尚未勾選標準期限管制項目');
	}
	else {
		document.input.impoprtFlag.value="true";
		document.input.doSearchFlag.value="true";
		setValue();
	}
}

function checkFinishDate(obj, index) {
	var checked = obj.checked;

	if(!checked) {
		var dateInput = $("input[name='finishedDate" + index + "']");
		dateInput.val('');
	}
	else {
		var date = new Date();
		
		var month = date.getMonth() + 1;
		if(month < 10) {
			month = "0" + month;
		}
		
		var day = date.getDate();
		if(day < 10) {
			day = "0" + day;
		}
		
		document.input['finishedDate' + index].value = date.getFullYear() + "-" + month + "-" + day;
	}
}


function mergerUpdateValue(obj) {
	if($("input[name=markKey]:checked").length == 0) {
		alert('您尚未勾選代辦事項');
	}
	else if($("#updateItem").val() == '') {
		alert('您尚未選擇更新項目');
	}
	else if($("#finishedDate2").val() == '' && $("#updateValue").val() == 'TDS02') {
		alert('請輸入完成日期');
	}
	else {
		document.input.updateFlag.value="true";
		document.input.doSearchFlag.value="true";
		setValue();
	}
}

function deleteTableRow(tableId, button) {
	var table = $('#'+tableId);
	var row = $(button).parent('td').parent('tr');

	
	row.remove();
}

function addTableRow(tableId) {
	if($('#'+tableId).length > 0) {
		var table = $('#'+tableId);

		var trs = table.find("tr.column");
		if(trs.length > 0) {
			$('#' + tableId + ' tbody>tr.column:last').clone(true).insertAfter('#' + tableId + ' tbody>tr:last');
			var select = $('#' + tableId + ' tbody>tr.column:last>td:first').find('select');
			
			var types = select.parent('td').parent('tr').find('#typeSelect');
			types.find('option').remove();
			for(var i=0;i<patentType.length;i++) {
				types.append('<option value="' + patentType[i][0] + '">' + patentType[i][1] + '</option>');
			}
		}
		else {
		}
	}
}


function addTableRow2(tableId) {
	if($('#'+tableId).length > 0) {
		var table = $('#'+tableId);

		var trs = table.find("tr.column");
		if(trs.length > 0) {
		var index = table.find('tr').length;
		var tdId = tableId + '_' + (index+1);
		$('<tr><td>' +
		'<input type="text" size="20" id="' + tdId + '" name="' + tdId + '" value="" class="ui-autocomplete-input" autocomplete="off">' + 
		'<input type="text" size="60" readonly=true name="' + tdId + 'Name" id="' + tdId + 'Name">' + 
		'</td><td></td></tr>')
		.insertAfter('#' + tableId + ' tbody>tr:last');
		$('#' + tdId).autocomplete({
			autoFocus: true,
			source: cases
			,change: function( event, ui ) { 
					if(ui.item) { 
						var label = ui.item.label; 
						if(label.indexOf('-') != -1){ 
							label = label.substring(label.indexOf(':')+1);
						}  
						$('#' + tdId + 'Name').val(label);
					}
				}
		});
		}
		else {
		}
	}
}

(function( $ ) {
    $.widget( "custom.combobox", {
      _create: function() {
        this.wrapper = $( "<span>" )
          .addClass( "custom-combobox" )
          .insertAfter( this.element );
 
        this.element.hide();
        this._createAutocomplete();
        this._createShowAllButton();
      },
 
      _createAutocomplete: function() {
        var selected = this.element.children( ":selected" ),
          value = selected.val() ? selected.text() : "";
 
        this.input = $( "<input>" )
          .appendTo( this.wrapper )
          .val( value )
          .attr( "title", "" )
          .addClass( "custom-combobox-input ui-widget ui-widget-content ui-state-default ui-corner-left" )
          .autocomplete({
            autoFocus: true,
            delay: 0,
            minLength: 0,
            source: $.proxy( this, "_source" )
          })
          .tooltip({
            tooltipClass: "ui-state-highlight"
          });
 
        this._on( this.input, {
          autocompleteselect: function( event, ui ) {
            ui.item.option.selected = true;
            this._trigger( "select", event, {
              item: ui.item.option
            });
            checkReleatedCaseNo($(event.target).parents('table').find('#groups').val(), ui.item, this.input);
          },
 
          autocompletechange: "_removeIfInvalid"
        });
      },
 
      _createShowAllButton: function() {
        var input = this.input,
          wasOpen = false;
 
        $( "<a>" )
          .attr( "tabIndex", -1 )
          .attr( "title", "Show All Items" )
          .tooltip()
          .appendTo( this.wrapper )
          .button({
            icons: {
              primary: "ui-icon-triangle-1-s"
            },
            text: false
          })
          .removeClass( "ui-corner-all" )
          .addClass( "custom-combobox-toggle ui-corner-right" )
          .mousedown(function() {
            wasOpen = input.autocomplete( "widget" ).is( ":visible" );
          })
          .click(function() {
            input.focus();
 
            // Close if already visible
            if ( wasOpen ) {
              return;
            }
 
            // Pass empty string as value to search for, displaying all results
            input.autocomplete( "search", "" );
          });
      },
 
      _source: function( request, response ) {
        var matcher = new RegExp( $.ui.autocomplete.escapeRegex(request.term), "i" );
        response( this.element.children( "option" ).map(function() {
          var text = $( this ).text();
          if ( this.value && ( !request.term || matcher.test(text) ) )
            return {
              label: text,
              value: text,
              option: this
            };
        }) );
      },
 
      _removeIfInvalid: function( event, ui ) {
 
        // Selected an item, nothing to do
        if ( ui.item ) {
          return;
        }
 
        // Search for a match (case-insensitive)
        var value = this.input.val(),
          valueLowerCase = value.toLowerCase(),
          valid = false;
        this.element.children( "option" ).each(function() {
          if ( $( this ).text().toLowerCase() === valueLowerCase ) {
            this.selected = valid = true;
            return false;
          }
        });
 
        // Found a match, nothing to do
        if ( valid ) {
          return;
        }
 
        // Remove invalid value
        this.input
          .val( "" )
          .attr( "title", value + " 您所輸入的案號不存在，請確認後重新輸入案號" )
          .tooltip( "open" );
        this.element.val( "" );
        this._delay(function() {
          this.input.tooltip( "close" ).attr( "title", "" );
        }, 2500 );
        this.input.data( "ui-autocomplete" ).term = "";
      },
 
      _destroy: function() {
        this.wrapper.remove();
        this.element.show();
      }
    });
  })( jQuery );

function addTableRow4(tableId) {
	if($('#'+tableId).length > 0) {
		var table = $('#'+tableId);
		var trs = table.find("tr.column");
		if(trs.length > 0) {
			var index = table.find('tr').length;
			var tdId = tableId + '_' + (index+1);
			var bgcolor = '#D0D8E8';
	
//			$('<tr class="column" bgcolor="' + bgcolor + '" height="25" style="font-size: 16;"><td><select id=' + tdId + ' width=400>' + $('#defaultSelect').html() +
//			'</select></td><td><input type="button" value="刪除" onclick="deleteTableRow("' + tableId + '", this)"></td></tr>').insertAfter('#' + tableId + ' tbody>tr:last');
			$('<tr class="column" bgcolor="' + bgcolor + '" height="25" style="font-size: 16;"><td><select id=' + tdId + ' width=400>' + $('#' + tableId + 'defaultSelect').html() +
					'</select></td><td><input type="button" value="刪除" onclick="deleteTableRow(\'' + tableId + '\', this)"></td></tr>').insertAfter('#' + tableId + ' tbody>tr:last');
			$('#' + tdId).combobox();
		}
		else {
		}
	}
}

$.widget("ui.combobox_remote", {
    _create: function() {
        var self = this,
            select = this.element.hide(),
            selected = select.children(":selected"),
            value = selected.val() ? selected.text() : "";
        var input = this.input = $("<input>").insertAfter(select).val(value).autocomplete({
            autoFocus: true,
            delay: 0,
            minLength: 4,
            source: function(request, response) {
                $.ajax({
		               type: "POST",
		               url: "AjaxServlet.do",
		               data: {
							'term': request.term,
							target: 'findReleatedCaseNo',
							className: 'QuotationCreateSo'
						},
		               dataType: "json",
		               success: function (data) {
		               		cache[ request.term ] = data;
		                   response(data);
		               },
		               error: function (msg) {
		               }
		           })
            },
            select: function(event, ui) {
                console.log(ui.item ? "Selected: " + ui.item.value + " aka " + ui.item.label : "Nothing selected, input was " + this.value);
            }

        }).addClass("ui-widget ui-widget-content ui-corner-left");

        input.data("autocomplete")._renderItem = function(ul, item) {
            return $("<li></li>").data("item.autocomplete", item).append("<a>" + item.label + "</a>").appendTo(ul);
        };

        this.button = $("<button type='button'>&nbsp;</button>").attr("tabIndex", -1).attr("title", "Show All Items").insertAfter(input).button({
            icons: {
                primary: "ui-icon-triangle-1-s"
            },
            text: false
        }).removeClass("ui-corner-all").addClass("ui-corner-right ui-button-icon").click(function() {
            // close if already visible
            if (input.autocomplete("widget").is(":visible")) {
                input.autocomplete("close");
                return;
            }

            // work around a bug (likely same cause as #5265)
            $(this).blur();

            // pass empty string as value to search for, displaying all results
            input.autocomplete("search", "");
            input.focus();
        });
    },

    destroy: function() {
        this.input.remove();
        this.button.remove();
        this.element.show();
        $.Widget.prototype.destroy.call(this);
    }
});

function addTableRow_auto_cache(tableId) {
	if($('#'+tableId).length > 0) {
		var index = parseInt($('#'+tableId).find('#trIndex').val(), 10) + 1;
		
		var table = $('#'+tableId);
		var trs = table.find("tr.column");
		if(trs.length > 0) {
			//var index = table.find('tr').length;
			var tdId = tableId + '_' + (index+1);
			var bgcolor = '#D0D8E8';

			var tr = '<tr class="column" bgcolor="' + bgcolor + '" height="25" style="font-size: 16;"><td>';
			tr += '<input type="text" size="40" id="' + tdId + '">';
			tr += '<span id="' + tdId + '_h"></span>';
			tr += '</td><td><input type="button" value="刪除" onclick="deleteTableRow(\'' + tableId + '\', this)"></td></tr>';
			$(tr).insertAfter('#' + tableId + ' tbody>tr:last');


			$('#' + tdId).autocomplete({
			  autoFocus: true,
		      minLength: 4,
		      source: function( request, response ) {
		      	var term = request.term;
		      	if ( term in cache ) {
		          response( cache[ term ] );
		          return;
		        }
		        
		        	$.ajax({
		               type: "POST",
		               url: "AjaxServlet.do",
		               data: {
							'term': request.term,
							target: 'findReleatedCaseNo',
							className: 'QuotationCreateSo'
						},
		               dataType: "json",
		               success: function (data) {
		               		cache[ term ] = data;
		                   response(data);
		               },
		               error: function (msg) {
		               }
		           })
		      },
		      select: function(event, ui) {
                var id = $(this).attr('id');
                $('#'+id+'_h').text(ui.item.label);
              }
		    });
		    
		     $('#'+tableId).find('#trIndex').val(index + 1);
		}
		else {
		}
	}
}

var cache = {};
function setAutoCache(inputId, index) {
	$("#" + inputId + "_" + index).autocomplete({
	  autoFocus:true,
      minLength: 4,
      source: function( request, response ) {
      	var term = request.term;
      	if ( term in cache ) {
          response( cache[ term ] );
          return;
        }
        
        	$.ajax({
               type: "POST",
               url: "AjaxServlet.do",
               data: {
					'term': request.term,
					target: 'findReleatedCaseNo',
					className: 'QuotationCreateSo'
				},
               dataType: "json",
               success: function (data) {
               		cache[ term ] = data;
                   response(data);
               },
               error: function (msg) {
               }
           })
      },
		      select: function(event, ui) {
                var id = $(this).attr('id');
                $('#'+id+'_h').text(ui.item.label);
                //$('#'+id).val(ui.item.label);
              }
    });
    
    $("#" + inputId + "_" + index).after("<span id='" + inputId + "_" + index + "_h'></span>");
}

var cache2 = {};
function setAutoCache2(inputId) {
	$("#" + inputId).autocomplete({
	  autoFocus:true,
      minLength: 4,
      source: function( request, response ) {
      	var term = request.term;
      	if ( term in cache2 ) {
          response( cache2[ term ] );
          return;
        }
        
        	$.ajax({
               type: "POST",
               url: "AjaxServlet.do",
               data: {
					'term': request.term,
					target: 'findReleatedCaseNo',
					className: 'QuotationCreateSo'
				},
               dataType: "json",
               success: function (data) {
               		cache2[ term ] = data;
                   response(data);
               },
               error: function (msg) {
               }
           })
      },
		      select: function(event, ui) {
                var id = $(this).attr('id');
                $('#'+id+'_h').text(ui.item.label);
                //$('#'+id).val(ui.item.label);
              }
    });
    
    $("#" + inputId).after("<span id='" + inputId + "_h'></span>");
}


function setCombo(selectId, index) {
	if($('#' + selectId + "_" + index).length > 0) {
		$('#' + selectId + "_" + index).html($('#' + selectId + 'defaultSelect').html());
		//$('#' + selectId + "_" + index).html($('#defaultSelect').html());
		$('#' + selectId + "_" + index).combobox();
	}
}


function setComboNew(selectId, index) {
	if($('#' + selectId + "_" + index).length > 0) {
		$('#' + selectId + "_" + index).html($('#' + selectId + 'defaultSelect').html());
		$('#' + selectId + "_" + index).combobox();
	}
}

function setCombo2(selectId, type, office) {
	if($('#' + selectId).length > 0) {
		$('#' + selectId).html($('#defaultSelect').html());
		$('#' + selectId).combobox();
	}
}

function changeSelect(kindSelect) {
		var kind = kindSelect.value;
		var types = $(kindSelect).parent('td').parent('tr').find('#typeSelect');
		
		types.find('option').remove();
		if(kind == 'STC01') {
			for(var i=0;i<patentType.length;i++) {
				types.append('<option value="' + patentType[i][0] + '">' + patentType[i][1] + '</option>');
			}
		}
		else if(kind == 'STC02') {
			for(var i=0;i<trademarkType.length;i++) {
				types.append('<option value="' + trademarkType[i][0] + '">' + trademarkType[i][1] + '</option>');
			}
		}
		else if(kind == 'STC03') {
			for(var i=0;i<legalType.length;i++) {
				types.append('<option value="' + legalType[i][0] + '">' + legalType[i][1] + '</option>');
			}
		}
		else if(kind == 'STC04') {
			for(var i=0;i<copyrightType.length;i++) {
				types.append('<option value="' + copyrightType[i][0] + '">' + copyrightType[i][1] + '</option>');
			}
		}
	}


function createNewSo(parentId) {
	
//	if($("input[name=markKey]:checked").length == 0) {
//		alert('您尚未勾選報價項目');
//		return;
//	}
	if($("#selectedKeys").val() == '') {
		alert('您尚未勾選報價項目');
		return;
	}
	
	/*
	if($('#caseOpenfile').val() == '') {
		alert('您尚未上傳委辦案件單附件，請上傳後再立案');
		return ;
	}
	else {
		$.ajax({
			type: 'POST',
			url: 'AjaxServlet.do',
			//contentType: "application/x-www-form-urlencoded; charset=utf-8", 
			data: {
				flowkey: parentId,
				className: 'QuotationCreateSo',
				target: 'CheckCaseOpenfile'
			}
		})
		.done(function(data) {
			if(!data.hasValue) {
				alert('您上傳的委辦案件單附件尚未儲存，請儲存後再立案');
			}
			else {
				openAppendix("QuotationCreateSo.jsp?_modeLockFlag=true&_pageActionMode=maintain&_dbActionMode=query&createType=new&parentId=" + parentId + "&quotationIn=true&keys=" + $("#selectedKeys").val() + "","建立新案",800,600);
			}
		})
		.fail(function(){  
			alert('您上傳的委辦案件單附件尚未儲存，請儲存後再立案');
		});
	}
	*/
	openAppendix("QuotationCreateSo.jsp?_modeLockFlag=true&_pageActionMode=maintain&_dbActionMode=query&createType=new&parentId=" + parentId + "&quotationIn=true&keys=" + $("#selectedKeys").val() + "","建立新案",800,600);
	
	
//	var data = "";
//	var checkDatas = document.input.markKey;
//	if(checkDatas.length) {
//		for(var i=0;i<checkDatas.length;i++) {
//			if(checkDatas[i].checked) {
//					data += checkDatas[i].value + ";";
//			}
//		}
//	}
//	else {
//		data = checkDatas.value + ";";
//	}
	
//	openAppendix("QuotationCreateSo.jsp?_modeLockFlag=true&_pageActionMode=maintain&_dbActionMode=query&createType=new&parentId=" + parentId + "&quotationIn=true&keys=" + $("#selectedKeys").val() + "","建立新案",800,600);
}

function createOldSo(parentId) {
//	if($("input[name=markKey]:checked").length == 0) {
//		alert('您尚未勾選報價項目');
//		return;
//	}
	if($("#selectedKeys").val() == '') {
		alert('您尚未勾選報價項目');
		return;
	}
	
//	var data = "";
//	var checkDatas = document.input.markKey;
//	if(checkDatas.length) {
//		for(var i=0;i<checkDatas.length;i++) {
//			if(checkDatas[i].checked) {
//					data += checkDatas[i].value + ";";
//			}
//		}
//	}
//	else {
//		data = checkDatas.value + ";";
//	}
	
	//openAppendix("QuotationCreateSo.jsp?_modeLockFlag=true&_pageActionMode=maintain&_dbActionMode=query&createType=old&parentId=" + parentId + "&quotationIn=true&keys=" + data+ "","關聯舊案",800,600);
	
	openAppendix("QuotationCreateSo.jsp?_modeLockFlag=true&_pageActionMode=maintain&_dbActionMode=query&createType=old&parentId=" + parentId + "&quotationIn=true&keys=" + $("#selectedKeys").val()+ "","關聯舊案",800,600);
}


function deleteReleatedCase(quotationKey, soKey) {
	if(confirm('確定移除此筆關聯資料?')) {
		doPatentCaseAjaxRequest('SalesOrder','RemoveRelatedCase',quotationKey + ';' + soKey,'SalesOrderDiv','innerHTML');
	}
}

function doReleatedCaseNo() {
	var groups = document.getElementsByName('groups');

	for(var i=0;i<groups.length;i++) {
		var table = $(groups[i]).parents('table');
		var releatedCaseNo = '';
		table.find('select').each(function(i){
			if($(this).val() != '') {
				releatedCaseNo += $(this).val() + '%%';
			}
		});
		table.find('#releatedCaseNo').val(releatedCaseNo);
		
		var naGroups = '';
		table.find('input[name=nakeys]:checked').each(function(i){
			if($(this).val() != '') {
				naGroups += $(this).val() + '%%';
			}
		});
		table.find('#naGroups').val(naGroups);
		
		if(document.getElementById('invoiceTitle1table_' + groups[i].value).value == '') {
			alert('發票抬頭需填寫確認後才能成立訂單');
			return;
		}
		
		if(document.getElementById('checktable_' + groups[i].value).value == 'true' &&
			document.getElementById('registeredNotable_' + groups[i].value).value == '') {
			alert('統一編號需填寫確認後才能成立訂單');
			return;
		}
	}

	setValue();
}

function checkNewShowItem() {
//	if($("input[name=newCase]:checked").length == 0) {
//		alert('新案件選項請擇一選取!');
//		return;
//	}
	var hasError = false;
	var caseNumbers = document.getElementsByName('caseNumber1');

	for(var i=0;i<caseNumbers.length;i++) {
		if(caseNumbers[i].value == '') {
			hasError = true;
		}
	}
	
	caseNumbers = document.getElementsByName('caseNumber2');

	for(var i=0;i<caseNumbers.length;i++) {
		if(caseNumbers[i].value == '') {
			hasError = true;
		}
	}
	
	caseNumbers = document.getElementsByName('caseNumber3');

	for(var i=0;i<caseNumbers.length;i++) {
		if(caseNumbers[i].value == '') {
			hasError = true;
		}
	}
	
	caseNumbers = document.getElementsByName('caseNumber4');

	for(var i=0;i<caseNumbers.length;i++) {
		if(caseNumbers[i].value == '') {
			hasError = true;
		}
	}

	
	if(hasError) {
		alert('請填寫欲成立案件的數量!');
		return;
	}
	
	document.input.confirmFlag.value="true";
	top.$.blockUI();
	setValue();
}

function doReleatedCaseNo_auto_cache() {
	var groups = document.getElementsByName('groups');

	for(var i=0;i<groups.length;i++) {
		var table = $(groups[i]).parents('table');
		var releatedCaseNo = '';
		table.find('.ui-autocomplete-input').each(function(i){
			//不用檢查關聯案號，就不用判斷是否空
			//if($(this).val() != '') {
				releatedCaseNo += $(this).val() + '#%%';
			//}
		});
		table.find('#releatedCaseNo').val(releatedCaseNo);
		
		var naGroups = '';
		table.find('input[name=nakeys]:checked').each(function(i){
			//if($(this).val() != '') {
				naGroups += $(this).val() + '#%%';
			//}
		});
		table.find('#naGroups').val(naGroups);
		
		if(document.getElementById('invoiceTitle1table_' + groups[i].value).value == '') {
			alert('發票抬頭需填寫確認後才能成立訂單');
			return;
		}
		
		if(document.getElementById('checktable_' + groups[i].value).value == 'true' &&
			document.getElementById('registeredNotable_' + groups[i].value).value == '') {
			alert('統一編號需填寫確認後才能成立訂單');
			return;
		}
	}

	setValue();
}


function updateSODTaskDesc(flowkey, value) {
	$.ajax({
		type: 'POST',
		url: 'AjaxServlet.do',
		//contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		data: {
			flowkey: flowkey,
			'value': value,
			className: 'SalesOrder',
			target: 'TaskDescription'
		}
	})
	.done(function(data) { 
	})
	.fail(function(){  
	});
}


function updateSODRemark(flowkey, value, target) {
	$.ajax({
		type: 'POST',
		url: 'AjaxServlet.do',
		//contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		data: {
			flowkey: flowkey,
			'value': value,
			className: 'SalesOrder',
			target: target
		}
	})
	.done(function(data) { 
	})
	.fail(function(){  
	});
}

function checkReleatedCaseNo(group, select, input) {
	$.ajax({
		type: 'POST',
		url: 'AjaxServlet.do',
		data: {
			flowkey: select.option.value,
			'group': group,
			className: 'QuotationCreateSo',
			target: 'checkReleatedCaseNo'
		}
	})
	.done(function(data) { 
		if(!data.success) {
			alert('您所選案號的案件種類、案件類別、國家欄位與欲立舊案訂單的項目不符，請確認後重新輸入案號');
			select.selectedIndex = 0;
			input.val('');
		}
	})
	.fail(function(){  
	});
}

function openQuotation_detail_merger(parentId) {
	if($("input[name=markKey]:checked").length == 0) {
		alert('您尚未選擇合併項目');
	}
	else {
		
		var data = "";
		var checkDatas = document.input.markKey;
		if(checkDatas.length) {
			for(var i=0;i<checkDatas.length;i++) {
				if(checkDatas[i].checked) {
					var id = '#acc_' + i;
					if($(id).val() == 'Y') {
						alert('請勿選擇實報實銷項目合併');
						return;
					}
					else {
						data += checkDatas[i].value + ";";
					}
				}
			}
		}
		else {
			data = checkDatas.value + ";";
		}
		
		openAppendix("Quotation_detail_merger.jsp?_modeLockFlag=true&_pageActionMode=maintain&_dbActionMode=insert&parentId=" + parentId + "&quotationIn=true&keys=" + data + "","合併報價",800,600);
	}
}

function openDiscount() {
	if($("input[name=markKey]:checked").length == 0 || document.input.discount.value == '') {
		alert('請勾選欲折扣的報價項目並輸入欲折扣的百分比');
	}
	else {
		document.input.doDiscount.value = true;
		setValue();
	}
}


function openPrint() {
/*
	if($("input[name=markKey]:checked").length == 0) {
		alert('請勾選欲套表的報價項目');
	}
	else {
*/
		document.input.doPrint.value = true;
		setValue();
	//}
}

function openAllPrint() {
/*
	if($("input[name=markKey]:checked").length == 0) {
		alert('請勾選欲套表的報價項目');
	}
	else {
*/
		document.input.doAllPrint.value = true;
		setValue();
	//}
}

function openDelete() {
	if($("input[name=markKey]:checked").length == 0) {
		alert('請勾選欲刪除的報價項目');
	}
	else {
		document.input.doDelete.value = true;
		setValue();
	}
}

function searchTodos(clazz, div) {
//	var param = document.input.flowKey.value;
	var param = document.input.flowKey.value + "&";
	param += document.input.matter.value + "&";
	param += document.input.toDosStatus.value + "&";
//	if(document.input.isPayment.checked) {
//		param += "Y&";
//	}
//	else {
//		param += "N&";
//	}
//	if(document.input.isCharge.checked) {
//		param += "Y";
//	}
//	else {
//		param += "N";
//	}
	param += "&" + document.input.financialFlag.value;
	doPatentCaseAjaxRequest(clazz,div,param,div+'Div','innerHTML');
}

function searchTodos2(clazz, div) {
	document.input.matter.selectedIndex = 0;
	document.input.toDosStatus.selectedIndex = 0;
	document.input.isPayment.checked = false;
	document.input.isCharge.checked = false;
	var param = document.input.flowKey.value + "&";
	param += document.input.matter.value + "&";
	param += document.input.toDosStatus.value + "&";
	param += "&" + document.input.financialFlag.value;
	doPatentCaseAjaxRequest(clazz,div,document.input.flowKey.value,div+'Div','innerHTML');
}

function showHideTodosDiv(showDivId, hideDivId) {
//	$('#' + showDivId).show();
//	$('#' + hideDivId).hide();
	if(showDivId=='PatentToDosDiv' ||
			showDivId=='TrademarkToDosDiv' ||
			showDivId=='LegalToDosDiv'  ||
				showDivId=='CopyrightToDosDiv'  ||
				showDivId=='ServiceProjectToDosDiv') {
		document.input.financialFlag.value = 'Y';
		$('#FinancialToDosTabBtn').prop('disabled', true);
		$('#MatterToDosTabBt').prop('disabled', false);
	}
	else {
		document.input.financialFlag.value = 'N';
		$('#FinancialToDosTabBtn').prop('disabled', false);
		$('#MatterToDosTabBt').prop('disabled', true);
	}
	if(showDivId == 'PatentToDosDiv' ||
			showDivId == 'PatentToDosDiv2') {
		searchTodos('PatentCase','PatentToDos');
	}
	else if(showDivId == 'LegalToDosDiv' ||
			showDivId == 'LegalToDosDiv2') {
		searchTodos('LegalCase','LegalToDos');
	}
	else if(showDivId == 'TrademarkToDosDiv' ||
			showDivId == 'TrademarkToDosDiv2') {
		searchTodos('TrademarkCase','TrademarkToDos');
	}
	else if(showDivId == 'CopyrightToDosDiv' ||
			showDivId == 'CopyrightToDosDiv2') {
		searchTodos('CopyrightCase','CopyrightToDos');
	}
	else if(showDivId == 'ServiceProjectToDosDiv' ||
			showDivId == 'ServiceProjectToDosDiv2') {
		searchTodos('ServiceProject','ServiceProjectToDos');
	}
}


function searchQuotations(clazz, div) {
	var param = document.input.caseKind.value + "&";
	param += document.input.patentOffice.value + "&";
	param += document.input.matterName.value + "&";
	
	param += "&" + document.input.financialFlag.value;
	doPatentCaseAjaxRequest(clazz,div,param,div+'Div','innerHTML');
}

function searchQuotation2(clazz, div) {
	document.input.matter.selectedIndex = 0;
	document.input.toDosStatus.selectedIndex = 0;
	document.input.isPayment.checked = false;
	document.input.isCharge.checked = false;
	param += "&" + document.input.financialFlag.value;
	doPatentCaseAjaxRequest(clazz,div,document.input.flowKey.value,div+'Div','innerHTML');
}

function exportIDS() {
	if($("input[name=markKey]:checked").length == 0) {
		alert('請勾選欲匯出的引證資料');
	}
	else {
		document.input.processType.value="printIDS";
		setValue();
	}
}

function changeRightDate() {
	//專利權終止日預設為申請日加”(發明)20 年、(新型)10 年、(設計)15 年”(但可手動改)
	if($("#applyDate").val() != '' && $("#patentOffice").val() != '') {
		var patentOffice = $("#patentOffice").val();
		var applyDate = ($("#applyDate").val()).replace(/\-/g,"/");
		var applyDateData = new Date(applyDate);
		
		var patentType = $("#patentType").val();
		if(patentOffice == 'TW'){
			if(patentType == 'PN01') {
				applyDateData.setYear(applyDateData.getFullYear() + 20);
				applyDateData.setDate(applyDateData.getDate() - 1);
				var month = (applyDateData.getMonth()+1).toString();
				if(month.length<2){
					month = '0'+month;
				}
				var date = applyDateData.getDate().toString();
				if(date.length<2){
					date = '0'+date;
				}
				$("#rightEndDate").val(applyDateData.getFullYear() + '-' + month + '-' + date);
			}
			else if(patentType == 'PN02') {
				applyDateData.setYear(applyDateData.getFullYear() + 10);
				applyDateData.setDate(applyDateData.getDate() - 1);
				var month = (applyDateData.getMonth()+1).toString();
				if(month.length<2){
					month = '0'+month;
				}
				var date = applyDateData.getDate().toString();
				if(date.length<2){
					date = '0'+date;
				}
				$("#rightEndDate").val(applyDateData.getFullYear() + '-' + month + '-' + date);
			}
			else if(patentType == 'PN03') {
				applyDateData.setYear(applyDateData.getFullYear() + 15);
				applyDateData.setDate(applyDateData.getDate() - 1);
				var month = (applyDateData.getMonth()+1).toString();
				if(month.length<2){
					month = '0'+month;
				}
				var date = applyDateData.getDate().toString();
				if(date.length<2){
					date = '0'+date;
				}
				$("#rightEndDate").val(applyDateData.getFullYear() + '-' + month + '-' + date);
			}else{
				$("#rightEndDate").val('');
			}
		}else if(patentOffice == 'CN'){
			if(patentType == 'PN01') {
				applyDateData.setYear(applyDateData.getFullYear() + 20);
				
				var month = (applyDateData.getMonth()+1).toString();
				if(month.length<2){
					month = '0'+month;
				}
				var date = applyDateData.getDate().toString();
				if(date.length<2){
					date = '0'+date;
				}
				$("#rightEndDate").val(applyDateData.getFullYear() + '-' + month + '-' + date);
			}
			else if(patentType == 'PN02' || patentType == 'PN03') {
				applyDateData.setYear(applyDateData.getFullYear() + 10);
				
				var month = (applyDateData.getMonth()+1).toString();
				if(month.length<2){
					month = '0'+month;
				}
				var date = applyDateData.getDate().toString();
				if(date.length<2){
					date = '0'+date;
				}
				$("#rightEndDate").val(applyDateData.getFullYear() + '-' + month + '-' + date);
			}else{
				$("#rightEndDate").val('');
			}
		}else{
			$("#rightEndDate").val('');
		}
	}
}

function deleteClentApplicant(client, key) {
	if(confirm('確定刪除此筆聯絡人資料?')) {
		doPatentCaseAjaxRequest('Client','ClientApplicant',client + ';' + key,'ClientApplicantDiv','innerHTML');
	}
}

function deleteClentApplicant(client, key) {
	if(confirm('確定刪除此筆聯絡人資料?')) {
		doPatentCaseAjaxRequest('Client','ClientApplicant',client + ';' + key,'ClientApplicantDiv','innerHTML');
	}
}

function showClentApplicant(client) {
	doPatentCaseAjaxRequest('Client','ClientApplicant2',client,'ClientApplicantDiv','innerHTML');
}

//排序javascript
function resortSubmit() {
	var sortKeys = '';
	var keys = $('.ui-state-default2');
	if(keys.length > 0) {
		keys.each(function(index, value) {
			sortKeys += $(this).attr('flowkey') + ';';
		});
	}
//	alert(sortKeys);

	document.input.sortKeys.value=sortKeys;
	document.input.doCheckFlag.value="true";
	document.input.submitFlag.value="true";
	setValue();
}

function changeIncharge() {
	if(document.input.salesChangeList.value == '') {
		alert('請先選擇業務人員');
		return;
	}
	document.input.changeSales.value=true;
	setValue();
}

function changeCaseADFun() {
	if(document.input.caseADChangeList.value == '') {
		alert('請先選擇程序人員');
		return;
	}
	document.input.changeCaseAD.value=true;
	setValue();
}

var valueChange = false;
var preDbActionMode = '';
function setSubmit() {
	if(valueChange) {
		if(confirm('您要離開編輯模式，請確認是否已儲存資料，若點確定則不儲存離開此頁，若將停留在此頁，請點選儲存後在離開。')) {
			document.input.submit();
		}
		else {
			$('#dbActionMode').val(preDbActionMode);
		}
	}
	else {
		document.input.submit();
	}
}

$(function () {
	preDbActionMode = $('#dbActionMode').val();

	if(($('#dbActionMode').length > 0 && 
			$('#dbActionMode').val() == 'update')) {
		
	    function setUnloadWarning(enabled) {
	    	if(preDbActionMode != $('#dbActionMode').val()) {
	    		window.onbeforeunload = enabled ? showWarning : null;
	    	}
	    }
	    
	    function showWarning() {
	        return "您要離開編輯模式，請確認是否已儲存資料，若點離開此頁則不儲存離開此頁，若將停留在此頁，請點選儲存後在離開。";
	    }

	    $("input:text, textarea, select").on("change", function () {
	    	$(this).css('border-color', 'red');
	    	valueChange = true;
	        //setUnloadWarning(true);
	    });
	    $("input:submit").click(function () {
	        setUnloadWarning(false);
	    });
	    //編輯模式要跳成搜尋模式時也要檢查
	    if($("#SearchModeBtn").length > 0) {
	    	if(valueChange) {
	    		setUnloadWarning(true);
	    	}
	    }
	    //用option來判斷是select或是button來切換模式
//	    if($("#dbActionMode").find("option").length > 0) {
//	    	$("#dbActionMode").change(function() {
//	    		if(valueChange) {
//	    			if(confirm('您要離開編輯模式，請確認是否已儲存資料，若點離開此頁則不儲存離開此頁，若將停留在此頁，請點選儲存後在離開。')) {
//	    				return true;
//	    			}
//	    			else {
//	    				return false;
//	    			}
//	    		}
//	    		else {
//	    			setUnloadWarning(true && valueChange);
//	    		}
//	    	});
//	    }
//	    else {
//	    	
//	    }
	}
});

function downloadFile(filePath) {
	$(document).ready(function() {
		var hiddenIFrameID = 'hiddenDownloader',
	    iframe = document.getElementById(hiddenIFrameID);
		if (iframe === null) {
		    iframe = document.createElement('iframe');
		    iframe.id = hiddenIFrameID;
		    iframe.style.display = 'none';
		    document.body.appendChild(iframe);
		}
		iframe.src = 'download_file.do?outputFile=' + filePath;
	});

//	$.ajax({
//		type: 'POST',
//		url: 'download_file.do',
//		data: {
//			outputFile: filePath
//		}
//	})
//	.done(function(data) { 
//		
//	})
//	.fail(function(){  
//	});
	
}

function downloadFile2(filePath,type,key) {
	$(document).ready(function() {
		var hiddenIFrameID = 'hiddenDownloader',
	    iframe = document.getElementById(hiddenIFrameID);
		if (iframe === null) {
		    iframe = document.createElement('iframe');
		    iframe.id = hiddenIFrameID;
		    iframe.style.display = 'none';
		    document.body.appendChild(iframe);
		}
		iframe.src = 'download_file2.do?outputFile=' + filePath + '&type=' + type + '&key=' + key;
	});
	
}

function checkFinishedDate(obj,index) {
  var p_date = obj.value;
  var result = false;
  var re1 = /^\d{4}\-(0[1-9]|1[0-2])\-(3[0-1]|[0-2][0-9])$/;
  var len = p_date.length;        
  if(p_date != null && p_date != ""){
	if(!regDate(p_date))
		  result = false;
  	if(len==10){
      if(!p_date.match(re1)) { 
    	  result = false ;
      }else{ 
    	  result = true ;
      } 
  	}
  	else if(len==8) { //yyyymmdd自動變成yyyy-mm-dd
  		var newDate = p_date.substring(0, 4) + "-" + p_date.substring(4, 6) + "-" + p_date.substring(6, 8);
  		if(!newDate.match(re1)) { 
      	  result = false ;
        }
  		else{ 
      	  result = true ;
          obj.value = newDate;
        } 
  	}//日期欄位可預設當年度年份(仍可手動修改)，eg.:輸入1015即可自動代為2012-10-15 
  	else if(len==4) {
  		var newDate = new Date().getFullYear() + "-" + p_date.substring(0, 2) + "-" + p_date.substring(2, 4);
  		if(!newDate.match(re1)) { 
      	  result = false ;
        }
  		else{ 
      	  result = true ;
          obj.value = newDate;
        } 
  	}
  	else {
  		result = false;
  	}
  }else{
	  result = true ;
  }
  
  if(!result) {
	  alert('請輸入正確的日期格式字串');
	  window.setTimeout("document.getElementById('" + obj.id + "').focus();",50);
  }else{
	  resetFinishedCheckbox(index);
	  resetFinishedValue();
	  resetFinishedDateValue();
  }
}


function changeCanEdit(field){
	if(field=='serviceFeeTax'){
		if($('input[name="serviceFeeTax"]:checked').val() == 'Y'){
			document.getElementById('serviceBusinessTax').disabled = false;
			$('input[name="serviceTaxInclude"]').attr('disabled',false);
			$('input[name="serviceTaxInclude"]').get(0).checked = true;
		}else{
			document.getElementById('serviceBusinessTax').disabled = true;
			document.getElementById('serviceBusinessTax').value = '';
			$('input[name="serviceTaxInclude"]').attr('disabled',true);
			$('input[name="serviceTaxInclude"]').attr('checked',false);
		}
	}else if(field=='attorneyFeeTax'){
		if($('input[name="attorneyFeeTax"]:checked').val() == 'Y'){
			document.getElementById('attorneyBusinessTax').disabled = false;
			$('input[name="attorneyTaxInclude"]').attr('disabled',false);
			$('input[name="attorneyTaxInclude"]').get(0).checked = true;
		}else{
			document.getElementById('attorneyBusinessTax').disabled = true;
			document.getElementById('attorneyBusinessTax').value = '';
			$('input[name="attorneyTaxInclude"]').attr('disabled',true);
			$('input[name="attorneyTaxInclude"]').attr('checked',false);
		}
	}else if(field=='officeFeeTax'){
		if($('input[name="officeFeeTax"]:checked').val() == 'Y'){
			document.getElementById('officeBusinessTax').disabled = false;
			$('input[name="officeTaxInclude"]').attr('disabled',false);
			$('input[name="officeTaxInclude"]').get(0).checked = true;
		}else{
			document.getElementById('officeBusinessTax').disabled = true;
			document.getElementById('officeBusinessTax').value = '';
			$('input[name="officeTaxInclude"]').attr('disabled',true);
			$('input[name="officeTaxInclude"]').attr('checked',false);
		}
	}
}

function changeCanEdit(field, office){
	if(field=='serviceFeeTax'){
		if($('input[name="serviceFeeTax_' + office + '"]:checked').val() == 'Y'){
			document.getElementById('serviceBusinessTax_' + office + '').disabled = false;
			$('input[name="serviceTaxInclude_' + office + '"]').attr('disabled',false);
			$('input[name="serviceTaxInclude_' + office + '"]').get(0).checked = true;
		}else{
			document.getElementById('serviceBusinessTax_' + office + '').disabled = true;
			document.getElementById('serviceBusinessTax_' + office + '').value = '';
			$('input[name="serviceTaxInclude_' + office + '"]').attr('disabled',true);
			$('input[name="serviceTaxInclude_' + office + '"]').attr('checked',false);
		}
	}else if(field=='attorneyFeeTax'){
		if($('input[name="attorneyFeeTax_' + office + '"]:checked').val() == 'Y'){
			document.getElementById('attorneyBusinessTax_' + office + '').disabled = false;
			$('input[name="attorneyTaxInclude_' + office + '"]').attr('disabled',false);
			$('input[name="attorneyTaxInclude_' + office + '"]').get(0).checked = true;
		}else{
			document.getElementById('attorneyBusinessTax_' + office + '').disabled = true;
			document.getElementById('attorneyBusinessTax_' + office + '').value = '';
			$('input[name="attorneyTaxInclude_' + office + '"]').attr('disabled',true);
			$('input[name="attorneyTaxInclude_' + office + '"]').attr('checked',false);
		}
	}else if(field=='officeFeeTax'){
		if($('input[name="officeFeeTax_' + office + '"]:checked').val() == 'Y'){
			document.getElementById('officeBusinessTax_' + office + '').disabled = false;
			$('input[name="officeTaxInclude_' + office + '"]').attr('disabled',false);
			$('input[name="officeTaxInclude_' + office + '"]').get(0).checked = true;
		}else{
			document.getElementById('officeBusinessTax_' + office + '').disabled = true;
			document.getElementById('officeBusinessTax_' + office + '').value = '';
			$('input[name="officeTaxInclude_' + office + '"]').attr('disabled',true);
			$('input[name="officeTaxInclude_' + office + '"]').attr('checked',false);
		}
	}
}

function changeBusinessTax(type, office) {
	if(type == 1) {
		if(document.getElementById('serviceBusinessTax_' + office + '').value == 'TaxT01') {
			$('input[name="serviceTaxInclude_' + office + '"]').attr('disabled',true);
			$('input[name="serviceTaxInclude_' + office + '"]').get(0).checked = true;
		}
		else {
			$('input[name="serviceTaxInclude_' + office + '"]').attr('disabled',false);
			//$('input[name="serviceTaxInclude_' + office + '"]').get(0).checked = true;
		}
	}
	else if(type == 2) {
		if(document.getElementById('attorneyBusinessTax_' + office + '').value == 'TaxT01') {
			$('input[name="attorneyBusinessTax_' + office + '"]').attr('disabled',true);
			$('input[name="attorneyBusinessTax_' + office + '"]').get(0).checked = true;
		}
		else {
			$('input[name="attorneyBusinessTax_' + office + '"]').attr('disabled',false);
			//$('input[name="attorneyBusinessTax_' + office + '"]').get(0).checked = true;
		}
	}
	else if(type == 3) {
		if(document.getElementById('officeTaxInclude_' + office + '').value == 'TaxT01') {
			$('input[name="officeTaxInclude_' + office + '"]').attr('disabled',true);
			$('input[name="officeTaxInclude_' + office + '"]').get(0).checked = true;
		}
		else {
			$('input[name="officeTaxInclude_' + office + '"]').attr('disabled',false);
			//$('input[name="officeTaxInclude_' + office + '"]').get(0).checked = true;
		}
	}
}

function resetAttorneyCase() {
	if($('#attorney').value != '') {
		document.input.attorneyCase.checked = true;
	}
	else {
		
	}
}

function notyMsg(msg) {
	noty({text: msg});
}


function todosAssign(flowkey, target, value) {
	if(target == 'Points' && value == '') {
		value='0';
	}
	$.ajax({
		type: 'POST',
		url: 'AjaxServlet.do',
		//contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		data: {
			flowkey: flowkey,
			'value': value,
			className: 'ToDosAssign',
			'target': target
		}
	})
	.done(function(data) { 
		if(data.logout) {
			location.replace("error.jsp");
		}
	})
	.fail(function(){  
	});
}


function todosAssign2(flowkey, assignedId, target, value, button) {
	if($('#at_'+assignedId).val() == '') {
		alert('請先指定承辦人!');
		return;
	}
	$.ajax({
		type: 'POST',
		url: 'AjaxServlet.do',
		//contentType: "application/x-www-form-urlencoded; charset=utf-8", 
		data: {
			flowkey: flowkey,
			'value': value,
			className: 'ToDosAssign',
			'target': target
		}
	})
	.done(function(data) { 
		if(data.logout) {
			location.replace("error.jsp");
		}
		else {
			button.disabled = true;
			document.getElementById('at_'+assignedId).disabled = true;
			document.getElementById('atn_'+assignedId).disabled = true;
			document.getElementById('points_'+assignedId).disabled = true;
			notyMsg('此筆資料已指派完畢!');
			document.input.doSearchFlag.value="true";
		}
	})
	.fail(function(){  
	});
}

function resetValue(obj) {
	if(obj) {
		if(obj.value=='0') {
			obj.value='';
		}
	}
}

function todosMultiDelete(btn) {
	if($("input[name=markKey]:checked").length == 0) {
		alert('您尚未勾選待辦事項');
		return;
	}
	if(confirm('確定刪除待辦事項')) {
		btn.disabled=true;
		document.input.doDeleteFlag.value="true";
		setValue();
	}
}


function resetSelectKeys(parentid, checkbox) {
	var type = '2';
	if(checkbox.checked) {
		type = '1';
	}
	$.ajax({
		type: 'POST',
		url: 'AjaxServlet.do',
		data: {
			parentid: parentid,
			'type': type,
			fk: checkbox.value,
			target: 'QDKeys',
			className: 'QuotationCreateSo'
		}
	})
	.done(function(data) { 
		if(data.hasKeys) {
			$('#selectedKeys').val(data.selectedKeys);
		}
		else {
			$('#selectedKeys').val('');
		}
	})
	.fail(function(){  
	});
}

function checkAllSelectKeys(obj,name, parentid){
	var objs = document.getElementsByName(name);
	var checked = obj.checked;
	var keys = "";
	if(objs){
		for(var i=0;i<objs.length;i++) {
			objs[i].checked = checked;
			keys += objs[i].value + ";";
		}

		var type = 1;
		if(!checked) {
			type = 2;
		}
		$.ajax({
			type: 'POST',
			url: 'AjaxServlet.do',
			data: {
				parentid: parentid,
				'type': type,
				fk: keys,
				target: 'QDKeys',
				className: 'QuotationCreateSo'
			}
		})
		.done(function(data) { 
			if(data.hasKeys) {
				$('#selectedKeys').val(data.selectedKeys);
			}
			else {
				$('#selectedKeys').val('');
			}
		})
		.fail(function(){  
		});
	}
}

function createInvoiceNo() {
	if(document.input.voucherDate.value == '') {
		alert('產生單據編號失敗，請輸入單據日期!');
	}
	else {
		document.input.createInvoiceNoFlag.value="true";
		setValue();
	}
}

function showPointsImg() {
	var ids = '';
	
	var allInJobs = document.input.inJobs;
	if(allInJobs) {
		for(var i=0;i<allInJobs.length;i++) {
			if(allInJobs[i].checked) {
				ids += allInJobs[i].value + ";";
			}
		}
	}
	
	var allNotInJobs = document.input.notInJobs;
	if(allNotInJobs) {
		for(var i=0;i<allNotInJobs.length;i++) {
			if(allNotInJobs[i].checked) {
				ids += allNotInJobs[i].value + ";";
			}
		}
	}

	top.$.blockUI();
	
	$.ajax({
		type: 'POST',
		url: 'AjaxServlet.do',
		data: {
			'userId': ids,
			target: 'PointsAccount',
			className: 'ToDosAssign'
		}
	})
	.done(function(data) {
		$('#imgdiv').html("");

		if(data.htmlCode) {
			$('#imgdiv').html(data.htmlCode);
		}
		top.$.unblockUI();
	})
	.fail(function(){   
		top.$.unblockUI();
	});
}


function showSingalPointsImg(id) {
	//top.$.blockUI();

	if(document.getElementById(id).value == '') {
		alert('請先選擇承辦人員');
		return ;
	}

	$.ajax({
		type: 'POST',
		url: 'AjaxServlet.do',
		data: {
			'userId': document.getElementById(id).value,
			target: 'PointsAccount',
			className: 'ToDosAssign'
		}
	})
	.done(function(data) {
		//top.$.unblockUI();
		
		if(data.htmlCode) {
			
			try {
			if($('#singalImageDiv').dialog('isOpen')) {
				$('#singalImageDiv').html(data.htmlCode);
			}
			}
			catch(e){}
			
			$('#singalImageDiv')
			//$('<div></div>')
			.html(data.htmlCode)
			.dialog({
				resizable: false,
				draggable:true,
				width: 600,
				height:600,
				closeText:'關閉',
				closeOnEscapeType: true,
				//modal:true,
				position: {my:"right top", at:"right top", of:window},
				close: function(event, ui) {
					//$(this).remove();
					$(this).dialog("close");
				},
				buttons: { "關閉": function() { $(this).dialog("close"); } }
			});;
		}
	})
	.fail(function(){   
		top.$.unblockUI();
	});
}

function checkAllDeptCheckBox(button, id) {
	var checked = button.checked;
	if(button){
		$('.' + id).each(function(index) {
			$(this).find('input[type=checkbox]').each(function(index2) {
				if(checked) {
					$(this).attr("checked", true);
				}
				else {
					$(this).attr("checked", false);
				}
			});
		});
		
	}
}

function openPreCount() {
	var amount = document.input.amount.value;
	var currency = document.input.currency.value;
	var invoiceCurrency = document.input.invoiceCurrency.value;
	var miscellaneous = document.input.miscellaneous.value;
	if(amount == '' || currency == '') {
		alert('原幣金額和幣別不得為空白!');
		return;
	}
	var url = "InvoicePreAccount.jsp?dbActionMode=update&pageActionMode=maintain&modelLoackFlag=true&_invoiceCurrency=" + invoiceCurrency + "&_currency=" + currency + "&_amount=" + amount + "&_miscellaneous=" + miscellaneous;
	openAppendix(url,"InvoicePreAccount",800,600);
}

function doPreCount() {
	if(document.input.exchangeRate.value == '') {
		alert('請輸入匯率資料');
		return;	
	}
	document.input.doCountFlag.value=true;
	setValue();
}

function doImportInvoiceAmount() {
	if(document.input.invoiceCurrency.value == '') {
		alert('請選擇本次請款幣別');
		return;	
	}
	if(document.input.invoiceAmount.value == '') {
		alert('本次請款金額不得為空白');
		return;	
	}
	if(document.input.importExchange.checked &&
		document.input.importExchange2.checked) {
		alert('匯率帶入勾選不得同時都選');
		return;	
	}
	if(document.input.importExchange.checked) {
		window.opener.input.exchangeRate.value = document.input.exchangeRate.value;
	}
	if(document.input.importExchange2.checked) {
		window.opener.input.exchangeRate.value = document.input.midExchange.value;
	}
	window.opener.input.changeInvoiceAmountFlag.value = "true";
	//window.opener.input.changeInvoiceCurrencyFlag.value = "true";
	window.opener.input.invoiceCurrency.value = document.input.invoiceCurrency.value;
	window.opener.input.invoiceAmount.value = document.input.invoiceAmount.value;
	window.opener.input.invoiceExchangeRate.value = document.input.invoiceExchangeRate.value;
	window.opener.input.memo.value = document.input.memo.value;
	
	window.opener.input.miscellaneous.value = document.input.miscellaneous.value;
	window.opener.input.amount.value = document.input.amount.value;
	window.opener.setValue();
	window.close();
}

//請款單明細的備註 欄位旁新增 帶入按鈕，點了之後就帶出 算式 備註公式：幣別代碼 (原幣金額+雜費)x本次請款匯率
//範例：EURO 1090.00 X 1.3818
function importInvoiceDetailMemo() {
	var multi = ' X ';
	if($('input[name="mulitType2"]:checked').val() == '2') {
		multi = ' ÷ ' ;
	}
	var value = document.input.currency.value + ' ';
	if(document.input.amount.value != '')  {
		value += round(parseFloat(document.input.amount.value) + parseFloat(document.input.miscellaneous.value), 2)  + multi;
	} 
	else {
		value += document.input.amount.value + multi;
	}
	value += document.input.invoiceExchangeRate.value;
		
	document.input.memo.value = value;
}

function importInvoiceExchange2(exchangeString) {
	if(exchangeString != '') {
		var array = exchangeString.trim().split(';');
		document.input.invoiceExchangeRate.value = array[0];
		checkFloat('invoiceExchangeRate');
		document.input.changeRateFlag2.value="true";
		setValue();
	}
}

function createPatentTabs1() {
$(function(){
	$('#tabs').tabs({
		activate: function (event, ui) {
			var id = ui.newTab.context.hash;
			
			if(id == '#tabs-2' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('PatentDocument');
			}
			else if(id == '#tabs-3' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('PatentToDos');
			}
			else if(id == '#tabs-4' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('PatentApplicant');
			}
			else if(id == '#tabs-5' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('PatentInventor');
			}
			else if(id == '#tabs-6' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('PatentAttorney');
			}
			else if(id == '#tabs-7' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('PatentPriority');
			}
			else if(id == '#tabs-11' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('PatentCitation');
			}
			else if(id == '#tabs-12' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('PatentCitationUs');
			}
			else if(id == '#tabs-13' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('PatentCitationEp');
			}
			else if(id == '#tabs-14' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('RenewalLog');
			}
			else if(id == '#tabs-15' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('CasePrivilege');
				resetFrame('CasePrivilege2');
			}
			else if(id == '#tabs-c6' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('SalesOrder');
			}
		}
	});
});
}

function createCopyrightTabs1() {
$(function(){
	$('#tabs').tabs({
		activate: function (event, ui) {
			var id = ui.newTab.context.hash;
			
			if(id == '#tabs-2' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('CopyrightColleagues');
			}
			else if(id == '#tabs-3' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('CopyrightDocument');
			}
			else if(id == '#tabs-4' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('CopyrightApplicant');
			}
			else if(id == '#tabs-5' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('CopyrightPriority');
			}
			else if(id == '#tabs-6' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('CopyrightAttorney');
			}
			else if(id == '#tabs-7' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('CopyrightToDos');
			}
			else if(id == '#tabs-14' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('RenewalLog');
			}
			else if(id == '#tabs-15' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('CasePrivilege');
				resetFrame('CasePrivilege2');
			}
			else if(id == '#tabs-c6' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('SalesOrder');
			}
		}
	});
});
}

function createLegalTabs1() {
$(function(){
	$('#tabs').tabs({
		activate: function (event, ui) {
			var id = ui.newTab.context.hash;
			
			if(id == '#tabs-2' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('LegalColleagues');
			}
			else if(id == '#tabs-3' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('LegalDocument');
			}
			else if(id == '#tabs-4' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('LegalRelative');
			}
			else if(id == '#tabs-41' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('LegalApplicant');
			}
			else if(id == '#tabs-4o' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('LegalOpponent');
			}
			else if(id == '#tabs-5' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('CopyrightPriority');
			}
			else if(id == '#tabs-6' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('LegalAttorney');
			}
			else if(id == '#tabs-7' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('LegalToDos');
			}
			else if(id == '#tabs-8' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('LegalSitting');
			}
			else if(id == '#tabs-14' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('RenewalLog');
			}
			else if(id == '#tabs-15' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('CasePrivilege');
				resetFrame('CasePrivilege2');
			}
			else if(id == '#tabs-c6' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('SalesOrder');
			}
		}
	});
});
}


function createTrademarkTabs1() {
$(function(){
	$('#tabs').tabs({
		activate: function (event, ui) {
			var id = ui.newTab.context.hash;
			if(id == '#tabs-2' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('TrademarkApplicant');
			}
			else if(id == '#tabs-3' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('PatentToDos');
			}
			else if(id == '#tabs-4' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('TrademarkPriority');
			}
			else if(id == '#tabs-5' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('TrademarkAttorney');
			}
			else if(id == '#tabs-6' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('TrademarkDocument');
			}
			else if(id == '#tabs-7' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('TrademarkToDos');
			}
			else if(id == '#tabs-8' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('RenewalLog');
			}
			else if(id == '#tabs-15' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('CasePrivilege');
				resetFrame('CasePrivilege2');
			}
			else if(id == '#tabs-c6' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				resetFrame('SalesOrder');
			}
		}
	});
});
}


function resetTodosTab(target, flowkey) {
	$.ajax({
		type: 'POST',
		url: 'AjaxServlet.do',
		data: {
			'flowkey': flowkey,
			'target': target,
			className: 'ToDos'
		}
	})
	.done(function(data) {
		var id = '#tabs-3';
		if(target == 'TrademarkCase') {
			id = '#tabs-7';
		}
		else if(target == 'LegalCase') {
			id = '#tabs-7';
		}
		else if(target == 'CopyrightCase') {
			id = '#tabs-7';
		}
		else if(target == 'ServiceProject') {
			id = '#tabs-7t';
		}
		if(data.count == 0) {
			$('a[href$="' + id + '"]').html('待辦事項(0)');
		}
		else {
			$('a[href$="' + id + '"]').html('<font color="red">待辦事項(' + data.count + ')</font>');
		}
	})
	.fail(function(){   
		top.$.unblockUI();
	});
}


function createSalesorderTabs1(tabid) {
$(function(){
	$('#'+tabid).tabs({
		activate: function (event, ui) {
			var id = ui.newTab.context.hash;
			
			if(id == '#tabs-3' && !$(id).attr('show')) {
				$(id).attr('show', '1');
				
				if($('#caseframe').length > 0) {
					$('#caseframe').prop('src', $('#frameurl').val());
				}
			}
			
		}
	});
});
}

function setQuotationFavor(id, fk) {

	var img = $('#'+id);

	if($('#'+id).attr('imgtype') == '2') {
		$('#'+id).prop('src', 'img/star1.gif');
		$('#'+id).attr('imgtype', '1');
	}
	else {
		$('#'+id).prop('src', 'img/star2.gif');
		$('#'+id).attr('imgtype', '2');
	}
	
	$.ajax({
			type: 'POST',
			url: 'AjaxServlet.do',
			data: {
				'type': $('#'+id).attr('imgtype'),
				fk: fk,
				target: 'QuotationFavor',
				className: 'QuotationCreateSo'
			}
		})
		.done(function(data) { 
			if(data.success) {
				if($('#'+id).attr('imgtype') == '2') {
					notyMsg('設定成功');
				}
				else {
					notyMsg('取消成功');
				}
				
			}
			else {
				notyMsg('設定失敗');			
			}
		})
		.fail(function(){  
		});
}


function setFocus(newid) {
		if($('#'+newid).length > 0) {
			$('#'+newid).blur(function() {
			  $('#'+newid).css({'background-color' : '#ffffff'});
			});
	
			$('#'+newid).css({'background-color' : '#00ff80'});
			$('#'+newid).focus();
		}
}

function doNextFocus(event,oldid, newid) {
	if(event.keyCode == 13) {
		if($('#'+newid).length > 0) {
		/*
			$('#'+newid).blur(function() {
			  $('#'+newid).css({'background-color' : '#ffffff'});
			});
	
			$('#'+newid).css({'background-color' : '#a0f288'});
		*/
			$('#'+newid).focus();
			
		}
	}
}

function setInvoiceDetailBg() {
	$('#unitPrice').css({'background-color' : '#a0f288'});
	$('#quantity').css({'background-color' : '#a0f288'});
	$('#currency').css({'background-color' : '#a0f288'});
	$('#miscellaneous').css({'background-color' : '#a0f288'});
	$('#invoiceExchangeRate').css({'background-color' : '#a0f288'});
	$('#invoiceCurrency').css({'background-color' : '#a0f288'});
	$('#taxType').css({'background-color' : '#a0f288'});
}


function setInvoiceBg(type) {
	$('#voucherDate').css({'background-color' : '#a0f288'});
	$('#invoiceNo').css({'background-color' : '#a0f288'});
	$('#attorneyTitle').css({'background-color' : '#a0f288'});
	$('#taskDescription').css({'background-color' : '#a0f288'});
	if(type == 'ATitle01' || type == 'ATitle04') {
		$('#receiptNumber').css({'background-color' : '#a0f288'});
	}
	else if(type == 'ATitle02') {
		$('#invoiceNumber').css({'background-color' : '#a0f288'});
	}
}

function setInvoicePreAccountBg() {
	$('#currency').css({'background-color' : '#a0f288'});
	$('#midCurrency').css({'background-color' : '#a0f288'});
	$('#exchangeRate').css({'background-color' : '#a0f288'});
	$('#invoiceCurrency').css({'background-color' : '#a0f288'});
	$('#midExchange').css({'background-color' : '#a0f288'});
}


function createClientTabs() {
	$(function(){
		$('#tabs').tabs({
			activate: function (event, ui) {
				var id = ui.newTab.context.hash;
				
				if(id == '#tabs-2' && !$(id).attr('show')) {
					$(id).attr('show', '1');
					//resetFrame('ClientApplicant');
				}
				if(id == '#tabs-9' && !$(id).attr('show')) {
					$(id).attr('show', '1');
					resetFrame('ClientAppTable');
				}
				if(id == '#tabs-10' && !$(id).attr('show')) {
					$(id).attr('show', '1');
					resetFrame('InventorTable');
				}
				if(id == '#tabs-3' && !$(id).attr('show')) {
					$(id).attr('show', '1');
					resetFrame('CaseTable');
				}
				if(id == '#tabs-5' && !$(id).attr('show')) {
					$(id).attr('show', '1');
					resetFrame('ServiceProject');
				}
				if(id == '#tabs-6' && !$(id).attr('show')) {
					$(id).attr('show', '1');
					resetFrame('NotYetWriteOffInvoice');
				}
				if(id == '#tabs-7' && !$(id).attr('show')) {
					$(id).attr('show', '1');
					resetFrame('Quotation1');
				}
				if(id == '#tabs-8' && !$(id).attr('show')) {
					$(id).attr('show', '1');
					resetFrame('Quotation2');
				}
				if(id == '#tabs-13' && !$(id).attr('show')) {
					$(id).attr('show', '1');
					resetFrame('ClientDocument');
				}
			}
		});
	});
}



var cache_caseno = {};
function setCaseNoAutoField(inputId) {
	$("#" + inputId).autocomplete({
	  autoFocus:true,
      minLength: 4,
      source: function( request, response ) {
      	var term = request.term;
      	if ( term in cache_caseno ) {
          response( cache_caseno[ term ] );
          return;
        }
        
        	$.ajax({
               type: "POST",
               url: "AjaxServlet.do",
               data: {
					'term': request.term,
					target: 'findCaseNo',
					className: 'Cases'
				},
               dataType: "json",
               success: function (data) {
               		cache_caseno[ term ] = data;
                   response(data);
               },
               error: function (msg) {
               }
           })
      },
		      select: function(event, ui) {
                var id = $(this).attr('id');
                $('#'+id+'_h').text(ui.item.label);
                //$('#'+id).val(ui.item.label);
              },
              change: function( event, ui ) { document.input.changeCaseNo.value=true;setValue(); }
    });
    
    $("#" + inputId).after("<span id='" + inputId + "_h'></span>");
}

function insertHiddenBtn() {

}

var showBodyTable;
function hiddenSearchTable(reload) {
	if(document.input.pageActionMode.value == 'search') {

			$.ajax({
               type: "POST",
               url: "AjaxServlet.do",
               data: {
               		'reload': reload,
					'program': document.input.program.value,
					target: 'hiddenSearch',
					className: 'Html'
				},
               dataType: "json",
               success: function (data) {
                   showBodyTable = data.showBodyTable;

                   var bodyTable = $('#bodyTable');
				if(bodyTable.length > 0) {
					var trs = bodyTable.children('tbody').children('tr');
					if(trs.length == 1) {
						$(trs[0]).hide();
					}
					else if(trs.length >= 2) {
						for(var i = 0;i<trs.length;i++) {
						  //本來就呈現，就要關掉
						  if(showBodyTable) {
						  	$(trs[i]).hide();
						  }
						  else {
						    $(trs[i]).show();
						  }
						}
					}
				}
               },
               error: function (msg) {
               }
           });
	
		
		if(showBodyTable) {
			showBodyTable = false;
		}
		else {
			showBodyTable = true;
		}
	}
	
}



function resetFieldsSetting(){
	var data = "[";
	var checks = $("input[id='fieldCheck']:checked");
	
	for(var i=0;i<checks.length;i++) {	
		data += "{";
		data += '"field":"' + checks[i].value + '",';
		data += '"replace":"' + $("#"+checks[i].value+"_Replace").val() + '",';
		data += '"type":"' + $("#"+checks[i].value+"_Type").val() + '",';
		data += '"category":"' + $("#"+checks[i].value+"_Category").val() + '"';
		
		if(i == checks.length -1){
			data += "}";
		}else{
			data += "},";
		}	
	}
	
	var addtionField = $("#addtionFieldSetting").val();
	
	if(addtionField != "undefine" && addtionField.length > 0){
		data += ","+addtionField;
	}
	
	data += "]";
	$("#settingField").val(data);

}

function markAllFields(){
	
	var isChecked = $('#markAll').is(':checked');

	if(isChecked){
		var checks = $("input:checkbox[id='fieldCheck']");
		for(var i = 0 ; i<checks.length; i ++){
			checks[i].checked = true;
		}
	}else{
		$("input:checkbox[id='fieldCheck']:checked").attr('checked',false);
	
	}
	
}

function toReportPreview(table){
	var url = "ReportTemplatePreview.jsp?reportNum=Multi&table="+table+"&keys=";
	var keys = "";
	if($('#markKey') != null){
		var items = $("input[id='markKey']:checked");
		
		for(var i=0 ; i <items.length; i++){
			if(i==0){
				keys+=items[i].value;
			}else{
				keys+=","+items[i].value;
			}	
		}
		url = url+keys;
		if(items != null && items != "undefine" && items.length>0){
			document.location.href = url;
		}else{
			alert("請先勾選案件!");
		}	
	}
}	

function calTimePoints() {
	//業績時薪*計費小時*90%
	
}


function checkMiscFee() {
	if($("input[name=markKey]:checked").length == 0) {
		alert('您尚未勾選事務費');
		return;
	}
	
	var items = $("input[id='markKey']:checked");
	var keys = '';
	for(var i=0 ; i <items.length; i++){
		if(i==0){
			keys+=items[i].value;
		}else{
			keys+=","+items[i].value;
		}	
	}
	
	$.ajax({
			type: 'POST',
			url: 'AjaxServlet.do',
			data: {
				keys: keys,
				target: 'CheckMiscFee',
				className: 'MiscFee'
			}
		})
		.done(function(data) { 
			if(data.error == 1) {
				alert('請勾選相同幣別者進行請款');
			}
			else if(data.error == 2) {
				alert('請勾選未請款項目進行請款');
			}
			else if(data.error == 3) {
				alert('請勾選相同案號進行請款');
			}
			else if(data.error == 0) {
				openAppendix("MiscFeeInvoice.jsp?pageActionMode=maintain&dbActionMode=insert&modeLockFlag=true&caseNo=" + data.caseNo,"",500,300);
			}
		})
		.fail(function(){  
		});
}

function checkMiscFeeInvoice() {
	if(document.input.invoiceNo.value != '') {
		$.ajax({
			type: 'POST',
			url: 'AjaxServlet.do',
			data: {
				caseNo: document.input.caseNo.value,
				invoice: document.input.invoiceNo.value,
				target: 'CheckMiscFeeInvoice',
				className: 'MiscFee'
			}
		})
		.done(function(data) { 
			if(data.error == 1) {
				alert('該請款編號不存在，請重新輸入');
				return;
			}
			else if(data.error == 2) {
				alert('所輸入的請款編號之案件編號與事務費不符，請重新輸入');
				return;
			}
			else if(data.error == 0) {
				window.opener.document.input.doCharge.value=true;
				window.opener.document.input.invoiceNo.value=document.input.invoiceNo.value;
				window.opener.setValue();
				window.close();
				
			}
		})
		.fail(function(){  
		});
	}
	else {

		window.opener.document.input.doCharge.value=true;
		window.opener.document.input.invoiceNo.value=document.input.invoiceNo.value;
		window.opener.setValue();
		window.close();
	}
}

