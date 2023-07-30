package com.kh.ticket02.model.vo;

import java.util.Date;

public class Ticket {
	// 필드 
	// 입력 받을 정보 
	// 회원 정보 
	private String MemberId; // 아이디 
	private String MemberPwd; // 비번 
	private String MemberName; // 예매자명 
	private char gender; // 성별 
	private String email; // 예매자이메일
	private String phone; // 예매자전화번호
	private Date enrollDate; // 가입일자.. 
	
	
	
	private Date reserveDate; // 예매일자
	private int buyNum; // 예매매수 
	private int buyAmount; // 예매금액
	
	// 공연 정보
	private String ticketDate; // 공연날짜
	private String ticketTime; // 공연시간
	private String title; // 공연이름
	private int price; // 가격 
	private int space; // 잔여석
	
	
	
	// 생성자 
	// 기본 생성자
	public Ticket() {}
	
	// 회원 가입용 
	public Ticket(String memberId, String memberPwd, String memberName, char gender, String email, String phone) {
		super();
		MemberId = memberId;
		MemberPwd = memberPwd;
		MemberName = memberName;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
	}
	
	// 회원 정보 수정용 
	public Ticket(String memberPwd, String email, String phone) {
		super();
		MemberPwd = memberPwd;
		this.email = email;
		this.phone = phone;
	}

	// 티켓 입력용 
	public Ticket(String ticketDate, String ticketTime, String title, int price, int space) {
		super();
		this.ticketDate = ticketDate;
		this.ticketTime = ticketTime;
		this.title = title;
		this.price = price;
		this.space = space;
	}
	
	// 티켓 예매 
	public Ticket(int buyNum, String title) {
		super();
		this.buyNum = buyNum;
		this.title = title;
	}
	
	
	

	// getter, setter
	public String getMemberId() {
		return MemberId;
	}


	public void setMemberId(String memberId) {
		MemberId = memberId;
	}

	public String getMemberPwd() {
		return MemberPwd;
	}

	public void setMemberPwd(String memberPwd) {
		MemberPwd = memberPwd;
	}

	public String getMemberName() {
		return MemberName;
	}

	public void setMemberName(String memberName) {
		MemberName = memberName;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
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

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public Date getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(Date reserveDate) {
		this.reserveDate = reserveDate;
	}

	public int getBuyNum() {
		return buyNum;
	}

	public void setBuyNum(int buyNum) {
		this.buyNum = buyNum;
	}

	public int getBuyAmount() {
		return buyAmount;
	}

	public void setBuyAmount(int buyAmount) {
		this.buyAmount = buyAmount;
	}

	public String getTicketDate() {
		return ticketDate;
	}

	public void setTicketDate(String ticketDate) {
		this.ticketDate = ticketDate;
	}

	public String getTicketTime() {
		return ticketTime;
	}

	public void setTicketTime(String ticketTime) {
		this.ticketTime = ticketTime;
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





	




	
	
	
}
