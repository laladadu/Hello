package com.aartek.service;

import java.util.List;

import com.aartek.model.ProductDto;

public interface ProductService {

	public boolean insertProductDetails(ProductDto productDto);

	public List<ProductDto> showProductsDetails();

	public List<ProductDto> show_pro_detail(String p_id);

	public void delete_product(String p_id);
}
