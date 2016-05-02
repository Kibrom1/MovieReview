package mum.edu.cs544.Model;

import org.hibernate.SessionFactory;

public class DirectorDAO {

	private SessionFactory sessf;

	public DirectorDAO(SessionFactory sf) {
		this.sf = sf;
	}

}
