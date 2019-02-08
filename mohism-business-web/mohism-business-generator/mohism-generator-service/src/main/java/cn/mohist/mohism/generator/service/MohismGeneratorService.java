
package cn.mohist.mohism.generator.service;

import cn.mohist.mohism.generator.mapper.MohismGeneratorMapper;
import cn.mohist.mohism.generator.model.ReferencedTable;
import cn.mohist.mohism.generator.util.GenUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipOutputStream;

/**
 * 飞特超级代码生成器
 * 
 * @author xc
 * @email 171998110@qq.com
 * @date 2018年06月20日 上午10:06:50
 */
@Service
public class MohismGeneratorService {
	@Autowired
	private MohismGeneratorMapper mohismGeneratorMapper;

	public List<Map<String, Object>> queryList(Map<String, Object> map) {
		return mohismGeneratorMapper.queryList(map);
	}

	public int queryTotal(Map<String, Object> map) {
		return mohismGeneratorMapper.queryTotal(map);
	}

	public Map<String, String> queryTable(String tableName) {
		return mohismGeneratorMapper.queryTable(tableName);
	}

	public List<Map<String, String>> queryColumns(String tableName) {
		return mohismGeneratorMapper.queryColumns(tableName);
	}
 
	public List<ReferencedTable> queryReferenced(String tableName) {
		return mohismGeneratorMapper.queryReferenced(tableName);
	}
	
	public byte[] generatorCode(String[] tableNames) throws IOException {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		ZipOutputStream zip = new ZipOutputStream(outputStream);

		for (String tableName : tableNames) {
			// 查询表信息
			Map<String, String> table = queryTable(tableName);
			// 查询列信息
			List<Map<String, String>> columns = queryColumns(tableName);
			//查询关联表的信息
			List<ReferencedTable> listReferencedTable =  queryReferenced(tableName);
			// 生成代码
			GenUtils.generatorCode(table,listReferencedTable, columns, zip);
		}
		IOUtils.closeQuietly(zip);
		return outputStream.toByteArray();
	}

	public void generatorAllCode(String[] tableNames) throws IOException {

		for (String tableName : tableNames) {
			// 查询表信息
			Map<String, String> table = queryTable(tableName);
			// 查询列信息
			List<Map<String, String>> columns = queryColumns(tableName);
			//查询关联表的信息
			List<ReferencedTable> listReferencedTable =  queryReferenced(tableName);
			// 生成代码
			GenUtils.generatorAllCode(table,listReferencedTable, columns);
		}
	}

	public void generatorApiCode(String[] tableNames) throws IOException {

		for (String tableName : tableNames) {
			// 查询表信息
			Map<String, String> table = queryTable(tableName);
			// 查询列信息
			List<Map<String, String>> columns = queryColumns(tableName);
			//查询关联表的信息
			List<ReferencedTable> listReferencedTable =  queryReferenced(tableName);
			// 生成代码
			GenUtils.generatorApiCode(table,listReferencedTable, columns);
		}
	}

	public void updateCode(String[] tableNames) throws IOException {

		for (String tableName : tableNames) {
			// 查询表信息
			Map<String, String> table = queryTable(tableName);
			// 查询列信息
			List<Map<String, String>> columns = queryColumns(tableName);
			//查询关联表的信息
			List<ReferencedTable> listReferencedTable =  queryReferenced(tableName);
			// 生成代码
			GenUtils.updateCode(table,listReferencedTable, columns);
		}

	}
}
