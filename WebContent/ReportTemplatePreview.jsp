<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*,java.io.File,java.lang.StringBuffer,deepspot.main.*,deepspot.util.*,deepspot.basic.*" %>
<jsp:useBean id="userInfo" scope="session" class="deepspot.main.UserBean" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Report Template Preview</title>
	
	<link href='css/login.css' rel='stylesheet' type='text/css'>
	<link href='css/reportTemplateDefault.css' rel='stylesheet' type='text/css'>
	<link href='css/smoothness/jquery-ui-1.10.2.custom.css' rel='stylesheet' type='text/css'>
	<link href='css/style_paginate.css' rel='stylesheet' type='text/css'>
	<script language='JavaScript' src='js/jquery-1.9.1.js'></script>
	<script language='JavaScript' src='js/jquery-ui-1.10.2.custom.min.js'></script>
	<script language='JavaScript' src='js/jquery.paginate.js'></script>
	<script language='JavaScript' src='js/basic.js'></script>
	<script language='JavaScript' src='js/tree.js'></script>
	<script language='JavaScript' src='js/ajax.js'></script>
	<script language='JavaScript' src='js/AC_RunActiveContent.js'></script>
	<script language='JavaScript' src='js/AC_ActiveX.js'></script>
	<!-- <script language='javascript' src="js/tinymce/tinymce.min.js"></script> -->
	<script language='javascript' src="js/CKEditor/ckeditor.js"></script>
	<script language='javascript' src="js/CKEditor/adapters/jquery.js"></script>
	<!--  <script language='javascript' src="js/reportTemplate.js"></script> -->

	<style>
		html,
		body {
		    height: 100%; 
		    padding: 0;
		    margin: 0;
		}
		
		#container {
		    display: table; 
		    width: 100%;
		    height: 100%;
		}
	  
	  .custom-combobox {
	    position: relative;
	    display: inline-block;
	  }
	  .custom-combobox-toggle {
	    position: absolute;
	    top: 0;
	    bottom: 0;
	    margin-left: -1px;
	    padding: 0;
	    /* support: IE7 */
	    *height: 1.7em;
	    *top: 0.1em;
	  }
	  .custom-combobox-input {
	    margin: 0;
	    padding: 0.3em;
	  }
	  #valueFieldKeyValueList{
	  	width: 330px;
	  }
	  .ui-autocomplete {
	    max-height: 400px;
	    overflow-y: auto;   /* prevent horizontal scrollbar */
	    overflow-x: hidden; /* add padding to account for vertical scrollbar */
	    z-index:1000 !important;
		}
 	</style>

<!--
	<script type="text/javascript">
		$(function() {
			$( "#FunctionList" ).combobox();
			$( "#ReportList" ).combobox();
			$( "#KeyValueList" ).combobox();
		});

		$(function(){$("#BasicTab").tabs();});
		
	</script>
-->
</head>
<body>

<input type="hidden" id="templateType" value="Preview"/>
<input type="hidden" id="reportNum" value="Single"/>
<input type="hidden" id="editorType" value="Update"/>
<div id="multiKeyContentDiv">
</div>
<div id="container">
	<!--  <div id="BasicTab" style="height:520px;width:1100px;margin: 0px auto;"> -->
	<div id="BasicTab" style="height:95%;width:98%;margin: 0px auto;">
			<ul>
				<li><a href="#tabs-1">新例稿報表功能</a></li>
				<!--
				<li><a href="#tabs-2">報表底稿設定</a></li> 
				-->
			</ul>
			<div id="tabs-1" style="height:100%;">
			<fieldset id="fieldSet" style="height:100%;">
				<center style="height:100%;">
					<!-- <table border='1' style="width:1050px;height:400px;"> -->
					<table border='1' style="width:1050px;height:100%;">
						<tr>
							<td style="height:20px" colspan="2">
								<div style="display:block;float:left;">
									<div id="FunctionSelectDiv" style="display:inline;">
										<div id="FunctionListDiv" style="display:inline;">
											功能名稱：<select id="FunctionList" onChange="getReportList();getKeyList();getDataFieldsList();clearReportAndKey();clearReportContent();"></select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</div>
										<div id="ReportListDiv" style="display:inline;">
											報表名稱：<select id="ReportList" onChange="clearHiddenMultiContent()"></select> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</div>
										<div id="KeyValueListDiv" style="display:inline;">
											案件編號：<select id="KeyValueList" onChange="getCaseData();setMultiContent();"></select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</div>
									</div>
									<div style="display:inline;">
										<input type="button" value="確定"/>
									</div>
									<div id="loading-img_loadTemplate" style="display:inline;">
										<img src="img/spinner.gif">讀取中...
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td style="height:20px" colspan="2">
								<div style="display:block;">
									<div id="PreviewBtnArea" style="display:inline;">
										<div style="display:block;float:left;">
											<input type="button" value="報表底稿設定功能" onclick="changeReportEditTemplate();"/>
											<input type="button" value="上傳檔案管理" onclick="openAppendix('UploadFiles.jsp?_dbActionMode=insert&_pageActionMode=maintain','UploadFiles',600,400)"/>
										</div>
										<div style="display:block;float:right;">
											<div id="MultiBtnArea" style="display:inline;">
												批次：
												<input type="button" value="全部載入" onClick="if(confirm('確定要載入全部案件報表？')){getAllReportData()}else{}"/>
												<input type="button" value="全部儲存" onClick="if(confirm('確定要儲存全部案件報表？')){saveAllReportData()}else{}"/>
												<input type="button" value="全部產生內容" onClick="if(confirm('確定要產生全部案件報表內容？')){getCreateAllReportData()}else{}"/>
												<input type="button" id="makePdfBtn" value="全部套印PDF檔案" onClick="if(confirm('確定要套印全部案件報表PDF檔案？')){makeAllReportDataPdf()}else{}"/>
												<!--  <input type="button" id="makePdfBtn" value="全部套印PDF檔案" onClick="if(confirm('確定要套印全部案件報表PDF檔案？')){makeAllReportDataPdf()}else{}"/> -->
												&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;單筆：
											</div>
											<div id="SingleBtnArea" style="display:inline;">
												<input type="button" value="載入" onClick="if(confirm('確定要載入案件報表？')){loadReportPersonalData();setHiddenMultiContent();}else{}"/>
												<input type="button" value="儲存" onClick="if(confirm('確定要儲存案件報表？')){savePersonalReport();setHiddenMultiContent();}else{}"/>
												<input type="button" value="產生內容" onclick="getCreateReportData();setHiddenMultiContent();"/>
												
											</div>
										</div>
									</div>
									<div id="EditorBtnArea" style="display:inline;">
										<div style="display:block;float:left;">
											<input type="button" value="報表產生內容預覽功能" onClick="changeReportPreviewTemplate()"/>
										</div>
										<div id="EditorBasicBtn" style="display:block;float:right;">
											<input type="button" value="新增底稿" onClick="changeEditorModeBtn()"/>
											<input type="button" value="刪除底稿" onClick="if(confirm('確定要刪除底稿？')){deleteReportData()}else{}"/>
											<input type="button" value="載入底稿" onClick="if(confirm('確定要載入底稿？')){getReportData()}else{}"/>
											<input type="button" value="儲存底稿" onClick="if(confirm('確定要儲存底稿？')){getSaveReport()}else{}"/>
										</div>
										<div id="EditorInsertBtn" style="display:block;float:right;">
											報表名稱：<input type="text" id="insertReportName" value=""/>
											報表類型：通用<input type="radio" name="reportType" value="Common"/>個人<input type="radio" name="reportType" value="Personal"/>
											<input type="button" value="新增" onClick="if(confirm('確定要新增底稿？')){getInsertReport()}else{}"/>
											<input type="button" value="取消" onClick="if(confirm('確定要取消新增底稿？')){changeEditorModeBtn()}else{}"/>
										</div>
									</div>
								</div>
							</td>
						</tr>
						<tr style='vertical-align:top;' >
							<td style="width:670px;" id="editorTd">
								<!-- <textarea name='TemplateEditor' id='TemplateEditor' style="height:260px"></textarea> -->
								<!-- 換CKEditor	<textarea name='TemplateEditor' id='TemplateEditor' ></textarea> -->
								<textarea id="ckeditor" name="ckeditor" cols="80" rows="30"></textarea>
								<!-- <textarea class="ckeditor" id="ckeditor" cols="80" rows="30"></textarea> -->
							</td>
							<td style="width:360px;">
								<!-- 表頁籤 -->
								 <div id="tabs" >
						            <ul>
						                <li><a href="#tab_main" onclick='nonePagination_tabDatas()' >主表</a></li>
						            </ul>
						            <div id='pagination_tabDatas' style='display:none' ></div>
						            <div id="tab_main" style='height:700px; overflow:auto;text-align:left;' ></div>
						        </div>
								
								<!-- <div style="height:380px;overflow:auto;text-align:left;" id="dataShowDiv"> -->
								<!-- 放入頁籤中<div style="height:400px;overflow:auto;text-align:left;" id="dataShowDiv"></div> -->
							</td>
						</tr>
					</table>
				</center>
			</fieldset>	
			</div>
			<!--
			<div id="tabs-2">
				Ttab2
			</div>
			-->
	</div>
</div>

<script type="text/javascript">

		$(function(){$("#BasicTab").tabs();});
		
		function resizeContainer(){
			 $("#dataShowDiv").css("height", "100%");
			 $("#fieldSet").css("height", "100%");
			 $("#tabs-1").css("height", "100%");
			
			var heightDataShowDiv = $("#dataShowDiv").css("height");
			var heightFieldset = $("#fieldSet").css("height");
			var heightTabs = $("#tabs-1").css("height");
			heightDataShowDiv = heightDataShowDiv.substring(0,heightDataShowDiv.length-2);
			heightFieldset = heightFieldset.substring(0,heightFieldset.length-2);
			heightTabs = heightTabs.substring(0,heightTabs.length-2);
			
			heightDataShowDiv = heightDataShowDiv -40;
			heightFieldset = heightFieldset - 70;
			heightTabs = heightTabs - 100;
			
			var newHeightDataShowDiv = heightDataShowDiv + "px";
			var newHeightFieldset = heightFieldset + "px";
			var newHeightTabs = heightTabs + "px";
			 $("#dataShowDiv").css("height", newHeightDataShowDiv);
			 $("#fieldSet").css("height", newHeightFieldset);
			 $("#tabs-1").css("height", newHeightTabs);
		}
		resizeContainer();
		
		
		var editorTdHeight = $("#BasicTab").css("height");
		editorTdHeight = editorTdHeight.substring(0,editorTdHeight.length-2);
		editorTdHeight = editorTdHeight-300;
		$("#TemplateEditor").css("height",editorTdHeight + "px");

</script>
<script language='javascript' src="js/reportTemplate.js"></script>
<script type="text/javascript">
		$(function() {
			$( "#FunctionList" ).combobox();
			$( "#ReportList" ).combobox();
			$( "#KeyValueList" ).combobox();
			
			//$( "#tabs" ).tabs();
			$( "#tabs" ).tabs({
				activate: function( event, ui ) {	//換頁籤時的動作
					var active = $( "#tabs" ).tabs( "option", "active" );
					clog("當前tab.active=>" + active);
					
					initPagination_tabDatas("pagination_tabDatas" + (active-1));
				}
			});
			
		});
		
		//CKEditor
		//改動態取得	CKEDITOR.config.height = '670px';	//設定高度
		CKEDITOR.config.height = $("#editorTd").css("height");	//設定高度
		//CKEDITOR.inline( 'editorTd' );	//限定不能超出指定框架範圍，會出錯，尚不確定原因，先關
		CKEDITOR.disableAutoInline = true;
		
		$( document ).ready( function() {
			$( '#ckeditor' ).ckeditor();
			
		} );
		
</script>
</body>
</html>