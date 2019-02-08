package cn.mohist.mohism.generator.service;

import cn.mohist.mohism.generator.dataInfo.DataBaseInfo;
import cn.mohist.mohism.generator.mapper.MohismGeneratorMapper;
import cn.mohist.mohism.generator.model.ColumnEntity;
import cn.mohist.mohism.generator.model.TableEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/** 
* @author  作者  freeter E-mail: 171998110@qq.com
* @date 创建时间：2018年7月9日 上午10:30:15 
* @version 1.0 
* @parameter  
* @since  
* @return  
* 
* 获取oracle数据库信息
*/
 

@Service("oracleDataBaseService")
public class OracleDataBaseService extends DataBaseInfo {
	 
	@Autowired
	private MohismGeneratorMapper mohismGeneratorMapper;

	@Value("${spring.datasource.username}")
	private String databaseName;
	

	@Override
	public String queryDatabaseName() {
		// TODO Auto-generated method stub
		return databaseName;
	}

	@Override
	public List<TableEntity> getTableList() {
		List<TableEntity> tables = mohismGeneratorMapper.queryOracleTableList(null);
		 
		 
		tables.stream().forEach((tableInfo) -> {
			List<ColumnEntity> columns = mohismGeneratorMapper.selectAllOracleColumns(tableInfo.getTableName());
			tableInfo.setColumns(columns);
		});
		return tables;
	}
	 
}
