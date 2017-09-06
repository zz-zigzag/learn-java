package site.xiaodong.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ObjectAspectConfig {

	@Pointcut("bean(logService)")	//注意小写
//	@Pointcut("target(site.xiaodong.service.Loggable)")
//	@Pointcut("this(site.xiaodong.service.LogService)")
//	@Pointcut("this(site.xiaodong.service.Loggable)")
	public void matchCondition() {
		
	}
	
	@Before("matchCondition()")
	public void before() {
		System.out.println("");
		System.out.println("### before object aspect");
	}
}
