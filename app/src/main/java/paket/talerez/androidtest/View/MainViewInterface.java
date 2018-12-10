package paket.talerez.androidtest.View;

import paket.talerez.androidtest.Models.NewsRespons;

public interface MainViewInterface
{
    // MainActivity interface (view)
    void showToast(String s);
    void displayNews(NewsRespons newsResponse);
    void displayError(String s);
}
