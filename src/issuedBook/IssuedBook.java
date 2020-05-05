package issuedBook;

import java.sql.*;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "issuedbook")
public class IssuedBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "issuedId")
	int issuedId;
	@Column(name = "studentId")
	private int studentId;
	@Column(name = "name")
	private String name;
	@Column(name = "mobile")
	private long mobile;
	@Column(name = "email")
	private String email;
	@Column(name = "date")
	private String date;
	@Column(name = "status")
	private String status;
	@Column(name = "bookid")
	private int bookId;

	public IssuedBook(int studentId, String name, long mobile, String email, String date, String status, int bookid) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.date = date;
		this.status = status;
	}

	public IssuedBook() {
		// TODO Auto-generated constructor stub
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getStatus() {
		return status;
	}

	public int getIssuedId() {
		return issuedId;
	}

	public void setIssuedId(int issuedId) {
		this.issuedId = issuedId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String isStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}