package com.sis.eims4.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.sis.eims4.dao.SearchDao;
import com.sis.eims4.dao.impl.SearchDaoImpl;
import com.sis.eims4.entity.Condition;
import com.sis.eims4.entity.Dept;
import com.sis.eims4.entity.EmpDto;
import com.sis.eims4.service.SearchService;
import com.sis.eims4.util.CommonUtil;
/**
 * 検索
 * @author test01
 *
 */
public class SearchSerImpl implements SearchService {
	SearchDao dao = new SearchDaoImpl();
	/**
	 * ダウンロード
	 * @param empList        社員情報
	 * @param outputStream   出力ストリーム
	 * @return               result
	 * @throws Exception
	 */
	public boolean printToExcelFile(List<EmpDto> empList,OutputStream outputStream,String applicationPath)throws Exception{
		HSSFWorkbook inWorkbook = new HSSFWorkbook(new FileInputStream(new File(applicationPath)));
		//获取sheet1
		HSSFSheet inSheet = inWorkbook.getSheetAt(0);
		HSSFWorkbook outWorkbook = new HSSFWorkbook();
		//创建sheet
		HSSFSheet outSheet = outWorkbook.createSheet();
		HSSFRow inRow,outRow;
		HSSFCell outCell;
		inRow = inSheet.getRow(0);
		outRow = outSheet.createRow(0);
		outRow.setHeight(inRow.getHeight());
		//文件首行
		for(int j=0;j<inRow.getLastCellNum();j++){
            outCell = getOutCell(outWorkbook, inRow,outRow, j);
        	outCell.setCellType(HSSFCell.CELL_TYPE_STRING);
        	//设置单元格的值
        	outCell.setCellValue(inRow.getCell(j).getStringCellValue());
		}
		//将数据库查询到的值写入
		for(int i=0;i<empList.size();i++){
			inRow = inSheet.getRow(1);
			outRow = outSheet.createRow(i+1);
			outRow.setHeight(inRow.getHeight());
			EmpDto empDto = empList.get(i);
			//社員ID
            outCell = getOutCell(outWorkbook, inRow,outRow, 0);
        	outCell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
        	outCell.setCellValue(empDto.getEmpno());
        	//氏名
        	outCell = getOutCell(outWorkbook, inRow,outRow, 1);
        	outCell.setCellType(HSSFCell.CELL_TYPE_STRING);
        	outCell.setCellValue(empDto.getEname());
        	//仕事
        	outCell = getOutCell(outWorkbook, inRow,outRow, 2);
        	outCell.setCellType(HSSFCell.CELL_TYPE_STRING);
        	outCell.setCellValue(empDto.getJob());
        	//上司
        	outCell = getOutCell(outWorkbook, inRow,outRow, 3);
        	outCell.setCellType(HSSFCell.CELL_TYPE_STRING);
        	outCell.setCellValue(empDto.getMgrname());
        	//年俸
        	outCell = getOutCell(outWorkbook, inRow,outRow, 4);
        	outCell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
        	outCell.setCellValue(empDto.getAnnualSal());
        	//部門
        	outCell = getOutCell(outWorkbook, inRow,outRow, 5);
        	outCell.setCellType(HSSFCell.CELL_TYPE_STRING);
        	outCell.setCellValue(empDto.getDname());
         }

		outWorkbook.write(outputStream);

		return true;

	}
	/**
	 * ダウンロード
	 * @param empList        社員情報
	 * @param outputStream   出力ストリーム
	 * @throws Exception
	 */
	public void printToCsvFile(List<EmpDto> empList,OutputStream outputStream)throws Exception{
		String str = "社員ID,社員名,仕事,上司 ,年俸,所属部門\n";
		outputStream.write(str.getBytes("shift_jis"));
		for (EmpDto empDto : empList) {
			str = empDto.getEmpno()+","+empDto.getEname()+","+
						CommonUtil.nvlString(empDto.getJob())+","+
						CommonUtil.nvlString(empDto.getMgrname())+","+
						CommonUtil.nvlString(empDto.getAnnualSal())+","+
						CommonUtil.nvlString(empDto.getDname())+"\n";
			outputStream.write(str.getBytes("shift_jis"));
		}


	}
	/**
	 * 设置输出单元格的格式
	 * @param outWorkbook   Excel文件夹
	 * @param inRow         要读取的模板的行
	 * @param outRow        要输出的行
	 * @param i             第i列
	 * @return              设置好格式的单元格
	 */
	public HSSFCell getOutCell(HSSFWorkbook outWorkbook,HSSFRow inRow,HSSFRow outRow,int i){
		HSSFCell inCell = inRow.getCell(i);
		HSSFCellStyle inCellStyle = inCell.getCellStyle();
		HSSFCellStyle outCellStyle = outWorkbook.createCellStyle();
        outCellStyle.cloneStyleFrom(inCellStyle);
        HSSFCell outCell = outRow.createCell(i);
        outCell.setCellStyle(outCellStyle);
        return outCell;
	}
	/**
	 * 検索部門情報
	 * @return               部門情報
	 * @throws Exception
	 */
	public List<Dept> findDepts() throws Exception {
		return dao.findDepts();
	}

	/**
	 * 検索社員情報
	 * @return               社員情報
	 * @throws Exception
	 */
	public List<EmpDto> findEmps(Condition condition) throws Exception {
		return dao.findEmps(condition);
	}
	/**
	 * 検索社員情報全件数
	 * @return               社員情報総本数
	 * @throws Exception
	 */
	public int countResult(Condition condition) throws Exception {
		return dao.countResult(condition);
	}

	/**
	 * 検索部門情報
	 * @param deptno         部門ID
	 * @return               部門情報
	 * @throws Exception
	 */
	public Dept findDeptById(int deptno) throws Exception {
		return  dao.findDeptById(deptno);
	}


}
