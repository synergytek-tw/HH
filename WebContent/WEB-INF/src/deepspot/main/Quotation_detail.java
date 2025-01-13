package deepspot.main;

import java.util.Iterator;
import java.util.List;
import deepspot.basic.Cnstnts;
import deepspot.basic.Field;
import deepspot.basic.DetailBean;

public class Quotation_detail extends DetailBean {

    public Quotation_detail(){this.init();}

    public Quotation_detail(String FlowKey) {
        this.init();
        this.setFlowKey(FlowKey);
    }

    public Field ItemName;
    public void setItemName(String ItemName){this.ItemName.setValue(ItemName);}
    public String getItemName(){return this.ItemName.getValue();}

    public Field UnitPrice;
    public void setUnitPrice(String UnitPrice){this.UnitPrice.setValue(UnitPrice);}
    public String getUnitPrice(){return this.UnitPrice.getValue();}

    public Field Qty;
    public void setQty(String Qty){this.Qty.setValue(Qty);}
    public String getQty(){return this.Qty.getValue();}

    public Field Amount;
    public void setAmount(String Amount){this.Amount.setValue(Amount);}
    public String getAmount(){return this.Amount.getValue();}

    public void init() {
        super.init();
        this.setProgramId("jsp.Quotation_detail");
        this.setTableName("Quotation_detail");

        this.ItemName = new Field("ItemName", this.getTableName());
        this.ItemName.setCheckEmpty(true);

        this.UnitPrice = new Field("UnitPrice", this.getTableName());

        this.Qty = new Field("Qty", this.getTableName());

        this.Amount = new Field("Amount", this.getTableName());

        this.setDbFields();
    }

    public void setDbFields() {
        super.setDbFields();
        this.ItemName.setDbType("nvarchar(200)");
        this.getDbFields().add(this.ItemName);
        
        this.UnitPrice.setDbType("int");
        this.UnitPrice.setAlign(Cnstnts.RIGHT);
        this.getDbFields().add(this.UnitPrice);
        
        this.Qty.setDbType("int");
        this.Qty.setAlign(Cnstnts.RIGHT);
        this.getDbFields().add(this.Qty);
        
        this.Amount.setDbType("int");
        this.Amount.setAlign(Cnstnts.RIGHT);
        this.Amount.setSubTotalFlag(true);
        this.getDbFields().add(this.Amount);
    }

    public String printMaintainTable() throws Exception {
        String rtnString = Cnstnts.EMPTY_STRING;
            this.ItemName.setHtmlType(Cnstnts.HTML_TAG_TEXTAREA);
            this.ItemName.setCols(60);
            this.ItemName.setRows(2);
            rtnString += this.printHtml(this.ItemName);
            
            this.Amount.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Amount.setSize(10);
            this.Amount.setReadonly(true);
            
            this.Qty.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.Qty.setSize(2);
            this.Qty.setOnChange("document.input.amount.value=document.input.qty.value*document.input.unitPrice.value");
            this.Qty.setAnotherField(this.Amount);

            this.UnitPrice.setHtmlType(Cnstnts.HTML_TAG_TEXT);
            this.UnitPrice.setSize(10);
            this.UnitPrice.setOnChange("document.input.amount.value=document.input.qty.value*document.input.unitPrice.value");
            this.UnitPrice.setAnotherField(this.Qty);
            rtnString += this.printHtml(this.UnitPrice);

        return rtnString;
    }

    @SuppressWarnings("unchecked")
    public void doAction(UserBean userInfo) throws Exception{
        this.setUserInfo(userInfo);
        if(this.onBtnSubmit()){
            if(this.checkFieldEmptyError()){
                return;
            } else {
                if(this.checkHasAnotherError()){
                    return;
                } else {
                    this.setCloseFlag(true);
                }
            }
            Quotation parentObj = (Quotation)userInfo.getObj("Quotation");
            this.setDbFields();
            if(Cnstnts.INSERT.equals(this.getActionMode())){
                parentObj.getDetails().add(this.getDbFields());
            }
            if(Cnstnts.UPDATE.equals(this.getActionMode())){
                parentObj.getDetails().set(this.getRecordIndex(), this.getDbFields());
            }
         } else {
            if(Cnstnts.UPDATE.equals(this.getActionMode())){
                Quotation parentObj = (Quotation)userInfo.getObj("Quotation");
                parentObj.setDbFields();
                List<Field> parentFields = (List<Field>)parentObj.getDetails().get(this.getRecordIndex());
                this.setDbFields();
                for(Iterator parentFieldsItr=parentFields.iterator();parentFieldsItr.hasNext();){
                    Field parentField = (Field)parentFieldsItr.next();
                    if(parentField!=null){
                        for(Iterator thisFieldsItr=this.getDbFields().iterator();thisFieldsItr.hasNext();){
                            Field thisField = (Field)thisFieldsItr.next();
                            if(thisField!=null && thisField.getName().equals(parentField.getName())){
                                thisField.setValue(parentField.getValue());
                            }
                        }
                    }
                }
            }
        }
    }

    private boolean checkHasAnotherError() throws Exception{
        return false;
    }

}