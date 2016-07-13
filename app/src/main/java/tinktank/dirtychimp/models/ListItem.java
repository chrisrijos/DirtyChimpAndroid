package tinktank.dirtychimp.models;

import java.util.ArrayList;

/**
 * @author: Chris Rijos : TinkTank Software
 * Description: This class will adapt the json response into a list item format
 * that can be used within the recycler view.
 */
public class ListItem{

    private String video_title;
    private String video_description;
    private String video_thumbnail_url;

    public ListItem(String video_title, String video_description, String video_thumbnail_url){
        this.video_title = video_title;
        this.video_description = video_description;
        this.video_thumbnail_url = video_thumbnail_url;
    }

    public String getVideo_title() {
        return video_title;
    }

    public void setVideo_title(String video_title) {
        this.video_title = video_title;
    }

    public String getVideo_description() {
        return video_description;
    }

    public void setVideo_description(String video_description) {
        this.video_description = video_description;
    }

    public String getVideo_thumbnail_url() {
        return video_thumbnail_url;
    }

    public void setVideo_thumbnail_url(String video_thumbnail_url) {
        this.video_thumbnail_url = video_thumbnail_url;
    }
}
