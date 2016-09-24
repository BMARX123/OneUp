package lowercasewon.oneup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MonthlyStatements extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monthly_statements);
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Total Monthly Income: = " + FinancialOverview.totalMonthlyIncum);
        TextView textView2 = (TextView) findViewById(R.id.textView2);
        textView2.setText("Total Monthly Investments: = " + FinancialOverview.investmentPercentage * FinancialOverview.totalMonthlyIncum);
        TextView textView3 = (TextView) findViewById(R.id.textView3);
        textView3.setText("Total Monthly Savings: = " + FinancialOverview.savingsPercentage * FinancialOverview.totalMonthlyIncum);
        TextView textView4 = (TextView) findViewById(R.id.textView4);
        textView4.setText("Total Monthly Spending: = " + FinancialOverview.moneySpentThisMonth);
        if(!FinancialOverview.hasFourK) {
            TextView textView5 = (TextView) findViewById(R.id.textView5);
            textView5.setText("Monthly Deposit in IRA: = " + FinancialOverview.totalMonthlyIncum * FinancialOverview.rothIraPercent);

        } else {
            TextView textView6 = (TextView) findViewById(R.id.textView6);
            textView6.setText("Monthly Deposit in 401K: = " + FinancialOverview.totalMonthlyIncum * FinancialOverview.rothIraPercent);

        }
        TextView textView7 = (TextView) findViewById(R.id.textView7);
        textView7.setText("Monthly change in debt = " + -1*(FinancialOverview.totalMonthlyIncum - (FinancialOverview.totalMonthlyIncum*FinancialOverview.investmentPercentage) - (FinancialOverview.totalMonthlyIncum*FinancialOverview.savingsPercentage)-(FinancialOverview.totalMonthlyIncum*FinancialOverview.rothIraPercent)-(FinancialOverview.moneySpentThisMonth)));









    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_monthly_statements, menu);
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
