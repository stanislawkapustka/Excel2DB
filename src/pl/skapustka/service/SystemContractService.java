package pl.skapustka.service;

import java.util.List;

import pl.skapustka.entities.SystemContract;

public interface SystemContractService {

	public void addSystemContract(SystemContract sc);
	
	public void updateSystemContract(SystemContract sc);

	public List<SystemContract> listSystemContracts();

	public SystemContract getSystemContractById(long id);

	public void removeSystemContract(long id);
	
}
