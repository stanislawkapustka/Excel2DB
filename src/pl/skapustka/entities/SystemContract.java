package pl.skapustka.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "system_contract", uniqueConstraints = @UniqueConstraint(columnNames = { "request", "system_id" }) )
public class SystemContract {

	@Id
	@GeneratedValue
	@Column(nullable = false)
	private long id;

	private boolean active;

	@Column(precision = 19, scale = 2)
	private BigDecimal amount;

	@Column(length = 5)
	private String amount_period;

	@Column(length = 5)
	private String amount_type;

	@Column(precision = 19, scale = 2)
	private BigDecimal authorization_percent;

	@Type(type="date")
	private Date from_date;

	@Column(length = 12)
	private String order_number;

	@Column(length = 12)
	private String request;

	@Type(type="date")
	private Date to_date;

	@ManyToOne
	@JoinColumn(name = "system_id")
	private SystemEnt system;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getAmount_period() {
		return amount_period;
	}

	public void setAmount_period(String amount_period) {
		this.amount_period = amount_period;
	}

	public String getAmount_type() {
		return amount_type;
	}

	public void setAmount_type(String amount_type) {
		this.amount_type = amount_type;
	}

	public BigDecimal getAuthorization_percent() {
		return authorization_percent;
	}

	public void setAuthorization_percent(BigDecimal authorization_percent) {
		this.authorization_percent = authorization_percent;
	}

	public Date getFrom_date() {
		return from_date;
	}

	public void setFrom_date(Date date) {
		this.from_date = date;
	}

	public String getOrder_number() {
		return order_number;
	}

	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public Date getTo_date() {
		return to_date;
	}

	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}

	public SystemEnt getSystem() {
		return system;
	}

	public void setSystem(SystemEnt system) {
		this.system = system;
	}

}
