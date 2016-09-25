package lowercasewon.oneup;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import static lowercasewon.oneup.R.id.textView;

public class DebtTracker extends AppCompatActivity {
    public Context c = this;
    Button button1;
    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3, floatingActionButton4, floatingActionButton5, floatingActionButton6, floatingActionButton7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debt_tracker);
        button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View i) {
                Intent j = new Intent(c, CurrentDebts.class);
                startActivity(j);
            }
        });
        TextView textView9 = (TextView) findViewById(R.id.textView9);
        for(int c = 0; c < FinancialOverview.debtList.size() - 1; c++) {
            Object temp = FinancialOverview.debtList.get(0);

        }
        textView9.setText("Current Prioritized Debt: = "); //use debt list to determine highest interest rate
        TextView textView10 = (TextView) findViewById(R.id.textView10);
        textView10.setText("Monthly Loan Progress: = "); //use debt list to find total paid/ total due
        TextView textView11 = (TextView) findViewById(R.id.textView11);
        textView11.setText("Total Loan Progress: = "); //use debt list to find longest time on debt loan
        //could either be set amount of months like car or division to find student loan payoff
        TextView textView12 = (TextView) findViewById(R.id.textView12);
        textView12.setText("Total Loan Progress: = ");

        materialDesignFAM = (FloatingActionMenu) findViewById(R.id.social_floating_menutimisfag);
        floatingActionButton1 = (FloatingActionButton) findViewById(R.id.settings);
        floatingActionButton2 = (FloatingActionButton) findViewById(R.id.financialoverview);
        floatingActionButton3 = (FloatingActionButton) findViewById(R.id.monthlystatements);
        floatingActionButton4 = (FloatingActionButton) findViewById(R.id.debttracker);
        //floatingActionButton5 = (FloatingActionButton) findViewById(R.id.investmentportfolio);
        floatingActionButton6 = (FloatingActionButton) findViewById(R.id.bankatm);
        floatingActionButton7 = (FloatingActionButton) findViewById(R.id.addevent);


        floatingActionButton1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu first item clicked
                Intent i = new Intent(c , SettingsPage.class);
                startActivity(i);



            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu second item clicked
                Intent i = new Intent(c , FinancialOverview.class);
                startActivity(i);

            }
        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu third item clicked
                Intent i = new Intent(c , MonthlyStatements.class);
                startActivity(i);
            }
        });

        floatingActionButton4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu first item clicked
                Intent i = new Intent(c , DebtTracker.class);
                startActivity(i);
            }
        });
       /* floatingActionButton5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu second item clicked
                Intent i = new Intent(c , InvestmentPortfolio.class);
                startActivity(i);
            }
        });*/
        floatingActionButton6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu third item clicked
                Intent i = new Intent(c , BankATM.class);
                startActivity(i);
            }
        });
        floatingActionButton7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TODO something when floating action menu third item clicked
                Intent i = new Intent(c , AddEvent.class);
                startActivity(i);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_debt_tracker, menu);
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
