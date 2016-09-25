package lowercasewon.oneup;

import android.content.Context;
import android.content.Intent;
import android.renderscript.Double2;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Q2 extends AppCompatActivity {

    EditText age;
    EditText mIncome;
    EditText monthlySetAside;
    EditText percentInvest;
    Button button;
    Context c = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);

        age = (EditText)findViewById(R.id.age);
        mIncome = (EditText)findViewById(R.id.income);
        monthlySetAside = (EditText)findViewById(R.id.incomePercent);
        percentInvest = (EditText)findViewById(R.id.investPercent);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                FinancialOverview.age = Integer.parseInt(age.toString());
                FinancialOverview.averageMonthlyIncome = Double.parseDouble(mIncome.toString());
                FinancialOverview.savingsPercentage = Integer.parseInt(monthlySetAside.toString());
                FinancialOverview.investmentPercentage = Integer.parseInt(percentInvest.toString());

                /*Intent i = new Intent(c, Q3.class);
                startActivity(i);*/

            }
        });
    }
}
