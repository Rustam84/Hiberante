package dao;

import database.Employee;

public interface EmployeeDAO {
    public void addEmployee(Employee employee);
    public void printListOfEmployeeByProjectCode(String projectCode);
    public void printListOfEmployeeBySkillType(String skillType);
    public void printListOfEmployeeBySkillName(String skillName);
    public void editEmployee(int id);
    public void deleteEmployee(int id);
}
