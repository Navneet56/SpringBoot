package com.zee.zee5app.utils;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class CustomTableNameStrategy extends PhysicalNamingStrategyStandardImpl {
	//PhysicalNamingStrategyStandardImpl we provide custom name table column schema
	//toPhysicalTableName override
	// identifier database object
	// jdbcEnvironment meata data of database 
	private final static String POSTFIX="_table";
	@Override
	public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment context) {
		
		// TODO Auto-generated method stub
		String tableName = identifier.getText()+POSTFIX;
		return identifier.toIdentifier(tableName);
	}

}
