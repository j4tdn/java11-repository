Step 1: Create a Maven Simple || QuickStart Project
Step 2: Add dependencies
+ mysql-connector
+ hibernate-core
Step 3: Configure Session Factory from Configuration
>> Configurarion
+ XML
+ Java, Annotation

Step 4: Execute SQL statement
1. Hibernate native API
>> DAO: Session

2. JPA native API
>> DAO: EntityManager

3. Spring Data JPA
>> Repository










==========Phân biệt openSession và getCurrentSession=========
Session session1 = openSession();
System.out.println("session1: " + session1);

Session session2 = openSession();
System.out.println("session2: " + session2);

Session session3 = getCurrentSession();
System.out.println("session3: " + session3);

Session session4 = getCurrentSession();
System.out.println("session4: " + session4);
