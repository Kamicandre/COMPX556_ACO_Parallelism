package COMPX556.Adrien_1276832_Billy_1298073;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
	private static ExcelReader ExcelRead;
	public static void test() {
		ExcelRead = new ExcelReader();
		List<String> test1 = ExcelRead.getList();
        System.out.print(test1);
		for(int i=0;i<test1.size();i++) {
			System.out.print(test1.get(i));
		}
	}
	public static void boxRead() {
		ExcelRead = new ExcelReader();
		ArrayList<BOX> test2 = ExcelRead.getBox();
        System.out.print(test2);
		for(int i=0;i<test2.size();i++) {
			System.out.print(test2.get(i));
		}
	}
    public static void main( String[] args )
    {
       System.out.println( "Hello World!" );
       test();
       boxRead();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public ExcelReader getExcelRead() {
		return ExcelRead;
	}
	public void setExcelRead(ExcelReader excelRead) {
		ExcelRead = excelRead;
	}
}
