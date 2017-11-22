/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2017 Grégory Van den Borre
 *
 *  More infos available: https://www.yildiz-games.be
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 *  documentation files (the "Software"), to deal in the Software without restriction, including without
 *  limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 *  of the Software, and to permit persons to whom the Software is furnished to do so,
 *  subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all copies or substantial
 *  portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 *  WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 *  OR COPYRIGHT  HOLDERS BE LIABLE FOR ANY CLAIM,
 *  DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE  SOFTWARE.
 *
 */

package be.yildizgames.engine.feature.player;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Grégory Van den Borre
 */
public class PlayerToCreate {

    private final Logger logger = LoggerFactory.getLogger(PlayerToCreate.class);

    private final String login;

    private final String password;

    private final String email;

    public PlayerToCreate(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
        assert this.invariant();
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    private boolean invariant() {
        if(login == null || login.isEmpty()) {
            logger.error("Login cannot be null or empty.");
            return false;
        }
        if(password == null || password.isEmpty()) {
            logger.error("Password cannot be null or empty.");
            return false;
        }
        if(email == null || email.isEmpty()) {
            logger.error("Email cannot be null or empty.");
            return false;
        }
        return true;
    }
}
