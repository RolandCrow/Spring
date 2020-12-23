package Bank;

public class BankFactory extends AbstractFactory {

    final String ICICI_BANK = "ICICI";
    final String YES_BANK = "YES";
    // 56

    @Override
    Bank getBank(String bankName) {
        if (ICICI_BANK.equalsIgnoreCase(bankName)) {
            return new ICICIBank();
        } else if (YES_BANK.equalsIgnoreCase(bankName)) {
            return new YesBank();
        }
        return null;
    }

    @Override
    Account getAccount(String accountType) {
        return null;
    }

    // 56
}
