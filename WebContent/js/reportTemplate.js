//設定jquery combobox autocomplete
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
	          //autocomplete的欄位給予id
	          .attr( "id", "valueField"+this.element.attr("id") )
	          .addClass( "custom-combobox-input ui-widget ui-widget-content ui-state-default ui-corner-left" )
	          .autocomplete({
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
	          },
	 
	          autocompletechange: "_removeIfInvalid"
	        });
	      },
	 
	      _createShowAllButton: function() {
	        var input = this.input,
	          wasOpen = false;
	 
	        $( "<a>" )
	          .attr( "tabIndex", -1 )
	          .attr( "title", "顯示所有選項" )
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
	        	//觸發combobox的onchange
	        	var org_onchange = this.element.closest("select").prop("onchange");
				if(org_onchange() != null){
					org_onchange();
				}
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
		        //觸發combobox的onchange
	        	var org_onchange = this.element.closest("select").prop("onchange");
				if(org_onchange() != null){
					org_onchange();
				}
	          return;
	        }
	 
	        // Remove invalid value
	        this.input
	          .val( "" )
	          .attr( "title", value + " 找不到對應選項" )
	          .tooltip( "open" );
	        this.element.val( "" );
	        this._delay(function() {
	          this.input.tooltip( "close" ).attr( "title", "" );
	        }, 2500 );
	        this.input.data( "ui-autocomplete" ).term = "";
	        //若選擇功能為不再列表的選項則清空後兩個選項欄位
	        if(this.element.attr("id") == "FunctionList"){
	        	$("#ReportList option").remove();
	        	$("#KeyValueList option").remove();
	        	$("#valueFieldReportList").val("");
	        	$("#valueFieldKeyValueList").val("");
	        	$("#ReportList").val("");
	        	$("#KeyValueList").val("");
	        }
	        if(this.element.attr("id") == "KeyValueList"){
	        	clearDataFields();
	        }
	      },
	 
	      _destroy: function() {
	        this.wrapper.remove();
	        this.element.show();
	      }
	    });
	  })( jQuery );

//為了IE7不支援JS會用到的JSON物件問題...判斷browser是否沒JSON物件，並讓browser自動下載(不會跳窗通知使用者，會自行載好)
if (typeof (JSON) == 'undefined') { //沒有 JSON 時才讓 browser 下載 json2.js
    $('head').append($("<script type='text/javascript' src='js/json2.js'>"));
}

//取參數設定單筆或多筆
if(getURLParameter("reportNum") != null && getURLParameter("reportNum") == "Multi"){
//	alert(getURLParameter("reportNum"));
	$("#reportNum").val("Multi");
//	alert($("#reportNum").val());
}

//一開始載入時根據模式判別按鈕區塊
if($("#templateType").val() != null && $("#templateType").val().length > 0 && $("#templateType").val() == "Preview"){
	changeBtnArea();
}

//按鈕區塊切換
function changeBtnArea(){
	//clog("templateType=>" + $("#templateType").val());
	if($("#templateType").val() != null && $("#templateType").val().length > 0 && $("#templateType").val() == "Preview"){
		$('#PreviewBtnArea').show();
		$('#EditorBtnArea').hide();
		$('#KeyValueListDiv').show();
		$("#dataShowDiv").html("");
		if($("#reportNum").val() == "Multi"){
			$("#MultiBtnArea").show();
		}else{
			$("#MultiBtnArea").hide();
		}
	}else{
		$('#PreviewBtnArea').hide();	//隱藏產製報表功能按鈕群
		$('#EditorBtnArea').show();	//顯示底稿編輯功能按鈕群
		$('#KeyValueListDiv').hide();	//案件編號下拉選單隱藏
		
		//右側原本輸入框部分清空
		//$("#dataShowDiv").html("");
		//tab_main.
		
		//底稿編輯功能按鈕群，子按鈕群控制
		$('#EditorBasicBtn').show();
		$('#EditorInsertBtn').hide();
		
		//當前頁面編輯類型更改
		$('#editorType').val('Update');
	}	
}

//編輯器內容填入
function setReportContent(content){
	//content = "DEMO XXX";
	//clog(content);
	
	$( '#ckeditor' ).val(content);
}
//編輯器內容取出
function getReportContent(){
	//無效	var ReportContent = $( '#ckeditor' ).attr("value");
	var ReportContent = CKEDITOR.instances.ckeditor.getData();
	clog("ReportContent=>" + ReportContent);
	return ReportContent;
}

//清除報表內容編輯器內容
function clearReportContent(){
	//換CKEditor	tinymce.get("TemplateEditor").setContent("");
	$( '#ckeditor' ).val("");
}

//清除報表名稱、案件編號選單
function clearReportAndKey(){
	$("#valueFieldReportList").val("");
	$("#valueFieldKeyValueList").val("");
	$("#ReportList").val("");
	$("#KeyValueList").val("");
}

//清除案件資料所有欄位
function clearDataFields(){
	var fields = $("input[id^='input_']");
	for(var i = 0 ; i <fields.length; i++ ){
		fields[i].value = "";
	}	
	
}

function changeEditorModeBtn(){
	if($('#editorType').val() != null && $('#editorType').val() != undefined 
			&& $('#editorType').val() == "Update"){
		$('#editorType').val("Insert");
		$("#ReportList").val("");
		$('#EditorInsertBtn').show();
		$('#EditorBasicBtn').hide();
		$('#ReportListDiv').hide();
	}else{
		$('#editorType').val("Update");
		$("#insertReportName").val("");
		$("input[type='radio'][name='reportType']:checked").prop('checked', false);
		$('#EditorBasicBtn').show();
		$('#EditorInsertBtn').hide();
		$('#ReportListDiv').show();
	}
}

//取得功能名稱選單
if($("#reportNum").val() == "Single"){
	clog("Single");
	var ajaxTabList = $.ajax({
		url:"ReportTemplateServlet",
		//async:false,	//非同步執行
		//data: $('#displayMethod').serialize(),
		data: {'method': 'FunctionList','functionName':'','reportName':'','key':''},
		type:"POST",
		dataType:'json',
		success:function(msg){
			//clog(msg);
			
			//alert('ajax='+msg);
			//alert(msg.length);
			$("#FunctionList").append($("<option></option>").attr("value", "").text("請選擇"));
			for(var i = 0 ; i<msg.length ; i++){
				$("#FunctionList").append($("<option></option>").attr("value", msg[i].table).text(msg[i].showName));
			}	
			//alert(msg[0].showName);
			//alert(msg[0].table);
		},
		beforeSend : function(){	//讀取中圖示顯示
			$('#loading-img_loadTemplate').show();
		},
		complete : function(){
			$('#loading-img_loadTemplate').hide();
		}
	});
}else{
	var tableKey = "";
	
	if(getURLParameter("table") != null && getURLParameter("table") != undefined){
		tableKey = getURLParameter("table");
	}	
	var ajaxTabList = $.ajax({
		url:"ReportTemplateServlet",
		//async:false,	//非同步執行
		//data: $('#displayMethod').serialize(),
		data: {'method': 'FunctionListAssign','functionName':'','reportName':'','key':tableKey},
		type:"POST",
		dataType:'json',
		success:function(msg){
			//alert('ajax='+msg);
			//alert(msg.length);
			$("#FunctionList").append($("<option></option>").attr("value", "").text("請選擇"));
			for(var i = 0 ; i<msg.length ; i++){
				$("#FunctionList").append($("<option></option>").attr("value", msg[i].table).text(msg[i].showName));
				$("#FunctionList").val(msg[i].table);
				$("#valueFieldFunctionList").val(msg[i].showName);
			}	
			
			getReportList();
			getKeyList();
			getDataFieldsList();
			//alert(msg[0].showName);
			//alert(msg[0].table);
		},
		beforeSend : function(){	//讀取中圖示顯示
			$('#loading-img_loadTemplate').show();
		},
		complete : function(){
			$('#loading-img_loadTemplate').hide();
		}
	});
}
	


function getReportList(){
	if($("#FunctionList").val() != null && $("#FunctionList").val().length > 0){
		$.ajax({
			url:"ReportTemplateServlet",
			//async:false,	//非同步執行
			//data: $('#displayMethod').serialize(),
			data: {'method': 'ReportList','functionName':$("#FunctionList").val(),'reportName':'','key':''},
			type:"POST",
			dataType:'json',
			success:function(msg){
//				alert('ajax='+msg);
//				alert(msg.length);
//				alert(msg[0].reportId);
//				alert(msg[0].reportName);
				$("#ReportList option").remove();
				$("#ReportList").append($("<option></option>").attr("value", "").text("請選擇"));
				for(var i = 0 ; i<msg.length ; i++){
					$("#ReportList").append($("<option></option>").attr("value", msg[i].reportId).text(msg[i].reportName));
				}	
			},
			beforeSend : function(){	//讀取中圖示顯示
				$('#loading-img_loadTemplate').show();
			},
			complete : function(){
				$('#loading-img_loadTemplate').hide();
			}
			
		});	
	}	
}

function getKeyList(){
	if($("#reportNum").val() == "Single"){
		if($("#FunctionList").val() != null && $("#FunctionList").val().length > 0){
			$.ajax({
				url:"ReportTemplateServlet",
				//async:false,	//非同步執行
				//data: $('#displayMethod').serialize(),
				data: {'method': 'KeyValueList','functionName':$("#FunctionList").val(),'reportName':'','key':''},
				type:"POST",
				dataType:'json',
				success:function(msg){
//					alert('ajax='+msg);
//					alert(msg.length);
//					alert(msg[0].reportId);
//					alert(msg[0].reportName);
					$("#KeyValueList option").remove();
					$("#KeyValueList").append($("<option></option>").attr("value", "").text("請選擇"));
					for(var i = 0 ; i<msg.length ; i++){
						$("#KeyValueList").append($("<option></option>").attr("value", msg[i].keyId).text(msg[i].keyName));
					}	
				},
				beforeSend : function(){	//讀取中圖示顯示
					$('#loading-img_loadTemplate').show();
				},
				complete : function(){
					$('#loading-img_loadTemplate').hide();
				}
				
			});	
		}	
	}else{
		var keys = "";
		
		if(getURLParameter("keys") != null && getURLParameter("keys") != undefined){
			keys = getURLParameter("keys");
		}	
		
		if($("#FunctionList").val() != null && $("#FunctionList").val().length > 0){
			$.ajax({
				url:"ReportTemplateServlet",
				//async:false,	//非同步執行
				//data: $('#displayMethod').serialize(),
				data: {'method': 'KeyValueListAssign','functionName':$("#FunctionList").val(),'reportName':'','key':keys},
				type:"POST",
				dataType:'json',
				success:function(msg){
//					alert('ajax='+msg);
//					alert(msg.length);
//					alert(msg[0].reportId);
//					alert(msg[0].reportName);
					$("#KeyValueList option").remove();
					$("#KeyValueList").append($("<option></option>").attr("value", "").text("請選擇"));
					for(var i = 0 ; i<msg.length ; i++){
						$("#KeyValueList").append($("<option></option>").attr("value", msg[i].keyId).text(msg[i].keyName));
						$("#multiKeyContentDiv").append("<input type='hidden' id='HiddenKey_"+ msg[i].keyId+"' value=''/>");
					}	
				},
				beforeSend : function(){	//讀取中圖示顯示
					$('#loading-img_loadTemplate').show();
				},
				complete : function(){
					$('#loading-img_loadTemplate').hide();
				}
				
			});	
		}
	}	
	
}


function getDataFieldsList(){
	clog("DO getDataFieldsList");
	clog("templateType=>" + $("#templateType").val());
	
	if($("#FunctionList").val() != null && $("#FunctionList").val().length > 0){
		if($("#templateType").val() != null && $("#templateType").val().length > 0 && $("#templateType").val() == "Preview"){
			$.ajax({
				url:"ReportTemplateServlet",
				//async:false,	//非同步執行
				//data: $('#displayMethod').serialize(),
				data: {'method': 'DataFieldSetting','functionName':$("#FunctionList").val(),'reportName':'','key':''},
				type:"POST",
				dataType:'json',
				success:function(msg){
					clog(msg);
					
//					alert('ajax='+msg);
//					alert(msg.length);
//					alert(msg[0].reportId);
//					alert(msg[0].reportName);
					
					//改放頁籤	$("#dataShowDiv").html("");
					$("#tab_main").html("");
					
					var showData = getShowData_DataFieldSetting(msg);
					/*提出
					var showData = "";
					showData += "<table>";
					for(var i = 0 ; i<msg.length ; i++){
						var fieldShowName = (msg[i].replace).replace("《","").replace("》","");
						fieldShowName = replaceAll(fieldShowName,"$","");
						showData += "<tr><td style='text-align:right;'>";
						showData += fieldShowName + "</td><td>";
						showData += "<input type='text' id='input_"+msg[i].field+"' replaceTag='"+msg[i].replace+"'/>";
						showData += "</td></tr>";
						if(msg[i].type == "date"){
							showData += "<tr><td style='text-align:right;'>";
							showData += fieldShowName + "(民國年)</td><td>";
							showData += "<input type='text' id='input_"+msg[i].field+"_ROC' replaceTag='《$"+fieldShowName+"_ROC$》'/>";
							showData += "</td></tr>";
						}
						else if(msg[i].type == "select"){
							showData += "<tr><td style='text-align:right;'>";
							showData += fieldShowName + "(含代碼)</td><td>";
							showData += "<input type='text' id='input_"+msg[i].field+"_Key' replaceTag='《$"+fieldShowName+"_Key$》'/>";
							showData += "</td></tr>";
						}
					}
					showData += "</table>";
					*/
					
					//改放頁籤	$("#dataShowDiv").html(showData);
					$("#tab_main").html(showData);
					
					//副表群
					cleanTab();	//先清空除了主表的頁籤
					//取得
					$.ajax({
						url:"ReportTemplateServlet",
						//async:false,	//非同步執行
						//data: $('#displayMethod').serialize(),
						data: {'method': 'DataFieldSetting_default','functionName':$("#FunctionList").val(),'reportName':'','key':''},
						type:"POST",
						dataType:'json',
						success:function(msg){
//							clog(msg);
							
							var tabs = $( "#tabs" );
							//加入展開時重載分頁元件	
							var tabTemplate = "<li><a href='#{href}'>#{label}</a></li>";
							//var tabTemplate = '<li><a href="#{href}" onclick="initPagination_tabDatas(\'#{pagination_tabDatas_Id}\')" >#{label}</a></li>';
							//var tabTemplate = '<li><a href="#{href}" onclick="initPagination_tabDatas(\'#{pagination_tabDatas_Id}\');blockPagination_tabDatas(\'#{pagination_tabDatas_Id}\');" >#{label}</a></li>';
							for(var imsg in msg){
								var tabData = msg[imsg];
								
								for(var tabName in tabData){	//這裡只會跑一次(只是因為不知道怎麼取key...)
//									clog(tabName);
									
									//表格組成
									var showData = getShowData_DataFieldSetting(JSON.parse(tabData[tabName]));
									var pagination_tabDatas_Id = "pagination_tabDatas" + imsg;
									
									var label = tabName || "Tab " + imsg;
									var id = "tabs-" + imsg;
									var li = $( tabTemplate.replace( /#\{href\}/g, "#" + id ).replace( /#\{label\}/g, label ).replace( /#\{pagination_tabDatas_Id\}/g, pagination_tabDatas_Id ) );
									tabs.find( ".ui-tabs-nav" ).append( li );
									tabs.append( "<div id='" + id + "' style='height:700px; overflow:auto;text-align:left;' >" + showData + "</div>" );
									tabs.tabs( "refresh" );	
								}
							}
						},
						beforeSend : function(){	//讀取中圖示顯示
							$('#loading-img_loadTemplate').show();
						},
						complete : function(){
							$('#loading-img_loadTemplate').hide();
						}
					});	
				},
				beforeSend : function(){	//讀取中圖示顯示
					//$('#loading-img_loadTemplate').show();
				},
				complete : function(){
					//$('#loading-img_loadTemplate').hide();
				}
			});	
		}	
		else if ($("#templateType").val() != null && $("#templateType").val().length > 0 && $("#templateType").val() == "Editor"){
			loadEditDataShowDiv();
		}
	}	
}
function getShowData_DataFieldSetting(msg){
	var showData = "";
	showData += "<table>";
	
	for(var i = 0 ; i<msg.length ; i++){
		var fieldShowName = (msg[i].replace).replace("《","").replace("》","");
		fieldShowName = replaceAll(fieldShowName,"$","");
		showData += "<tr><td style='text-align:right;'>";
		showData += fieldShowName + "</td><td>";
		showData += "<input type='text' id='input_"+msg[i].field+"' replaceTag='"+msg[i].replace+"'/>";
		showData += "</td></tr>";
//		clog("msg[i].type=>" + msg[i].type + " fieldShowName=>" + fieldShowName);
		if(msg[i].type == "date"){
			showData += "<tr><td style='text-align:right;'>";
			showData += fieldShowName + "(民國年)</td><td>";
			showData += "<input type='text' id='input_"+msg[i].field+"_ROC' replaceTag='《$"+fieldShowName+"_ROC$》'/>";
			showData += "</td></tr>";
		}
		else if(msg[i].type == "select"){
			showData += "<tr><td style='text-align:right;'>";
			showData += fieldShowName + "(含代碼)</td><td>";
			showData += "<input type='text' id='input_"+msg[i].field+"_Key' replaceTag='《$"+fieldShowName+"_Key$》'/>";
			showData += "</td></tr>";
		}
	}
	
	showData += "</table>";
	
	return showData;
}

function getReportData(){
	clog("DO getReportData");
	
	if($("#FunctionList").val() != null && $("#FunctionList").val().length > 0){
		if($("#ReportList").val() != null && $("#ReportList").val().length > 0){
			$.ajax({
				url:"ReportTemplateServlet",
				//async:false,	//非同步執行
				//data: $('#displayMethod').serialize(),
				data: {'method': 'ReportSettingData','functionName':'','reportName':$("#ReportList").val(),'key':''},
				type:"POST",
				dataType:'json',
				success:function(msg){
					//clearReportContent();	//先清空
					
					//clog(msg);
					if(msg.length > 0){
						//換CKEditor	tinymce.get("TemplateEditor").setContent(msg[0]);
						setReportContent(msg[0]);
					}	
					
				},
				beforeSend : function(){	//讀取中圖示顯示
					$('#loading-img_loadTemplate').show();
				},
				complete : function(){
					$('#loading-img_loadTemplate').hide();
				}
				
			});	
		}else{
			alert('請選擇"報表名稱"');
		}	
	}else{
		alert('請選擇"功能名稱"');
	}	
}

function deleteReportData(){
	if($("#FunctionList").val() != null && $("#FunctionList").val().length > 0){
		if($("#ReportList").val() != null && $("#ReportList").val().length > 0){
			$.ajax({
				url:"ReportTemplateServlet",
				//async:false,	//非同步執行
				//data: $('#displayMethod').serialize(),
				data: {'method': 'DeleteReportSettingData','functionName':'','reportName':$("#ReportList").val(),'key':''},
				type:"POST",
				dataType:'json',
				success:function(msg){
					if(msg[0]){
						alert('報表底稿刪除成功!');
					}else{
						alert('報表底稿刪除失敗!');
					}
				},
				beforeSend : function(){	//讀取中圖示顯示
					$('#loading-img_loadTemplate').show();
				},
				complete : function(){
					$('#loading-img_loadTemplate').hide();

					clearReportAndKey();
					clearReportContent();
					getReportList();
				}
				
			});	
		}else{
			alert('請選擇"報表名稱"');
		}	
	}else{
		alert('請選擇"功能名稱"');
	}	
}

var pagination_tabDatas_conf = {};	//為了分頁元件在頁籤未進入時就初始會縮起來...在每次頁籤進入都呼叫初始一次
function initPagination_tabDatas(pagination_tabDatas_Id){
	clog("DO initPagination_tabDatas! init附表分頁元件!");
	
	//clog(pagination_tabDatas_Id);
//	clog(pagination_tabDatas_conf[pagination_tabDatas_Id]);
//	clog(pagination_tabDatas_conf);
	clog("templateType=>" + $("#templateType").val());
	if(pagination_tabDatas_conf[pagination_tabDatas_Id] && pagination_tabDatas_conf[pagination_tabDatas_Id]!=null && pagination_tabDatas_conf[pagination_tabDatas_Id]!="undefined"
		&& $("#templateType").val()=="Preview"){
		//判斷當前頁籤是否要顯示
		//var active = $( "#tabs" ).tabs( "option", "active" );
		var active = $( "#tabs" ).tabs( "option", "active" );
		//clog(active);
		
//		clog("indexOf=>" + pagination_tabDatas_Id.indexOf(active-1));
//		clog("indexOf=>" + pagination_tabDatas_Id.indexOf(active-1) >= 0);
		if(pagination_tabDatas_Id.indexOf(active-1) >= 0){
			if(active > 0){
				$("#pagination_tabDatas").css('display', 'block');	
			}
			
			$("#pagination_tabDatas").paginate( pagination_tabDatas_conf[pagination_tabDatas_Id] );	
		}
	}else{
		nonePagination_tabDatas();
	}
	
	clog("dataDefault:");	clog(dataDefault);
}
//function blockPagination_tabDatas(pagination_tabDatas_Id){	//將分頁div顯示
//	clog("DO blockPagination_tabDatas");
//	if(pagination_tabDatas_conf[pagination_tabDatas_Id] && pagination_tabDatas_conf[pagination_tabDatas_Id]!=null && pagination_tabDatas_conf[pagination_tabDatas_Id]!="undefined"){
//		$("#pagination_tabDatas").css('display', 'block');
//	}
//}
function nonePagination_tabDatas(){	//將分頁div隱藏
	$("#pagination_tabDatas").css('display', 'none');
}

var dataDefault = {};	//為了分頁元件換資料時取用
var pagination_pages = {};	//為了tab切換後，分頁頁數能保留，頁面資料回填json時才能填到對應位置
function getCaseData(){
	clog("DO getCaseData");
	
	if($("#FunctionList").val() != null && $("#FunctionList").val().length > 0){
		if($("#KeyValueList").val() != null && $("#KeyValueList").val().length > 0){
			$.ajax({
				url:"ReportTemplateServlet",
				//async:false,	//非同步執行
				//data: $('#displayMethod').serialize(),
				data: {'method': 'CaseData','functionName':$("#FunctionList").val(),'reportName':'','key':$("#KeyValueList").val()},
				type:"POST",
				dataType:'json',
				success:function(msg){
//					clog(msg);
					
					//主表填值
					if(msg.length == 1){
						var data = msg[0];
						for(var i = 0 ; i < data.length ; i++){
							$("#"+data[i].inputField).val(data[i].value);
						}	
					}
					
					//副表(有多筆資料型態)分別取值填入
					clog("DO 副表分別取值填入");
					$.ajax({
						url:"ReportTemplateServlet",
						//async:false,	//非同步執行
						//data: $('#displayMethod').serialize(),
						data: {'method': 'CaseData_default','functionName':$("#FunctionList").val(),'reportName':'','key':$("#KeyValueList").val()},
						type:"POST",
						dataType:'json',
						success:function(msg){
							clog("msg:");	clog(msg);
							
							//先清空
							dataDefault = {};
							pagination_tabDatas_conf = {};
							
							for(var imsg in msg){
								var pagination_tabDatas_Id = "pagination_tabDatas"+imsg;
								
								//將此資料放入var保存，供分頁再次取用
								dataDefault[pagination_tabDatas_Id] = msg[imsg];
								clog("dataDefault:");	clog(dataDefault);
								
								pagination_pages[pagination_tabDatas_Id] = 1;	//放入預設page=1
								
								//放入分頁元件
								var count = msg[imsg].length;
//								clog("count=>" + count);
								if(count > 0){	//總筆數0會出錯
									pagination_tabDatas_conf[pagination_tabDatas_Id] = {
											count 		: count,
											start 		: 1,
											display     : 5,
											border					: true,
											border_color			: '#fff',
											text_color  			: '#0000AA',
											background_color    	: '#CCEEFF',
											border_hover_color		: '#ccc',
											text_hover_color  		: '#000',
											background_hover_color	: '#fff', 
											images					: false,
											mouse					: 'press',
											onChange     			: function(page){
																		//clog("page=>" + page);
																		clog("DO onChange! 切換附表資料分頁!");
																		//取不到...其實只有一個分頁元件...無法對應各頁籤放	clog("pagination_tabDatas_Id=>" + pagination_tabDatas_Id);
																		
																		getPagesDataToJson();	//將當前頁面上的資料回寫到json
																		
																		var active = $( "#tabs" ).tabs( "option", "active" );	//當前頁籤index
																		var pagination_tabDatas_NowId = "pagination_tabDatas"+(active-1);
																		clog("pagination_tabDatas_NowId=>" + pagination_tabDatas_NowId);
																		
																		pagination_pages[pagination_tabDatas_NowId] = parseInt(page);	//放入當前page
																		clog("pagination_pages:");	clog(pagination_pages);
																		
																		showOneData_default(dataDefault[pagination_tabDatas_NowId][page-1], (active-1));
																	  }
										};
//									clog(pagination_tabDatas_conf[pagination_tabDatas_Id]);
									initPagination_tabDatas(pagination_tabDatas_Id);	//呼叫頁面建立
									
									//取第一筆放入
									showOneData_default(msg[imsg][0], imsg);
								}
							}
							clog("dataDefault:");	clog(dataDefault);
						},
						beforeSend : function(){	//讀取中圖示顯示
							$('#loading-img_loadTemplate').show();
						},
						complete : function(){
							$('#loading-img_loadTemplate').hide();
						}
					});
					
				},
				beforeSend : function(){	//讀取中圖示顯示
					//等內層	$('#loading-img_loadTemplate').show();
				},
				complete : function(){
					//等內層	$('#loading-img_loadTemplate').hide();
				}
				
			});	
		}	
	}	
}
function showOneData_default(oneData, tabIndex){
	clog("DO showOneData_default!");
//	clog("tabIndex=>" + tabIndex);	//主表tab不列入計算，第一個附表tab=0
//	clog("oneData:");	clog(oneData);
//	clog("oneData=>" + JSON.stringify(oneData));
	
	//在[對應的tab]中的[對應欄位]填值
	for(var i = 0 ; i < oneData.length ; i++){
		$("#tabs-"+tabIndex + " #"+oneData[i].inputField).val("" + oneData[i].value);	
	}
}

//取得頁面可能改動的值放入存資料的json
function getPagesDataToJson(){
	clog("DO getPagesDataToJson!");
	
	//clog("當前tab=>" + $( "#tabs" ).tabs( "option", "active" ));
	clog("pagination_pages:");	clog(pagination_pages);
	clog("dataDefault:");	 clog(dataDefault);
	
	//對所有tab中input欄位取值，回填到json
	//查看上方頁籤，但此處直接對下面處理即可，是固定tabs不需要對應計算	clog($("#tabs ul")[0].children);
	for(var itabs=0; itabs<=5; itabs++){	//tabs0~5
		clog("itabs=>" + itabs);
		//clog($("#tabs-"+itabs+" input"));
		
		clog("tab中當前page=>" + pagination_pages["pagination_tabDatas"+itabs]);
		var getPagesDataToJson_dataNum = pagination_pages["pagination_tabDatas"+itabs]-1;
		clog("data中筆數=>" + getPagesDataToJson_dataNum);
		
		for(var iOneDataField in dataDefault["pagination_tabDatas"+itabs][getPagesDataToJson_dataNum]){
			var getPagesDataToJson_fileName = dataDefault["pagination_tabDatas"+itabs][getPagesDataToJson_dataNum][iOneDataField].inputField;
//			clog("getPagesDataToJson_fileName=>" + getPagesDataToJson_fileName);
			var getPagesDataToJson_inputValue = $("#tabs-"+itabs+" input[id="+getPagesDataToJson_fileName+"]").val();
//			clog("getPagesDataToJson_inputValue=>" + getPagesDataToJson_inputValue);
			
			dataDefault["pagination_tabDatas"+itabs][getPagesDataToJson_dataNum][iOneDataField].value = getPagesDataToJson_inputValue;
		}		
	}
	clog("dataDefault:");	 clog(dataDefault);
}

function getCreateReportData(){
	clog("DO getCreateReportData");
	//clog(dataDefault);
	
	var reportContext = "";
	$('#loading-img_loadTemplate').show();
	if($("#FunctionList").val() != null && $("#FunctionList").val().length > 0){
		if($("#ReportList").val() != null && $("#ReportList").val().length > 0){
			$.ajax({
				url:"ReportTemplateServlet",
				//async:false,	//非同步執行
				//data: $('#displayMethod').serialize(),
				data: {'method': 'ReportSettingData','functionName':'','reportName':$("#ReportList").val(),'key':''},
				type:"POST",
				dataType:'json',
				success:function(msg){
					clog("底稿msg:");	clog(msg);
					clog("dataDefault:");	clog(dataDefault);
					
					getPagesDataToJson();	//將當前頁面上的資料回寫到json
					
					//=======主表取代
					reportContext = msg[0];
					var fields = $("input[id^='input_']");
					//alert(fields.length);
					for(var i = 0 ; i <fields.length; i++ ){
//						clog(fields[i].id+"-"+fields[i].value);
						
						if(reportContext.indexOf($("#"+fields[i].id).attr("replaceTag")) > 0){
							reportContext = replaceAll(reportContext,$("#"+fields[i].id).attr("replaceTag"),fields[i].value);
						}
					}		

					//=======多值欄位取代~
					//處理[多值tableTag]取代
					var findLoseTags = reportContext.match(/《\SMultiValue_table_[^》]*》/g);	//取得「table多值標籤」	EX：《$MultiValue_table_發明人_發明人名稱§國籍§統一編號$》
					//clog(findLoseTags);
					for(var ifindLoseTags in findLoseTags){
						//取得「準備取代的tag」並拆解
						var tag = findLoseTags[ifindLoseTags];	//《$MultiValue_table_發明人_發明人名稱§國籍§統一編號$》
						var multiTags = tag.replace("《$MultiValue_", "").replace("$》", "").split("_");	//拆解tag
						//clog(tag);
//						clog(multiTags);
						
						//取得附表的資料群&tabIndex
						var agetTagDataFromDatadefault = getTagDataFromDatadefault(multiTags[1]);
						var data = agetTagDataFromDatadefault[0];	//目標附表的資料群
						var tabIndex = agetTagDataFromDatadefault[1];	//tabIndex
						clog("multiTags[1]=>"+multiTags[1] + " data:"); clog(data);
						
						var tagFields = tag.replace("《$MultiValue_", "").replace("$》", "").replace(multiTags[0]+"_", "").replace(multiTags[1]+"_", "");
						clog("tagFields=>" + tagFields);
						reportContext = reportContext.replace(tag, buildReplaceDefaultTableString(tagFields, data, tabIndex));	//取代tag
					}
					
					//處理[多值list區塊]取代
					reportContext = replaceDefaultList(reportContext);
					
					//~多值欄位取代
					
					reportContext = reportContext.replace("\\r\\n", "<br/>").replace("\\n", "<br/>").replace("\\r", "<br/>");
					
					if(reportContext.length > 0)	setReportContent(reportContext);	//內容置入編輯器
				}
			});	
		}else{
			alert('請選擇"報表名稱"');
		}
	}else{
		alert('請選擇"功能名稱"');
	}
	
	$('#loading-img_loadTemplate').hide();
	
}
//專用於oneKindDataDefault的value檢查
function scanningValue_oneKindDataDefault(scanned_oneKindDataDefault, scanned_value){
	var bscanningValue_oneKindDataDefault = false;
	for(var iscanned_oneKindDataDefault in scanned_oneKindDataDefault){
		if(scanned_oneKindDataDefault[iscanned_oneKindDataDefault].inputField == scanned_value){
			bscanningValue_oneKindDataDefault = true;
			break;
		}
	}
	return bscanningValue_oneKindDataDefault;
}
function getTagDataFromDatadefault(tagName){
	clog("tagName=>" + tagName);
	
	var data = [];	//目標附表的資料群
	var tabIndex = 0;	//tabIndex
	$('#tabs li').each(function(i){	//比對tag的附表名在頁面上是第幾個tab，判別要取用json中哪組資料
//		clog("$(this):");	clog($(this));
		
		if(data.length==0 && $(this)[0].innerText==tagName){
			var sInnerHTML = $(this)[0].innerHTML;
//			clog("sInnerHTML:");	clog(sInnerHTML);
			if(new RegExp("href=\"#tabs[^\"]+\"", "g").test(sInnerHTML)){
				var aMatch = new RegExp("href=\"#tabs[^\"]+\"", "g").exec(sInnerHTML);
				tabIndex = aMatch[0].replace('href=\"#tabs-', "").replace("\"", "");
				clog("tabIndex=>" + tabIndex);
				
				data = dataDefault["pagination_tabDatas"+tabIndex];
			}else{
				clog("取得tabIndex失敗...");
			}
		}
	});
	
	return [data, tabIndex];
}
function buildReplaceDefaultTableString(multiTags, data, tabIndex){
	clog("DO buildReplaceDefaultTableString!");
	var replacedText = "<table>";
	
	replacedText += "<tr>";	
	//拆解出要組成table的藍位名稱，§符號會被轉為「&sect;」
	var multiFields = [];	//要組成table的藍位名稱，給取值時使用
	for(var iFields in multiTags.split("&sect;")){
		clog("multiTags[2]=>" + multiTags);
		var multiField = multiTags.split("&sect;")[iFields]
		
		//[中文欄位]到[頁面input]對應出英文欄位名
		$("#tabs-"+tabIndex + " :input").each(function(){
//			clog("$(this):");	clog($(this));
			clog("replacetag=>" + $(this).attr("replacetag"));	//《$稱謂$》
			clog("replacetag=>" + $(this).attr("replacetag").replace("《$", "").replace("$》", ""));
			clog("multiField=>" + multiField);
			
			if(multiField == $(this).attr("replacetag").replace("《$", "").replace("$》", "")){
				multiFields.push($(this).attr("id"));
			}
		});
		
		replacedText += "<th>" + multiField + "</th>";	//先放入th
	}
	replacedText += "</tr>";
//	clog("multiFields:");	clog(multiFields);
	
	//照附表筆數依序放入<tr>
	for(var idata in data){
		var oneData = data[idata];
		
		replacedText += "<tr>";	
		
		//照[tag的欄位名稱]掃過data比對藍位名稱取得值放入td
		for(var imultiFields in multiFields){
//			//[中文欄位]到[頁面input]對應出英文欄位名
//			var fieldName_E = "";
//			$("#tabs-"+tabIndex + " :input").each(function(){
////				clog("$(this):");	clog($(this));
////				clog("replacetag=>" + $(this).attr("replacetag"));	//《$稱謂$》
//				
//				if(multiFields[imultiFields] == $(this).attr("replacetag").replace("《$", "").replace("$》", "")){
//					fieldName_E = $(this).attr("id");
//				}
//			});
//			clog("fieldName_E=>" + fieldName_E)
			
			for(var ioneData in oneData){
//				clog("oneData[ioneData].inputField=>" + oneData[ioneData].inputField);
//				clog("multiFields[imultiFields]=>" + multiFields[imultiFields]);
				if(oneData[ioneData].inputField == multiFields[imultiFields]){
					replacedText += "<th>" + oneData[ioneData].value + "</th>";	//先放入th	
				}
			}
		}
		replacedText += "</tr>";
	}
	replacedText += "</table>";
	
	return replacedText;
}
function replaceDefaultList(reportContext){	//附表list格式取代
	clog("DO replaceDefaultList!");
	
	var patterned = reportContext;
	while(new RegExp("《\\DMultiValue_list_[^》\\d]+_#START#\\D》", "g").test(patterned)){
		var labelName = new RegExp("《\\DMultiValue_list_[^》\\d]+_#START#\\D》", "g").exec(patterned)[0]
							.replace("《$MultiValue_list_", "").replace('_#START#$》', "");
		clog("labelName(tabName)=>" + labelName);
		
		//取得[對應tag]的data
		var agetTagDataFromDatadefault = getTagDataFromDatadefault(labelName);
		var data = agetTagDataFromDatadefault[0];	//目標附表的資料群
		var tabIndex = agetTagDataFromDatadefault[1];	//tabIndex
		clog("data:");	clog(data);
		
		var indexStart = new RegExp("《\\DMultiValue_list_"+labelName+"_#START#\\D》", "g").exec(patterned).index;
		clog("indexStart(startTag起始位置)=>" + indexStart);
		
		patterned = patterned.substring(indexStart + ("《$MultiValue_list_"+labelName+"_#START#$》").length);	//從START後開始準備取「list區塊」 = 取得startTag後的底稿字段
		
		if(new RegExp("《\\DMultiValue_list_"+labelName+"_#END#\\D》", "g").test(patterned)){
			var indexEnd = new RegExp("《\\DMultiValue_list_"+labelName+"_#END#\\D》", "g").exec(patterned).index;
			
			var oneDefaultList = patterned.substring(0, indexEnd);	//取得一個list格式區段底稿文字(一組資料成一段)
			oneDefaultList = replaceAll(oneDefaultList, "《$MultiValue_list_"+labelName+"_#換行#$》", "<br />");	//取代「換行」
			
			//取出[list段落]中tags
			var findLoseTags = oneDefaultList.match(/《\SMultiValue_list_[^》]*》/g);	//取得「list多值標籤」	EX：《$MultiValue_list_申請人_申請人名稱$》
			//clog(findLoseTags);
			
			//依資料筆數，重複建構list區段
			var strDefaultLists = "";	//所有資料取代list區塊的串接
			for(var idata in data){
				var oneDefaultList_temp = oneDefaultList;
				oneDefaultList_temp = replaceAll(oneDefaultList_temp, "《$MultiValue_list_"+labelName+"_#編號#$》", (Number(idata)+1));	//取代「編號」
				
				var oneData = data[idata];	//一組資料
				
				//取出欄位分別取代
				for(var ifindLoseTags in findLoseTags){
					var tag = findLoseTags[ifindLoseTags];	
					var multiTags = tag.replace("《$MultiValue_", "").replace("$》", "").split("_");	//拆解tag
					clog("tag=>" + tag);
					
					//[中文欄位]到[頁面input]對應出英文欄位名
					var tagName_E = "";
					$("#tabs-"+tabIndex + " :input").each(function(){
//						clog("multiField=>" + multiField);
						
						if(multiTags[2] == $(this).attr("replacetag").replace("《$", "").replace("$》", "")){
							tagName_E = $(this).attr("id");
						}
					});
					
					for(var ioneData in oneData){
						if(oneData[ioneData].inputField == tagName_E){
							oneDefaultList_temp = replaceAll(oneDefaultList_temp, tag, oneData[ioneData].value);
						}
					}
				}
				
				//避免夾雜空行去掉<p>
				oneDefaultList_temp = replaceAll(oneDefaultList_temp, "<p>", "");
				oneDefaultList_temp = replaceAll(oneDefaultList_temp, "</p>", "");
				
				clog("oneDefaultList_temp:");	clog(oneDefaultList_temp);
				clog("strDefaultLists:");	clog(strDefaultLists);
				//if(strDefaultLists != "")	strDefaultLists += "<br />";
				
				strDefaultLists += oneDefaultList_temp;	//串接
			}
			
			//取代整個list格式區塊
			reportContext = reportContext.replace(
				"《$MultiValue_list_"+labelName+"_#START#$》"+patterned.substring(0, indexEnd)+"《$MultiValue_list_"+labelName+"_#END#$》"
				, strDefaultLists);
		}else{
			alert("缺少對應的END標記《$MultiValue_list_"+labelName+"_#END#$》,不予取代問題區塊");
		}
	}
	return reportContext;
}

function getCreateAllReportData(){
	var reportContext = "";
	$('#loading-img_loadTemplate').show();
	if($("#FunctionList").val() != null && $("#FunctionList").val().length > 0){
		if($("#ReportList").val() != null && $("#ReportList").val().length > 0){
			var keys = "";
			
			if(getURLParameter("keys") != null && getURLParameter("keys") != undefined){
				keys = getURLParameter("keys");
			}	
			
			$.ajax({
				url:"ReportTemplateServlet",
				//async:false,	//非同步執行
				//data: $('#displayMethod').serialize(),
				data: {'method': 'makeAllCaseReportData','functionName':$("#FunctionList").val(),'reportName':$("#ReportList").val(),'key':keys},
				type:"POST",
				dataType:'json',
				success:function(msg){
//					alert('success!!');
//					alert(msg.length);
					for(var i = 0 ; i < msg.length ; i++){
						var hiddenkey = "HiddenKey_"+msg[i].key;
						var value = msg[i].value;
						value = replaceAll(value,"\\n","");
//						value = replaceAll(value,"\r\n","");
						value = replaceAll(value,"\\/","/");
						value = replaceAll(value,'\\"','"');
//						alert(hiddenkey+"="+msg[i].value);
						$("input[id='"+hiddenkey+"']").attr("value",value);
						
						if($("#KeyValueList").val() == msg[i].key){
							//換CKEditor	tinymce.get("TemplateEditor").setContent(value);
							setReportContent(value);
						}	
					}	
					alert('全案件產生完成');
				}
				
			});	
		}else{
			alert('請選擇"報表名稱"');
		}
	}else{
		alert('請選擇"功能名稱"');
	}
	
	$('#loading-img_loadTemplate').hide();
	
}

function saveAllReportData(){
	var reportContext = "";
	$('#loading-img_loadTemplate').show();
	if($("#FunctionList").val() != null && $("#FunctionList").val().length > 0){
		if($("#ReportList").val() != null && $("#ReportList").val().length > 0){
			var keys = "";
			
			if(getURLParameter("keys") != null && getURLParameter("keys") != undefined){
				keys = getURLParameter("keys");
			}	
			
			var fields = $("input[id^='HiddenKey_']");
			var jsonData = [];
			var keyStr = "key";
			var valueStr = "content";
			for(var i = 0 ; i <fields.length; i++ ){
				var jsonObj = {};

				var id = fields[i].id;
				id = id.substring(10);
				jsonObj[keyStr] = id; 
				
				var content = fields[i].value;
				jsonObj[valueStr] = content;
				
				jsonData[i] = jsonObj;
			}
			
			var jsonDataStr = JSON.stringify(jsonData);
//			alert(jsonData);
			
			$.ajax({
				url:"ReportTemplateServlet",
				//async:false,	//非同步執行
				//data: $('#displayMethod').serialize(),
				data: {'method': 'saveAllCaseReportData','functionName':$("#FunctionList").val(),'reportName':$("#ReportList").val(),'reportContent':jsonDataStr},
				type:"POST",
				dataType:'json',
				success:function(msg){
					if(msg[0]){
						alert('全案件儲存成功!');
					}else{
						alert('全案件儲存失敗!');
					}
				}
				
			});	
			
		}else{
			alert('請選擇"報表名稱"');
		}
	}else{
		alert('請選擇"功能名稱"');
	}
	
	$('#loading-img_loadTemplate').hide();
	
}

function getAllReportData(){
	$('#loading-img_loadTemplate').show();
	if($("#FunctionList").val() != null && $("#FunctionList").val().length > 0){
		if($("#ReportList").val() != null && $("#ReportList").val().length > 0){
			var keys = "";
			
			if(getURLParameter("keys") != null && getURLParameter("keys") != undefined){
				keys = getURLParameter("keys");
			}	
			
			$.ajax({
				url:"ReportTemplateServlet",
				//async:false,	//非同步執行
				//data: $('#displayMethod').serialize(),
				data: {'method': 'getAllCaseReportData','functionName':$("#FunctionList").val(),'reportName':$("#ReportList").val(),'key':keys},
				type:"POST",
				dataType:'json',
				success:function(msg){
					
//					alert(msg.length);
					
					for(var i = 0 ; i < msg.length ; i++){
						var key = msg[i].key;
						var value = msg[i].value;
						var hiddenkey = "HiddenKey_"+key;
						$("input[id='"+hiddenkey+"']").attr("value",value);
						
						if($("#KeyValueList").val() == key){
							//換CKEditor	tinymce.get("TemplateEditor").setContent(value);
							setReportContent(value);
						}	
					}	
					
					alert("全案件讀取完成");
				}
				
			});	
			
		}else{
			alert('請選擇"報表名稱"');
		}
	}else{
		alert('請選擇"功能名稱"');
	}
	
	$('#loading-img_loadTemplate').hide();
	
}

//進入底稿編輯時，右側輸入框組建
function loadEditDataShowDiv(){
	clog("DO loadEditDataShowDiv");
	
	if($("#FunctionList").val() != null && $("#FunctionList").val().length > 0){
		$.ajax({
			url:"ReportTemplateServlet",
			//async:false,	//非同步執行
			//data: $('#displayMethod').serialize(),
			data: {'method': 'DataFieldSetting','functionName':$("#FunctionList").val(),'reportName':'','key':''},
			type:"POST",
			dataType:'json',
			success:function(msg){
//				alert('ajax='+msg);
//				alert(msg.length);
//				alert(msg[0].reportId);
//				alert(msg[0].reportName);
				//clog(msg);
				
				//改放頁籤	$("#dataShowDiv").html("");
				$("#tab_main").html("");
				
				var showData = getShowData_EditDataShowDiv(msg);
				/*提出
				var showData = "";
				showData += "<table>";
				
				for(var i = 0 ; i<msg.length ; i++){
					var fieldShowName = (msg[i].replace).replace("《","").replace("》","");
					fieldShowName = replaceAll(fieldShowName,"$","");
					showData += "<tr><td style='text-align:right;width:75%;'>";
					showData += fieldShowName + "</td><td>";
					showData += "<input type='button' id='btn_"+msg[i].field+"' replaceTag='"+msg[i].replace+"' value='帶入參數' onClick='replaceTextToAttribute(\"btn_"+msg[i].field+"\")'/>";
					showData += "</td></tr>";
					if(msg[i].type == "date"){
						showData += "<tr><td style='text-align:right;width:75%;'>";
						showData += fieldShowName + "(民國年)</td><td>";
						showData += "<input type='button' id='btn_"+msg[i].field+"_ROC' replaceTag='《$"+fieldShowName+"_ROC$》' value='帶入參數' onClick='replaceTextToAttribute(\"btn_"+msg[i].field+"_ROC\")'/>";
						showData += "</td></tr>";
					}
					else if(msg[i].type == "select"){
						showData += "<tr><td style='text-align:right;width:75%;'>";
						showData += fieldShowName + "(含代碼)</td><td>";
						showData += "<input type='button' id='btn_"+msg[i].field+"_Key' replaceTag='《$"+fieldShowName+"_Key$》' value='帶入參數' onClick='replaceTextToAttribute(\"btn_"+msg[i].field+"_Key\")'/>";
						showData += "</td></tr>";
					}
				}
				*/
				
				//改放頁籤	$("#dataShowDiv").html(showData);
				$("#tab_main").html(showData);
				
				//副表群
				cleanTab();	//先清空除了主表的頁籤
				//取得
				$.ajax({
					url:"ReportTemplateServlet",
					//async:false,	//非同步執行
					//data: $('#displayMethod').serialize(),
					data: {'method': 'DataFieldSetting_default','functionName':$("#FunctionList").val(),'reportName':'','key':''},
					type:"POST",
					dataType:'json',
					success:function(msg){
						//clog(msg);
						
						var tabs = $( "#tabs" );
						//加入展開時重載分頁元件	
						var tabTemplate = "<li><a href='#{href}'>#{label}</a></li>";
						//var tabTemplate = '<li><a href="#{href}" onclick="initPagination_tabDatas(\'#{pagination_tabDatas_Id}\')" >#{label}</a></li>';
						//var tabTemplate = '<li><a href="#{href}" onclick="initPagination_tabDatas(\'#{pagination_tabDatas_Id}\');blockPagination_tabDatas(\'#{pagination_tabDatas_Id}\');" >#{label}</a></li>';
						for(var imsg in msg){
							var tabData = msg[imsg];
							
							for(var tabName in tabData){	//這裡只會跑一次(只是因為不知道怎麼取key...)
//								clog(tabName);
								
								var label = tabName || "Tab " + imsg;
								var id = "tabs-" + imsg;
								var pagination_tabDatas_Id = "pagination_tabDatas" + imsg;
								var li = $( tabTemplate.replace( /#\{href\}/g, "#" + id ).replace( /#\{label\}/g, label ).replace( /#\{pagination_tabDatas_Id\}/g, pagination_tabDatas_Id ) );
								
								//換多值標籤	var showData = getShowData_EditDataShowDiv(JSON.parse(tabData[tabName]));
								var showData = getShowData_EditDataShowDiv_default(JSON.parse(tabData[tabName]), label, id);
								
								tabs.find( ".ui-tabs-nav" ).append( li );
								tabs.append( "<div id='" + id + "' style='height:700px; overflow:auto;text-align:left;' >" + showData + "</div>" );
								tabs.tabs( "refresh" );
							}
						}
					},
					beforeSend : function(){	//讀取中圖示顯示
						$('#loading-img_loadTemplate').show();
					},
					complete : function(){
						$('#loading-img_loadTemplate').hide();
					}
				});
			}
		});	
	}
}
function getShowData_EditDataShowDiv(msg){
	var showData = "";
	
	showData += "<table>";
	for(var i = 0 ; i<msg.length ; i++){
		var fieldShowName = (msg[i].replace).replace("《","").replace("》","");
		fieldShowName = replaceAll(fieldShowName,"$","");
		showData += "<tr><td style='text-align:right;width:75%;'>";
		showData += fieldShowName + "</td><td>";
		showData += "<input type='button' id='btn_"+msg[i].field+"' replaceTag='"+msg[i].replace+"' value='帶入參數' onClick='replaceTextToAttribute(\"btn_"+msg[i].field+"\")'/>";
		showData += "</td></tr>";
		if(msg[i].type == "date"){
			showData += "<tr><td style='text-align:right;width:75%;'>";
			showData += fieldShowName + "(民國年)</td><td>";
			showData += "<input type='button' id='btn_"+msg[i].field+"_ROC' replaceTag='《$"+fieldShowName+"_ROC$》' value='帶入參數' onClick='replaceTextToAttribute(\"btn_"+msg[i].field+"_ROC\")'/>";
			showData += "</td></tr>";
		}
		else if(msg[i].type == "select"){
			showData += "<tr><td style='text-align:right;width:75%;'>";
			showData += fieldShowName + "(含代碼)</td><td>";
			showData += "<input type='button' id='btn_"+msg[i].field+"_Key' replaceTag='《$"+fieldShowName+"_Key$》' value='帶入參數' onClick='replaceTextToAttribute(\"btn_"+msg[i].field+"_Key\")'/>";
			showData += "</td></tr>";
		}
	}
	showData += "</table>";
	
	return showData;
}
function getShowData_EditDataShowDiv_default(msg, label, divId){
	//clog("label=>" + label + "/divId=>" + divId);
	var showData = "";
	
	//radio
	showData += "<input type='radio' name='radio_getShowData_EditDataShowDiv_default_"+divId+"' value='table' onclick='onclickRadio_getShowData_EditDataShowDiv_default(\"table\", \""+divId+"\")' checked />表格"
		+ "<input type='radio' name='radio_getShowData_EditDataShowDiv_default_"+divId+"' value='list' onclick='onclickRadio_getShowData_EditDataShowDiv_default(\"list\", \""+divId+"\")' />清單"
		+ "<br/><hr/>";
	/*換結構	//下拉選單
	showData += "<select>"
		+ "<option value='table' >表格</option>"
		+ "<option value='list' >清單</option>"
		+ "<option value='string/' >字串以/分隔</option>"
		+ "<option value='string,' >字串以,分隔</option>"
		+ "<option value='string&nbsp;' >字串以「空格」分隔</option>"
		+ "<option value='string、' >字串以、分隔</option>"
		+ "<option value='string，' >字串以，分隔</option>"
		+ "</select>";	*/
	
	//table區塊
	showData += "<div id='tableBlock_"+divId+"' >";
	showData += "<table>";
	for(var i = 0 ; i<msg.length ; i++){
		var fieldShowName = (msg[i].replace).replace("《","").replace("》","");
		fieldShowName = replaceAll(fieldShowName,"$","");
		
		showData += "<tr><td>";
		showData += "<input type='checkbox' value='"+fieldShowName+"' >" + fieldShowName;
		showData += "</td></tr>";
		/*換checkbox
		showData += "<tr><td style='text-align:right;width:75%;'>";
		showData += fieldShowName + "</td><td>";
		showData += "<input type='button' id='btn_"+msg[i].field+"' replaceTag='"+msg[i].replace+"' value='帶入參數' onClick='replaceTextToAttribute(\"btn_"+msg[i].field+"\")'/>";
		showData += "</td></tr>";*/
		
		if(msg[i].type == "date"){
			showData += "<tr><td>";
			showData += "<input type='checkbox' value='"+fieldShowName+"_ROC' >" + fieldShowName + "(民國年)";
			showData += "</td></tr>";
			/*換checkbox
			showData += "<tr><td style='text-align:right;width:75%;'>";
			showData += fieldShowName + "(民國年)</td><td>";
			showData += "<input type='button' id='btn_"+msg[i].field+"_ROC' replaceTag='《$"+fieldShowName+"_ROC$》' value='帶入參數' onClick='replaceTextToAttribute(\"btn_"+msg[i].field+"_ROC\")'/>";
			showData += "</td></tr>";*/
		}
		else if(msg[i].type == "select"){
			showData += "<tr><td>";
			showData += "<input type='checkbox' value='"+fieldShowName+"_Key' >" + fieldShowName + "(含代碼)";
			showData += "</td></tr>";
			/*換checkbox
			showData += "<tr><td style='text-align:right;width:75%;'>";
			showData += fieldShowName + "(含代碼)</td><td>";
			showData += "<input type='button' id='btn_"+msg[i].field+"_Key' replaceTag='《$"+fieldShowName+"_Key$》' value='帶入參數' onClick='replaceTextToAttribute(\"btn_"+msg[i].field+"_Key\")'/>";
			showData += "</td></tr>";*/
		}
	}
	showData += "</table>";
	showData += "<button type='button' onclick='replaceTextToAttribute_default(\""+label+"\",\""+divId+"\")' >帶入參數</button>";	//「帶入參數」按鈕
	showData += "</div>";
	
	//list區塊
	showData += "<div id='listBlock_"+divId+"' style='display:none' >";
	showData += "<button type='button' onclick='replaceTextToAttribute_default(\""+label+"\",\""+divId+"\",\"#START#\")' >插入start</button>";
	showData += "<button type='button' onclick='replaceTextToAttribute_default(\""+label+"\",\""+divId+"\",\"#END#\")' >插入end</button><br/><br/>";
	showData += "<button type='button' onclick='replaceTextToAttribute_default(\""+label+"\",\""+divId+"\",\"#編號#\")' >插入「編號」變數</button><br/><br/>";
	showData += "<button type='button' onclick='replaceTextToAttribute_default(\""+label+"\",\""+divId+"\",\"#換行#\")' >插入「換行」變數</button><br/><br/>";
	for(var i = 0 ; i<msg.length ; i++){
		var fieldShowName = (msg[i].replace).replace("《","").replace("》","");
		fieldShowName = replaceAll(fieldShowName,"$","");
		
		showData += "<button type='button' onclick='replaceTextToAttribute_default(\""+label+"\",\""+divId+"\",\""+fieldShowName+"\")' >" + fieldShowName + "</button>";
		if(msg[i].type == "date"){
			showData += "<button type='button' onclick='replaceTextToAttribute_default(\""+label+"\",\""+divId+"\",\""+fieldShowName+"_ROC\")' >" + fieldShowName+"_ROC</button>";
		}else if(msg[i].type == "select"){
			showData += "<button type='button' onclick='replaceTextToAttribute_default(\""+label+"\",\""+divId+"\",\""+fieldShowName+"_Key\")' >" + fieldShowName+"_Key</button>";
		}
		showData += "<br/>";
	}
	
	showData += "</div>";
	
	return showData;
}

function onclickRadio_getShowData_EditDataShowDiv_default(value, divId){
	clog("DO onclickRadio_getShowData_EditDataShowDiv_default! =>" + value + "/divId=>" + divId);
	clog(value + "Block_" + divId);
	
	//先全部隱藏
	$("#tableBlock_" + divId).hide();
	$("#listBlock_" + divId).hide();
	
	$("#" + value + "Block_" + divId).show();	//顯示點選的類型
}

function cleanTab(){
	$('#tabs li').each(function(i){
		//clog($(this));
		//clog($(this)[0].innerText);
		
		if($(this)[0].innerText != "主表"){
			$(this).remove();	//移除tab
			
			//移除對應的div
			//clog($(this).children('a'));
			//clog($(this).children('a').attr("href"));
			var hrefDivId = $(this).children('a').attr("href");
			//clog("hrefDivId=>" + hrefDivId);
			$("#tabs > "+hrefDivId).remove();
			
			$( "#tabs" ).tabs( "refresh" );
		}
	});
}

function changeReportEditTemplate(){
	$('#loading-img_loadTemplate').show();
	$("#templateType").val("Editor");
	$("#KeyValueList").val("");
	changeBtnArea();
	
	if($("#FunctionList").val() != null && $("#FunctionList").val().length > 0){
		if($("#ReportList").val() != null && $("#ReportList").val().length > 0){
			$.ajax({
				url:"ReportTemplateServlet",
				//async:false,	//非同步執行
				//data: $('#displayMethod').serialize(),
				data: {'method': 'ReportSettingData','functionName':'','reportName':$("#ReportList").val(),'key':''},
				type:"POST",
				dataType:'json',
				success:function(msg){
					
					if(msg.length > 0){
						//換CKEditor	tinymce.get("TemplateEditor").setContent(msg[0]);
						setReportContent(msg[0]);
					}	
				}
			});	
		}	
	}
	
	loadEditDataShowDiv();
	
	$('#loading-img_loadTemplate').hide();
}

function replaceTextToAttribute(id){
	clog("DO replaceTextToAttribute");
	var tagName = $("#"+id).attr("replaceTag");

	//換CKEditor	tinymce.execCommand('mceReplaceContent', false, tagName);
	CKEDITOR.instances.ckeditor.insertHtml( tagName ) ;	//在游標處插入內容
};
function replaceTextToAttribute_default(label, divId, value){
	clog("DO replaceTextToAttribute_default");
	
	//換radio	var type = $("#"+divId+" select").val();	//取得(下拉選單)多值類型
	var type = $('input:radio:checked[name="radio_getShowData_EditDataShowDiv_default_'+divId+'"]').val();
	clog(type);
	
	var concatenationFiled = "";
	if(value != undefined){
		concatenationFiled = value;
	}else{
		//取得(多選)欄位
		$("#"+divId+" input:checkbox:checked").each(function(i) {
			//clog(i);
			if(i > 0){
				concatenationFiled += "§";
			}
			concatenationFiled += this.value; 
		});
		if(concatenationFiled == ""){
			alert("請至少勾選一欄位");
			return;
		}
	}
	
	var tagName = "《$MultiValue_" + type + "_" + label + "_" + concatenationFiled + "$》";
	
	CKEDITOR.instances.ckeditor.insertHtml( tagName ) ;	//在游標處插入內容
}

function getSaveReport(){
	clog("DO getSaveReport");
	
	if($("#FunctionList").val() != null && $("#FunctionList").val().length > 0){
		if($("#ReportList").val() != null && $("#ReportList").val().length > 0){
			var reportContent = getReportContent();
			
			checkListSE(reportContent);	//list[start/end]檢查
			
			$.ajax({
				url:"ReportTemplateServlet",
				//async:false,	//非同步執行
				//data: $('#displayMethod').serialize(),
				//換CKEditor	data: {'method': 'SaveReport','functionName':'','reportName':'','key':$("#ReportList").val(),'reportContent':tinymce.get("TemplateEditor").getContent()},
				data: {'method': 'SaveReport','functionName':'','reportName':'','key':$("#ReportList").val(),'reportContent':reportContent},
				type:"POST",
				dataType:'json',
				success:function(msg){
					if(msg[0]){
						alert('報表底稿儲存成功!');
					}else{
						alert('報表底稿儲存失敗!');
					}
				},
				beforeSend : function(){	//讀取中圖示顯示
					$('#loading-img_loadTemplate').show();
				},
				complete : function(){
					$('#loading-img_loadTemplate').hide();
				}
				
			});	
		}else{
			alert('請選擇"報表名稱"');
		}	
	}else{
		alert('請選擇"功能名稱"');
	}	
}

function checkListSE(text){
	clog("DO checkListSE!");
	
	var patterned = text;
	while(new RegExp("《\\DMultiValue_list_[^》\\d]+_#START#\\D》", "g").test(patterned)){
		clog("patterned=>" + patterned);
		
		var labelName = new RegExp("《\\DMultiValue_list_[^》\\d]+_#START#\\D》", "g").exec(patterned)[0].replace("《$MultiValue_list_", "").replace('_#START#$》', "");
		if(new RegExp("《\\DMultiValue_list_"+labelName+"_#END#\\D》", "g").test(text)){
			var indexStart = new RegExp("《\\DMultiValue_list_"+labelName+"_#START#\\D》", "g").exec(patterned).index;
			var indexEnd = new RegExp("《\\DMultiValue_list_"+labelName+"_#END#\\D》", "g").exec(patterned).index;
			
			//end在start前...
			if(indexEnd <= indexStart){
				alert("檢測「END」在「START」前，請查看「" + new RegExp("《\\DMultiValue_list_"+labelName+"_#START#\\D》", "g").exec(patterned)[0]
					+ "/" + new RegExp("《\\DMultiValue_list_"+labelName+"_#END#\\D》", "g").exec(patterned)[0] + "」。");
				return;
			}
			
			if(new RegExp("《\\DMultiValue_list_[^》\\d]+_[^》\\d]+\\D》", "g").test(patterned.substring(0, indexStart))){
				alert("檢測有list標籤在[START/END]區塊之外，請查看「"+new RegExp("《\\DMultiValue_list_[^》\\d]+_[^》\\d]+\\D》", "g").exec(patterned.substring(0, indexStart))[0]+"」");
				return;
			}
			
			clog(indexStart+("《$MultiValue_list_"+labelName+"_#START#$》").length);
			var textBettewnSE = patterned.substring(indexStart+("《$MultiValue_list_"+labelName+"_#START#$》").length, indexEnd);	//取得start到end中間的文字段
			clog("textBettewnSE=>" + textBettewnSE);
			
			if(new RegExp("《\\DMultiValue_list_[^》\\d]+_#START#\\D》", "g").test(textBettewnSE)){	//不能出現「任何lebal.start」
				alert("檢測「多組START對應一個END」，請檢查《$MultiValue_list_"+labelName+"_#START#$》。");
				return;
			}else{
				//不能出現「其他lebal元素」(一組start/end中，不該出現其他附表內容)
				while(new RegExp("《\\DMultiValue_list_[^》\\d]+_[^》\\d]+\\D》", "g").test(textBettewnSE)){
					var getTegBettewnSE = new RegExp("《\\DMultiValue_list_[^》\\d]+_[^》\\d]+\\D》", "g").exec(textBettewnSE)[0];
					clog("getTegBettewnSE=>" + getTegBettewnSE);
					if(!new RegExp("《\\DMultiValue_list_"+labelName+"_[^》\\d]+\\D》", "g").test(getTegBettewnSE)){
						alert("檢測「" + labelName + "」的START/END範圍內存在其他附表區塊標籤" + getTegBettewnSE + "，此標籤將無法正確取代。");
						return;
					}else{
						textBettewnSE = textBettewnSE.substring(textBettewnSE.indexOf(getTegBettewnSE) + getTegBettewnSE.length);
					}
				}
				
				patterned = patterned.substring(indexEnd+("《$MultiValue_list_"+labelName+"_#END#$》").length);
			}
		}else{
			alert("檢測缺少「END」，請由" + labelName + "附表區塊加入。");
			return;
		}
	}
	
	if(new RegExp("《\\DMultiValue_list_[^》\\d]+_[^》\\d]+\\D》", "g").test(patterned)){
		alert("檢測有list標籤在[START/END]區塊之外，請查看「"+new RegExp("《\\DMultiValue_list_[^》\\d]+_[^》\\d]+\\D》", "g").exec(patterned)[0]+"」");
	}
	
	clog("END===checkListSE!");
}

function getInsertReport(){
	clog("DO getInsertReport");
	
	if($("#FunctionList").val() != null && $("#FunctionList").val().length > 0){
		if($("#insertReportName").val() != null && $("#insertReportName").val().length > 0){
			console.log($("input[type='radio'][name='reportType']:checked").val());
			if($("input[type='radio'][name='reportType']:checked").val() != null && $("input[type='radio'][name='reportType']:checked").val().length > 0){
				$.ajax({
					url:"ReportTemplateServlet",
					//async:false,	//非同步執行
					//data: $('#displayMethod').serialize(),
					//換CKEditor	data: {'method': 'insertReport','functionName':$("#FunctionList").val(),'reportName':$("#insertReportName").val(),'reportType':$("input[type='radio'][name='reportType']:checked").val(),'reportContent':tinymce.get("TemplateEditor").getContent()},
					data: {'method': 'insertReport','functionName':$("#FunctionList").val(),'reportName':$("#insertReportName").val(),'reportType':$("input[type='radio'][name='reportType']:checked").val(),'reportContent':getReportContent()},
					type:"POST",
					dataType:'json',
					success:function(msg){
						if(msg[0]){
							alert('報表底稿新增成功!');
						}else{
							alert('報表底稿新增失敗!');
						}
					},
					beforeSend : function(){	//讀取中圖示顯示
						$('#loading-img_loadTemplate').show();
					},
					complete : function(){
						$('#loading-img_loadTemplate').hide();
						
						clearReportAndKey();
						clearReportContent();
						getReportList();
						changeEditorModeBtn();
					}
				});	
			}else{
				alert('請選擇"報表類型"');
			}
		}else{
			alert('請輸入"報表名稱"');
		}	
	}else{
		alert('請選擇"功能名稱"');
	}	
}

function changeReportPreviewTemplate(){
	$('#loading-img_loadTemplate').show();
	$("#templateType").val("Preview");
	$("#valueFieldKeyValueList").val("");
	$("#KeyValueList").val("");
	
	changeBtnArea();
	clearReportContent();
	
	$('#editorType').val("Update");
	$('#EditorBasicBtn').show();
	$('#EditorInsertBtn').hide();
	$('#ReportListDiv').show();
	$("#insertReportName").val("");
	$("input[type='radio'][name='reportType']:checked").prop('checked', false);
	
	getDataFieldsList();
	
	$('#loading-img_loadTemplate').hide();
}

function savePersonalReport(){
	var personalReport = $( '#ckeditor' ).val();
	//clog(personalReport);
	
	if($("#FunctionList").val() != null && $("#FunctionList").val().length > 0){
		if($("#ReportList").val() != null && $("#ReportList").val().length > 0){
			if($("#KeyValueList").val() != null && $("#KeyValueList").val().length > 0){
				$.ajax({
					url:"ReportTemplateServlet",
					//async:false,	//非同步執行
					//data: $('#displayMethod').serialize(),
					//data: {'method': 'SavePersonalReport','functionName':$("#FunctionList").val(),'reportName':$("#ReportList").val(),'key':$("#KeyValueList").val(),'reportContent':tinymce.get("TemplateEditor").getContent()},
					data: {'method': 'SavePersonalReport','functionName':$("#FunctionList").val(),'reportName':$("#ReportList").val(),'key':$("#KeyValueList").val(),'reportContent':personalReport},
					type:"POST",
					dataType:'json',
					success:function(msg){
						if(msg[0]){
							alert('報表儲存成功!');
						}else{
							alert('報表儲存失敗!');
						}
					},
					beforeSend : function(){	//讀取中圖示顯示
						$('#loading-img_loadTemplate').show();
					},
					complete : function(){
						$('#loading-img_loadTemplate').hide();
					}
					
				});	
			}else{
				alert('請選擇"案件編號"');
			}
		}else{
			alert('請選擇"報表名稱"');
		}	
	}else{
		alert('請選擇"功能名稱"');
	}	
}

//載入
function loadReportPersonalData(){
	if($("#FunctionList").val() != null && $("#FunctionList").val().length > 0){
		if($("#ReportList").val() != null && $("#ReportList").val().length > 0){
			if($("#KeyValueList").val() != null && $("#KeyValueList").val().length > 0){
				$.ajax({
					url:"ReportTemplateServlet",
					//async:false,	//非同步執行
					//data: $('#displayMethod').serialize(),
					data: {'method': 'ReportPersonalData','functionName':$("#FunctionList").val(),'reportName':$("#ReportList").val(),'key':$("#KeyValueList").val(),'reportContent':''},
					type:"POST",
					dataType:'json',
					success:function(msg){
						//clog(msg);
						
						//換CKEditor	tinymce.get("TemplateEditor").setContent("");
						//會蓋掉下面的寫入值...	setReportContent("");
						
						if(msg.length > 0){
							if(msg[0]=="data error"){
								alert("讀取錯誤!!");
							}else{
								//換CKEditor	tinymce.get("TemplateEditor").setContent(msg[0]);
								setReportContent(msg[0]);
							}	
						}	
					},
					beforeSend : function(){	//讀取中圖示顯示
						$('#loading-img_loadTemplate').show();
					},
					complete : function(){
						$('#loading-img_loadTemplate').hide();
					}
					
				});	
			}else{
				alert('請選擇"案件編號"');
			}
		}else{
			alert('請選擇"報表名稱"');
		}	
	}else{
		alert('請選擇"功能名稱"');
	}	
}

function getURLParameter(sParam)
{
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) 
    {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) 
        {
            return sParameterName[1];
        }
    }
}

//按鈕「產生內容」第二步
function setHiddenMultiContent(){
	clog("DO setHiddenMultiContent");
	
	//clog($("#reportNum").val());
	if($("#reportNum").val() == "Multi"){
		var key = $("#KeyValueList").val();
//		alert(key);
		if(key.length>0){
			var hiddenkey = "HiddenKey_"+key;
			
			//換CKEditor	$("input[id='"+hiddenkey+"']").attr("value",tinymce.get("TemplateEditor").getContent());
			$("input[id='"+hiddenkey+"']").attr("value", getReportContent());
		}	
	}
}

function setMultiContent(){
	clog("DO setMultiContent");
	
	if($("#reportNum").val() == "Multi"){
		var key = $("#KeyValueList").val();
		if(key.length>0){
			var hiddenkey = "HiddenKey_"+key;
//			alert($("input[id='"+hiddenkey+"']").attr("value"));
			//換CKEditor	tinymce.get("TemplateEditor").setContent($("input[id='"+hiddenkey+"']").attr("value"));
			setReportContent($("input[id='"+hiddenkey+"']").attr("value"));
		}	
	}
}
function clearHiddenMultiContent(){
	if($("#reportNum").val() == "Multi"){
		//換CKEditor	tinymce.get("TemplateEditor").setContent("");
		setReportContent("");
		
		var hiddenFields = $("input[id^='HiddenKey_']");
		for(var i = 0 ; i < hiddenFields.length ; i++){
			$("input[id='"+hiddenFields[i].id+"']").attr("value","");
			
		}
	}
}


function makeAllReportDataPdf(){
	var reportContext = "";
	$('#loading-img_loadTemplate').show();
	$('#makePdfBtn').prop('disabled', true);
	if($("#FunctionList").val() != null && $("#FunctionList").val().length > 0){
		if($("#ReportList").val() != null && $("#ReportList").val().length > 0){
			var keys = "";
			
			if(getURLParameter("keys") != null && getURLParameter("keys") != undefined){
				keys = getURLParameter("keys");
			}	
			
			var fields = $("input[id^='HiddenKey_']");
			var jsonData = [];
			var keyStr = "key";
			var valueStr = "content";
			for(var i = 0 ; i <fields.length; i++ ){
				var jsonObj = {};

				var id = fields[i].id;
				id = id.substring(10);
				jsonObj[keyStr] = id; 
				
				var content = fields[i].value;
				jsonObj[valueStr] = content;
				
				jsonData[i] = jsonObj;
			}
			
			var jsonDataStr = JSON.stringify(jsonData);
//			alert(jsonData);
			$.ajax({
				url:"ReportTemplateServlet",
				//async:false,	//非同步執行
				//data: $('#displayMethod').serialize(),
				data: {'method': 'makeAllCaseReportDataPdf','functionName':$("#FunctionList").val(),'reportName':$("#ReportList").val(),'reportContent':jsonDataStr},
				type:"POST",
				dataType:'json',
				success:function(msg){
//					alert(msg.path);
					if(msg.path=="error"){
						alert("套印PDF檔失敗");
					}else{
						var hiddenIFrameID = 'hiddenDownloader',
						iframe = document.getElementById(hiddenIFrameID);
						if (iframe === null) {
							iframe = document.createElement('iframe');
							iframe.id = hiddenIFrameID;
							iframe.style.display = 'none';
							document.body.appendChild(iframe);
						}
						iframe.src = msg.path;
						
						alert("套印PDF檔完成");
					}	
//					window.open(msg.path,'Pdf','scrollbars=yes,resizable');
				}
				
			});	
			
		}else{
			alert('請選擇"報表名稱"');
		}
	}else{
		alert('請選擇"功能名稱"');
	}
	$('#makePdfBtn').prop('disabled', false);
	$('#loading-img_loadTemplate').hide();
	
}

function checkInput(){
	var fields = $("input[id^='input_']");
	alert(fields.length);
	for(var i = 0 ; i <fields.length; i++ ){
		//alert(fields[i].id+"-"+fields[i].value+"-"+$("#"+fields[i].id).attr("replace"));
		alert(fields[i].id+"-"+fields[i].value+"-"+fields[i].replaceTag);
		if(i==5){
			break;
		}
	}	
	
}

function clog(o){
	console.log(o);
}

/*換CKEditor
tinymce.init({
	language:"zh_TW",
	menubar: false,
	resize: true,
	selector: "textarea#TemplateEditor",
	forced_root_block : false,
    force_br_newlines : true,
    force_p_newlines : false,
	plugins: [
		"advlist autolink link image lists charmap print preview hr anchor pagebreak spellchecker",
		"searchreplace visualblocks visualchars code fullscreen insertdatetime media nonbreaking",
		"table contextmenu directionality emoticons template textcolor paste fullpage textcolor"
  	],
  	toolbar1: "undo redo print preview | cut copy paste | searchreplace | forecolor backcolor | bold italic underline strikethrough | subscript superscript | pagebreak ",
	toolbar2: "alignleft aligncenter alignright alignjustify | bullist numlist | outdent indent blockquote | hr removeformat | charmap code | ltr rtl | visualchars visualblocks ",
	toolbar3: "link unlink image | styleselect fontselect fontsizeselect | table ",
	font_formats: 
		"新細明體=新細明體,times;"+
		"標楷體=標楷體,times;"+
		"Andale Mono=andale mono,times;"+
        "Arial=arial,helvetica,sans-serif;"+
        "Arial Black=arial black,avant garde;"+
        "Book Antiqua=book antiqua,palatino;"+
        "Comic Sans MS=comic sans ms,sans-serif;"+
        "Courier New=courier new,courier;"+
        "Georgia=georgia,palatino;"+
        "Helvetica=helvetica;"+
        "Impact=impact,chicago;"+
        "Symbol=symbol;"+
        "Tahoma=tahoma,arial,helvetica,sans-serif;"+
        "Terminal=terminal,monaco;"+
        "Times New Roman=times new roman,times;"+
        "Trebuchet MS=trebuchet ms,geneva;"+
        "Verdana=verdana,geneva;"+
        "Webdings=webdings;"+
        "Wingdings=wingdings,zapf dingbats",
    setup: function(editor) {
		editor.on('blur', function(e) {
			setHiddenMultiContent();
		});
	}
});*/