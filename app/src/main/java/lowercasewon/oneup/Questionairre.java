package lowercasewon.oneup;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.reimaginebanking.api.nessieandroidsdk.requestclients.NessieClient;

import java.util.ArrayList;

public class Questionairre extends AppCompatActivity {
    public String name;
    public String email;
    public String password;
    public int age;
    public double averageMonthlyIncome;
    public double savingsPercentage;
    public double investmentPercentage;
    public boolean longTermJob;
    public boolean fourKOffer;
    public int fourKPercent;
    public boolean hasFourK;
    public int rothIraPercent;
    public FinancialOverview fo;
    public ArrayList debtList;
    public NessieClient client;
    public boolean bool;
    public boolean redo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionairre);
        fo = new FinancialOverview();
        client = fo.getClient();
        debtList = new ArrayList<>();
        startSurvey();


    }

    public void startSurvey(){
        this.name = createStringDialog("Enter Your First and Last Name");
        EPDialog("Enter email and password");
        this.age = IntDialog("Enter Your Age");
        this.averageMonthlyIncome = DoubleDialog("Enter Your Average Monthly Income");
        this.savingsPercentage = DoubleDialog("What percentage of your monthly income would you like to be put into savings");
        this.investmentPercentage = DoubleDialog("What percentage of your monthly income would you like to be put into investments");
        this.longTermJob = createYesNoPopUp("Are you in long term employment", null);
        if(longTermJob) {
            this.fourKOffer = createYesNoPopUp("Does your employer offer a 401k", null);
        }
        if(fourKOffer){
            this.fourKPercent = IntDialog("What percentage of monthly income would you like to put towards your 401k ");
            this.hasFourK = true;
        }
        if(!hasFourK){
            this.rothIraPercent = IntDialog("What percentage of monthly income would you like to put towards your Roth IRA ");
        }

        while(redo){

            debtList.add(billDialog());
            createRedoPopUp("Enter Another", "Do you have more bills");
        }
    }

    boolean createYesNoPopUp(String title, String Message){

        new AlertDialog.Builder(this)
                .setTitle(title)
                //.setMessage("Are you sure you want to delete this entry?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        bool = true;
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                        bool = false;

                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

        return bool;
    }

    boolean createRedoPopUp(String title, String Message){

        new AlertDialog.Builder(this)
                .setTitle(title)
                .setMessage(Message)
                //.setMessage("Are you sure you want to delete this entry?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        redo = true;
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                        redo = false;

                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();

        return bool;
    }

    String createStringDialog(String title){
        Dialog dialog = onCreateStringDialog(title);
        dialog.show();
        EditText et = (EditText) findViewById(R.id.string);
        return et.toString();
    }

    void  EPDialog(String title){
        Dialog dialog = onCreateEPDialog(title);
        dialog.show();
        EditText et1 = (EditText)findViewById(R.id.username);
        this.email = et1.toString();
        EditText et2 = (EditText)findViewById(R.id.password);
        this.password = et2.toString();

    }

    Bill billDialog(){
        Dialog dialog = onCreateBillDialog("Enter Bill");
        dialog.show();
        EditText et1 = (EditText)findViewById(R.id.nameOfBill);
        EditText et2 = (EditText)findViewById(R.id.monthlyDue);
        EditText et3 = (EditText)findViewById(R.id.interestRate);
        EditText et4 = (EditText)findViewById(R.id.totalDue);
        return new Bill(et1.toString(), Double.parseDouble(et2.toString()), Integer.parseInt(et3.toString()),Double.parseDouble(et4.toString()));
    }

    int IntDialog(String title){
        Dialog dialog = onCreateIntDialog(title);
        dialog.show();
        EditText et1 = (EditText)findViewById(R.id.numero);
        return Integer.parseInt(et1.toString());
    }

    Double DoubleDialog(String title){
        Dialog dialog = onCreateDoubleDialog(title);
        dialog.show();
        EditText et1 = (EditText)findViewById(R.id.numero);
        return Double.parseDouble(et1.toString());
    }

    public Dialog onCreateEPDialog(String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Get the layout inflater
        LayoutInflater inflater = this.getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.dialog_txt, null))
                .setTitle(title)
                // Add action buttons
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                });
        return builder.create();
    }

    public Dialog onCreateIntDialog(String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Get the layout inflater
        LayoutInflater inflater = this.getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.dialog_int, null))
                .setTitle(title)
                // Add action buttons
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                });
        return builder.create();
    }

    public Dialog onCreateDoubleDialog(String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Get the layout inflater
        LayoutInflater inflater = this.getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.dialog_int, null))
                .setTitle(title)
                // Add action buttons
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                });
        return builder.create();
    }

    public Dialog onCreateBillDialog(String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Get the layout inflater
        LayoutInflater inflater = this.getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.dialog_bill, null))
                .setTitle(title)
                // Add action buttons
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                });
        return builder.create();
    }

    public Dialog onCreateStringDialog(String title) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // Get the layout inflater
        LayoutInflater inflater = this.getLayoutInflater();

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.dialog_string_txt, null))
                .setTitle(title)
                // Add action buttons
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // sign in the user ...
                    }
                });
        return builder.create();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_questionairre, menu);
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
}
