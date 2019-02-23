package jp.mototakatsu.danddinitiative;

/**
 * Created by moto on 2019/02/23.
 */

public class CharacterModel {
    public String name;
    public Double initiative;
    public Integer damage;
    public String note;

    public CharacterModel(String name, double initiative, int damage, String note) {
        this.name = name;
        this.initiative = initiative;
        this.damage = damage;
        this.note = note;
    }
}
