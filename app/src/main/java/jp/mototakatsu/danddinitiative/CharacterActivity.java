package jp.mototakatsu.danddinitiative;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;

import jp.mototakatsu.danddinitiative.databinding.ActivityCharacterBinding;

public class CharacterActivity extends AppCompatActivity {

    public static final String KEY_CHARACTER = "character";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCharacterBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_character);
        binding.setActivity(this);
        Intent intent = getIntent();
        if (intent.hasExtra(KEY_CHARACTER)) {
            binding.setCharacter((CharacterModel) intent.getParcelableExtra(KEY_CHARACTER));
        }
        else {
            binding.setCharacter(new CharacterModel());
        }
    }

    public void onSave(CharacterModel characterModel) {
        EventBus.getDefault().post(new NewCharacterEvent(characterModel));
        finish();
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, CharacterActivity.class);
    }

    public static Intent createIntent(Context context, CharacterModel characterModel) {
        Intent intent = new Intent(context, CharacterActivity.class);
        intent.putExtra(KEY_CHARACTER, characterModel);
        return intent;
    }
}
