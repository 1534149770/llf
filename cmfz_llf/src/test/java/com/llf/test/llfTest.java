package com.llf.test;

import com.baizhi.entity.Type;
import com.baizhi.service.TypeService;
import com.baizhi.serviceImpl.TypeServiceImpl;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class llfTest {


	@Test
	public void testQueryAll(){
		TypeService service = new TypeServiceImpl();
		List<Type> list = service.findAll();
		for (Type type : list) {
			System.out.println(type.getTitle());
		}
	}
	
	@Test
	public void testDS() throws SQLException{
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		 DataSource ds = (DataSource)ctx.getBean("ds");
		 System.out.println(ds.getConnection());
	}
	
	@Test
	public void testFactory(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		 SqlSessionFactory ssf = (SqlSessionFactory)ctx.getBean("factory");
		 System.out.println(ssf.openSession().getConnection());
	}
	
/*	public static void main(String[] args) {
		TypeService service = new TypeServiceImpl();
		List<Type> list = service.queryAll();
		for (Type type : list) {
			System.out.println(type.getTypeName());
		}
	}*/
}
