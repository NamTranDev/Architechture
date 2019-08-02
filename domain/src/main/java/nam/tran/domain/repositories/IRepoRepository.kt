package nam.tran.domain.repositories

import io.reactivex.Single
import nam.tran.domain.entities.RepositoryEntity

interface IRepoRepository {
    fun getRepositories(page: Int, perPage: Int) : Single<List<RepositoryEntity>>
}