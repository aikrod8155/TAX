package efia.tax.entity;

public class Business {
	private String address; //���q�a�}
	private String seq; //�Τ@�s��
	private String head;	//�`���νs
	private String name;	//���q�W��
	private String capital;	//�ꥻ�B
	private String founding; //�Хߤ��
	private String receipt; //�O�_�ϥβΤ@�o��
	private String typeCode1;//��~�N��1
	private String typeName1;//��~�W��1
	private String typeCode2;//��~�N��2
	private String typeName2;//��~�W��2
	private String typeCode3;//��~�N��3
	private String typeName3;//��~�W��3
	private String typeCode4;//��~�N��4
	private String typeName4;//��~�W��4
	public Business() {
		
	}
	public Business(String address, String seq, String head, String name, String capital, String founding,
			String receipt, String typeCode1, String typeName1, String typeCode2, String typeName2, String typeCode3,
			String typeName3, String typeCode4, String typeName4) {
		this.address = address;
		this.seq = seq;
		this.head = head;
		this.name = name;
		this.capital = capital;
		this.founding = founding;
		this.receipt = receipt;
		this.typeCode1 = typeCode1;
		this.typeName1 = typeName1;
		this.typeCode2 = typeCode2;
		this.typeName2 = typeName2;
		this.typeCode3 = typeCode3;
		this.typeName3 = typeName3;
		this.typeCode4 = typeCode4;
		this.typeName4 = typeName4;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getFounding() {
		return founding;
	}
	public void setFounding(String founding) {
		this.founding = founding;
	}
	public String getReceipt() {
		return receipt;
	}
	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}
	public String getTypeCode1() {
		return typeCode1;
	}
	public void setTypeCode1(String typeCode1) {
		this.typeCode1 = typeCode1;
	}
	public String getTypeName1() {
		return typeName1;
	}
	public void setTypeName1(String typeName1) {
		this.typeName1 = typeName1;
	}
	public String getTypeCode2() {
		return typeCode2;
	}
	public void setTypeCode2(String typeCode2) {
		this.typeCode2 = typeCode2;
	}
	public String getTypeName2() {
		return typeName2;
	}
	public void setTypeName2(String typeName2) {
		this.typeName2 = typeName2;
	}
	public String getTypeCode3() {
		return typeCode3;
	}
	public void setTypeCode3(String typeCode3) {
		this.typeCode3 = typeCode3;
	}
	public String getTypeName3() {
		return typeName3;
	}
	public void setTypeName3(String typeName3) {
		this.typeName3 = typeName3;
	}
	public String getTypeCode4() {
		return typeCode4;
	}
	public void setTypeCode4(String typeCode4) {
		this.typeCode4 = typeCode4;
	}
	public String getTypeName4() {
		return typeName4;
	}
	public void setTypeName4(String typeName4) {
		this.typeName4 = typeName4;
	}
	
	
	
}
