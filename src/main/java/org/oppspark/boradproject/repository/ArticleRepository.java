package org.oppspark.boradproject.repository;

import org.oppspark.boradproject.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}