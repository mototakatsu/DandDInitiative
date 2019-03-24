package jp.mototakatsu.danddinitiative;

/**
 * Created by moto on 2019/03/25.
 */

public class NewCharacterEvent {
    private final CharacterModel characterModel;

    public NewCharacterEvent(final CharacterModel characterModel) {
        this.characterModel = characterModel;
    }

    public CharacterModel getCharacter() {
        return characterModel;
    }
}
