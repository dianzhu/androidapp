package edu.gatech.seclass.jobcompare6300.screens;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

import edu.gatech.seclass.jobcompare6300.R;
import edu.gatech.seclass.jobcompare6300.objects.ComparisonSettings;
import edu.gatech.seclass.jobcompare6300.objects.CurrentJob;
import edu.gatech.seclass.jobcompare6300.objects.DatabaseHelper;
import edu.gatech.seclass.jobcompare6300.objects.Job;
import edu.gatech.seclass.jobcompare6300.objects.JobManager;
import edu.gatech.seclass.jobcompare6300.objects.JobOffer;

public class Compare_Jobs extends AppCompatActivity {
    private LinearLayout layout1;
    private LinearLayout layout2;
    ArrayList<JobOffer> jobOffers;
    ArrayList<Job> rankedJobs;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.compare_jobs);
        DatabaseHelper db = new DatabaseHelper(Compare_Jobs.this);
        CurrentJob currentJob = db.readCurrentJob();
        jobOffers = db.readJobOffers();
        ComparisonSettings weights = db.readWeights();
        JobManager jobManager = new JobManager(currentJob, jobOffers, weights);
        rankedJobs = jobManager.rankJobs();
        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        int index = 0;
        for (Job j : rankedJobs) {
            CheckBox box = new CheckBox(this);
            String text = "";
            if (j.getIsCurrent()) {
                text += "[CURRENT] ";
            }
            text += String.format("%s @ %s\n[SCORE = %.0f]", j.getTitle(), j.getCompany(), j.getScore());
            box.setText(text);
            if(index == 0) {
                layout1.addView(box);
            }
            else if(index > 0){
                layout2.addView(box);
            }
            index++;

        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.comparejobs), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void handleClick(View view) {
        if (view.getId() == R.id.compare_button) {
            boolean error_flag = false;
            ArrayList<Job> selectedJobs = new ArrayList<>();

            int count = 0;

            CheckBox box1 = (CheckBox) layout1.getChildAt(0);
            if (box1.isChecked()) {
                selectedJobs.add(rankedJobs.get(0));
                count += 1;
            }

            for (int i = 0; i < layout2.getChildCount(); i++) {
                CheckBox box = (CheckBox) layout2.getChildAt(i);
                if (box.isChecked()) {
                    selectedJobs.add(rankedJobs.get(i));
                    count += 1;
                }
            }

            if (count != 2) {
                Toast.makeText(Compare_Jobs.this, "Please select exactly two jobs", Toast.LENGTH_SHORT).show();
                error_flag = true;
            }

            if (!error_flag) {
                Intent intent = new Intent(Compare_Jobs.this, Compare_Jobs_Cont.class);
                intent.putExtra("selectedJobs", selectedJobs);
                startActivity(intent);
            }
        } else if (view.getId() == R.id.return_to_main_menu_button) {
            Intent intent = new Intent(Compare_Jobs.this, MainActivity.class);
            startActivity(intent);
        }
    }
}
