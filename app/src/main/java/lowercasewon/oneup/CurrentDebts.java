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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_debts);

        final GridView grid = (GridView) findViewById(R.id.gridView);
        final ArrayList<String> items = new ArrayList<String>();

        grid.setAdapter(new GridAdapter(FinancialOverview.debtList));
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_current_debts, menu);
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

    public static final class GridAdapter extends BaseAdapter {

        private static final int ROW_ITEMS = 3;
        final ArrayList<String> mItems;
        final int mCount;

        /**
         * Default constructor
         * @param items to fill data to
         */
        private GridAdapter(final ArrayList<String> items) {

            mCount = items.size() * ROW_ITEMS;
            mItems = new ArrayList<String>(mCount);

            // for small size of items it's ok to do it here, sync way
            for (String item : items) {
                // get separate string parts, divided by ,
                final String[] parts = item.split(",");

                // remove spaces from parts
                for (String part : parts) {
                    part.replace(" ", "");
                    mItems.add(part);
                }
            }
        }

        @Override
        public int getCount() {
            return mCount;
        }

        @Override
        public Object getItem(final int position) {
            return mItems.get(position);
        }

        @Override
        public long getItemId(final int position) {
            return position;
        }

        @Override
        public View getView(final int position, final View convertView, final ViewGroup parent) {

            View view = convertView;

            if (view == null) {
                view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
            }

            final TextView text = (TextView) view.findViewById(android.R.id.text1);

            text.setText(mItems.get(position));

            return view;
        }
    }
}


