package vo;

import java.util.Date;
import java.util.ArrayList;

public class Writing {
	protected int id;
	protected String title;
	protected String name;
	protected Date write_date;
	protected Date mod_date;
	
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
	
	public Date getWriteDate() {
		return this.write_date;
	}
	
	public Date getModDate() {
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
	
	public Writing setWriteDate(Date wDate) {
		this.write_date = wDate;
		return this;
	}
	
	public Writing setModDate(Date modDate) {
		this.mod_date = modDate;
		return this;
	}
}
