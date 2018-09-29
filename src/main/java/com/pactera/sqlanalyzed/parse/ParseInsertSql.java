package com.pactera.sqlanalyzed.parse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.SelectBody;
import net.sf.jsqlparser.statement.select.SelectItem;
import net.sf.jsqlparser.statement.select.SetOperationList;
import net.sf.jsqlparser.statement.select.WithItem;

import org.springframework.util.CollectionUtils;

import com.pactera.sqlanalyzed.entity.ColumnNode;
import com.pactera.sqlanalyzed.entity.ResultRelationshp;
import com.pactera.sqlanalyzed.entity.TableNode;

/**
 * 
 ************类说明**************
 * 类名：ParseInsertSql
 * 建类时间：2018年9月27日 下午4:27:02
 * 类描述：解析存储过程中的insert语句
 */
public class ParseInsertSql {

	private static final String SPLIT_DOT = ".";
	
	/**
	 * 存储目标表的字段 INSERT INTO (col1,col2..) [...]
	 */
	private List<ColumnNode> insertColumns = new ArrayList<ColumnNode>();
	/**
	 * 存储来源表的字段  SELECT col1,col2..
	 */
	private List<ColumnNode> itemColumns = new ArrayList<ColumnNode>();
	/**
	 * 临时存放select字段
	 */
	private List<String> itemsTemp = new ArrayList<String>();
	/**
	 * 目标表
	 */
	private TableNode targetTable = new TableNode();
	
	/**
	 * 来源表集合
	 */
	private Set<TableNode> sourceTables = new HashSet<TableNode>();
	
	/**
	 * 结果集和
	 */
	private Set<ResultRelationshp> resultRelationships = new HashSet<ResultRelationshp>();
	
	/**
	 * 
	 * 方法说明：sql解析
	 * 方法名：parse
	 * @param sqlText
	 * @return 
	 * 返回值：Set<ResultRelationshp>
	 * @throws JSQLParserException 
	 */
	public Set<ResultRelationshp> parse(String syscode,String schema,String proName,String sqlText) throws JSQLParserException{
		Insert insert = (Insert) CCJSqlParserUtil.parse(sqlText);
		targetTable.setSchema(insert.getTable().getSchemaName());
		targetTable.setTableName(insert.getTable().getName());
		dealWithColumns(insert.getColumns());
		prepareParseInsert(insert);
		beginParseInsert(insert);
		return null;
	}

	/**
	 * 
	 * 方法说明：将目标字段存储起来
	 * 方法名：dealWithColumns
	 * @param insert 
	 * 返回值：void
	 */
	private void dealWithColumns(List<Column> columns) {
		
		System.out.println("一共"+columns.size()+"字段");
		for (Column column : columns) {
			ColumnNode columnNode = new ColumnNode();
			columnNode.setColumnName(column.getColumnName());
			insertColumns.add(columnNode);
		}
	}

	/**
	 * 
	 * 方法说明：开始解析sql
	 * 方法名：beginParseInsert
	 * @param insert 
	 * 返回值：void
	 */
	private void beginParseInsert(Insert insert) {
		SelectBody sts = insert.getSelect().getSelectBody();
		if(sts instanceof PlainSelect){
			parsePlainSelect((PlainSelect)sts);
		}else if(sts instanceof SetOperationList){//包含union all 
			
		}
	}

	/**
	 * 
	 * 方法说明：解析plainselect语句
	 * 方法名：parsePlainSelect
	 * @param sts 
	 * 返回值：void
	 */
	private void parsePlainSelect(PlainSelect sts) {
		
		//处理select字段
		dealWithSelectItems(sts);
		
		
		System.out.println("-----------");
	}

	/**
	 * 
	 * 方法说明：处理查询字段
	 * 方法名：dealWithSelectItems
	 * @param sts 
	 * 返回值：void
	 */
	private void dealWithSelectItems(PlainSelect sts) {
		if(sts.toString().contains("SELECT *")){
			System.out.println("从数据库中查找字段");
			return;
		}
		List<SelectItem> selects = sts.getSelectItems();
		int i=0;
		for (SelectItem selectItem : selects) {
			
		}
	}

	/**
	 * 
	 * 方法说明：准备解析
	 * 方法名：preparePareseInsert
	 * @param sqlText 
	 * 返回值：void
	 */
	private void prepareParseInsert(Insert insert) {
		if(CollectionUtils.isEmpty(insert.getSelect().getWithItemsList())){
			return;
		}
		List<WithItem> withItemsList = insert.getSelect().getWithItemsList();
	}
	
}
