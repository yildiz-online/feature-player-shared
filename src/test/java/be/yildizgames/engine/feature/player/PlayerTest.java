/*
 * This file is part of the Yildiz-Engine project, licenced under the MIT License  (MIT)
 *
 *  Copyright (c) 2019 Grégory Van den Borre
 *
 *  More infos available: https://engine.yildiz-games.be
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
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Grégory Van den Borre
 */
public final class PlayerTest {

    @Test
    public void testPlayer() {
        // FIXME exception when creating 2 identical players?
        Player p = new Player(PlayerId.valueOf(3), "aPlayer");
        assertEquals(p.id, PlayerId.valueOf(3));
        assertEquals("aPlayer", p.name);
        Assertions.assertThrows(AssertionError.class, () -> new Player(null, "aa"));
        Assertions.assertThrows(AssertionError.class, () -> new Player(PlayerId.valueOf(5), null));
    }

    @Test
    public void testGetId() {
        Player p = new Player(PlayerId.valueOf(1257552), "aName");
        assertEquals(PlayerId.valueOf(1257552), p.id);
        Assertions.assertNotSame(PlayerId.valueOf(487415774), p.id);
    }

    @Test
    public void testGetName() {
        Player p = new Player(PlayerId.valueOf(1257552), "aName");
        assertEquals("aName", p.name);
    }

    @Test
    public void testEqualsObject() {
        Player p2 = new Player(PlayerId.valueOf(4751), "odfhytuijh");
        Player p3 = new Player(PlayerId.valueOf(4751), "odfhytuijh");
        Player p = new Player(PlayerId.valueOf(1257552), "aName");
        Assertions.assertNotSame(p, p2);
        Assertions.assertNotSame(p2, p3);
        Assertions.assertNotSame(p2, null);
        Assertions.assertNotSame(p2, 5);
    }

    /***/
    @Test
    public void testToString() {
        Player p = new Player(PlayerId.valueOf(1257552), "aName");
        assertEquals("aName", p.toString());
    }
}
