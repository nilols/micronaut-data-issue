package com.example.course

import com.example.student.Student
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.Relation
import io.micronaut.data.annotation.Relation.Cascade.ALL
import io.micronaut.data.annotation.Relation.Kind.MANY_TO_MANY
import java.util.UUID

@MappedEntity
data class Course(

    @field:Id
    val id: UUID,

    val name: String,

    @Relation(value = MANY_TO_MANY, mappedBy = "courses", cascade = [ALL])
    val students: List<Student>
)