package poliban.ac.id.e020320042.listindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_list:
                startActivity(new Intent(MainActivity.this, ActivityListView.class));
                break;
            case R.id.action_recycler:
                startActivity(new Intent(MainActivity.this, ActivityRecycleView.class));
                break;
            case R.id.action_quit:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}