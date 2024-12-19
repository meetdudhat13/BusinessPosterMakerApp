package meet.anayacoders.businesspostermaker.data.database.remote

import meet.anayacoders.businesspostermaker.data.response.generalEvent.GeneralEventDto
import meet.anayacoders.businesspostermaker.data.response.generalEvent.GeneralEventsResponseDto
import meet.anayacoders.businesspostermaker.data.response.poster.PosterDto
import meet.anayacoders.businesspostermaker.data.response.poster.PosterResponseDto
import meet.anayacoders.businesspostermaker.data.response.upcomingevent.UpcomingEventDto
import meet.anayacoders.businesspostermaker.data.response.upcomingevent.UpcomingEventsResponseDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    // Poster API endpoints
    @GET("posters")
    suspend fun getAllPosters(): PosterResponseDto

    @POST("posters")
    suspend fun addPoster(@Body poster: PosterDto): PosterResponseDto

    @DELETE("posters/{id}")
    suspend fun deletePoster(@Path("id") posterId: String): PosterResponseDto

    @PUT("posters/{id}")
    suspend fun updatePoster(
        @Path("id") posterId: String,
        @Body poster: PosterDto
    ): PosterResponseDto

    @GET("posters/search/title")
    suspend fun searchPosterByTitle(
        @Query("title") title: String
    ): PosterResponseDto

    @GET("posters/search/category")
    suspend fun searchPosterByCategory(
        @Query("category") category: String
    ): PosterResponseDto

    @GET("posters/search/combined")
    suspend fun searchPosterByCombinedSearch(
        @Query("query") query: String
    ): PosterResponseDto


    // Upcoming Events API endpoints
    @GET("upcoming-events")
    suspend fun getAllUpComingEvent(): UpcomingEventsResponseDto

    @POST("upcoming-events")
    suspend fun addUpcomingEvent(@Body event: UpcomingEventDto): UpcomingEventsResponseDto

    @DELETE("upcoming-events/{id}")
    suspend fun deleteUpcomingEvent(@Path("id") eventId: String): UpcomingEventsResponseDto

    @PUT("upcoming-events/{id}")
    suspend fun updateUpcomingEvent(
        @Path("id") evenId: String,
        @Body event: UpcomingEventDto
    ): UpcomingEventsResponseDto

    @GET("upcoming-events/search/title")
    suspend fun searchUpcomingEventByTitle(
        @Query("title") title: String
    ): UpcomingEventsResponseDto

    @GET("upcoming-events/search/category")
    suspend fun searchUpcomingEventByCategory(
        @Query("category") category: String
    ): UpcomingEventsResponseDto

    @GET("upcoming-events/search/combined")
    suspend fun searchUpcomingEventByCombinedSearch(
        @Query("query") query: String
    ): UpcomingEventsResponseDto


    // General Events API endpoints
    @GET("general-events")
    suspend fun getAllGeneralEvent(): GeneralEventsResponseDto

    @POST("general-events")
    suspend fun addGeneralEvent(@Body event: GeneralEventDto): GeneralEventsResponseDto

    @DELETE("general-events/{id}")
    suspend fun deleteGeneralEvent(@Path("id") eventId: String): GeneralEventsResponseDto

    @PUT("general-events/{id}")
    suspend fun updateGeneralEvent(
        @Path("id") evenId: String,
        @Body event: GeneralEventDto
    ): GeneralEventsResponseDto

    @GET("general-events/search/title")
    suspend fun searchGeneralEventByTitle(
        @Query("title") title: String
    ): GeneralEventsResponseDto

    @GET("general-events/search/category")
    suspend fun searchGeneralEventByCategory(
        @Query("category") category: String
    ): GeneralEventsResponseDto

    @GET("general-events/search/combined")
    suspend fun searchGeneralEventByCombinedSearch(
        @Query("query") query: String
    ): GeneralEventsResponseDto



}