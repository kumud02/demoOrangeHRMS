package entities;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

@Data
@Jacksonized
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonFilter(User.FILTER_NAME)
@SuperBuilder(toBuilder = true)
public class User {
    public static final String FILTER_NAME = "User";

    private String email;
    @Builder.Default private String password="Toggle@123";
    @Builder.Default private String confirmPassword="Toggle@123";
    @Builder.Default private String phoneNumber="9898989898";
    @Builder.Default private String nameOfPublisher = "test publisher";
    @Builder.Default private String nameOfSchool = "test school";
    @Builder.Default private String userType = "School Admin";
    private String municipality;
    @Builder.Default private String wardNumber = "01";
    @Builder.Default private String localAddress = "local address";
    @Builder.Default private String PANNumber = "909090909";
    @Builder.Default private String VATNumber = "101010101";
    @Builder.Default private String schoolID = "121213131";

    @ToString.Exclude
//    @JsonIgnore private String password;
    @Builder.Default private String firstName = "Suresh";
    @Builder.Default private String lastName = "Heroes";




    public String buildFirstLastName() {
        return getFirstName() + " " + getLastName();
    }
}
