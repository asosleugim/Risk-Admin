package org.appfuse.model;

public class Risk extends BaseObject {
	
	private Long id;
	private String riskName;
	private String riskDescription;
	private String mitigationPlan;
	private String contingencyPlan;
	private User owner;

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
