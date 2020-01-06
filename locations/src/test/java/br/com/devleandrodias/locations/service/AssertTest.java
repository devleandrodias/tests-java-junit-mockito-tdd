package br.com.devleandrodias.locations.service;

import org.junit.Assert;
import org.junit.Test;

import br.com.devleandrodias.locations.entity.User;

/**
 * AssertTest
 */
public class AssertTest {

  @Test
  public void test() {
    Assert.assertTrue(true);
    Assert.assertFalse(false);

    Assert.assertEquals(1, 1);
    Assert.assertEquals(0.51, 0.51, 0.1);

    int i = 5;
    Integer i2 = 5;

    Assert.assertEquals(Integer.valueOf(i), i2);

    Assert.assertEquals("object not match", "notebook", "notebook");
    Assert.assertNotEquals("notebook", "iPad");
    Assert.assertTrue("notebook".equalsIgnoreCase("NoteBook"));
    Assert.assertTrue("notebook".startsWith("note"));

    User user1 = new User("User 1");
    User user2 = new User("User 1");
    User user3 = user2;
    User user4 = null;

    Assert.assertEquals(user1, user2);
    Assert.assertSame(user2, user3);
    Assert.assertNotSame(user1, user2);
    Assert.assertNull(user4);
    Assert.assertNotNull(user3);
  }
}