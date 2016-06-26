package tinktank.dirtychimp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.*;
import com.loopj.android.http.*;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import tinktank.dirtychimp.adapters.JSONAdapter;
import tinktank.dirtychimp.interfaces.EndlessScrollListener;
import tinktank.dirtychimp.networking.DirtyChimpRestClient;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DirtyChimpRestClient.get("", null, new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

                String t = "video";
                //populates array with json objects related to key
                ArrayList<String> jsonObjects = (new JSONAdapter().convert_json_string(t, response));
                for(String s : jsonObjects){
                    System.out.println(s);
                }
                //creates list view
                ListView listView = (ListView) findViewById(R.id.listView);

                listView.setOnScrollListener(new EndlessScrollListener() {
                    @Override
                    protected boolean onLoadMore(int page, int totalItemsCount) {
                        // Triggered only when new data needs to be appended to the list
                        // Add whatever code is needed to append new items to your AdapterView
                        LoadMoreDataFromApi(page);
                        // or customLoadMoreDataFromApi(totalItemsCount);
                        return true; // ONLY if more data is actually being loaded; false otherwise.
                    }
                });
            }

            // Append more data into the adapter
            public void LoadMoreDataFromApi(int offset) {
                // This method probably sends out a network request and appends new data items to your adapter.
                // Use the offset value and add it as a parameter to your API request to retrieve paginated data.
                // Deserialize API response and then construct new objects to append to the adapter
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {

                System.out.println(errorResponse.toString());
            }
        });
    }
}
