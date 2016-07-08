package tinktank.dirtychimp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import tinktank.dirtychimp.models.Video;

public class MainActivity extends AppCompatActivity{

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Video test = new Video();

        test.getListData();
    }
}
