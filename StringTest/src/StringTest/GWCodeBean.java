package StringTest;

public class GWCodeBean {
	
	private String commonItemCode;
	private String commonItemName;
	
	public GWCodeBean(){}
	
	public GWCodeBean(String commonItemCode, String commonItemName) {
		this.commonItemCode = commonItemCode;
		this.commonItemName = commonItemName;
	}
	
	public String getCommonItemCode() {
		return commonItemCode;
	}
	public void setCommonItemCode(String commonItemCode) {
		this.commonItemCode = commonItemCode;
	}
	public String getCommonItemName() {
		return commonItemName;
	}
	public void setCommonItemName(String commonItemName) {
		this.commonItemName = commonItemName;
	}
	
	@Override
	public String toString() {
		return "commonItemCode = " + commonItemCode + " // commonItemName = " + commonItemName;
	}
}
