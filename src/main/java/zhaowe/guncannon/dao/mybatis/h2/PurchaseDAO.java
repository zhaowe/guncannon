package zhaowe.guncannon.dao.mybatis.h2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
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

import zhaowe.guncannon.mapper.PurchaseItemMapper;
import zhaowe.guncannon.mapper.PurchaseListMapper;
import zhaowe.guncannon.model.PurchaseItem;
import zhaowe.guncannon.model.PurchaseListItem;
import zhaowe.guncannon.util.Logger;

public class PurchaseDAO {
	static SqlSessionFactory factory;
	static SqlSession session;
	public PurchaseDAO() {
		if (null != PurchaseDAO.factory) return;
		String methodName = "PurchaseDAO";
		Logger.infoStarted(methodName);
		
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
		PurchaseDAO.factory = new SqlSessionFactoryBuilder().build(config);
		
		PurchaseDAO.session = PurchaseDAO.factory.openSession();
		try{
			PurchaseItemMapper mapper = session.getMapper(PurchaseItemMapper.class);
			PurchaseItem p;
			
			mapper.build();

			SimpleDateFormat df = new SimpleDateFormat("yy/MM/dd");
			p = new PurchaseItem();
			p.setAmount(36);
			p.setCategory("辅材");
			p.setId("5001");
			p.setName("保丽龙大板");
			p.setOrigin("CAAA1");
			p.setPhoneNo("CAAA1");
			p.setPrice(180.0);
			p.setPurchaser("陈村花湾城");
			p.setPurchasingDate(df.parse("16/10/31"));
			p.setSpecification("14KG2*1*0.56M");
			p.setUnit("PCS");
			p.setVendor("吴祝福");

			mapper.put(p);

			p = new PurchaseItem();
			p.setAmount(6);
			p.setCategory("辅材");
			p.setId("5002");
			p.setName("预埋件十厘钢板大板");
			p.setOrigin("CAAB1");
			p.setPhoneNo("138 0283 6677");
			p.setPrice(62.8);
			p.setPurchaser("陈村花湾城");
			p.setPurchasingDate(df.parse("16/09/29"));
			p.setSpecification("400*250");
			p.setUnit("件");
			p.setVendor("浩海装饰(陈如华)");

			mapper.put(p);

			p = new PurchaseItem();
			p.setAmount(120);
			p.setCategory("管材");
			p.setId("4001");
			p.setName("联塑线管");
			p.setOrigin("佛山");
			p.setPhoneNo("159 1455 6588");
			p.setPrice(6.86);
			p.setPurchaser("陈村花湾城");
			p.setPurchasingDate(df.parse("16/10/31"));
			p.setSpecification("25*4M*A");
			p.setUnit("条");
			p.setVendor("郑扬贵");

			mapper.put(p);
		} catch (ParseException e) {
			e.printStackTrace();
		}
//		} finally {
//			session.close();
//		}
		Logger.infoFinished(methodName);
	}

	public Collection<PurchaseListItem> getAll() {
//		SqlSession session = PurchaseDAO.factory.openSession();
		Collection<PurchaseListItem> items;
		String methodName = "getAll";

		Logger.infoStarted(methodName);
		
		try{
			PurchaseListMapper listMapper = PurchaseDAO.session.getMapper(PurchaseListMapper.class);
			items = listMapper.getAll();
		} finally {
//			session.close();
		}
		Logger.infoFinished(methodName);
		return items;		
	}

	public PurchaseItem get(String key) {
		String methodName = "get " + key;
		Logger.infoStarted(methodName);

//		SqlSession session = PurchaseDAO.factory.openSession();
		PurchaseItem item;
		
		try{
			PurchaseItemMapper mapper = PurchaseDAO.session.getMapper(PurchaseItemMapper.class);
			item = mapper.get(key);
		} finally {
//			session.close();
		}
		Logger.infoFinished(methodName);
		return item;		
	}
	
}
