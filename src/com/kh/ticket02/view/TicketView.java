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
		finish : 
		while(true) {
			int choice = printLoginMenu();
			switch(choice) {
			case 1 : // 1. 회원용 
				end : 
				for(;;) {
					choice = printMemberMenu();
					switch(choice) {
					case 1 : // 1. 회원 정보 입력 
						member = inputMember();
						int result = controller.insertMember(member);
						if(result > 0) {
							// 성공 메시지 출력
							displaySuccess("학생 정보 등록 성공");
						} else {
							// 실패 메시지 출력
							displayError("학생 정보 등록 실패");
						}
						break;
					case 2 : // 2. 회원 정보 확인(예매 내역, 회원 등급 포함) 
						break;
					case 3 : // 3. 회원 정보 수정 
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
						case 1 : // 1. 전체 회원 정보 확인 
							break;
						case 2 : // 2. 티켓 정보 입력
							break;
						case 3 : // 3. 티켓 정보 수정 
							break;
						case 4 : // 4. 티켓 정보 삭제
							break;
						case 5 : // 5. 이전으로 돌아가기
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

	private void displayError(String message) {
		System.out.println("[서비스 실패] : " + message);
	}

	private void displaySuccess(String message) {
		System.out.println("[서비스 성공] : " + message);
	}

	private Ticket inputMember() {
		// TODO Auto-generated method stub
		return null;
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
		System.out.println("1. 회원 정보 입력");
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
		System.out.println("3. 티켓 정보 수정 ");
		System.out.println("4. 티켓 정보 삭제");
		System.out.println("5. 이전으로 돌아가기");
		System.out.println("0. 프로그램 종료");
		System.out.print("메뉴 선택 >> ");
		int choice = sc.nextInt();
		return choice;
	}
	
}
