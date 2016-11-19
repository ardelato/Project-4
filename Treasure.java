/**
 * Treasure.java
 * @version Project 3
 * @author Anthony Vuong and Angel De La Torre
 * @version CPE102-05
 * @version Fall 2016
 */
import java.lang.*;
import java.util.*;

public class Treasure extends RandomOccupant
{
	private boolean foundTreasure;

	public Treasure(Maze maze)
	{
		super(maze);
	 	foundTreasure = false;
	 	super.location().setTreasure(this);
	 }
	public Treasure(Maze maze, long seed)
	{
		super(maze, seed);
	 	foundTreasure = false;
	 	super.location().setTreasure(this);
	}
	public Treasure(Maze maze, Square location)
	{
		super(maze, location);
	 	foundTreasure = false;
	    location().setTreasure(this);
	 }				  
	public boolean found()
	{ return foundTreasure;}

	public void setFound()
	{ this.foundTreasure = true;}
	
	public void move(){}
	//method to make this object into a string
	public String toText(char delimiter)
	{
		return(super.toText(delimiter) + delimiter + Boolean.toString(this.foundTreasure));
	}
	// method to create this object from the string 
	public void toObject(Scanner input)
	{
		super.toObject(input);
		this.foundTreasure = input.nextBoolean();
	}
	//method to move this square to a null location if not already null 
	public void moveTo(Square new_location){
		if(this.location() != null) {
			super.moveTo(null);
		}
		super.moveTo(new_location);
		location().setTreasure(this);
	}
}