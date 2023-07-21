package com.kh.ticket02.model.vo;

public class Ticket {
	// 입력 받을 정보 
	// 회원정보 
	private String name; // 예매자명 
	private String email; // 예매자이메일
	private String phone; // 예매자전화번호
	
	private String reserveDate; // 예매일자
	private int buyNum; // 예매매수 
	private int buyAmount; // 예매금액
	
	private String date; // 공연일자
	private String time; // 공연시간
	private String title; // 공연이름
	private int price; // 가격 
	private int space; // 잔여석
}
