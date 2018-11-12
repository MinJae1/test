package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import project.MembetDAO;

class MemberDAOTest {

	MembetDAO mdao = new MembetDAO();

	@Test
	void test() {
		int result = mdao.CheckIDLogin(100004, "login");
		assertEquals(result, 1);
	}

}
