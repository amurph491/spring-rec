package com.amurph491.videorec

import com.datastax.driver.core.Session
import lombok.extern.slf4j.Slf4j
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.beans.factory.annotation.Autowired

@Slf4j
@SpringBootApplication
class VideorecApplication {
    @Autowired
    lateinit var repository: FanRepository
    @Autowired
    lateinit var session: Session


    @Bean
    fun init() = CommandLineRunner {
        val f1 = Fan(
                "amurph491",
                "Alex",
                "Murphy");

        repository.save(f1)

    }

}

fun main(args: Array<String>) {
    SpringApplication.run(VideorecApplication::class.java, *args)
}
