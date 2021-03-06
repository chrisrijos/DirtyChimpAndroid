package tinktank.dirtychimp.models;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RunnableFuture;

import cz.msebera.android.httpclient.Header;
import tinktank.dirtychimp.networking.DirtyChimpRestClient;

/**
 * @author: Christopher Rijos : TinkTank Software
 * Description: The purpose of this class is to provide a generalized model for interacting
 * and assigning data from the Video info being parsed from json
 */
public class Video {

    private List<ListItem> data = new ArrayList<>();

    /*Default Constructor*/
    public Video(){

    }

    /*Makes the asynchronous call to fill a list with the video data */
    public List<ListItem> getListData(){
        this.getResponse();
        return this.data;
    }

    /*Handles using RestClient to fill the list of json objects first within the video class*/
    public void getResponse(){
        DirtyChimpRestClient.get("", null, new JsonHttpResponseHandler(){

            //on json connect success
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                List<JSONObject> json_objects = new ArrayList<JSONObject>();
                try {

                    for(int i = 0; i < response.length(); i++){
                        json_objects.add(response.getJSONObject(i));
                    }

                    for(JSONObject o : json_objects){
                        data.add(new ListItem(
                                o.getString("title"),
                                o.getString("description"),
                                o.getString("video")
                        ));
                    }

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
