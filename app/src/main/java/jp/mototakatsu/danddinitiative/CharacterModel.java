package jp.mototakatsu.danddinitiative;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by moto on 2019/02/23.
 */

public class CharacterModel extends BaseObservable implements Parcelable {
    private String name;
    private Double initiative;
    private Integer damage;
    private String note;

    public CharacterModel() {
        this.name = "";
        this.initiative = 0.0;
        this.damage = 0;
        this.note = "";
    }

    public CharacterModel(String name, double initiative, int damage, String note) {
        this.name = name;
        this.initiative = initiative;
        this.damage = damage;
        this.note = note;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public Double getInitiative() {
        return initiative;
    }

    @Bindable
    public Integer getDamage() {
        return damage;
    }

    @Bindable
    public String getNote() {
        return note;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    public void setInitiative(Double initiative) {
        this.initiative = initiative;
        notifyPropertyChanged(BR.initiative);
    }

    public void setDamage(Integer damage) {
        this.damage = damage;
        notifyPropertyChanged(BR.damage);
    }

    public void setNote(String note) {
        this.note = note;
        notifyPropertyChanged(BR.note);
    }

    // Parcelable methods
    protected CharacterModel(Parcel in) {
        name = in.readString();
        initiative = in.readDouble();
        damage = in.readInt();
        note = in.readString();
    }

    public static final Creator<CharacterModel> CREATOR = new Creator<CharacterModel>() {
        @Override
        public CharacterModel createFromParcel(Parcel in) {
            return new CharacterModel(in);
        }

        @Override
        public CharacterModel[] newArray(int i) {
            return new CharacterModel[i];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(initiative);
        dest.writeInt(damage);
        dest.writeString(note);
    }
}
