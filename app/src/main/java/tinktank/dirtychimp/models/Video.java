package tinktank.dirtychimp.models;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import tinktank.dirtychimp.networking.DirtyChimpRestClient;

/**
 * @author: Christopher Rijos : TinkTank Software
 * Description: The purpose of this class is to provide a generalized model for interacting
 * and assigning data from the Video info being parsed from json
 */
public class Video {



    /*Makes the asynchronous call to fill a list with the video data */
    public static List<ListItem> getListData(){
        List<ListItem> data = new ArrayList<>();

            DirtyChimpRestClient.get("", null, new JsonHttpResponseHandler(){

                //on json connect success
                @Override
                public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

                    String t = "video";
                    //populates array with json objects related to key
                    List<ListItem> list = new ArrayList<ListItem>();

                    for(int i = 0; i < response.length(); i++) {
                        try {
                            list.add((ListItem) response.get(i));
                            System.out.println("Response: " + list);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                }

                @Override
                public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {

                    System.out.println(errorResponse.toString());
                }
            });
        return data;
    }
}
