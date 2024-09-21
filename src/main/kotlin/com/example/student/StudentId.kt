package com.example.student

import io.micronaut.core.convert.ConversionContext
import io.micronaut.data.model.runtime.convert.AttributeConverter
import jakarta.inject.Singleton
import java.util.UUID

data class StudentId(val id: UUID)

@Singleton
class StudentIdAttributeConverter : AttributeConverter<StudentId, UUID> {
    override fun convertToPersistedValue(entityValue: StudentId?, context: ConversionContext?): UUID? {
        return entityValue?.id
    }

    override fun convertToEntityValue(persistedValue: UUID?, context: ConversionContext?): StudentId? {
        return persistedValue?.let { StudentId(it) }
    }
}