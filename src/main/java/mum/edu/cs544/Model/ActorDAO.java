package mum.edu.cs544.Model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import mum.edu.cs544.Domain.Actor;

import org.hibernate.SessionFactory;

public class ActorDAO {

	private SessionFactory sf;

	public ActorDAO(SessionFactory sf) {
		this.sf = sf;
	}

	public List<Actor> getAllActors() {

		List<Actor> actors = new ArrayList<Actor>();

		try {
			Query criteria = sf.getCurrentSession().createQuery(
					"From Actor act");
			actors = criteria.list();
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return actors;
	}

	public void addActor(Actor actor) throws Exception {

		try {

			sf.getCurrentSession().persist(actor);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
