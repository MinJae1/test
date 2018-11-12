package project;

public class BbsDTO {
	private int id;
	private int memberId;
	private String title;
	private String content;
	private String name;
	private String date;

	public String getDate() {
		return date;
	}

	public BbsDTO() {
		// TODO Auto-generated constructor stub
	}

	public BbsDTO(int memberId, String title, String content) {
		this.memberId = memberId;
		this.title = title;
		this.content = content;
	}

	public BbsDTO(int id, String title, String name, String date) {
		this.id = id;
		this.title = title;
		this.name = name;
		this.date = date;
	}

	public BbsDTO(String title, String content, String name, String date) {
		this.title = title;
		this.content = content;
		this.name = name;
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String ret = String.format("%4d   %-20s      %-8s    %13s", id, title, name,
				date);

		return ret;
	}
	

}
