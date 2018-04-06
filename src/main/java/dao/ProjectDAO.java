package dao;

import database.Project;

public interface ProjectDAO {
    public void addProject(Project project);
    public void printListOfProjectsByCompanyID(int companyId);
    public void printListOfProjectsWhereFourPeopleInJava();
    public void deleteProject(int id);
}
