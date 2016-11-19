/**
 * Square.java
 * @version Project 3
 * @author Anthony Vuong and Angel De La Torre
 * @version CPE102-05
 * @version Fall 2016
 */
import java.lang.*;
import java.util.*;

public class Square implements DelimitedTextIO
{

//a public constant variable named SQUARE_SIZE with a value of 50 
	public static final int SQUARE_SIZE = 50;
//a public constant variable named  UP with a value of 0
	public static final int UP = 0; 
//a public constant variable named RIGHT with a value of 1
	public static final int RIGHT = 1;
//a public constant variable named DOWN with a value of 2
	public static final int DOWN = 2;
//a public constant variable named LEFT with a value of 3
	public static final int LEFT = 3;
//a private variable named WALLS representing an array with a size of 4
	private boolean[] walls = new boolean[4];
//a private boolean variable named seen determines if a square has been seen or not
	private boolean seen = false;
//a private boolean variable named inView determines if a square is in view or not
	private boolean in_View = false;
//a private integer variable named ROW that represent the rows of a square
	private int row = 0;
//a private integer variable named COL that represent the columns of a square
	private int col = 0;
//a private Treasure(type) variable named treasure that references a treasure objects within a square
	private Treasure treasure = null; 

	public Square(boolean up, boolean right, boolean down, boolean left, int row, int col)
	{
		walls[0] = up;
		walls[1] = right;
		walls[2] = down;
 		walls[3] = left;
		this.row = row;
		this.col = col;
	}
	public Square(int row, int col)
	{
		this.row = row;
		this.col = col;
	}
	public boolean wall(int direction)
	{return walls[direction];}
	
	public boolean seen()
	{return seen;}
	
	public boolean inView()
	{return in_View;}
	
	public int row()
	{return row;}
	
	public int col()
	{return col;}
	
	public Treasure treasure()
	{return treasure;}
	
	public int x()
	{return col*SQUARE_SIZE;}
	
	public int y()
	{return row*SQUARE_SIZE;}

	public void setInView(boolean inView)
	{
		if(inView == true){
			this.seen = true;
		}	
	 in_View = inView;
	}
	
	public void setTreasure(Treasure t)
	{ this.treasure = t;}
	
	public void enter()
	{
		if (this.treasure != null)
			{treasure.setFound();}
	}
	//method to make this object into string format
	public String toText(char delimiter)
	{
		return(this.getClass().getName() + delimiter + Integer.toString(this.row) + delimiter + Integer.toString(this.col) + 
			delimiter + Boolean.toString(walls[UP]) + delimiter + Boolean.toString(walls[RIGHT]) + delimiter + Boolean.toString(walls[DOWN])
			+ delimiter + Boolean.toString(walls[LEFT]) + delimiter + Boolean.toString(this.seen) + delimiter + Boolean.toString(this.in_View));
	}
	//method to create this object from the string
	public void toObject(Scanner input)
	{
		this.walls[UP] = input.nextBoolean(); 
		this.walls[RIGHT] = input.nextBoolean();

		this.walls[DOWN] = input.nextBoolean();

		this.walls[LEFT] = input.nextBoolean();

		this.seen = input.nextBoolean();
		this.in_View = input.nextBoolean();
	}
}
		


	