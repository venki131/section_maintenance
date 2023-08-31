package com.example.sectionmaintenance

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.work.PeriodicWorkRequestBuilder
import androidx.work.WorkManager
import com.example.sectionmaintenance.ui.theme.SectionMaintenanceTheme
import java.util.concurrent.TimeUnit

class MainActivity : ComponentActivity() {

    val sectionKey = Section.HOME.name
    val isSectionInMaintenance = MaintenanceManager.isSectionInMaintenance(sectionKey)

    //add this in the fragment level for navigating to either maintenance fragment or selected section fragment
    private fun showScreen() {
        if (isSectionInMaintenance) {
            // Show maintenance screen or placeholder fragment
        } else {
            // Navigate to the selected section's fragment
        }
    }

    //run this in application level
    private fun runWorkerManager() {
        val workRequest = PeriodicWorkRequestBuilder<MaintenanceWorker>(
            repeatInterval = 5, // In minutes
            repeatIntervalTimeUnit = TimeUnit.MINUTES
        ).build()

        WorkManager.getInstance(this).enqueue(workRequest)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SectionMaintenanceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SectionMaintenanceTheme {
        Greeting("Android")
    }
}