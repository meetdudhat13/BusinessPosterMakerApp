package meet.anayacoders.businesspostermaker.data.response

data class RespMD(
    val data: Data,
    val error: Any,
    val message: String,
    val status: String,
    val timestamp: String
)