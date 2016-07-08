package tinktank.dirtychimp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author: Chris Rijos : TinkTank Software
 * Description: This class adapts the recycler view to fit the list and handles application context.
 */
public class ListAdapter {

    class ListHolder extends RecyclerView.ViewHolder{

        public ListHolder(View itemView) {
            super(itemView);
        }
    }
}
