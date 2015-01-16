package org.lop.modules.repository.mybatis.generator.plugins;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;

/**
 * 初始化方法插件.
 * 
 * @author 潘瑞峥
 * @date 2014年11月20日
 */
public class InitPlugin extends PluginAdapter {

	@Override
	public boolean validate( List<String> warnings ) {
		return true;
	}

	/**
	 * 初始化.
	 */
	@Override
	public void initialized( IntrospectedTable introspectedTable ) {
		this.changeMethodName( introspectedTable );
	}

	/**
	 * 更改方法名称.
	 */
	private void changeMethodName( IntrospectedTable introspectedTable ) {
		introspectedTable.setSelectByPrimaryKeyStatementId( "find" );
		introspectedTable.setInsertStatementId( "create" );
		introspectedTable.setUpdateByPrimaryKeyStatementId( "update" );

		introspectedTable.setBaseResultMapId( "Result" );
		introspectedTable.setBaseColumnListId( "Columns" );
		introspectedTable.setUpdateByPrimaryKeyStatementId( "update" );
		introspectedTable.setUpdateByPrimaryKeySelectiveStatementId( "updateProperties" );
		introspectedTable.setDeleteByPrimaryKeyStatementId( "delete" );
	}

}