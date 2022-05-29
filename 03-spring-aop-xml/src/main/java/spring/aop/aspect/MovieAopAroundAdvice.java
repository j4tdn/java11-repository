package spring.aop.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MovieAopAroundAdvice implements MethodInterceptor {

	public Object invoke(MethodInvocation invocation) throws Throwable {
		Object object = null;
		
		System.out.println(">>>> Before proceed");
		System.out.println(">>>> Method name: " + invocation.getMethod().getName());
		
		try {
			object = invocation.proceed();
			System.out.println(">>>> After proceed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return object;
	}

}
