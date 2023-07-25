package com.kh.ticket02.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kh.ticket02.model.vo.Ticket;

public class TicketDAO {
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:XE"; 
	private final String USER = "TICKET01";
	private final String PASSWORD = "TICKET01";
	
	public int inputMember(Ticket member) {
		String query = "INSERT INTO MEMBER_TBL VALUES(?, ?, ?, ?, ?, ?, DEFAULT)";
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberId());
			pstmt.setString(2, member.getMemberPwd());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getGender()+"");
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getPhone());
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public int updateMember(Ticket member) {
		String query = "UPDATE MEMBER_TBL SET MEMBER_PWD = ?, EMAIL = ?, PHONE = ?";
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getMemberPwd());
			pstmt.setString(2, member.getEmail());
			pstmt.setString(3, member.getPhone());
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public int inputTicket(Ticket ticket) {
		String query = "INSERT INTO TICKET_TBL VALUES(?, ?, ?, ?, ?)";
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, ticket.getTicketDate());
			pstmt.setString(2, ticket.getTicketTime());
			pstmt.setString(3, ticket.getTitle());
			pstmt.setInt(4, ticket.getPrice());
			pstmt.setInt(5, ticket.getSpace());
			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public Ticket selectMemberById(String memberId) {
		String query = "SELECT * FROM MEMBER_TBL WHERE MEMBER_ID = ?";
		Ticket member = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery(); 
			if(rset.next()) {
				member = rsetToMember(rset);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

	public List<Ticket> selectAllMembers() {
		String query = "SELECT * FROM MEMBER_TBL"; 
		// 쿼리문을 보고 실행할 메소드와 리턴타입을 정한다 
		List<Ticket> mList = new ArrayList<Ticket>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			// 후처리 
			while(rset.next()) {
				Ticket member = rsetToMember(rset);
				mList.add(member);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mList;
	}

	public List<Ticket> selectAllTickets() {
		String query = "SELECT * FROM TICKET_TBL"; 
		// 쿼리문을 보고 실행할 메소드와 리턴타입을 정한다 
		List<Ticket> tList = new ArrayList<Ticket>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			// 후처리 
			while(rset.next()) {
				Ticket ticket = rsetToTicket(rset);
				tList.add(ticket);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return tList;
	}

	private Ticket rsetToTicket(ResultSet rset) throws SQLException {
		Ticket ticket = new Ticket();
		ticket.setTicketDate(rset.getString("TICKET_DATE"));
		ticket.setTicketTime(rset.getString("TICKET_TIME"));
		ticket.setTitle(rset.getString("TITLE"));
		ticket.setPrice(rset.getInt("PRICE"));
		ticket.setSpace(rset.getInt("SPACE"));
		return ticket;
	}

	private Ticket rsetToMember(ResultSet rset) throws SQLException {
		Ticket member = new Ticket();
		member.setMemberId(rset.getString("MEMBER_ID"));
		member.setMemberPwd(rset.getString("MEMBER_PWD"));
		member.setMemberName(rset.getString("MEMBER_NAME"));
		member.setGender(rset.getString("GENDER").charAt(0));
		member.setEmail(rset.getString("EMAIL"));
		member.setPhone(rset.getString("PHONE"));
		member.setEnrollDate(rset.getDate("ENROLL_DATE"));
		return member;
	}

}
