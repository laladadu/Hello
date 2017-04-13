package com.aartek.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aartek.model.ProductDto;
import com.aartek.repository.ProductRepository;
import com.aartek.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	// FOR SAVE VALUES
	public boolean insertProductDetails(ProductDto productDto) {
		
		ProductDto dto=productRepository.saveProductDetails(productDto);
		if (dto != null) {
			return true;
			}
			
		
		 else {
			return false;
		}
	}

	//FOR SHOW ON DASHBOARD
	public List<ProductDto> showProductsDetails() {
		List<ProductDto> list=productRepository.showAllProducts();
		return list;
	}
	
	//FOR EDIT 
	public List<ProductDto> show_pro_detail(String p_id) {
		List<ProductDto> list=	productRepository.getProductDetail(p_id);
			return list;
		}

	// FOR DELETE 
	public void delete_product(String p_id) {
			productRepository.deleteProduct(p_id);
			
		}
	
}
