package com.example.mostri_in_tasca.UserArtifacts;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mostri_in_tasca.R;

public class UserArtifactsFragment extends Fragment {

    private UserArtifactsViewModel mViewModel;

    public static UserArtifactsFragment newInstance() {
        return new UserArtifactsFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_user_artifacts, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button backButtonArtifacts = view.findViewById(R.id.backButtonArtifacts);
        backButtonArtifacts.setOnClickListener(v -> Navigation.findNavController(v).navigate(R.id.action_userArtifactsFragment_to_userProfileFragment));
    }
}