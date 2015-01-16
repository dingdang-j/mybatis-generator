package org.lop.modules.repository.mybatis.generator.plugins;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * 增加Model父类.
 * 
 * @author 潘瑞峥
 * @date 2014年11月19日
 */
public class SuperclassPlugin extends PluginAdapter {

	private FullyQualifiedJavaType superclass;

	public SuperclassPlugin() {
		super();
		superclass = new FullyQualifiedJavaType( "com.hz.modules.repository.mybatis.BaseModel" );
	}

	@Override
	public boolean validate( List<String> warnings ) {
		return true;
	}

	@Override
	public boolean modelBaseRecordClassGenerated( TopLevelClass topLevelClass, IntrospectedTable introspectedTable ) {
		makeSerializable( topLevelClass, introspectedTable );
		return true;
	}

	@Override
	public boolean modelPrimaryKeyClassGenerated( TopLevelClass topLevelClass, IntrospectedTable introspectedTable ) {
		makeSerializable( topLevelClass, introspectedTable );
		return true;
	}

	@Override
	public boolean modelRecordWithBLOBsClassGenerated( TopLevelClass topLevelClass, IntrospectedTable introspectedTable ) {
		makeSerializable( topLevelClass, introspectedTable );
		return true;
	}

	protected void makeSerializable( TopLevelClass topLevelClass, IntrospectedTable introspectedTable ) {
		topLevelClass.addImportedType( superclass );
		topLevelClass.setSuperClass( superclass );

		Field field = new Field();
		field.setFinal( true );
		field.setInitializationString( "1L" );
		field.setName( "serialVersionUID" );
		field.setStatic( true );
		field.setType( new FullyQualifiedJavaType( "long" ) );
		field.setVisibility( JavaVisibility.PRIVATE );
		context.getCommentGenerator().addFieldComment( field, introspectedTable );

		topLevelClass.addField( field );
	}

}