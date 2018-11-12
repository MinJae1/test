package mvc;

public class CountryLanguageDTO {
	private String cc;
	private String lan;
	private String isof;
	private float per;

	public CountryLanguageDTO() {
		// TODO Auto-generated constructor stub
	}

	public CountryLanguageDTO(String cc, String lan, float per) {
		this.cc = cc;
		this.lan = lan;
		this.per = per;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getLan() {
		return lan;
	}

	public void setLan(String lan) {
		this.lan = lan;
	}

	public String getIsof() {
		return isof;
	}

	public void setIsof(String isof) {
		this.isof = isof;
	}

	public float getPer() {
		return per;
	}

	public void setPer(float per) {
		this.per = per;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String ret = String.format("%s %-10s %.1f", cc, lan,  per);
		return ret;
	}
}
