package com.example.reminderapp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class UserStory1Tests {

    //Test for User Story 1:Scenario 1: Given that the user is on homepage, when the user clicks on
    // the Goto quicknotes button, then the quicknotes screen should show up.
    @Test
    public void goToQuickNotes() {
        // Context of the app under test.
        ActivityScenario activityScenario = ActivityScenario.launch(Homepage.class);
        onView(withId(R.id.toQuickNotes)).perform(click());
        onView(withId(R.id.quickNotesBanner)).check(matches(isDisplayed()));
    }

    //Test for User Story 1: Scenario 2: Given that the user is on the add quick notes activity,
    // when the user wants to add a quick note, then click the add button for the quick notes adding
    // activity to open.
    @Test
    public void openAddQNActivity() {
        // Context of the app under test.
        ActivityScenario activityScenario = ActivityScenario.launch(QuickNotes.class);
        onView(withId(R.id.addButton)).perform(click());
        onView(withId(R.id.addQN)).check(matches(isDisplayed()));
    }

    //Test for User Story 1: Scenario 3: Given that the user is on the quick notes activity, when
    // the user no longer wants to view or add quick notes, then the user shall click back to return
    // to the homepage.
    @Test
    public void returnToHomepage() {
        // Context of the app under test.
        ActivityScenario activityScenario = ActivityScenario.launch(QuickNotes.class);
        onView(withId(R.id.QNBack)).perform(click());
        onView(withId(R.id.homePageBanner)).check(matches(isDisplayed()));
    }
}