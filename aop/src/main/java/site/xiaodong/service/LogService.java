package site.xiaodong.service;

import org.springframework.stereotype.Component;

import site.xiaodong.anno.MethodAnno;
import site.xiaodong.anno.TypeAnno;

@Component
@TypeAnno
public class LogService implements Loggable {

	@Override
	@MethodAnno
	public void log() {
		System.out.println("log from LogService");
	}

}
