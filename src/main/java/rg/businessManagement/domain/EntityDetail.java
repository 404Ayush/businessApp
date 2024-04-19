package rg.businessManagement.domain;

public class EntityDetail {
	private String entityName;
	private String gstNumber;
	
	public String getEntityName() {
		return entityName;
	}
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	public String getGstNumber() {
		return gstNumber;
	}
	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}
	
	@Override
	public String toString() {
		return "EntityDetails [entityName=" + entityName + ", gstNumber=" + gstNumber + "]";
	}
	
}
