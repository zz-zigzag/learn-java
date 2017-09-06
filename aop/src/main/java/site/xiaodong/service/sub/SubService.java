package site.xiaodong.service.sub;

import site.xiaodong.service.ProductService;
import org.springframework.stereotype.Component;

/**
 * Created by cat on 2017-02-19.
 */
@Component
public class SubService extends ProductService{

	public void findById(Long id) {
		System.out.println("execute find by id in " + getClass().getName());
	}
    public void demo(){
        System.out.println("execute sub service method");
    }
}
