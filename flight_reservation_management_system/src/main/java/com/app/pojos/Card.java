package com.app.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "card")
public class Card extends BaseEntity{
	
	@Column(name = "card_no", length = 20, nullable = false)
	private String cardNo;
	@Column(length = 20, nullable = false)
	private String name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "exp_date", nullable = false)
	private LocalDate expDate;
	
	@Column(nullable = false)
	private int cvv;
//	@JoinColumn(name = "carduser_id",nullable = false)
	
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
	public LocalDate getExpDate() {
		return expDate;
	}
	public void setExpDate(LocalDate expDate) {
		this.expDate = expDate;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	public Card(String cardNo, String name, LocalDate expDate, int cvv) {
		super();
		this.cardNo = cardNo;
		this.name = name;
		this.expDate = expDate;
		this.cvv = cvv;
	}
	public Card() {
		super();
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((cardNo == null) ? 0 : cardNo.hashCode());
		result = prime * result + cvv;
		result = prime * result + ((expDate == null) ? 0 : expDate.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (cardNo == null) {
			if (other.cardNo != null)
				return false;
		} else if (!cardNo.equals(other.cardNo))
			return false;
		if (cvv != other.cvv)
			return false;
		if (expDate == null) {
			if (other.expDate != null)
				return false;
		} else if (!expDate.equals(other.expDate))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Card [cardNo=" + cardNo + ", name=" + name + ", expDate=" + expDate + ", cvv=" + cvv + "]";
	}
	

}
