package hall;
import javax.swing.*;
import movieList.MovieList.Movie;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import utils.Theatre;

public class Hall extends JFrame{
  private CheckoutEventListener checkoutListener;
  private int rowCount = 5;
  private int columnCount = 5;
  private int startingXPosition = 10 + 50;
  private int startingYPosition = 10;
  private int width = 100;
  private int height = 100;
  private int[][] busySeats = new int[5][2];
  private List<Integer[]> reservedSeats = new ArrayList<>();

  public Hall (Movie movie){
    this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    this.setLayout(null);
    this.setSize(900, 750);
    this.setVisible(true);
    this.setResizable(false);
    for (int row = 0; row < rowCount; row++ ){
      busySeats[row][0] = (int)Math.floor(Math.random() * 5);
      busySeats[row][1] = (int)Math.floor(Math.random() * 5);
    }
    JButton payButton = new JButton();
    payButton.setFocusable(false);
    payButton.setText("Check out");
    payButton.setBounds(350, 560, 150, 40);
    payButton.setHorizontalTextPosition(JButton.CENTER);
    payButton.setBackground(Color.lightGray);
    payButton.addMouseListener( 
      new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
            checkoutListener.checkout(movie, reservedSeats);
          }
    });
    this.add(payButton);
  }
  public void createRows(){
    int x;
    int y;
    for(int row = 0; row < rowCount; row++){
      JLabel l = new JLabel();
      y = startingYPosition; 
      l.setBounds(10, ((row + 1) * startingYPosition + (row) * height) + (height / 2 -5), 50, 10);  
      l.setText("row " + (row + 1)); 
      this.add(l);
      for (int col = 0; col < columnCount; col++){
        x = startingXPosition;
        Seat seat = new Seat(col + 1, row + 1);
        x = (col + 1) * startingXPosition + (col) * width;
        y = (row + 1) * startingYPosition + (row) * height;
        seat.setBounds(x, y, width, height); 
        seat.setOpaque(true);
        if(Theatre.isSeatBusy(busySeats[row], col)){
          seat.makeBusy();
        }            
        final int rowFinal = row + 1;

        seat.onReserve(new ReserveEventListener(){
          @Override
          public void reserve(int seatNumber, boolean reserved) {
            Integer[] seatPositions = new Integer[2];
            if(reserved){
              seatPositions[0] = rowFinal;
              seatPositions[1] = seatNumber;
              reservedSeats.add(seatPositions);
            } else {
              int seatIndex = Theatre.getReservedSeatIndex(reservedSeats, rowFinal, seatNumber);
              if(seatIndex > -1){
                reservedSeats.remove(seatIndex);
              }
            }
          }
        });
        this.add(seat);
      }
    }
  }      
  public void onCheckout(CheckoutEventListener checkoutListener) {
    this.checkoutListener = checkoutListener;
  }
}
