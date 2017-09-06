package site.xiaodong.config;

import static org.hamcrest.CoreMatchers.nullValue;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdviceAspectConfig {

	@Pointcut("execution(* site.xiaodong..*.*(..) throws *)")
	public void matchException() {
	}

	@Pointcut("execution(String site.xiaodong..*Service.*(..))")
	public void matchReturn() {
	}

	@Pointcut("execution(* site.xiaodong..*Service.*(Long))")
	public void matchArgs() {
	}

	@After("matchException()")
	public void after() {
		System.out.println("");
		System.out.println("##### after");
	}

	@AfterReturning("matchException()")
	public void afterReturning() {
		System.out.println("");
		System.out.println("##### afterReturning");
	}

	@AfterThrowing("matchException()")
	public void afterThrowing() {
		System.out.println("");
		System.out.println("##### afterThrowing");
	}

	@AfterReturning(value = "matchReturn()", returning = "result")
	public void afterReturn(String result) {
		System.out.println("");
		System.out.println("##### afterReturn " + result);
	}


	@Before("matchArgs() && args(id)")
	public void beforeArgs(Long id) {
		System.out.println("");
		System.out.println("##### beforeArgs " + id);
	}
	
	@Around("matchArgs()")
	public  Object Around(ProceedingJoinPoint joinPoint) {
		Object result = null;
		try {
			result = joinPoint.proceed(joinPoint.getArgs());
			System.out.println("#### return ");
		} catch (Throwable e) {
			System.out.println("#### exception");
			e.printStackTrace();
		} finally {
			System.out.println("#### finally");
		}
		return result;
	}
}
