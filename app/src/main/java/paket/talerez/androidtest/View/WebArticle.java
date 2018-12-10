package paket.talerez.androidtest.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import paket.talerez.androidtest.R;

public class WebArticle extends AppCompatActivity {

    @BindView(R.id.webviewnews)
    WebView webviewnews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_article);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ButterKnife.bind(this);
        getUrl();
    }
// getting data url
    public void getUrl()
    {
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle!=null)
        {
            String myData = (String) bundle.getSerializable("results");
            webviewnews.setWebViewClient(new WebViewClient());
            webviewnews.loadUrl(myData.toString());
        }
    }
// back to MainActivity
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}
