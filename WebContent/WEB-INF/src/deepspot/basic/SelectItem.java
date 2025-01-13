package deepspot.basic;

public class SelectItem {
	public SelectItem(String key, String value){
		this.key=key;
		this.value=value;
	}
	
	private String key;
	public void setKey(String key){
		this.key=key;
	}
	public String getKey(){
		return this.key;
	}
	
	private String value;
	public void setValue(String value){
		this.value=value;
	}
	public String getValue(){
		return this.value;
	}
	
	private String parentKey;
	public void setParentKey(String parentKey){
		this.parentKey=parentKey;
	}
	public String getParentKey(){
		return this.parentKey;
	}
	
	private int layer=0;
	public void setLayer(int layer){
		this.layer = layer;
	}
	public int getLayer(){
		return this.layer;
	}
	
	private boolean initFlag=false;
	public void setInitFlag(boolean initFlag){
		this.initFlag = initFlag;
	}
	public boolean InitFlag(){
		return this.initFlag;
	}
	
	private boolean childFlag=false;
	public void setChildFlag(boolean childFlag){
		this.childFlag = childFlag;
	}
	public boolean hasChild(){
		return this.childFlag;
	}
	
	private boolean onlyMenuFlag=false;
	public void setOnlyMenuFlag(boolean onlyMenuFlag) {
		this.onlyMenuFlag = onlyMenuFlag;
	}
	public boolean onlyMenu(){
		return this.onlyMenuFlag;
	}
	
	private boolean onlyLeaveFlag=false;
	public void setOnlyLeaveFlag(boolean onlyLeaveFlag) {
		this.onlyLeaveFlag = onlyLeaveFlag;
	}
	public boolean onlyLeave(){
		return this.onlyLeaveFlag;
	}
}
