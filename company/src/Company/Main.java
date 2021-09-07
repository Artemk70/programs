package Company;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Company company = new Company(20000000);

        List <Staff> companyEmpl = new ArrayList<>(){{
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new Operator());
            add(new Operator());
            add(new Operator());
            add(new Operator());
            add(new Operator());

        }};

        company.hireAll(companyEmpl);

        System.out.println("По возрастанию:");
        List<Staff> low = company.getLowestSalaryStaff(company.getNumberOfEmployees());

        for (Staff staff : low) {
            System.out.println(staff.getMonthSalary());
        }

        System.out.println();

        System.out.println("По убыванию:");
        List<Staff> top = company.getTopSalaryStaff(company.getNumberOfEmployees());

        for (Staff st : top) {
            System.out.println(st.getMonthSalary());
        }
        System.out.println();
        System.out.println("Уволим 20 сотрудников");
        System.out.println();


        company.fire(20);

        System.out.println("По убыванию:");
        List<Staff> topp = company.getTopSalaryStaff(company.getEmplayee().size());

        for (Staff st : topp) {
            System.out.println(st.getMonthSalary());
        }

        System.out.println("===========================");

//==================================================================

        Company gazprom = new Company(50000000);

        List<Staff> gazpromEmpl = new ArrayList<>(){{
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new Operator());
            add(new Operator());
            add(new Operator());
            add(new Operator());
        }};

        gazprom.hireAll(gazpromEmpl);

        System.out.println(gazprom);

        System.out.println("===========================");

//==================================================================

        Company apple = new Company(70000009);

        List<Staff> appleEmpl = new ArrayList<>(){{
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new Manager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
            add(new TopManager());
           add(new Operator());
           add(new Operator());
           add(new Operator());
           add(new Operator());
           add(new Operator());
           add(new Operator());
           add(new Operator());
           add(new Operator());
           add(new Operator());
           add(new Operator());
           add(new Operator());
           add(new Operator());
           add(new Operator());
           add(new Operator());
           add(new Operator());
           add(new Operator());
           add(new Operator());
           add(new Operator());
           add(new Operator());
        }};

        apple.hireAll(appleEmpl);

        System.out.println(apple);

        System.out.println(gazprom.getIncome());
        System.out.println(apple.getIncome());

        System.out.println("===========================");
        Company ozon = new Company(500000000);
            List<Staff> ozonEmpl = new ArrayList<>(){{
                add(new TopManager());
                add(new TopManager());
                add(new Manager());
                add(new Manager());
                add(new Manager());
                add(new Manager());
                add(new Manager());
                add(new Manager());
                add(new Manager());
                add(new Manager());
                add(new Operator());
                add(new Operator());

            }};

        ozon.hireAll(ozonEmpl);

        ozon.hire(new TopManager());

        System.out.println(ozon);

    }
}
