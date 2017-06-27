package com.amurph491.videorec

import com.datastax.driver.core.Session
import junit.framework.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.cql.core.generator.CreateIndexCqlGenerator
import org.springframework.data.cql.core.keyspace.CreateIndexSpecification
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class VideorecApplicationTests {
	@Autowired
	lateinit var repository: FanRepository

    @Autowired
    lateinit var session: Session

	@Test
	fun contextLoads() {
	}

	@Test
	fun testRepository() {
        val cql = CreateIndexCqlGenerator(CreateIndexSpecification()
                .ifNotExists()
                .tableName("fans")
                .columnName("userName")).toCql()
        session.execute(cql);
        Thread.sleep(1000)
		val fan = repository.findFanByUserName("amurph491");

        assertNotNull(fan)
		assertEquals(fan.firstName, "Alex")
	}


}
