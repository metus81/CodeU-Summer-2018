// Copyright 2017 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package codeu.model.data;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class UserTest {

  @Test
  public void testCreate() {
    UUID id = UUID.randomUUID();
    String name = "test_username";
    String passwordHash = "$2a$10$bBiLUAVmUFK6Iwg5rmpBUOIBW6rIMhU1eKfi3KR60V9UXaYTwPfHy";
    Instant creation = Instant.now();
    String aboutMe = "aboutMe";

    User user = new User(id, name, passwordHash, creation, aboutMe);

    Assert.assertEquals(id, user.getId());
    Assert.assertEquals(name, user.getName());
    Assert.assertEquals(passwordHash, user.getPasswordHash());
    Assert.assertEquals(creation, user.getCreationTime());
    Assert.assertEquals(aboutMe, user.getAboutMe());
  }
  
  @Test
  public void testCompareTo() {
	User user = new User(UUID.randomUUID(), "test", "$2a$10$bBiLUAVmUFK6Iwg5r", Instant.now(), "about me");
    //Since Conversation and User both implement Activity, we test the compareTo method
    Conversation conversation = new Conversation(UUID.randomUUID(), UUID.randomUUID(), "Test", Instant.now().plusSeconds(2), true);
    Assert.assertEquals(-1, user.compareTo(conversation));
  }
  
  @Test
  public void testAddConversation() {
	User user = new User(UUID.randomUUID(), "test", "$2a$10$bBiLUAVmUFK6Iwg5r", Instant.now(), "about me");
	Assert.assertTrue(user.getConversations().isEmpty());
    Conversation conversation = new Conversation(UUID.randomUUID(), UUID.randomUUID(), "Test", Instant.now(), true);
    user.addConversation(conversation.getId());
    List<UUID> convos = new ArrayList<UUID>();
    convos.add(conversation.getId());
    Assert.assertEquals(user.getConversations(), convos);
  }
  
  @Test
  public void testSetConversations() {
	User user = new User(UUID.randomUUID(), "test", "$2a$10$bBiLUAVmUFK6Iwg5r", Instant.now(), "about me");
	Assert.assertTrue(user.getConversations().isEmpty());
	Conversation conversation = new Conversation(UUID.randomUUID(), UUID.randomUUID(), "Test", Instant.now(), true);
	List<UUID> convos = new ArrayList<UUID>();
	convos.add(conversation.getId());
	user.setConversations(convos);
	Assert.assertEquals(user.getConversations(), convos);
  }
}
