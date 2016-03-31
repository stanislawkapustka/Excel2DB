package pl.skapustka.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import pl.skapustka.dao.SystemEntDAO;
import pl.skapustka.entities.SystemEnt;

@Service
public class SystemEntServiceImpl implements SystemEntService {

	private SystemEntDAO systemEntDao;

	public void setSystemEntDao(SystemEntDAO systemEntDao) {
		this.systemEntDao = systemEntDao;
	}

	@Override
	@Transactional
	public void addSystemEnt(SystemEnt se) {
		this.systemEntDao.addSystemEnt(se);

	}
		
	@Override
	@Transactional
	public void updateSystemEnt(SystemEnt se) {
		this.systemEntDao.updateSystemEnt(se);

	}

	@Override
	@Transactional
	public List<SystemEnt> listSystemEnts() {
		return this.systemEntDao.listSystemEnts();
	}

	@Override
	@Transactional
	public SystemEnt getSystemEntById(long id) {
		return this.systemEntDao.getSystemEntById(id);
	}

	@Override
	@Transactional
	public void removeSystemEnt(long id) {
		this.systemEntDao.removeSystemEnt(id);
	}
}
