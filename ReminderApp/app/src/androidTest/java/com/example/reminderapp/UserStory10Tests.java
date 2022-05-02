package com.example.reminderapp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

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
public class UserStory10Tests {

    //Test for User Story 10: Scenario 1: Given it is the first time the user logs in when the user
    // clicks the submit button on the passcode page then unlock the phone because there is no
    // passcode yet.
    @Test
    public void goToHPNoPass() {
        // Context of the app under test.
        ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.submitB)).perform(click());
        onView(withId(R.id.homePageBanner)).check(matches(isDisplayed()));
    }

    //Test for User Story 10: Scenario 2: Given the user is on the homepage when the user clicks the
    // settings button then load the settings page which will contain a setting to change the
    // passcode.
    @Test
    public void goToChangePasscode() {
        // Context of the app under test.
        ActivityScenario.launch(Homepage.class);
        onView(withId(R.id.settings)).perform(click());
        onView(withId(R.id.SettingsText)).check(matches(isDisplayed()));
    }

    //Test for User Story 10: Scenario 3: Given the passcode page is open, when the user enters the
    // new passcode and taps on the submit button, then the user will be redirected to the passcode
    // page to enter the new passcode.
    @Test
    public void afterPasscodeChangeGotoLockScreen() {
        // Context of the app under test.
        ActivityScenario.launch(ChangeCode.class);
        onView(withId(R.id.c2)).perform(click());
        onView(withId(R.id.c0)).perform(click());
        onView(withId(R.id.submitB2)).perform(click());
        onView(withId(R.id.submitB)).check(matches(isDisplayed()));
    }
}