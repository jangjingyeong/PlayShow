package com.kh.ticket02.view;

import java.util.*;

import com.kh.ticket02.controller.TicketController;
import com.kh.ticket02.model.vo.Ticket;

public class TicketView {
	
	private TicketController controller;
	
	public TicketView() {
		controller = new TicketController();
	}
	
	public void startProgram() {
		Ticket member = null;
		List<Ticket> mList;
		Ticket ticket = null;
		List<Ticket> tList;
		String memberId = "";
		finish : 
		while(true) {
			int choice = printLoginMenu();
			switch(choice) {
			case 1 : // 1. 회원용 
				end : 
				for(;;) {
					choice = printMemberMenu();
					switch(choice) {
					case 1 : // 1. 회원 가입 ok
						member = inputMember();
						int result = controller.insertMember(member);
						if(result > 0) {
							// 성공 메시지 출력 
							displaySuccess("회원 가입 성공");
						} else {
							// 실패 메시지 출력
							displayError("회원 가입 실패");
						}
						break;
					case 2 : // 2. 회원 정보 확인(예매 내역, 회원 등급 포함) ok...
						memberId = inputMemberId("확인");
						member = controller.printMemberById(memberId);
						if(member != null) {
							showMember(member);
						} else {
							displayError("회원 정보가 존재하지 않습니다.");
						}
						break;
					case 3 : // 3. 회원 정보 수정 
						memberId = inputMemberId("수정");
						member = controller.printMemberById(memberId);
						if(member != null) {
							member = modifyMember();
							member.setMemberId(memberId);
							result = controller.updateMember(member);
							if(result > 0) {
								displaySuccess("회원 정보 수정 완료");
							} else {
								displayError("회원 정보 수정 실패");
							}
						}
						break;
					case 4 : // 4. 티켓 예매
						
						break;
					case 5 : // 5. 티켓 취소
						break;
					case 6 : // 6. 이전으로 돌아가기
						break end;
					case 0 : // 0. 프로그램 종료
						break finish; 
					}
				}
				break;
			case 2 : // 2. 관리자용 
				end : 
					for(;;) {
						choice = printAdminMenu();
						switch(choice) {
						case 1 : // 1. 전체 회원 정보 확인 ok
							mList = controller.selectAllMembers();
							printAllMembers(mList);
							break;
						case 2 : // 2. 티켓 정보 입력 ok
							ticket = inputTicket();
							int result = controller.insertTicket(ticket);
							if(result > 0) {
								// 성공 메시지 출력
								displaySuccess("티켓 입력 성공");
							} else {
								// 실패 메시지 출력
								displayError("티켓 입력 실패");
							}
							break;
						case 3 : // 3. 티켓 정보 확인 ok
							tList = controller.selectAllTickets();
							printAllTickets(tList);
							break;
						case 4 : // 4. 티켓 정보 수정 
							break;
						case 5 : // 5. 티켓 정보 삭제
							break;
						case 6 : // 6. 이전으로 돌아가기
							break end;
						case 0 : // 0. 프로그램 종료
							break finish; 
						}
					}
				break;
			case 0 : // 0. 프로그램 종료  
				break finish;
			}
		}
		
		
	}

	private Ticket modifyMember() {
		Scanner sc = new Scanner(System.in);
		System.out.println("회원 정보 수정");
		System.out.print("비밀번호 : ");
		String memberPwd = sc.next();
		System.out.print("이메일 : ");
		String email = sc.next();
		System.out.print("전화번호 : ");
		String phone = sc.next();
		Ticket member = new Ticket(memberPwd, email, phone);
		return member;
	}

	private int printLoginMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		System.out.println();		
		System.out.println("		                       [티켓 예매 프로그램] ");
		System.out.println();
		System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		System.out.println("1. 티켓 예매(회원)");
		System.out.println("2. 관리자용");
		System.out.println("0. 프로그램 종료");
		System.out.print("메뉴 선택 >> ");
		int choice = sc.nextInt();
		return choice;
	}

	private int printMemberMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		System.out.println();		
		System.out.println("		                       [티켓 예매 프로그램] ");
		System.out.println();
		System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		System.out.println("1. 회원 가입");
		System.out.println("2. 회원 정보 확인");
		System.out.println("3. 회원 정보 수정");
		System.out.println("4. 티켓 예매");
		System.out.println("5. 티켓 취소 ");
		System.out.println("6. 이전으로 돌아가기");
		System.out.println("0. 프로그램 종료");
		System.out.print("메뉴 선택 >> ");
		int choice = sc.nextInt();
		return choice;
	}

	private int printAdminMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		System.out.println();		
		System.out.println("		                       [티켓 예매 프로그램] ");
		System.out.println();
		System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		System.out.println("1. 전체 회원 정보 확인");
		System.out.println("2. 티켓 정보 입력");
		System.out.println("3. 티켓 정보 확인");
		System.out.println("4. 티켓 정보 수정 ");
		System.out.println("5. 티켓 정보 삭제");
		System.out.println("6. 이전으로 돌아가기");
		System.out.println("0. 프로그램 종료");
		System.out.print("메뉴 선택 >> ");
		int choice = sc.nextInt();
		return choice;
	}

	private void showMember(Ticket member) {
		System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		System.out.println("2. 회원 정보 확인");
		System.out.printf("아이디 : %s, 이름 : %s, 성별 : %s, 이메일 : %s, 전화번호 : %s\n"
				, member.getMemberId()
				, member.getMemberName()
				, member.getGender()
				, member.getEmail()
				, member.getPhone());
	}

	private void printAllMembers(List<Ticket> mList) {
		System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		System.out.println("1. 전체 회원 정보 확인");
		for(Ticket member : mList) { // foreach 쓰면 인덱스 신경쓰지 않고 출력 가능 
			System.out.printf("아이디 : %s, 이름 : %s, 성별 : %s"
					+ ", 이메일 : %s, 전화번호 : %s"
					+ ", 가입날짜 : %s\n"
					, member.getMemberId()
					, member.getMemberName()
					, member.getGender()
					, member.getEmail()
					, member.getPhone()
					, member.getEnrollDate());
		}
	}

	private void printAllTickets(List<Ticket> tList) {
		System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		System.out.println("3. 티켓 정보 확인");
		for(Ticket ticket : tList) { // foreach 쓰면 인덱스 신경쓰지 않고 출력 가능 
			System.out.printf("공연날짜 : %s, 공연시간 : %s, 공연이름 : %s"
					+ ", 가격 : %d"
					+ ", 잔여석 : %d\n"
					, ticket.getTicketDate()
					, ticket.getTicketTime()
					, ticket.getTitle()
					, ticket.getPrice()
					, ticket.getSpace());
		}
	}

	private Ticket inputMember() {
		Scanner sc = new Scanner(System.in);
		System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		System.out.println("1. 회원 가입");
		System.out.print("아이디 : ");
		String memberId = sc.next();
		System.out.print("비밀번호 : ");
		String memberPwd = sc.next();
		System.out.print("이름 : ");
		String memberName = sc.next();
		System.out.print("성별(F,M) : ");
		char gender = sc.next().charAt(0);
		System.out.print("이메일 : ");
		String email = sc.next();
		System.out.print("전화번호 : ");
		String phone = sc.next();
		Ticket member = new Ticket(memberId, memberPwd, memberName, gender, email, phone);
		return member;
	}

	private Ticket inputTicket() {
		Scanner sc = new Scanner(System.in);
		System.out.print("공연날짜 : ");
		String ticketDate = sc.nextLine();
		System.out.print("공연시간 : ");
		String ticketTime = sc.nextLine();
		System.out.print("공연이름 : ");
		String title = sc.nextLine();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		System.out.print("잔여석 : ");
		int space = sc.nextInt();
		Ticket ticket = new Ticket(ticketDate, ticketTime, title, price, space);
		return ticket;
	}

	private String inputMemberId(String category) {
		Scanner sc = new Scanner(System.in);
		System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		System.out.print(category + "회원 아이디 입력 : ");
		String memberId = sc.next();
		return memberId;
	}

	private void displaySuccess(String message) {
		System.out.println("[서비스 성공] : " + message);
	}

	private void displayError(String message) {
		System.out.println("[서비스 실패] : " + message);
	}
	
}
