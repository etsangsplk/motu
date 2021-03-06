/* 
 * Motu, a high efficient, robust and Standard compliant Web Server for Geographic
 * Data Dissemination.
 *
 * http://cls-motu.sourceforge.net/
 *
 * (C) Copyright 2009-2010, by CLS (Collecte Localisation Satellites) - 
 * http://www.cls.fr - and  Contributors
 *
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.
 */
package fr.cls.atoll.motu.library.cas;

import fr.cls.atoll.motu.api.message.AuthenticationMode;
import fr.cls.atoll.motu.library.cas.exception.MotuCasException;
import fr.cls.atoll.motu.library.cas.util.RestUtil;

/**
 * User class.
 * 
 * (C) Copyright 2009-2010, by CLS (Collecte Localisation Satellites)
 * 
 * @version $Revision: 1.1 $ - $Date: 2009-03-18 12:18:22 $
 * @author <a href="mailto:dearith@cls.fr">Didier Earith</a>
 */
public class UserBase {

    /** The cas authentication. */
    private AuthenticationMode authenticationMode = AuthenticationMode.NONE;

    /**
     * FirstName of the user.
     * 
     * @uml.property name="firstName"
     */
    private String firstName;

    /**
     * LastName of the user.
     * 
     * @uml.property name="lastName"
     */
    private String lastName;

    /**
     * Email adress of the user.
     * 
     * @uml.property name="email"
     */
    private String email;

    /** Is it an anonymous user. */
    private boolean anonymousUser;

    /** The login. */
    private String login;

    /** The pwd. */
    private String pwd;

    /** The cas rest suff url. */
    protected String casRestSuffURL;

    /** The cas url. */
    protected String casURL;

    /**
     * Default constructor.
     */
    public UserBase() {
        firstName = "";
        lastName = "";
        email = "";
        anonymousUser = true;
        login = "";
        pwd = "";
    }

    /**
     * Getter of the property <tt>firstName</tt>.
     * 
     * @return Returns the firstName.
     * @uml.property name="firstName"
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Setter of the property <tt>firstName</tt>.
     * 
     * @param firstName The firstName to set.
     * @uml.property name="firstName"
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Getter of the property <tt>lastName</tt>.
     * 
     * @return Returns the lastName.
     * @uml.property name="lastName"
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Setter of the property <tt>lastName</tt>.
     * 
     * @param lastName The lastName to set.
     * @uml.property name="lastName"
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter of the property <tt>email</tt>.
     * 
     * @return Returns the email.
     * @uml.property name="email"
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Setter of the property <tt>email</tt>.
     * 
     * @param email The email to set.
     * @uml.property name="email"
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Checks if is anonymous user.
     * 
     * @return true, if is anonymous user
     */
    public boolean isAnonymousUser() {
        return anonymousUser;
    }

    /**
     * Sets the anonymous user.
     * 
     * @param anonymousUser the anonymous user
     */
    public void setAnonymousUser(boolean anonymousUser) {
        this.anonymousUser = anonymousUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login != null) {
            this.login = login;
        } else {
            this.login = "";
        }
    }

    /**
     * Gets the pwd.
     * 
     * @return the pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * Sets the pwd.
     * 
     * @param pwd the new pwd
     */
    public void setPwd(String pwd) {
        if (pwd != null) {
            this.pwd = pwd;
        }
    }

    /**
     * Gets the authentication mode.
     * 
     * @return the authentication mode
     */
    public AuthenticationMode getAuthenticationMode() {
        return authenticationMode;
    }

    /**
     * Sets the authentication mode.
     * 
     * @param authenticationMode the new authentication mode
     */
    public void setAuthenticationMode(AuthenticationMode authenticationMode) {
        if (authenticationMode != null) {
            this.authenticationMode = authenticationMode;
        } else {
            this.authenticationMode = AuthenticationMode.NONE;
        }
    }

    /**
     * Sets the authentication mode.
     *
     * @param authenticationMode the new authentication mode
     * @throws MotuCasException the motu exception
     */
    public void setAuthenticationMode(String authenticationMode) throws MotuCasException {

        if (RestUtil.isNullOrEmpty(authenticationMode)) {
            this.authenticationMode = AuthenticationMode.NONE;
            return;
        }

        try {
            this.authenticationMode = AuthenticationMode.fromValue(authenticationMode);
        } catch (Exception e) {
            throw new MotuCasException(
                    String.format("Invalid authentication mode '%s'. Valid values are: %s",
                                  authenticationMode,
                                  AuthenticationMode.getAvailableValues()));
        }
    }

    /**
     * Checks if is basic authentication.
     *
     * @return true, if is basic authentication
     */
    public boolean isBasicAuthentication() {
        return this.authenticationMode.equals(AuthenticationMode.BASIC);
    }

    /**
     * Checks if is cas authentication.
     * 
     * @return true, if is cas authentication
     */
    public boolean isCASAuthentication() {
        return this.authenticationMode.equals(AuthenticationMode.CAS);
    }

    /**
     * Checks if is none authentication.
     * 
     * @return true, if is none authentication
     */
    public boolean isNoneAuthentication() {
        return this.authenticationMode.equals(AuthenticationMode.NONE);
    }

    /**
     * Checks if is authentication.
     * 
     * @return true, if is authentication
     */
    public boolean isAuthentication() {
        return !isNoneAuthentication();
    }

    public void setCASAuthentication(boolean casAuthentication) {
        this.authenticationMode = casAuthentication ? AuthenticationMode.CAS : AuthenticationMode.NONE;
    }

    /**
     * Gets the cas rest suff url.
     *
     * @return the cas rest suff url
     * @throws MotuCasException the motu cas exception
     */
    public String getCasRestSuffURL() throws MotuCasException {

        return casRestSuffURL;
    }

    /**
     * Sets the cas rest suff url.
     * 
     * @param casRestSuffURL the new cas rest suff url
     */
    public void setCasRestSuffURL(String casRestSuffURL) {
        this.casRestSuffURL = casRestSuffURL;
    }

    /**
     * Gets the cas url.
     *
     * @return the cas url
     */
    public String getCasURL() {
        return casURL;
    }

    /**
     * Sets the cas url.
     *
     * @param casURL the new cas url
     */
    public void setCasURL(String casURL) {
        this.casURL = casURL;
    }

}
