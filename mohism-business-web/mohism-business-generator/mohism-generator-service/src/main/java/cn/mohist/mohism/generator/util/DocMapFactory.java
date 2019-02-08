package cn.mohist.mohism.generator.util;

import cn.mohist.mohism.generator.model.TableEntity;
import cn.mohist.mohism.generator.service.MysqlDataBaseService;
import cn.mohist.mohism.generator.service.OracleDataBaseService;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DocMapFactory {

	public static Map build() throws SQLException{
		Map map = new HashMap();
		DataSource dataSource =(DataSource) SpringContextUtils.getBean("dataSource");
		String databaseProductName = dataSource.getConnection().getMetaData().getDatabaseProductName();
		 if(("MySQL").equals(databaseProductName)){
				
			MysqlDataBaseService mysqlDataBaseService = (MysqlDataBaseService) SpringContextUtils.getBean("mysqlDataBaseService");
  				String databaseName = mysqlDataBaseService.queryDatabaseName();
				List<TableEntity> tableInfos = mysqlDataBaseService.getTableList();
 			
				map.put("tableInfos", tableInfos);
				map.put("databaseName", databaseName);
				 
		 		 
		 } else  if(("Oracle").equals(databaseProductName)){
				
			 OracleDataBaseService oracleDataBaseService = (OracleDataBaseService) SpringContextUtils.getBean("oracleDataBaseService");
				String databaseName = oracleDataBaseService.queryDatabaseName();
				List<TableEntity> tableInfos = oracleDataBaseService.getTableList();
			
				map.put("tableInfos", tableInfos);
				map.put("databaseName", databaseName);
				 
		 		 
		 } 
		 
		 return map;
	}
}
