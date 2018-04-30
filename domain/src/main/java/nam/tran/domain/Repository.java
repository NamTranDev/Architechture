package nam.tran.domain;

import javax.inject.Inject;
import javax.inject.Singleton;

import nam.tran.domain.executor.AppExecutors;
import nam.tran.domain.mapper.DataEntityMapper;
import nam.tran.flatform.IApi;
import nam.tran.flatform.local.IPreference;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
@Singleton
public class Repository implements IRepository {

    private final AppExecutors appExecutors;
    private final IPreference iPreference;
    private final DataEntityMapper dataEntityMapper;
    private IApi iApi;

    @Inject Repository(AppExecutors appExecutors, IPreference iPreference, DataEntityMapper dataEntityMapper) {
        this.appExecutors = appExecutors;
        this.iPreference = iPreference;
        this.dataEntityMapper = dataEntityMapper;
    }
}
