package poliban.ac.id.e020320042.listindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class InputControlActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_control);

        TextView tvValue = findViewById(R.id.tv_value);
        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                String  value = String.format("%d%%",i);
                tvValue.setText(value);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                tvValue.setText("Started!");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button btSubmitCb = findViewById(R.id.bt_submit_cb);
        btSubmitCb.setOnClickListener(this::doInCheckBox);

        Button btSubmitrb = findViewById(R.id.bt_submit_rb);
        btSubmitrb.setOnClickListener(this::doinRadioButton);
        Spinner spinner = findViewById(R.id.spinner);
    }

    private void doinRadioButton(View view) {
        int[] rbs = {R.id.rb_prog, R.id.rb_sa, R.id.rb_ui_designer};
        RadioButton[] radioButtons = new RadioButton[rbs.length];
        List<String> result = new ArrayList<>();

        for (int i = 0; i < rbs.length; i++) {
            radioButtons[i] = findViewById(rbs[i]);
            if (radioButtons[i].isChecked())
                result.add(radioButtons[i].getText().toString());
        }
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
    private void doInCheckBox(View view) {
        int[] cbs = {R.id.cb_c, R.id.cb_python,  R.id.cb_go, R.id.cb_java};
        CheckBox[] checkBoxes = new CheckBox[cbs.length];
        List<String> result = new ArrayList<>();

        for (int i = 0; i < cbs.length; i++) {
            checkBoxes[i] = findViewById(cbs[i]);
            if (checkBoxes[i].isChecked())
                result.add(checkBoxes[i].getText().toString());
        }
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();

        FlagAdapter fa = new FlagAdapter((this, mList));
        spinner.setAdapter(fa);
    }
}