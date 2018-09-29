package com.pactera.sqlanalyzed.parse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sf.jsqlparser.JSQLParserException;

import org.apache.commons.io.IOUtils;





import com.pactera.sqlanalyzed.utils.Check;

/**
 * 
 ************类说明**************
 * 类名：GetInsertSqlByFile
 * 建类时间：2018年9月28日 上午9:16:48
 * 类描述：通过读txt文件来获取sql语句
 */
public class GetInsertSqlByFile {

	private int fileMaxSize = 10485760;
	
	/**
     * 文件编码
     */
    private String fileEncoder = "UTF-8";
    /**
     * sql语句
     */
    private String sqlText;
    /**
     * insert语句
     */
    private String inserSql;
    /**
     * insert语句的个数
     */
    private int sqlNumber;
    
    private String proName;
    
    private String syscode;
    
    private String schema;
    
    private String INSERT_REG = "(INSERT INTO[\\s\\S]*?;)";
    /**
     * 去掉单行注释 
     */
    private static final String SIGLE_COMMENT ="/\\*.*?\\*/";
    /**
     * 去掉多行注释
     */
    private static final String BLOCK_COMMENT="/\\*[\\s\\S]*?\\*/";
    
    /**
     * 去掉单行注释 --
     */
    private static final String LINE_COMMENT="--.*";
    /**
     * 
     * 方法说明：通过文件路径得到存储过程语句
     * 方法名：GetProcedureByFile
     * @param filePath 
     * 返回值：void
     */
	@SuppressWarnings("resource")
	public void GetProcedureByFile(String filePath){
		
		String[] str = filePath.split("-");
		syscode = str[0];
		schema = str[1];
		proName = str[2];
		
		try {
			FileInputStream fis = new FileInputStream(new File(filePath));
			if(fis.available()> fileMaxSize){
				throw new RuntimeException(String.format("The file exceeds the maximum limit,filePath:%s, fileSize:%d, fileMaxSize:%d", filePath, fis.available(), fileMaxSize));
			}
			byte[] buffer = new byte[fis.available()];
			IOUtils.readFully(fis, buffer);
			sqlText = new String(buffer, fileEncoder);
			fis.close();
			sqlText = sqlText.replaceAll(SIGLE_COMMENT,"").replaceAll(BLOCK_COMMENT, "").replaceAll(LINE_COMMENT, "");
		}catch (IOException e) {
			throw new RuntimeException("file read error.", e);
		}
	}
	/**
	 * 
	 * 方法说明：得到insert语句
	 * 方法名：GetInsertSqlByReg 
	 * 返回值：void
	 * @throws JSQLParserException 
	 */
	public  void GetInsertSqlByReg() throws JSQLParserException{
		if(Check.isEmpty(sqlText)){
			System.out.println("存储过程为空");
			return;
		}
		Pattern pattern = Pattern.compile(INSERT_REG);
		Matcher  matcher = pattern.matcher(sqlText);
		long time = System.currentTimeMillis();
		while(matcher.find()){
			System.out.println("Group 1:"+matcher.group(1));
			inserSql = matcher.group(1);
			//解析insert语句
			ParseInsertSql parseInsertSsql = new ParseInsertSql();
			parseInsertSsql.parse(syscode,schema,proName,inserSql);
			sqlNumber++;
			inserSql = "";
		}
		System.out.println("存储过程"+proName+"一共包含 "+sqlNumber+"个insert语句,解析总耗时："+(System.currentTimeMillis() - time)/1000);
	}
	
	public static void main(String[] args) {
		
        String path = "G:/procedure_path/EDWTST-STAS_ETL-SP_S_03_CORP_LOAN_DUBIL.txt";
        GetInsertSqlByFile gisbf = new GetInsertSqlByFile();
        gisbf.GetProcedureByFile(path);
        try {
			gisbf.GetInsertSqlByReg();
		} catch (JSQLParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
