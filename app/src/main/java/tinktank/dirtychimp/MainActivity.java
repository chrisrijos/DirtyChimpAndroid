package tinktank.dirtychimp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import org.json.*;
import com.loopj.android.http.*;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import tinktank.dirtychimp.adapters.JSONAdapter;
import tinktank.dirtychimp.networking.DirtyChimpRestClient;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DirtyChimpRestClient.get("", null, new JsonHttpResponseHandler(){

            //on json connect success
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

                String t = "video";
                //populates array with json objects related to key
                ArrayList<String> jsonObjects = (new JSONAdapter().convert_json_string(t, response));
                for(String s : jsonObjects){
                    System.out.println(s);
                }
                //creates list view


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
