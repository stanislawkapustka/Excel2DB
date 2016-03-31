package pl.skapustka.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;

import pl.skapustka.dao.SystemContractDAO;
import pl.skapustka.entities.SystemContract;

@Service
public class SystemContractServiceImpl implements SystemContractService {

	private SystemContractDAO systemContractDao;

	public void setSystemContractDao(SystemContractDAO systemContractDao) {
		this.systemContractDao = systemContractDao;
	}

	@Override
	@Transactional
	public void addSystemContract(SystemContract sc) {
		this.systemContractDao.addSystemContract(sc);

	}
	
	@Override
	@Transactional
	public void updateSystemContract(SystemContract sc) {
		this.systemContractDao.updateSystemContract(sc);

	}

	@Override
	@Transactional
	public List<SystemContract> listSystemContracts() {
		return this.systemContractDao.listSystemContracts();
	}

	@Override
	@Transactional
	public SystemContract getSystemContractById(long id) {
		return this.systemContractDao.getSystemContractById(id);
	}

	@Override
	@Transactional
	public void removeSystemContract(long id) {
		this.systemContractDao.removeSystemContract(id);
	}
}
