package v;

public class VDTO {
	private int album_id, title_song_id;
	private String name, issue_date, album_type;

	private String title;

	public VDTO() {
		// TODO Auto-generated constructor stub
	}

	public VDTO(int album_id, String name, String issue_date) {
		this.album_id = album_id;
		this.name = name;
		this.issue_date = issue_date;
	}

	public int getAlbum_id() {
		return album_id;
	}

	public void setAlbum_id(int album_id) {
		this.album_id = album_id;
	}

	public int getTitle_song_id() {
		return title_song_id;
	}

	public void setTitle_song_id(int title_song_id) {
		this.title_song_id = title_song_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}

	public String getAlbum_type() {
		return album_type;
	}

	public void setAlbum_type(String album_type) {
		this.album_type = album_type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
