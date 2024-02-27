package mobile.services;

import mobile.po.ArticlePage;

import java.io.File;

public class ArticleService {
    private final ArticlePage articlePage = new ArticlePage();

    public String getArticleName() {
        return articlePage
                .clickFirstArticle()
                .getArticleName();
    }

    public void getPicture(String fileName) {
        if (pictureExists(fileName)) {
            File f = new File(fileName);
            boolean deleted = f.delete();
            if (!deleted) {
                throw new RuntimeException("Can not delete file");
            }
        }
        articlePage.getPicture(fileName);
    }

    public boolean pictureExists(String fileName) {
        File f = new File(fileName);
        return f.exists();
    }
}
