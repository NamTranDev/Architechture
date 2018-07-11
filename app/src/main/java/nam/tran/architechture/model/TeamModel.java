package nam.tran.architechture.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TeamModel implements Parcelable {

    public int idSeason;
    public String name;
    public String code;
    public String shortName;
    public String crestUrl;


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.idSeason);
        dest.writeString(this.name);
        dest.writeString(this.code);
        dest.writeString(this.shortName);
        dest.writeString(this.crestUrl);
    }

    public TeamModel() {
    }

    protected TeamModel(Parcel in) {
        this.idSeason = in.readInt();
        this.name = in.readString();
        this.code = in.readString();
        this.shortName = in.readString();
        this.crestUrl = in.readString();
    }

    public static final Creator<TeamModel> CREATOR = new Creator<TeamModel>() {
        @Override
        public TeamModel createFromParcel(Parcel source) {
            return new TeamModel(source);
        }

        @Override
        public TeamModel[] newArray(int size) {
            return new TeamModel[size];
        }
    };
}
