package com.pactera.sqlanalyzed.entity;

/**
 * 
 ************类说明**************
 * 类名：TableNode
 * 建类时间：2018年9月27日 下午4:50:07
 * 类描述：表的实体类
 */
public class TableNode {

	private String syscode;
	
	private String schema;
	
	private String tableName;
	
	private String tableAlia;

	public String getSyscode() {
		return syscode;
	}

	public void setSyscode(String syscode) {
		this.syscode = syscode;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableAlia() {
		return tableAlia;
	}

	public void setTableAlia(String tableAlia) {
		this.tableAlia = tableAlia;
	}
	
	
}
