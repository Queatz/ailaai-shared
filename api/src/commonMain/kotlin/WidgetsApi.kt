import app.ailaai.api.Api
import app.ailaai.api.ErrorBlock
import app.ailaai.api.SuccessBlock
import com.queatz.db.CreateWidgetBody
import com.queatz.db.Widget
import com.queatz.widgets.Widgets

suspend fun Api.widget(
    id: String,
    onError: ErrorBlock = null,
    onSuccess: SuccessBlock<Widget>
) = get(
    "widgets/$id",
    onError = onError,
    onSuccess = onSuccess
)

suspend fun Api.createWidget(
    widget: Widgets,
    onError: ErrorBlock = null,
    onSuccess: SuccessBlock<Widget>
) = post(
    "widgets",
    CreateWidgetBody(widget),
    onError = onError,
    onSuccess = onSuccess
)
