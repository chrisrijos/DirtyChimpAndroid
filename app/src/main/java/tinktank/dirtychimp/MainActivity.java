package tinktank.dirtychimp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import tinktank.dirtychimp.adapters.ListAdapter;

public class MainActivity extends AppCompatActivity{

    private RecyclerView recyclerView;
    private ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView)findViewById(R.id.rec_list);

        listAdapter = new ListAdapter();
    }
}
