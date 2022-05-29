package spring.aop.aspect;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

//Step 2: Create Advice
public class MovieAopBeforeAdvice implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object target) throws Throwable {
		// advice(method) run before JoinPoint
		System.out.println("\n==========================");
		System.out.println("***** MovieAopBeforeAdvice >> BEFORE >> " + method.getName());
		
	}
}
