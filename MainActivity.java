package in.santiniketan.browser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    WebView browser;
    EditText url_txt;
    ImageButton search;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        browser =findViewById(R.id.web_browser);
      url_txt= findViewById(R.id.url_txt);
      search = findViewById(R.id.search_btn);
      browser.setWebViewClient(new myWebViewClient());

      search.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String url = url_txt.getText().toString();

              browser.getSettings().setLoadsImagesAutomatically(true);
              browser.getSettings().setJavaScriptEnabled(true);

              browser.loadUrl(url);
          }
      });



    }

    private class myWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}

