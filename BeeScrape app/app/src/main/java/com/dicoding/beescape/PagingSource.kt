package com.dicoding.beescape

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dicoding.beescape.api.response.ItemsItem
import com.dicoding.beescape.api.retrofit.ApiService

class PagingSource (private val apiService: ApiService, private val token: String):
    PagingSource<Int, ItemsItem>() {

    override fun getRefreshKey(state: PagingState<Int, ItemsItem>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ItemsItem> {
        return try {
            val position = params.key ?: INITIAL_PAGE_INDEX
            val responseData = apiService.getDataPaging(token, position, params.loadSize)
            val data= responseData.items!!.map { it as ItemsItem }

            LoadResult.Page(
                data = data,
                prevKey = if (position == INITIAL_PAGE_INDEX) null else position - 1,
                nextKey = if (data.isEmpty()) null else position + 1
            )
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }

    private companion object {
        const val INITIAL_PAGE_INDEX = 1
    }
}