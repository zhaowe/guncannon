package zhaowe.guncannon.test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.ibatis.datasource.pooled.PooledDataSourceFactory;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Ignore;
import org.junit.Test;

import zhaowe.guncannon.mapper.PurchaseItemMapper;
import zhaowe.guncannon.mapper.PurchaseListMapper;
import zhaowe.guncannon.model.PurchaseItem;
import zhaowe.guncannon.model.PurchaseListItem;
import zhaowe.guncannon.util.Logger;

public class PurchaseItemDaoTest {

	SqlSessionFactory factory;
//	SqlSession session;
	
	@Ignore
	@Test
	public void tearUp() {
		Properties props = new Properties();
		props.setProperty("driver", "org.h2.Driver");
		props.setProperty("url", "jdbc:h2:mem:");
		props.setProperty("username", "sa");
		props.setProperty("password", "");

		DataSourceFactory factory = new PooledDataSourceFactory();
		factory.setProperties(props);
		
		String id = "purchaseDataSource";
		
		TransactionFactory transactionFactory = new JdbcTransactionFactory();

		DataSource dataSource = factory.getDataSource();
		Environment environment = new Environment(id, transactionFactory, dataSource);
		
		Configuration config = new Configuration(environment);
		config.addMapper(PurchaseItemMapper.class);
		config.addMapper(PurchaseListMapper.class);
		this.factory = new SqlSessionFactoryBuilder().build(config);
		SqlSession session = this.factory.openSession();
		try{
			PurchaseItemMapper mapper = session.getMapper(PurchaseItemMapper.class);
			PurchaseItem item;
			
			mapper.build();
			
			item = new PurchaseItem();
			item.setAmount(11.2);
			String category = "辅件";
			item.setCategory(category);
			String name = "大管";
			item.setName(name);
			String origin = "陈村";
			item.setOrigin(origin);
			String phone = "18675860045";
			item.setPhoneNo(phone);
			double price = 2.5;
			item.setPrice(price);
			String purchaser = "花港湾";
			item.setPurchaser(purchaser);
			Date purchasingDate = Calendar.getInstance().getTime();
			item.setPurchasingDate(purchasingDate);
			String specification = "100";
			item.setSpecification(specification);
			String unit = "米";
			item.setUnit(unit);
			String vendor = "马可波罗";
			item.setVendor(vendor);
			mapper.put(item);
			
			PurchaseListMapper listMapper = session.getMapper(PurchaseListMapper.class);
			List<PurchaseListItem> items = listMapper.getAll();
			
			String methodName = "testListMapper";
			String message = String.valueOf(items.size());
			Logger.info(methodName, message);
		} finally {
			session.close();
		}
	}
}
