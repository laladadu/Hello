package com.aartek.repositoryImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aartek.model.HindiDTO;
import com.aartek.repository.HindiReposetry;

@Repository
public class HindiReposetryImpl implements HindiReposetry {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	public boolean saveHindiDetail(HindiDTO hindiDto) {
		if (hindiDto != null) {

			System.out.println("At REPOSETRY");
			System.out.println("First name is : " + hindiDto.getFirstName());
			System.out.println("Last Name is : " + hindiDto.getLastName());

			hibernateTemplate.saveOrUpdate(hindiDto);
			System.out.println("INSERT");

			return true;
		}
		return false;
	}
}
