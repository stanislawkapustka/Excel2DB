package pl.skapustka.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import pl.skapustka.entities.SystemContract;

@Repository
public class SystemContractDAOImpl implements SystemContractDAO {

	private static final Logger logger = LoggerFactory.getLogger(SystemContractDAOImpl.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	@Override
	public void addSystemContract(SystemContract sc) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(sc);
		logger.info("SystemContract saved successfully, SystemContract Details=" + sc);

	}
	
	
	@Override
	public void updateSystemContract(SystemContract sc) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(sc);
		logger.info("SystemContract updated successfully, Person Details=" + sc);

	}

	@Override
	@SuppressWarnings("unchecked")
	public List<SystemContract> listSystemContracts() {
		Session session = this.sessionFactory.getCurrentSession();
		List<SystemContract> systemContractsList = session.createQuery("from SystemContract").list();
		for (SystemContract sc : systemContractsList) {
			logger.info("SystemContract List::" + sc);
		}
		return systemContractsList;
	}

	@Override
	public SystemContract getSystemContractById(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		SystemContract sc = (SystemContract) session.load(SystemContract.class, new Long(id));
		logger.info("SystemContract loaded successfully, Person details=" + sc);
		return sc;
	}

	@Override
	public void removeSystemContract(long id) {
		Session session = this.sessionFactory.getCurrentSession();
		SystemContract sc = (SystemContract) session.load(SystemContract.class, new Long(id));
		if (null != sc) {
			session.delete(sc);
		}
		logger.info("Person deleted successfully, person details=" + sc);

	}

}
