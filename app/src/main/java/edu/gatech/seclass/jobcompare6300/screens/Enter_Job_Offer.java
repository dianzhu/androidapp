package edu.gatech.seclass.jobcompare6300.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import edu.gatech.seclass.jobcompare6300.R;
import edu.gatech.seclass.jobcompare6300.objects.DatabaseHelper;
import edu.gatech.seclass.jobcompare6300.objects.JobOffer;

public class Enter_Job_Offer extends AppCompatActivity {

    EditText jobOfferTitle;
    EditText jobOfferCompany;
    EditText jobOfferCity;
    EditText jobOfferState;
    EditText jobOfferCostOfLiving;
    EditText jobOfferYearlySalary;
    EditText jobOfferYearlyBonus;
    EditText jobOfferRetirement;
    EditText jobOfferStock;
    EditText jobOfferLearning;
    EditText jobOfferFamilyPlanning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.enter_job_offer);
        jobOfferTitle = findViewById(R.id.title_input);
        jobOfferCompany = findViewById(R.id.company_input);
        jobOfferCity = findViewById(R.id.city_input);
        jobOfferState = findViewById(R.id.state_input);
        jobOfferCostOfLiving = findViewById(R.id.cost_of_living_input);
        jobOfferYearlySalary = findViewById(R.id.yearly_salary_input);
        jobOfferYearlyBonus = findViewById(R.id.yearly_bonus_input);
        jobOfferRetirement = findViewById(R.id.retirement_input);
        jobOfferStock = findViewById(R.id.restricted_stock_input);
        jobOfferLearning = findViewById(R.id.personalized_learning_and_development_input);
        jobOfferFamilyPlanning = findViewById(R.id.family_planning_assistance_input);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.joboffer), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void handleClick(View view) {
        if (view.getId() == R.id.save_button) {
            boolean error_flag = false;

            String input1 = jobOfferTitle.getText().toString();
            String input2 = jobOfferCompany.getText().toString();
            String input3 = jobOfferCity.getText().toString();
            String input4 = jobOfferState.getText().toString();
            String input5 = jobOfferCostOfLiving.getText().toString();
            int input5_n = 0;
            String input6 = jobOfferYearlySalary.getText().toString();
            double input6_n = 0;
            String input7 = jobOfferYearlyBonus.getText().toString();
            double input7_n = 0;
            String input8 = jobOfferRetirement.getText().toString();
            int input8_n = 0;
            String input9 = jobOfferStock.getText().toString();
            double input9_n = 0;
            String input10 = jobOfferLearning.getText().toString();
            double input10_n = 0;
            String input11 = jobOfferFamilyPlanning.getText().toString();
            double input11_n = 0;

            if (input1.isEmpty()) {
                jobOfferTitle.setError("Please fill this value");
                error_flag = true;
            }

            if (input2.isEmpty()) {
                jobOfferCompany.setError("Please fill this value");
                error_flag = true;
            }

            if (input3.isEmpty()) {
                jobOfferCity.setError("Please fill this value");
                error_flag = true;
            }

            if (input4.isEmpty()) {
                jobOfferState.setError("Please fill this value");
                error_flag = true;
            }

            if (input5.isEmpty()) {
                jobOfferCostOfLiving.setError("Please fill this value");
                error_flag = true;
            } else {
                input5_n = Integer.parseInt(input5);
            }

            if (input6.isEmpty()) {
                jobOfferYearlySalary.setError("Please fill this value");
                error_flag = true;
            } else {
                input6_n = Double.parseDouble(input6);
                if (input6_n < 0) {
                    jobOfferStock.setError("Yearly salary values must be positive");
                    error_flag = true;
                }
            }

            if (input7.isEmpty()) {
                jobOfferYearlyBonus.setError("Please fill this value");
                error_flag = true;
            } else {
                input7_n = Double.parseDouble(input7);
                if (input7_n < 0) {
                    jobOfferStock.setError("Yearly bonus values must be positive");
                    error_flag = true;
                }
            }

            if (input8.isEmpty()) {
                jobOfferRetirement.setError("Please fill this value");
                error_flag = true;
            } else {
                input8_n = Integer.parseInt(input8);
                if (input8_n > 100) {
                    jobOfferRetirement.setError("Retirement values rangers from 0 to 100");
                    error_flag = true;
                }
            }

            if (input9.isEmpty()) {
                jobOfferStock.setError("Please fill this value");
                error_flag = true;
            } else {
                input9_n = Double.parseDouble(input9);
                if (input9_n < 0) {
                    jobOfferStock.setError("Stock values must be positive");
                    error_flag = true;
                }
            }

            if (input10.isEmpty()) {
                jobOfferLearning.setError("Please fill this value");
                error_flag = true;
            } else {
                input10_n = Double.parseDouble(input10);
                if (input10_n < 0 || input10_n > 18000) {
                    jobOfferLearning.setError("Learning values ranges from 0 to 18000");
                    error_flag = true;
                }
            }

            if (input11.isEmpty()) {
                jobOfferFamilyPlanning.setError("Please fill this value");
                error_flag = true;
            } else {
                input11_n = Double.parseDouble(input11);
                if (input11_n < 0 || input11_n > input6_n * 0.12) {
                    jobOfferFamilyPlanning.setError("Family planning values ranges from 0 to 12% of yearly salary");
                    error_flag = true;
                }
            }

            if (!error_flag) {
                DatabaseHelper db = new DatabaseHelper(Enter_Job_Offer.this);
                JobOffer jobOffer = new JobOffer(input1, input2, input3, input4, input5_n, input6_n, input7_n, input8_n, input9_n, input10_n, input11_n);
                db.addJobOffer(jobOffer);
                Toast.makeText(Enter_Job_Offer.this, "job offer details are saved now", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Enter_Job_Offer.this, Enter_Job_Offer_Cont.class);
                startActivity(intent);
            }
        } else if (view.getId() == R.id.cancel_button) {
            Toast.makeText(Enter_Job_Offer.this, "job offer details are cancelled now", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Enter_Job_Offer.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
