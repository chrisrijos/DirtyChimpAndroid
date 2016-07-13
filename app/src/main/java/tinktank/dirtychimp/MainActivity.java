package tinktank.dirtychimp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import tinktank.dirtychimp.adapters.ListAdapter;
import tinktank.dirtychimp.models.Video;

public class MainActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.rec_list);
        //layour manager: GridLayout Manager or StaggeredGridLayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listAdapter = new ListAdapter(Video.getListData(), this);

        recyclerView.setAdapter(listAdapter);
    }
}
