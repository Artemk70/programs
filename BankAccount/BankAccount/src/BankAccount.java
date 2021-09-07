public class BankAccount {
    private double moneyAmount = 0; //сумма денег на счете

    // Получить остаток на счёте
    public double getMoneyAmount() {
        return moneyAmount;
    }

    // Снять со счёта (без комиссии)
    public double withdraw(double money) {
        if (money > 0 && moneyAmount >= money) {
            moneyAmount -= money;
            return money;
        } else {
            return 0;
        }
    }

    // Пополнить счет (без комиссии)
    public void putMoney(double money) {
        if (money > 0) {
            moneyAmount += money;
        }
    }
// Переводить между счетами
    boolean send(BankAccount account, double amountForTransfer) {
        if (amountForTransfer > 0 && moneyAmount >= amountForTransfer && withdraw(amountForTransfer) > 0) {
            account.putMoney(amountForTransfer);
            return true;
        } else {
            return false;
        }
    }
}
