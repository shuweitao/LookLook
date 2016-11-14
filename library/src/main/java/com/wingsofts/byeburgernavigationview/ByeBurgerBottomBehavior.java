package com.wingsofts.byeburgernavigationview;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Bye Bye Burger Navigation Bar Behavior
 * <p>
 * Created by wing on 11/5/16.
 */

public class ByeBurgerBottomBehavior extends ByeBurgerBehavior {

    private TranslateAnimateHelper mAnimateHelper;

    public ByeBurgerBottomBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, View child, View target,
                                  int dx, int dy, int[] consumed) {

    if (isFirstMove) {
      isFirstMove = false;
      mAnimateHelper = TranslateAnimateHelper.get(child);
      mAnimateHelper.setStartY(child.getY());
      mAnimateHelper.setMode(TranslateAnimateHelper.MODE_BOTTOM);
    }
    if (Math.abs(dy) > mTouchSlop) {
      if (dy < 0) {

        if (mAnimateHelper.getState() == TranslateAnimateHelper.STATE_HIDE) {
          mAnimateHelper.show();
        }
      } else if (dy > 0) {
        if (mAnimateHelper.getState() == TranslateAnimateHelper.STATE_SHOW) {
          mAnimateHelper.hide();
        }
      }
    }


//        if (isFirstMove) {
//            isFirstMove = false;
//            mAnimateHelper = TranslateAnimateHelper.get(child);
//            mAnimateHelper.setStartY(child.getY());
//            mAnimateHelper.setMode(TranslateAnimateHelper.MODE_BOTTOM);
//        }
//        if (dy < 0) {
//
//            if (mAnimateHelper.getState() == TranslateAnimateHelper.STATE_HIDE) {
//                mAnimateHelper.show();
//            }
//        } else if (dy > 0) {
//            if (mAnimateHelper.getState() == TranslateAnimateHelper.STATE_SHOW) {
//                mAnimateHelper.hide();
//            }
//        }


//    if (dy > 0 && child.getVisibility() == View.VISIBLE) {
//            // User scrolled down and the FAB is currently visible -> hide the FAB
//            child.setVisibility(View.GONE);
//        } else if (dy < 0 && child.getVisibility() != View.VISIBLE) {
//            // User scrolled up and the FAB is currently not visible -> show the FAB
//      child.setVisibility(View.VISIBLE);
//        }

    }


}
