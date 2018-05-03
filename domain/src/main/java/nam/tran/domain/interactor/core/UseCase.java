package nam.tran.domain.interactor.core;

import nam.tran.domain.IRepository;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public abstract class UseCase {

    protected final IRepository iRepository;

    protected UseCase(IRepository iRepository) {
        this.iRepository = iRepository;
    }
}
