package paket.talerez.androidtest;

import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.runner.RunWith;

import androidx.test.espresso.web.webdriver.Locator;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import paket.talerez.androidtest.View.WebArticle;

import static androidx.test.espresso.web.sugar.Web.onWebView;
import static androidx.test.espresso.web.webdriver.DriverAtoms.findElement;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class webviewTest
{
    private static final String URL_CODE = "https://www.google.com/";
    @Rule
    public ActivityTestRule<WebArticle> webArticleActivityTestRule =
            new ActivityTestRule<WebArticle>(WebArticle.class);

public void webtest()
{
    //webview connect to url
    onWebView().withElement(findElement(Locator.ID, URL_CODE));
}

}
