package utils;

import java.util.List;

public class Theatre {
  public static boolean isSeatBusy(int[] row, int seatNumber){
    for(int seat = 0; seat < row.length; seat++ ){
      if(row[seat] == seatNumber){
        return true;
      }
    }
    return false;
  }
  public static int getReservedSeatIndex(List<Integer[]> seatPositions, int row, int col){
    for(int seatPosition = 0; seatPosition < seatPositions.size(); seatPosition++ ){
      if(seatPositions.get(seatPosition)[0] == row && seatPositions.get(seatPosition)[1] == col){
        return seatPosition;
      }
    }
    return -1;
  }
}
