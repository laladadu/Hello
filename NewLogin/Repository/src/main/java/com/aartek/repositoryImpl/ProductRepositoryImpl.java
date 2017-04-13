package com.aartek.repositoryImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.model.ProductDto;
import com.aartek.repository.ProductRepository;

@Repository
public class ProductRepositoryImpl implements ProductRepository{

	@Autowired
	private HibernateTemplate hibernateTemplate;

	// FOR SAVE VALUES
	public ProductDto saveProductDetails(ProductDto productDto) {

		if (productDto != null) {

			hibernateTemplate.saveOrUpdate(productDto);

			return productDto;
		} else {
			return null;
		}
	}

	//FOR SHOW ON DASHBOARD
	public List<ProductDto> showAllProducts() {

		List<ProductDto> list = null;

		list = hibernateTemplate.find("from ProductDto");

		return list;

	}
	
	//FOR EDIT
	public List<ProductDto> getProductDetail(String p_id) {
		Integer id=Integer.parseInt(p_id);
		List<ProductDto> list = null;
		list=hibernateTemplate.find("from ProductDto where p_id=?",id);
		
		return list;
	}

	// FOR DELETE 
	public void deleteProduct(String p_id) {
		Integer id=Integer.parseInt(p_id);
		hibernateTemplate.bulkUpdate("delete ProductDto where p_id=? ",id);
		
		
	}
	
	
}
