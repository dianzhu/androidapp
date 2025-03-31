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
import edu.gatech.seclass.jobcompare6300.objects.CurrentJob;
import edu.gatech.seclass.jobcompare6300.objects.DatabaseHelper;

public class Edit_Current_Job extends AppCompatActivity{
    private EditText currentJobTitle;
    private EditText currentJobCompany;
    private EditText currentJobCity;
    private EditText currentJobState;
    private EditText currentJobCostOfLiving;
    private EditText currentJobYearlySalary;
    private EditText currentJobYearlyBonus;
    private EditText currentJobRetirement;
    private EditText currentJobStock;
    private EditText currentJobLearning;
    private EditText currentJobFamilyPlanning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.edit_current_job);
        currentJobTitle = findViewById(R.id.title_input);
        currentJobCompany = findViewById(R.id.company_input);
        currentJobCity = findViewById(R.id.city_input);
        currentJobState = findViewById(R.id.state_input);
        currentJobCostOfLiving = findViewById(R.id.cost_of_living_input);
        currentJobYearlySalary = findViewById(R.id.yearly_salary_input);
        currentJobYearlyBonus = findViewById(R.id.yearly_bonus_input);
        currentJobRetirement = findViewById(R.id.retirement_input);
        currentJobStock = findViewById(R.id.restricted_stock_input);
        currentJobLearning = findViewById(R.id.personalized_learning_and_development_input);
        currentJobFamilyPlanning = findViewById(R.id.family_planning_assistance_input);
        DatabaseHelper db = new DatabaseHelper(Edit_Current_Job.this);
        CurrentJob currentJob = db.readCurrentJob();
        if (currentJob != null) {
            currentJobTitle.setText(currentJob.getTitle());
            currentJobCompany.setText(currentJob.getCompany());
            currentJobCity.setText(currentJob.getCity());
            currentJobState.setText(currentJob.getState());
            currentJobCostOfLiving.setText(String.valueOf(currentJob.getCostOfLiving()));
            currentJobYearlySalary.setText(String.valueOf(currentJob.getYearlySalary()));
            currentJobYearlyBonus.setText(String.valueOf(currentJob.getYearlyBonus()));
            currentJobRetirement.setText(String.valueOf(currentJob.getRetirement()));
            currentJobStock.setText(String.valueOf(currentJob.getRestrictedStock()));
            currentJobLearning.setText(String.valueOf(currentJob.getPersonalLearningAndDevelopment()));
            currentJobFamilyPlanning.setText(String.valueOf(currentJob.getFamilyPlanningAssistance()));
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.currentjob), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void handleClick(View view) {
        if (view.getId() == R.id.save_button) {
            boolean error_flag = false;

            String input1 = currentJobTitle.getText().toString();
            String input2 = currentJobCompany.getText().toString();
            String input3 = currentJobCity.getText().toString();
            String input4 = currentJobState.getText().toString();
            String input5 = currentJobCostOfLiving.getText().toString();
            int input5_n = 0;
            String input6 = currentJobYearlySalary.getText().toString();
            double input6_n = 0;
            String input7 = currentJobYearlyBonus.getText().toString();
            double input7_n = 0;
            String input8 = currentJobRetirement.getText().toString();
            int input8_n = 0;
            String input9 = currentJobStock.getText().toString();
            double input9_n = 0;
            String input10 = currentJobLearning.getText().toString();
            double input10_n = 0;
            String input11 = currentJobFamilyPlanning.getText().toString();
            double input11_n = 0;

            if (input1.isEmpty()) {
                currentJobTitle.setError("Please fill this value");
                error_flag = true;
            }

            if (input2.isEmpty()) {
                currentJobCompany.setError("Please fill this value");
                error_flag = true;
            }

            if (input3.isEmpty()) {
                currentJobCity.setError("Please fill this value");
                error_flag = true;
            }

            if (input4.isEmpty()) {
                currentJobState.setError("Please fill this value");
                error_flag = true;
            }

            if (input5.isEmpty()) {
                currentJobCostOfLiving.setError("Please fill this value");
                error_flag = true;
            } else {
                input5_n = Integer.parseInt(input5);
            }

            if (input6.isEmpty()) {
                currentJobYearlySalary.setError("Please fill this value");
                error_flag = true;
            } else {
                input6_n = Double.parseDouble(input6);
                if (input6_n < 0) {
                    currentJobStock.setError("Yearly salary values must be positive");
                    error_flag = true;
                }
            }

            if (input7.isEmpty()) {
                currentJobYearlyBonus.setError("Please fill this value");
                error_flag = true;
            } else {
                input7_n = Double.parseDouble(input7);
                if (input7_n < 0) {
                    currentJobStock.setError("Yearly bonus values must be positive");
                    error_flag = true;
                }
            }

            if (input8.isEmpty()) {
                currentJobRetirement.setError("Please fill this value");
                error_flag = true;
            } else {
                input8_n = Integer.parseInt(input8);
                if (input8_n > 100) {
                    currentJobRetirement.setError("Retirement values rangers from 0 to 100");
                    error_flag = true;
                }
            }

            if (input9.isEmpty()) {
                currentJobStock.setError("Please fill this value");
                error_flag = true;
            } else {
                input9_n = Double.parseDouble(input9);
                if (input9_n < 0) {
                    currentJobStock.setError("Stock values must be positive");
                    error_flag = true;
                }
            }

            if (input10.isEmpty()) {
                currentJobLearning.setError("Please fill this value");
                error_flag = true;
            } else {
                input10_n = Double.parseDouble(input10);
                if (input10_n < 0 || input10_n > 18000) {
                    currentJobLearning.setError("Learning values ranges from 0 to 18000");
                    error_flag = true;
                }
            }

            if (input11.isEmpty()) {
                currentJobFamilyPlanning.setError("Please fill this value");
                error_flag = true;
            } else {
                input11_n = Double.parseDouble(input11);
                if (input11_n < 0 || input11_n > input6_n * 0.12) {
                    currentJobFamilyPlanning.setError("Family planning values ranges from 0 to 12% of yearly salary");
                    error_flag = true;
                }
            }

            if (!error_flag) {
                DatabaseHelper db = new DatabaseHelper(Edit_Current_Job.this);
                CurrentJob currentJob = new CurrentJob(input1, input2, input3, input4, input5_n, input6_n, input7_n, input8_n, input9_n, input10_n, input11_n);
                db.updateCurrentJob(currentJob);

                Toast.makeText(Edit_Current_Job.this, "current job details are saved now", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Edit_Current_Job.this, MainActivity.class);
                startActivity(intent);
            }
        } else if (view.getId() == R.id.cancel_button) {
            Toast.makeText(Edit_Current_Job.this, "current job details are cancelled now", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Edit_Current_Job.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
