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
	//Provide excel file location
	private static final String NAME = "30x30_Test_Template.xlsx";
	private static int maxR = 30;
	private static int maxC = 30;
	//Initialise Variable
	private static List<String> ant = new ArrayList<String>();
	static BOX box;
	static ArrayList<BOX> boxA = new ArrayList<BOX>();
	static MAP map = new MAP(maxR,maxC);
	public static void main(String[] args) {
		try {
			
			FileInputStream file = new FileInputStream(new File(NAME)); //FileInputStream from excel file location
			Workbook workbook = new XSSFWorkbook(file); //New Workbook
			DataFormatter dataFormatter = new DataFormatter(); //New DataFormatter
			Iterator<Sheet> sheets = workbook.sheetIterator(); //New Iterator to go through workbook sheet
			map.initializeTable();
			//While there's still data
			while(sheets.hasNext()) {
				//Go to next sheet
				Sheet sh = sheets.next();
				System.out.println("Original Map");
				//Iterator to go through sheet rows
				Iterator<Row> iterator = sh.iterator();
				//While there are still rows
				while(iterator.hasNext()) {
					//Go to next row
					Row row = iterator.next();
					//Iterator to go through row's column cells
					Iterator<Cell> cellIterator = row.iterator();
					//While there are still column
					while (cellIterator.hasNext()) {
						//Go to next column cell
						Cell cell = cellIterator.next();
						//Extract Cell value, row number & column number
						String cellValue = dataFormatter.formatCellValue(cell);
						int rowN = cell.getRowIndex();
						int colN = cell.getColumnIndex();
						//Create new box of extracted value, row number and column number
						box = new BOX(cellValue, rowN, colN);
						map.setTableValue(rowN, colN, cellValue);
						//Add box to BOX Array
						boxA.add(box);
						//Add cell value to ant list
						ant.add(cellValue);
						//Print current cell value
						System.out.print(cellValue+" ");
					}
					System.out.println();
				}
			}
			//Close Workbook
			workbook.close();
			//System.out.println(ant);
		}
		//Catch Error
		catch(Exception error){
			error.printStackTrace();
		}
	}
	//Return cellvalue list
	public List<String> getList() {
		main(null);
		return ant;
	}
	//Return BOX Array
	public ArrayList<BOX> getBox() {
		main(null);
		return boxA;
	}
	
	public MAP getMap() {
		main(null);
		return map;
	}
}

/////////////////////////////////////////////////////////////////////////////////////////////
//BOX Class to store excel sheet's value, row and column number
class BOX{
	//Initialise Variable
	private String value;
	private int row;
	private int column;
	//BOX constructor
	public BOX(String v, int r, int c) {
		this.value = v;
		this.row = r;
		this.column = c;
	}
	//getValue of the Box value
	public String getValue() {
		return this.value;
	}
	//getRow number of the box
	public int getRow() {
		return this.row;
	}
	//getColumn number of the box
	public int getColumn() {
		return this.column;
	}
}

/////////////////////////////////////////////////////////////////////////////////////////////
class MAP {
	private int rowSize;
	private int columnSize;
	String[][] table;
	//MAP constructor
	public MAP(int rS, int cS) {
		this.rowSize = rS;
		this.columnSize = cS;
		table = new String[rowSize][columnSize];
	}
	
	public void initializeTable() {
		for(int r = 0; r < table.length; r++){
			for (int c = 0; c < table[r].length; c++){
				table[r][c] = "0"; 
			}
		}
	}
	
	public void setTableValue(int r, int c ,String value){
		table[r][c] = value;
	}
	
	public String getTableValue(int r, int c) {
		return table[r][c];
	}
	public String[][] getTable() {
		return table;
	}
	
	public void printMap() {
		for(int r = 0; r < table.length; r++) {
			for(int c = 0; c < table[r].length; c++) {
				System.out.print(table[r][c] + " ");
			}
			System.out.println();
		}
	}
}