package com.queatz.db

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
class MemberDevice(
    var member: Member? = null,
    var devices: List<Device>? = null
)

@Serializable
class GroupExtended(
    var group: Group? = null,
    var members: List<MemberAndPerson>? = null,
    var latestMessage: Message? = null
)

@Serializable
class MemberAndPerson(
    var person: Person? = null,
    var member: Member? = null
)

@Serializable
class JoinRequestAndPerson(
    var person: Person? = null,
    var joinRequest: JoinRequest? = null
)

@Serializable
class SaveAndCard(
    var save: Save? = null,
    var card: Card? = null
)

@Serializable
class ReminderOccurrences(
    val reminder: Reminder,
    val dates: List<Instant>,
    val occurrences: List<ReminderOccurrence>,
)
