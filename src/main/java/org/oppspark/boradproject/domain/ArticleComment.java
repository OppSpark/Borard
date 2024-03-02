package org.oppspark.boradproject.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@ToString
@Table(indexes = {
        @Index(columnList = "content"),
        @Index(columnList = "createAt"),
        @Index(columnList = "createdBy"),
})

@Entity
public class ArticleComment {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    @Setter
    @ManyToOne(optional = false)
    private Article article; //개시글 ID

    @Setter
    @Column(nullable = false, length = 500)
    private String content;  //내용

    @CreatedDate
    @Column(nullable = false)
    private LocalDateTime createAt;  //생성일시

    @CreatedBy
    @Column(nullable = false, length = 100)
    private String createdBy;  //생성자

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime modifiedAt;  //수정일자

    @LastModifiedDate
    @Column(nullable = false, length = 100)
    private String modifiedBy;  //수정자


    protected ArticleComment(){}
    private ArticleComment(Article article, String content){
    }
    public ArticleComment of(Article article, String content){
        return  new ArticleComment(article, content);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArticleComment that)) return false;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

