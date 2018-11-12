package ch11;

public class GcExam {
	public static void main(String[] args) {
		Employee emp;

		emp = new Employee(1);
		emp = null;
		emp = new Employee(2);
		emp = new Employee(3);

		System.out.print("Employee's number :");
		System.out.println(emp.eno);
		System.gc();
	}
}

class Employee {

	public int eno;

	public Employee(int eno) {
		// TODO Auto-generated constructor stub
		this.eno = eno;
		System.out.println("Create Employee(" + eno + ")");
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Remove Employee(" + eno + ")");
	}

}
