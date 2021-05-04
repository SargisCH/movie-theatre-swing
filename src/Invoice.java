import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

import movieList.MovieList.Movie;

public class Invoice extends JFrame{
  private Movie movie;
  private List<Integer[]> seatList;
  private int bannerHeight = 150;
  private int defaultMargin = 20;
  public Invoice(Movie movie, List<Integer[]> seatList){
    this.movie = movie;
    this.seatList = seatList;
  }
  public void render() throws IOException {
    JLabel movieBanner = new JLabel();
    movieBanner.setIcon(new ImageIcon(movie.getImagePath()));
    movieBanner.setBounds(10, 10, 512, bannerHeight);
    JLabel movieLabel = new JLabel();
    movieLabel.setText(movie.toString());
    movieLabel.setBounds(10, bannerHeight + defaultMargin, 512, 20);
    JLabel seatListHeaderLabel = new JLabel();
    seatListHeaderLabel.setBounds(10, bannerHeight + (defaultMargin * 2), 512, 20);
    seatListHeaderLabel.setText("Your Seats");
    this.add(movieBanner);
    this.add(movieLabel);
    this.add(seatListHeaderLabel);
    float totalPrice = 0;
    for(int seat = 0; seat < seatList.size(); seat++){
      JLabel seatLabel = new JLabel();
      Integer[] currentSeat = seatList.get(seat);
      float price = movie.getPrice();
      totalPrice += price;
      seatLabel.setText("row" + " " + currentSeat[0] + " " + "seat number is" + " " + currentSeat[1]+ " : " + price + " AMD ");
      seatLabel.setBounds(10, bannerHeight + (defaultMargin * 2) + (seat + 1) * defaultMargin, 512, 20);
      this.add(seatLabel);
    }
    JLabel totalPriceLabel = new JLabel();
    totalPriceLabel.setBounds(10, bannerHeight + (defaultMargin * 2) + seatList.size() * defaultMargin + defaultMargin, 200, 20);
    totalPriceLabel.setText("Total Price: " + totalPrice);
    this.add(totalPriceLabel);
    JButton closeButton = new JButton();
    closeButton.setFocusable(false);
    closeButton.setText("Close");
    closeButton.setBounds(210,  bannerHeight + (defaultMargin * 2) + seatList.size() * defaultMargin + defaultMargin, 150, 40);
    closeButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
          System.exit(0);
      }
    });
    this.add(closeButton);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLayout(null);
    this.setSize(525,500);
    this.setVisible(true);
    this.setResizable(false);
  }
}
