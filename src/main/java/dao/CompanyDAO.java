package dao;

import database.Company;

public interface CompanyDAO {
    public void addCompany(Company company);
    public Company getCompanyById(int id);
    public void printProjectsAndEmployeesOfCompany(Company company);
}
