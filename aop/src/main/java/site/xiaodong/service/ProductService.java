package site.xiaodong.service;

import org.springframework.stereotype.Component;

import site.xiaodong.bean.Product;

@Component
public class ProductService implements Loggable {

	public String getName() {
		System.out.println("execute get name");
		return "product service";
	}
	public void setName(String name, String name1) {
		System.out.println("execute set name: " + name);
	}

	public void exDemo() throws IllegalAccessException {
		System.out.println("execute ex demo");
		throw new IllegalAccessException("hello");
	}

	public void findById(Long id) {
		System.out.println("execute find by id in " + getClass().getName());
	}

	public void setProduct(Product product) {
		System.out.println("execute setProduct");
	}
	public void findByTwoArgs(Long id, String name) {
		System.out.println("execute find by id and name");
	}

	@Override
	public void log() {
		System.out.println("log from ProductService");
	}

}
