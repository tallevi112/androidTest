package paket.talerez.androidtest.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import paket.talerez.androidtest.Adapter.NewsAdapter;
import paket.talerez.androidtest.Models.NewsRespons;
import paket.talerez.androidtest.R;

public class MainActivity extends AppCompatActivity implements MainViewInterface {

    @BindView(R.id.rvNews)
    RecyclerView rvNews;

    private String TAG = ".MainActivity";
    RecyclerView.Adapter adapter;
    MainPresenter mainPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


//setup presenter
    private void setupMVP() {
        mainPresenter = new MainPresenter(this);
    }

//recyclerview - set up for view
    private void setupViews() {
        rvNews.setLayoutManager(new LinearLayoutManager(this));
    }
// presenter connecting to get news to network for data
    private void getNewsList() {
        mainPresenter.getNews();

    }
// resume setup
    @Override
    protected void onResume() {
        super.onResume();
        ButterKnife.bind(this);

        setupMVP();
        getNewsList();
        setupViews();

    }
//toast
    @Override
    public void showToast(String str) {
        Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
    }
//setup adapter - getting data for adapter
    @Override
    public void displayNews(NewsRespons newsResponse) {

        if (newsResponse != null) {
            adapter = new NewsAdapter(newsResponse.getArticles(), MainActivity.this);
            rvNews.setAdapter(adapter);

        } else {
            Log.d(TAG, "News response null");
        }

    }
// Toast Network Error
    @Override
    public void displayError(String e) {
        showToast(e);
    }

}
