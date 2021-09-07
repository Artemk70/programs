import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DepositAccount extends BankAccount {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private LocalDate date = LocalDate.now();

    @Override
    public void putMoney(double money) {
        if (money > 0) {
            super.putMoney(money);
            date = date.plusMonths(1);
        }
    }

    @Override
    public double withdraw(double money) {
        if (money > getMoneyAmount()) {
            System.out.println("Недостаточно средств!");
            return 0;
        }
        else if (money <= getMoneyAmount() && date.compareTo(LocalDate.now()) == 0) {
            withdraw(money);
            return money;
        }
        else if (date.compareTo(LocalDate.now()) > 0){
            System.out.println("Деньги можно будет снять/перевести: " + date.format(formatter));
            return 0;
        } else {
            return 0;
        }
    }
}

