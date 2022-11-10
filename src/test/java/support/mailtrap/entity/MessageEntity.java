package support.mailtrap.entity;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageEntity {

    public String subject;
    public String from_email;
    public String from_name;
    public String to_name;
    public String id;

}
