// Download the twilio-java library from http://twilio.com/docs/libraries
import java.util.Map;
import java.util.HashMap;

import com.twilio.sdk.resource.instance.Account;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class SmsSender {

    /* Find your sid and token at twilio.com/user/account */
    public static final String ACCOUNT_SID = "ACca4f7d564ff760a6c0d6b6444214feb8";
    public static final String AUTH_TOKEN = "97fa04ae3a1c30ee36b25f8b1ec0990e";

    public static void main(String[] args) throws TwilioRestException {

        TwilioRestClient client = new TwilioRestClient(ACCOUNT_SID, AUTH_TOKEN);

        Account account = client.getAccount();

        MessageFactory messageFactory = account.getMessageFactory();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("To", "+")); // Replace with a valid phone number for your account.
        params.add(new BasicNameValuePair("From", "+17148729100")); // Replace with a valid phone number for your account.
        params.add(new BasicNameValuePair("Body", "Where's Wallace?"));
        Message sms = messageFactory.create(params);
    }
}