package pojo;

import lombok.Data;

@Data
public class CommentsPlaceholder {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;
}
