package com.aartek.repository;

import java.util.List;

import com.aartek.model.ProductDto;

public interface ProductRepository {

	// FOR SAVE VALUES
	public ProductDto saveProductDetails(ProductDto productDto);

	// FOR SHOW ON DASHBOARD
	public List<ProductDto> showAllProducts();

	// FOR EDIT
	public List<ProductDto> getProductDetail(String p_id);

	// FOR DELETE
	public void deleteProduct(String p_id);

}
