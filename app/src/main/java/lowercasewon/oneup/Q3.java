package lowercasewon.oneup;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Q3 extends AppCompatActivity {

    Button yes;
    Button no;
    Context c = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q3);

        yes = (Button)findViewById(R.id.yes);
        no = (Button)findViewById(R.id.no);

        yes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FinancialOverview.longTermJob = true;
                Intent i = new Intent(c, Q4.class);
                startActivity(i);
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FinancialOverview.longTermJob = false;
                Intent i = new Intent(c, Q6.class);
                startActivity(i);
            }
        });
    }
}
