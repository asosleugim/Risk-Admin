package org.appfuse.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * 
 * @author d.ramirez.ledesma
 *
 */
@Entity
@Table(name = "project", uniqueConstraints = { @UniqueConstraint(columnNames = "project_code") })
public class Project extends BaseObject {
	private static final long serialVersionUID = 5498192837735678638L;
	
	private Long id;
	private String projectCode;
	private String projectName;
	private String projectDescription;
	private Set<User> users = new HashSet<User>();
	

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "project_id", unique = true, nullable = false)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "project_code", unique = true, nullable = false, length = 10)
	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	@Column(name = "project_name")
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	@Column(name = "project_description")
	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "user_project",
				joinColumns = { @JoinColumn(name = "project_id", nullable = false, updatable = false) }, 
				inverseJoinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) })
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ID: ");
		sb.append(this.id);
		sb.append(" Project Name: ");
		sb.append(this.projectName);
		return sb.toString();
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public boolean equals(Object o) {
		if(o instanceof Project && ((Project)o).getId() == this.getId())
				return true;
		else
			return false;
	}

	/**
     * {@inheritDoc}
     */
	@Override
	public int hashCode() {
		return (projectName != null ? projectName.hashCode() : 0);
	}
}
