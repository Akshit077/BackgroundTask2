package com.example.backgroundtask2

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.annotation.RequiresApi



class MainActivity : AppCompatActivity() {

    companion object{
        val JOB_ID:Int=101
        var counter:Int=0;
        fun countSeconds()
        {
            counter++
        }
    }
    private lateinit var jobScheduler: JobScheduler
    private lateinit var jobInfo: JobInfo
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
override fun onCreate(savedInstanceState:Bundle?)
{
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    var cn:ComponentName= ComponentName(this,MJobScheduler::class.java)
    var builder:JobInfo.Builder=JobInfo.Builder(JOB_ID,cn)
    builder.setPeriodic(5000)
    builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
    builder.setPersisted(true)
    jobInfo=builder.build()
    jobScheduler=getSystemService(Context.JOB_SCHEDULER_SERVICE)as JobScheduler
}
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun scheduleJob(v:View)
    {
        jobScheduler.schedule(jobInfo)
        Toast.makeText(this,"Job Scheduled...",Toast.LENGTH_LONG).show()
    }
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun clearJob(v:View)
    {
        jobScheduler.cancel(JOB_ID)
        Toast.makeText(this,"Job Cancelled...",Toast.LENGTH_LONG).show()
    }
}