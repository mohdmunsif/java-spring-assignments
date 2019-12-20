package my.aop;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookThrowsAdvice implements ThrowsAdvice {
	private static Logger logger = LoggerFactory.getLogger(
			BookThrowsAdvice.class);
			
    public static void main(String... args) throws Exception {
        ErrorBean errorBean = new ErrorBean();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(errorBean);
        pf.addAdvice(new BookThrowsAdvice());

        ErrorBean proxy = (ErrorBean) pf.getProxy();

        try {
            proxy.throwException();
        } catch (Exception ignored) {

        }

//        try {
//            proxy.errorProneMethod();
//        } catch (Exception ignored) {
//
//        }
//
//        try {
//            proxy.otherErrorProneMethod();
//        } catch (Exception ignored) {
//
//        }
    }

    public void afterThrowing(Method method,Object[] args, Object target, RuntimeException ex) throws Throwable {
        logger.info("***");
        logger.info("RuntimeException Capture");
        logger.info("Caught: " + ex.getClass().getName());
        logger.info("Method: " + method.getName());
        System.out.print("***\n");
    }

    public void afterThrowing(Exception ex) throws Throwable {
        logger.info("***");
        logger.info("Generic Exception Capture");
        logger.info("Caught: " + ex.getClass().getName());
        System.out.print("***\n");
    }

    public void afterThrowing(Method method, Object[] args, Object target,
            IllegalArgumentException ex) throws Throwable {
        logger.info("***");
        logger.info("IllegalArgumentException Capture");
        logger.info("Caught: " + ex.getClass().getName());
        logger.info("Method: " + method.getName());
        System.out.print("***\n");
    }
}
