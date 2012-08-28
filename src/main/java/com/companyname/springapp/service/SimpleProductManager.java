package com.companyname.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.companyname.springapp.domain.Product;
import com.companyname.springapp.repository.ProductDao;

@Component
public class SimpleProductManager implements ProductManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Autowired
    private ProductDao productDao1;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao1 = productDao;
	}
	
    public List<Product> getProducts() {
        return productDao1.getProductList();
    }

    public void increasePrice(int percentage) {
        List<Product> products = productDao1.getProductList();
        if (products != null) {
            for (Product product : products) {
                double newPrice = product.getPrice().doubleValue() * 
                                    (100 + percentage)/100;
                product.setPrice(newPrice);
                productDao1.saveProduct(product);
            }
        }
    }
	
}