package ch11;

import java.util.Arrays;

public class Member_clon2 implements Cloneable {
	public String name;
	public int age;
	public int[] score;
	public Car car;

	public Member_clon2(String name, int age, int[] score, Car car) {
		// TODO Auto-generated constructor stub
		this.age = age;
		this.name = name;
		this.score = score;
		this.car = car;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ name = " + name + ", age = " + age + ", score = {" + score[0] + ", " + score[1] + "}, car = "
				+ car.model + " ]";
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		Member_clon2 cloned = (Member_clon2) super.clone();

		cloned.score = Arrays.copyOf(this.score, this.score.length);

		cloned.car = new Car(this.car.model);

		return cloned;
	}

	public Member_clon2 getMember_clon2() {
		// TODO Auto-generated constructor stub
		Member_clon2 cloned = null;
		try {
			cloned = (Member_clon2) clone();
		} catch (CloneNotSupportedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cloned;
	}
}
