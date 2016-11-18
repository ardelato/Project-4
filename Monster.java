/**
 * Monster.java
 * @version Project 3
 * @author Anthony Vuong and Angel De La Torre
 * @version CPE102-05
 * @version Fall 2016
 */

/*
public class Monster extends RandomOccupant

constructor: we can use super technique on maze to get access from parent class
public Monster - Maze maze
public Monster - Maze maze, long seed
public Monster - Maze maze, Square location
 */

public class Monster extends RandomOccupant{
	
	public Monster(Maze maze){
		super(maze);
		
	}
	public Monster(Maze maze, long seed)
	{
		super(maze, seed);
	}
	public Monster(Maze maze, Square location)
	{
		super(maze, location);
	}
	public String toText(char delimiter)
	{
		return(super.toText(delimiter));
	}
}
