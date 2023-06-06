package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	private ProductRepository productRepository;
	private Logger LOG=LoggerFactory.getLogger(DemoApplication.class);
	
	@Autowired
	public void productRepository(ProductRepository productRepository) {
		this.productRepository=productRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
	
		
		Product product1=new Product();
		product1.setName("Tester Product");
		product1.setCategory("TEST");
		product1.setType("GENERAL");

		productRepository.save(product1);

		Product product2=new Product();
		product2.setName("Another Tester Product");
		product2.setCategory("TEST");
		product2.setType("CUSTOM");

		productRepository.save(product2);

		List<Product> products =productRepository.findAll();
		for(Product product:products){
			LOG.info("Products found :"+product.toString());
		}


	}

}
/* 
@RestController
@RequestMapping(path="/")
class TestController{

	@RequestMapping(value="hello/{name}",method=RequestMethod.GET)
	public String hello(@PathVariable(value ="name") String name){

		return "Hello "+name;
	}
} */
