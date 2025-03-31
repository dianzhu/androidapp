package edu.gatech.seclass.jobcompare6300.objects;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private final Context context;
    private static final String DATABASE_NAME = "Team023.db";
    private static final Integer DATABASE_VERSION = 3 ;
    private static final String JOB_TABLE_NAME = "Job_Table";
    private static final String WEIGHTS_TABLE_NAME = "Weights_Table";
    private static final String COLUMN_ID = "_id";
    private static final String TITLE = "_title";
    private static final String COMPANY = "_company";
    private static final String CITY = "_city";
    private static final String STATE = "_state";
    private static final String COST_OF_LIVING = "_cost_of_living";
    private static final String YEARLY_SALARY = "_yearly_salary";
    private static final String YEARLY_BONUS = "_yearly_bonus";
    private static final String RETIREMENT = "_retirement";
    private static final String RESTRICTED_STOCKS = "_restricted_stocks";
    private static final String PERSONAL_LEARN_AND_DEVELOPMENT = "_personal_learn_and_development";
    private static final String FAMILY_PLANNING_ASSISTANCE = "_familyPlanning";
    private static final String YEARLY_SALARY_WEIGHT = "_yearly_salary_weight";
    private static final String YEARLY_BONUS_WEIGHT = "_yearly_bonus_weight";
    private static final String RETIREMENT_WEIGHT = "_retirement_weight";
    private static final String RESTRICTED_STOCKS_WEIGHT = "_restricted_stocks_weight";
    private static final String PERSONAL_LEARN_AND_DEVELOPMENT_WEIGHT = "_personal_learn_and_development_weight";
    private static final String FAMILY_PLANNING_ASSISTANCE_WEIGHT = "_familyPlanning_weight";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + JOB_TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + TITLE + " TEXT, "
                + COMPANY + " TEXT, "
                + CITY + " TEXT, "
                + STATE + " TEXT, "
                + COST_OF_LIVING + " INTEGER, "
                + YEARLY_SALARY + " REAL, "
                + YEARLY_BONUS + " REAL, "
                + RETIREMENT + " INTEGER, "
                + RESTRICTED_STOCKS + " REAL, "
                + PERSONAL_LEARN_AND_DEVELOPMENT + " REAL, "
                + FAMILY_PLANNING_ASSISTANCE + " REAL);";
        db.execSQL(query);

        // Insert default job
        ContentValues defaultCv = new ContentValues();
        defaultCv.put(COLUMN_ID, 1);

        db.insert(JOB_TABLE_NAME, null, defaultCv);

        query = "CREATE TABLE " + WEIGHTS_TABLE_NAME + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + YEARLY_SALARY_WEIGHT + " INTEGER, "
                + YEARLY_BONUS_WEIGHT + " INTEGER, "
                + RETIREMENT_WEIGHT + " INTEGER, "
                + RESTRICTED_STOCKS_WEIGHT + " INTEGER, "
                + PERSONAL_LEARN_AND_DEVELOPMENT_WEIGHT + " INTEGER, "
                + FAMILY_PLANNING_ASSISTANCE_WEIGHT + " INTEGER);";
        db.execSQL(query);

        // Insert default weights
        defaultCv = new ContentValues();
        defaultCv.put(YEARLY_SALARY_WEIGHT, 1);
        defaultCv.put(YEARLY_BONUS_WEIGHT, 1);
        defaultCv.put(RETIREMENT_WEIGHT, 1);
        defaultCv.put(RESTRICTED_STOCKS_WEIGHT, 1);
        defaultCv.put(PERSONAL_LEARN_AND_DEVELOPMENT_WEIGHT, 1);
        defaultCv.put(FAMILY_PLANNING_ASSISTANCE_WEIGHT, 1);

        db.insert(WEIGHTS_TABLE_NAME, null, defaultCv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + JOB_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + WEIGHTS_TABLE_NAME);
        onCreate(db);
    }

    public CurrentJob readCurrentJob() {
        String query = "SELECT * FROM " + JOB_TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();
        if (cursor.isNull(1)) {
            return null;
        } else {
            return new CurrentJob(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getInt(5),
                    cursor.getDouble(6),
                    cursor.getDouble(7),
                    cursor.getInt(8),
                    cursor.getDouble(9),
                    cursor.getDouble(10),
                    cursor.getDouble(11)
            );
        }
    }

    public ArrayList<JobOffer> readJobOffers() {
        ArrayList<JobOffer> jobOffers = new ArrayList<>();
        String query = "SELECT * FROM " + JOB_TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();
        while (cursor.moveToNext()) {
            jobOffers.add(new JobOffer(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getInt(5),
                    cursor.getDouble(6),
                    cursor.getDouble(7),
                    cursor.getInt(8),
                    cursor.getDouble(9),
                    cursor.getDouble(10),
                    cursor.getDouble(11)
            ));
        }
        return jobOffers;
    }

    public JobOffer readLastJobOffer() {
        String query = "SELECT * FROM " + JOB_TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToLast();
        return new JobOffer(
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getInt(5),
                cursor.getDouble(6),
                cursor.getDouble(7),
                cursor.getInt(8),
                cursor.getDouble(9),
                cursor.getDouble(10),
                cursor.getDouble(11)
        );
    }

    public ComparisonSettings readWeights() {
        String query = "SELECT * FROM " + WEIGHTS_TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        cursor.moveToFirst();
        return new ComparisonSettings(
                cursor.getInt(1),
                cursor.getInt(2),
                cursor.getInt(3),
                cursor.getInt(4),
                cursor.getInt(5),
                cursor.getInt(6)
        );
    }

    public void updateCurrentJob(CurrentJob currentJob) {

        SQLiteDatabase db = this.getWritableDatabase();

        // Update the first job entry in the table
        ContentValues cv = new ContentValues();
        cv.put(TITLE, currentJob.getTitle());
        cv.put(COMPANY, currentJob.getCompany());
        cv.put(CITY, currentJob.getCity());
        cv.put(STATE, currentJob.getState());
        cv.put(COST_OF_LIVING, currentJob.getCostOfLiving());
        cv.put(YEARLY_SALARY, currentJob.getYearlySalary());
        cv.put(YEARLY_BONUS, currentJob.getYearlyBonus());
        cv.put(RETIREMENT, currentJob.getRetirement());
        cv.put(RESTRICTED_STOCKS, currentJob.getRestrictedStock());
        cv.put(PERSONAL_LEARN_AND_DEVELOPMENT, currentJob.getPersonalLearningAndDevelopment());
        cv.put(FAMILY_PLANNING_ASSISTANCE, currentJob.getFamilyPlanningAssistance());

        int result = db.update(JOB_TABLE_NAME, cv, "_id = ?", new String[]{"1"});
        if (result == -1) {
            Toast.makeText(context, "Failed to update current job", Toast.LENGTH_SHORT).show();
            Log.e("DatabaseHelper", "Update failed for values: " + cv);
        } else {
            Toast.makeText(context, "Current job updated successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    public void addJobOffer(JobOffer jobOffer) {
        SQLiteDatabase db = this.getWritableDatabase();

        // Insert the new job offer
        ContentValues cv = new ContentValues();
        cv.put(TITLE,jobOffer.getTitle());
        cv.put(COMPANY, jobOffer.getCompany());
        cv.put(CITY, jobOffer.getCity());
        cv.put(STATE, jobOffer.getState());
        cv.put(COST_OF_LIVING, jobOffer.getCostOfLiving());
        cv.put(YEARLY_SALARY, jobOffer.getYearlySalary());
        cv.put(YEARLY_BONUS, jobOffer.getYearlyBonus());
        cv.put(RETIREMENT, jobOffer.getRetirement());
        cv.put(RESTRICTED_STOCKS, jobOffer.getRestrictedStock());
        cv.put(PERSONAL_LEARN_AND_DEVELOPMENT, jobOffer.getPersonalLearningAndDevelopment());
        cv.put(FAMILY_PLANNING_ASSISTANCE, jobOffer.getFamilyPlanningAssistance());

        long result = db.insert(JOB_TABLE_NAME, null, cv);
        if (result == -1) {
            Toast.makeText(context, "Failed to add job offer", Toast.LENGTH_SHORT).show();
            Log.e("DatabaseHelper", "Insertion failed for values: " + cv);
        } else {
            Toast.makeText(context, "Job offer added successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    public void updateWeights(ComparisonSettings weights) {

        SQLiteDatabase db = this.getWritableDatabase();

        // Update the first weights entry in the table
        ContentValues cv = new ContentValues();
        cv.put(YEARLY_SALARY_WEIGHT, weights.getYearlySalaryWeight());
        cv.put(YEARLY_BONUS_WEIGHT, weights.getYearlyBonusWeight());
        cv.put(RETIREMENT_WEIGHT, weights.getRetirementWeight());
        cv.put(RESTRICTED_STOCKS_WEIGHT, weights.getRestrictedStockWeight());
        cv.put(PERSONAL_LEARN_AND_DEVELOPMENT_WEIGHT, weights.getPersonalLearningAndDevelopmentWeight());
        cv.put(FAMILY_PLANNING_ASSISTANCE_WEIGHT, weights.getFamilyPlanningAssistanceWeight());

        int result = db.update(WEIGHTS_TABLE_NAME, cv, "_id = ?", new String[]{"1"});
        if (result == -1) {
            Toast.makeText(context, "Failed to update weights", Toast.LENGTH_SHORT).show();
            Log.e("DatabaseHelper", "Update failed for values: " + cv);
        } else {
            Toast.makeText(context, "Weights updated successfully!", Toast.LENGTH_SHORT).show();
        }
    }
}
