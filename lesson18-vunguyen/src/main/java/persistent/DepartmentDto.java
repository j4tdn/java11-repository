package persistent;

public class DepartmentDto {
    private String dept_name;
    private String project_details;
    private Double budget;

    public DepartmentDto() {
    }

    public DepartmentDto(String dept_name, String project_details, Double budget) {
        this.dept_name = dept_name;
        this.project_details = project_details;
        this.budget = budget;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getProject_details() {
        return project_details;
    }

    public void setProject_details(String project_details) {
        this.project_details = project_details;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "DepartmentDto{" +
               "dept_name='" + dept_name + '\'' +
               ", project_details='" + project_details + '\'' +
               ", budget='" + budget + '\'' +
               '}';
    }
}
