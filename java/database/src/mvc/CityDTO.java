package mvc;

public class CityDTO {
	private int id;
	private String name;
	private String cc;
	private String dst;
	private int pp;


	public CityDTO() {
		// TODO Auto-generated constructor stub
	}

	public CityDTO(int id, String name, String cc, String dst, int pp) {
		this.id = id;
		this.name = name;
		this.cc = cc;
		this.dst = dst;
		this.pp = pp;
	}

	public CityDTO(String name, String cc, String dst, int pp) {
		this.name = name;
		this.cc = cc;
		this.dst = dst;
		this.pp = pp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getDst() {
		return dst;
	}

	public void setDst(String dst) {
		this.dst = dst;
	}

	public int getPp() {
		return pp;
	}

	public void setPp(int pp) {
		this.pp = pp;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String ret = String.format("%8d %-15s %s %-20s %,10d", id, name, cc, dst,
				pp);
		return ret;
	}

}
