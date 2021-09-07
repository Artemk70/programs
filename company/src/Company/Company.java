package Company;

import java.util.*;
import java.util.concurrent.ThreadPoolExecutor;

public class Company {

    // доход компании
    private int income = 0;
    // список сотрудников
    private ArrayList<Staff> emplayee = new ArrayList<>(); // список всех сотрудников

//==================================================================

    // конструктор создает компанию с доходом в 1,1млн руб
    public Company() {
        income = 11000000;
    }

    // конструктор создает компанию с заданным доходом
    public Company(int salary) {
        this.income = salary;
    }

//==================================================================

    // получить список всех сотрудников
    public ArrayList<Staff> getEmplayee() {
        return emplayee;
    }

    // получить доход компании
    public int getIncome() {
        return income;
    }

    // получить число сотрудников
    public int getNumberOfEmployees() {
        return this.emplayee.size();
    }

//==================================================================

    // нанять одного сотрудника
        void hire(Staff staff) {

        staff.setCompany(this);
        
        if (staff instanceof TopManager) {
            staff.generateSalary();
        }

        this.emplayee.add(staff);
    }

//==================================================================

    // нанять список сотрудников
    void hireAll(List<Staff> employees) {

        for (Staff staff : employees) {
            hire(staff);
        }
    }

//==================================================================

    // увольнение одного или нескольких сотрудников
    void fire(int value) {

        if (value < 0 || value > getNumberOfEmployees()) {
            System.out.println("Недопустимое число сутрудников");
        } else {
            for (int i = 0; i < value; i++) {
                int n = (int) (Math.random() * this.emplayee.size());
                this.emplayee.remove(n);
            }
        }
    }

//==================================================================

    // возвращает список указанной длинны сотрудников по возрастанию заработной платы
    List<Staff> getLowestSalaryStaff(int count) {
        List<Staff> sortEmploy = new ArrayList<>();

        Collections.sort(emplayee);

        if (count > 0 && count <= emplayee.size()) {
            sortEmploy = emplayee.subList(0, emplayee.size());
        }

        return sortEmploy;
    }

    // возвращает список указанной длинны сотрудников по убыванию заработной платы
    List<Staff> getTopSalaryStaff(int count) {

        List<Staff> sortEmploy = new ArrayList<>();

        Collections.sort(emplayee);

        if (count > 0 && count <= emplayee.size())
        {
            for (int i = emplayee.size() - 1; sortEmploy.size() < count; i--) {
                sortEmploy.add(emplayee.get(i));
            }
        }

        return sortEmploy;
    }

//==================================================================

    @Override
    public String toString() {
        return "Доход компании: " + this.getIncome() +
                "\nЧисло сотрудников: " + this.getEmplayee().size();
    }
}
