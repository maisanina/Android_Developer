package poliban.e020320042.hellocompatV2;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView mHelloTextView;
    private String[] mColorArray = {"red", "pink", "purple", "deep_purple", "indigo", "blue", "light_blue", "cyan", "teal", "green", "light_green", "lime", "yellow", "amber", "orange", "deep_orange", "brown", "grey", "blue_grey", "black"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mHelloTextView = findViewById(R.id.hello_textView);
        if (savedInstanceState != null){
            mHelloTextView.setTextColor(savedInstanceState.getInt("color"));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("color", mHelloTextView.getCurrentTextColor());
    }

    public void changeColor(View view) {
        int colorRes;
        Random random = new Random();
        String colorName = mColorArray[random.nextInt(20)];
        int resourceColorName = getResources().getIdentifier(colorName, "color", getApplicationContext().getPackageName());
        if(Build.VERSION.SDK_INT >= 23){
            colorRes = getResources().getColor(resourceColorName, this.getTheme());
        }
        else {
            colorRes = getResources().getColor(resourceColorName);
        }
        mHelloTextView.setTextColor(colorRes);



    }
}
