package apple.example.com.mvp_design_pattern.View;

public interface ILoginView {

    void onLoginSuccess(String message);
    void onLoginError(String message);
}
