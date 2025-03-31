package edu.gatech.seclass.jobcompare6300.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import edu.gatech.seclass.jobcompare6300.R;
import edu.gatech.seclass.jobcompare6300.objects.Job;

public class Compare_Jobs_Cont extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.compare_jobs_cont);
        Intent intent = getIntent();
        ArrayList<Job> selectedJobs = (ArrayList<Job>) intent.getSerializableExtra("selectedJobs");
        Job job1 = selectedJobs.get(0);
        Job job2 = selectedJobs.get(1);
        TextView title1 = findViewById(R.id.title1);
        TextView title2 = findViewById(R.id.title2);
        TextView company1 = findViewById(R.id.company1);
        TextView company2 = findViewById(R.id.company2);
        TextView city1 = findViewById(R.id.city1);
        TextView city2 = findViewById(R.id.city2);
        TextView state1 = findViewById(R.id.state1);
        TextView state2 = findViewById(R.id.state2);
        TextView adjustedYearlySalary1 = findViewById(R.id.adjusted_yearly_salary1);
        TextView adjustedYearlySalary2 = findViewById(R.id.adjusted_yearly_salary2);
        TextView adjustedYearlyBonus1 = findViewById(R.id.adjusted_yearly_bonus1);
        TextView adjustedYearlyBonus2 = findViewById(R.id.adjusted_yearly_bonus2);
        TextView retirement1 = findViewById(R.id.retirement1);
        TextView retirement2 = findViewById(R.id.retirement2);
        TextView restrictedStocks1 = findViewById(R.id.restricted_stock1);
        TextView restrictedStocks2 = findViewById(R.id.restricted_stock2);
        TextView personalizedLearning1 = findViewById(R.id.personalized_learning_and_development1);
        TextView personalizedLearning2 = findViewById(R.id.personalized_learning_and_development2);
        TextView familyPlanningAssistance1 = findViewById(R.id.family_planning_assistance1);
        TextView familyPlanningAssistance2 = findViewById(R.id.family_planning_assistance2);

        title1.setText(job1.getTitle());
        title2.setText(job2.getTitle());
        company1.setText(job1.getCompany());
        company2.setText(job2.getCompany());
        city1.setText(job1.getCity());
        city2.setText(job2.getCity());
        state1.setText(job1.getState());
        state2.setText(job2.getState());
        adjustedYearlySalary1.setText(String.valueOf(job1.getAYS()));
        adjustedYearlySalary2.setText(String.valueOf(job2.getAYS()));
        adjustedYearlyBonus1.setText(String.valueOf(job1.getAYB()));
        adjustedYearlyBonus2.setText(String.valueOf(job2.getAYB()));
        retirement1.setText(String.valueOf(job1.getRetirement()));
        retirement2.setText(String.valueOf(job2.getRetirement()));
        restrictedStocks1.setText(String.valueOf(job1.getRestrictedStock()));
        restrictedStocks2.setText(String.valueOf(job2.getRestrictedStock()));
        personalizedLearning1.setText(String.valueOf(job1.getPersonalLearningAndDevelopment()));
        personalizedLearning2.setText(String.valueOf(job2.getPersonalLearningAndDevelopment()));
        familyPlanningAssistance1.setText(String.valueOf(job1.getFamilyPlanningAssistance()));
        familyPlanningAssistance2.setText(String.valueOf(job2.getFamilyPlanningAssistance()));

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.comparejobscont), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void handleClick(View view) {
        if (view.getId() == R.id.compare_other_jobs_button) {
            Intent intent = new Intent(Compare_Jobs_Cont.this, Compare_Jobs.class);
            startActivity(intent);
        } else if (view.getId() == R.id.return_main_menu_button) {
            Intent intent = new Intent(Compare_Jobs_Cont.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
