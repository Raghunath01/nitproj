package in.nitech.model;

public class Contact {
	private Integer cntctId;
	private String cntctName;
	private Long cntctNum;
	public Contact() {
		super();
	}
	public Contact(Integer cntctId, String cntctName, Long cntctNum) {
		super();
		this.cntctId = cntctId;
		this.cntctName = cntctName;
		this.cntctNum = cntctNum;
	}
	public Integer getCntctId() {
		return cntctId;
	}
	public void setCntctId(Integer cntctId) {
		this.cntctId = cntctId;
	}
	public String getCntctName() {
		return cntctName;
	}
	public void setCntctName(String cntctName) {
		this.cntctName = cntctName;
	}
	public Long getCntctNum() {
		return cntctNum;
	}
	public void setCntctNum(Long cntctNum) {
		this.cntctNum = cntctNum;
	}
	@Override
	public String toString() {
		return "Contact [cntctId=" + cntctId + ", cntctName=" + cntctName + ", cntctNum=" + cntctNum + "]";
	}
	
}
