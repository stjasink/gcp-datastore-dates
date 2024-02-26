package com.tjasink.gcp.repository

import com.google.cloud.spring.data.datastore.repository.DatastoreRepository
import com.tjasink.gcp.model.ThingWithDate

interface ThingWithDateRepository: DatastoreRepository<ThingWithDate, String>
