package edu.oregonstate.cs361.battleship;

import java.util.ArrayList;
import java.util.Random;
import java.util.StringJoiner;

/**
 * Created by guita on 3/13/2017.
 */
public class Easy extends BattleshipModel{
    
    private Ship aircraftCarrier;
    private Ship battleship;
    private Ship submarine;
    private Ship clipper;
    private Ship dhingy;
    private Ship fisher;

    private Ship computer_aircraftCarrier;
    private Ship computer_battleship;
    private Ship computer_submarine;
    private Ship computer_clipper;
    private Ship computer_dhingy;
    private Ship computer_fisher;

    ArrayList<ShotData> playerHits;
    ArrayList<ShotData> playerMisses;
    ArrayList<ShotData> computerHits;
    ArrayList<ShotData> computerMisses;

    public Easy(){
        playerHits = new ArrayList<>();
        playerMisses= new ArrayList<>();
        computerHits = new ArrayList<>();
        computerMisses= new ArrayList<>();

        aircraftCarrier = new Ship("AircraftCarrier",5, new Coordinate(0,0),new Coordinate(0,0));
        battleship = new StealthShip("Battleship",4, new Coordinate(0,0),new Coordinate(0,0));
        submarine = new StealthShip("Submarine",2, new Coordinate(0,0),new Coordinate(0,0));
        clipper = new CivilianShip("Clipper", 3, new Coordinate(0, 0), new Coordinate(0, 0));
        dhingy = new CivilianShip("Dhingy", 1, new Coordinate(0, 0), new Coordinate(0, 0));
        fisher = new CivilianShip("Fisher", 2, new Coordinate(0, 0), new Coordinate(0, 0));


        computer_aircraftCarrier = new Ship("Computer_AircraftCarrier",5, new Coordinate(1,1),new Coordinate(5,1));
        computer_battleship = new StealthShip("Computer_Battleship",4, new Coordinate(5,5),new Coordinate(2,5));
        computer_submarine = new StealthShip("Computer_Submarine",2, new Coordinate(8,8),new Coordinate(10,8));
        computer_clipper = new CivilianShip("Computer_Clipper", 3, new Coordinate(10, 6), new Coordinate(10, 9));
        computer_dhingy = new CivilianShip("Computer_Dhingy", 1, new Coordinate(10, 10), new Coordinate(10, 10));
        computer_fisher = new CivilianShip("Computer_Fisher", 2, new Coordinate(9, 1), new Coordinate(10, 1));
    }

    //place ships
    public void computerplaceShips() {
       
  }


    /*The function will fire on every other tile. FIRST, it will cover 0 and even numbered tiles
     *i.e. array[0][0], array[0][2], array[0][4]...
     *Then it will fire down; array[1][0]...array[9][0] covering the even tiles as above
     *Then it will go back to the top and fire on odd tiles
     *i.e. array[0][1], array[0][3], array[0][5]...
     *Then it will fire down in the same fashion stated above
     */

    @Override
    public void shootAtPlayer(){
        int max = 10, min = 1, row = 0, col = 0;
        Coordinate coor = new Coordinate(row, col);
        //firing on 0 and even numbers
        for(int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j = j + 2) {
                coor.setDown(i);
                coor.setAcross(j);

                //check for duplicates
                for(ShotData s : computerHits){
                    if(s.loc.getAcross() == coor.getAcross() && s.loc.getDown() == coor.getDown()){
                        shootAtPlayer();
                        playerShot(coor);
                        return;
                    }
                }
                for(ShotData s : computerMisses){
                    if(s.loc.getAcross() == coor.getAcross() && s.loc.getDown() == coor.getDown()){
                        shootAtPlayer();
                        playerShot(coor);
                        return;
                    }
                }
            }
        }
        playerShot(coor);
        for(int i = 0; i < 10; i++){
            for(int j = 1; j < 10; j=j+2){
                coor.setDown(i);
                coor.setAcross(j);

                //check for duplicates
                for(ShotData s : computerHits){
                    if(s.loc.getAcross() == coor.getAcross() && s.loc.getDown() == coor.getDown()){
                        shootAtPlayer();
                        playerShot(coor);
                        return;
                    }
                }
                for(ShotData s : computerMisses){
                    if(s.loc.getAcross() == coor.getAcross() && s.loc.getDown() == coor.getDown()){
                        shootAtPlayer();
                        playerShot(coor);
                        return;
                    }
                }
            }
        }
    }
}


