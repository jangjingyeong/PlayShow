package com.kh.ticket;

public class TicketReserve {
	// 입력 받을 정보 
	// 회원정보 
	private String name; 
	private String email;
	private String phone;

	public TicketReserve() {
		name = "";
		email = "";
		phone = "";
	}
	
	public TicketReserve(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "TicketReserve [name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
	
 	
	
}






class Reservation {
	private String memberName;
	private String reserveDate;
	private String title;
	private int buyNum;
	private int buyAmount;

	public Reservation() {}
	public Reservation(String memberName, String title, int buyNum, String reserveDate, int buyAmount) {
		super();
		this.memberName = memberName;
		this.title = title;
		this.buyNum = buyNum;
		this.reserveDate = reserveDate;
		this.buyAmount = buyAmount;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getBuyNum() {
		return buyNum;
	}
	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}
	public String getReserveDate() {
		return reserveDate;
	}
	public void setReserveDate(String reserveDate) {
		this.reserveDate = reserveDate;
	}
	public int getBuyAmount() {
		return buyAmount;
	}
	public void setBuyAmount(int buyAmount) {
		this.buyAmount = buyAmount;
	}
	@Override
	public String toString() {
		return memberName + "님은 " + reserveDate + " 공연 '" + title
				+ "'를 총 " + buyNum + "매 예매하셨고 총 금액은 " + buyAmount + "입니다.";
	}
	
	
	
	
}




class TicketInfo {
	private String date;
	private String title;
	private int price;
	private int space;
	
	public TicketInfo() {}

	public TicketInfo(String date, String title, int price, int space) {
		super();
		this.date = date;
		this.title = title;
		this.price = price;
		this.space = space;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getSpace() {
		return space;
	}

	public void setSpace(int space) {
		this.space = space;
	}

	@Override
	public String toString() {
		return "공연날짜 : " + date + " / 공연명 : " + title + " / 가격 : " + price + " / 잔여석 : " + space;
	}

	

	
	
	
}





