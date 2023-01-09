package poliban.ac.id.e020320042.listindemo;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.LinkedList;

public class ActivityListView extends AppCompatActivity {
    private LinkedList<String> mList = new LinkedList<>();
    private CountryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        mList.add("Indonesia");
        mList.add("Thailand");
        mList.add("Brunei Darussalam");
        mList.add("Malaysia");

        adapter = new CountryAdapter(this, mList);

        ListView listView = findViewById(R.id.listview);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(this::onItemClicked);
        //tambahkan LiSTENER onItemLong Click

        listView.setOnItemLongClickListener(this::onItemLongClicked);

        //definisikan dan deklarasikan fab
        FloatingActionButton fab = findViewById(R.id.fab_list_view);
        //pasang listener onClick pada dab
        fab.setOnClickListener(this::addItem);

    }

    private void addItem(View view) {
        //buat sebuah object yang terhubung dengan R.layout
        View subView = LayoutInflater.from(this)
                .inflate(R.layout.item_input, null, false);
        //buat object Edittext yang merujuk ke R.id.et_item yang ada diinput
        EditText etItem = subView.findViewById(R.id.et_item);
        etItem.setHint("Input Nama Negara");
        etItem.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);

        //buat dialog input dari AlertDialog
        new AlertDialog.Builder(this)
                .setTitle("Add Item")
                .setView(subView)
                .setCancelable(false)
                .setNegativeButton("Batal", null)
                .setPositiveButton("Tambah", (dialogInterface, i) -> {
                    if (!etItem.getText().toString().isEmpty()){
                        mList.add(etItem.getText().toString());
                        adapter.notifyDataSetChanged();
                    }
                    })
                .show();

    }

    private boolean onItemLongClicked(AdapterView<?> adapterView, View view, int i, long l) {
        //method ini kita gunakan untuk mengapus item
        //1.tangkap item yang mau di hapus
        String item = adapterView.getAdapter().getItem(i).toString();
        //2.tampilkan alert dialog hapus
        new AlertDialog.Builder(this)
                .setTitle("Hapus Konfirmasi")
                .setMessage(String.format("Hapus %s?", item))
                .setNegativeButton("Batal", null)
                .setPositiveButton("Ya",(dialogInterface, which) -> {
                   mList.remove(item);
                   adapter.notifyDataSetChanged();
                })
                .show();
        return true;
    }

    private void onItemClicked(AdapterView<?> adapterView, View view, int i, long l) {
        String item = adapterView.getAdapter().getItem(i).toString();
        item = String.format("%s telah di klik", item);
        Snackbar.make(view, item, Snackbar.LENGTH_SHORT).show();
    }


}