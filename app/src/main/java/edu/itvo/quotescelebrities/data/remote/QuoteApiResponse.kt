package edu.itvo.quotescelebrities.data.remote

import com.google.gson.annotations.SerializedName
import edu.itvo.quotescelebrities.domain.model.QuoteModel


data class QuoteApiResponse(
    @SerializedName("success")
    var success: Boolean,

    @SerializedName("message")
    var message: String,

    @SerializedName("data")
    var data: List<QuoteModel?>?

)