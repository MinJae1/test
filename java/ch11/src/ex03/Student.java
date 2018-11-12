package ex03;

import ch11.Member;

public class Student {
	private String stNum;

	public Student(String stNum) {
		// TODO Auto-generated constructor stub
		this.stNum = stNum;
	}

	public String getStNum() {
		return stNum;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Member) {
			Student stu = (Student) obj;
			if (stNum.equals(stu.stNum)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return stNum.hashCode();
	}
}
