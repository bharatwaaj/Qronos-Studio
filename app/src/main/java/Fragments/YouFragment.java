package Fragments;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import design.material.myapplication.R;

import static LayoutDesigns.GetRoundedCornersForImageView.getRoundedCornerBitmap;
import static design.material.myapplication.R.drawable;
import static design.material.myapplication.R.id;

public class YouFragment extends Fragment{

    private static final int RESULT_LOAD_IMAGE = 1;
    ImageView profilePicture;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_you, container, false);
        TextView userNameTextView = (TextView) layout.findViewById(id.textView_profile);
        String userName = getActivity().getIntent().getStringExtra(Intent.EXTRA_TEXT);
        userNameTextView.setText(userName.toUpperCase());
        profilePicture = (ImageView) layout.findViewById(id.imageView_profile);
        Bitmap bImage = BitmapFactory.decodeResource(this.getResources(), drawable.index_profile_picture);
        Bitmap bImage2=getRoundedCornerBitmap(bImage, 300);
        profilePicture.setImageBitmap(bImage2);
        profilePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                // where do we want to find the data?
                File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                String pictureDirectoryPath = pictureDirectory.getPath();
                // finally, get a URI representation
                Uri data = Uri.parse(pictureDirectoryPath);
                // set the data and type.  Get all image types.
                photoPickerIntent.setDataAndType(data, "image/*");
                startActivityForResult(photoPickerIntent,RESULT_LOAD_IMAGE);
            }
        });
        return layout;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        // if we are here, everything processed successfully.
        if (requestCode == RESULT_LOAD_IMAGE) {
            // if we are here, we are hearing back from the image gallery.
            // the address of the image on the SD Card.
            Uri imageUri = data.getData();
            // declare a stream to read the image data from the SD Card.
            InputStream inputStream;
            // we are getting an input stream, based on the URI of the image.
            try {
                inputStream = getActivity().getContentResolver().openInputStream(imageUri);
                // get a bitmap from the stream.
                Bitmap image = getRoundedCornerBitmap(BitmapFactory.decodeStream(inputStream), 300);
                // show the image to the user]
                profilePicture.setImageBitmap(image);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                // show a message to the user indictating that the image is unavailable.
                Toast.makeText(getActivity(), "File Not Found", Toast.LENGTH_LONG).show();
            }

        }
    }

}
