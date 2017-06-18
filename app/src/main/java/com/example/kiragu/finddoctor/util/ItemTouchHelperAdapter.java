package com.example.kiragu.finddoctor.util;

/**
 * Created by kiragu on 6/18/17.
 */

public interface ItemTouchHelperAdapter {
    boolean onItemMove(int fromPosition, int toPosition);
    void onItemDismiss(int position);
}
