package lowercasewon.oneup;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.github.clans.fab.FloatingActionMenu;

import java.util.ArrayList;






public class CurrentDebts extends AppCompatActivity {

    Context c  = this  ;
    FloatingActionMenu materialDesignFAM;
    FloatingActionButton floatingActionButton1, floatingActionButton2, floatingActionButton3, floatingActionButton4, floatingActionButton5, floatingActionButton6, floatingActionButton7;
    GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_debts);
        setTitle("Current Debt");


        ArrayList<Bill> items = FinancialOverview.debtList;
        ArrayList<String> w = new ArrayList<>();
        int k = 0;

        w.add("Name Of Debt");
        w.add("Monthly Due");
        w.add("Total Due");
        for (Bill b : items ){
            w.add(b.getNameOfBill());
            //w.add(b.getInterestRate() + "");
            w.add(b.getMonthlyDue() + "");
            w.add(b.getTotalDue() + "");
        }

        gridview = (GridView)findViewById(R.id.gridView1);
        ArrayAdapter<String> adpater = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, w);
        gridview.setAdapter(adpater);

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
                Intent i = new Intent(c , CurrentDebts.class);
                startActivity(i);
            }
        });
        /*floatingActionButton5.setOnClickListener(new View.OnClickListener() {
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




}


