package nam.tran.architechture.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import nam.tran.architechture.application.model.SoccerSeasonModel;
import nam.tran.domain.entity.SoccerSeasonEntity;
import nam.tran.domain.entity.state.Resource;

/**
 * Mapper class used to transform {@link SoccerSeasonEntity} (in the domain layer)
 * to {@link SoccerSeasonModel} in the
 * app layer.
 */
public class SoccerSeasonModelDataMapper {

    @Inject
    public SoccerSeasonModelDataMapper() {
    }

    /**
     * Transform a {@link SoccerSeasonEntity} into an {@link SoccerSeasonModel}.
     *
     * @param season Object to be transformed.
     * @return {@link SoccerSeasonModel}.
     */
    public SoccerSeasonModel transform(SoccerSeasonEntity season) {
        if (season == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final SoccerSeasonModel seasonModel = new SoccerSeasonModel();
        seasonModel.id = season.id;
        seasonModel.caption = season.caption;
        seasonModel.league = season.league;
        seasonModel.year = season.year;
        seasonModel.currentMatchday = season.currentMatchday;
        seasonModel.numberOfMatchdays = season.numberOfMatchdays;
        seasonModel.numberOfTeams = season.numberOfTeams;
        seasonModel.numberOfGames = season.numberOfGames;
        seasonModel.lastUpdated = season.lastUpdated;

        return seasonModel;
    }

    /**
     * Transform a Collection of {@link SoccerSeasonEntity} into a Collection of {@link SoccerSeasonModel}.
     *
     * @param seasonCollection Objects to be transformed.
     * @return List of {@link SoccerSeasonModel}.
     */
    public List<SoccerSeasonModel> transform(List<SoccerSeasonEntity> seasonCollection) {
        List<SoccerSeasonModel> seasonModelCollection;

        if (seasonCollection != null && !seasonCollection.isEmpty()) {
            seasonModelCollection = new ArrayList<>();
            for (SoccerSeasonEntity user : seasonCollection) {
                seasonModelCollection.add(transform(user));
            }
        } else {
            seasonModelCollection = new ArrayList<>();
        }

        return seasonModelCollection;
    }

    public Resource<List<SoccerSeasonModel>> transform(Resource<List<SoccerSeasonEntity>> data){
        return new Resource<>(data.status,transform(data.data),data.message,data.loading);
    }
}
