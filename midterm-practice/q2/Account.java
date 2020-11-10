package q2;
import java.util.Date;

//starting code
public class Account implements Comparable<Account> {
    private String id;
    private double balance;
    private Date dateCreated;

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Account(String id, double balance) {
        this.id = id;
        this.balance = balance;
        this.dateCreated = new Date();
    }

    @Override
    public String toString() {
        return "Account:" + id ;
    }

    @Override
    public int compareTo(Account acc) {
        if (this.getBalance() > acc.getBalance()) return 1;
        else if (this.getBalance() == acc.getBalance()) return 0;
        else return -1;
    }

}

