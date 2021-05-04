package movieList;
import javax.swing.JFrame;
import movieList.MovieList.Movie;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MoviePage extends JFrame{
  public MoviePage(Movie movie, TimeEventListener timeEventListener){
    ImageIcon joker = new ImageIcon(movie.getImagePath());
        JLabel jokerLabel = new JLabel();
        jokerLabel.setIcon(joker);
        jokerLabel.setText(movie.toString());
        jokerLabel.setBounds(0, 0, 512, 150);

        JButton button1 = new JButton();
        button1.setText("12:30");
        button1.setFocusable(false);
        button1.setFont(new Font("Calibri",Font.BOLD,20));
        button1.setBounds(187, 170, 150, 75);
        button1.setHorizontalTextPosition(JButton.CENTER);
        button1.setBackground(Color.lightGray);
        button1.setBorder(BorderFactory.createBevelBorder(5));
        button1.addMouseListener( 
          new MouseAdapter() {
              @Override
              public void mouseClicked(MouseEvent e) {
                timeEventListener.timeSelected(movie);
              }
        });
        JButton button2 = new JButton();
        button2.setText("15:30");
        button2.setFocusable(false);
        button2.setFont(new Font("Calibri",Font.BOLD,20));
        button2.setBounds(187, 270, 150, 75);
        button2.setHorizontalTextPosition(JButton.CENTER);
        button2.setBackground(Color.lightGray);
        button2.setBorder(BorderFactory.createBevelBorder(5));
        button2.addMouseListener( 
          new MouseAdapter() {
              @Override
              public void mouseClicked(MouseEvent e) {
                timeEventListener.timeSelected(movie);
              }
        });
        JButton button3 = new JButton();
        button3.setText("19:30");
        button3.setFocusable(false);
        button3.setFont(new Font("Calibri",Font.BOLD,20));
        button3.setBounds(187, 370, 150, 75);
        button3.setHorizontalTextPosition(JButton.CENTER);
        button3.setBackground(Color.lightGray);
        button3.setBorder(BorderFactory.createBevelBorder(5));
        button3.addMouseListener( 
          new MouseAdapter() {
              @Override
              public void mouseClicked(MouseEvent e) {
                timeEventListener.timeSelected(movie);
              }
        });
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLayout(null);
        this.setSize(525,500);
        this.setVisible(true);
        this.setResizable(false);
        this.add(jokerLabel);
        this.add(button1);
        this.add(button2);
        this.add(button3);
  }
}
