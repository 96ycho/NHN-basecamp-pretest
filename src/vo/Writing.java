package vo;

import java.util.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

public class Writing {
	protected int id;
	protected String title;
	protected String name;
	protected Timestamp write_date;
	protected Timestamp mod_date;
	
	protected String email;
	protected String password;
	protected String content;
	
	public int getId() {
		return this.id;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Timestamp getWriteDate() {
		return this.write_date;
	}
	
	public Timestamp getModDate() {
		return this.mod_date;
	}
	
	public Writing setId(int id) {
		this.id = id;
		return this;
	}
	
	public Writing setTitle(String title) {
		this.title = title;
		return this;
	}
	
	public Writing setName(String name) {
		this.name = name;
		return this;
	}
	
	public Writing setWriteDate(Timestamp wDate) {
		this.write_date = wDate;
		return this;
	}
	
	public Writing setModDate(Timestamp modDate) {
		this.mod_date = modDate;
		return this;
	}
}
