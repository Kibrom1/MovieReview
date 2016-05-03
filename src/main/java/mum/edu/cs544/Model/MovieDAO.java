package mum.edu.cs544.Model;

import java.util.ArrayList;
import java.util.List;

import mum.edu.cs544.Domain.Movie;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class MovieDAO {

	private SessionFactory sf;

	public MovieDAO(SessionFactory sf) {

		this.sf = sf;
	}

	public void addMovie(Movie movie) throws Exception {

		try {
			sf.getCurrentSession().persist(movie);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public List<Movie> getAllMovie() throws Exception {

		List<Movie> listMovies = new ArrayList<Movie>();
		try {
			Query query = sf.getCurrentSession().createQuery("From Movie m");
			listMovies = query.list();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return listMovies;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> searchByTitle(String title) throws Exception {
		List<Movie> listMovies = new ArrayList<Movie>();
		try {
			Query query = sf.getCurrentSession().createQuery(
					"From Movie m where m.title like :title");
			query.setParameter("title", "%" + title + "%");

			listMovies = query.list();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return listMovies;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> searchByGenre(String gener) throws Exception {
		List<Movie> listMovies = new ArrayList<Movie>();
		try {
			Query query = sf.getCurrentSession().createQuery(
					"From Movie m where m.gener like :gener");
			query.setParameter("gener", "%" + gener + "%");

			listMovies = query.list();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return listMovies;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> searchByRating(double rating) throws Exception {
		List<Movie> listMovies = new ArrayList<Movie>();
		try {
			Query query = sf.getCurrentSession().createQuery(
					"From Movie m where m.rating like :rating");
			query.setParameter("rating", "%" + rating + "%");

			listMovies = query.list();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return listMovies;
	}

	@SuppressWarnings("unchecked")
	public List<Movie> searchByYear(int year) throws Exception {
		List<Movie> listMovies = new ArrayList<Movie>();
		try {
			Query query = sf.getCurrentSession().createQuery(
					"From Movie m where m.rating like :year");
			query.setParameter("year", "%" + year + "%");

			listMovies = query.list();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

		return listMovies;
	}
}
