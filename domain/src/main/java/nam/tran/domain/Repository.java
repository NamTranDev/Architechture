package nam.tran.domain;

import javax.inject.Inject;

import nam.tran.domain.executor.AppExecutors;
import nam.tran.domain.mapper.DataEntityMapper;
import nam.tran.flatform.IApi;
import nam.tran.flatform.local.IPreference;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public class Repository implements IRepository {

    private final AppExecutors appExecutors;
    private final IPreference iPreference;
    private final DataEntityMapper dataEntityMapper;
    private final IApi iApi;
//    private final DbProvider dbProvider;

    @Inject
    Repository(AppExecutors appExecutors, IPreference iPreference, DataEntityMapper dataEntityMapper, IApi iApi/*, DbProvider dbProvider*/) {
        this.appExecutors = appExecutors;
        this.iPreference = iPreference;
        this.dataEntityMapper = dataEntityMapper;
        this.iApi = iApi;
//        this.dbProvider = dbProvider;
    }
}
