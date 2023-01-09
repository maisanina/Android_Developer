package ac.id.poliban.e020320042.buttondemos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btOne = findViewById(R.id.button01);
        Button btTwo = findViewById(R.id.button02);
        Button btThree = findViewById(R.id.button03);
        Button btFour = findViewById(R.id.button04);
        Button btFive = findViewById(R.id.button05);
    }
}