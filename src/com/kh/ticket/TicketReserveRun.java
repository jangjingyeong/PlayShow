package com.kh.ticket;

import java.util.Scanner;


public class TicketReserveRun {
	public static void main(String[] args) {
		TicketReserveFunction ticFunc = new TicketReserveFunction();
		finish : 
		while(true) {
			int choice = ticFunc.printMenu();
			switch(choice) {
			case 1 : 
				ticFunc.inputInfo();
				break;
			case 2 : 
				ticFunc.printInfoAll();
				break;
			case 3 : 
				ticFunc.printInfoSearch();
				break;
			case 4 : 
				ticFunc.ticketReserve();
				break;
			case 5 : 
				ticFunc.printReserve();
				break;
			case 6 : 
				System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
				System.out.println("		                      프로그램이 종료되었습니다. ");
				System.out.println("■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■ ■");
				break finish;
			default : System.out.println("잘못입력하셨습니다. 다시 선택해주세요."); 
			}
			
			
			
			
			
			
			
		}
	}
	


	
	
	
	
}
