package deepspot.basic;

public class DailyInfo {
	
	public DailyInfo(){this.init();}
	
	public Field BusinessDate;
    public void setBusinessDate(String BusinessDate){this.BusinessDate.setValue(BusinessDate);}
    public String getBusinessDate(){return this.BusinessDate.getValue();}
    
    public Field Dancer;
    public void setDancer(String Dancer){this.Dancer.setValue(Dancer);}
    public String getDancer(){return this.Dancer.getValue();}

    public Field FirstCount;
    public void setFirstCount(String FirstCount){this.FirstCount.setValue(FirstCount);}
    public String getFirstCount(){return this.FirstCount.getValue();}
    
    public Field FirstUnit;
    public void setFirstUnit(String FirstUnit){this.FirstUnit.setValue(FirstUnit);}
    public String getFirstUnit(){return this.FirstUnit.getValue();}
    
    public Field FirstAmount;
    public void setFirstAmount(String FirstAmount){this.FirstAmount.setValue(FirstAmount);}
    public String getFirstAmount(){return this.FirstAmount.getValue();}

    public Field SecondCount;
    public void setSecondCount(String SecondCount){this.SecondCount.setValue(SecondCount);}
    public String getSecondCount(){return this.SecondCount.getValue();}
    
    public Field SecondUnit;
    public void setSecondUnit(String SecondUnit){this.SecondUnit.setValue(SecondUnit);}
    public String getSecondUnit(){return this.SecondUnit.getValue();}
    
    public Field SecondAmount;
    public void setSecondAmount(String SecondAmount){this.SecondAmount.setValue(SecondAmount);}
    public String getSecondAmount(){return this.SecondAmount.getValue();}
    
    public Field InFlag;
    public void setInFlag(String InFlag){this.InFlag.setValue(InFlag);}
    public String getInFlag(){return this.InFlag.getValue();}
    
    public Field FirstInFlag;
    public void setFirstInFlag(String FirstInFlag){this.FirstInFlag.setValue(FirstInFlag);}
    public String getFirstInFlag(){return this.FirstInFlag.getValue();}
    
    private void init() {

    	this.BusinessDate = new Field("BusinessDate");
        
        this.Dancer = new Field("Dancer");

        this.FirstCount = new Field("FirstCount");
        
        this.FirstUnit = new Field("FirstUnit");
        
        this.FirstAmount = new Field("FirstAmount");

        this.SecondCount = new Field("SecondCount");
        
        this.SecondUnit = new Field("SecondUnit");
        
        this.SecondAmount = new Field("SecondAmount");
        
        this.InFlag = new Field("InFlag");
        
        this.FirstInFlag = new Field("FirstInFlag");
		
	}
	
}
