package com.tjasink.gcp

import com.tjasink.gcp.model.ThingWithDate
import com.tjasink.gcp.repository.ThingWithDateRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDate
import java.time.Month
import java.util.*

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DatastoreDateTest {

    @Autowired
    private var repository: ThingWithDateRepository? = null

    @Test
    fun `loading LocalDate gives the same answer when running in different time zones`() {
        val myDate = LocalDate.of(2023, Month.JULY, 21)
        val id = UUID.randomUUID().toString()

        TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"))

        val thing = ThingWithDate(id, myDate)
        repository!!.save(thing)

        val loadedThingSameTZ  = repository!!.findById(id).get()
        println(loadedThingSameTZ)
        // this assertion passes, was loaded in the same time zone it was saved
        assertEquals(myDate, loadedThingSameTZ.date)

        TimeZone.setDefault(TimeZone.getTimeZone("UTC"))

        val loadedThingUTC  = repository!!.findById(id).get()
        println(loadedThingUTC)
        // this assertion fails, was loaded in a different time zone
        assertEquals(myDate, loadedThingUTC.date)
    }

}
