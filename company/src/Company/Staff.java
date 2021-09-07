package Company;

public abstract class Staff implements Employee, Comparable<Staff> {

    private Company company;

    void setCompany(Company c) {
        company = c;
    }

    public Company getCompany() {
        return company;
    }

    public int getMonthSalary() {
        return 0;
    }

    protected void generateSalary(){

    };

    @Override
    public int compareTo(Staff employee) {
        return Integer.compare(getMonthSalary(), employee.getMonthSalary());
    }
}
