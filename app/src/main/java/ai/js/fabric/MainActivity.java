package ai.js.fabric;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	private WebView webView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getWindow().requestFeature(Window.FEATURE_PROGRESS);

		setContentView(R.layout.activity_main);
		webView = (WebView)findViewById(R.id.web_view);

		webView.getSettings().setJavaScriptEnabled(true);

		final Activity activity = this;
		webView.setWebChromeClient(new WebChromeClient() {
			public void onProgressChanged(WebView view, int progress) {
				// Activities and WebViews measure progress with different scales.
				// The progress meter will automatically disappear when we reach 100%
				activity.setProgress(progress * 1000);
			}
		});
		webView.setWebViewClient(new WebViewClient() {
			public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
				Toast.makeText(activity, "Oh no! " + description, Toast.LENGTH_SHORT).show();
			}
		});


	}

	@Override
	protected void onResume() {
		super.onResume();
		///webView.loadUrl("http://fabricjs.com/freedrawing");
		webView.loadUrl("https://ninesummer.github.io/fabricjs.com/kitchensink");
	}
}
