package com.spring.data.jpa.demo.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.spring.data.jpa.demo.model.Product;
import com.spring.data.jpa.demo.repository.ProductRepository;

@Controller
public class ProductController {
	@Autowired
    private ProductRepository productRepository;
	
	public void run() {
		//1. inserting
		Date dateCreated = new Date(2022, 11, 10);
		Date lastUpdated = new Date(2022, 11, 30);
		
		
		/*Product p1 = new Product("Ball", "A round ball.", new BigDecimal(25.00), true, "c:\\images\\ball.png", dateCreated, lastUpdated);
		Product p2 = new Product("Bat", "A straight bat.", new BigDecimal(100.50), true, "c:\\images\\bat.png", dateCreated, lastUpdated);
		Product p3 = new Product("Bat", "A flat bat.", new BigDecimal(125.50), true, "c:\\images\\bat.png", dateCreated, lastUpdated);
		*/
		
		Product p1 = new Product("Ball", "A round ball.", new BigDecimal(25.00), true, "c:\\images\\ball.png");
		Product p2 = new Product("Bat", "A straight bat.", new BigDecimal(100.50), true, "c:\\images\\bat.png");
		Product p3 = new Product("Bat", "A flat bat.", new BigDecimal(125.50), true, "c:\\images\\bat.png");
		
		
		productRepository.save(p1);
		productRepository.save(p2);
		productRepository.save(p3);
		
		System.out.println("\n\n\n***************************\n");
		
		
		//2. displaying
		Product product = productRepository.findById(1L).get();

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
        
		
		
		
		// 3. findByNameOrDescription
        System.out.println("\n\n\n***********findByNameOrDescription****************\n");
		List<Product> products = productRepository.findByNameOrDescription("Bat",
                "A straight bat.xyz");
		
		 products.forEach((p) -> {
	            System.out.println(p.getId());
	            System.out.println(p.getName());
	      });
		 
		
		
		
		 // 4. findByNameAndDescription
				 
		 System.out.println("\n\n\n***********findByNameAndDescription****************\n");
		 List<Product> products1 = productRepository.findByNameAndDescription("Ball",
	                "A round ball.");


	        products1.forEach((p) -> {
	            System.out.println(p.getId());
	            System.out.println(p.getName());
	        });
	       
		
	        //5. findDistinctByNameMethod
	        
	        System.out.println("\n\n\n***********findDistinctByNameMethod****************\n");
	        
	        Product product2 = productRepository.findDistinctByName("Ball");
	        
	        System.out.println(product2.getId());
	        System.out.println(product2.getName());
	        System.out.println(product2.getDescription());
	        
	        
	
	        //6. findByPriceGreaterThan
	        System.out.println("\n\n\n***********findByPriceGreaterThan****************\n");
	        List<Product> products3 = productRepository.findByPriceGreaterThan(new BigDecimal(100));
	        products3.forEach((p) -> {
	            System.out.println(p.getId());
	            System.out.println(p.getName());
	        });
	        
		
	        
	        //7. findByPriceLessThan
	        System.out.println("\n\n\n***********findByPriceLessThan****************\n");
	        List<Product> products4 = productRepository.findByPriceLessThan(new BigDecimal(100));
	        products4.forEach((p) -> {
	            System.out.println(p.getId());
	            System.out.println(p.getName());
	        });
	        
	       
		
		
	        //8. findByNameContaining
	        System.out.println("\n\n\n***********findByNameContaining****************\n");
	        List<Product> products5 = productRepository.findByNameContaining("Ba");
	        products5.forEach((p) -> {
	            System.out.println(p.getId());
	            System.out.println(p.getName());
	        });
	       
		
		
	        
	        //9. findByNameLike
	        
	        System.out.println("\n\n\n***********findByNameLike****************\n");
	        
	        List<Product> products6 = productRepository.findByNameLike("Bal");
	        products6.forEach((p) -> {
	            System.out.println(p.getId());
	            System.out.println(p.getName());
	        });
	        
	       
		
		
	        //10. findByPriceBetween
	        
	        System.out.println("\n\n\n***********findByPriceBetween****************\n");
	        
	        List<Product> products7 = productRepository.findByPriceBetween(
	                new BigDecimal(100), new BigDecimal(300)
	        );

	        products7.forEach((p) ->{
	            System.out.println(p.getId());
	            System.out.println(p.getName());
	        });
	       
		
		  
	        
	        //11. findByDateCreatedBetween
	        
	        System.out.println("\n\n\n***********findByDateCreatedBetween****************\n");
	      
	        // start date
	        Date startDate = new Date(2023, 12, 13);
	        // end date
	        Date endDate = new Date(2023, 12, 2023);
	        
	        List<Product> products8 = productRepository.findByDateCreatedBetween(startDate, endDate);

	        products8.forEach((p) ->{
	            System.out.println(p.getId());
	            System.out.println(p.getName());
	        });
	        
	        
	}
}
