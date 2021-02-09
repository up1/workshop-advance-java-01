package badcode;

import java.util.Arrays;

public class RegisterBusiness {

    public Integer register(SpeakerRepository repository, Speaker speaker) {
        // 1. Validate Register Data
        validateRegisterData(speaker);
        // 2. Save Speaker
        Integer speakerId = repository.saveSpeaker(speaker);
        // 3. Return speaker id
        return speakerId;
    }

    private void validateRegisterData(Speaker speaker) {
        // Fail fast
        if (isNullOrEmpty(speaker.getFirstName())) {
            throw new ArgumentNullException("First name is required.");
        }
        if (isNullOrEmpty(speaker.getLastName())) {
            throw new ArgumentNullException("Last name is required.");
        }
        if (isNullOrEmpty(speaker.getEmail())) {
            throw new ArgumentNullException("Email is required.");
        }

        String[] domains = {"gmail.com", "live.com"};
        String emailDomain = getEmailDomain(speaker.getEmail());
        if (Arrays.stream(domains).filter(it -> it.equals(emailDomain)).count() == 0) {
            throw new SpeakerDoesntMeetRequirementsException("Speaker doesn't meet our standard rules.");
        }

    }

    private boolean isNullOrEmpty(String input) {
        return input == null
                || input.trim().equals("");
    }

    int getFee(int exp) {
        int fee = 0;
        if (exp <= 1) {
            fee = 500;
        } else if (exp <= 3) {
            fee = 250;
        } else if (exp <= 5) {
            fee = 100;
        } else if (exp <= 9) {
            fee = 50;
        }
        return fee;
    }

    public String getEmailDomain(String email) {
        String[] inputs = email.trim().split("@");
        if (inputs.length == 2) return inputs[1];
        throw new DomainEmailInvalidException();
    }

}
