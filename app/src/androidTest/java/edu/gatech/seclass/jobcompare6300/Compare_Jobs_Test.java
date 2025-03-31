package edu.gatech.seclass.jobcompare6300;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.CoreMatchers.not;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.gatech.seclass.jobcompare6300.screens.MainActivity;

@RunWith(AndroidJUnit4.class)
public class Compare_Jobs_Test {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void comparebuttonwithselecttwojobs(){

        onView(withId(R.id.enter_job_offer_button)).perform(click());

        onView(withId(R.id.title_input)).perform(replaceText("AI Engineer"));
        onView(withId(R.id.company_input)).perform(replaceText("Google"));
        onView(withId(R.id.city_input)).perform(replaceText("Mountain View"));
        onView(withId(R.id.state_input)).perform(replaceText("CA"));
        onView(withId(R.id.cost_of_living_input)).perform(replaceText("171"));
        onView(withId(R.id.yearly_salary_input)).perform(replaceText("200000"));
        onView(withId(R.id.yearly_bonus_input)).perform(replaceText("10000"));
        onView(withId(R.id.retirement_input)).perform(replaceText("100"));
        onView(withId(R.id.restricted_stock_input)).perform(replaceText("100"));
        onView(withId(R.id.personalized_learning_and_development_input)).perform(replaceText("18000"));
        onView(withId(R.id.family_planning_assistance_input)).perform(replaceText("50"));

        onView(withId(R.id.save_button)).perform(click());

        onView(withId(R.id.enter_another_job_offer_button)).perform(click());

        onView(withId(R.id.title_input)).perform(replaceText("Data Engineer"));
        onView(withId(R.id.company_input)).perform(replaceText("Meta"));
        onView(withId(R.id.city_input)).perform(replaceText("Menlo Park"));
        onView(withId(R.id.state_input)).perform(replaceText("CA"));
        onView(withId(R.id.cost_of_living_input)).perform(replaceText("170"));
        onView(withId(R.id.yearly_salary_input)).perform(replaceText("210000"));
        onView(withId(R.id.yearly_bonus_input)).perform(replaceText("9000"));
        onView(withId(R.id.retirement_input)).perform(replaceText("100"));
        onView(withId(R.id.restricted_stock_input)).perform(replaceText("100"));
        onView(withId(R.id.personalized_learning_and_development_input)).perform(replaceText("16000"));
        onView(withId(R.id.family_planning_assistance_input)).perform(replaceText("40"));

        onView(withId(R.id.save_button)).perform(click());

        onView(withId(R.id.return_main_menu_button)).perform(click());

        onView(withId(R.id.compare_jobs_button)).perform(click());

        onView(withId(R.id.layout1)).perform(click());

        onView(withId(R.id.layout2)).perform(click());

        onView(withId(R.id.compare_button)).check(matches(isClickable()));

        onView(withId(R.id.compare_button)).perform(click());

        onView(withId(R.id.comparejobscont)).check(matches(isCompletelyDisplayed()));

        onView(withId(R.id.title1)).check(matches(not(withText(""))));
        onView(withId(R.id.title2)).check(matches(not(withText(""))));
        onView(withId(R.id.company1)).check(matches(not(withText(""))));
        onView(withId(R.id.company2)).check(matches(not(withText(""))));
        onView(withId(R.id.city1)).check(matches(not(withText(""))));
        onView(withId(R.id.city2)).check(matches(not(withText(""))));
        onView(withId(R.id.state1)).check(matches(not(withText(""))));
        onView(withId(R.id.state2)).check(matches(not(withText(""))));
        onView(withId(R.id.adjusted_yearly_salary1)).check(matches(not(withText(""))));
        onView(withId(R.id.adjusted_yearly_salary2)).check(matches(not(withText(""))));
        onView(withId(R.id.adjusted_yearly_bonus1)).check(matches(not(withText(""))));
        onView(withId(R.id.adjusted_yearly_bonus2)).check(matches(not(withText(""))));
        onView(withId(R.id.retirement1)).check(matches(not(withText(""))));
        onView(withId(R.id.retirement2)).check(matches(not(withText(""))));
        onView(withId(R.id.restricted_stock1)).check(matches(not(withText(""))));
        onView(withId(R.id.restricted_stock2)).check(matches(not(withText(""))));
        onView(withId(R.id.personalized_learning_and_development1)).check(matches(not(withText(""))));
        onView(withId(R.id.personalized_learning_and_development2)).check(matches(not(withText(""))));
        onView(withId(R.id.family_planning_assistance1)).check(matches(not(withText(""))));
        onView(withId(R.id.family_planning_assistance2)).check(matches(not(withText(""))));

    }

    @Test
    public void comparebuttondisabledwithoutselecttwojobs(){
        onView(withId(R.id.enter_job_offer_button)).perform(click());

        onView(withId(R.id.title_input)).perform(replaceText("AI Engineer"));
        onView(withId(R.id.company_input)).perform(replaceText("Google"));
        onView(withId(R.id.city_input)).perform(replaceText("Mountain View"));
        onView(withId(R.id.state_input)).perform(replaceText("CA"));
        onView(withId(R.id.cost_of_living_input)).perform(replaceText("171"));
        onView(withId(R.id.yearly_salary_input)).perform(replaceText("200000"));
        onView(withId(R.id.yearly_bonus_input)).perform(replaceText("10000"));
        onView(withId(R.id.retirement_input)).perform(replaceText("100"));
        onView(withId(R.id.restricted_stock_input)).perform(replaceText("100"));
        onView(withId(R.id.personalized_learning_and_development_input)).perform(replaceText("18000"));
        onView(withId(R.id.family_planning_assistance_input)).perform(replaceText("50"));

        onView(withId(R.id.save_button)).perform(click());

        onView(withId(R.id.enter_another_job_offer_button)).perform(click());

        onView(withId(R.id.title_input)).perform(replaceText("Data Engineer"));
        onView(withId(R.id.company_input)).perform(replaceText("Meta"));
        onView(withId(R.id.city_input)).perform(replaceText("Menlo Park"));
        onView(withId(R.id.state_input)).perform(replaceText("CA"));
        onView(withId(R.id.cost_of_living_input)).perform(replaceText("170"));
        onView(withId(R.id.yearly_salary_input)).perform(replaceText("210000"));
        onView(withId(R.id.yearly_bonus_input)).perform(replaceText("9000"));
        onView(withId(R.id.retirement_input)).perform(replaceText("100"));
        onView(withId(R.id.restricted_stock_input)).perform(replaceText("100"));
        onView(withId(R.id.personalized_learning_and_development_input)).perform(replaceText("16000"));
        onView(withId(R.id.family_planning_assistance_input)).perform(replaceText("40"));

        onView(withId(R.id.save_button)).perform(click());

        onView(withId(R.id.return_main_menu_button)).perform(click());

        onView(withId(R.id.compare_jobs_button)).perform(click());

        onView(withId(R.id.compare_button)).perform(click());

        onView(withText("Please select exactly two jobs."));

    }

    @Test
    public void comparebuttondisabledwithselectonejob(){
        onView(withId(R.id.enter_job_offer_button)).perform(click());

        onView(withId(R.id.title_input)).perform(replaceText("AI Engineer"));
        onView(withId(R.id.company_input)).perform(replaceText("Google"));
        onView(withId(R.id.city_input)).perform(replaceText("Mountain View"));
        onView(withId(R.id.state_input)).perform(replaceText("CA"));
        onView(withId(R.id.cost_of_living_input)).perform(replaceText("171"));
        onView(withId(R.id.yearly_salary_input)).perform(replaceText("200000"));
        onView(withId(R.id.yearly_bonus_input)).perform(replaceText("10000"));
        onView(withId(R.id.retirement_input)).perform(replaceText("100"));
        onView(withId(R.id.restricted_stock_input)).perform(replaceText("100"));
        onView(withId(R.id.personalized_learning_and_development_input)).perform(replaceText("18000"));
        onView(withId(R.id.family_planning_assistance_input)).perform(replaceText("50"));

        onView(withId(R.id.save_button)).perform(click());

        onView(withId(R.id.enter_another_job_offer_button)).perform(click());

        onView(withId(R.id.title_input)).perform(replaceText("Data Engineer"));
        onView(withId(R.id.company_input)).perform(replaceText("Meta"));
        onView(withId(R.id.city_input)).perform(replaceText("Menlo Park"));
        onView(withId(R.id.state_input)).perform(replaceText("CA"));
        onView(withId(R.id.cost_of_living_input)).perform(replaceText("170"));
        onView(withId(R.id.yearly_salary_input)).perform(replaceText("210000"));
        onView(withId(R.id.yearly_bonus_input)).perform(replaceText("9000"));
        onView(withId(R.id.retirement_input)).perform(replaceText("100"));
        onView(withId(R.id.restricted_stock_input)).perform(replaceText("100"));
        onView(withId(R.id.personalized_learning_and_development_input)).perform(replaceText("16000"));
        onView(withId(R.id.family_planning_assistance_input)).perform(replaceText("40"));

        onView(withId(R.id.save_button)).perform(click());

        onView(withId(R.id.return_main_menu_button)).perform(click());

        onView(withId(R.id.compare_jobs_button)).perform(click());

        onView(withId(R.id.layout1)).perform(click());

        onView(withId(R.id.compare_button)).perform(click());

        onView(withText("Please select exactly two jobs."));

    }

    @Test
    public void firstreturnmainmenubottontest(){
        onView(withId(R.id.edit_current_job_button)).perform(click());

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

        onView(withId(R.id.save_button)).perform(click());

        onView(withId(R.id.enter_job_offer_button)).perform(click());

        onView(withId(R.id.title_input)).perform(replaceText("AI Engineer"));
        onView(withId(R.id.company_input)).perform(replaceText("Google"));
        onView(withId(R.id.city_input)).perform(replaceText("Mountain View"));
        onView(withId(R.id.state_input)).perform(replaceText("CA"));
        onView(withId(R.id.cost_of_living_input)).perform(replaceText("171"));
        onView(withId(R.id.yearly_salary_input)).perform(replaceText("200000"));
        onView(withId(R.id.yearly_bonus_input)).perform(replaceText("10000"));
        onView(withId(R.id.retirement_input)).perform(replaceText("100"));
        onView(withId(R.id.restricted_stock_input)).perform(replaceText("100"));
        onView(withId(R.id.personalized_learning_and_development_input)).perform(replaceText("18000"));
        onView(withId(R.id.family_planning_assistance_input)).perform(replaceText("50"));

        onView(withId(R.id.save_button)).perform(click());

        onView(withId(R.id.return_main_menu_button)).perform(click());

        onView(withId(R.id.compare_jobs_button)).perform(click());

        onView(withId(R.id.return_to_main_menu_button)).check(matches(isClickable()));

        onView(withId(R.id.return_to_main_menu_button)).perform(click());

        onView(withId(R.id.mainmenu)).check(matches(isCompletelyDisplayed()));
    }

    @Test
    public void anothercompareotherjobsbutton(){

        onView(withId(R.id.edit_current_job_button)).perform(click());

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

        onView(withId(R.id.save_button)).perform(click());

        onView(withId(R.id.enter_job_offer_button)).perform(click());

        onView(withId(R.id.title_input)).perform(replaceText("AI Engineer"));
        onView(withId(R.id.company_input)).perform(replaceText("Google"));
        onView(withId(R.id.city_input)).perform(replaceText("Mountain View"));
        onView(withId(R.id.state_input)).perform(replaceText("CA"));
        onView(withId(R.id.cost_of_living_input)).perform(replaceText("171"));
        onView(withId(R.id.yearly_salary_input)).perform(replaceText("200000"));
        onView(withId(R.id.yearly_bonus_input)).perform(replaceText("10000"));
        onView(withId(R.id.retirement_input)).perform(replaceText("100"));
        onView(withId(R.id.restricted_stock_input)).perform(replaceText("100"));
        onView(withId(R.id.personalized_learning_and_development_input)).perform(replaceText("18000"));
        onView(withId(R.id.family_planning_assistance_input)).perform(replaceText("50"));

        onView(withId(R.id.save_button)).perform(click());

        onView(withId(R.id.return_main_menu_button)).perform(click());

        onView(withId(R.id.compare_jobs_button)).perform(click());

        onView(withId(R.id.layout1)).perform(click());

        onView(withId(R.id.layout2)).perform(click());

        onView(withId(R.id.compare_button)).perform(click());

        onView(withId(R.id.compare_other_jobs_button)).check(matches(isClickable()));

        onView(withId(R.id.compare_other_jobs_button)).perform(click());

        onView(withId(R.id.comparejobs)).check(matches(isCompletelyDisplayed()));
    }

    @Test
    public void anotherreturnmainmenubutton(){
        onView(withId(R.id.edit_current_job_button)).perform(click());

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

        onView(withId(R.id.save_button)).perform(click());

        onView(withId(R.id.enter_job_offer_button)).perform(click());

        onView(withId(R.id.title_input)).perform(replaceText("AI Engineer"));
        onView(withId(R.id.company_input)).perform(replaceText("Google"));
        onView(withId(R.id.city_input)).perform(replaceText("Mountain View"));
        onView(withId(R.id.state_input)).perform(replaceText("CA"));
        onView(withId(R.id.cost_of_living_input)).perform(replaceText("171"));
        onView(withId(R.id.yearly_salary_input)).perform(replaceText("200000"));
        onView(withId(R.id.yearly_bonus_input)).perform(replaceText("10000"));
        onView(withId(R.id.retirement_input)).perform(replaceText("100"));
        onView(withId(R.id.restricted_stock_input)).perform(replaceText("100"));
        onView(withId(R.id.personalized_learning_and_development_input)).perform(replaceText("18000"));
        onView(withId(R.id.family_planning_assistance_input)).perform(replaceText("50"));

        onView(withId(R.id.save_button)).perform(click());

        onView(withId(R.id.return_main_menu_button)).perform(click());

        onView(withId(R.id.compare_jobs_button)).perform(click());

        onView(withId(R.id.layout1)).perform(click());

        onView(withId(R.id.layout2)).perform(click());

        onView(withId(R.id.compare_button)).perform(click());

        onView(withId(R.id.return_main_menu_button)).check(matches(isClickable()));

        onView(withId(R.id.return_main_menu_button)).perform(click());

        onView(withId(R.id.mainmenu)).check(matches(isCompletelyDisplayed()));
    }
}

