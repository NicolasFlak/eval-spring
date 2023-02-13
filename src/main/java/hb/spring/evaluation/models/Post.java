package hb.spring.evaluation.models;

import java.util.ArrayList;
import java.util.Date;

public class Post {

    private Integer id;
    private String title;
    private String content;
    private String creatorName;
    private Date creationDate;

    static ArrayList<Post> allPost = new ArrayList<Post>();

    public Post() {
    }

    public Post(Integer id, String title, String content) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public Post(Integer id, String title, String content, String creatorName, Date creationDate) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.creatorName = creatorName;
        this.creationDate = creationDate;
    }
    public static ArrayList<Post> getAllPost() {
        return allPost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
