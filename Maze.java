import java.util.*;
import java.io.*;

/**
 * Class that contains all the logic to model a Maze with Treasures, Monsters, and an Explorer.
 * 
 * @author Anthony Vuong and Angel de la Torre 
 * @version 11/2/16
 */


public class Maze
{
   // named constants
   public static final int ACTIVE = 0;
   public static final int EXPLORER_WIN = 1;
   public static final int MONSTER_WIN = 2;
    
    // instance variables
   private Square[][] squares;
   private ArrayList<RandomOccupant> randOccupants;
   private Explorer explorer;
   private int rows;
   private int cols;

   /**
    * Constructor for objects of class Maze
    */
   public Maze(Square[][] squares, int rows, int cols)
   {
      // CHANGE - initialize the squares, rows, and cols instance variables to
      //          what is passed in to the constructor
	   this.squares = squares;
      this.rows = rows;
      this.cols = cols;
      // CHANGE - create the empty ArrayList of RandomOccupants
      randOccupants = new ArrayList<RandomOccupant>();
   }
   public Maze()
   {
    randOccupants = new ArrayList<RandomOccupant>();
   }
	
   // QUERIES
   public Square getSquare(int row, int col){ 
    return squares[row][col]; 
   }
   public int rows() {return rows;}
   public int cols() {return cols;}
   public String explorerName() {return explorer.name();}
   public Explorer getExplorer() {return explorer;}
    
   // CHANGE - Implement the following two methods.  I have them stubbed to return dummy values just so it will compile.
   //          Your getRandomOccupant should return the occupant from the ArrayList at the specified index.
  public RandomOccupant getRandomOccupant(int index) 
  {
    return randOccupants.get(index);
  }

   public int getNumRandOccupants() 
   { return randOccupants.size();}
	
   // COMMANDS
   // CHANGE - implement the following method
   public void addRandomOccupant(RandomOccupant ro) 
   {
    randOccupants.add(ro);
  }
	
   public void setExplorer(Explorer e) {explorer = e;}
	
   public void explorerMove(int key)
   {
      explorer.move(key);
   }
	
   public void randMove()
   {
      // CHANGE - instruct each object in the RandomOccupant to move
    for(int i = 0; i < randOccupants.size(); i++){
      randOccupants.get(i).move();
    }
   }
	
   /**
    * Returns the status of the game.
    *
    * If all treasures have been found, return EXPLORER_WIN.
    * If not, check each maze occupant, if it is a Monster and
    *    it is in the same location as the Explorer, return
    *    MONSTER_WIN.  Note that you can use == to check locations, do you know why?
    * Otherwise, return ACTIVE.
    */
   public int gameStatus()
   {
      int status = ACTIVE;
      if(this.foundAllTreasures() == true)
      {
        return EXPLORER_WIN;
      } 
      for(int i = 0; i < randOccupants.size(); i++)
      {
        if(randOccupants.get(i) instanceof Monster)
        {
          if( ((Monster)randOccupants.get(i)).location() == explorer.location())
          {return MONSTER_WIN;}
        }
      }
      // CHANGE - implement
      return status;
   }
	
   private boolean foundAllTreasures()
   {
      boolean foundAll = true;
        
      // CHANGE - search through all the RandomOccupants to see if the Treasures have been found.  Return false if
      //        - there is a Treasure that hasn't been found.  Note:  This should work for subclasses of Treasure, as well.
      for(int i = 0; i < randOccupants.size(); i++)
      {
        if(randOccupants.get(i) instanceof Treasure)
        {
          Treasure t = ((Treasure)randOccupants.get(i));  
          if(t.found() != true){ 
            foundAll = false;
            return foundAll;
            }
        }
      }
              
      return foundAll;
   }
    
   public void lookAround(Square s)
   {
      int row = s.row();
      int col = s.col();
      // Clear what was previously in view
      resetInView();
        
      // Set the current square so that we are viewing it (obviously)
      s.setInView(true);
      // CHANGE - Check the adjacent squares.  If there isn't a wall in the way, set their inview to true.
        
      //check if there is a wall in UP direction

       if( s.wall(s.RIGHT) == false){
            (getSquare(row,col+1)).setInView(true);
            if( getSquare(row,col+1).wall(s.UP) == false){
                (getSquare(row-1,col+1)).setInView(true);
            }
            if( getSquare(row,col+1).wall(s.DOWN) == false){
                (getSquare(row+1,col+1)).setInView(true);
            }
        }
      if( s.wall(s.DOWN) == false){
            (getSquare(row+1,col)).setInView(true);  
            if( getSquare(row+1,col).wall(s.LEFT) == false){
                (getSquare(row+1,col-1)).setInView(true);
            }
            if( getSquare(row+1,col).wall(s.RIGHT) == false){
                (getSquare(row+1,col+1)).setInView(true);
            }
       }

      if( s.wall(s.LEFT) == false){
            (getSquare(row,col-1)).setInView(true);
            if( getSquare(row,col-1).wall(s.UP) == false){
                (getSquare(row-1,col-1)).setInView(true);
            }
            if( getSquare(row,col-1).wall(s.DOWN) == false){
                (getSquare(row+1,col-1)).setInView(true);
            }
        }
        if( s.wall(s.UP) == false){
           (getSquare(row-1,col)).setInView(true);
            if( getSquare(row-1,col).wall(s.LEFT) == false){
                  (getSquare(row-1,col-1)).setInView(true);
            }
            if( getSquare(row-1,col).wall(s.RIGHT) == false){             
                  (getSquare(row-1,col+1)).setInView(true);
            }        
        }
    }
   private void resetInView()
   {
      for (int i = 0; i<rows; i++) {
         for (int j = 0; j<cols; j++) {
            squares[i][j].setInView(false);
         }
      }
   }
   public void writeMazeToFile(String fileName) throws IOException
   {
      try{
        char delimiter = ',';
        File file = new File(fileName);
        PrintWriter writer = new PrintWriter(file);
        writer.print(Integer.toString(this.rows) + delimiter + Integer.toString(this.cols));
        writer.println();
        for(int x = 0; x < rows; x++)
        {  for(int y = 0; y < cols; y++)
            {
              writer.print(squares[x][y].toText(delimiter));
              writer.println();
            }
        }
        if (explorer != null){
          writer.print(explorer.toText(delimiter));
          writer.println();
        }
        for(int i = 0; i < randOccupants.size(); i++)
        {
          if(randOccupants.get(i) instanceof Treasure){
            writer.print(randOccupants.get(i).toText(delimiter));
            writer.println();
          } 
        }
        for(int i = 0; i < randOccupants.size(); i++)
        {
          if(randOccupants.get(i) instanceof Monster){
            writer.print(randOccupants.get(i).toText(delimiter));
            writer.println();
          }
        }
        writer.flush();
      } catch (IOException ioe) {
        System.err.println("IOException:" + ioe.getMessage());
      }
    }
    //read from a text file and creates a maze from what is read
    public void readMazeFromFile(String fileName) throws IOException, FileNotFoundException, MazeReadException
    {
        String delimiter = ",";
        //intialize the file
        File file = new File(fileName);
        //scanner 1 to read the file 
        Scanner fileReader = null;
     
          fileReader = new Scanner(file);
          //counter to keep track of the line being read
          int lineCounter = 1;
         
          while(fileReader.hasNextLine()){
             
            String line = fileReader.nextLine();
            //starting to read each string within the line
            Scanner input = new Scanner(line).useDelimiter(delimiter);
            // starting to read each line
            if(!input.hasNextLine())
                throw new MazeReadException("Line format or other error.", line, lineCounter);
            while(input.hasNext()){
                //check the first line for the row and col integers
                if(lineCounter == 1)
                {
                  if(input.hasNextInt()){
                    this.rows = input.nextInt();
                    this.cols = input.nextInt();
                    this.squares = new Square[rows][cols];
                  }
                  else
                    throw new MazeReadException("Rows and columns not specified." , line, lineCounter);
                }
               else
                {
                    //obtains the name of the first part of the string in order to be used for the switch
                    String className = input.next();
                  
                    //switch to be used for the dependent class names
                    switch(className){
                      case "Square":
                        int ro = input.nextInt();
                        int co = input.nextInt(); 
                        Square s = new Square(ro,co);
                        try{
                          s.toObject(input);}
                        catch(Exception a)
                        {
                          throw new MazeReadException("Line format or other error.", line, lineCounter);
                        }
                        if(squares[ro][co] != null)
                          throw new MazeReadException("Duplicate square.", line, lineCounter);
                        else{
                          this.squares[ro][co] = s;
                        }
                        break;
                      case "Explorer":
                        Explorer e =  new Explorer(this);
                        int rol = input.nextInt();
                        int cow = input.nextInt(); 
                        Square sq = squares[rol][cow];
                        try{
                          e.toObject(input);
                        }
                        catch(Exception b)
                        {
                          throw new MazeReadException("Line format or other error.", line, lineCounter);
                        }
                        e.moveTo(sq);
                        this.setExplorer(e);
                        break;
                      case "Monster":
                        Monster mon = new Monster(this);
                        try{
                         mon.toObject(input);
                        }
                        catch(Exception c)
                        {
                          throw new MazeReadException("Line format or other error.", line, lineCounter);
                        }
                        randOccupants.add(mon);
                        break;
                      case "Treasure":
                        Treasure t = new Treasure(this);
                        try{
                         t.toObject(input);
                        }
                        catch(Exception d)
                        {
                          throw new MazeReadException("Line format or other error.", line, lineCounter);
                        }
                        randOccupants.add(t);
                        break;
                      default:
                        throw new MazeReadException("Unknown type.", line, lineCounter);
                    } 
      
               }
               lineCounter++;
            }
          //close the second scanner
          input.close();
        }
      //close the first scanner
      fileReader.close();
  }

}

