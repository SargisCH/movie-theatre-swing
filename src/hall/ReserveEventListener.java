package hall;
import java.util.EventListener;

public interface ReserveEventListener extends EventListener {
  public void reserve(int seatNumber, boolean reserved);
}
