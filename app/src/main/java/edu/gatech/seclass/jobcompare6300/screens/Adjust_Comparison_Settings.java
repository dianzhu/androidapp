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
import edu.gatech.seclass.jobcompare6300.objects.ComparisonSettings;
import edu.gatech.seclass.jobcompare6300.objects.DatabaseHelper;

public class Adjust_Comparison_Settings extends AppCompatActivity{

    private EditText salary_wt;
    private EditText bonus_wt;
    private EditText retire_wt;
    private EditText stock_wt;
    private EditText learning_wt;
    private EditText planning_wt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.adjust_comparison_settings);
        DatabaseHelper db = new DatabaseHelper(Adjust_Comparison_Settings.this);
        ComparisonSettings weights = db.readWeights();
        salary_wt = findViewById(R.id.yearly_salary_input);
        salary_wt.setText(String.valueOf(weights.getYearlySalaryWeight()));
        bonus_wt = findViewById(R.id.yearly_bonus_input);
        bonus_wt.setText(String.valueOf(weights.getYearlyBonusWeight()));
        retire_wt = findViewById(R.id.retirement_input);
        retire_wt.setText(String.valueOf(weights.getRetirementWeight()));
        stock_wt = findViewById(R.id.restricted_stock_input);
        stock_wt.setText(String.valueOf(weights.getRestrictedStockWeight()));
        learning_wt = findViewById(R.id.personalized_learning_and_development_input);
        learning_wt.setText(String.valueOf(weights.getPersonalLearningAndDevelopmentWeight()));
        planning_wt = findViewById(R.id.family_planning_assistance_input);
        planning_wt.setText(String.valueOf(weights.getFamilyPlanningAssistanceWeight()));
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.adjustcomparisonsettings), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void handleClick(View view) {
        if (view.getId() == R.id.save_button) {
            boolean error_flag = false;

            String input1 = salary_wt.getText().toString();
            int input1_n = 0;
            String input2 = bonus_wt.getText().toString();
            int input2_n = 0;
            String input3 = retire_wt.getText().toString();
            int input3_n = 0;
            String input4 = stock_wt.getText().toString();
            int input4_n = 0;
            String input5 = learning_wt.getText().toString();
            int input5_n = 0;
            String input6 = planning_wt.getText().toString();
            int input6_n = 0;

            if (input1.isEmpty() && input2.isEmpty() && input3.isEmpty() && input4.isEmpty() && input5.isEmpty() && input6.isEmpty()) {
                input1_n = 1;
                input2_n = 1;
                input3_n = 1;
                input4_n = 1;
                input5_n = 1;
                input6_n = 1;
            } else {
                if (input1.isEmpty()) {
                    salary_wt.setError("Please fill this value");
                    error_flag = true;
                } else {
                    input1_n = Integer.parseInt(input1);
                    if (input1_n > 9) {
                        salary_wt.setError("Invalid weight assigned");
                        error_flag = true;
                    }
                }

                if (input2.isEmpty()) {
                    bonus_wt.setError("Please fill this value");
                    error_flag = true;
                } else {
                    input2_n = Integer.parseInt(input2);
                    if (input2_n > 9) {
                        bonus_wt.setError("Invalid weight assigned");
                        error_flag = true;
                    }
                }

                if (input3.isEmpty()) {
                    retire_wt.setError("Please fill this value");
                    error_flag = true;
                } else {
                    input3_n = Integer.parseInt(input3);
                    if (input3_n > 9) {
                        retire_wt.setError("Invalid weight assigned");
                        error_flag = true;
                    }
                }

                if (input4.isEmpty()) {
                    stock_wt.setError("Please fill this value");
                    error_flag = true;
                } else {
                    input4_n = Integer.parseInt(input4);
                    if (input4_n > 9) {
                        stock_wt.setError("Invalid weight assigned");
                        error_flag = true;
                    }
                }

                if (input5.isEmpty()) {
                    learning_wt.setError("Please fill this value");
                    error_flag = true;
                } else {
                    input5_n = Integer.parseInt(input5);
                    if (input5_n > 9) {
                        learning_wt.setError("Invalid weight assigned");
                        error_flag = true;
                    }
                }

                if (input6.isEmpty()) {
                    planning_wt.setError("Please fill this value");
                    error_flag = true;
                } else {
                    input6_n = Integer.parseInt(input6);
                    if (input6_n > 9) {
                        planning_wt.setError("Invalid weight assigned");
                        error_flag = true;
                    }
                }
            }

            if (!error_flag) {
                DatabaseHelper db = new DatabaseHelper(Adjust_Comparison_Settings.this);
                ComparisonSettings weights = new ComparisonSettings(input1_n, input2_n, input3_n, input4_n, input5_n, input6_n);
                db.updateWeights(weights);

                Toast.makeText(Adjust_Comparison_Settings.this, "weights values are saved now", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Adjust_Comparison_Settings.this, MainActivity.class);
                startActivity(intent);
            }
        } else if (view.getId() == R.id.cancel_button) {
            Toast.makeText(Adjust_Comparison_Settings.this, "weights values are cancelled now", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Adjust_Comparison_Settings.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
