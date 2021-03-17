package com.example.backgroundtask2

import android.app.job.JobParameters
import android.app.job.JobService
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
class MJobScheduler: JobService() {

    private lateinit var mJobExecutor:JobSchedulerService
    override fun onStopJob(params: JobParameters?): Boolean {

        mJobExecutor.cancel(true)
        return false
    }

    override fun onStartJob(params: JobParameters?): Boolean {

        mJobExecutor=object :JobSchedulerService(){
            override fun onPostExecute(result: String?) {
                super.onPostExecute(result)

                Toast.makeText(applicationContext,result,Toast.LENGTH_LONG).show()
                jobFinished(params,false)
            }
        }
        mJobExecutor.execute()
        return true
    }
}