package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import vo.Writing;

public class WritingDao {
	Connection conn;
	
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	public List<Writing> getBoard() throws Exception {
		Statement stmt = null;
		ResultSet rs = null;
		String read_sql = "select id, title, name, write_date, mod_date from board order by id desc";
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(read_sql);
			
			ArrayList<Writing> writings = new ArrayList<Writing>();
			while(rs.next()) {
				Writing w = new Writing();
				w = w.setId(rs.getInt("id"))
						.setTitle(rs.getString("title"))
						.setName(rs.getString("name"))
						.setWriteDate(rs.getTimestamp("write_date"))
						.setModDate(rs.getTimestamp("mod_date"));
				writings.add(w);
			}
			return writings;
		} catch (Exception e) {
			throw e;
		} finally {
			try {if(rs != null) rs.close();} catch(Exception e) {}
			try {if(stmt != null) stmt.close();} catch(Exception e) {}
		}
	}
	
	public int insert(Writing w) throws Exception {
		PreparedStatement stmt = null;
		String write_sql = "insert into board(name, email, password, title, content) values(?, ?, ?, ?, ?)";
		String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
		if(!w.getEmail().matches(emailRegex)) {
			return -1;
		}
		
		try {
			stmt = conn.prepareStatement(write_sql);
			stmt.setString(1, w.getName());
			stmt.setString(2, w.getEmail());
			stmt.setString(3, w.getPassword());
			stmt.setString(4, w.getTitle());
			stmt.setString(5, w.getContent());
			stmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			throw e;
		} finally {
			try {if(stmt != null) stmt.close();} catch(Exception e) {}
		}
	}
	
	public int delete(int id) throws Exception {
		PreparedStatement stmt = null;
		String delete_sql = "delete from board where id=?";
		
		try {
			stmt = conn.prepareStatement(delete_sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			throw e;
		} finally {
			try {if(stmt != null) stmt.close();} catch(Exception e) {}
		}
	}
	
	public String getPassword(int id) throws Exception {
		Statement stmt = null;
		ResultSet rs = null;
		String select_sql = "select password from board where id="+id;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(select_sql);
			rs.next();
			return rs.getString("password");
		} catch (Exception e) {
			throw e;
		} finally {
			try {if(rs != null) rs.close();} catch(Exception e) {}
			try {if(stmt != null) stmt.close();} catch(Exception e) {}
		}
	}
	
	public Writing getWriting(int id) throws Exception {
		Statement stmt = null;
		ResultSet rs = null;
		String select_sql = "select id, name, email, password, title, content from board where id="+id;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(select_sql);
			rs.next();
			
			Writing w = new Writing();
			w = w.setId(rs.getInt("id"))
					.setTitle(rs.getString("title"))
					.setName(rs.getString("name"))
					.setEmail(rs.getString("email"))
					.setPassword(rs.getString("password"))
					.setContent(rs.getString("content"));
			return w;
		} catch (Exception e) {
			throw e;
		} finally {
			try {if(rs != null) rs.close();} catch(Exception e) {}
			try {if(stmt != null) stmt.close();} catch(Exception e) {}
		}
	}
	
	public int update(Writing w) throws Exception {
		PreparedStatement stmt = null;
		String write_sql = "update board set name=?, email=?, password=?, title=?, content=? where id=?";
		String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
		if(!w.getEmail().matches(emailRegex)) {
			return -1;
		}
		
		try {
			stmt = conn.prepareStatement(write_sql);
			stmt.setString(1, w.getName());
			stmt.setString(2, w.getEmail());
			stmt.setString(3, w.getPassword());
			stmt.setString(4, w.getTitle());
			stmt.setString(5, w.getContent());
			stmt.setInt(6, w.getId());
			stmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			throw e;
		} finally {
			try {if(stmt != null) stmt.close();} catch(Exception e) {}
		}
	}
}
