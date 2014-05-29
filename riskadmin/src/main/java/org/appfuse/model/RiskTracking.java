package org.appfuse.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "risk_tracking")
public class RiskTracking extends BaseObject {
	
	private Long id;
	private Risk risk;
	private Date followUpDate;
	private RiskStatus status;
	private String updateDescription;
	

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "risk_tracking_id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "risk_id")
	public Risk getRisk() {
		return risk;
	}

	public void setRisk(Risk risk) {
		this.risk = risk;
	}

	@Column(name = "followup_date")
	public Date getFollowUpDate() {
		return followUpDate;
	}

	public void setFollowUpDate(Date followUpDate) {
		this.followUpDate = followUpDate;
	}

	public RiskStatus getStatus() {
		return status;
	}

	public void setStatus(RiskStatus status) {
		this.status = status;
	}

	@Column(name = "update_description")
	public String getUpdateDescription() {
		return updateDescription;
	}

	public void setUpdateDescription(String updateDescription) {
		this.updateDescription = updateDescription;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("ID: ");
		sb.append(this.getId());
		sb.append(" Description: ");
		sb.append(this.getUpdateDescription());
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof RiskTracking && ((RiskTracking)o).getId() == this.getId())
			return true;
		else
			return false;
	}

	@Override
	public int hashCode() {
		return (id != null ? id.hashCode() : 0);
	}

}
