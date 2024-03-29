package library.demo.model;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "books")
public class Book {
    @Id
    private String id;
    private String kind;
    private String fullSortKey;
    @Indexed(unique = true)
    @NotNull
    private String title;
    private String url;
    private String coverColor;
    @NotNull
    private String author;
    private String cover;
    private String epoch;
    private String href;
    private boolean hasAudio;
    private String genre;

    @Field("simple_thumb")
    private String simpleThumb;
    private String slug;
    private String coverThumb;

    @DocumentReference
    private List<Review> reviews;


    public Book(ObjectId id, String kind, String title, String author, String cover, String epoch, boolean hasAudio, String genre, String simpleThumb) {
        this.id = id.toHexString();
        this.kind = kind;
        this.title = title;
        this.author = author;
        this.cover = cover;
        this.epoch = epoch;
        this.hasAudio = hasAudio;
        this.genre = genre;
        this.simpleThumb = simpleThumb;
    }
}
