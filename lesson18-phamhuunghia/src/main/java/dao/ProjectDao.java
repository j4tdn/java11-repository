package dao;

import java.util.List;

import persistence.Department;
import persistence.DepartmentDto;
import persistence.Project;

public interface ProjectDao {
  List<Project> getAllProject(int budget);

}