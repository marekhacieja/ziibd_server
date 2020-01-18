package pl.marekhacieja.ziibd.model;

public class SalaryAudit {

    private String id;
    private String employeeId;
    private java.sql.Date dop;
    private String oldSalary;
    private String newSalary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public java.sql.Date getDop() {
        return dop;
    }

    public void setDop(java.sql.Date dop) {
        this.dop = dop;
    }

    public String getOldSalary() {
        return oldSalary;
    }

    public void setOldSalary(String oldSalary) {
        this.oldSalary = oldSalary;
    }

    public String getNewSalary() {
        return newSalary;
    }

    public void setNewSalary(String newSalary) {
        this.newSalary = newSalary;
    }

}
