package lowercasewon.oneup;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Q5 extends AppCompatActivity {
    Context c = this;
    Button next;
    EditText percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q5);
        next = (Button)findViewById(R.id.button2);
        percent = (EditText)findViewById(R.id.kPercent);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FinancialOverview.fourKPercent = Integer.parseInt(percent.toString());
                //Intent i = new Intent(c, Q6.class);
                //startActivity(i);
            }
        });
    }
}
