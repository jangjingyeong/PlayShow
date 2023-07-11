package com.kh.ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicketReserveFunction {
	List<TicketReserve> ticList;  // 리스트 생성 
	List<Reservation> reserveList = new ArrayList<Reservation>();
	TicketInfo ti1 = new TicketInfo("23/07/11","백작", 29900, 20);
	TicketInfo ti2 = new TicketInfo("23/07/16","트레이스유", 58000, 20);
	TicketInfo ti3 = new TicketInfo("23/08/05","테베랜드", 50000, 20);
	TicketInfo ti4 = new TicketInfo("23/08/10","와일드그레이", 30000, 20);
	TicketInfo ti5 = new TicketInfo("23/10/01","타오르는어둠속에서", 50000, 20);
	
	
	public TicketReserveFunction() {
		ticList = new ArrayList<TicketReserve>();
	}
	public static int printMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		System.out.println();		
		System.out.println("		                       [티켓 예매 프로그램] ");
		System.out.println();
		System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		
		System.out.println("1. 회원 정보 입력 ");
		System.out.println("2. 전체 회원 정보 확인 ");
		System.out.println("3. 특정 회원 정보 확인");
		System.out.println("4. 티켓 예매");
		System.out.println("5. 예매 내역 확인");
		System.out.println("6. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
		int choice = sc.nextInt();
		return choice;
	}
	
	public void inputInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		System.out.println();
		System.out.println("		                      [예매할 회원 정보 입력] ");
		System.out.println();
		System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("이메일 : ");
		String email = sc.next();
		System.out.print("핸드폰번호(010-0000-0000) : ");
		String phone = sc.next();
		TicketReserve member = new TicketReserve(name, email, phone);
		ticList.add(member);  // 리스트에 정보 넣음
	}
	public void printInfoAll() { // 전체출력
		System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		System.out.println();
		System.out.println("		                       [전체 회원 정보 확인] ");
		System.out.println();
		System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		for(int i = 0; i < ticList.size(); i++) {
			TicketReserve member = ticList.get(i);
			System.out.printf("%d번째 회원 -> 이름 : %s, 이메일 : %s, 핸드폰번호 : %s\n", (i+1), member.getName(), member.getEmail(), member.getPhone());
		}
	}
	
	public void printInfoSearch() {
		System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		System.out.println();
		System.out.println("		                       [특정 회원 정보 확인] ");
		System.out.println();
		System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		Scanner sc = new Scanner(System.in);
		System.out.print("확인할 회원 이름 입력 : ");
		String name = sc.next();
		for(TicketReserve member : ticList) {
			if(member.getName().equals(name)) {
				System.out.printf("검색 결과 >> 이름 : %s, 이메일 : %s, 핸드폰번호 : %s\n",  member.getName(), member.getEmail(), member.getPhone());
			}
		}
	}
	
	public void ticketReserve() {
		Scanner sc = new Scanner(System.in);
		

		List<TicketInfo> tList = new ArrayList<>();
		tList.add(ti1); 
		tList.add(ti2);
		tList.add(ti3);
		tList.add(ti4);
		tList.add(ti5);
		
		
		System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		System.out.println();
		System.out.println("		                            [티켓 예매] ");
		System.out.println();
		System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		System.out.println(tList.get(0));
		System.out.println(tList.get(1));
		System.out.println(tList.get(2));
		System.out.println(tList.get(3));
		System.out.println(tList.get(4));
		System.out.print("예매자 이름 입력 >>");
		String name = sc.next();
		System.out.print("공연 명 입력 >>");
		String title = sc.next();

		int buyNum = 0;
		if (title.trim().equals("백작") || title.trim().equals("타오르는어둠속에서") || title.trim().equals("트레이스유")
				|| title.trim().equals("테베랜드") || title.trim().equals("와일드그레이")) {

			for (int j = 0; j < tList.size(); j++) {
				if (tList.get(j).getTitle().equals(title)) {
					if (tList.get(j).getSpace() == 0) {
						System.out.println("잔여석이 없습니다.");
						ticketReserve();
					} else {
						System.out.print("예매할 매수 입력 >> ");
						buyNum = sc.nextInt();

						if (buyNum > tList.get(j).getSpace()) {
							System.out.println("예매 가능한 매수를 초과했습니다.");
						} else {
							Reservation reserve = new Reservation();
							reserve.setMemberName(name);
							reserve.setBuyNum(buyNum);
							reserve.setTitle(title);

							tList.get(j).setSpace(tList.get(j).getSpace() - buyNum);
							reserve.setReserveDate(tList.get(j).getDate());
							reserve.setBuyAmount(tList.get(j).getPrice() * buyNum);
							reserveList.add(reserve);
							System.out.println(name + "님, " + title + "를 " + buyNum + "매 구매하셨습니다.");
						}
					}
				}
			}
		} else {
			System.out.println("해당 공연이 없습니다.");
			ticketReserve();
		}
	}
		
	
	public void printReserve() {
		Scanner sc = new Scanner(System.in);
		System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		System.out.println();
		System.out.println("		                          [예매 내역 확인]");
		System.out.println();
		System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
		System.out.print("예매자 이름 입력 >> ");
		String name = sc.next();
		
		for(int i = 0; i<reserveList.size(); i++) {
			if(name.equals(reserveList.get(i).getMemberName())) { 
				System.out.println(reserveList.get(i));
			}
		}
	}
	
	
	
	
}
