package com.amurph491.videorec

import com.datastax.driver.core.Session
import lombok.extern.slf4j.Slf4j
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.beans.factory.annotation.Autowired

val FAN_KEYSPACE: String = "fans"
@Slf4j
@SpringBootApplication
class VideorecApplication {
    val CASSANDRA_KEYSPACE = CassandraKeyspace.onLocalhost()
    @Autowired
    lateinit var repository: FanRepository
    @Autowired
    lateinit var session: Session


    @Bean
    fun init() = CommandLineRunner {
        session.execute("CREATE KEYSPACE $FAN_KEYSPACE")
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
