package dao;

import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.IntegerType;
import org.hibernate.type.StringType;
import persistence.DepartmentBudgetDto;
import persistence.DepartmentListEmployeeDto;
import persistence.DepartmentTotalOfBudget;

import java.util.List;

public class HibernateDepartmentDao extends AbstractHibernateDao implements DepartmentDao {

    public HibernateDepartmentDao() {
    }

    final String Q_GET_EMPLOYEES_EACH_DEPARTMENT_ASC =
            "select d.dept_id as " + DepartmentListEmployeeDto.DEPARTMENT_ID + " , d.dept_name as " + DepartmentListEmployeeDto.DEPARTMENT_NAME +
                    ", e.emp_id as " + DepartmentListEmployeeDto.EMPLOYEE_ID + ",e.emp_name as " + DepartmentListEmployeeDto.EMPLOYEE_NAME + ",e.age as " + DepartmentListEmployeeDto.EMPLOYEE_AGE +
                    ", e.salary as " + DepartmentListEmployeeDto.EMPLOYEE_SALARY +
                    " from department as d  inner join employee as e on " +
                    "e.dept_id=d.dept_id order by d.dept_id asc";

    @SuppressWarnings("unchecked")
    @Override
    public List<DepartmentListEmployeeDto> getEmployeesEachDepartment() {
        return OpenSession().createNativeQuery(Q_GET_EMPLOYEES_EACH_DEPARTMENT_ASC)
                .addScalar(DepartmentListEmployeeDto.DEPARTMENT_ID, StringType.INSTANCE)
                .addScalar(DepartmentListEmployeeDto.DEPARTMENT_NAME, StringType.INSTANCE)
                .addScalar(DepartmentListEmployeeDto.EMPLOYEE_ID, StringType.INSTANCE)
                .addScalar(DepartmentListEmployeeDto.EMPLOYEE_NAME, StringType.INSTANCE)
                .addScalar(DepartmentListEmployeeDto.EMPLOYEE_AGE, IntegerType.INSTANCE)
                .addScalar(DepartmentListEmployeeDto.EMPLOYEE_SALARY, DoubleType.INSTANCE)
                .setResultTransformer(Transformers.aliasToBean(DepartmentListEmployeeDto.class)).getResultList();
    }

    final String Q_GET_SUM_BUDGET_DEPARTMENT =
            "select d.dept_name as " + DepartmentBudgetDto.DEPARRTMENT_NAME + " , p.pro_name as " + DepartmentBudgetDto.PROJECT_NAME + ", " +
                    "p.budget as " + DepartmentBudgetDto.SUM_BUDGET + " from department as d inne" +
                    "r join project as p on d.dept_id=p.dept_id where " +
                    "p.budget>400";

    @SuppressWarnings("unchecked")
    @Override
    public List<DepartmentBudgetDto> getSumBudget() {
        return OpenSession().createNativeQuery(Q_GET_SUM_BUDGET_DEPARTMENT)
                .addScalar(DepartmentBudgetDto.DEPARRTMENT_NAME, StringType.INSTANCE)
                .addScalar(DepartmentBudgetDto.PROJECT_NAME, StringType.INSTANCE)
                .addScalar(DepartmentBudgetDto.SUM_BUDGET, DoubleType.INSTANCE)
                .setResultTransformer(Transformers.aliasToBean(DepartmentBudgetDto.class)).getResultList();
    }

    final String Q_GET_TOTAL_BUDGET_PROJECT =
                    "with PE as (\n" +
                    "select * from project_employee as p where year(cast(p.start_date as date ))='2021'\n" +
                    ")\n" +
                    "select d.dept_name as " + DepartmentTotalOfBudget.DEPARTMENT_NAME + "" +
                    ", group_concat(concat(p.pro_name,' ',p.budget)) as " + DepartmentTotalOfBudget.PROJECT_DETAILS +
                    ", sum(p.budget) as " + DepartmentTotalOfBudget.SUM_BUDGET +
                    " from project as p inner join PE pe on p.pro_id= pe.pro_id inner join department as  d on p.dept_id=d.dept_id group by d.dept_name\n";

    @SuppressWarnings("unchecked")
    @Override
    public List<DepartmentTotalOfBudget> getListTotal() {
        return OpenSession().createNativeQuery(Q_GET_TOTAL_BUDGET_PROJECT)
                .addScalar(DepartmentTotalOfBudget.DEPARTMENT_NAME, StringType.INSTANCE)
                .addScalar(DepartmentTotalOfBudget.PROJECT_DETAILS, StringType.INSTANCE)
                .addScalar(DepartmentTotalOfBudget.SUM_BUDGET, DoubleType.INSTANCE)
                .setResultTransformer(Transformers.aliasToBean(DepartmentTotalOfBudget.class)).getResultList();
    }

    final String Q_MAX_BUDGET_DEPARTMENT = "select d.dept_name as " + DepartmentBudgetDto.DEPARRTMENT_NAME+ " , p.pro_name as  "+ DepartmentBudgetDto.PROJECT_NAME+ " ,p.budget as "+ DepartmentBudgetDto.SUM_BUDGET+" from department " +
            "as d inner join project as p on d.dept_id=p.dept_id" +
            " where p.budget = (select max(budget) from project)";

    @Override
    public List<DepartmentBudgetDto> getMaxBudget() {
        return OpenSession().createNativeQuery(Q_MAX_BUDGET_DEPARTMENT)
                .addScalar(DepartmentBudgetDto.DEPARRTMENT_NAME, StringType.INSTANCE)
                .addScalar(DepartmentBudgetDto.PROJECT_NAME, StringType.INSTANCE)
                .addScalar(DepartmentBudgetDto.SUM_BUDGET, DoubleType.INSTANCE)
                .setResultTransformer(Transformers.aliasToBean(DepartmentBudgetDto.class)).getResultList();
    }



}
