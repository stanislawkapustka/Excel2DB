package pl.skapustka.dao;

import java.util.List;

import pl.skapustka.entities.SystemContract;

public interface SystemContractDAO {
	public void addSystemContract(SystemContract sc);
	public void updateSystemContract(SystemContract sc);
    public List<SystemContract> listSystemContracts();
    public SystemContract getSystemContractById(long id);
    public void removeSystemContract(long id);
}
