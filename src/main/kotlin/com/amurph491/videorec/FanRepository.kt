package com.amurph491.videorec

import org.springframework.data.cassandra.repository.Query
import org.springframework.data.repository.CrudRepository

interface FanRepository : CrudRepository<Fan, Long> {

    @Query("SELECT * from fans where fan_id in(?0)")
    fun findFanByIdIn(id: Long): Fan

    fun findFanByUsername(username: String): Fan
}