package my.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleAfterReturningAdvice implements AfterReturningAdvice {
	private static Logger logger = LoggerFactory.getLogger(
			SimpleAfterReturningAdvice.class);
			
    public static void main(String... args) {
		
        Student munsif = new Student();

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SimpleAfterReturningAdvice());
        pf.setTarget(munsif);

        Student proxy = (Student) pf.getProxy();

        proxy.reading();
    }

    @Override
    public void afterReturning(Object returnValue, Method method,
                               Object[] args, Object target) throws Throwable {
        logger.info("After '" + method.getName() + "', write the book review.");
    }
}
