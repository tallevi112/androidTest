package paket.talerez.androidtest;


import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import paket.talerez.androidtest.View.MainActivity;
import paket.talerez.androidtest.View.WebArticle;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainTest {
    private static final int ITEM_BELOW = 1;
    private static final String News_TITLE = "News Code";

    @Rule
    public ActivityTestRule<MainActivity> mainActivityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void checkRecycler () {

        onView(withId(R.id.rvNews))
                .check(matches(hasDescendant(withText("Testing Recycler"))));

        //First, scroll to the position that needs to be matched and click on it.
        onView(ViewMatchers.withId(R.id.rvNews))
                .perform(RecyclerViewActions.actionOnItemAtPosition(ITEM_BELOW,click()));

        onView(withId(R.id.nwTitle)).check(matches(withText(News_TITLE)));

    }
    @Test
    protected Intent getActivityIntent() {

      // this is Intent to webartical activity
        Intent intent = new Intent(InstrumentationRegistry.getContext(),WebArticle.class);
        intent.putExtra("result","https://www.youtube.com/watch?v=pP63G1UFgHY");
        return intent;
    }



}
