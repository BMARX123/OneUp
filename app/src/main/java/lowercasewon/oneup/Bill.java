package lowercasewon.oneup;

/**
 * Created by Brandon on 9/24/2016.
 */

public class Bill {
    String nameOfBill;
    double monthlyDue;
    double interestRate;
    double totalDue;

    public Bill(String nameOfBill, double monthlyDue, double interestRate, double totalDue){
        this.nameOfBill = nameOfBill;
        this.monthlyDue = monthlyDue;
        this.interestRate = interestRate;
        this.totalDue = totalDue;

    }
    public double getTotalDue() {
        return totalDue;
    }
    public double getInterestRate() {
        return interestRate;
    }
    public double getMonthlyDue() {
        return monthlyDue;
    }
    public String getNameOfBill() {
        return nameOfBill;
    }

    public void setTotalDue(int temp) {
        this.totalDue = temp;
    }
    public void setInterestRate(double temp) {
        this.interestRate = temp;
    }
    public void setMonthlyDue(double temp) {
        this.monthlyDue = temp;
    }
    public void setNameOfBill(String temp) {
        this.nameOfBill = temp;
    }
}
