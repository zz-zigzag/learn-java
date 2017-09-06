package site.xiaodong.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ArgsAspectConfig {

	@Pointcut("args(Long, ..) && within(site.xiaodong.service..*)")
//	@Pointcut("args(Long) && within(site.xiaodong.service..*)")
	public void matchArgs() {
	}

	@Before("matchArgs()")
	public void before() {
		System.out.println("");
		System.out.println("### before args aspect");
	}
}
