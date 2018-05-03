package nam.tran.domain.interactor.core;

import nam.tran.domain.IRepository;

@SuppressWarnings({"FieldCanBeLocal", "unused"})
public abstract class UseCase {

    private final IRepository iRepository;

    protected UseCase(IRepository iRepository) {
        this.iRepository = iRepository;
    }
}
