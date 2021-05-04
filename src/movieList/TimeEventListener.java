package movieList;
import movieList.MovieList.Movie;
import java.util.EventListener;

public interface TimeEventListener extends EventListener {
    public void timeSelected(Movie movie);
}
