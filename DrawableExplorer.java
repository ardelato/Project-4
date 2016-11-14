/**
 *@name DrawableExplorer.java 
 *
 *@descripiton a file that will implement the interface Drawable and extend the Explorer class while being able to draw the Squares in the Maze
 *
 *@author Angel de la Torre, Anthony Vuong
 *
 *@version CPE 102 - 05
 *@version Fall 2016
 *@version 10/28/16
 */

//Constructor
	//a function takes in a location, a maze, and a "name" and will intialize these parameters
	//with the variables from the parent class(Explorer)

public class DrawableExplorer extends Explorer implements Drawable{

//Method
	//A function to draw the "explorer" on the screen 
	public DrawableExplorer(Square location, Maze maze, String name){
		super(location, maze, name);
	}

	public void draw() {}
	
}
