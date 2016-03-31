package pl.skapustka.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "system")
public class SystemEnt {

	@Id
	@GeneratedValue
	@Column(nullable = false)
	private long id;

	@Column(length = 500)
	private String description;

	@Column(length = 50, unique = true)
	private String name;

	@Column(length = 50, unique = true)
	private String support_group;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSupport_group() {
		return support_group;
	}

	public void setSupport_group(String support_group) {
		this.support_group = support_group;
	}

}
