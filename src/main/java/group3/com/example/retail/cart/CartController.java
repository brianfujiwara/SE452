package group3.com.example.retail.cart;

import group3.com.example.retail.product.Product;
import group3.com.example.retail.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class CartController {

	@Autowired
	private ProductService productService;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private CartService cartService;

	// go to 'localhost/7996/cart/'
	@GetMapping("/cart/{userID}")
	public ModelAndView getCart(@PathVariable long userID) {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("cart/cart");

		mnv.addObject("user", userID);
		Cart cart = cartRepository.findByCustomerID(userID);
		List<Product> productsInCart = cart.getCartProducts();
		mnv.addObject("products", productsInCart);
		mnv.addObject("totalPrice", cart.getTotalPrice());
		return mnv;		
	}

	@GetMapping("/checkout")
	public ModelAndView getCheckout() {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("cart/checkout");
		// TODO: Get real products in cart from table
		mnv.addObject("products", productService.getAllProducts());
		return mnv;
	}

	@GetMapping("/removeFromCart/{productId}")
	public String removeFromCart(@PathVariable Long productId) {
		// TODO: Remove hardcoded user ID
		// Remove product from cart
		cartService.removeProductFromCart(productId, 1);
		// redirect to cart view
		return "redirect:/cart/1";
	}
}
