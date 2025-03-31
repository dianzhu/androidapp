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

import edu.gatech.seclass.jobcompare6300.screens.Enter_Job_Offer;
import edu.gatech.seclass.jobcompare6300.objects.CurrentJob;

@RunWith(AndroidJUnit4.class)
public class Enter_Job_Offer_Test {
    @Rule
    public ActivityScenarioRule<Enter_Job_Offer> activityRule = new ActivityScenarioRule<>(Enter_Job_Offer.class);

    @Test
    public void savebuttonwithcorrectdatatest() {
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

        onView(withId(R.id.save_button)).check(matches(isClickable()));

        onView(withId(R.id.save_button)).perform(click());
        onView(withText("Job offer added successfully!"));
        onView(withText("job offer details are saved now"));

        onView(withId(R.id.enterjoboffercont)).check(matches(isCompletelyDisplayed()));
    }

    @Test
    public void savebuttonwithincorrectdatatest() {
        onView(withId(R.id.title_input)).perform(replaceText("AI Engineer"));
        onView(withId(R.id.company_input)).perform(replaceText("Google"));
        onView(withId(R.id.city_input)).perform(replaceText("Mountain View"));
        onView(withId(R.id.state_input)).perform(replaceText("CA"));
        onView(withId(R.id.cost_of_living_input)).perform(replaceText("171"));
        onView(withId(R.id.yearly_salary_input)).perform(replaceText("200000"));
        onView(withId(R.id.yearly_bonus_input)).perform(replaceText("10000"));
        onView(withId(R.id.retirement_input)).perform(replaceText("101"));
        onView(withId(R.id.restricted_stock_input)).perform(replaceText("100"));
        onView(withId(R.id.personalized_learning_and_development_input)).perform(replaceText("18000"));
        onView(withId(R.id.family_planning_assistance_input)).perform(replaceText("50"));

        onView(withId(R.id.save_button)).check(matches(isClickable()));

        onView(withId(R.id.save_button)).perform(click());

        onView(withId(R.id.retirement_input))
                .check(matches(hasErrorText("Retirement values rangers from 0 to 100")));

    }

    @Test
    public void cancelbuttontest() {
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

        onView(withId(R.id.cancel_button)).check(matches(isClickable()));

        onView(withId(R.id.cancel_button)).perform(click());

        onView(withText("job offer details are cancelled now"));

        onView(withId(R.id.mainmenu)).check(matches(isCompletelyDisplayed()));
    }

    @Test
    public void enteranotherjobofferbuttontest(){
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

        onView(withId(R.id.enter_another_job_offer_button)).check(matches(isClickable()));

        onView(withId(R.id.enter_another_job_offer_button)).perform(click());

        onView(withId(R.id.joboffer)).check(matches(isCompletelyDisplayed()));

        onView(withId(R.id.title_input)).check(matches(withText("")));
        onView(withId(R.id.company_input)).check(matches(withText("")));
        onView(withId(R.id.city_input)).check(matches(withText("")));
        onView(withId(R.id.state_input)).check(matches(withText("")));
        onView(withId(R.id.cost_of_living_input)).check(matches(withText("")));
        onView(withId(R.id.yearly_salary_input)).check(matches(withText("")));
        onView(withId(R.id.yearly_bonus_input)).check(matches(withText("")));
        onView(withId(R.id.retirement_input)).check(matches(withText("")));
        onView(withId(R.id.restricted_stock_input)).check(matches(withText("")));
        onView(withId(R.id.personalized_learning_and_development_input)).check(matches(withText("")));
        onView(withId(R.id.family_planning_assistance_input)).check(matches(withText("")));

    }

    @Test
    public void returnmainmenubuttontest(){
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

        onView(withId(R.id.return_main_menu_button)).check(matches(isClickable()));

        onView(withId(R.id.return_main_menu_button)).perform(click());

        onView(withId(R.id.mainmenu)).check(matches(isCompletelyDisplayed()));
    }

    @Test
    public void firstjoboffercomparewithcurrentjobbuttontest(){
        onView(withId(R.id.cancel_button)).perform(click());

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

        onView(withId(R.id.compare_with_current_job_button)).check(matches(isClickable()));

        onView(withId(R.id.compare_with_current_job_button)).perform(click());

        onView(withId(R.id.comparejobscont)).check(matches(isCompletelyDisplayed()));

        onView(withId(R.id.title1)).check(matches(withText("Software Engineer")));
        onView(withId(R.id.title2)).check(matches(withText("AI Engineer")));
        onView(withId(R.id.company1)).check(matches(withText("IBM")));
        onView(withId(R.id.company2)).check(matches(withText("Google")));
        onView(withId(R.id.city1)).check(matches(withText("San Francisco")));
        onView(withId(R.id.city2)).check(matches(withText("Mountain View")));
        onView(withId(R.id.state1)).check(matches(withText("CA")));
        onView(withId(R.id.state2)).check(matches(withText("CA")));
        Double getAYS1 = 150000.0 * 100 / 171;
        Double getAYS2 = 200000.0 * 100 / 171;
        onView(withId(R.id.adjusted_yearly_salary1)).check(matches(withText(String.valueOf(getAYS1))));
        onView(withId(R.id.adjusted_yearly_salary2)).check(matches(withText(String.valueOf(getAYS2))));
        Double getAYB1 = 4000.0 * 100 / 171;
        Double getAYB2 = 10000.0 * 100 / 171;
        onView(withId(R.id.adjusted_yearly_bonus1)).check(matches(withText(String.valueOf(getAYB1))));
        onView(withId(R.id.adjusted_yearly_bonus2)).check(matches(withText(String.valueOf(getAYB2))));
        onView(withId(R.id.retirement1)).check(matches(withText("90")));
        onView(withId(R.id.retirement2)).check(matches(withText("100")));
        onView(withId(R.id.restricted_stock1)).check(matches(withText("20.0")));
        onView(withId(R.id.restricted_stock2)).check(matches(withText("100.0")));
        onView(withId(R.id.personalized_learning_and_development1)).check(matches(withText("17000.0")));
        onView(withId(R.id.personalized_learning_and_development2)).check(matches(withText("18000.0")));
        onView(withId(R.id.family_planning_assistance1)).check(matches(withText("10.0")));
        onView(withId(R.id.family_planning_assistance2)).check(matches(withText("50.0")));

    }

    @Test
    public void anotherjoboffercomparewithcurrentjobbuttontest(){
        onView(withId(R.id.cancel_button)).perform(click());

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

        onView(withId(R.id.compare_with_current_job_button)).check(matches(isClickable()));

        onView(withId(R.id.compare_with_current_job_button)).perform(click());

        onView(withId(R.id.comparejobscont)).check(matches(isCompletelyDisplayed()));

        onView(withId(R.id.title1)).check(matches(withText("Software Engineer")));
        onView(withId(R.id.title2)).check(matches(withText("Data Engineer")));
        onView(withId(R.id.company1)).check(matches(withText("IBM")));
        onView(withId(R.id.company2)).check(matches(withText("Meta")));
        onView(withId(R.id.city1)).check(matches(withText("San Francisco")));
        onView(withId(R.id.city2)).check(matches(withText("Menlo Park")));
        onView(withId(R.id.state1)).check(matches(withText("CA")));
        onView(withId(R.id.state2)).check(matches(withText("CA")));
        Double getAYS1 = 150000.0 * 100 / 171;
        Double getAYS2 = 210000.0 * 100 / 170;
        onView(withId(R.id.adjusted_yearly_salary1)).check(matches(withText(String.valueOf(getAYS1))));
        onView(withId(R.id.adjusted_yearly_salary2)).check(matches(withText(String.valueOf(getAYS2))));
        Double getAYB1 = 4000.0 * 100 / 171;
        Double getAYB2 = 9000.0 * 100 / 170;
        onView(withId(R.id.adjusted_yearly_bonus1)).check(matches(withText(String.valueOf(getAYB1))));
        onView(withId(R.id.adjusted_yearly_bonus2)).check(matches(withText(String.valueOf(getAYB2))));
        onView(withId(R.id.retirement1)).check(matches(withText("90")));
        onView(withId(R.id.retirement2)).check(matches(withText("100")));
        onView(withId(R.id.restricted_stock1)).check(matches(withText("20.0")));
        onView(withId(R.id.restricted_stock2)).check(matches(withText("100.0")));
        onView(withId(R.id.personalized_learning_and_development1)).check(matches(withText("17000.0")));
        onView(withId(R.id.personalized_learning_and_development2)).check(matches(withText("16000.0")));
        onView(withId(R.id.family_planning_assistance1)).check(matches(withText("10.0")));
        onView(withId(R.id.family_planning_assistance2)).check(matches(withText("40.0")));
    }

}


