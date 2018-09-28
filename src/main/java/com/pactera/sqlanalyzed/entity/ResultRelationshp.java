package com.pactera.sqlanalyzed.entity;

/**
 * 
 ************类说明**************
 * 类名：ResultRelationshp
 * 建类时间：2018年9月27日 下午5:27:56
 * 类描述：解析结果
 */
public class ResultRelationshp {

	private String syscode;
	private String schema;
	private String proName;
	private String targetSchema;
	private String targetTable;
	private String targetColumn;
	private String sourceSchema;
	private String sourceTable;
	private String sourceColumn;
	public String getSyscode() {
		return syscode;
	}
	public void setSyscode(String syscode) {
		this.syscode = syscode==null?null:syscode.trim();
	}
	public String getSchema() {
		return schema;
	}
	public void setSchema(String schema) {
		this.schema = schema==null?null:schema.trim();
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName==null?null:proName.trim();
	}
	public String getTargetSchema() {
		return targetSchema;
	}
	public void setTargetSchema(String targetSchema) {
		this.targetSchema = targetSchema==null?null:targetSchema.trim();
	}
	public String getTargetTable() {
		return targetTable;
	}
	public void setTargetTable(String targetTable) {
		this.targetTable = targetTable==null?null:targetTable.trim();
	}
	public String getTargetColumn() {
		return targetColumn;
	}
	public void setTargetColumn(String targetColumn) {
		this.targetColumn = targetColumn==null?null:targetColumn.trim();
	}
	public String getSourceSchema() {
		return sourceSchema;
	}
	public void setSourceSchema(String sourceSchema) {
		this.sourceSchema = sourceSchema==null?null:sourceSchema.trim();
	}
	public String getSourceTable() {
		return sourceTable;
	}
	public void setSourceTable(String sourceTable) {
		this.sourceTable = sourceTable==null?null:sourceTable.trim();
	}
	public String getSourceColumn() {
		return sourceColumn;
	}
	public void setSourceColumn(String sourceColumn) {
		this.sourceColumn = sourceColumn==null?null:sourceColumn.trim();
	}
	
	
	
	
}
