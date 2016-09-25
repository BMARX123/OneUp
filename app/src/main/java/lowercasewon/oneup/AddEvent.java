package lowercasewon.oneup;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddEvent extends AppCompatActivity {
    public Context d = this;
    public Bill temp;
    EditText billName;
    EditText monthlyDue;
    EditText intrestRate;
    EditText totalDue;
    double tempMonthly;
    double tempIntrest;
    double tempTotal;
    String tempBill;
    Button button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        billName = (EditText)findViewById(R.id.editText);
        monthlyDue = (EditText)findViewById(R.id.editText2);
        intrestRate = (EditText)findViewById(R.id.editText3);
        totalDue = (EditText)findViewById(R.id.editText4);
        button2 = (Button) findViewById(R.id.button2);


        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View i) {
                tempMonthly = Double.parseDouble(monthlyDue.getText().toString());
                tempBill = billName.getText().toString();
                tempIntrest = Double.parseDouble(intrestRate.getText().toString());
                tempTotal = Double.parseDouble(totalDue.getText().toString());

                Toast.makeText(getApplicationContext(), "Thank you. Please fill out again to add more debts",
                        Toast.LENGTH_SHORT).show();
            }
        });
        //need prompts for interest rate, monthly due and total due
        temp = new Bill(tempBill, tempMonthly, tempIntrest, tempTotal);
        billName.setText("");
        monthlyDue.setText("");
        intrestRate.setText("");
        totalDue.setText("");

        if(temp!= null) {
            FinancialOverview.debtList.add(temp);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_monthly_averages, menu);
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
