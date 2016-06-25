package tinktank.dirtychimp.networking;
import com.loopj.android.http.*;


/**
 * @author: Chris Rijos : Tinktank Software
 * Description: This class handles asynchronous request to the dirty chimp website.
 */
public class DirtyChimpRestClient {

    /*Constant for API request URL*/
    private static String DirtyChimpApiUrl = "https://dirty-chimp-chrisrijos.c9users.io/video/index.json";

    /*Asynchronous HTTP client*/
    private static AsyncHttpClient client = new AsyncHttpClient();

    /*Default Constructor*/
    public DirtyChimpRestClient(){

    }

    /*Initializes client with given url*/
    public DirtyChimpRestClient(String url){
        this.DirtyChimpApiUrl = url;
    }

    /*Handles the asynchronous get request from theDirtyChimpApi*/
    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler){
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    /*Handles the asynchronous post request from theDirtyChimpApi*/
    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    /*Appends the relative url to the base URL*/
    public static String getAbsoluteUrl(String relativeURL){
        return DirtyChimpApiUrl + relativeURL;
    }
}
