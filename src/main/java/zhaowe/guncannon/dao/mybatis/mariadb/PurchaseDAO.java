package zhaowe.guncannon.dao.mybatis.mariadb;

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

	public PurchaseDAO() {
		if (null != PurchaseDAO.factory) return;
		String methodName = "PurchaseDAO";
		Logger.infoStarted(methodName);
		
		Properties props = new Properties();
		props.setProperty("driver", "org.mariadb.jdbc.Driver");
		props.setProperty("url", "jdbc:mysql://localhost:3306/guncannon");
		props.setProperty("username", "root");
		props.setProperty("password", "wayne");

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
		
		Logger.infoFinished(methodName);
	}

	public Collection<PurchaseListItem> getAll() {
		SqlSession session = PurchaseDAO.factory.openSession();
		Collection<PurchaseListItem> items;
		String methodName = "getAll";

		Logger.infoStarted(methodName);
		
		try{
			PurchaseListMapper listMapper = session.getMapper(PurchaseListMapper.class);
			items = listMapper.getAll();
		} finally {
			session.close();
		}
		Logger.infoFinished(methodName);
		return items;		
	}

	public PurchaseItem get(String key) {
		String methodName = "get " + key;
		Logger.infoStarted(methodName);

		SqlSession session = PurchaseDAO.factory.openSession();
		PurchaseItem item;
		
		try{
			PurchaseItemMapper mapper = session.getMapper(PurchaseItemMapper.class);
			item = mapper.get(key);
		} finally {
			session.close();
		}
		Logger.infoFinished(methodName);
		return item;		
	}
	
}
