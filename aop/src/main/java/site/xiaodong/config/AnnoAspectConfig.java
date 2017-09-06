package site.xiaodong.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AnnoAspectConfig {

	
//	@Pointcut("@annotation(site.xiaodong.anno.MethodAnno)")
//	@Pointcut("@within(site.xiaodong.anno.TypeAnno)")
//	@Pointcut("@target(site.xiaodong.anno.TypeAnno) && within(site.xiaodong..*)")
	@Pointcut("@args(site.xiaodong.anno.TypeAnno)")
	public void matchAnno() {}

	@Before("matchAnno()")
	public void before() {
		System.out.println("");
		System.out.println("### before Annotation aspect");
	}
}
