package com.pactera.sqlanalyzed.entity;

/**
 * 
 ************类说明**************
 * 类名：ColumnNode
 * 建类时间：2018年9月27日 下午5:10:30
 * 类描述：字段节点实体类
 */
public class ColumnNode {

	private String syscode;
	
	private String schema;
	
	private String tableName;
	
	private String columnName;

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

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	
	
}
