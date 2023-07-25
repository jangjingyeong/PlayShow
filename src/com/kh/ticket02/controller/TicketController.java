package com.kh.ticket02.controller;

import java.util.List;

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

	public int updateMember(Ticket member) {
		int result = tDao.updateMember(member);
		return result;
	}

	public int insertTicket(Ticket ticket) {
		int result = tDao.inputTicket(ticket);
		return result;
	}

	public Ticket printMemberById(String memberId) {
		Ticket member = tDao.selectMemberById(memberId);
		return member;
	}

	public List<Ticket> selectAllMembers() {
		List<Ticket> mList = tDao.selectAllMembers();
		return mList;
	}

	public List<Ticket> selectAllTickets() {
		List<Ticket> tList = tDao.selectAllTickets();
		return tList;
	}

}
