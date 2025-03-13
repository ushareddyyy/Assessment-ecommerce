package com.ecommerce.controller;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ecommerce.entity.*;
import com.ecommerce.service.ECommerceService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class ECommerceController {

	@Autowired private ECommerceService service;

	// User
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return service.register(user);
	}

	@PostMapping("/login")
	public User login(@RequestBody User user) {
		return service.login(user.getEmail(), user.getPassword());
	}

	// Products
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return service.getAllProducts();
	}

	@GetMapping("/products/{id}")
	public Product getProductById(@PathVariable int id) {
		return service.getProductById(id);
	}

	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}

	@DeleteMapping("/products/{id}")
	public void deleteProduct(@PathVariable int id) {
		service.deleteProduct(id);
	}

	// Cart
	@PostMapping("/cart/{userId}/add/{productId}/{quantity}")
	public CartItem addToCart(@PathVariable int userId, @PathVariable int productId, @PathVariable int quantity) {
		return service.addToCart(userId, productId, quantity);
	}

	@GetMapping("/cart/{userId}")
	public List<CartItem> viewCart(@PathVariable int userId) {
		return service.viewCart(userId);
	}

	// Orders
	@PostMapping("/order/{userId}")
	public Order placeOrder(@PathVariable int userId) {
		return service.placeOrder(userId);
	}

	@GetMapping("/orders/{userId}")
	public List<Order> getUserOrders(@PathVariable int userId) {
		return service.viewOrders(userId);
	}
}
