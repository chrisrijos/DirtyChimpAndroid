package tinktank.dirtychimp.models;

import java.util.ArrayList;

/**
 * @author: Christopher Rijos : TinkTank Software
 * Description: The purpose of this class is to provide a generalized model for interacting
 * and assigning data from the Video info being parsed from json
 */
public class Video {

    private String v_title;
    private String v_desc;
    private String v_url;
    private ArrayList v_tags;

    /*Default Constructor*/
    public Video(){

    }

    /*Constructor for Video*/
    public Video(String title, String desc, String url){
        this.v_title = title;
        this.v_desc = desc;
        this.v_url = url;
    }

    /*Retrieves title from video*/
    public String getV_title() {
        return v_title;
    }

    public void setV_title(String v_title) {
        this.v_title = v_title;
    }

    /*Retrieves description*/
    public String getV_desc() {
        return v_desc;
    }

    public void setV_desc(String v_desc) {
        this.v_desc = v_desc;
    }

    /*Retrieves video_url*/
    public String getV_url() {
        return v_url;
    }

    public void setV_url(String v_url) {
        this.v_url = v_url;
    }

    /*Retrieves tags*/
    public ArrayList getV_tags() {
        return v_tags;
    }

    /*Sets tags for the video model*/
    public void setV_tags(ArrayList v_tags) {
        this.v_tags = v_tags;
    }
}
