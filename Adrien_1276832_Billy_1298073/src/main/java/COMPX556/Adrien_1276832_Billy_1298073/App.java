package COMPX556.Adrien_1276832_Billy_1298073;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	private static boolean[][] deads = new boolean[10][10];
	private static boolean[][] revisited = new boolean[10][10];
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
     * 1) Create Ant at start position using Map - Completed
     * 2) Reading through map to figure out free location - Completed
     * 3) Travelling through that random location
     * 4) Save trails and positions that Ant has visited
     * 5) Update best Solution of trail by length
    */
    
    
    
    
    
    
    
    
    public static void AntTravel(Ant ant, String[][] grid) {
		Position curr = ant.getPosition();
		Position end = findEnd();
		//While reaching end of the position
		while(curr != end){
			//Should move ant to a random free location.
    		ant.movement(curr.getRow(),curr.getCol(),grid,end);
		}
		System.out.println("Reached end goal");
		ArrayList<Position> trails = ant.getTrails();
		for(int i = 0; i < trails.size(); i++){
			System.out.println("Ant path " + i + "visited trail " + trails.get(i).getRow() + ", " + trails.get(i).getCol());
		}
    }
    
    
    
    
    
    
    
    
	public ExcelReader getExcelRead() {
		return ExcelRead;
	}
	public void setExcelRead(ExcelReader excelRead) {
		ExcelRead = excelRead;
	}
	
	public static void main( String[] args )
    {
	    //test();
	    //boxRead();
	    Map.printMap();
		Position start = findStart();
		Position end = findEnd();
		System.out.println("Start Row value is :" + start.getRow() +" and Start Column value is : " + start.getCol());
		System.out.println("End Row value is :" + end.getRow() +" and End Column value is : " + end.getCol());
		
		
		a1 = new Ant(start.getRow(),start.getCol(),end.getRow(), end.getCol(),0,visit,deads,revisited);
		AntTravel(a1, Map.getTable());
		
		//ArrayList<Position> nextLoc = a1.isFree(start.getRow(),start.getCol(), Map.getTable());
		
		//Position nextPos = a1.randomMove(nextLoc);
		//System.out.println("Next pos is: "+ nextPos.getRow() + ", " + nextPos.getCol());
    }
}

//////////////////////////////////////////////////////////////////////////////////////////
class Ant{
	private static Position currentPos;
	private static Position endGoal;
	private static Position prevPos;
	private static int pheromoneCount;
	ArrayList<Position> trails = new ArrayList<Position>();
	ArrayList<Position> Deadends = new ArrayList<Position>();
	private static boolean[][] visited;
	private static boolean[][] dead;
	private static boolean[][] revisited;

	public Ant(int startR, int startC , int endr, int endc , int phero, boolean[][] visit, boolean[][] deads, boolean[][] revisited){
		this.currentPos = new Position(startR, startC);
		this.prevPos = new Position(startR, startC);
		this.endGoal = new Position(endr, endc);
		this.pheromoneCount = phero;
		this.visited = visit;
		this.dead = deads;
		this.revisited = revisited;
	}

	public void visitedPos(Position pos){
		trails.add(pos);
		visited[pos.getRow()][pos.getCol()] = true;
	}
	public boolean visited(int r, int c){
		return visited[r][c];
	}
	public Position getPosition(){
		return currentPos;
	}
	public ArrayList<Position> getTrails(){
		return trails;
	}



	public void movement(int r, int c, String[][] mapTable, Position end){
		//Check which location is free
		ArrayList<Position> freeLoc = isFree(currentPos.getRow(), currentPos.getCol(), mapTable, end);
		if(freeLoc.size() == 0){
			Deadends.add(currentPos);
			dead[currentPos.getRow()][currentPos.getCol()] = true;
			currentPos = prevPos;
			revisited[currentPos.getRow()][currentPos.getCol()] = true;
		}else{
			Position nextPos = randomMove(freeLoc);
			if(visited[nextPos.getRow()][nextPos.getCol()] = true){
				revisited[nextPos.getRow()][nextPos.getCol()] = true;
			}
			System.out.println("Before movment Position is " + currentPos.getRow() + " , " + currentPos.getCol());
			prevPos = currentPos;
			visitedPos(nextPos);
			currentPos = nextPos;
			System.out.println("After movment Position is " + currentPos.getRow() + " , " + currentPos.getCol());
		}
		/*Position nextPos = randomMove(freeLoc);
		System.out.println("Before movment Position is " + currentPos.getRow() + " , " + currentPos.getCol());
		prevPos = currentPos;
		visitedPos(nextPos);
		currentPos = nextPos;
		System.out.println("After movment Position is " + currentPos.getRow() + " , " + currentPos.getCol());*/
	}
	public void Pheromone(){
		
	}
	
	//Deadend function needs to be updated
	public Position Deadend(int r , int c, String[][] mapTable) {
		String [][] grid = mapTable;
		ArrayList<Position> freeLoc = new ArrayList<Position>();
		Position prevPos = new Position(r,c);
		String free = "0";
		//Check up
		if (r != 0) {
			//Check if this option is dead end
				if(dead[r-1][c] != true){
					//Check if the it was visited.
					if (grid[r-1][c].equals(free)) {
						//Do something
						Position posDown = new Position(r+1 , c);
						//Save the prevpos into Deadends array
						Deadends.add(prevPos);
						dead[posDown.getRow()][posDown.getCol()] = true;
						prevPos = posDown;
						return prevPos;
					}
				}
		}
		//Check down
		if(r < 9) {
			//Check if this option is dead end
				if(dead[r+1][c] != true){
					if (grid[r+1][c].equals(free)){
						//Do something
						Position posDown = new Position(r+1 , c);
						//Save the prevpos into Deadends array
						Deadends.add(prevPos);
						dead[posDown.getRow()][posDown.getCol()] = true;
						prevPos = posDown;
						return prevPos;
					}
				}
		}
		//Check left
		if (c != 0) {
			//Check if this option is dead end
				if(dead[r][c-1] != true){
					if (grid[r][c-1].equals(free)){
						//Do something
						Position posLeft = new Position(r, c - 1);
						//Save the prevpos into Deadends array
						Deadends.add(prevPos);
						dead[posLeft.getRow()][posLeft.getCol()] = true;
						prevPos = posLeft;
						return prevPos;
					}
				}
		}
		//Check right
		if (c < 9) {
			//Check if this option is dead end
			if(dead[r][c+1] != true){
				if (grid[r][c+1].equals(free)){
					//Do something
					Position posRight = new Position(r, c+1);
					//Save the prevpos into Deadends array
					Deadends.add(prevPos);
					dead[posRight.getRow()][posRight.getCol()] = true;
					prevPos = posRight;
					return prevPos;
				}
			}
		}
		//System.out.println("Ant has gone insane and lost its path");
		//System.exit(0);
		return prevPos;
	}
	
	public Position randomMove(ArrayList<Position> pos){
		//Implement random
		Random rand = new Random();
		int move = rand.nextInt(pos.size());
		return pos.get(move);

	}

	public static void goLeft(Position current){
		current.setCol(current.getCol() - 1);
	}
	public static void goRight(Position current){
		current.setCol(current.getCol() + 1);
	}
	////////////////////////////FIX  THIS WHEN YOU CAN /////////////////////////////////
	public static void goUp(Position current){
		current.setRow(current.getRow() - 1);
	}
	public static void goDown(Position current){
		current.setRow(current.getRow() + 1);
	}
	/////////////////////////////////////////////////////////////////////////////////////
	//Looking for free location
	public ArrayList<Position> isFree(int r , int c, String[][] mapTable, Position endPos){
		String [][] grid = mapTable;
		ArrayList<Position> freeLoc = new ArrayList<Position>();
		ArrayList<Position> endLoc = new ArrayList<Position>();
		System.out.println("Current position is " + r + " ," + c);
		String free = "0";
		String end = "e";
		Integer rowVal = endPos.getRow() - r;
		Integer colVal = endPos.getCol() - c;
		System.out.println("Row and col is " + rowVal + ", " + colVal);
		boolean isUp = false;
		boolean isLeft = false;
		boolean upFree = false;
		boolean downFree = false;
		boolean leftFree = false;
		boolean rightFree = false;
		//Checking which way is end.
		if(rowVal > 0){
			isUp = false;
		}else{
			isUp = true;
		}
		if(colVal > 0){
			isLeft = false;
		}else{
			isLeft = true;
		}
		System.out.println("Up and Left is " + isUp + ", " + isLeft);
			//Check up
			if (r != 0) {
				//Check if this option is dead end
				if(dead[r-1][c] != true){
					//Check if the free position was visited previously
					if (revisited[r-1][c] != true){
						//If it finds end poistion up
						if(grid[r-1][c].equals(end)) {
							Position posUp = new Position(r-1, c);
							endLoc.add(posUp);
							return endLoc;
						}
						else if (grid[r-1][c].equals(free)) {
							upFree = true;
							/*if(isUp == true) {
								//Do something
								Position posUp = new Position(r-1, c);
								freeLoc.add(posUp);
								System.out.println("Up is: " + posUp.getRow() + ", " + posUp.getCol());
							}*/
						}
					}
				}	
			}
			//Check down
			if(r < 9) {
				//Check if this option is dead end
				if(dead[r+1][c] != true){
					if (revisited[r+1][c] != true){
						if(grid[r+1][c].equals(end)) {
							Position posDown= new Position(r-1, c);
							endLoc.add(posDown);
							return endLoc;
						}
						else if (grid[r+1][c].equals(free)) {
							downFree = true;
							/*if(isUp == false) {
								//Do something
								Position posDown = new Position(r+1 , c);
								freeLoc.add(posDown);
								System.out.println("Down is: " + posDown.getRow() + ", " + posDown.getCol());
							}*/
						}
					}
				}
			}
			//Check left
			if (c != 0) {
				//Check if this option is dead end
				if(dead[r][c-1] != true){
					if (revisited[r][c-1] != true){
						if(grid[r][c-1].equals(end)) {
							Position posLeft = new Position(r-1, c);
							endLoc.add(posLeft);
							return endLoc;
						}
						else if (grid[r][c-1].equals(free)) {
							leftFree = true;
							/*if(isLeft == true) {
								//Do something
								Position posLeft = new Position(r, c - 1);
								freeLoc.add(posLeft);
								System.out.println("Left is: " + posLeft.getRow() + ", " + posLeft.getCol());
							}*/
						}
					}
				}
			}
			//Check right
			if (c < 9) {
				//Check if this option is dead end
				if(dead[r][c+1] != true){
					if (revisited[r][c+1] != true){
						if(grid[r][c+1].equals(end)) {
							Position posRight= new Position(r-1, c);
							endLoc.add(posRight);
							return endLoc;
						}
						else if (grid[r][c+1].equals(free)) {
							rightFree = true;
							/*if(isLeft == false) {
								//Do something
								Position posRight = new Position(r, c+1);
								freeLoc.add(posRight);
								System.out.println("Right is: " + posRight.getRow() + ", " + posRight.getCol());
							}*/
						}
					}
				}
			}
			//Check up and if down is blocked
			if(upFree == true && isUp == true){
				Position posUp = new Position(r-1, c);
				freeLoc.add(posUp);
				System.out.println("Up is: " + posUp.getRow() + ", " + posUp.getCol());
			}else if(upFree == true && isUp == false && downFree == false){
				Position posUp = new Position(r-1, c);
				freeLoc.add(posUp);
				System.out.println("Up is: " + posUp.getRow() + ", " + posUp.getCol());
			}
			//Check Down and if up is blocked
			if(downFree == true && isUp == false) {
				Position posDown = new Position(r+1 , c);
				freeLoc.add(posDown);
				System.out.println("Down is: " + posDown.getRow() + ", " + posDown.getCol());
			} else if(downFree == true && isUp == true && upFree == false){
				Position posDown = new Position(r+1 , c);
				freeLoc.add(posDown);
				System.out.println("Down is: " + posDown.getRow() + ", " + posDown.getCol());
			}
			//Check Left and if right is blocked
			if(leftFree == true && isLeft == true) {
				Position posLeft = new Position(r, c - 1);
				freeLoc.add(posLeft);
				System.out.println("Left is: " + posLeft.getRow() + ", " + posLeft.getCol());
			}else if (leftFree == true && isLeft == false & rightFree == false){
				Position posLeft = new Position(r, c - 1);
				freeLoc.add(posLeft);
				System.out.println("Left is: " + posLeft.getRow() + ", " + posLeft.getCol());
			}//Check right and if left is blocked.
			if(rightFree == true && isLeft == false) {
				Position posRight = new Position(r, c+1);
				freeLoc.add(posRight);
				System.out.println("Right is: " + posRight.getRow() + ", " + posRight.getCol());
			}else if(rightFree == true && isLeft == true && leftFree == false){
				Position posRight = new Position(r, c+1);
				freeLoc.add(posRight);
				System.out.println("Right is: " + posRight.getRow() + ", " + posRight.getCol());
			}
			
			/*if(freeLoc.size() == 0){
				Position back = Deadend(r,c,grid);
				freeLoc.add(back);
				System.out.println("Returning back to: " + back.getRow() + ", " + back.getCol());
			}*/
		return freeLoc;
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
	public void setRow(int r) {
		this.row = r;
	}
	public void setCol(int c) {
		this.col = c;
	}
}