package service;

import persistence.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getProject(double budget);
}
