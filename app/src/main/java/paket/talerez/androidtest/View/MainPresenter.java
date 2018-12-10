package paket.talerez.androidtest.View;

import android.support.annotation.NonNull;
import android.util.Log;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import paket.talerez.androidtest.Models.NewsRespons;
import paket.talerez.androidtest.Network.NetworkClient;
import paket.talerez.androidtest.Network.NewtworkInterface;

public class MainPresenter implements MainPresenterInterface {

    MainViewInterface mvi;
    private String TAG = "MainPresenter";
// constructor getting Main interface
    public MainPresenter(MainViewInterface mvi) {
        this.mvi = mvi;
    }
// calling data -- sets Observable
    @Override
    public void getNews() {
        getObservable().subscribeWith(getObserver());
    }


// Observable- connecting NetworkClient -- with query +apikey + parameter
    public Observable<NewsRespons> getObservable() {
        return NetworkClient.getRetrofit().create(NewtworkInterface.class)
                .getNews("us", "2846af2c43784081bcf09e8e0ca10474")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
//Observable Response for Networking
    public DisposableObserver<NewsRespons> getObserver() {
        return new DisposableObserver<NewsRespons>() {

            @Override //Succeeded
            public void onNext(@android.support.annotation.NonNull NewsRespons newsResponse) {
                Log.d(TAG, "OnNext" + newsResponse.getTotalResults());
                mvi.displayNews(newsResponse);
            }

            @Override //failed
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "Error" + e);
                e.printStackTrace();
                mvi.displayError("Error fetching News Data");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Completed");
            }
        };
    }
}
