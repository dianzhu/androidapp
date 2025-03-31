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

import edu.gatech.seclass.jobcompare6300.screens.Edit_Current_Job;

@RunWith(AndroidJUnit4.class)
public class Edit_Current_Job_Test {
    @Rule
    public ActivityScenarioRule<Edit_Current_Job> activityRule = new ActivityScenarioRule<>(Edit_Current_Job.class);

    @Test
    public void savebuttonwithcorrectdatatest() {
        onView(withId(R.id.title_input)).perform(replaceText("Software Engineer"));
        onView(withId(R.id.company_input)).perform(replaceText("IBM"));
        onView(withId(R.id.city_input)).perform(replaceText("San Francisco"));
        onView(withId(R.id.state_input)).perform(replaceText("CA"));
        onView(withId(R.id.cost_of_living_input)).perform(replaceText("171"));
        onView(withId(R.id.yearly_salary_input)).perform(replaceText("150000"));
        onView(withId(R.id.yearly_bonus_input)).perform(replaceText("4000"));
        onView(withId(R.id.retirement_input)).perform(replaceText("90"));
        onView(withId(R.id.restricted_stock_input)).perform(replaceText("20"));
        onView(withId(R.id.personalized_learning_and_development_input)).perform(replaceText("17000"));
        onView(withId(R.id.family_planning_assistance_input)).perform(replaceText("10"));

        onView(withId(R.id.save_button)).check(matches(isClickable()));

        onView(withId(R.id.save_button)).perform(click());

        onView(withText("Current job updated successfully!"));
        onView(withText("current job details are saved now"));

        onView(withId(R.id.mainmenu)).check(matches(isCompletelyDisplayed()));
    }

    @Test
    public void savebuttonwithincorrectdatatest() {
        onView(withId(R.id.title_input)).perform(replaceText(""));
        onView(withId(R.id.company_input)).perform(replaceText("IBM"));
        onView(withId(R.id.city_input)).perform(replaceText("San Francisco"));
        onView(withId(R.id.state_input)).perform(replaceText("CA"));
        onView(withId(R.id.cost_of_living_input)).perform(replaceText("171"));
        onView(withId(R.id.yearly_salary_input)).perform(replaceText("150000"));
        onView(withId(R.id.yearly_bonus_input)).perform(replaceText("4000"));
        onView(withId(R.id.retirement_input)).perform(replaceText("90"));
        onView(withId(R.id.restricted_stock_input)).perform(replaceText("20"));
        onView(withId(R.id.personalized_learning_and_development_input)).perform(replaceText("18000"));
        onView(withId(R.id.family_planning_assistance_input)).perform(replaceText("10"));

        onView(withId(R.id.save_button)).check(matches(isClickable()));

        onView(withId(R.id.save_button)).perform(click());

        onView(withId(R.id.title_input))
                .check(matches(hasErrorText("Please fill this value")));

    }

    @Test
    public void cancelbuttontest() {
        onView(withId(R.id.title_input)).perform(replaceText("Software Engineer"));
        onView(withId(R.id.company_input)).perform(replaceText("IBM"));
        onView(withId(R.id.city_input)).perform(replaceText("San Francisco"));
        onView(withId(R.id.state_input)).perform(replaceText("CA"));
        onView(withId(R.id.cost_of_living_input)).perform(replaceText("171"));
        onView(withId(R.id.yearly_salary_input)).perform(replaceText("150000"));
        onView(withId(R.id.yearly_bonus_input)).perform(replaceText("4000"));
        onView(withId(R.id.retirement_input)).perform(replaceText("90"));
        onView(withId(R.id.restricted_stock_input)).perform(replaceText("20"));
        onView(withId(R.id.personalized_learning_and_development_input)).perform(replaceText("17000"));
        onView(withId(R.id.family_planning_assistance_input)).perform(replaceText("10"));

        onView(withId(R.id.cancel_button)).check(matches(isClickable()));

        onView(withId(R.id.cancel_button)).perform(click());

        onView(withText("current job details are cancelled now"));

        onView(withId(R.id.mainmenu)).check(matches(isCompletelyDisplayed()));
    }

}
