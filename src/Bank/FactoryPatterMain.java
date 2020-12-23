package Bank;

public class FactoryPatterMain {

    public static void main(String[] args) {
        AccountFactory accountFactory = new AccountFactory();

        Account savingAccount = accountFactory.getAccount("SAVING");
        savingAccount.accountType();

        Account currentAccount = accountFactory.getAccount("CURRENT");
        savingAccount.accountType();
    }
}
