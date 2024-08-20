package com.manolevski.stereometrycalculator.ui;

import static com.manolevski.stereometrycalculator.utils.Constants.SHAPE_TYPE_KEY;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.manolevski.stereometrycalculator.R;
import com.manolevski.stereometrycalculator.models.Cone;
import com.manolevski.stereometrycalculator.models.Cube;
import com.manolevski.stereometrycalculator.models.Cuboid;
import com.manolevski.stereometrycalculator.models.Cylinder;
import com.manolevski.stereometrycalculator.models.Pyramid;
import com.manolevski.stereometrycalculator.models.Shape;
import com.manolevski.stereometrycalculator.models.ShapeType;
import com.manolevski.stereometrycalculator.models.Sphere;

public class ShapeActivity extends AppCompatActivity {

    Shape shape;
    TextInputLayout measure1Layout;
    TextInputLayout measure2Layout;
    TextInputLayout measure3Layout;
    TextInputEditText measure1Input;
    TextInputEditText measure2Input;
    TextInputEditText measure3Input;
    AppCompatTextView volumeText;
    AppCompatTextView areaText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape);
        ShapeType shapeType = (ShapeType) getIntent().getSerializableExtra(SHAPE_TYPE_KEY);

        measure1Layout = findViewById(R.id.measure1_input_layout);
        measure2Layout = findViewById(R.id.measure2_input_layout);
        measure3Layout = findViewById(R.id.measure3_input_layout);
        measure1Input = findViewById(R.id.measure1_input);
        measure2Input = findViewById(R.id.measure2_input);
        measure3Input = findViewById(R.id.measure3_input);
        volumeText = findViewById(R.id.volume_text);
        areaText = findViewById(R.id.area_text);

        if (shapeType != null) {
            setTitle(getString(shapeType.getResourceId()));
            initShape(shapeType);
            initUi();
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void initShape(ShapeType type) {
        switch (type) {
            case CUBE:
                shape = new Cube(type, R.drawable.cube);
                shape.setMeasure1Name("a");
                break;
            case CUBOID:
                shape = new Cuboid(type, R.drawable.cuboid);
                shape.setMeasure1Name("a");
                shape.setMeasure2Name("b");
                shape.setMeasure3Name("c");
                break;
            case PYRAMID:
                shape = new Pyramid(type, R.drawable.pyramid);
                shape.setMeasure1Name("a");
                shape.setMeasure2Name("h");
                break;
            case CYLINDER:
                shape = new Cylinder(type, R.drawable.cylinder);
                shape.setMeasure1Name("r");
                shape.setMeasure2Name("h");
                break;
            case CONE:
                shape = new Cone(type, R.drawable.cone);
                shape.setMeasure1Name("r");
                shape.setMeasure2Name("h");
                break;
            case SPHERE:
                shape = new Sphere(type, R.drawable.sphere);
                shape.setMeasure1Name("r");
                break;
        }
    }

    private void initUi() {
        if (shape == null) {
            return;
        }
        AppCompatImageView imageView = findViewById(R.id.shape_image);
        imageView.setImageDrawable(AppCompatResources
                .getDrawable(this, shape.getImageResourceId()));

        if(shape.getMeasure1Name() != null) {
            measure1Layout.setVisibility(View.VISIBLE);
            measure1Layout.setHint(shape.getMeasure1Name());
        }
        if(shape.getMeasure2Name() != null) {
            measure2Layout.setVisibility(View.VISIBLE);
            measure2Layout.setHint(shape.getMeasure2Name());
        }
        if(shape.getMeasure3Name() != null) {
            measure3Layout.setVisibility(View.VISIBLE);
            measure3Layout.setHint(shape.getMeasure3Name());
        }

        measure1Input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Not used
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    volumeText.setVisibility(View.GONE);
                    areaText.setVisibility(View.GONE);
                    return;
                }
                if (shape != null) {
                    shape.setMeasure1(Double.parseDouble(s.toString()));
                    calculateResult();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                //Not used
            }
        });

        measure2Input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Not used
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    volumeText.setVisibility(View.GONE);
                    areaText.setVisibility(View.GONE);
                    return;
                }
                if (shape != null) {
                    shape.setMeasure2(Double.parseDouble(s.toString()));
                    calculateResult();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                //Not used
            }
        });

        measure3Input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Not used
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 0) {
                    volumeText.setVisibility(View.GONE);
                    areaText.setVisibility(View.GONE);
                    return;
                }
                if (shape != null) {
                    shape.setMeasure3(Double.parseDouble(s.toString()));
                    calculateResult();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                //Not used
            }
        });
    }

    private void calculateResult() {
        if (shape != null) {
            shape.calculateVolume();
            shape.calculateSurfaceArea();
            showResult();
        }
    }

    private void showResult() {
        if (shape.getVolume() > 0) {
            volumeText.setVisibility(View.VISIBLE);
            volumeText.setText(getString(R.string.volume_placeholder, shape.getVolume()));
        }

        if (shape.getSurfaceArea() > 0) {
            areaText.setVisibility(View.VISIBLE);
            areaText.setText(getString(R.string.area_placeholder, shape.getSurfaceArea()));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
