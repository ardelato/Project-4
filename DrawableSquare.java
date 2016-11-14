/**
 *@name DrawableSquare.java 
 *
 *@descripiton a file that will implement the interface Drawable and extend the Square class while being able to draw the Squares in the Maze
 *
 *@author Angel de la Torre, Anthony Vuong
 *
 *@version CPE 102 - 05
 *@version Fall 2016
 *@version 10/28/16
 */

//Constructor
	//takes in a the previously defined directions (up,down,left, right) in addition to the row and column
	/* will initialize all the parameters with variables from the parent class (Square)
	*/
public class DrawableSquare extends Square implements Drawable{
	public DrawableSquare(boolean up, boolean right, boolean down, boolean left, int row, int col){
		super(up, right, down, left, row, col);
	}

//Methods
	//a function to draw the square	on the screen only if its in view or it has been seen
	//if it has been seen but not in view then the square will be a darker color
	public void draw() {}

}
