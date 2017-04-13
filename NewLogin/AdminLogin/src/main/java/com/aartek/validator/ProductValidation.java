package com.aartek.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.aartek.model.ProductDto;

@Component
public class ProductValidation implements Validator {

	public boolean supports(Class<?> objrct) {

		return ProductDto.class.isAssignableFrom(objrct);
	}

	public void validate(Object objrct, Errors errors) {

		ProductDto productDto = (ProductDto) objrct;

		if (productDto.getPro_name() != "" && productDto.getPro_name().matches("[a-zA-Z]{2,25}") != true) {
			// errors.rejectValue("pro_name", "error.pro_name.length");
			errors.rejectValue("pro_name", "error.pro_name.alphabetic");

		} else {
			ValidationUtils.rejectIfEmpty(errors, "pro_name", "error.pro_name.empty");
		}
		if (productDto.getPro_category() != "" && productDto.getPro_category().matches("[a-zA-Z]{2,25}") != true) {
			// errors.rejectValue("pro_category", "error.pro_category.length");
			errors.rejectValue("pro_category", "error.pro_category.alphabetic");

		} else {
			ValidationUtils.rejectIfEmpty(errors, "pro_category", "error.pro_category.empty");
		}
		if (productDto.getPro_price() != "" && productDto.getPro_price().matches("[0-9]+") != true) {
			errors.rejectValue("pro_price", "error.pro_price.invalid");
		} else {
			ValidationUtils.rejectIfEmpty(errors, "pro_price", "error.pro_price.empty");
		}
		if (productDto.getPro_id() != "" && productDto.getPro_id().matches("[0-9]+") != true) {
			errors.rejectValue("pro_id", "error.pro_id.invalid");
		} else {
			ValidationUtils.rejectIfEmpty(errors, "pro_id", "error.pro_id.empty");
		}

	}

}
