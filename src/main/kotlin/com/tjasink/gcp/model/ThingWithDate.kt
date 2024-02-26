package com.tjasink.gcp.model

import com.google.cloud.spring.data.datastore.core.mapping.Entity
import org.springframework.data.annotation.Id
import java.time.LocalDate

@Entity
data class ThingWithDate(
    @Id
    val id: String,
    val date: LocalDate
)
