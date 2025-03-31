package edu.gatech.seclass.jobcompare6300;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.gatech.seclass.jobcompare6300.screens.Adjust_Comparison_Settings;

@RunWith(AndroidJUnit4.class)
public class Adjust_Settings_Test {
    @Rule
    public ActivityScenarioRule<Adjust_Comparison_Settings> activityRule = new ActivityScenarioRule<>(Adjust_Comparison_Settings.class);

    @Test
    public void save_correctdatatest() {
        onView(withId(R.id.yearly_salary_input)).perform(replaceText("2"));
        onView(withId(R.id.yearly_bonus_input)).perform(replaceText("2"));
        onView(withId(R.id.retirement_input)).perform(replaceText("2"));
        onView(withId(R.id.restricted_stock_input)).perform(replaceText("2"));
        onView(withId(R.id.personalized_learning_and_development_input)).perform(replaceText("2"));
        onView(withId(R.id.family_planning_assistance_input)).perform(replaceText("2"));

        onView(withId(R.id.save_button)).check(matches(isClickable()));

        onView(withId(R.id.save_button)).perform(click());

        onView(withText("Weights updated successfully!"));
        onView(withText("weights values are saved now"));

        onView(withId(R.id.mainmenu)).check(matches(isCompletelyDisplayed()));
    }

    @Test
    public void save_incorrectdatatest() {
        onView(withId(R.id.yearly_salary_input)).perform(replaceText("20"));
        onView(withId(R.id.yearly_bonus_input)).perform(replaceText("2"));
        onView(withId(R.id.retirement_input)).perform(replaceText("2"));
        onView(withId(R.id.restricted_stock_input)).perform(replaceText("2"));

        onView(withId(R.id.save_button)).check(matches(isClickable()));
        onView(withId(R.id.save_button)).perform(click());
        onView(withId(R.id.yearly_salary_input))
                .check(matches(hasErrorText("Invalid weight assigned")));

    }

    @Test
    public void cancelbuttontest() {
        onView(withId(R.id.yearly_salary_input)).perform(replaceText("2"));
        onView(withId(R.id.yearly_bonus_input)).perform(replaceText("2"));
        onView(withId(R.id.retirement_input)).perform(replaceText("2"));
        onView(withId(R.id.restricted_stock_input)).perform(replaceText("2"));
        onView(withId(R.id.personalized_learning_and_development_input)).perform(replaceText("2"));
        onView(withId(R.id.family_planning_assistance_input)).perform(replaceText("2"));
        onView(withId(R.id.cancel_button)).check(matches(isClickable()));
        onView(withId(R.id.cancel_button)).perform(click());
        onView(withText("weights values are cancelled now"));

        onView(withId(R.id.mainmenu)).check(matches(isCompletelyDisplayed()));
    }

}
