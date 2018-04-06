package main;

import database.*;
import enumerations.Role;
import enumerations.State;
import utils.Factory;

import java.util.Arrays;
import java.util.HashSet;

public class Data {

    static Country moldova = new Country();
    static Country ukraine = new Country();
    static Country romania = new Country();

    static Address chisinau = new Address();
    static Address balti = new Address();
    static Address kiev = new Address();
    static Address odessa = new Address();
    static Address buharest = new Address();
    static Address cluj = new Address();
    static Address chisinauAnother = new Address();

    static Skill java = new Skill();
    static Skill sharp = new Skill();
    static Skill net = new Skill();
    static Skill hibernate = new Skill();
    static Skill spring = new Skill();

    static Company endava = new Company();
    static Company star = new Company();

    static Project project1 = new Project();
    static Project project2 = new Project();
    static Project project3 = new Project();


    static Employee employee1 = new Employee();
    static Employee employee2 = new Employee();
    static Employee employee3 = new Employee();
    static Employee employee4 = new Employee();
    static Employee employee5 = new Employee();
    static Employee employee6 = new Employee();
    static Employee employee7 = new Employee();

    static{
        moldova.setISOCode("MD");
        moldova.setName("Moldova");

        ukraine.setISOCode("UKR");
        ukraine.setName("Ukraine");

        romania.setISOCode("RO");
        romania.setName("Romania");

        chisinau.setCity("Chisnau");
        chisinau.setCountry(moldova);
        chisinau.setStreet("Stefan cel Mare street");
        chisinau.setStreetNumber(145);

        balti.setCity("Balti");
        balti.setCountry(moldova);
        balti.setStreet("Main street");
        balti.setStreetNumber(17);

        kiev.setCity("Kiev");
        kiev.setCountry(ukraine);
        kiev.setStreet("Kiev street");
        kiev.setStreetNumber(33);

        odessa.setCity("Odessa");
        odessa.setCountry(ukraine);
        odessa.setStreet("Hero street");
        odessa.setStreetNumber(67);

        buharest.setCity("Buharest");
        buharest.setCountry(romania);
        buharest.setStreet("Dracula street");
        buharest.setStreetNumber(28);

        cluj.setCity("Cluj");
        cluj.setCountry(romania);
        cluj.setStreet("Main street");
        cluj.setStreetNumber(236);

        chisinauAnother.setCity("Chisnau");
        chisinauAnother.setCountry(moldova);
        chisinauAnother.setStreet("Stefan cel Mare street");
        chisinauAnother.setStreetNumber(155);

        java.setType("Soft");
        java.setSkill("Java");

        sharp.setType("Soft");
        sharp.setSkill("C#");

        net.setType("Technical");
        net.setSkill("Computer networks");

        hibernate.setType("Soft");
        hibernate.setSkill("Hibernate");

        spring.setType("Soft");
        spring.setSkill("Spring");

        endava.setName("Endava");

        star.setName("StarTech");

        project1.setName("Project 1");
        project1.setProjectCode("pr-1234");
        project1.setDescription("description");
        project1.setCompany(endava);
        project1.setState(State.ACTIVE);

        project2.setName("Project 2");
        project2.setProjectCode("pr-7654");
        project2.setDescription("description");
        project2.setCompany(endava);
        project2.setState(State.ACTIVE);

        project3.setName("Project 3");
        project3.setProjectCode("pr-7012");
        project3.setDescription("description");
        project3.setCompany(star);
        project3.setState(State.ACTIVE);

        employee1.setFirstName("Ion");
        employee1.setLastName("Sandul");
        employee1.setUserId("isandul");
        employee1.setRole(Role.PROGRAMMER);
        employee1.setCompany(endava);
        employee1.setAddress(chisinau);
        employee1.setSkills(new HashSet<Skill>(Arrays.asList(java, hibernate, spring)));
        employee1.setProjects(new HashSet<Project>(Arrays.asList(project1, project2)));
        employee1.setState(State.ACTIVE);

        employee2.setFirstName("Ivan");
        employee2.setLastName("Sirosenco");
        employee2.setUserId("isirosenco");
        employee2.setRole(Role.PROGRAMMER);
        employee2.setCompany(endava);
        employee2.setAddress(chisinauAnother);
        employee2.setSkills(new HashSet<Skill>(Arrays.asList(java, spring)));
        employee2.setProjects(new HashSet<Project>(Arrays.asList(project1)));
        employee2.setState(State.ACTIVE);

        employee3.setFirstName("Alexand");
        employee3.setLastName("Cusnir");
        employee3.setUserId("acusnir");
        employee3.setRole(Role.PROGRAMMER);
        employee3.setCompany(endava);
        employee3.setAddress(odessa);
        employee3.setSkills(new HashSet<Skill>(Arrays.asList(java)));
        employee3.setProjects(new HashSet<Project>(Arrays.asList(project1)));
        employee3.setState(State.ACTIVE);

        employee4.setFirstName("Mila");
        employee4.setLastName("Bezaliuc");
        employee4.setUserId("mbezaliuc");
        employee4.setRole(Role.CHIEF);
        employee4.setCompany(endava);
        employee4.setAddress(balti);
        employee4.setSkills(new HashSet<Skill>(Arrays.asList(java, hibernate, spring)));
        employee4.setProjects(new HashSet<Project>(Arrays.asList(project1, project2)));
        employee4.setState(State.ACTIVE);

        employee5.setFirstName("Iulia");
        employee5.setLastName("Muraseva");
        employee5.setUserId("imuraseva");
        employee5.setRole(Role.MANAGER);
        employee5.setCompany(endava);
        employee5.setAddress(kiev);
        employee5.setSkills(new HashSet<Skill>(Arrays.asList(java)));
        employee5.setProjects(new HashSet<Project>(Arrays.asList(project2)));
        employee5.setState(State.ACTIVE);

        employee6.setFirstName("Petr");
        employee6.setLastName("Petrov");
        employee6.setUserId("ppetrov");
        employee6.setRole(Role.PROGRAMMER);
        employee6.setCompany(star);
        employee6.setAddress(cluj);
        employee6.setSkills(new HashSet<Skill>(Arrays.asList(net, sharp)));
        employee6.setProjects(new HashSet<Project>(Arrays.asList(project3)));
        employee6.setState(State.ACTIVE);

        employee7.setFirstName("Sasha");
        employee7.setLastName("Alexandr");
        employee7.setUserId("salexandr");
        employee7.setRole(Role.CHIEF);
        employee7.setCompany(star);
        employee7.setAddress(buharest);
        employee7.setSkills(new HashSet<Skill>(Arrays.asList(net)));
        employee7.setProjects(new HashSet<Project>(Arrays.asList(project3)));
        employee7.setState(State.ACTIVE);
    }

    public static void fill(){
        Factory.getCountryDAO().addCountry(moldova);
        Factory.getCountryDAO().addCountry(ukraine);
        Factory.getCountryDAO().addCountry(romania);

        Factory.getAddressDAO().addAddress(chisinau);
        Factory.getAddressDAO().addAddress(balti);
        Factory.getAddressDAO().addAddress(kiev);
        Factory.getAddressDAO().addAddress(odessa);
        Factory.getAddressDAO().addAddress(buharest);
        Factory.getAddressDAO().addAddress(cluj);
        Factory.getAddressDAO().addAddress(chisinauAnother);

        Factory.getSkillDAO().addSkill(java);
        Factory.getSkillDAO().addSkill(sharp);
        Factory.getSkillDAO().addSkill(net);
        Factory.getSkillDAO().addSkill(hibernate);
        Factory.getSkillDAO().addSkill(spring);

        Factory.getCompanyDAO().addCompany(endava);
        Factory.getCompanyDAO().addCompany(star);

        Factory.getProjectDAO().addProject(project1);
        Factory.getProjectDAO().addProject(project2);
        Factory.getProjectDAO().addProject(project3);

        Factory.getEmployeeDAO().addEmployee(employee1);
        Factory.getEmployeeDAO().addEmployee(employee2);
        Factory.getEmployeeDAO().addEmployee(employee3);
        Factory.getEmployeeDAO().addEmployee(employee4);
        Factory.getEmployeeDAO().addEmployee(employee5);
        Factory.getEmployeeDAO().addEmployee(employee6);
        Factory.getEmployeeDAO().addEmployee(employee7);

    }

}
