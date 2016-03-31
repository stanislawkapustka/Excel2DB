package pl.skapustka.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//import pl.skapustka.dao.SystemEntDAOImpl;
import pl.skapustka.entities.SystemContract;
import pl.skapustka.entities.SystemEnt;

public class ExcelReader {

	FileInputStream fis;
	XSSFWorkbook myWorkBook;
	XSSFSheet mySheet;
	Row row;
	Cell cell;
	
	public List<SystemEnt> readExcelSys(String fileName) throws FileNotFoundException, IOException {
		fis = new FileInputStream(fileName);
		myWorkBook = new XSSFWorkbook(fis);
		mySheet = myWorkBook.getSheetAt(0);
		List<SystemEnt> listSystem = new ArrayList<SystemEnt>();
		SystemEnt system;
		
		for (int i = 1; i <= mySheet.getLastRowNum(); i++) {
			system = new SystemEnt();
			cell = mySheet.getRow(i).getCell(0);
			String celName = cell.getStringCellValue();
			system.setName(celName);
			listSystem.add(system);
			
		}
		
		return listSystem;
	}
	
	public List<SystemContract> readExcelContract(String fileName) throws FileNotFoundException, IOException {
		fis = new FileInputStream(fileName);
		myWorkBook = new XSSFWorkbook(fis);
		mySheet = myWorkBook.getSheetAt(0);
		List<SystemContract> listSystemContract = new ArrayList<SystemContract>();
		SystemContract systemContract;
		DataFormatter df = new DataFormatter();

		for (int i = 1; i <= mySheet.getLastRowNum(); i++) {
			systemContract = new SystemContract();
			//request
			cell = mySheet.getRow(i).getCell(1);
			String celRequest = df.formatCellValue(cell);
			systemContract.setRequest(celRequest);
			//order_number
			cell = mySheet.getRow(i).getCell(2);
			String celOrderNumber = cell.getStringCellValue();
			systemContract.setOrder_number(celOrderNumber);
			//fromDate
			cell = mySheet.getRow(i).getCell(3);
			Date celFromDate = cell.getDateCellValue();
			systemContract.setFrom_date(celFromDate);
			//toDate
			cell = mySheet.getRow(i).getCell(4);
			Date celToDate = cell.getDateCellValue();
			systemContract.setTo_date(celToDate);
			//amount
			cell = mySheet.getRow(i).getCell(5);
			BigDecimal celAmount = new BigDecimal(cell.getStringCellValue());
			systemContract.setAmount(celAmount);
			//amount_Type
			cell = mySheet.getRow(i).getCell(6);
			String celAmountType = cell.getStringCellValue();
			systemContract.setAmount_type(celAmountType);
			//amount_period
			cell = mySheet.getRow(i).getCell(7);
			String celAmountPeriod = cell.getStringCellValue();
			systemContract.setAmount_period(celAmountPeriod);
			//authorizationPercent
			cell = mySheet.getRow(i).getCell(8);
			BigDecimal celAP = new BigDecimal(cell.getNumericCellValue());
			systemContract.setAuthorization_percent(celAP);
			//active
			cell = mySheet.getRow(i).getCell(8);
			double celActive = cell.getNumericCellValue();
			boolean result;
			if (celActive == 2) result = true;
			else result = false;
			systemContract.setActive(result);
			
			listSystemContract.add(systemContract);
		}
		
		return listSystemContract;
	}
		

}
