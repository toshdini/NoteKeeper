package com.example.notekeeper.Note;

import android.app.job.JobParameters;
import android.app.job.JobService;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class NoteUploaderJobService extends JobService {
    public static final String EXTRA_DATA_URI = "com.example.notekeeper.extras.DATA_URI";
    private final Executor mExecutor = Executors.newSingleThreadExecutor();
    private NoteUploader mNoteUploader;
    private JobParameters backgroundParams;


    public NoteUploaderJobService() {
    }

    @Override
    public boolean onStartJob(JobParameters params) {

        mNoteUploader = new NoteUploader(this);


        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }


}