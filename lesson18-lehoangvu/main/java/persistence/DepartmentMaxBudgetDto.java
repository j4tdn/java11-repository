package persistence;

public class DepartmentMaxBudgetDto {
    public final static String DEPARTMENT_NAME ="d_name";
    public final static String PROJECT_NAME="p_name";
    public final static String BUDGET="budget";

    private String d_name;
    private String p_name;
    private Double budget;

    public DepartmentMaxBudgetDto() {
    }

    public DepartmentMaxBudgetDto(String d_name, String p_name, Double budget) {
        this.d_name = d_name;
        this.p_name = p_name;
        this.budget = budget;
    }

    public String getD_name() {
        return d_name;
    }

    public void setD_name(String d_name) {
        this.d_name = d_name;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "DepartmentMaxBudgetDto{" +
                "d_name='" + d_name + '\'' +
                ", p_name='" + p_name + '\'' +
                ", budget=" + budget +
                '}';
    }
}
