package com.tjasink.gcp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

fun main(args: Array<String>) {
    runApplication<SpringApp>(*args)
}

@SpringBootApplication
class SpringApp : SpringBootServletInitializer()
