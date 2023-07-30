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
		String query = "UPDATE MEMBER_TBL SET MEMBER_PWD = ?, EMAIL = ?, PHONE = ? WHERE MEMBER_ID = ?";
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
			pstmt.setString(4, member.getMemberId());
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

	public Ticket selectTicket(Ticket tr) {
		String query = "SELECT * FROM TICKET_TBL WHERE TITLE = ?";
		Ticket ticket = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, tr.getTitle());
			rset = pstmt.executeQuery(); 
			if(rset.next()) {
				ticket = rsetToTicket(rset);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return ticket;
	}

	public List<Ticket> selectTicketReserve(String memberId) {
		String query = "SELECT * FROM RESERVE_TBL JOIN TICKET_TBL USING(TITLE) WHERE BUYER = ?";
		List<Ticket> trList = new ArrayList<Ticket>();
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
				Ticket tr = rsetToReserve(rset);
				System.out.println(tr);
				trList.add(tr);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return trList;
	}

	public int ticketReserve(Ticket tr) {
		// 예매 정보에 대해서 
		// 예매자 아이디를 넘겨받아야겠따 title이랑 buyNum랑 가격을 받아야함 
		// 예매자, 타이틀,ㅂ ㅏ이넘으로 예매정보 저장하고 
		
		// 티켓 정보 
		// 티켓 정보에는 타이틀이랑 예매매수만큼 잔여석차감,,,,  
		
		String query = "INSERT INTO RESERVE_TBL VALUES(SEQ_RT.NEXTVAL, ?, ?, ?, ?, DEFAULT)";
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, tr.getMemberId());
			pstmt.setString(2, tr.getTitle());
			pstmt.setInt(3, tr.getBuyNum());
			pstmt.setInt(4, tr.getBuyAmount());
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

	public int reduceSpace(Ticket tr) {  // 잔여석 차감 
		String query = "UPDATE TICKET_TBL SET SPACE = space - ? WHERE TITLE =?";
		int result = -1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, tr.getBuyNum());
			pstmt.setString(2, tr.getTitle());
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

	private Ticket rsetToReserve(ResultSet rset) throws SQLException {
		Ticket tr = new Ticket();
		tr.setMemberId(rset.getString("BUYER"));
		tr.setTitle(rset.getString("TITLE"));
		tr.setBuyNum(rset.getInt("BUYNUM"));
		tr.setBuyAmount(rset.getInt("BUYAMOUNT"));
		tr.setReserveDate(rset.getDate("RESERVE_DATE"));
		return tr;
	}




}
