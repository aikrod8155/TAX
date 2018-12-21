package efia.tax.web.form;

import efia.tax.entity.Business;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description="營利單位稅籍資料")
public class BusinessBean {
	@ApiModelProperty(dataType="string" , value="公司地址")
	private String address; //公司地址
	@ApiModelProperty(dataType="string" , value="統一編號")
	private String seq; //統一編號
	@ApiModelProperty(dataType="string" , value="總部統編")
	private String head;	//總部統編
	@ApiModelProperty(dataType="string" , value="公司名稱")
	private String name;	//公司名稱
	@ApiModelProperty(dataType="string" , value="資本額")
	private String capital;	//資本額
	@ApiModelProperty(dataType="string" , value="創立日期")
	private String founding; //創立日期
	@ApiModelProperty(dataType="string" , value="是否使用統一發票",allowableValues="Y,N")
	private String receipt; //是否使用統一發票
	@ApiModelProperty(dataType="string" , value="行業代號1")
	private String typeCode1;//行業代號1
	@ApiModelProperty(dataType="string" , value="行業名稱1")
	private String typeName1;//行業名稱1
	@ApiModelProperty(dataType="string" , value="行業代號2")
	private String typeCode2;//行業代號2
	@ApiModelProperty(dataType="string" , value="行業名稱2")
	private String typeName2;//行業名稱2
	@ApiModelProperty(dataType="string" , value="行業代號3")
	private String typeCode3;//行業代號3
	@ApiModelProperty(dataType="string" , value="行業名稱3")
	private String typeName3;//行業名稱3
	@ApiModelProperty(dataType="string" , value="行業代號4")
	private String typeCode4;//行業代號4
	@ApiModelProperty(dataType="string" , value="行業名稱4")
	private String typeName4;//行業名稱4
	public BusinessBean() {
		super();
	}
	public BusinessBean(Business entity) {
		super();
		this.address = entity.getAddress();
		this.seq = entity.getSeq();
		this.head = entity.getHead();
		this.name = entity.getName();
		this.capital = entity.getCapital();
		this.founding = entity.getFounding();
		this.receipt = entity.getReceipt();
		this.typeCode1 = entity.getTypeCode1();
		this.typeName1 = entity.getTypeName1();
		this.typeCode2 = entity.getTypeCode2();
		this.typeName2 = entity.getTypeName2();
		this.typeCode3 = entity.getTypeCode3();
		this.typeName3 = entity.getTypeName3();
		this.typeCode4 = entity.getTypeCode4();
		this.typeName4 = entity.getTypeName4();
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
