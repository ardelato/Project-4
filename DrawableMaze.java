/**
 *@name DrawableMaze.java 
 *
 *@descripiton a file that will implement the interface Drawable and extend the Maze class while being able to draw the Squares in the Maze
 *
 *@author Angel de la Torre, Anthony Vuong
 *
 *@version CPE 102 - 05
 *@version Fall 2016
 *@version 10/28/16
 */

//Constructor
	//a function takes in a DrawableSqare double array of the maze, and a row and col.
	//using the parent class (Maze) it will initialize all the variables. 
//Methods
	// a function that will draw the entire maze, to do so do the following
	/* Add all the rows and cols together to get the width and length of the rectangle to draw.
	*  Then draw all the squares in the maze. 
	*  Then draw all the random occupants within the maze.
	*  Lastly, draw the explorer.*/
public class DrawableMaze extends Maze implements Drawable {

	public DrawableMaze(Square[][] squares, int rows, int cols) {
		super(squares, rows, cols);
	}

	public void draw() {}
	

}
