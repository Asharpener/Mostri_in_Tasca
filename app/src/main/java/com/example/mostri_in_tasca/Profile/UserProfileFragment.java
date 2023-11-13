package com.example.mostri_in_tasca.Profile;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.example.mostri_in_tasca.R;

public class UserProfileFragment extends Fragment {

    private UserProfileFragment mViewModel;

    public static UserProfileFragment newInstance() {
        return new UserProfileFragment();



    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_profile, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageButton imageButtonArma = view.findViewById(R.id.imageButtonArma);
        imageButtonArma.setOnClickListener( v -> Navigation.findNavController(v).navigate(R.id.action_userProfileFragment_to_userArtifactsFragment));

        ImageButton imageButtonAmuleto = view.findViewById(R.id.imageButtonAmuleto);
        imageButtonAmuleto.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_userProfileFragment_to_userArtifactsFragment));

        ImageButton imageButtonArmatura = view.findViewById(R.id.imageButtonArmatura);
        imageButtonArmatura.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_userProfileFragment_to_userArtifactsFragment));

        ImageButton modifyProfileButton = view.findViewById(R.id.modifyProfileButton);
        modifyProfileButton.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_userProfileFragment_to_modifyProfileFragment));


    }

}