package org.haitao.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ListView;

/**
 * Description
 * Author by wangHaitao(a758277560@gmail.com)
 * Created  on 2015/11/17.
 * Version 1.0
 */
public class ListViewForScrollNoClick extends ListView {

    public ListViewForScrollNoClick(Context context) {
        super(context);
    }

    public ListViewForScrollNoClick(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ListViewForScrollNoClick(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);

    }
	
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
            return true;// true 拦截事件自己处理，禁止向下传递
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
            return false;// false 自己不处理此次事件以及后续的事件，那么向上传递给外层view
    }
}
