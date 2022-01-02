package persistent;

public class ProjectDto {
    private String dept_name;
    private String pro_name;
    private Double budget;

    public ProjectDto() {
    }

    public ProjectDto(String pro_name, Double budget, String dept_name) {
        this.pro_name = pro_name;
        this.budget = budget;
        this.dept_name = dept_name;
    }

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    @Override
    public String toString() {
        return "ProjectDto{" +
               "dept_idDeptName='" + dept_name + '\'' +
               ", pro_name='" + pro_name + '\'' +
               ", budget=" + budget +
               '}';
    }
}
