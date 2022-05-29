package spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MovieLogAspect {
	// class annotated with @Aspect contains Advice, PointCut
	private Logger LOGGER = Logger.getLogger(getClass().getName());

	// execution(* *(..))
	// execution(* com.spring.service.*.*(..))
	// execution(private * com.spring.service.*.*(..))
	// execution(* com.spring.service.MovieService.*(..))
	// execution(* com.spring.service.MovieService.addMovie(..))
	// execution(* com.spring.service.MovieService.update*(..))"
	// execution(* com.spring.service.MovieService.*Movie(..))

	@Pointcut("execution(* spring.aop.service.MovieService.*(..))")
	public void movieServicePointCut() {
	};

	@Before("movieServicePointCut()")
	public void forMovieSerivce(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		LOGGER.info(">>>> Add LOG before MovieService " + methodName);
	}

	@Before("movieServicePointCut()")
	public void forAnalyseService(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		LOGGER.info("<<<< Add LOG for analysing " + methodName);
	}

}
