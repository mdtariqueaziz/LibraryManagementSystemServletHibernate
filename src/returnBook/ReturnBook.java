package returnBook;

public class ReturnBook {
	private int iId;
	private String status;
	private int bId;
	public ReturnBook() {
	}
	public ReturnBook(int iId, String status,int bId) {
		super();
		this.iId = iId;
		this.status = status;
	}
	public int getbId() {
		return bId;
	}
	public void setbId(int bId) {
		this.bId = bId;
	}
	public int getiId() {
		return iId;
	}
	public void setiId(int iId) {
		this.iId = iId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}


