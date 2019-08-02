package nam.tran.architechture.view.repository.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import nam.tran.data.Logger
import nam.tran.domain.entities.RepositoryEntity
import nam.tran.domain.interactor.UserUseCase

class RepoDataSourceFactory constructor(private val useCase: UserUseCase) : DataSource.Factory<Int, RepositoryEntity>() {

    val sourceData = MutableLiveData<RepoDataSource>()

    override fun create(): DataSource<Int, RepositoryEntity> {
        Logger.debug("Paging Learn", "RepoDataSourceFactory - create()")
        val source = RepoDataSource(useCase)
        sourceData.postValue(source)
        return source
    }
}