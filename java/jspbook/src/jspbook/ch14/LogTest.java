package jspbook.ch14;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogTest {
	private static final Logger LOG = LoggerFactory.getLogger(LogTest.class);

	public static void main(String[] args) {
		LOG.trace("main()");
		String msg = "Hello Log";
//		Logger logger = LoggerFactory.getLogger(LogTest.class);
//		logger.info("test log");
//		logger.warn("test log : {}", msg);
		LOG.debug(msg);
		LOG.info("test log");
		LOG.warn("test log : {}", msg);
		LOG.error(msg);
		int i = methodeA();
	}

	static int methodeA() {
		// TODO Auto-generated method stub
		LOG.trace("methodeA()");
		return 0;
	}
}
