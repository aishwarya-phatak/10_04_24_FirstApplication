package in.bitcode.firstapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class HomeActivity extends Activity {
    LinearLayout linearLayout;
    TextView txtWelcomeMessage;
    ImageView imageView;
    EditText edtUsername;
    Button btnClick;

    int currentIndex = 0;
    int [] flagImages = {R.drawable.flag,R.drawable.flag1};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initializeViews();
        initializeListeners();
    }

    private void initializeViews() {
        linearLayout = findViewById(R.id.linearLayout);
        txtWelcomeMessage = findViewById(R.id.txtWelcomeMessage);
        imageView = findViewById(R.id.imgFlag);
        imageView.setImageResource(flagImages[currentIndex]);
        edtUsername = findViewById(R.id.edtUsername);
        btnClick = findViewById(R.id.btnClick);
    }

    private void initializeListeners() {
        btnClick.setOnClickListener(new BtnClickListener());
        imageView.setOnClickListener(new MyImageViewClickListener());
    }

    class MyImageViewClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            currentIndex = ++currentIndex % flagImages.length;
            imageView.setImageResource(flagImages[currentIndex]);
        }
    }

    class BtnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view == btnClick) {
                if (edtUsername.getText().toString().equals("Bitcode")) {
                    txtWelcomeMessage.setText(edtUsername.getText().toString() + "Welcomes You!");
                } else {
                    txtWelcomeMessage.setText(R.string.welcome);
                }
            }
        }
    }
}