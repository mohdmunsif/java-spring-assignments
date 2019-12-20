package my.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {
	private static Logger logger = LoggerFactory.getLogger(
			SimpleBeforeAdvice.class);
			
    public static void main(String... args) {
		
        Student munsif = new Student();

        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SimpleBeforeAdvice());
        pf.setTarget(munsif);

        Student proxy = (Student) pf.getProxy();

        proxy.reading();
    }

    @Override
    public void before(Method method, Object[] args, Object target)
            throws Throwable {
        logger.info("Before '" + method.getName() + "', buy the book.");
    }
}
