package com.amurph491.videorec

import com.datastax.driver.core.Session
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.cassandra.config.SchemaAction
import org.springframework.data.cassandra.core.CassandraTemplate
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories
import org.springframework.data.cassandra.core.CassandraOperations
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter
import org.springframework.data.cassandra.core.convert.CassandraConverter
import org.springframework.data.cassandra.core.mapping.BasicCassandraMappingContext
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext
import org.springframework.data.cassandra.config.CassandraClusterFactoryBean
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment


@Configuration
@EnableAutoConfiguration
class BasicConfiguration {

    @Configuration
    @EnableCassandraRepositories
    internal class CassandraConfig : AbstractCassandraConfiguration() {

        public override fun getKeyspaceName(): String {
            return "recdb"
        }

        public override fun getContactPoints(): String {
            return "localhost"
        }

        @Bean
        fun cassandraTemplate(session: Session): CassandraTemplate {
            return CassandraTemplate(session)
        }

        override fun getEntityBasePackages(): Array<String> {
            return arrayOf(Fan::class.java!!.getPackage().getName())
        }

        override fun getSchemaAction(): SchemaAction {
            return SchemaAction.RECREATE
        }
    }
}