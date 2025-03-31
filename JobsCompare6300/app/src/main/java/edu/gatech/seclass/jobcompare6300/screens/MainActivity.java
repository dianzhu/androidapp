package edu.gatech.seclass.jobcompare6300.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import edu.gatech.seclass.jobcompare6300.R;
import edu.gatech.seclass.jobcompare6300.objects.CurrentJob;
import edu.gatech.seclass.jobcompare6300.objects.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.main_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainmenu), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void handleClick(View view) {

        if (view.getId() == R.id.edit_current_job_button) {
            Intent intent = new Intent(MainActivity.this, Edit_Current_Job.class);
            startActivity(intent);
        } else if (view.getId() == R.id.enter_job_offer_button) {
            Intent intent = new Intent(MainActivity.this, Enter_Job_Offer.class);
            startActivity(intent);
        } else if (view.getId() == R.id.adjust_comparison_settings_button) {
            Intent intent = new Intent(MainActivity.this, Adjust_Comparison_Settings.class);
            startActivity(intent);
        } else if (view.getId() == R.id.compare_jobs_button) {
            DatabaseHelper db = new DatabaseHelper(MainActivity.this);
            int numberOfJobs = 0;
            if (db.readCurrentJob() != null) {
                numberOfJobs += 1;
            }
            numberOfJobs += db.readJobOffers().size();
            if (numberOfJobs >= 2) {
                Intent intent = new Intent(MainActivity.this, Compare_Jobs.class);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "you need at least two jobs (including current job)", Toast.LENGTH_SHORT).show();
            }
        }
    }
}