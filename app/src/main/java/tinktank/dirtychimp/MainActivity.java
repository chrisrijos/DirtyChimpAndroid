package tinktank.dirtychimp;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import org.json.*;
import com.loopj.android.http.*;

import cz.msebera.android.httpclient.Header;
import tinktank.dirtychimp.controllers.DirtyChimpRestClient;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DirtyChimpRestClient.get("", null, new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                try {
                    JSONObject firstEvent = (JSONObject) response.get(0);
                    String video_url = firstEvent.getString("nm");

                    //handle response
                    System.out.println(video_url);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {

                System.out.println(errorResponse.toString());
            }
        });
    }
}
