package life.wmm.commulity.community.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GithubUser {
    private Long id;
    private String name;
    private String bio;
    private String avatar_url;
}
