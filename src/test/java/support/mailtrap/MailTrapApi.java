package support.mailtrap;

import support.http.Http;
import support.mailtrap.entity.MessageEntity;

import java.util.HashMap;
import java.util.Map;

public class MailTrapApi {

    private String apiToken;
    private String inboxId;
    private String accountId;

    public MailTrapApi(String apiToken, String accountId, String inboxId) {
        this.apiToken = apiToken;
        this.inboxId = inboxId;
        this.accountId = accountId;
    }

    public MessageEntity[] searchMessage(String term) throws Exception {

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "Bearer " + this.apiToken);
        String endpoint = "https://mailtrap.io/api/accounts/"+accountId+"/inboxes/"+inboxId+"/messages?search="+term;
        return (MessageEntity[]) Http.Get(endpoint,MessageEntity[].class,headers);
    }
    public String getHtmlBody(String id) throws Exception {

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "Bearer " + this.apiToken);
        String endpoint = "https://mailtrap.io/api/accounts/"+accountId+"/inboxes/"+inboxId+"/messages/"+id+"/body.html";
        return (String) Http.Get(endpoint,String.class,headers);
    }
    public MessageEntity deleteMessage(String id) throws Exception {

        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "Bearer " + this.apiToken);
        String endpoint = "https://mailtrap.io/api/accounts/"+accountId+"/inboxes/"+inboxId+"/messages/"+id;
        return (MessageEntity) Http.Delete(endpoint,MessageEntity.class,headers);
    }

}
