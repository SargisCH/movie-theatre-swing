package hall;
import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;

public class Seat extends JButton {
  private Color redColor = new Color(139, 0, 0);
  private ReserveEventListener reserveListener;
  private int row;
  private int seatNumber;
  public Seat (int SeatNumber, int row){
    this.setText("Seat" + " " + SeatNumber);
    this.seatNumber = SeatNumber;
    this.row = row;
    SeatEventHandler seatEventHandler = new SeatEventHandler(this);
    this.addActionListener(seatEventHandler);
  }
  class SeatEventHandler implements ActionListener {
    private Seat seat;
    public SeatEventHandler(Seat seat){
      this.seat = seat;
    }
    public void actionPerformed(ActionEvent e){
      // seat.setBorderPainted(true);
      if(!seat.busy()){
        if(seat.reserved()){
          seat.unReserve();
          reserveListener.reserve(seatNumber, false);
          seat.setBackground(null);
        } else{
          seat.reserve();
          reserveListener.reserve(seatNumber, true);
          seat.setBackground(Color.yellow);
        }
      }
  
    }  
  }
  public enum STATUS{
    RESERVED,
    BUSY,
    FREE
  }
  private STATUS status = STATUS.FREE;
  public STATUS getStatus(){
    return status;
  }
  public void reserve (){
    status = STATUS.RESERVED;
  }
  
  public void makeBusy (){
    status = STATUS.BUSY;
    this.setBackground(this.redColor);
  }
  
  public void unReserve (){
    status = STATUS.FREE;
  }

  public boolean busy (){
    return status.equals(STATUS.BUSY);
  }
  
  public boolean reserved (){
    return status.equals(STATUS.RESERVED);
  }
  public void onReserve(ReserveEventListener listener){
    reserveListener = listener;
  }
}
