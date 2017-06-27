package com.amurph491.videorec

import com.datastax.driver.core.Session
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.beans.factory.annotation.Autowired

@SpringBootApplication
class VideorecApplication {
    @Autowired
    lateinit var repository: FanRepository
    @Autowired
    lateinit var session: Session


    @Bean
    fun init() = CommandLineRunner {

    }

}

fun main(args: Array<String>) {
    SpringApplication.run(VideorecApplication::class.java, *args)
}
