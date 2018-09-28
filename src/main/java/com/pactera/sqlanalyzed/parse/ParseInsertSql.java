package com.pactera.sqlanalyzed.parse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	 */
	public Set<ResultRelationshp> parse(String syscode,String schema,String proName,String sqlText){
		
		
		return null;
	}
	
}
