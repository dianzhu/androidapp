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

import java.util.ArrayList;

import edu.gatech.seclass.jobcompare6300.R;
import edu.gatech.seclass.jobcompare6300.objects.CurrentJob;
import edu.gatech.seclass.jobcompare6300.objects.DatabaseHelper;
import edu.gatech.seclass.jobcompare6300.objects.Job;
import edu.gatech.seclass.jobcompare6300.objects.JobOffer;

public class Enter_Job_Offer_Cont extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.enter_job_offer_cont);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.enterjoboffercont), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void handleClick(View view) {
        if (view.getId() == R.id.compare_with_current_job_button) {
            ArrayList<Job> selectedJobs = new ArrayList<>();
            DatabaseHelper db = new DatabaseHelper(Enter_Job_Offer_Cont.this);
            CurrentJob currentJob = db.readCurrentJob();
            JobOffer lastJobOffer = db.readLastJobOffer();
            if (currentJob == null) {
                Toast.makeText(Enter_Job_Offer_Cont.this, "current job details are not present now, so this button is disabled.", Toast.LENGTH_SHORT).show();
            } else {
                selectedJobs.add(currentJob);
                selectedJobs.add(lastJobOffer);
                Intent intent = new Intent(Enter_Job_Offer_Cont.this, Compare_Jobs_Cont.class);
                intent.putExtra("selectedJobs", selectedJobs);
                startActivity(intent);
            }
        }
        else if (view.getId() == R.id.enter_another_job_offer_button) {
            Intent intent = new Intent(Enter_Job_Offer_Cont.this, Enter_Job_Offer.class);
            startActivity(intent);
        }
        else if (view.getId() == R.id.return_main_menu_button) {
            Intent intent = new Intent(Enter_Job_Offer_Cont.this, MainActivity.class);
            startActivity(intent);
        }
    }

}
