package com.example.sectionmaintenance

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.google.firebase.remoteconfig.FirebaseRemoteConfig

class MaintenanceWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    override fun doWork(): Result {
        //get the remote config instance
        val firebaseRemoteConfig =  FirebaseRemoteConfig.getInstance()

        val sectionOneFlag = firebaseRemoteConfig.getBoolean(Section.HOME.name)
        val sectionTwoFlag = firebaseRemoteConfig.getBoolean(Section.PREPZONE.name)

        MaintenanceManager.updateSectionMaintenanceFlag("section_one", sectionOneFlag)
        MaintenanceManager.updateSectionMaintenanceFlag("section_two", sectionTwoFlag)

        return Result.success()
    }
}
