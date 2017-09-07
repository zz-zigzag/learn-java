package site.xiaodong.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdviceAspectConfig2 {

	@Before("execution(* site.xiaodong..*.*(..)) && args(id, id1)")
	public void log(Object id,Object id1) {
		System.out.println("");
		System.out.println("### before log aspect: " + id );
	}
}
