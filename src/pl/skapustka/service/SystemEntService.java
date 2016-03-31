package pl.skapustka.service;

import java.util.List;

import pl.skapustka.entities.SystemEnt;

public interface SystemEntService {

	public void addSystemEnt(SystemEnt se);
		
	public void updateSystemEnt(SystemEnt se);

	public List<SystemEnt> listSystemEnts();

	public SystemEnt getSystemEntById(long id);

	public void removeSystemEnt(long id);
}
