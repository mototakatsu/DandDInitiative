package jp.mototakatsu.danddinitiative;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import jp.mototakatsu.danddinitiative.databinding.ItemCharacterBinding;

/**
 * Created by moto on 2019/02/24.
 */

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ViewHolder> {

    private List<CharacterModel> dataList;

    public CharacterAdapter(List<CharacterModel> dataList) {
        this.dataList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ItemCharacterBinding binding = ItemCharacterBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        CharacterModel characterModel = dataList.get(position);
        viewHolder.binding.setCharacter(characterModel);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addCharacter(CharacterModel characterModel) {
        dataList.add(characterModel);
        notifyDataSetChanged();
    }

    public void setCharacter(int position, CharacterModel characterModel) {
        if(position < getItemCount()) {
            dataList.set(position, characterModel);
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ItemCharacterBinding binding;

        public ViewHolder(ItemCharacterBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
