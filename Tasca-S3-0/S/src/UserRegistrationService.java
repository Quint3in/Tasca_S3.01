public class UserRegistrationService {

    private final UserValidator uv;
    private final EmailService es;

    public UserRegistrationService() {
        uv = new UserValidator();
        es = new EmailService();
    }

    public void register(User user) {
        uv.validate(user);

        es.sendConfirmationEmail(user.getEmail());

        es.confirmEmail();
    }

}
