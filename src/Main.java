import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.EventListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import movieList.MovieList;
import movieList.TimeEventListener;
import movieList.MovieList.Movie;
import hall.Hall;

public class Main {
    public String title;
    public String director;
    public List<String> cast;
    public int year;
    public float price;
    public static int userChoice;
    public static void main(String[] args) throws IOException {
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(545, 800);
      frame.setLayout(null);
      frame.setResizable(false);
        MovieList movieList  = new MovieList(frame);
        movieList.render();
        movieList.onTimeSelect( new TimeEventListener(){
          public void timeSelected(Movie movie) {
            Hall hall = new Hall(movie);
            hall.createRows();
            hall.onCheckout(new hall.CheckoutEventListener(){
              @Override
              public void checkout(Movie movie, List<Integer[]> seatList) {
                Invoice invoicePage = new Invoice(movie, seatList);
                try{
                  if(seatList.size() > 0){
                    invoicePage.render();
                  }
                } catch(IOException e ){
                System.out.println(e.getMessage());
                }
              }
            });
          };
        });
      frame.setVisible(true);

    }
}
