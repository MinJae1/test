package ex08;

public class Student {
	public int Stno;
	public String name;

	public Student(int Stno, String name) {
		this.Stno = Stno;
		this.name = name;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Stno;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Student) {
			Student studnt = (Student) obj;
			return studnt.Stno == Stno;
		} else {
			return false;
		}
	}
}
