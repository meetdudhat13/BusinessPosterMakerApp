package meet.anayacoders.businesspostermaker.data.database.remote

import meet.anayacoders.businesspostermaker.data.dto.PosterDto
import meet.anayacoders.businesspostermaker.data.response.RespMD
import retrofit2.http.GET

interface PosterApiService {

    @GET("posters")
    suspend fun getAllPosters() : RespMD

}