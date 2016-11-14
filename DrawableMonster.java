/**
 *@name DrawableMonster.java 
 *
 *@descripiton a file that will implement the interface Drawable and extend the Monster class while being able to draw the Squares in the Maze
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
	//a function that takes in a maze and a prechosen location and will initialize the object within the maze at thge
	//prechosen location
public class DrawableMonster extends Monster implements Drawable {


//Method
	//A function to draw the object within the maze only if the object is within the explorer object.
	public DrawableMonster(Maze maze) {
		super(maze);
	}
	public DrawableMonster(Maze maze, long seed) {
		super(maze, seed);
	}
	public DrawableMonster(Maze maze, Square Location) {
		super(maze, Location);
	}
	public void draw() {}

}
