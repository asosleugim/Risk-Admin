package org.appfuse.model;

import java.util.Date;

public class RiskTracking extends BaseObject {
	
	private Long id;
	private Risk risk;
	private Date followUpDate;
	private RiskStatus status;
	private String updateDescription;
	

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

}
