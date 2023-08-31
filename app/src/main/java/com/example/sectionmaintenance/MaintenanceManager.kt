package com.example.sectionmaintenance

object MaintenanceManager {
    private val sectionMaintenanceFlags: MutableMap<String, Boolean> = mutableMapOf()

    fun updateSectionMaintenanceFlag(sectionKey: String, isMaintenance: Boolean) {
        sectionMaintenanceFlags[sectionKey] = isMaintenance
    }

    fun isSectionInMaintenance(sectionKey: String): Boolean {
        return sectionMaintenanceFlags[sectionKey] == true
    }
}
