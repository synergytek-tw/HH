package deepspot.html;

public class TitleTag{
	
	public TitleTag(){};
	
	public TitleTag(String titleValue){
		this.titleValue=titleValue;
	}
	
	private String titleValue="";
	public void setTitleValue(String titleValue){this.titleValue=titleValue;}
	public String getTitleValue(){return this.titleValue;}
	
	public String toString(){
		return ("<title>"+this.titleValue+"</title>");
	}
	
}