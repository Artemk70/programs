public class CardAccount extends BankAccount {
    private final double PERCENT = 0.01;
    @Override
    // Снять со счёта (комиссия 1%)
    public double withdraw(double money) {
        if (getMoneyAmount() > 0 && money > 0) {
            double commission = money * PERCENT;
            double count = money + commission;
            
            super.withdraw(count);
            return money;
        } else {
            return 0;
        }
    }
}