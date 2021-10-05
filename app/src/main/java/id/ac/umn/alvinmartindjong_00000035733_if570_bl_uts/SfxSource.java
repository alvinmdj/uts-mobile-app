package id.ac.umn.alvinmartindjong_00000035733_if570_bl_uts;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class SfxSource implements Serializable {
    private String title;
    private String description;
    private String uri;

    public SfxSource(String title, String description, String uri) {
        this.title = title;
        this.description = description;
        this.uri = uri;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public String getUri() {
        return this.uri;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @NonNull
    public String toString() {
        return this.getTitle() + "=>" + this.getDescription();
    }
}
