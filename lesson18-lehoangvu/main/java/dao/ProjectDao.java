package dao;

import persistence.Project;

import java.util.List;

public interface ProjectDao {
    List<Project> getProject(double budget);
}
