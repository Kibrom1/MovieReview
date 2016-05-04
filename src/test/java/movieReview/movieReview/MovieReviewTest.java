package movieReview.movieReview;

import java.util.List;

import mum.edu.cs544.Domain.Actor;
import mum.edu.cs544.Domain.Director;
import mum.edu.cs544.Domain.Movie;
import mum.edu.cs544.Model.ActorDAO;
import mum.edu.cs544.Model.DirectorDAO;
import mum.edu.cs544.Model.MovieDAO;
import junit.framework.TestCase;

public class MovieReviewTest extends TestCase {

	private MovieDAO movieDao;
	private ActorDAO actorDao;
	private DirectorDAO directorDao;

	//To test both searchbytitle, addmovies and getAll movies methods
	public void testsearchByTitle() throws Exception {

		Movie movie = new Movie();

		movie.setGener("Romance");
		movie.setSummary("High school romance");
		movie.setRating(4.7);
		movie.setTitle("Love and Life");
		movie.setYear("2016");
		movie.setPoster("Having fun and loving");
		movieDao.addMovie(movie);

		List<Movie> movieList = movieDao.getAllMovie();
		assertEquals(2, movieList.size());

		@SuppressWarnings("unchecked")
		Movie newmovie = ((List<Movie>) movie).get(0);

		assertEquals("Love and Life", newmovie.getTitle());
		assertEquals("2016", newmovie.getYear());
		assertEquals("Romance", newmovie.getGener());
		assertEquals("High school romance", newmovie.getSummary());
		assertEquals("Having fun and loving", newmovie.getPoster());
		return;
	}
//test getMovie(int id) method
	public void testGetMovie() throws Exception {

		Movie movie = movieDao.getMovie(101);
		assertEquals("Love and Life", movie.getTitle());
		assertEquals("2016", movie.getYear());
		assertEquals("Romance", movie.getGener());
		assertEquals("High school romance", movie.getSummary());
		assertEquals("Having fun and loving", movie.getPoster());
		return;
	}
//test addActor, getAll actors, and addActor
	public void testGetAllActors() throws Exception {
		Actor actor = new Actor();

		actor.setName("Dicaprio");
		actor.setPlaceOfBirth("minissota,USA");
		actor.setBiography("He have acted in many movies");

		actorDao.addActor(actor);

		List<Actor> actorList = actorDao.getAllActors();
		assertEquals(1, actorList.size());

		Actor newActor = actorList.get(0);

		assertEquals("Dicaprio", newActor.getName());
		assertEquals("minissota,USA", newActor.getPlaceOfBirth());
		assertEquals("He have acted in many movies", newActor.getBiography());
		return;
	}
//teste getActor(int id) 
	public void testGetActor() throws Exception {
		Actor actor = actorDao.getActor(1001);

		assertEquals("Dicaprio", actor.getName());
		assertEquals("minissota,USA", actor.getPlaceOfBirth());
		assertEquals("He have acted in many movies", actor.getBiography());
		return;
	}
	//test addDirector, getAllDirectors, and addDirector
	public void testgetAllDirectors() throws Exception {

		Director director = new Director();

		director.setName("Tom Cruis");

		directorDao.addDirector(director);

		List<Director> directorList = directorDao.getAllDirectors();

		assertEquals(1, directorList.size());

		Director newDirector = directorList.get(0);

		assertEquals("Tom Cruis", newDirector.getName());

		return;

	}
//test getDirector(int id)
	public void testGetDirector() throws Exception {

		Director director = directorDao.getDirector(10);

		assertEquals("Tom Cruis", director.getName());

		return;
	}
}
