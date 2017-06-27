package com.amurph491.videorec

import lombok.Getter
import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.util.*

@Table(value = "fans")
class Fan(
        var userName: String,
        var firstName: String,
        var lastName: String)
{
    @PrimaryKey("fan_id")
    private var id: String = UUID.randomUUID().toString()

    override fun toString(): String {
        return "Fan(firstName='$this.firstName', lastName='$this.lastName')"
    }

}