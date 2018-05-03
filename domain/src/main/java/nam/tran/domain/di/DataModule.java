package nam.tran.domain.di;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import nam.tran.domain.IRepository;
import nam.tran.domain.Repository;
import nam.tran.domain.executor.AppSchedulerProvider;
import nam.tran.domain.executor.SchedulerProvider;
import nam.tran.flatform.di.PreferenceModule;

@SuppressWarnings("unused")
@Module(includes = {PreferenceModule.class})
public abstract class DataModule {

    @Binds
    @Singleton
    abstract IRepository provideRepository(Repository repository);

    @Binds
    @Singleton
    abstract SchedulerProvider provideSchedulerProvider(AppSchedulerProvider schedulerProvider);
}
