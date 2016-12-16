package io.github.changjiashuai.template.domain.entity;

/**
 * Email: changjiashuai@gmail.com
 *
 * Created by CJS on 2016/12/14 10:08.
 */

public class Welcome {

    private String text;
    private String imageUrl;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
