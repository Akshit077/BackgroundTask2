package com.example.backgroundtask2

import android.app.job.JobParameters
import android.app.job.JobService
import android.os.AsyncTask
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.backgroundtask2.MainActivity.Companion.counter
import kotlin.concurrent.thread

open class JobSchedulerService: AsyncTask<Void, Void, String>()
{
    override fun doInBackground(vararg params: Void?): String {

        MainActivity.countSeconds()
        return "Performing in Background $counter time"
    }

}