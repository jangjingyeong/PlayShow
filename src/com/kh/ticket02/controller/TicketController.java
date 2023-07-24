package com.kh.ticket02.controller;

import com.kh.ticket02.model.dao.TicketDAO;
import com.kh.ticket02.model.vo.Ticket;

public class TicketController {
	TicketDAO tDao;
	
	public TicketController() {
		tDao = new TicketDAO();
	}
	
	public int insertMember(Ticket member) {
		int result = tDao.inputMember(member);
		return result;
	}

	public Ticket printMemberById(String memberId) {
		Ticket member = tDao.selectMemberById(memberId);
		return member;
	}

}
