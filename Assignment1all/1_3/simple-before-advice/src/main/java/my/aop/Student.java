package my.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by iuliana.cosmina on 3/26/17.
 */
public class Student   {
	private static Logger logger = LoggerFactory.getLogger(
			Student.class);
			
	private String action="Reading Design Patterns Book";

	public void reading(){
		logger.info("Student.reading() = " + action);
	}

}
