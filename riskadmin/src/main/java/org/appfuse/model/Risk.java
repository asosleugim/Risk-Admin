package org.appfuse.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 * @author d.ramirez.ledesma
 *
 */
@Entity
@Table(name = "risk")
public class Risk extends BaseObject {
	
	private Long id;
	private String riskName;
	private String riskDescription;
	private Date creationDate;
	private String mitigationPlan;
	private String contingencyPlan;
	private Project project;
	private User owner;
	private Set<RiskTracking> riskTracking = new HashSet<RiskTracking>();

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "risk_id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "risk_name")
	public String getRiskName() {
		return riskName;
	}

	public void setRiskName(String riskName) {
		this.riskName = riskName;
	}

	@Column(name = "risk_description")
	public String getRiskDescription() {
		return riskDescription;
	}

	public void setRiskDescription(String riskDescription) {
		this.riskDescription = riskDescription;
	}

	@Column(name = "creation_date")
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Column(name = "mitigation_plan")
	public String getMitigationPlan() {
		return mitigationPlan;
	}

	public void setMitigationPlan(String mitigationPlan) {
		this.mitigationPlan = mitigationPlan;
	}

	@Column(name = "contigency_plan")
	public String getContingencyPlan() {
		return contingencyPlan;
	}

	public void setContingencyPlan(String contingencyPlan) {
		this.contingencyPlan = contingencyPlan;
	}
	
	@ManyToOne
	@JoinColumn(name = "project_id")
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	@OneToMany(mappedBy = "risk", fetch = FetchType.EAGER)
	public Set<RiskTracking> getRiskTracking() {
		return riskTracking;
	}

	public void setRiskTracking(Set<RiskTracking> riskTracking) {
		this.riskTracking = riskTracking;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("ID: ");
		sb.append(this.getId());
		sb.append(" Risk Name: ");
		sb.append(this.getRiskName());
		return sb.toString();
	}

	@Override
	public boolean equals(Object o) {
		if(o instanceof Risk && ((Risk)o).getId() == this.id)
			return true;
		else
			return false;
	}

	@Override
	public int hashCode() {
		return (riskName != null ? riskName.hashCode() : 0);
	}

}
