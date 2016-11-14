/**
 *@name DrawableTreasure.java 
 *
 *@descripiton a file that will implement the interface Drawable and extend the Treasure class while being able to draw the Squares in the Maze
 *
 *@author Angel de la Torre, Anthony Vuong
 *
 *@version CPE 102 - 05
 *@version Fall 2016
 *@version 10/28/16
 */

//Constructor
	//a function that takes in a maze and initialzes the object in a random location within the maze
	//a function that takes in a maze and a seed and will initliaze the object in a seeded location within the maze
	//a function that takes in a maze and a prechosen location and will initialize the object within the maze at the
	//prechosen location
public class DrawableTreasure extends Treasure implements Drawable{

//Method
	// a function to draw itself within the maze only if it has been seen by the explorer object
	public DrawableTreasure(Maze maze) {
		super(maze);
	}
	
	public DrawableTreasure(Maze maze, long seed) {
		super(maze, seed);
	}
	
	public DrawableTreasure(Maze maze, Square location) {
		super(maze, location);
	}

	public void draw() {}
}
