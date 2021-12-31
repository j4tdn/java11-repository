package dao;

import org.hibernate.transform.Transformers;
import org.hibernate.type.DoubleType;
import org.hibernate.type.StringType;
import persistence.DepartmentDto;
import persistence.DepartmentMaxBudgetDto;

import java.util.List;

public class HibernateDepartmentDao extends AbstractHibernateDao implements DepartmentDao{




   /** private static String Q_GET_TOTAL = "SELECT  dep.dept_name"                    +DepartmentDto.DEPT_NAME+",\n"
            +"CONCAT(GROUP_CONCAT(DISTINCT pro.pro_name,\"-\",pro.budget)) "         +DepartmentDto.PROJECT_DETAILS+",\n"
            +"SUM(DISTINCT  pro.budget) "                                           +DepartmentDto.BUDGET+",\n"
            +" FROM department dep\n"
            +"JOIN project pro\n"
            +    "ON  dep.dept_id = pro.dept_id\n"
            +"JOIN project_employee e\n"
             +   "ON  pro.pro_id = e.pro_id\n"
            +"WHERE YEAR(e.start_date) =:year\n"
            +"GROUP BY dep.dept_id;";*/

private static String Q_GET_TOTAL ="SELECT de.dept_name " + DepartmentDto.DEPT_NAME + ",\n"
                        + "CONCAT(GROUP_CONCAT(DISTINCT pr.pro_name, \"-\", pr.budget)) " + DepartmentDto.PROJECT_DETAILS + " ,\n"
                        + "SUM(DISTINCT pr.budget) " + DepartmentDto.BUDGET + " \n"
                        + "FROM department de\n"
                        + " JOIN project pr\n"
                        +  "    ON de.dept_id = pr.dept_id\n"
                        + " JOIN project_employee pe\n"
                        + "     ON pr.pro_id = pe.pro_id\n"
                        + "WHERE YEAR(pe.start_date) = :year\n"
                        + "GROUP BY de.dept_id;";


    @Override
    public List<DepartmentDto> getTotal(int year) {
        return openSession().createNativeQuery(Q_GET_TOTAL)
                .setParameter("year",year)
                .addScalar(DepartmentDto.DEPT_NAME, StringType.INSTANCE)
                .addScalar(DepartmentDto.PROJECT_DETAILS, StringType.INSTANCE)
                .addScalar(DepartmentDto.BUDGET, DoubleType.INSTANCE)
                .setResultTransformer(Transformers.aliasToBean(DepartmentDto.class))
                .getResultList();
    }



//    private static String Q_GET_MAX_BUDGET = "SELECT a.dept_name" +DepartmentMaxBudgetDto.DEPARTMENT_NAME+",\n"
//            +"       b.pro_name" +DepartmentMaxBudgetDto.PROJECT_NAME+",\n"
//            +"       b.budget" +DepartmentMaxBudgetDto.BUDGET+"\n"
//            +"FROM department a\n"
//            +" JOIN project b\n"
//            +"  ON a.dept_id = b.dept_id\n"
//            +"JOIN project_employee c\n"
//            +"  ON b.pro_id = c.pro_id\n"
//            +"WHERE YEAR(c.start_date) = :year\n"
//            +"ORDER BY b.budget DESC\n"
//            +"LIMIT 1;";

    private static String Q_GET_MAX_BUDGET ="SELECT a.dept_name " + DepartmentMaxBudgetDto.DEPARTMENT_NAME+ ",\n"
            + "		b.pro_name " + DepartmentMaxBudgetDto.PROJECT_NAME+ "   ,\n"
            + "     b.budget " +DepartmentMaxBudgetDto.BUDGET + " \n"
            + "FROM department a\n"
            + "JOIN project b\n"
            + "ON a.dept_id = b.dept_id\n"
            + "JOIN project_employee c\n"
            + "ON b.pro_id = c.pro_id\n"
            + "WHERE YEAR(c.start_date) = :year\n"
            + "ORDER BY b.budget DESC\n"
            + "LIMIT 1;";

    @Override
    public List<DepartmentMaxBudgetDto> getMaxBudget(int year) {
        return openSession()
                .createNativeQuery(Q_GET_MAX_BUDGET)
                .setParameter("year",year)
                .addScalar(DepartmentMaxBudgetDto.DEPARTMENT_NAME,StringType.INSTANCE)
                .addScalar(DepartmentMaxBudgetDto.PROJECT_NAME,StringType.INSTANCE)
                .addScalar(DepartmentMaxBudgetDto.BUDGET,DoubleType.INSTANCE)
                .setResultTransformer(Transformers.aliasToBean(DepartmentMaxBudgetDto.class))
                .getResultList();
    }

}
