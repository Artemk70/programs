package Company;

public class TopManager extends Staff {

    private int salary = 120000; // месячный оклад
    private final double PERCENT = 1.5;
    private final int MIN_PROFIT_COMPANY = 10000000;
    private int monthSalary = 0; // зарплата за месяц

    public TopManager() {

    }

    protected void generateSalary() {
        if (getCompany().getIncome() > MIN_PROFIT_COMPANY) {
            monthSalary = (int) (salary + (salary * PERCENT));
        } else {
            monthSalary = salary;
        }
    }

    public int getMonthSalary() {
        return monthSalary;
    }

}
