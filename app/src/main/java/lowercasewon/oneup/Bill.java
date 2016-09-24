package lowercasewon.oneup;

/**
 * Created by Brandon on 9/24/2016.
 */

public class Bill {
    String nameOfBill;
    double monthlyDue;
    int interestRate;
    double totalDue;

    public Bill(String nameOfBill, double monthlyDue, int interestRate, double totalDue){
        this.nameOfBill = nameOfBill;
        this.monthlyDue = monthlyDue;
        this.interestRate = interestRate;
        this.totalDue = totalDue;

    }
    public double getTotalDue() {
        return totalDue;
    }
    public int getInterestRate() {
        return interestRate;
    }
    public double getMonthlyDue() {
        return monthlyDue;
    }
    public String getNameOfBill() {
        return nameOfBill;
    }
}
