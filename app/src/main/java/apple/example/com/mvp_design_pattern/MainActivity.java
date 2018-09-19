package apple.example.com.mvp_design_pattern;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import apple.example.com.mvp_design_pattern.Presenter.ILoginPresenter;
import apple.example.com.mvp_design_pattern.Presenter.LoginPresenter;
import apple.example.com.mvp_design_pattern.View.ILoginView;
import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements ILoginView {

    EditText edt_email;
    EditText edt_password;
    Button btnLogin;

    ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init View

        btnLogin = (Button) findViewById(R.id.btnLogin);
        edt_email = (EditText) findViewById(R.id.edit_mail);
        edt_password = (EditText) findViewById(R.id.edit_password);

        //Init
        loginPresenter = new LoginPresenter(this);

        //Event
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.onLogin(edt_email.getText().toString(), edt_password.getText().toString());
            }
        });
    }

    @Override
    public void onLoginSuccess(String message) {
        Toasty.success(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(String message) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show();
    }
}
