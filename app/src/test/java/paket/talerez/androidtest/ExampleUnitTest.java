package paket.talerez.androidtest;

import android.content.Context;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import paket.talerez.androidtest.Models.NewsRespons;
import paket.talerez.androidtest.View.MainPresenter;
import paket.talerez.androidtest.View.MainViewInterface;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    @Mock
    Context mMockContext;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void shouldGetApiKey() {
        when(mMockContext.getString(R.string.key_api))
                .thenReturn("2846af2c43784081bcf09e8e0ca10474");

        assertEquals("2846af2c43784081bcf09e8e0ca10474", mMockContext.getString(R.string.key_api));
    }


    @Test
    public void shouldCreatePresenterUsingInterface() {
        MainViewInterface mainViewInterface= new MainViewInterface() {
            @Override
            public void showToast(String s) {
                when(mMockContext.getString(Integer.parseInt(s.toString())))
                        .thenReturn("Error fetching News Data");
                assertEquals("Error fetching News Data", mMockContext.getString(Integer.parseInt(s)));
            }

            @Override
            public void displayNews(NewsRespons newsResponse) {
            }

            @Override
            public void displayError(String s) {
            }
        };
        MainPresenter mainPresenter = new MainPresenter(mainViewInterface);
        assertNotNull(mainPresenter);

    }
}