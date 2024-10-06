package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    private EditText txtInput;
    private Spinner spinnerOptions;
    private Button btnCount;
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtInput = findViewById(R.id.txtInput);
        spinnerOptions = findViewById(R.id.spinnerOptions);
        btnCount = findViewById(R.id.btnCount);
        txtResult = findViewById(R.id.txtResult);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.count_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOptions.setAdapter(adapter);

        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = txtInput.getText().toString().trim();

                if (input.isEmpty()) {
                    Toast.makeText(MainActivity.this, R.string.empty_input_warning, Toast.LENGTH_SHORT).show();
                    return;
                }

                String selectedOption = spinnerOptions.getSelectedItem().toString();
                int result = 0;

                if (selectedOption.equals("Words")) {
                    result = Counter.countWords(input);
                } else if (selectedOption.equals("Characters")) {
                    result = Counter.countCharacters(input);
                }

                txtResult.setText(String.valueOf(result));
            }
        });
    }
}
