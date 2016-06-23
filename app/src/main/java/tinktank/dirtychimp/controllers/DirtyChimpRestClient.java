package tinktank.dirtychimp.controllers;
import com.loopj.android.http.*;


/**
 * @author: Chris Rijos : Tinktank Software
 * Description: This class handles asynchronous request to the dirty chimp website.
 */
public class DirtyChimpRestClient {

    /*Constant for API request URL*/
    private static final String DirtyChimpApiUrl = "http://mysafeinfo.com/api/data?list=englishmonarchs&format=json";

    /*Asynchronous HTTP client*/
    private static AsyncHttpClient client = new AsyncHttpClient();

    /*Default Constructor*/
    public DirtyChimpRestClient() {

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
