package lowercasewon.oneup;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Q6 extends AppCompatActivity {
    Context c = this;
    Button next;
    EditText percent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q6);
        next = (Button)findViewById(R.id.button2);
        percent = (EditText)findViewById(R.id.kPercent);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FinancialOverview.rothIraPercent = Double.parseDouble(percent.getText().toString());

                AlertDialog alertDialog = new AlertDialog.Builder(c).create();
                alertDialog.setTitle("Thank You for Enetering Your Details");
                alertDialog.setMessage("Please Add All Bills That You Have");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(c, AddEvent.class);
                                startActivity(i);
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();

            }
        });
    }
}
