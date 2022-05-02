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
public class UserStory3Tests {

    //Test for User Story 3: Scenario 1: Given that the user is on the homepage, when the user
    // clicks on add a reminder, then direct the user to the add reminder page, where he/she can
    // add a date.
    @Test
    public void toReminderPage() {
        // Context of the app under test.
        ActivityScenario.launch(Homepage.class);
        onView(withId(R.id.toAddReminder)).perform(click());
        onView(withId(R.id.addReminderBanner)).check(matches(isDisplayed()));
    }

    //Test for User Story 3: Scenario 2: Given that the user is on the add a reminder activity, when
    // the user clicks the add date/time, then the user should encounter a clock to input a time.
    @Test
    public void clickInputField() {
        // Context of the app under test.
        ActivityScenario.launch(QuickNotes.class);
        onView(withId(R.id.date_time_input)).perform(click());
        onView(withId(R.id.date_time_input)).check(matches(isDisplayed()));
    }

    //Test for User Story 3: Scenario 3: Given that the user clicks add reminder, when the input
    // field is empty, then do don't add any reminder and remain on the reminders activity.
    @Test
    public void emptyInput() {
        // Context of the app under test.
        ActivityScenario.launch(AddReminder.class);
        onView(withId(R.id.setReminder)).perform(click());
        onView(withId(R.id.addReminderBanner)).check(matches(isDisplayed()));
    }
}