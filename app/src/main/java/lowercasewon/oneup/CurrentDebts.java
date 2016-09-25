package lowercasewon.oneup;

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

import java.util.ArrayList;






public class CurrentDebts extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_debts);

        final GridView grid = (GridView) findViewById(R.id.gridView);
        final ArrayList<String> items = new ArrayList<String>();

        grid.setAdapter(new GridAdapter(FinancialOverview.debtList));
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


