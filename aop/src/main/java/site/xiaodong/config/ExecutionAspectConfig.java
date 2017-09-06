package site.xiaodong.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionAspectConfig {

//	@Pointcut("execution(public String site.xiaodong.service..*Service.*(Long))")
//	@Pointcut("execution(* site.xiaodong.service.*Service.*())")
//	@Pointcut("execution(* site.xiaodong.service..*Service.*(..) throws * )")
	@Pointcut("execution(* site.xiaodong.service..*.*(..) throws java.lang.IllegalAccessException )")
	public void matchCondition() { }
	
	@Before("matchCondition()")
	public void before() {
		System.out.println("");
		System.out.println("### before execution aspect");
	}
}
