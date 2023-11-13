package com.example.mostri_in_tasca.EditProfile;

import static android.app.Activity.RESULT_OK;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mostri_in_tasca.R;

public class ModifyProfileFragment extends Fragment {

    private Uri selectedImageUri;
    private ModifyProfileViewModel mViewModel;

    private EditText nameEditText;
    private String originalName;
    public static ModifyProfileFragment newInstance() {
        return new ModifyProfileFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       return inflater.inflate(R.layout.fragment_modify_profile, container, false);

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button editPicButton = view.findViewById(R.id.editProfilePicButton);

        ActivityResultLauncher<Intent> pickImageLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(), result -> {
                    if (result.getResultCode() == RESULT_OK) {
                        // Gestisci l'immagine scelta dalla galleria
                        Intent data = result.getData();
                        selectedImageUri = data.getData();                        // Codice per gestire l'immagine
                    }
                });

        editPicButton.setOnClickListener(v -> {
            //codice per cambiare la foto del profilo
            showEditDialog(pickImageLauncher);

        });




        //edit name
        nameEditText = view.findViewById(R.id.editNameText);
        originalName = "Nome Attuale"; // Sostituisci con il vero nome del profilo

        nameEditText.setText(originalName);

        Button cancelNameButton = view.findViewById(R.id.cancelNameButton);
        cancelNameButton.setOnClickListener(v -> {
            //codice per annullare il cambiamento del nome
            nameEditText.setText(originalName);
            Toast.makeText(requireContext(), "Modifiche annullate", Toast.LENGTH_SHORT).show();

        });

        Button saveNameButton = view.findViewById(R.id.confirmButton);
        saveNameButton.setOnClickListener(v -> {
            //codice per salvare il nuovo nome
            String newName = nameEditText.getText().toString();
            originalName = newName;
            Toast.makeText(requireContext(), "Nome salvato: " + newName, Toast.LENGTH_SHORT).show();

        });



    }

    private void showEditDialog(ActivityResultLauncher<Intent> launcher) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Modifica Foto Profilo")
                .setItems(new CharSequence[]{"Scegli dalla galleria", "Scatta ora"}, (dialog, which) -> {
                    switch (which) {
                        case 0:
                            Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            launcher.launch(pickPhoto);
                            break;
                        case 1:
                            Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            if (takePicture.resolveActivity(requireActivity().getPackageManager()) != null) {
                                launcher.launch(takePicture);
                            }
                            break;
                    }
                });

        builder.create().show();
    }
}





