package spring.aop.aspect;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class MovieAopAfterAdvice implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.println(">>> MovieAopAfterAdvice --> finished");
	}

}
