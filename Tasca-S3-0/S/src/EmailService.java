public class EmailService {

    public void sendConfirmationEmail(String email) {
        System.out.println("📧 Sending confirmation email to: " + email);
    }
    public void confirmEmail() {
        boolean userConfirmed = true;
        if (!userConfirmed) {
            System.out.println("⚠️ User did not confirm registration.");
        }
    }
}
