package group3.com.example.retail.catalog;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import group3.com.example.retail.product.Product;



//@RequestMapping({"/"})    // SET TO BE THE MAIN

@Controller
public class CatalogController {
	
	private static Catalog catalog = Catalog.getCatalog(); // 

	
	
	
	@GetMapping({"", "/home", "index", "/"}) // Return all Products
	public ModelAndView home() {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("other/home");
		mnv.addObject("categorys", catalog.getAllStoreCategories());
		mnv.addObject("products", catalog.getAllProducts() );
		return mnv;
	}
	
	
	@GetMapping({"/{categoryName}", "/{categoryName}/"}) // Return all Products in Category
	public ModelAndView getCategory(@PathVariable String categoryName) {
		ModelAndView mnv = new ModelAndView();
		mnv.setViewName("other/home");
//		mnv.addObject("categorys", catalog.getAllProductsInCategory(categoryName));
		mnv.addObject("products", catalog.getAllProductsInCategory(categoryName));
		return mnv;
	}
	//

	
	private static List<Product> getAllProductsInCategory(String categoryId) {
		return catalog.getAllProductsInCategory(categoryId);
	}
	
//
}