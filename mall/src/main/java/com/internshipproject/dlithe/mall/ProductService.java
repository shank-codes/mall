package com.internshipproject.dlithe.mall;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	public Product newadd(Product product)
	{
		return repo.save(product);                //repo.save is a pre defined method in spring boot for a repository
	}                                              //serv.newadd(vehicle);
	
	public List<Product> every()
	{
		return repo.findAll();                      //read
	}
	
	public Product single(int id)
	{
		return repo.findById(id).orElse(new Product());                 // read,write,update and delete
	}
	
	public Product alter(Product product)
	{
		return repo.save(product);
	}
	public String remove(Product product)
	{
		String model=product.getPname();
		repo.delete(product);
		return model;
	}
	
}
