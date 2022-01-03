SELECT *
FROM employee em
WHERE em.salary > (SELECT salary
                   FROM employee
                   WHERE Id = em.ManagerId);