package Bank;

public class AccountFactory { // метод фабрика

    final String CURRENT_ACCOUNT = "CURRENT";
    final String SAVING_ACCOUNT = "SAVING";


    Bank getBank(String bankName) {
        return null;
    }


    public Account getAccount(String accountType) {
        if(CURRENT_ACCOUNT.equals(accountType)) {
            return new CurrentAccount();
        } else if(SAVING_ACCOUNT.equals(accountType)) {
            return new SavingAccount();
        }
        return null;
    }


}
