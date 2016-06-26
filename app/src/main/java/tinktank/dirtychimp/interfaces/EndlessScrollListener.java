package tinktank.dirtychimp.interfaces;

import android.widget.AbsListView;

/**
 * @author: Chris Rijos : TinkTank Software
 * Desc: This class creates a standard interface to be used as an endless scroll listener.
 * The interface must be able to have videos preloaded within a visible region and outside of the
 * visible region but the viewport would remain static.
 */
public abstract class EndlessScrollListener implements AbsListView.OnScrollListener {

    //the number of items to have below the current scroll position
    private int visibleThreshold = 5;
    //the index of the page you have loaded
    private int currentPage = 0;
    //the total number of items in the dataset after the last load
    private int previousTotalItemCount = 0;
    //true if we are still waiting for the last set of data to load
    private boolean loading = true;
    //Sets the index of the starting page
    private int startingPageIndx = 0;

    /*Default*/
    public EndlessScrollListener(){

    }

    public EndlessScrollListener(int visibleThreshold){
        this.visibleThreshold = visibleThreshold;
    }

    /*Initializes the listener with the threshold of the viewpart and sets
    * sets the current page to the page you would liek to start at*/
    public EndlessScrollListener(int visibleThreshold, int startPage){
        this.visibleThreshold = visibleThreshold;
        this.startingPageIndx = startPage;
        this.currentPage = startPage;
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount){
        /*checks the total item count, if zero
        * the list is invalidated.*/
        if(totalItemCount < previousTotalItemCount){
            this.currentPage = this.startingPageIndx;
            this.previousTotalItemCount = totalItemCount;
            if(totalItemCount == 0){
                this.loading = true;
            }
        }
        /*Check to see if the page is still loading the given dataset
        * if it is  we conclude that we can update the current page number and total
        * items within teh list view.*/
        if(loading && (totalItemCount > previousTotalItemCount)){
            loading = false;
            previousTotalItemCount = totalItemCount;
            currentPage++;
        }

        /*If it isnt currently loading, we check to see if we have breached the visible
        * threshold and need to reload more data.*/
        if(!loading && (firstVisibleItem + visibleItemCount + visibleThreshold) >= totalItemCount){
            loading = onLoadMore(currentPage + 1, totalItemCount);
        }
    }
    //Defines the abstract process of loading more pages
    protected abstract boolean onLoadMore(int i, int totalItemCount);

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        // Don't take any action on changed
    }
}

