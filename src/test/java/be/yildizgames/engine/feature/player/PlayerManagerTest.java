/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2018 Grégory Van den Borre
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

import be.yildizgames.common.model.PlayerId;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Grégory Van den Borre
 */
class PlayerManagerTest {

    @BeforeAll
    static void init() {
        PlayerManager.getInstance().createPlayer(PlayerId.valueOf(1), "player1");
    }

    @Nested
    class FindFromId {

        @Test
        void happyFlow() {
            Player p = PlayerManager.getInstance().findFromId(PlayerId.valueOf(1));
            assertEquals(PlayerId.valueOf(1), p.id);
            assertEquals("player1", p.name);
        }

        @Test
        void notFound() {
            Player p = PlayerManager.getInstance().findFromId(PlayerId.valueOf(2));
            assertEquals(Player.WORLD, p);
        }

    }

    @Nested
    class GetFromId {

        @Test
        void happyFlow() {
            Player p = PlayerManager.getInstance().getFromId(PlayerId.valueOf(1));
            assertEquals(PlayerId.valueOf(1), p.id);
            assertEquals("player1", p.name);
        }

        @Test
        void notFound() {
            assertThrows(PlayerManager.PlayerNotFoundException.class,
                    () -> PlayerManager.getInstance().getFromId(PlayerId.valueOf(2)));
        }

    }

    @Nested
    class GetFromName {

        @Test
        void happyFlow() {
            Player p = PlayerManager.getInstance().getFromName("player1");
            assertEquals(PlayerId.valueOf(1), p.id);
            assertEquals("player1", p.name);
        }

        @Test
        void notFound() {
            assertThrows(PlayerManager.PlayerNotFoundException.class,
                    () -> PlayerManager.getInstance().getFromName("player2"));
        }

    }

}