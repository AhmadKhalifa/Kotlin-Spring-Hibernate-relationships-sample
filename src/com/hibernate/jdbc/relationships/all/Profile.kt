package com.hibernate.jdbc.relationships.all

import javax.persistence.*

@Entity(name = "instructor_detail")
data class Profile(
        @Column(name = "youtube_channel") var youtubeChannel: String = "",
        var hobby: String = ""
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
    lateinit var id: Integer

    @OneToOne(
            mappedBy = "profile",
            cascade = [CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH]
    )
    lateinit var instructor: Instructor
}