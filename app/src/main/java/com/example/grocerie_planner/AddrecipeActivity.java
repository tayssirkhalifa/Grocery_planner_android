package com.example.grocerie_planner;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import android.os.Parcelable;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.grocerie_planner.adapter.recipieListAdapter;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AddrecipeActivity extends AppCompatActivity {

    final int REQUEST_CODE_GALLERY = 999;
    Button addimage, add, fabCamera, fabUpload;


    Bitmap mBitmap;
    Uri picUri;
    private ArrayList<String> permissionsToRequest;
    private ArrayList<String> permissionsRejected = new ArrayList<>();
    private ArrayList<String> permissions = new ArrayList<>();
    private final static int ALL_PERMISSIONS_RESULT = 107;
    private final static int IMAGE_RESULT = 200;
    EditText category, ingredients, country, instructions;
    ImageView image;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addrecipe);

        add = findViewById(R.id.addrecipe);
        category = findViewById(R.id.category);
        ingredients = findViewById(R.id.ingredients);
        country = findViewById(R.id.country);
        instructions = findViewById(R.id.instructions);
        image = findViewById(R.id.image);
        fabCamera = findViewById(R.id.fab);
        fabUpload = findViewById(R.id.fabUpload);


        /*askPermissions();
        fabCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(AddrecipeActivity.this,getPickImageChooserIntent().getClass());
                startActivity(i);
            }
        });*/
        fabUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  ImagePicker.Companion.with(this)
                        .crop()
                        .cropOval()
                        .compress(1024)
                        .maxResultSize(width: 1080,heigth:1080)
                        .start()*/
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // byte[] newimage=imageviewtobyte(image);
                  recipie recipie= new recipie();
                recipie.setCategory(category.getText().toString());
                recipie.setInstructions(instructions.getText().toString());
                recipie.setIngredients(ingredients.getText().toString());
                recipie.setCountry(country.getText().toString());

                if(validateInput(recipie)){
                    //DO insert operation
                    recipieDataBase recipiedataBase= recipieDataBase.getInstance(getApplicationContext());
                    recipieDAO recipiedao=recipiedataBase.recipieDAO();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            recipiedao.insertrecipe(recipie);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getApplicationContext(), "user registred", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }).start();
                }else{
                    Toast.makeText(getApplicationContext(), "fill all fields !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private Boolean validateInput(recipie recipie){
        if( recipie.getCategory().isEmpty()|| recipie.getInstructions().isEmpty()|| recipie.getCountry().isEmpty()){
            return false;
        }
        return true;
    }

           /* private byte[] imageviewtobyte(ImageView image) {
                Bitmap bitmap=((BitmapDrawable)image.getDrawable()).getBitmap();
                ByteArrayOutputStream stream= new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
                byte[] byteArray=stream.toByteArray();
                return byteArray;
            }
        });


    }*/


    }
