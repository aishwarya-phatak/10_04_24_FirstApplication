package in.bitcode.firstapplication;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    LinearLayout mainContainer;
    TextView welcomeTextView;
    EditText usernameEditText;
    Button btnClick;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);

        mainContainer = new LinearLayout(this);
        mainContainer.setPadding(10,10,10,10);
        mainContainer.setOrientation(LinearLayout.VERTICAL);
        mainContainer.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);

        ViewGroup.LayoutParams layoutParamsForMainContainer = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );

        mainContainer.setLayoutParams(layoutParamsForMainContainer);

        welcomeTextView = new TextView(this);
        welcomeTextView.setText("Welcome To Bitcode!");
        welcomeTextView.setBackgroundColor(Color.MAGENTA);
        welcomeTextView.setTextColor(Color.WHITE);
        welcomeTextView.setTextSize(20.0F);
        welcomeTextView.setPadding(10,10,10,10);

        ViewGroup.LayoutParams layoutParamsForSubViews = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        welcomeTextView.setLayoutParams(layoutParamsForSubViews);
        mainContainer.addView(welcomeTextView);

        usernameEditText = new EditText(this);
        usernameEditText.setHint("Enter username");
        usernameEditText.setTextSize(30.0F);

        usernameEditText.setLayoutParams(layoutParamsForSubViews);
        mainContainer.addView(usernameEditText);

        btnClick = new Button(this);
        btnClick.setText("Submit");
        btnClick.setTextSize(20.0F);
        btnClick.setTextColor(Color.RED);
        btnClick.setBackgroundColor(R.color.green);

        btnClick.setLayoutParams(layoutParamsForSubViews);
        mainContainer.addView(btnClick);

        setContentView(mainContainer);

        //way 1 -- of attaching listener to views
        btnClick.setOnClickListener(new BtnClickListener());
        welcomeTextView.setOnClickListener(new TxtViewClickListener());

        //way 2
        View.OnClickListener listener = new MyViewClickListener();
        btnClick.setOnClickListener(listener);
        welcomeTextView.setOnClickListener(listener);

        //way 3
        btnClick.setOnClickListener(this);
    }

    //way 3
    @Override
    public void onClick(View view) {
        if (view == btnClick){
            welcomeTextView.setText("welcome " + usernameEditText.getText().toString());
        }
    }

    class MyViewClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if (view == btnClick){
                welcomeTextView.setText("Welcome " + usernameEditText.getText().toString());
            } else  {
                welcomeTextView.setText("");
            }
        }
    }

    class BtnClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if (view == btnClick){
                welcomeTextView.setText(usernameEditText.getText().toString());
            }
        }
    }

    class TxtViewClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            welcomeTextView.setText("Android Batch");
        }
    }
}