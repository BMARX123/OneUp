package lowercasewon.oneup;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Q4 extends AppCompatActivity {

    Button yes;
    Button no;
    Context c = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q4);

        yes = (Button)findViewById(R.id.yes);
        no = (Button)findViewById(R.id.no);

        yes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FinancialOverview.fourKOffer = true;
                Intent i = new Intent(c, Q5.class);
                startActivity(i);
            }
        });

        yes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FinancialOverview.fourKOffer = false;
                Intent i = new Intent(c, Q6.class);
                startActivity(i);
            }
        });
    }
}
