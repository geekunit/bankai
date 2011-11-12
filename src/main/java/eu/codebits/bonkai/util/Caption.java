package eu.codebits.bonkai.util;

import java.util.List;

/**
 *
 * @author bmfurtado
 */
public class Caption {
    private Integer number;
    private String timecodes;
    private List<String> text;

    public Caption (Integer number, String timecodes, List<String> text) {
        this.number = number;
        this.timecodes = timecodes;
        this.text = text;
    }

    public Integer getNumber() {
        return number;
    }

    public void setId(Integer id) {
        this.number = number;
    }

    public String getTimecodes() {
        return timecodes;
    }

    public void setTimecodes(String timecodes) {
        this.timecodes = timecodes;
    }

    public List<String> getText() {
        return text;
    }

    public void setText(List<String> text) {
        this.text = text;
    }
}
