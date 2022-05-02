package com.example.reminderapp;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
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
public class UserStory7Tests {

    //Test for User Story 7: Scenario 1: Given the user is on the homepage when the add a reminder
    //button is tapped then load the add a reminder page.
    @Test
    public void goToAddReminder() {
        // Context of the app under test.
        ActivityScenario.launch(Homepage.class);
        onView(withId(R.id.toAddReminder)).perform(click());
        onView(withId(R.id.addReminderBanner)).check(matches(isDisplayed()));
    }

    //Test for User Story 7: Scenario 2: Given the user is on the add a reminder page when the
    // user changes his/her mind and wants to go back to the homepage and clicks back, then the
    // user should be brought back to the homepage.
    @Test
    public void returnToHomePage() {
        // Context of the app under test.
        ActivityScenario.launch(AddReminder.class);
        onView(withId(R.id.addReminderBack)).perform(click());
        onView(withId(R.id.homePageBanner)).check(matches(isDisplayed()));
    }

    //Test for User Story 7: Scenario 3: Given that the user clicks add reminder, when the input
    // field is empty, then do don't add any reminder and remain on the reminders activity.
    @Test
    public void invalidInputAddReminder() {
        // Context of the app under test.
        ActivityScenario.launch(AddReminder.class);
        onView(withId(R.id.setReminder)).perform(click());
        onView(withId(R.id.addReminderBanner)).check(matches(isDisplayed()));
    }
}