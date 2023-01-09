package poliban.ac.id.e020320042.listindemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
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
}