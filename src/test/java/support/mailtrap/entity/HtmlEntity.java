package support.mailtrap.entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HtmlEntity {

    public String html_body;

}
