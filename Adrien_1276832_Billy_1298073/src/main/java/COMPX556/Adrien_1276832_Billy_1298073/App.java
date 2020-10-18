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
	private static Ant a1;
	private static boolean[][] visit = new boolean[10][10];
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
   


    
	//Finding "s" in the Map
	public static Position findStart(){
		String[][] grid = Map.getTable();
		//Initalize Start positions value
		int rS = 0;
		int cS = 0;
		String v = "";
		String s = "s";
		//while(v != s){
			for(int r = 0; r < grid.length; r++) {
				//reset Column to 0
				cS = 0;
				for(int c = 0; c < grid[r].length; c++) {
					//Increment column value
					v = grid[r][c];
					if (v.equals(s)){
						return new Position(rS , cS);
					}
					cS++;
				}
				rS++;
			}
		//}
		
		
		return new Position(rS , cS);
	}
    
	public static Position findEnd(){
		String[][] grid = Map.getTable();
		//Initalize Start positions value
		int rS = 0;
		int cS = 0;
		String v = "";
		String e = "e";
		//while(v != s){
			for(int r = 0; r < grid.length; r++) {
				//reset Column to 0
				cS = 0;
				for(int c = 0; c < grid[r].length; c++) {
					//Increment column value
					v = grid[r][c];
					if (v.equals(e)){
						return new Position(rS , cS);
					}
					cS++;
				}
				rS++;
			}
		//}
		
		
		return new Position(rS , cS);
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
	
	public static void main( String[] args )
    {
		System.out.println( "Hello World!" );
	    //test();
	    //boxRead();
	    Map.printMap();
		Position start = findStart();
		Position end = findEnd();
		System.out.println("Start Row value is :" + start.getRow() +" and Start Column value is : " + start.getCol());
		System.out.println("End Row value is :" + end.getRow() +" and End Column value is : " + end.getCol());
		a1 = new Ant(start.getRow(),start.getCol(),end.getRow(), end.getCol(),0,visit);
		a1.visitCity(start.getRow(),start.getCol());
		a1.isFree(start.getRow(),start.getCol(), Map.getTable());
    }
}

//////////////////////////////////////////////////////////////////////////////////////////
class Ant{
	private static int currentPr;
	private static int currentPc;
	private static int endPr;
	private static int endPc;
	private static int pheromoneCount;
	ArrayList<Position> pList = new ArrayList<Position>();
	//private static String[][] trails;
	private static boolean[][] visited;

	public Ant(int r, int c , int endr, int endc , int phero, boolean[][] visit){
		this.currentPr = r;
		this.currentPc = c;
		this.endPr = endr;
		this.endPc = endc;
		this.pheromoneCount = phero;
		this.visited = visit;
	}

	public void visitCity(int currentPr, int currentPc){
		//trails[currentPr][currentPc] =  value;
		visited[currentPr][currentPc] = true;
	}
	public boolean visited(int r, int c){
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
	/////////////////////////////////////////////////////////////////////////////////////
	//Looking for free location
	public void isFree(int r , int c, String[][] mapTable){
		String [][] grid = mapTable;
		ArrayList<Position> freeLoc = new ArrayList<Position>();
		String free = "0";
		//Check up
		if (r != 0) {
			if (grid[r-1][c].equals(free)) {
				//Do something
				Position posUp = new Position(r-1, c);
				freeLoc.add(posUp);
				System.out.println("Up is: " + posUp.getRow() + ", " + posUp.getCol());
			}
		}
		//Check down
		if(r <= 9) {
			if (grid[r+1][c].equals(free)) {
				//Do something
				Position posDown = new Position(r+1 , c);
				freeLoc.add(posDown);
				System.out.println("Down is: " + posDown.getRow() + ", " + posDown.getCol());
			}
		}
		//Check left
		if (c != 0) {
			if (grid[r][c-1].equals(free)) {
				//Do something
				Position posLeft = new Position(r, c - 1);
				freeLoc.add(posLeft);
				System.out.println("Left is: " + posLeft.getRow() + ", " + posLeft.getCol());
			}
		}
		//Check right
		if (c <= 9) {
			if (grid[r][c+1].equals(free)) {
				//Do something
				Position posRight = new Position(r, c+1);
				freeLoc.add(posRight);
				System.out.println("Right is: " + posRight.getRow() + ", " + posRight.getCol());
			}
		}
	}

}

//////////////////////////////////////////////////////////////////////////////////////////
class Position{
	private int row;
	private int col;

	public Position(int row, int col){
		this.row = row;
		this.col = col;
	}

	public int getRow(){
		return row;
	}
	public int getCol(){
		return col;
	}
}