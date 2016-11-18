/**
 *@name Occupant.java 
 *
 *@descripiton Occupant class will be an abstract class that will extend to the objects in the Maze
 *
 *@author Angel de la Torre, Anthony Vuong
 *
 *@version CPE 102 - 05
 *@version Fall 2016
 *@version 10/28/16
 */
import java.lang.*;
import java.util.*;

public abstract class Occupant implements DelimitedTextIO
{
//instance variables
	//make a Square type variable representing location of the object 
	/* declare its privacy then the data type Square followed by the name 
	you wish to represent for location*/
	private Square square_location;

//constructors
	//make an empty constructor called Occupant
	public Occupant()
	{ square_location = square_location;}
	//make a constructor called Occupant what will accept a parameter of Square type.
		/*this constructor will make our instance variable above equal to the value
		 of the value passed parameter variable
		 */
	public Occupant(Square start)
	{
		square_location = start; 
	}

//Methods
	//make a function that will return the location 
	//of the object based on the square they're in
		 /*Simply return the value of Square variable you have ealier in the class.*/
	public Square location()
	{ return square_location;}
	//make a function that will move an object's location based of the 
	//the location you want
		/*Simply set you Square variable equal to the new Square and then return it*/
	public void moveTo(Square new_location)
	{
		square_location = new_location;
	}
	public String toText(char delimiter)
	{
		return(this.getClass().getName()+delimiter+Integer.toString(square_location.row())+delimiter+Integer.toString(square_location.col()));
	}
	public void toObject(Scanner input)
	{
		int row = input.nextInt();
		int col = input.nextInt();
		Square s = new Square(row,col);
		moveTo(s);
	}
}

	