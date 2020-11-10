package q2;
import java.util.Comparator;
import java.util.Date;

import q2.Account;

//starting code
public class AccountComparator implements Comparator<Account> {
    @Override
    public int compare(Account acc, Account bcc) {
        return acc.getId().compareTo( bcc.getId());
    }

}

