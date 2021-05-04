package hall;

import java.util.List;

import movieList.MovieList.Movie;

public interface CheckoutEventListener {
  public void checkout(Movie movie, List<Integer[]> seatList );
}
