package com.app.pojos;

public class CardInfo {
	private String cardNo;
	private String name;
	private String expDate;
	private int cvv;
	public CardInfo() {}
	public CardInfo(String cardNo, String name, String expDate, int cvv) {
		super();
		this.cardNo = cardNo;
		this.name = name;
		this.expDate = expDate;
		this.cvv = cvv;
	}
	@Override
	public String toString() {
		return "CardInfo [cardNo=" + cardNo + ", name=" + name + ", expDate=" + expDate + ", cvv=" + cvv + "]";
	}
	public String getCardNo() {
		return cardNo;
	}
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
}
