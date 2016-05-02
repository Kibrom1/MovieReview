package mum.edu.cs544.Model;



import org.hibernate.SessionFactory;

public class MovieDAO {

	private SessionFactory sessf;
	
	public MovieDAO(SessionFactory sf){
		
		this.sessf = sf;
	}
}
