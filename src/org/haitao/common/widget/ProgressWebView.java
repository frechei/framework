package org.haitao.common.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * 带进度条的WebView
 */

/**
 * @Description:带进度条的WebView
 */
public class ProgressWebView extends WebView {

	private ProgressBar progressbar;

	public ProgressWebView(final Context context, AttributeSet attrs) {
		super(context, attrs);
		progressbar = new ProgressBar(context, null, android.R.attr.progressBarStyleHorizontal);
		progressbar.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, 5, 0, 0));
		
		// setWebViewClient(new WebViewClient(){});
		setWebChromeClient(new WebChromeClient());
		// 是否可以缩放
		getSettings().setSupportZoom(true);
		getSettings().setBuiltInZoomControls(true);
		setWebViewClient(new WebViewClient() {
			public boolean shouldOverrideUrlLoading(WebView view, String url)
			{ //  重写此方法表明点击网页里面的链接还是在当前的webview里跳转，不跳到浏览器那边
                if( url.startsWith("http:") || url.startsWith("https:") ) {
                    view.loadUrl(url);
                    return false;
                }
                // Otherwise allow the OS to handle things like tel, mailto, etc.
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                context.startActivity(intent );
                return true;
			}
		});
	}
    


	/**
	* @param drawable
	* @return void    返回类型
	*/
	public void setProgressDrawable(Drawable drawable ){
		progressbar.setProgressDrawable(drawable);
		addView(progressbar);
	}
	/**
	 * @param drawable
	 * @return void    返回类型
	 */
	public void setProgressDrawableInt(int drawable ){
		progressbar.setProgress(drawable);
		addView(progressbar);
	}
	public class WebChromeClient extends android.webkit.WebChromeClient {
		@Override
		public void onProgressChanged(WebView view, int newProgress) {
			if (newProgress == 100) {
				progressbar.setVisibility(GONE);
			} else {
				if (progressbar.getVisibility() == GONE)
					progressbar.setVisibility(VISIBLE);
				progressbar.setProgress(newProgress);
			}
			super.onProgressChanged(view, newProgress);
		}

	}

	@Override
	protected void onScrollChanged(int l, int t, int oldl, int oldt) {
		LayoutParams lp = (LayoutParams) progressbar.getLayoutParams();
		lp.x = l;
		lp.y = t;
		progressbar.setLayoutParams(lp);
		super.onScrollChanged(l, t, oldl, oldt);
	}
}
