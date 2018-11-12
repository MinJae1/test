package ex04;

public class DaoExam {
	private static void dbWork(DataAccessObject dao) {
		// TODO Auto-generated method stub
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
	}

	public static void main(String[] args) {
		dbWork(new OracleDao());
		dbWork(new MtSqlDao());
	}
}
