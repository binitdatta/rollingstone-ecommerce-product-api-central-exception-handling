package com.rollingstone.spring.controller;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rollingstone.events.ProductEvent;
import com.rollingstone.exceptions.HTTP400Exception;
import com.rollingstone.exceptions.HTTP404Exception;
import com.rollingstone.spring.model.Product;
import com.rollingstone.spring.service.ProductService;

@RestController
public class ProductController extends AbstractController {

  
   private ProductService  productService;
   
   public ProductController(ProductService productService) {
	   this.productService = productService;
   }

   /*---Add new Product---*/
   @PostMapping("/product")
   public ResponseEntity<?> createProduct(@RequestBody Product product) {
	  try {
		  Product savedProduct = productService.save(product);
	      ProductEvent productCreatedEvent = new ProductEvent("One Product is created", savedProduct);
	      eventPublisher.publishEvent(productCreatedEvent);
	      return ResponseEntity.ok().body("New Product has been saved with ID:" + savedProduct.getId());
	  }
	  catch(Exception e) {
		  throw new HTTP400Exception("The Request did not have proper data", new Date(), e);
	  }
    
   }

   /*---Get a Product by id---*/
   @GetMapping("/product/{id}")
   public ResponseEntity<Product> getProduct(@PathVariable("id") long id) {
	  try {
		  Optional<Product> returnedProduct = productService.get(id);
		  Product product  = returnedProduct.get(); 
		  
		  ProductEvent productCreatedEvent = new ProductEvent("One Product is retrieved", product);
	      eventPublisher.publishEvent(productCreatedEvent);
	      return ResponseEntity.ok().body(product);
	   }
	  catch(Exception e) {
		  throw new HTTP404Exception("The Requested Product was not found", new Date(), e);
	  }
   }

   /*---get all Product---*/
   @GetMapping("/product")
   public @ResponseBody Page<Product> getProductsByPage(
		   @RequestParam(value="pagenumber", required=true, defaultValue="0") Integer pageNumber,
		   @RequestParam(value="pagesize", required=true, defaultValue="20") Integer pageSize) {
      Page<Product> pagedProducts = productService.getProductsByPage(pageNumber, pageSize);
      return pagedProducts;
   }

   /*---Update a Product by id---*/
   @PutMapping("/product/{id}")
   public ResponseEntity<?> updateProduct(@PathVariable("id") long id, @RequestBody Product product) {
	  checkResourceFound(this.productService.get(id));
      productService.update(id, product);
      return ResponseEntity.ok().body("Product has been updated successfully.");
   }

   /*---Delete a Product by id---*/
   @DeleteMapping("/product/{id}")
   public ResponseEntity<?> deleteProduct(@PathVariable("id") long id) {
	  checkResourceFound(this.productService.get(id));
      productService.delete(id);
      return ResponseEntity.ok().body("Product has been deleted successfully.");
   }
}