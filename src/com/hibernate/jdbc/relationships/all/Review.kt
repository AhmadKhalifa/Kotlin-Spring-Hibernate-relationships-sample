package com.hibernate.jdbc.relationships.all

import javax.persistence.*

@Entity(name = "review")
data class Review(var comment: String = "") {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
    lateinit var id: Integer

    @ManyToOne(cascade = [CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH])
    @JoinColumn(name = "course_id")
    lateinit var course: Course
}