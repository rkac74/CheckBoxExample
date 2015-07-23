package edu.umkc.burrise.checkboxexample2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckboxManager cbm = CheckboxManager.get(getApplication());

        CheckBox cb = (CheckBox)findViewById(R.id.completedCheckBox);
        cb.setChecked(cbm.checked);
    }

    public void onToggle(View v) {
        CheckBox cb = (CheckBox)findViewById(R.id.completedCheckBox);
        boolean currentValue = cb.isChecked();
        cb.setChecked(!currentValue);

        CheckboxManager cbm = CheckboxManager.get(getApplication());
        cbm.checked = !currentValue;
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Checkbox Example", "onPause()");
        CheckboxManager cbm = CheckboxManager.get(getApplication());
        cbm.persist();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
