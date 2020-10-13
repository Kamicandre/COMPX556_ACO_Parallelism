package COMPX556.Adrien_1276832_Billy_1298073;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	private static final String NAME = "../../10x10_Test_Template.xlsx";
	private static List<String> ant = new ArrayList<String>();
	static BOX box;
	static ArrayList<BOX> boxA = new ArrayList<BOX>();
	public static void main(String[] args) {
		try {
			FileInputStream file = new FileInputStream(new File(NAME));
			Workbook workbook = new XSSFWorkbook(file);
			DataFormatter dataFormatter = new DataFormatter();
			Iterator<Sheet> sheets = workbook.sheetIterator();
			int r = 0;
			int c = 0;
			while(sheets.hasNext()) {
				Sheet sh = sheets.next();
				System.out.println("Sheet name is " + sh.getSheetName());
				System.out.println("------");
				Iterator<Row> iterator = sh.iterator();
				while(iterator.hasNext()) {
					Row row = iterator.next();
					r = r++;
					Iterator<Cell> cellIterator = row.iterator();
					while (cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						c = c++;
						String cellValue = dataFormatter.formatCellValue(cell);
//						if(cell.getCellType() == CellType.STRING) {
//						}
						box = new BOX(cellValue, r, c);
						boxA.add(box);
						ant.add(cellValue);
						System.out.print(cellValue+"\t");
					}
					System.out.println();
				}
			}
			workbook.close();
			for(int i=0;i<ant.size();i++){
				System.out.print(ant.get(i));
			}
			System.out.println(ant);
		}
		catch(Exception error){
			error.printStackTrace();
		}
	}
	
	public List<String> getList() {
		main(null);
		return ant;
	}
	
	public ArrayList<BOX> getBox() {
		main(null);
		return boxA;
	}
}

/////////////////////////////////////////////////////////////////////////////////////////////

class BOX{
	private String value;
	private int row;
	private int column;
	
	public BOX(String v, int r, int c) {
		this.value = v;
		this.row = r;
		this.column = c;
	}
	
	public String getValue() {
		return this.value;
	}
	
	public int getRow() {
		return this.row;
	}
	
	public int getColumn() {
		return this.column;
	}
}