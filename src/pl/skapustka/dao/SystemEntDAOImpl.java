package pl.skapustka.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pl.skapustka.entities.SystemEnt;

@Repository
public class SystemEntDAOImpl implements SystemEntDAO {

	private static final Logger logger = LoggerFactory.getLogger(SystemEntDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addSystemEnt(SystemEnt se) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(se);
		logger.info("SystemContract saved successfully, SystemContract Details=" + se);

	}

	@Override
	public void updateSystemEnt(SystemEnt se) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(se);
		logger.info("SystemContract updated successfully, Person Details=" + se);

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SystemEnt> listSystemEnts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<SystemEnt> systemEntsList = session.createQuery("from SystemEnt").list();
		for (SystemEnt se : systemEntsList) {
			logger.info("SystemContract List::" + se);
		}
		return systemEntsList;
	}

	@Override
	public SystemEnt getSystemEntById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		SystemEnt se = (SystemEnt) session.load(SystemEnt.class, new Long(id));
		logger.info("SystemContract loaded successfully, Person details=" + se);
		return se;
	}

	@Override
	public void removeSystemEnt(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		SystemEnt se = (SystemEnt) session.load(SystemEnt.class, new Long(id));
		if (null != se) {
			session.delete(se);
		}
		logger.info("Person deleted successfully, person details=" + se);

	}

}
