package nam.tran.domain.interactor;

import nam.tran.domain.IRepository;

@SuppressWarnings("unused")
public abstract class UseCase {

    private final IRepository iRepository;

    protected UseCase(IRepository iRepository) {
        this.iRepository = iRepository;
    }
}
