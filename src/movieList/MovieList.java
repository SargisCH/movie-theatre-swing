
package movieList;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;




public class MovieList {
  private int bannerHeight = 150;
  private int listMargin = 90;
  private Frame frame;
  private TimeEventListener timeEventListener;
  private List<Movie> movieList = new ArrayList<>();
  public MovieList (Frame frame) {
    this.frame = frame;
    movieList.add(new Movie("Joker", "Todd Phillips", 43.99f, "jokerbanner.jpg"));
    movieList.add(new Movie("Tenet", "Christopher Nolan", 6.99f, "tenetbanner.jpg"));
    movieList.add(new Movie("Knives Out", "Rian Johnson", 4.99f, "knivesout.jpg"));
  }
  public class Movie {
    private String title;
    private String director;
    private float price;
    private String imagePath;
    public Movie (String title, String director, float price, String imagePath){
      this.title = title;
      this.director = director;
      this.price = price;
      this.imagePath = imagePath;
    }
    public String getImagePath(){
      return imagePath;
    }
    public float getPrice(){
      return price;
    }
    public String toString() {
      return "The movie " + title + " is directed by " + director;
    }
  }
  public void render () throws IOException{
    for(int movieIndex = 0; movieIndex < movieList.size(); movieIndex++){
      Movie currentMovie = movieList.get(movieIndex);
      BufferedImage movieIcon = ImageIO.read(new File(currentMovie.getImagePath()));
      JButton movieButton = new JButton(new ImageIcon(movieIcon));
      movieButton.setBorder(BorderFactory.createEmptyBorder());
      movieButton.setBounds(0, movieIndex * (bannerHeight + listMargin)  , 512, 150);
      movieButton.addMouseListener( 
        new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              new MoviePage(currentMovie, timeEventListener);
            }
      });
      JLabel knivesOutLabel = new JLabel();
      knivesOutLabel.setText(movieList.get(movieIndex).toString());
      knivesOutLabel.setFont(new Font("Calibri",Font.PLAIN,20));
      knivesOutLabel.setBounds(0, movieIndex * (bannerHeight + listMargin) + listMargin , 512, 150);
      frame.add(movieButton);
      frame.add(knivesOutLabel);
    }
  }

  public void onTimeSelect(TimeEventListener listener) {
    timeEventListener = listener;
  }
}
