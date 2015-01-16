package org.lop.modules.repository.mybatis.generator.plugins;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

/**
 * 文件名称.
 * 
 * @author 潘瑞峥
 * @date 2014年11月19日
 */
public class ClassNamePlugin extends PluginAdapter {

	@Override
	public boolean validate( List<String> warnings ) {
		return true;
	}

	/**
	 * 文件命名.
	 */
	@Override
	public void initialized( IntrospectedTable introspectedTable ) {
		String oldType = introspectedTable.getBaseRecordType();
		String newType = oldType + "Model";
		String oldMapper = introspectedTable.getMyBatis3JavaMapperType();
		String newMapper = oldMapper.replaceAll( "Mapper$", "Dao" );

		introspectedTable.setBaseRecordType( newType );
		introspectedTable.setExampleType( newType + "Example" );
		introspectedTable.setMyBatis3JavaMapperType( newMapper );
	}

}