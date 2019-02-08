package cn.mohist.mohism.generator.service;

import cn.mohist.mohism.generator.dataInfo.DataBaseInfo;
import cn.mohist.mohism.generator.mapper.MohismGeneratorMapper;
import cn.mohist.mohism.generator.model.ColumnEntity;
import cn.mohist.mohism.generator.model.TableEntity;
import org.springframework.beans.factory.annotation.Autowired;
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
* 获取mysql数据库信息
*/
 

@Service("mysqlDataBaseService")
public class MysqlDataBaseService extends DataBaseInfo {

	@Autowired
	private MohismGeneratorMapper mohismGeneratorMapper;

	 
	public String queryDatabaseName() {
  		return mohismGeneratorMapper.queryDatabaseName();
	}

 	public List<TableEntity> getTableList() {
		List<TableEntity> tables = mohismGeneratorMapper.queryTableList(null);
	 
		 
		tables.stream().forEach((tableInfo) -> {
			List<ColumnEntity> columns = mohismGeneratorMapper.selectAllColumns(tableInfo.getTableName());
			tableInfo.setColumns(columns);
		});
		return tables;
	}

	 
 

}
