package poliban.ac.id.e020320042.listindemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ActivityRecycleView extends AppCompatActivity {
    private final List<String> mList = new ArrayList<>();
    private FriendAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        mList.add("Aditya Ramadan");
        mList.add("Muhammad Nor Fauzi");
        mList.add("Adi Rahadai Nugraha");

        mAdapter = new FriendAdapter(this, mList);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fab_recysler);
        fab.setOnClickListener(this::addFriend);

    }

    private void addFriend(View view) {
        View subView = LayoutInflater.from(this)
                .inflate(R.layout.item_input, null, false);
        EditText etFriend = subView.findViewById(R.id.et_item);
        etFriend.setHint("Enter your friend");
        etFriend.setInputType(InputType.TYPE_TEXT_FLAG_CAP_WORDS);

        new AlertDialog.Builder(this)
                .setTitle("Add Friend")
                .setView(subView)
                .setCancelable(false)
                .setNegativeButton("Cancel", null)
                .setPositiveButton("Yes", (dialogInterface, i) -> {
                    if (!etFriend.getText().toString().isEmpty()){
                        mList.add(etFriend.getText().toString());
                        mAdapter.notifyDataSetChanged();
                    }
                })
                .show();
    }

    public static class ActivityListView extends AppCompatActivity {
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
}