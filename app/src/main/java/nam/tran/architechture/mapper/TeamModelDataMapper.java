package nam.tran.architechture.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import nam.tran.architechture.model.SoccerSeasonModel;
import nam.tran.architechture.model.TeamModel;
import nam.tran.domain.entity.SoccerSeasonEntity;
import nam.tran.domain.entity.TeamEntity;
import nam.tran.domain.entity.state.Resource;

/**
 * Mapper class used to transform {@link SoccerSeasonEntity} (in the domain layer)
 * to {@link SoccerSeasonModel} in the
 * app layer.
 */
public class TeamModelDataMapper {

    @Inject
    public TeamModelDataMapper() {
    }

    /**
     * Transform a {@link TeamEntity} into an {@link TeamModel}.
     *
     * @param team Object to be transformed.
     * @return {@link SoccerSeasonModel}.
     */
    private TeamModel transform(TeamEntity team) {
        if (team == null) {
            throw new IllegalArgumentException("Cannot transform a null value");
        }
        final TeamModel teamModel = new TeamModel();
        teamModel.code = team.code;
        teamModel.crestUrl = team.crestUrl;
        teamModel.idSeason = team.idSeason;
        teamModel.name = team.name;
        teamModel.shortName = team.shortName;
        return teamModel;
    }

    /**
     * Transform a Collection of {@link List<TeamEntity>} into a Collection of {@link List<TeamModel>}.
     *
     * @param teamCollection Objects to be transformed.
     * @return List of {@link SoccerSeasonModel}.
     */
    private List<TeamModel> transform(List<TeamEntity> teamCollection) {
        List<TeamModel> teamModelCollection = new ArrayList<>();

        if (teamCollection != null && !teamCollection.isEmpty()) {
            teamModelCollection = new ArrayList<>();
            for (TeamEntity team : teamCollection) {
                teamModelCollection.add(transform(team));
            }
        }

        return teamModelCollection;
    }

    public Resource<List<TeamModel>> transform(Resource<List<TeamEntity>> data) {
        return new Resource<>(data.status, transform(data.data), data.message, data.loading);
    }
}
