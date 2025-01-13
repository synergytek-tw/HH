package deepspot.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Vector;

import com.deepspot.pdf.PdfGenerator;

import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.MasterBean;
import deepspot.basic.PdfCnstnts;
import deepspot.html.HiddenTag;
import deepspot.html.Html;
import deepspot.util.Util;

public class Quotation extends MasterBean {

    public Quotation(){this.init();}

    public Quotation(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
        this.getAttribute();
    }

    public Field CreateTime;
    public void setCreateTime(String CreateTime){this.CreateTime.setValue(CreateTime);}
    public String getCreateTime(){return this.CreateTime.getValue();}

    public Field EffectDate;
    public void setEffectDate(String EffectDate){this.EffectDate.setValue(EffectDate);}
    public String getEffectDate(){return this.EffectDate.getValue();}

    public Field CustomerNo;
    public void setCustomerNo(String CustomerNo){this.CustomerNo.setValue(CustomerNo);}
    public String getCustomerNo(){return this.CustomerNo.getValue();}

    public Field CustomerName;
    public void setCustomerName(String CustomerName){this.CustomerName.setValue(CustomerName);}
    public String getCustomerName(){return this.CustomerName.getValue();}

    public Field Address;
    public void setAddress(String Address){this.Address.setValue(Address);}
    public String getAddress(){return this.Address.getValue();}

    public Field Contact;
    public void setContact(String Contact){this.Contact.setValue(Contact);}
    public String getContact(){return this.Contact.getValue();}

    public Field Tel;
    public void setTel(String Tel){this.Tel.setValue(Tel);}
    public String getTel(){return this.Tel.getValue();}

    public Field Fax;
    public void setFax(String Fax){this.Fax.setValue(Fax);}
    public String getFax(){return this.Fax.getValue();}

    public Field Email;
    public void setEmail(String Email){this.Email.setValue(Email);}
    public String getEmail(){return this.Email.getValue();}

    public Field Amount;
    public void setAmount(String Amount){this.Amount.setValue(Amount);}
    public String getAmount(){return this.Amount.getValue();}

    public Field Discount;
    public void setDiscount(String Discount){this.Discount.setValue(Discount);}
    public String getDiscount(){return this.Discount.getValue();}

    public Field TaxFlag;
    public void setTaxFlag(String TaxFlag){this.TaxFlag.setValue(TaxFlag);}
    public String getTaxFlag(){return this.TaxFlag.getValue();}

    public Field TaxAmount;
    public void setTaxAmount(String TaxAmount){this.TaxAmount.setValue(TaxAmount);}
    public String getTaxAmount(){return this.TaxAmount.getValue();}

    public Field TotalAmount;
    public void setTotalAmount(String TotalAmount){this.TotalAmount.setValue(TotalAmount);}
    public String getTotalAmount(){return this.TotalAmount.getValue();}

    public Field Memo;
    public void setMemo(String Memo){this.Memo.setValue(Memo);}
    public String getMemo(){return this.Memo.getValue();}

    public Field Sale;
    public void setSale(String Sale){this.Sale.setValue(Sale);}
    public String getSale(){return this.Sale.getValue();}
    
    public String CustomerFlag = Cnstnts.EMPTY_STRING;
    public void setCustomerFlag(String CustomerFlag){this.CustomerFlag=CustomerFlag;}
    public String getCustomerFlag(){return this.CustomerFlag;}

    public Quotation_detail myDetail;
    public void setMyDetail(Quotation_detail myDetail){
        this.myDetail = myDetail;
    }
    public Quotation_detail getMyDetail(){return this.myDetail;}

    public void init() {
        super.init();
        this.setProgramId("jsp.Quotation");
        this.setTableName("Quotation");

        this.CreateTime = new Field("CreateTime", this.getTableName());

        this.EffectDate = new Field("EffectDate", this.getTableName());
        this.EffectDate.setCheckEmpty(true);

        this.CustomerNo = new Field("CustomerNo", this.getTableName());

        this.CustomerName = new Field("CustomerName", this.getTableName());
        this.CustomerName.setCheckEmpty(true);
        this.CustomerName.setSearchCondition(Cnstnts.LIKE);

        this.Address = new Field("Address", this.getTableName());

        this.Contact = new Field("Contact", this.getTableName());

        this.Tel = new Field("Tel", this.getTableName());

        this.Fax = new Field("Fax", this.getTableName());

        this.Email = new Field("Email", this.getTableName());

        this.Amount = new Field("Amount", this.getTableName());

        this.Discount = new Field("Discount", this.getTableName());

        this.TaxFlag = new Field("TaxFlag", this.getTableName());

        this.TaxAmount = new Field("TaxAmount", this.getTableName());

        this.TotalAmount = new Field("TotalAmount", this.getTableName());

        this.Memo = new Field("Memo", this.getTableName());

        this.Sale = new Field("Sale", this.getTableName());

        this.setPageRecords(Cnstnts.DEFAULT_PAGE_RECORDS);

        this.setSearchListPrpts();

        this.myDetail = new Quotation_detail();
        this.setDetails(new ArrayList<List<Field>>());
    }

    public void setDbFields() {
        super.setDbFields();
        this.CreateTime.setDbType("varchar(20)");
        this.DbFields.add(this.CreateTime);

        this.EffectDate.setDbType("varchar(10)");
        this.DbFields.add(this.EffectDate);

        this.CustomerNo.setDbType("varchar(50)");
        this.DbFields.add(this.CustomerNo);

        this.CustomerName.setDbType("nvarchar(100)");
        this.DbFields.add(this.CustomerName);

        this.Address.setDbType("nvarchar(200)");
        this.DbFields.add(this.Address);

        this.Contact.setDbType("nvarchar(50)");
        this.DbFields.add(this.Contact);

        this.Tel.setDbType("varchar(50)");
        this.DbFields.add(this.Tel);

        this.Fax.setDbType("varchar(50)");
        this.DbFields.add(this.Fax);

        this.Email.setDbType("varchar(50)");
        this.DbFields.add(this.Email);

        this.Amount.setDbType("int");
        this.DbFields.add(this.Amount);

        this.Discount.setDbType("int");
        this.DbFields.add(this.Discount);

        this.TaxFlag.setDbType("char(1)");
        this.DbFields.add(this.TaxFlag);

        this.TaxAmount.setDbType("int");
        this.DbFields.add(this.TaxAmount);

        this.TotalAmount.setDbType("int");
        this.DbFields.add(this.TotalAmount);

        this.Memo.setDbType("nvarchar(500)");
        this.DbFields.add(this.Memo);

        this.Sale.setDbType("varchar(50)");
        this.DbFields.add(this.Sale);

    }
    
    public String printHiddenTags(){
    	String rtnString = super.printHiddenTags();
  	  	HashMap<String,String> hm = new HashMap<String,String>();
  	  	hm.put("customerFlag",Cnstnts.EMPTY_STRING);
  	  	rtnString += new HiddenTag().print(hm);
  	  	return rtnString;
    }

    public String printSearchTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onSearchMode()) {
            this.CustomerName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            rtnString += this.printHtml(this.CustomerName);

        }
        return rtnString;
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
        if (this.onMaintainMode()) {
            this.EffectDate.setHtmlType(Cnstnts.HTML_TAG_OPEN_CALENDAR);

            this.CustomerNo.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.CustomerNo.setSelectList(new Customer().getList());
            this.CustomerNo.setOnChange("document.input.customerFlag.value=\"true\";setValue()");
            this.CustomerNo.setAnotherField(this.EffectDate);
            rtnString += this.printHtml(this.CustomerNo);
            
            if(Cnstnts.TRUE_FLAG.equals(this.CustomerFlag)){
            	Customer customer = new Customer(this.CustomerNo.getValue());
            	this.CustomerName.setValue(customer.getNames());
            	this.Address.setValue(customer.getAddress());
            	this.Email.setValue(customer.getEmail());
            	this.Contact.setValue(customer.getContact());
            	this.Fax.setValue(customer.getFax());
            	this.Tel.setValue(customer.getTelNo());
            }

            this.CustomerName.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.CustomerName.setSize(60);
            rtnString += this.printHtml(this.CustomerName);

            this.Address.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Address.setSize(60);
            rtnString += this.printHtml(this.Address);
            
            this.Email.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Email.setSize(36);
            
            this.Contact.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Contact.setAnotherField(this.Email);
            this.Contact.setSize(10);
            rtnString += this.printHtml(this.Contact);
            
            this.Fax.setHtmlType(Cnstnts.HTML_TAG_TEXT);

            this.Tel.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Tel.setAnotherField(this.Fax);
            rtnString += this.printHtml(this.Tel);
            
            this.Discount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Discount.setSize(10);

            this.Amount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Amount.setReadonly(true);
            this.Amount.setSize(10);
            this.Amount.setAnotherField(this.Discount);
            rtnString += this.printHtml(this.Amount);
            
            this.TaxAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TaxAmount.setSize(10);
            this.TaxAmount.setReadonly(true);
            
            this.TaxFlag.setHtmlType(Cnstnts.HTML_TAG_CHECKBOX);
            this.TaxFlag.setOnClick("setValue()");
            if(this.TaxFlag.getValue().equals("Y")){
            	this.TaxFlag.setAnotherField(this.TaxAmount);
            } else {
            	rtnString += this.TaxAmount.printHiddenTag();
            }
            rtnString += this.printHtml(this.TaxFlag);
            
            this.Sale.setHtmlType(Cnstnts.HTML_TAG_SELECT_ONE);
            this.Sale.setSelectList(new Employee().getGroupList(this.Sale.getName()));
            
            this.TotalAmount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.TotalAmount.setReadonly(true);
            this.TotalAmount.setSize(10);
            this.TotalAmount.setOnClick("setValue()");
            this.TotalAmount.setAnotherField(this.Sale);
            rtnString += this.printHtml(this.TotalAmount);
            
            this.Memo.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.Memo.setCols(60);
            this.Memo.setRows(5);
            rtnString += this.printHtml(this.Memo);

            rtnString += this.CreateTime.printHiddenTag();

            if(this.myDetail!=null){
                rtnString += this.printDetailTable();
            }
        }
        return rtnString;
    }

    public void setSearchListPrpts() {
        this.FlowKey.setListWidth("10%");

        this.CustomerName.setListWidth("20%");

        this.Contact.setListWidth("10%");

        this.Tel.setListWidth("10%");

        this.TotalAmount.setListWidth("10%");
        this.TotalAmount.setAlign(Cnstnts.RIGHT);

        this.Memo.setListWidth("40%");

        Field[] showField = {this.FlowKey, this.CustomerName, this.Contact, this.Tel, this.Memo, this.TotalAmount};
        this.setShowField(showField);
        this.setPageRecords(new Program(this.getProgramId()).getPageRecords());
    }

    public List<Object[]> getSearchList() throws Exception {
        String whereStr = Cnstnts.EMPTY_STRING;
        whereStr = Util.addWhereSQL(whereStr, this.CustomerName);
        return this.doSearch(whereStr);
    }

    public Properties getNamesPrpts() throws Exception {
        return super.getNamesPrpts(this.CustomerName);
    }

    public void setPreObj(UserBean userInfo){
        if (userInfo.getObj(this.getTableName()) != null) {
            Quotation preObj = (Quotation) userInfo.getObj(this.getTableName());
            if(this.onBtnDeleteDetail()
                    && this.getDeleteItems()!=null
            				   && this.getDeleteItems().length>0){
                for(int i=0;i<this.getDeleteItems().length;i++){
                    int seqNo = Integer.parseInt(this.getDeleteItems()[i]);
                    preObj.getDetails().remove(seqNo-i);
                }
            }
            this.setSearchResult(preObj.getSearchResult());
            if (!this.getDataFromDB()) {
                this.setDetails(preObj.getDetails());
            }
        }
    }

    public boolean checkInsertError() throws Exception {
        if(super.checkInsertError()){
            return true;
        } else {
            return false;
        }
    }

    public boolean checkUpdateError() throws Exception {
        return this.checkInsertError();
    }

    @SuppressWarnings("unchecked")
    private String printDetailTable() throws Exception {
        char newLine = Cnstnts.NEW_LINE;
        String rtnString = newLine+"</table>";
        int iframeWidth = 130;
        rtnString+=newLine+Html.getJavaScriptFunction(this.getTableName(),iframeWidth);
        rtnString+=newLine+"<table"+Cnstnts.DEFAULT_TABLE_BGCOLOR+">";
        rtnString+=newLine+"  <tr><td colspan='"+this.myDetail.getDbFields().size()+"'>"+this.myDetail.getPageTitle()+"</td></tr>";
        if(this.canEdit()){
            rtnString += newLine+"  <tr><td colspan='"+this.myDetail.getDbFields().size()+"' align='center'>"+"<div id='showDetail'></div></td></tr>";
        }
        rtnString+=newLine+"  <tr"+Cnstnts.DEFAULT_TH_BGCOLOR+">";
        rtnString+=newLine+"    <td width='3%' align='center'>"+this.getInsertImg()+"</td>";
        List<Field> detailFieldLst = this.myDetail.getDbFields();
        for(Iterator itr=detailFieldLst.iterator();itr.hasNext();){
            Field detailField = (Field)itr.next();
            if(detailField!=null && !"FlowKey".equals(detailField.getName()) && !"Seq_no".equals(detailField.getName())){
                rtnString += newLine+"    <td align='center'"+detailField.printListWidth()+">"+this.myDetail.getAlias(detailField)+"</td>";
            }
        }
        rtnString+=newLine+"    <td width='3%' align='center'>"+this.getDeleteImg()+"</td>";
        rtnString+=newLine+"  </tr>";
        if(this.getDetails()!=null && this.getDetails().size()>0){
            int i=0;
            boolean showSubTotal = false;
            for(Iterator detailItr=this.getDetails().iterator();detailItr.hasNext();i++){
                List<Field> fields = (List<Field>)detailItr.next();
                String trBgcolor = Cnstnts.DEFAULT_TR_BGCOLOR_1;
                if(i%2==0) trBgcolor = Cnstnts.DEFAULT_TR_BGCOLOR_2;
                rtnString += newLine+"  <tr"+trBgcolor+">";
                rtnString += newLine+"    <td align='center'>"+this.getEditImg(i)+"</td>";
                int j=0;
                for(Iterator fieldsItr=fields.iterator();fieldsItr.hasNext();j++){
                    Field detailField = (Field)fieldsItr.next();
                    String showName = detailField.getValue();
                    if(detailFieldLst.get(j).getMapingPrpt()!=null 
                    	       && detailFieldLst.get(j).getMapingPrpt().getProperty(showName)!=null){
                        if(detailFieldLst.get(j).notShowCode()){
                            showName = detailFieldLst.get(j).getMapingPrpt().getProperty(showName);
                        } else {
                            showName += "-"+detailFieldLst.get(j).getMapingPrpt().getProperty(showName);
                        }
                    }
                    if(detailFieldLst.get(j).getDbType().equals(Cnstnts.DB_TYPE_INT)
                    			&& detailFieldLst.get(j).subTotalFlag()){
                    	   detailFieldLst.get(j).setSubtotal(detailFieldLst.get(j).getSubTotal()+
                                 Integer.parseInt(showName));
                        showSubTotal = true;
                        showName = Util.outFormat(Integer.parseInt(showName), 3);
                    }
                    if(detailField!=null && !"FlowKey".equals(detailField.getName()) && !"Seq_no".equals(detailField.getName())){
                        rtnString += newLine+"    <td"+detailFieldLst.get(j).printAlign()+">"+showName+"</td>";
                    }
                }
                rtnString += newLine+"    <td align='center'>"+this.getDeleteCheckbox(i)+"</td>";
                rtnString += newLine+"  </tr>";
            }
            if(showSubTotal){
            	   String printValue = Cnstnts.EMPTY_STRING;
                for(Iterator itr=detailFieldLst.iterator();itr.hasNext();){
                    Field detailField = (Field)itr.next();
                    if(detailField!=null && !"FlowKey".equals(detailField.getName()) 
                            && !"Seq_no".equals(detailField.getName())){
                        if(detailField.subTotalFlag()){
                            printValue += "<td align='right'>"+Util.outFormat(detailField.getSubTotal(), 3)+"</td>";
                        } else {
                            printValue += "<td></td>";
                        }
                    }
                }
                rtnString +=  newLine+"  <tr><td></td>"+printValue+"<td></td></tr>";
            }
        }
        return rtnString;
    }

    @SuppressWarnings("unchecked")
	public void doAction(UserBean userInfo) throws Exception{
        if(this.myDetail!=null){
            this.myDetail.setUserInfo(userInfo);
            if (this.getDataFromDB()) {
                this.setDetails(this.myDetail.getDetails(this.FlowKey.getValue()));
            }
        }
        super.doAction(userInfo);
        int amount = 0;
        for(Iterator itr=this.getDetails().iterator();itr.hasNext();){
        	List<Field> detailFieldsLst = (List<Field>)itr.next();
        	for(Iterator fieldsItr=detailFieldsLst.iterator(); fieldsItr.hasNext();){
        		Field field = (Field)fieldsItr.next();
        		if(field.getName().equals("Amount")){
        			amount += Integer.parseInt(field.getValue());
        		}
        	}
        }
        this.Amount.setValue(amount+Cnstnts.EMPTY_STRING);
        int discount = 0;
        if(this.Discount.getValue().trim().length()>0){
        	discount = Integer.parseInt(this.Discount.getValue());
        }
        this.Discount.setValue(discount+Cnstnts.EMPTY_STRING);
        int taxAmount = 0;
        if(this.TaxFlag.getValue().equals("Y")){
        	taxAmount = (int) Math.round((amount - discount) * .05);
        }
        this.TaxAmount.setValue(taxAmount+Cnstnts.EMPTY_STRING);
        int totalAmount = amount - discount + taxAmount;
        this.TotalAmount.setValue(totalAmount+Cnstnts.EMPTY_STRING);
    }
    
    public void doPrintProcess() throws Exception {
    	this.setOutputFile(this.makePdf(this.getUserInfo()));
    }
    
    public void doOtherInsertProcess() throws Exception {
    	this.setOutputFile(this.makePdf(this.getUserInfo()));
    }
    
    @SuppressWarnings({ "static-access", "unchecked" })
	public String makePdf(UserBean userInfo) throws Exception{
    	Employee sale = new Employee(this.Sale.getValue());
    	Department dept = new Department(this.getCreateDept());
    	
    	String IMAGE = Cnstnts.EMPTY_STRING;
    	String pdfText = Cnstnts.EMPTY_STRING;
    	  
    	String titleText = userInfo.getMsg(this.getProgramId()+"."+"title");
    	String pdfTitle=titleText;
    	String pdfSubject="";
    	String pdfAuthor=userInfo.getAttribute("user_name");
    	//String pdfHeader=userInfo.getMsg("jsp.report.header");
    	String pdfHeader=Cnstnts.EMPTY_STRING;
    	String pdfImgPath="";
    	String fName = Util.getPdfNo(this.getApplicant()+"_"+this.getTableName())+".pdf";
    	String pdfFilePath=Util.getPdfPath()+fName;
    	  
    	Vector<HashMap<?, ?>> pdfDocHeader = new Vector<HashMap<?, ?>>();
    	
    	pdfText = dept.getCompanyName(this.getCreateDept());
    	pdfDocHeader.add(Util.makePdfText(pdfText,IMAGE,PdfCnstnts.SIZE16,PdfCnstnts.CENTER));
    	
    	pdfText = userInfo.getMsg(this.getProgramId()+"."+"title");
    	pdfDocHeader.add(Util.makePdfText(pdfText,IMAGE,PdfCnstnts.SIZE14,PdfCnstnts.CENTER));
    	
    	Vector<HashMap<?, ?>> pdfDocFooter = new Vector<HashMap<?, ?>>();
    	pdfText = userInfo.getAttribute("user_name")+" "+Util.getDateTime();
    	pdfDocFooter.add(Util.makePdfText(pdfText,IMAGE,PdfCnstnts.SIZE8,PdfCnstnts.LEFT));
    	  
    	HashMap pdfDocTable;
    	int Columns = 14;
    	int Border = 1;
    	float Width = 100f;
    	int Padding = 3;
    	int Spacing = 0;
    	Vector<HashMap<?, ?>> pdfTableData = new Vector<HashMap<?, ?>>();
    	String cellText;
    	HashMap cell;
    	
    	cellText = userInfo.getMsg(this.getProgramId()+".FlowKey");
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN2,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.CENTER);
    	pdfTableData.add(cell);
    	
    	cellText = this.FlowKey.getValue();
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN5,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.LEFT);
    	pdfTableData.add(cell);
    	
    	cellText = userInfo.getMsg(this.getProgramId()+".EffectDate");
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN3,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.CENTER);
    	pdfTableData.add(cell);
    	
    	cellText = this.EffectDate.getValue();
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN4,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.LEFT);
    	pdfTableData.add(cell);
    	
    	
    	cellText = userInfo.getMsg(this.getProgramId()+".CustomerName");
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN2,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.CENTER);
    	pdfTableData.add(cell);
    	
    	cellText = this.CustomerName.getValue();
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN12,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.LEFT);
    	pdfTableData.add(cell);
    	
    	
    	cellText = userInfo.getMsg(this.getProgramId()+".Contact");
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN2,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.CENTER);
    	pdfTableData.add(cell);
    	
    	cellText = this.Contact.getValue();
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN3,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.LEFT);
    	pdfTableData.add(cell);
    	
    	cellText = userInfo.getMsg(this.getProgramId()+".Tel");
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN1,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.CENTER);
    	pdfTableData.add(cell);
    	
    	cellText = this.Tel.getValue();
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN4,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.LEFT);
    	pdfTableData.add(cell);
    	
    	cellText = userInfo.getMsg(this.getProgramId()+".Fax");
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN1,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.CENTER);
    	pdfTableData.add(cell);
    	
    	cellText = this.Fax.getValue();
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN3,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.LEFT);
    	pdfTableData.add(cell);
    	
    	
    	cellText = userInfo.getMsg(this.getProgramId()+".Address");
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN2,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.CENTER);
    	pdfTableData.add(cell);
    	
    	cellText = this.Address.getValue();
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN6,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.LEFT);
    	pdfTableData.add(cell);
    	
    	cellText = userInfo.getMsg(this.getProgramId()+".Email");
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN2,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.CENTER);
    	pdfTableData.add(cell);
    	
    	cellText = this.Email.getValue();
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN4,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.LEFT);
    	pdfTableData.add(cell);
    	
    	
    	cellText = Cnstnts.EMPTY_STRING;
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE,PdfCnstnts.COLSPAN14,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.LEFT);
    	pdfTableData.add(cell); 
    	
    	
    	cellText = userInfo.getMsg("jsp.Quotation_detail.title");
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE14,PdfCnstnts.COLSPAN14,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.CENTER);
    	pdfTableData.add(cell);
    	
    	
    	cellText = userInfo.getMsg("jsp.Quotation_detail.ItemName");
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN9,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.CENTER);
    	pdfTableData.add(cell);
    	
    	cellText = userInfo.getMsg("jsp.Quotation_detail.UnitPrice");
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN2,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.CENTER);
    	pdfTableData.add(cell);
    	
    	cellText = userInfo.getMsg("jsp.Quotation_detail.Qty");
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN1,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.CENTER);
    	pdfTableData.add(cell);
    	
    	cellText = userInfo.getMsg("jsp.Quotation_detail.Amount");
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN2,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.CENTER);
    	pdfTableData.add(cell);
    	
    	for(Iterator itr=this.myDetail.getDetails(this.FlowKey.getValue()).iterator();
    																	itr.hasNext();){
        	List<Field> detailFieldsLst = (List<Field>)itr.next();
        	for(Iterator fieldsItr=detailFieldsLst.iterator(); fieldsItr.hasNext();){
        		Field field = (Field)fieldsItr.next();
        		String showName = field.getValue();
        		if(field.getName().equals("Seq_no")){
        			cell = Util.makePdfCell(showName,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN1,
        	    									PdfCnstnts.ROWSPAN1,PdfCnstnts.CENTER);
        			pdfTableData.add(cell);
        		}
        		if(field.getName().equals("ItemName")){
        			cell = Util.makePdfCell(showName,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN8,
							PdfCnstnts.ROWSPAN1,PdfCnstnts.LEFT);
        			pdfTableData.add(cell);
        		}
        		if(field.getName().equals("UnitPrice")){
        			showName = Util.outFormat(Integer.parseInt(showName), 3);
        			cell = Util.makePdfCell(showName,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN2,
							PdfCnstnts.ROWSPAN1,PdfCnstnts.RIGHT);
        			pdfTableData.add(cell);
        		}
        		if(field.getName().equals("Qty")){
        			cell = Util.makePdfCell(showName,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN1,
							PdfCnstnts.ROWSPAN1,PdfCnstnts.RIGHT);
        			pdfTableData.add(cell);
        		}
        		if(field.getName().equals("Amount")){
        			showName = Util.outFormat(Integer.parseInt(showName), 3);
        			cell = Util.makePdfCell(showName,IMAGE,PdfCnstnts.SIZE12,PdfCnstnts.COLSPAN2,
							PdfCnstnts.ROWSPAN1,PdfCnstnts.RIGHT);
        			pdfTableData.add(cell);
        		}
        	}
        }
    	
    	
    	int discount = 0;
    	if(this.Discount.getValue().trim().length()>0){
    		discount = Integer.parseInt(this.Discount.getValue());
    	}
    	if(discount>0){
    		cellText =  userInfo.getMsg(this.getProgramId()+".Discount");
        	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE,PdfCnstnts.COLSPAN12,
        									PdfCnstnts.ROWSPAN1,PdfCnstnts.RIGHT);
        	pdfTableData.add(cell);
        	
        	cellText = Util.outFormat(discount,3);
        	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE,PdfCnstnts.COLSPAN2,
        									PdfCnstnts.ROWSPAN1,PdfCnstnts.RIGHT);
        	pdfTableData.add(cell);
    	}
    	
    	
    	int taxAmount = 0;
    	if(this.TaxAmount.getValue().trim().length()>0){
    		taxAmount = Integer.parseInt(this.TaxAmount.getValue());
    	}
    	if(taxAmount>0){
    		cellText =  userInfo.getMsg(this.getProgramId()+".TaxAmount");
        	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE,PdfCnstnts.COLSPAN12,
        									PdfCnstnts.ROWSPAN1,PdfCnstnts.RIGHT);
        	pdfTableData.add(cell);
        	
        	cellText = Util.outFormat(taxAmount,3);
        	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE,PdfCnstnts.COLSPAN2,
        									PdfCnstnts.ROWSPAN1,PdfCnstnts.RIGHT);
        	pdfTableData.add(cell);
    	}
    	
    	
    	cellText =  userInfo.getMsg(this.getProgramId()+".TotalAmount");
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE,PdfCnstnts.COLSPAN2,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.CENTER);
    	pdfTableData.add(cell);
    	
    	if(this.TotalAmount.getValue().trim().length()==0){
    		this.TotalAmount.setValue("0");
    	}
    	cellText = Util.cnLong2cnShort(Util.number2chinese(Integer.parseInt(this.TotalAmount.getValue())));
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE,PdfCnstnts.COLSPAN7,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.CENTER);
    	pdfTableData.add(cell);
    	
    	cellText = "NT$ "+Util.outFormat(Integer.parseInt(this.TotalAmount.getValue()),3);
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE,PdfCnstnts.COLSPAN5,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.RIGHT);
    	pdfTableData.add(cell);
    	
    	
    	cellText = Cnstnts.EMPTY_STRING;
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE,PdfCnstnts.COLSPAN14,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.LEFT);
    	pdfTableData.add(cell); 
    	
    	
    	cellText = userInfo.getMsg(this.getProgramId()+".Memo");
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE,PdfCnstnts.COLSPAN2,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.CENTER);
    	pdfTableData.add(cell);
    	
    	cellText = this.Memo.getValue();
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE,PdfCnstnts.COLSPAN12,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.LEFT);
    	pdfTableData.add(cell);
    	
    	
    	cellText = Cnstnts.EMPTY_STRING;
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE,PdfCnstnts.COLSPAN14,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.LEFT);
    	pdfTableData.add(cell); 
    	
    	
    	cellText = userInfo.getMsg(this.getProgramId()+".Sale");
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE,PdfCnstnts.COLSPAN2,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.CENTER);
    	pdfTableData.add(cell);
    	
    	cellText = sale.getEmp_name();
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE,PdfCnstnts.COLSPAN2,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.LEFT);
    	pdfTableData.add(cell);
    	
    	cellText = userInfo.getMsg(this.getProgramId()+".Tel");
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE,PdfCnstnts.COLSPAN1,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.CENTER);
    	pdfTableData.add(cell);
    	
    	cellText = sale.getTel_no()+"  cell: "+sale.getMobile_no();
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE,PdfCnstnts.COLSPAN6,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.LEFT);
    	pdfTableData.add(cell);
    	
    	cellText = Cnstnts.EMPTY_STRING;
    	cell = Util.makePdfCell(cellText,Util.getTomcatPath()+"img/BigSeal.jpg",PdfCnstnts.SIZE,PdfCnstnts.COLSPAN3,
    									PdfCnstnts.ROWSPAN3,PdfCnstnts.CENTER);
    	pdfTableData.add(cell);
    	
    	
    	cellText = userInfo.getMsg(this.getProgramId()+".Email");
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE,PdfCnstnts.COLSPAN2,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.CENTER);
    	pdfTableData.add(cell);
    	
    	cellText = sale.getEmail();
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE,PdfCnstnts.COLSPAN9,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.LEFT);
    	pdfTableData.add(cell);
    	    	
    	
    	cellText = userInfo.getMsg(this.getProgramId()+".Address");
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE,PdfCnstnts.COLSPAN2,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.CENTER);
    	pdfTableData.add(cell);
    	
    	cellText = sale.getAddress();
    	cell = Util.makePdfCell(cellText,IMAGE,PdfCnstnts.SIZE,PdfCnstnts.COLSPAN9,
    									PdfCnstnts.ROWSPAN1,PdfCnstnts.LEFT);
    	pdfTableData.add(cell);
    	
    	
    	pdfDocTable = Util.makePdfTable(Columns,Border,Width,Padding,Spacing,pdfTableData.iterator());
    	HashMap pdfData = Util.makePdfData(pdfDocHeader.iterator(),pdfDocTable,pdfDocFooter.iterator());
    	Vector<HashMap<?, ?>> pdfDataVtr = new Vector<HashMap<?, ?>>();
    	pdfDataVtr.add(pdfData);
    	HashMap pdfInfo = Util.makePdfDoc(pdfTitle,pdfSubject,pdfAuthor,pdfHeader,pdfImgPath,pdfFilePath,pdfDataVtr.iterator());
    	new PdfGenerator(PdfCnstnts.A4,PdfCnstnts.DEFAULT).run(pdfInfo);
    	
    	return "pdf/"+fName;
    }

}