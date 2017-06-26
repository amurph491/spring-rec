package com.amurph491.videorec

import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table

@Table(value = "fans")
class Fan(userName: String, firstName: String, lastName: String){

    @PrimaryKey("fan_id") private val id: Long? = null

    override fun toString(): String {
        return "Fan(firstName='$this.firstName', lastName='$this.lastName')"
    }
}