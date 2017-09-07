package site.xiaodong.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import site.xiaodong.bean.Product;
import site.xiaodong.service.sub.SubService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring.xml" })
public class ProductServiceTest {

	@Autowired
	private ProductService productService;

	@Autowired
	private SubService subService;

	@Autowired
	private LogService logService;

	@Test
	public void testExecutionAspect() {
		System.out.println("####### begin testExecutionAspect ##########");
		productService.findById(1L);
		productService.findByTwoArgs(1L, "he");
		productService.getName();
		subService.demo();

		try {
			productService.exDemo();
		} catch (IllegalAccessException e) {
			// e.printStackTrace();
		}

		System.out.println("####### end testExecutionAspect ##########");
	}

	@Test
	public void testObjectAspect() {
		System.out.println("####### begin testObjectAspect ##########");
		productService.findById(1L);
		productService.log();
		logService.log();
		System.out.println("####### end testObjectAspect ##########");
	}

	@Test
	public void testArgsAspect() {
		System.out.println("####### begin testArgsAspect ##########");
		productService.findById(1L);
		productService.log();
		logService.log();
		System.out.println("####### end testArgsAspect ##########");
	}

	@Test
	public void testAnnoAspect() {
		System.out.println("####### begin testAnnoAspect ##########");
		productService.log();
		logService.log();
		productService.setProduct(new Product());
		System.out.println("####### end testAnnoAspect ##########");
	}

	@Test
	public void testAdviceAspect() {
		try {
			productService.exDemo();
		} catch (IllegalAccessException e) {
			// e.printStackTrace();
		}
		
		productService.getName();
		productService.findById(1L);
	}
	
	@Test
	public void testAdviceAspect2() {
		productService.findById(1L);
		productService.setName("Test","Test1");
	}
}
