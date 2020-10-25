package com.internshipproject.dlithe.mall;


import static org.junit.Assert.assertNotNull;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Vector;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;




@SpringBootTest
@RunWith(SpringRunner.class)
class MallApplicationTests {
	
	@MockBean
	ProductRepository repo;
	@Autowired
	ProductService serv;

	@Test
	public void testAdd()
	{
		Product pro=new Product(12,"Horlicks",20,100.0,2000.0);
		Product pr=null;
		
		when(repo.save(pro)).thenReturn(pro);
		assertEquals(pro, serv.newadd(pro));
		assertNull(serv.newadd(pr));          // 
		Product pr02=new Product(10,"Boost",20,100.0,2000.0);
		
		when(repo.save(pr02)).thenReturn(pr02);
		assertTrue(serv.newadd(pr02).getPid()==10);
	}
	@Test
	public void testIterate()
	{
		
		List<Product> storage=new Vector<Product>();
		Product pro1=new Product(12,"Horlicks",20,100.0,2000.0);
		Product pro2=new Product(13,"Boost",30,200.0,6000.0);
		Product pro3=new Product(14,"Complan",40,300.0,12000.0);
		
		storage.add(pro1);storage.add(pro2);storage.add(pro3);
		
		when(repo.findAll()).thenReturn(storage);
		assertTrue(serv.every().get(0).getTotal()>=1000.0);
		assertNotNull(serv.every().get(2));
	}
	
	@Test
	public void testUpdate()
	{
		Product pro1=new Product(12,"Horlicks",20,100.0,2000.0);
		Product pro2=new Product(13,"Boost",30,200.0,6000.0);
		when(repo.save(pro1)).thenReturn(pro1);
		assertEquals(pro1, serv.alter(pro1));
		
		when(repo.save(pro2)).thenReturn(pro2);
		assertTrue(serv.alter(pro1).getQuantity()<=pro2.getQuantity());
	}
	
	@Test
	public void testDelete()
	{
		Product pro1=new Product(12,"Horlicks",20,100.0,2000.0);
		Product pro2=new Product(13,"Boost",30,200.0,6000.0);
		assertSame(pro2.getPname(),serv.remove(pro2));
		assertSame(pro1.getPname(),serv.remove(pro1));
	}
}













