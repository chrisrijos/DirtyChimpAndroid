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

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

                String t = "video";
                ArrayList<String> jsonObjects = (new JSONAdapter().convert_json_string(t, response));
                for(String s : jsonObjects){
                    System.out.println(s);
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {

                System.out.println(errorResponse.toString());
            }
        });
    }
}
