package org.haotao.common.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;


/** 像素转换工具
 * @author MarkMjw
 */
public class PixelUtil {


    /**
     * dp转 px.
     *
     * @param value   the value
     * @param context the context
     * @return the int
     */
    public static int dp2px( Context context,float value) {
        final float scale = context.getResources().getDisplayMetrics().densityDpi;
        return (int) (value * (scale / 160) + 0.5f);
    }

    /**
     * px转dp.
     *
     * @param value   the value
     * @param context the context
     * @return the int
     */
    public static int px2dp(float value, Context context) {
        final float scale = context.getResources().getDisplayMetrics().densityDpi;
        return (int) ((value * 160) / scale + 0.5f);
    }


    /**
     * sp转px.
     *
     * @param value   the value
     * @param context the context
     * @return the int
     */
    public static int sp2px(float value, Context context) {
        Resources r;
        if (context == null) {
            r = Resources.getSystem();
        } else {
            r = context.getResources();
        }
        float spvalue = value * r.getDisplayMetrics().scaledDensity;
        return (int) (spvalue + 0.5f);
    }


    /**
     * px转sp.
     *
     * @param value   the value
     * @param context the context
     * @return the int
     */
    public static int px2sp(float value, Context context) {
        final float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (value / scale + 0.5f);
    }
    
    /**
     * 获取屏幕宽度
     *
     * @param value   the value
     * @param context the context
     * @return the int
     */
    public static int getScreenWidth(Context activity) {
        // 获取屏幕密度（方法2） 
        DisplayMetrics dm = new DisplayMetrics(); 
        dm = activity.getResources().getDisplayMetrics(); 
        return  dm.widthPixels;      // 屏幕宽（像素，如：480px） 
    }
    /**
     * 获取屏幕宽度
     *
     * @param value   the value
     * @param context the context
     * @return the int
     */
    public static float getScreenWidthDp(Context activity) {
    	// 获取屏幕密度（方法2） 
    	DisplayMetrics dm = new DisplayMetrics(); 
    	dm = activity.getResources().getDisplayMetrics(); 
    	return  dm.xdpi;      // 屏幕宽（像素，如：480px） 
    }
    /**
     * 获取屏幕高度
     *
     * @param value   the value
     * @param context the context
     * @return the int
     */
    public static int getScreenHeight(Activity activity) {
    	// 获取屏幕密度（方法2） 
    	DisplayMetrics dm = new DisplayMetrics(); 
    	dm = activity.getResources().getDisplayMetrics(); 
    	return  dm.heightPixels;      // 屏幕宽（像素，如：480px） 
    }

}
