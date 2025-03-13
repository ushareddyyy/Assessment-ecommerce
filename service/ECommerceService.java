package com.ecommerce.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ecommerce.entity.*;
import com.ecommerce.repo.*;

@Service
public class ECommerceService {

	@Autowired private UserRepo userRepo;
	@Autowired private ProductRepo productRepo;
	@Autowired private CartItemRepo cartItemRepo;
	@Autowired private OrderRepo orderRepo;
	@Autowired private OrderItemRepo orderItemRepo;

	// User - Register
	public User register(User user) {
		return userRepo.save(user);
	}

	// User - Login
	public User login(String email, String password) {
		User user = userRepo.findByEmail(email);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	// Product - All
	public List<Product> getAllProducts() {
		return productRepo.findAll();
	}

	// Product - By ID
	public Product getProductById(int id) {
		return productRepo.findById(id).orElse(null);
	}

	// Product - Add
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}

	// Product - Delete
	public void deleteProduct(int id) {
		productRepo.deleteById(id);
	}

	// Cart - Add
	public CartItem addToCart(int userId, int productId, int quantity) {
		User user = userRepo.findById(userId).orElse(null);
		Product product = productRepo.findById(productId).orElse(null);
		if (user == null || product == null) return null;

		CartItem item = new CartItem(0, user, product, quantity);
		return cartItemRepo.save(item);
	}

	// Cart - View
	public List<CartItem> viewCart(int userId) {
		User user = userRepo.findById(userId).orElse(null);
		return user != null ? cartItemRepo.findByUser(user) : new ArrayList<>();
	}

	// Cart - Clear
	public void clearCart(User user) {
		cartItemRepo.deleteByUser(user);
	}

	// Order - Place
	public Order placeOrder(int userId) {
		User user = userRepo.findById(userId).orElse(null);
		if (user == null) return null;

		List<CartItem> cartItems = cartItemRepo.findByUser(user);
		if (cartItems.isEmpty()) return null;

		// ✅ FIX: set user before saving order
		Order order = new Order();
		order.setUser(user);  // IMPORTANT LINE
		orderRepo.save(order);

		for (CartItem ci : cartItems) {
			OrderItem oi = new OrderItem(0, order, ci.getProduct(), ci.getQuantity(), ci.getProduct().getPrice());
			orderItemRepo.save(oi);
		}

		clearCart(user);
		return order;
	}

	// Order - View by user
	public List<Order> viewOrders(int userId) {
		User user = userRepo.findById(userId).orElse(null);
		return user != null ? orderRepo.findByUser(user) : new ArrayList<>();
	}
}
