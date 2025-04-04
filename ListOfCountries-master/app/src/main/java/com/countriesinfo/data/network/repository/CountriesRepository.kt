package com.countriesinfo.data.network.repository

import com.countriesinfo.data.model.CountiesInfoResponseItem
import com.countriesinfo.data.network.CountryApiService
import com.countriesinfo.data.network.NetworkStatus
import okio.IOException
import retrofit2.HttpException


class CountriesRepository(private val countryApiService: CountryApiService) {
    suspend fun getPost(): NetworkStatus<List<CountiesInfoResponseItem>> {
        return try {
            val response = countryApiService.getPosts()
            NetworkStatus.Success(response)
        } catch (e: IOException) {
            NetworkStatus.Error("Network error: Please check your internet connection.", e)
        } catch (e: HttpException) {
            NetworkStatus.Error("Server error: Unable to fetch data.", e)
        } catch (e: Exception) {
            NetworkStatus.Error("Failed to fetch countries", e)
        }
    }
}