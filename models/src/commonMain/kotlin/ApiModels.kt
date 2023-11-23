package com.queatz.db

import com.queatz.widgets.Widgets
import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable

@Serializable
data class Geo(val latitude: Double, val longitude: Double) {
    override fun toString() = "$latitude,$longitude"
}

fun Geo.toList() = listOf(latitude, longitude)
fun List<Double>.asGeo() = Geo(get(0), get(1))

@Serializable
class MemberDevice(
    var member: Member? = null,
    var devices: List<Device>? = null
)

@Serializable
class GroupExtended(
    var group: Group? = null,
    var members: List<MemberAndPerson>? = null,
    var cardCount: Int? = null,
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

@Serializable
data class WildReplyBody(
    val message: String,
    val conversation: String?,
    val card: String,
    val device: String
)

@Serializable
data class ConversationItem(
    var title: String = "",
    var message: String = "",
    var action: ConversationAction? = null,
    var items: MutableList<ConversationItem> = mutableListOf(),
)

@Serializable
data class CardOptions(
    var enableReplies: Boolean? = null,
    var enableAnonymousReplies: Boolean? = null
)

enum class ConversationAction {
    Message
}

@Serializable
data class ProfileStats(
    val friendsCount: Int,
    val cardCount: Int
)

@Serializable
data class PersonProfile(
    val person: Person,
    val profile: Profile,
    val stats: ProfileStats
)

@Serializable
data class ExportDataResponse(
    val profile: Profile? = null,
    val cards: List<Card>? = null,
    val stories: List<Story>? = null
)

@Serializable
class MyDevice(
    val type: DeviceType,
    val token: String,
)

@Serializable
data class VersionInfo(
    val versionCode: Int,
    val versionName: String
)

@Serializable
data class SignUpRequest(
    val code: String?
)

@Serializable
data class SignInRequest(
    val code: String? = null,
    val link: String? = null
)

@Serializable
data class TokenResponse (
    val token: String
)

@Serializable
data class CreateGroupBody(val people: List<String>, val reuse: Boolean)

@Serializable
data class CreateWidgetBody(val widget: Widgets, val data: String? = null)
