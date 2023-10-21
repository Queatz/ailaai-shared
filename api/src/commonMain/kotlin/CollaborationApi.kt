package app.ailaai.api

import com.queatz.db.Card
import io.ktor.http.*
import kotlinx.serialization.Serializable

@Serializable
private data class LeaveCollaborationBody(val card: String)

suspend fun Api.myCollaborations(
    onError: ErrorBlock = null,
    onSuccess: SuccessBlock<List<Card>> = {}
) = get(
    "me/collaborations",
    onError = onError,
    onSuccess = onSuccess
)

suspend fun Api.leaveCollaboration(
    card: String,
    onError: ErrorBlock = null,
    onSuccess: SuccessBlock<HttpStatusCode> = {}
) = post(
    "me/collaborations/leave",
    LeaveCollaborationBody(card),
    onError = onError,
    onSuccess = onSuccess
)
