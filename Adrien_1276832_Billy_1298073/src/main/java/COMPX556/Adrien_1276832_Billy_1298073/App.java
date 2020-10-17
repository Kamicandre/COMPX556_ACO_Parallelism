package COMPX556.Adrien_1276832_Billy_1298073;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
	private static ExcelReader ExcelRead = new ExcelReader();
	private static MAP Map = ExcelRead.getMap();
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
        //System.out.print(test2);
		for(int i=0;i<test2.size();i++) {
		}
		
	}
    public static void main( String[] args )
    {
       System.out.println( "Hello World!" );
       //test();
       //boxRead();
       Map.printMap();
    }
    
    
    /*
     * 1) Create Ant at start position using Map
     * 2) Reading through map to figure out free location
     * 3) Travelling through that random location
     * 4) Save trails and positions that Ant has visited
     * 5) Update best Solution of trail by length
    */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
	public ExcelReader getExcelRead() {
		return ExcelRead;
	}
	public void setExcelRead(ExcelReader excelRead) {
		ExcelRead = excelRead;
	}
}

//////////////////////////////////////////////////////////////////////////////////////////
class Ant{
	private static int currentPr;
	private static int currentPc;
	private static int endPr;
	private static int endPc;
	private static int pheromoneCount;
	private static String[][] trails;
	private static boolean[][] visited;

	public void visitCity(int currentPr, int currentPc, String value){
		trails[currentPr][currentPc] =  value;
		visited[currentPr][currentPc] = true;
	}
	public boolean visted(int r, int c){
		return visited[r][c];
	}



	public void movement(){
		//checking for path (which way it should go/ if the path is open that way)
	}
	public void Pheromone(){
		
	}

	public static void goLeft(){
		currentPr = currentPr - 1;
	}
	public static void goRight(){
		currentPr = currentPr + 1;
	}
	////////////////////////////FIX  THIS WHEN YOU CAN /////////////////////////////////
	public static void goUp(){
		currentPr = currentPr;
	}
	public static void goDown(){
		currentPr = currentPr ;
	}
}
