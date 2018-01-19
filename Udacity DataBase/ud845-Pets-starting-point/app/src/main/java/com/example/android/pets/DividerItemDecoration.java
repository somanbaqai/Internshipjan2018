package com.example.android.pets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by soman on 1/19/2018.
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    private Drawable dividerObj;

    public DividerItemDecoration(Context context) {
        dividerObj = ContextCompat.getDrawable(context,R.drawable.line_divider);
    }

    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
//        super.onDrawOver(c, parent, state);
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        int childCount = parent.getChildCount();
        for(int i = 0 ; i < parent.getChildCount();i++){
            View child = parent.getChildAt(i);
            RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            int top = child.getBottom() + params.bottomMargin;
            int bottom = top + dividerObj.getIntrinsicHeight();
            dividerObj.setBounds(left,top,right,bottom);
            dividerObj.draw(c);

        }





    }
}
