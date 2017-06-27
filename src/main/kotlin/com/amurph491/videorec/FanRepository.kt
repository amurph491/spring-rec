package com.amurph491.videorec

import org.springframework.data.cassandra.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.scheduling.annotation.Async
import java.util.concurrent.CompletableFuture

interface FanRepository : CrudRepository<Fan, Long> {

    @Query("SELECT * from fans where fan_id in(?0)")
    fun findFanByIdIn(id: Long): Fan

    fun findFanByUserName(userName: String): Fan

    @Async
    fun findTop10ByFirstName(firstName: String): CompletableFuture<Fan>
}