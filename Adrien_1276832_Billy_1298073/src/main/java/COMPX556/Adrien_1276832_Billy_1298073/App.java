package COMPX556.Adrien_1276832_Billy_1298073;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Hello world!
 *
 */
public class App implements Runnable
{
	private static int maxR = 20;
	private static int maxC = 20;
	private static ExcelReader ExcelRead = new ExcelReader();
	private static MAP Map = ExcelRead.getMap();
	private static Ant a1;
	private static Ant a2;
	private static Ant a3;
	private static Ant a4;
	private static Ant a5;
	private static Ant a6;
	private static Ant a7;
	private static Ant a8;
	private static Ant a9;
	private static Ant a10;
	private static Ant bestAnt;
	private static boolean[][] visit = new boolean[maxR][maxC];
	private static boolean[][] deads = new boolean[maxR][maxC];
	private static boolean[][] revisited = new boolean[maxR][maxC];
	private static int[][] phero = new int[maxR][maxC];
	private static ArrayList<Ant> antList = new ArrayList<Ant>();
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
		return new Position(rS , cS);
	}

    /*
     * 1) Create Ant at start position using Map - Completed
     * 2) Reading through map to figure out free location - Completed
     * 3) Tra=velling through that random location
     * 4) Save trails and positions that Ant has visited
     * 5) Update best Solution of trail by length
     * getTrails in Ant has an error, maybe not adding move position properly
    */
    
    public static void AntTravel(Ant ant, String[][] grid) {
		Position curr = ant.getPosition();
		//System.out.println("Starting new ant ---------------------------------------------------------------------------------------");
		//System.out.println("Start pos :" + curr.getRow() + ", " + curr.getCol());
		Position end = findEnd();
		//System.out.println("End pos :" + end.getRow() + ", " + end.getCol());
		//While reaching end of the position
		while(grid[curr.getRow()][curr.getCol()] != grid[end.getRow()][end.getCol()]){
			//Should move ant to a random free location.
    		curr = ant.movement(curr.getRow(),curr.getCol(),grid,end);			
			//System.out.println("Ants current poisition after movement is :" + curr.getRow() + ", " + curr.getCol());
		}
		//System.out.println("Reached end goal");
    }
    
    public static void massTravel() {
		Position start = findStart();
		Position end = findEnd();
    	a1 = new Ant(start.getRow(),start.getCol(),end.getRow(), end.getCol(), maxR, maxC, visit,deads,revisited, phero);
		antList.add(a1);
		AntTravel(a1, Map.getTable());
		a1.evaporate(maxR,maxC);
		
		a2 = new Ant(start.getRow(),start.getCol(),end.getRow(), end.getCol(), maxR, maxC, visit,deads,revisited, phero);
		antList.add(a2);
		AntTravel(a2, Map.getTable());
		a2.evaporate(maxR,maxC);
		
		a3 = new Ant(start.getRow(),start.getCol(),end.getRow(), end.getCol(), maxR, maxC, visit,deads,revisited, phero);
		antList.add(a3);
		AntTravel(a3, Map.getTable());
		a3.evaporate(maxR,maxC);
		
		a4 = new Ant(start.getRow(),start.getCol(),end.getRow(), end.getCol(), maxR, maxC, visit,deads,revisited, phero);
		antList.add(a4);
		AntTravel(a4, Map.getTable());
		a4.evaporate(maxR,maxC);
		
		a5 = new Ant(start.getRow(),start.getCol(),end.getRow(), end.getCol(), maxR, maxC, visit,deads,revisited, phero);
		antList.add(a5);
		AntTravel(a5, Map.getTable());
		a5.evaporate(maxR,maxC);
		
		a6 = new Ant(start.getRow(),start.getCol(),end.getRow(), end.getCol(), maxR, maxC, visit,deads,revisited, phero);
		antList.add(a6);
		AntTravel(a6, Map.getTable());
		a6.evaporate(maxR,maxC);
		
		a7 = new Ant(start.getRow(),start.getCol(),end.getRow(), end.getCol(), maxR, maxC, visit,deads,revisited, phero);
		antList.add(a7);
		AntTravel(a7, Map.getTable());
		a7.evaporate(maxR,maxC);
		
		a8 = new Ant(start.getRow(),start.getCol(),end.getRow(), end.getCol(), maxR, maxC, visit,deads,revisited, phero);
		antList.add(a8);
		AntTravel(a8, Map.getTable());
		a8.evaporate(maxR,maxC);
		
		a9 = new Ant(start.getRow(),start.getCol(),end.getRow(), end.getCol(), maxR, maxC, visit,deads,revisited, phero);
		antList.add(a9);
		AntTravel(a9, Map.getTable());
		a9.evaporate(maxR,maxC);
		
		a10 = new Ant(start.getRow(),start.getCol(),end.getRow(), end.getCol(), maxR, maxC, visit,deads,revisited, phero);
		antList.add(a10);
		AntTravel(a10, Map.getTable());
		a10.evaporate(maxR,maxC);
    }
    
    public static void printTrails(Ant ant, String[][] grid) {
    	ArrayList<Position> trail = ant.getTrails();
    	//String[][] test = grid; // Problem here, its not copying it, merely add a reference to it
    	String[][] test = new String[grid.length][];
    	for(int i = 0; i < test.length; i++) {
    		test[i] = new String[grid[i].length];
    		for (int j = 0; j < test[i].length; j++) {
    			test[i][j] = grid[i][j];
    		}
    	}
    	//Go through the trail position arraylist
    	//Take their position row and col val
    	//Put it into test and change its value to x to show that its has travelled
    	for(int i = 0; i < trail.size(); i++) {
    		int trailR = trail.get(i).getRow();
    		int trailC = trail.get(i).getCol();
    		if(!test[trailR][trailC].equals("e") && !test[trailR][trailC].equals("s")) {
    			test[trailR][trailC] = "x";
    		}
    	}
    	for(int r = 0; r < test.length; r++) {
			for(int c = 0; c < test[r].length; c++) {
				System.out.print(test[r][c] + "\t");
			}
			System.out.println();
		}
//    	for(int r = 0; r < table.length; r++) {
//			for(int c = 0; c < table[r].length; c++) {
//				System.out.print(table[r][c] + " ");
//			}
//			System.out.println();
//		}
    }
    
    public static void bestTrails() {
    	//Search through the ArrayList<Ant> antList to find which ant.getTrails has the smallest size
    	//Set minTrail Size to the first ant trail size in antList
    	int minTrailSize = antList.get(0).getTrails().size();
    	int minIndex = 0;
    	//Go through antList trails
    	for (int i = 1; i < antList.size(); i++) {
    		//Check to see where index ant trail is less than minTrailSize
    		if(antList.get(i).getTrails().size() < minTrailSize) {
    			minTrailSize = antList.get(i).getTrails().size();
    			minIndex = i;
    		}
    	}
    	bestAnt = antList.get(minIndex);
    	minIndex = minIndex + 1;
    	System.out.println("Ant Trail Min Size is: " + minTrailSize + " Found at Ant" + minIndex);
    	System.out.println("Best Ant has size: " + bestAnt.getTrails().size() + ", " + "and has a path of: ");
    	printTrails(bestAnt, Map.getTable());
    }
    
	public ExcelReader getExcelRead() {
		return ExcelRead;
	}
	public void setExcelRead(ExcelReader excelRead) {
		ExcelRead = excelRead;
	}
	
	public static void main()
    {
		massTravel();
//		System.out.println("A1 trails:");
//		printTrails(a1, Map.getTable());
		System.out.println("A1 trails count: " + a1.getTrails().size() + 
							" A2 trails count: " + a2.getTrails().size() + 
							" A3 trails count: " + a3.getTrails().size() + 
							" A4 trails count: " + a4.getTrails().size() + 
							" A5 trails count: " + a5.getTrails().size() + 
							" A6 trails count: " + a6.getTrails().size() + 
							" A7 trails count: " + a7.getTrails().size() + 
							" A8 trails count: " + a8.getTrails().size() + 
							" A9 trails count: " + a9.getTrails().size() + 
							" A10 trails count: " + a10.getTrails().size());
		bestTrails();
    }
	@Override
	public void run() {
		main();
	}
}

//////////////////////////////////////////////////////////////////////////////////////////
class Ant{
	private static Position currentPos;
	private static Position endGoal;
	private static Position prevPos;
	ArrayList<Position> trails = new ArrayList<Position>();
	ArrayList<Position> Deadends = new ArrayList<Position>();
	private static boolean[][] visited;
	private static boolean[][] dead;
	private static boolean[][] revisited;
	private static int[][] pheromone;
	private static int maxR;
	private static int maxC;

	public Ant(int startR, int startC , int endr, int endc , int mR, int mC, boolean[][] visit, boolean[][] deads, boolean[][] revisited , int[][] phero){
		this.currentPos = new Position(startR, startC);
		this.prevPos = new Position(startR, startC);
		this.endGoal = new Position(endr, endc);
		this.maxR = mR;
		this.maxC = mC;
		this.visited = visit;
		this.dead = deads;
		this.revisited = revisited;
		this.pheromone = phero;
		pheromone[startR][startC] = 1;
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
	public void getPheromoneMap(int r , int c, int[][] phero){
		for(int row = 0; row < r; row++){
			for(int col = 0; col < col; col++){
				pheromone[r][c] = phero[r][c];
			}
		}
	}



	public Position movement(int r, int c, String[][] mapTable, Position end){
		//Check which location is free
		ArrayList<Position> freeLoc = isFree(currentPos.getRow(), currentPos.getCol(), mapTable, end);
		if(freeLoc.size() == 0){
			//Position marker to switch current and previous position.
			ArrayList<Position> freeM = onlyPath(currentPos.getRow(), currentPos.getCol(), mapTable);
			Position temp = randomMove(freeM);
			//CHANGE THIS.
			Deadends.add(currentPos);
			dead[currentPos.getRow()][currentPos.getCol()] = true;
			Pheromone(currentPos.getRow(), currentPos.getCol());
			//System.out.println("Gay loop");
			prevPos = currentPos;
			visitedPos(prevPos);
			currentPos = temp;
			revisited[currentPos.getRow()][currentPos.getCol()] = true;
			//System.out.println("Position stuck in : " + currentPos.getRow() + ","+ currentPos.getCol());
			return currentPos;
		}else{
			Position nextPos = randomMove(freeLoc);
			if(visited[nextPos.getRow()][nextPos.getCol()] == true){
				revisited[nextPos.getRow()][nextPos.getCol()] = true;
			}
			if(mapTable[nextPos.getRow()][nextPos.getCol()] == mapTable[prevPos.getRow()][prevPos.getCol()]){
				//System.out.println("Before movment Position is " + currentPos.getRow() + " , " + currentPos.getCol());
				prevPos = currentPos;
				Pheromone(currentPos.getRow(), currentPos.getCol());
				visitedPos(currentPos);
				currentPos = nextPos;
				return currentPos;
			}else{
				//System.out.println("Before movment Position is " + currentPos.getRow() + " , " + currentPos.getCol());
				prevPos = currentPos;
				visitedPos(currentPos);
				currentPos = nextPos;
				Pheromone(currentPos.getRow(), currentPos.getCol());
				return currentPos;
			}
		}
	}
	public void Pheromone(int r , int c){
		pheromone[r][c] = pheromone[r][c] + 1;
	}
	public void evaporate(int maxR, int maxC) {
		for(int r = 0; r < maxR; r++) {
			for(int c = 0; c < maxC; c++) {
				if(pheromone[r][c] > 0) {
					pheromone[r][c] = pheromone[r][c]/2;
				}
			}
				
		}
	}
	
	public Position randomMove(ArrayList<Position> pos){
		//Implement random
		Random rand = new Random();
		int move = rand.nextInt(pos.size());
		return pos.get(move);

	}

	public ArrayList<Position> onlyPath(int r, int c, String[][] mapTable){
		String [][] grid = mapTable;
		String free = "0";
		//System.out.println("Searching for path");
		ArrayList<Position> freeLoc = new ArrayList<Position>();
		//Return first value thats available free to move.
		if(r != 0){
			if (grid[r-1][c].equals(free)) {
				Position posU = new Position(r-1, c);
				freeLoc.add(posU);
			}
		}	
		if(r < maxR-1){
			if (grid[r+1][c].equals(free)) {
				Position posD = new Position(r+1, c);
				freeLoc.add(posD);
			}
		}
		if(c != 0){
			if (grid[r][c-1].equals(free)) {
				Position posL = new Position(r, c-1);
				freeLoc.add(posL);
			}
		}
		if (c < maxC-1){
			if (grid[r][c+1].equals(free)) {
				Position posR = new Position(r, c+1);
				freeLoc.add(posR);
			}
		}
		return freeLoc;
	}
	/////////////////////////////////////////////////////////////////////////////////////
	//Looking for free location
	public ArrayList<Position> isFree(int r , int c, String[][] mapTable, Position endPos){
		String [][] grid = mapTable;
		ArrayList<Position> freeLoc = new ArrayList<Position>();
		ArrayList<Position> endLoc = new ArrayList<Position>();
		ArrayList<Integer> prior = new ArrayList<Integer>();
		//ArrayList<Integer> minPrior = new ArrayList<Integer>();
		prior.add(3);
		prior.add(3);
		prior.add(3);
		prior.add(3);
		//System.out.println("Current position is " + r + " ," + c);
		String free = "0";
		String end = "e";
		Integer rowVal = endPos.getRow() - r;
		Integer colVal = endPos.getCol() - c;
		//System.out.println("Row and col is " + rowVal + ", " + colVal);
		int upPrior = 0;
		int downPrior = 0;
		int leftPrior = 0;
		int rightPrior = 0;
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
		//System.out.println("Up and Left is " + isUp + ", " + isLeft);
		//System.out.println("Prior array: " + prior);
		//Check up
		if (r != 0) {
			//Check if this option is dead end
			if(dead[r-1][c] != true){
				//If it finds end poistion up
				if(grid[r-1][c].equals(end)) {
					Position posUp = new Position(r-1, c);
					endLoc.add(posUp);
					return endLoc;
				}
				/*Get the prior from the pheromone count
				  Get the min, and 2nd min and 3rd min
				  Sort them in an array from the min to the highest
				  */
				else if (grid[r-1][c].equals(free)) {
					upFree = true;
					//upPrior = pheromone[r-1][c];
					//prior.set(0, upPrior);
					//Check if the free position was visited previously
					if (visited[r-1][c] != true){
						upPrior = pheromone[r-1][c];
						prior.set(0, upPrior);
					}else if (revisited[r-1][c] == true){
						upPrior = pheromone[r-1][c] + 2;
						prior.set(0, upPrior);
					}else if (visited[r-1][c] == true){
						upPrior = pheromone[r-1][c] + 1;
						prior.set(0, upPrior);
					}
				}
			}	
		}
		//Check down
		if(r < maxR-1) {
			//Check if this option is dead end
			if(dead[r+1][c] != true){
				
				if(grid[r+1][c].equals(end)) {
					Position posDown= new Position(r+1, c);
					endLoc.add(posDown);
					return endLoc;
				}
				else if (grid[r+1][c].equals(free)) {
					downFree = true;
					//downPrior = pheromone[r+1][c];
					//prior.set(1, downPrior);
					//Check if the free position was visited previously
					if (visited[r+1][c] != true){
						downPrior = pheromone[r+1][c];
						prior.set(1, downPrior);
					}else if (revisited[r+1][c] == true){
						downPrior = pheromone[r+1][c] + 2;
						prior.set(1, downPrior);
					}else if (visited[r+1][c] == true){
						downPrior = pheromone[r+1][c] + 1;
						prior.set(1, downPrior);
					} 
				}
				
			}
		}
		//Check left
		if (c != 0) {
			//Check if this option is dead end
			if(dead[r][c-1] != true){
				if(grid[r][c-1].equals(end)) {
					Position posLeft = new Position(r, c-1);
					endLoc.add(posLeft);
					return endLoc;
				}
				else if (grid[r][c-1].equals(free)) {
					leftFree = true;
					//leftPrior = pheromone[r][c-1];
					//prior.set(2, leftPrior);
					//Check if the free position was visited previously
					if (visited[r][c-1] != true){
						leftPrior = pheromone[r][c-1];
						prior.set(2, leftPrior);
					}else if (revisited[r][c-1] == true){
						leftPrior = pheromone[r][c-1] + 2;
						prior.set(2, leftPrior);
					}else if (visited[r][c-1] == true){
						leftPrior = pheromone[r][c-1] + 1;
						prior.set(2, leftPrior);
					}
				}
				
			}
		}
		//Check right
		if (c < maxC-1) {
			//Check if this option is dead end
			if(dead[r][c+1] != true){
				if(grid[r][c+1].equals(end)) {
					Position posRight= new Position(r, c+1);
					endLoc.add(posRight);
					return endLoc;
				}
				else if (grid[r][c+1].equals(free)) {
					rightFree = true;
					//rightPrior = pheromone[r][c+1];
					//prior.set(3, rightPrior);
					//Check if the free position was visited previously
					if (visited[r][c+1] != true){
						rightPrior = pheromone[r][c+1];
						prior.set(3, rightPrior);
					}else if (revisited[r][c+1] == true){
						rightPrior = pheromone[r][c+1] + 2;
						prior.set(3, rightPrior);
					}else if (visited[r][c+1] == true){
						rightPrior = pheromone[r][c+1] + 1;
						prior.set(3, rightPrior);
					}
				}
				
			}
		}
		//System.out.println("Prior array: " + prior.get(0) + ", "+ prior.get(1)+ ", "+prior.get(2)+ ", "+prior.get(3));
	
		//USING PHERO TO CHECK IF BEST POISITION TO MOVE.
		///////////Check if correct direction is free///////////////
		//Check up and if down is blocked && prior.get(0) == 0
		if(upFree == true && isUp == true && prior.get(0) == 0){
			Position posUp = new Position(r-1, c);
			freeLoc.add(posUp);
			//System.out.println("Up is: " + posUp.getRow() + ", " + posUp.getCol());
		}
		//Check Down and if up is blocked
		if(downFree == true && isUp == false && prior.get(1) == 0) {
			Position posDown = new Position(r+1 , c);
			freeLoc.add(posDown);
			//System.out.println("Down is: " + posDown.getRow() + ", " + posDown.getCol());
		} 
		//Check Left and if right is blocked
		if(leftFree == true && isLeft == true && prior.get(2) == 0) {
			Position posLeft = new Position(r, c-1);
			freeLoc.add(posLeft);
			//System.out.println("Left is: " + posLeft.getRow() + ", " + posLeft.getCol());
		}
		//Check right and if left is blocked.
		if(rightFree == true && isLeft == false && prior.get(3) == 0) {
			Position posRight = new Position(r, c+1);
			freeLoc.add(posRight);
			//System.out.println("Right is: " + posRight.getRow() + ", " + posRight.getCol());
		}
		//CHECKING PRIORITY
		if(freeLoc.size() == 0){
			int minIndex = 0;
			List<Integer> best = new ArrayList<>();
			for(int i = 0; i < prior.size(); i++){
				if(prior.get(i) == prior.get(minIndex)){
					best.add(i);
				}
				else if (prior.get(minIndex) > prior.get(i)){
					best.clear();
					best.add(i);
					minIndex = i;
				}
			}
			//System.out.println("New Priority");
			if(best.contains(0)){
				if(r != 0 && upFree == true) {
					Position posUp = new Position(r-1, c);
					freeLoc.add(posUp);
					//System.out.println("UpPrior is: " + posUp.getRow() + ", " + posUp.getCol());
				}
			}
			if(best.contains(1)){
				if(r < maxR-1 && downFree == true) {
					Position posDown = new Position(r+1, c);
					freeLoc.add(posDown);
					//System.out.println("DownPrior is: " + posDown.getRow() + ", " + posDown.getCol());
				}
			}
			if(best.contains(2)){
				if(c != 0 && leftFree == true) {
					Position posLeft = new Position(r, c-1);
					freeLoc.add(posLeft);
					//System.out.println("LeftPrior is: " + posLeft.getRow() + ", " + posLeft.getCol());
				}
			}
			if(best.contains(3)){
				if(c < maxC-1 && rightFree == true) {
					Position posRight = new Position(r, c+1);
					freeLoc.add(posRight);
					//System.out.println("RightPrior is: " + posRight.getRow() + ", " + posRight.getCol());
				}
			}
		}
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