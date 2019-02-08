package cn.mohist.mohism.generator.mapper;


import cn.mohist.mohism.generator.model.ColumnEntity;
import cn.mohist.mohism.generator.model.ReferencedTable;
import cn.mohist.mohism.generator.model.TableEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 飞特超级代码生成器
 * 
 * @author xc
 * @email 171998110@qq.com
 * @date 2018年06月20日 上午9:12:58
 */
@Mapper
public interface MohismGeneratorMapper   {
	List<Map<String, Object>> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	Map<String, String> queryTable(String tableName);
	
	List<Map<String, String>> queryColumns(String tableName);
	
	List<ReferencedTable> queryReferenced(String tableName);
	
	String queryDatabaseName();
	
	List<TableEntity> queryTableList(Map<String, Object> map);
	
	List<ColumnEntity>  selectAllColumns(String tableName);
	
	List<TableEntity> queryOracleTableList(Map<String, Object> map);
	
	List<ColumnEntity>  selectAllOracleColumns(String tableName);
}
