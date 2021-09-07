package Company;

public class Manager extends Staff {

    private int minProfit = 115000; // минимальная прибыль
    private int maxProfit = 140000; // максимальная прибыль
    private double profit = Math.random() * (maxProfit - minProfit) + minProfit; // прибыль
    private int salary = 80000; // месячный оклад
    private final double PERCENT = 0.05;
    private int monthSalary = (int) (salary + (profit * PERCENT)); // зарплата за месяц

    public int getMonthSalary() {
        return monthSalary;
    }

}
