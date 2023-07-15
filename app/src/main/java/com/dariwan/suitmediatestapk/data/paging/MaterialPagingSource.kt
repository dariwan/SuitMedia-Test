package com.dariwan.suitmediatestapk.data.paging


import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.dariwan.suitmediatestapk.apihelper.ApiService
import com.dariwan.suitmediatestapk.response.AllUsersResponse

class MaterialPagingSource(private val apiService: ApiService): PagingSource<Int, AllUsersResponse.ListUsers>() {

    private val PAGE_INDEX = 1

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AllUsersResponse.ListUsers> {
        return try {
            val position = params.key ?: PAGE_INDEX
            val param = params.loadSize
            val response = apiService.getAllUsers(position, param).data.toList()

            LoadResult.Page(
                data = response,
                prevKey = if (position == PAGE_INDEX) null else position - 1,
                nextKey = position.plus(1)
            )
        } catch (exception : Exception){
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, AllUsersResponse.ListUsers>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}