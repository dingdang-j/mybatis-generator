package org.lop.modules.repository.mybatis.generator.internal;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * 注释.
 * 
 * @author 潘瑞峥
 * @date 2014年11月19日
 */
public class CommentGenerator extends DefaultCommentGenerator {

	/**
	 * 增加字段的注释.
	 */
	@Override
	public void addFieldComment( Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn ) {
		String comment = null;
		if ( null != introspectedColumn ) {
			comment = introspectedColumn.getRemarks();
		}

		StringBuilder buf = new StringBuilder( "/** " );

		if ( null != comment && !"".equals( comment.trim() ) ) {
			comment = comment.trim();

			buf.append( comment ).append( ". " );
		}

		buf.append( "*/" );

		field.addJavaDocLine( buf.toString() );
	}

	/**
	 * 增加字段的注释.
	 */
	@Override
	public void addFieldComment( Field field, IntrospectedTable introspectedTable ) {
		this.addFieldComment( field, introspectedTable, null );
	}

}