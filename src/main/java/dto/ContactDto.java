package dto;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class ContactDto {
    private String id;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String address;
    private String description;
}
