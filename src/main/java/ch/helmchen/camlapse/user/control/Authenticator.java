/*
 * File: Authenticator.java, created at 06.04.2012
 * $Id$
 * Copyright 2012 Helmut Gehrer <helmut.gehrer@helmchen.ch>
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.helmchen.camlapse.user.control;

import ch.helmchen.camlapse.MetaInfo;
import ch.helmchen.camlapse.user.entities.UserBean;

import java.net.MalformedURLException;
import java.net.URL;

import org.scribe.builder.ServiceBuilder;
import org.scribe.builder.api.TwitterApi;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import org.slf4j.LoggerFactory;

/**
 * @todo Klasse Authenticator dokumentieren.
 *
 * @author Helmut Gehrer <helmut.gehrer@helmchen.ch>
 * @since 06.04.2012
 */
public class Authenticator {
    private OAuthService authService = null;
    private Token requestToken = null;

    public Authenticator(String aTwitterApiKey, String aTwitterApiSecret) {
        ServiceBuilder sb = new ServiceBuilder().provider(TwitterApi.class);
        authService = sb.apiKey(aTwitterApiKey).apiSecret(aTwitterApiSecret).build();
        requestToken = authService.getRequestToken();
        if (authService != null) {
            LoggerFactory.getLogger(Authenticator.class).debug(MetaInfo.SECURITY, 
                    MetaInfo.buildMessage(MetaInfo.SECURITY, "authServiceCreated"));
        }
    }

    public URL getAuthenticationUrl() throws MalformedURLException {
        String authUrl = authService.getAuthorizationUrl(requestToken);
            LoggerFactory.getLogger(Authenticator.class).debug(MetaInfo.SECURITY, 
                    MetaInfo.buildMessage(MetaInfo.SECURITY, "gotAuthenticationUrl", authUrl));
        return new URL(authUrl);
    }

    public UserBean verifyAuthentication(String aToken) {
            LoggerFactory.getLogger(Authenticator.class).debug(MetaInfo.SECURITY, 
                    MetaInfo.buildMessage(MetaInfo.SECURITY, "verifyingAuthentication"));        
        Verifier verifier = new Verifier(aToken);
        Token accessToken = authService.getAccessToken(requestToken, verifier);
        OAuthRequest request = new OAuthRequest(Verb.GET, "http://api.twitter.com/1/account/verify_credentials.xml");
        authService.signRequest(accessToken, request);
        Response response = request.send();
        System.out.println(response.getBody());
        
        return null;
    }
}
