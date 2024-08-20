package com.manolevski.stereometrycalculator.ui;

import static com.manolevski.stereometrycalculator.utils.Constants.SHAPE_TYPE_KEY;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.manolevski.stereometrycalculator.R;
import com.manolevski.stereometrycalculator.models.ShapeType;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = new Intent(this, ShapeActivity.class);
        findViewById(R.id.button_cube).setOnClickListener(view -> {
                intent.putExtra(SHAPE_TYPE_KEY, ShapeType.CUBE);
                startActivity(intent);
        });
        findViewById(R.id.button_cuboid).setOnClickListener(view -> {
            intent.putExtra(SHAPE_TYPE_KEY, ShapeType.CUBOID);
            startActivity(intent);
        });
        findViewById(R.id.button_pyramid).setOnClickListener(view -> {
            intent.putExtra(SHAPE_TYPE_KEY, ShapeType.PYRAMID);
            startActivity(intent);
        });
        findViewById(R.id.button_cylinder).setOnClickListener(view -> {
            intent.putExtra(SHAPE_TYPE_KEY, ShapeType.CYLINDER);
            startActivity(intent);
        });
        findViewById(R.id.button_cone).setOnClickListener(view -> {
            intent.putExtra(SHAPE_TYPE_KEY, ShapeType.CONE);
            startActivity(intent);
        });
        findViewById(R.id.button_sphere).setOnClickListener(view -> {
            intent.putExtra(SHAPE_TYPE_KEY, ShapeType.SPHERE);
            startActivity(intent);
        });
    }
}
