package tinktank.dirtychimp.adapters;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author: Chris Rijos : TinkTank Software
 * Desc: This class will handle serializing the data from the json file
 */
public class JSONAdapter{



    /*Default Constructor*/
    public JSONAdapter(){

    }

    /*converts JSONArrayInput and key into a list of all of the entries with that key*/
    public ArrayList<String> convert_json_string(String key, JSONArray array){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < array.length(); i++){
            try {
                list.add(array.getJSONObject(i).getString(key));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return (ArrayList<String>) list;
    }

    /*Converts JSONObject to hashmap*/
    public Map<String, Object> toMap(JSONObject object) throws JSONException{
        Map<String, Object> map = new HashMap<String, Object>();

        Iterator<String> keysIterator = object.keys();
        //tokenizes using an iterator to determing if more is available withint the json array
        while(keysIterator.hasNext()){
            String key = keysIterator.next();
            Object value = object.get(key);

            if(value instanceof JSONArray){
                value = Arrays.asList((JSONArray) value);
            }
            else if(value instanceof JSONObject){
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }
}
