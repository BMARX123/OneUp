package lowercasewon.oneup;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;
import com.reimaginebanking.api.nessieandroidsdk.models.Account;
import com.reimaginebanking.api.nessieandroidsdk.models.Customer;
import com.reimaginebanking.api.nessieandroidsdk.requestclients.NessieClient;
import com.reimaginebanking.api.nessieandroidsdk.*;


import java.util.ArrayList;
import java.util.List;


public class FinancialOverview extends AppCompatActivity {

    public static String name;
    public static String email;
    public static String password;
    public static int age;
    public static double averageMonthlyIncome;
    public static double savingsPercentage;
    public static double investmentPercentage;
    public static boolean longTermJob;
    public static boolean fourKOffer;
    public static int fourKPercent;
    public static boolean hasFourK;
    public static int rothIraPercent;
    public static ArrayList debtList;
    public static int totalBalance;
    public NessieClient client = NessieClient.getInstance("88d32ed949123a777cc5763009fbe502");
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financial_overview);
        Customer customer = new Customer.Builder().firstName(name).build();
        Account myAccount = new Account.Builder().accountNumber(customer.getId()).balance(totalBalance).rewards(0).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_financial_overview, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("FinancialOverview Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }
    public void onCreate() {
        client.CUSTOMER.getCustomers(new NessieResultsListener() {
            @Override
            public void onSuccess(Object result) {
                List<Customer> customers = (List<Customer>) result;
                // do something with the list of customers here
            }

            @Override
            public void onFailure(NessieError error) {
                // handle error
            }
        });




    }

    public NessieClient getClient(){
        return client;
    }


    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onStop() {
        super.onStop();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverageMonthlyIncome() {
        return averageMonthlyIncome;
    }

    public void setAverageMonthlyIncome(double averageMonthlyIncome) {
        this.averageMonthlyIncome = averageMonthlyIncome;
    }

    public double getSavingsPercentage() {
        return savingsPercentage;
    }

    public void setSavingsPercentage(double savingsPercentage) {
        this.savingsPercentage = savingsPercentage;
    }

    public double getInvestmentPercentage() {
        return investmentPercentage;
    }

    public void setInvestmentPercentage(double investmentPercentage) {
        this.investmentPercentage = investmentPercentage;
    }

    public boolean isLongTermJob() {
        return longTermJob;
    }

    public void setLongTermJob(boolean longTermJob) {
        this.longTermJob = longTermJob;
    }

    public boolean isFourKOffer() {
        return fourKOffer;
    }

    public void setFourKOffer(boolean fourKOffer) {
        this.fourKOffer = fourKOffer;
    }

    public int getFourKPercent() {
        return fourKPercent;
    }

    public void setFourKPercent(int fourKPercent) {
        this.fourKPercent = fourKPercent;
    }

    public boolean isHasFourK() {
        return hasFourK;
    }

    public void setHasFourK(boolean hasFourK) {
        this.hasFourK = hasFourK;
    }

    public int getRothIraPercent() {
        return rothIraPercent;
    }

    public void setRothIraPercent(int rothIraPercent) {
        this.rothIraPercent = rothIraPercent;
    }

    public ArrayList getDebtList() {
        return debtList;
    }

    public void setDebtList(ArrayList debtList) {
        this.debtList = debtList;
    }
}
