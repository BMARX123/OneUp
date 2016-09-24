package lowercasewon.oneup;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Q1 extends AppCompatActivity {

    EditText fName;
    EditText lName;
    EditText eMail;
    EditText pWord;
    Button button;
    Context c = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);

        fName = (EditText)findViewById(R.id.fName);
        lName = (EditText)findViewById(R.id.lName);
        eMail = (EditText)findViewById(R.id.email);
        pWord = (EditText)findViewById(R.id.password);
        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                FinancialOverview.firstName = fName.toString();
                FinancialOverview.lastName = fName.toString();
                FinancialOverview.email = eMail.toString();
                FinancialOverview.password = pWord.toString();

                Intent i = new Intent(c, Q2.class);
                startActivity(i);

            }
        });
    }
}
