package tinktank.dirtychimp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import tinktank.dirtychimp.R;
import tinktank.dirtychimp.models.ListItem;

/**
 * @author: Chris Rijos : TinkTank Software
 * Description: This class adapts the recycler view to fit the list and handles application context.
 */
public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListHolder>{

    private List<ListItem> listData;
    private LayoutInflater inflater;

    public ListAdapter (List<ListItem> data, Context c){
        this.listData = data;
        this.inflater = LayoutInflater.from(c);
    }

    //inner class for assigning fields to a view element
    class ListHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private ImageView icon;
        private View container;

        public ListHolder(View itemView) {
            super(itemView);

            title = (TextView)itemView.findViewById(R.id.lbl_item_text);
            icon = (ImageView)itemView.findViewById(R.id.im_item_icon);
            container = itemView.findViewById(R.id.cont_item_root);

        }
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ListHolder(view);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        ListItem item = listData.get(position);
        holder.title.setText(item.getVideo_title());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }


}
