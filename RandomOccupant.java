/**
 *@name RandomOccupant.java 
 *
 *@descripiton RandomOccupant class - extends from the Occupant class and will
 *be an abstract class that will extend to Monster and Treasure
 *
 *@author Angel de la Torre, Anthony Vuong
 *
 *@version CPE 102 - 05
 *@version Fall 2016
 *@version 10/28/16
 */
import java.util.*;

public abstract class RandomOccupant extends Occupant{
//instance variables
	//a variable to use the random function
	private Random rand = new Random();
	//a reference to the Maze file that it inhabits
	private Maze m; 

//constructor
	//a constructor that takes in a maze object. and also sets the object's location
		//to a random location within the maze. 
	public RandomOccupant(Maze maze)
	{
		m = maze; 
	 	int r = rand.nextInt(m.rows());
	 	int c = rand.nextInt(m.cols());
	 	this.moveTo(m.getSquare(r, c));
	}
	//a constructor that takes in a maze object and a seed that will effect the random function
		//the seed will effect the random function in a way to make the random function predictable
	public RandomOccupant(Maze maze, long seed)
	{
		m = maze; 
		rand.setSeed(seed);
		int r = rand.nextInt(m.rows());
		int c = rand.nextInt(m.cols());
	 	this.moveTo(m.getSquare(r, c));
	}
	//a constructor that takes in a maze object and a pre-chosen location
		//this will remove the random function and set the object to the chosen location
	public RandomOccupant(Maze maze, Square location)
	{
		m = maze;
		this.moveTo(location);
	}

//methods
	//a function that moves the object to a random location.
	/**
	* Retrieve the row and column of the object's current location
	* Generate a random integer, between 0-3, this integer will represent the numeric
	* 	value of which direction to go.
	* Check to see if the direction is valid, i.e. there are no walls in that given direction
	* if there are no walls, move the object to the new direction
	* else try again until there is a valid direction.
	*/
	public void move()
	{
		Square s = this.location();
		int r = s.row();
		int c = s.col();
		boolean x = false;
		while(x == false){
			int d = rand.nextInt(4);
			if(d == Square.UP && r != 0 && s.wall(d) == false)
			{
				r -= 1;
				if(m.getSquare(r, c).wall(Square.DOWN) == false){
					this.moveTo(m.getSquare(r, c));
					x = true;
				}
			}
			else if(d == Square.DOWN && r != (m.rows() - 1) && s.wall(d) == false)
			{
				r += 1;
				if(m.getSquare(r,c).wall(Square.UP) == false){
					this.moveTo(m.getSquare(r,c));
					x = true;
				}
			}
			else if(d == Square.RIGHT && c != (m.cols() - 1) && s.wall(d) == false)
			{ 
				c += 1;
				if(m.getSquare(r,c).wall(Square.LEFT) == false){
					this.moveTo(m.getSquare(r,c));
					x = true;
				}
			}
			else if(d == Square.LEFT && c != 0 &&  s.wall(d) == false)
			{
				c-= 1;
				if(m.getSquare(r, c).wall(Square.RIGHT) == false){
					this.moveTo(m.getSquare(r,c));
					x = true;
				}
			}
		}
	}
	//method to become used in subclasses for creating the object from a string
	public void toObject(Scanner input)
	{	
		int row = input.nextInt();
		int col = input.nextInt();
		Square s = new Square(row,col);
		this.moveTo(s);
	}
}

