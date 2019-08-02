package nam.tran.architechture.view.repository.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Transformations
import androidx.paging.PagedList
import androidx.paging.toLiveData
import nam.tran.data.Logger
import nam.tran.data.database.DbProvider
import nam.tran.data.local.IPreference
import nam.tran.data.network.IApi
import nam.tran.domain.entities.RepositoryEntity
import nam.tran.domain.interactor.UserUseCase
import tran.nam.core.viewmodel.BaseViewModel
import javax.inject.Inject

class RepositoriesViewModel @Inject internal constructor(useCase: UserUseCase, iApi: IApi, iDbProvider: DbProvider, iPreference: IPreference)
    : BaseViewModel() {

    private val pagedSize = 10
    private val _repoData = MediatorLiveData<PagedList<RepositoryEntity>>()
    val repoData: LiveData<PagedList<RepositoryEntity>>
        get() = _repoData

    private val sourceFactory = RepoDataSourceFactory(
            useCase
    )

    val state = Transformations.switchMap(sourceFactory.sourceData) { it.state }

    init {
        val config = PagedList.Config.Builder()
                .setPageSize(pagedSize)
                .setInitialLoadSizeHint(pagedSize * 2)
                .setPrefetchDistance(10)
                .setEnablePlaceholders(false)
                .build()

        _repoData.addSource(sourceFactory.toLiveData(config = config)) {
            Logger.debug(it)
            _repoData.value = it
        }
    }

    fun onRefresh() {
        sourceFactory.sourceData.value?.invalidate()
    }
}
