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
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;

public class ConversationTest {

  @Test
  public void testCreate() {
    UUID id = UUID.randomUUID();
    UUID owner = UUID.randomUUID();
    String title = "Test_Title";
    Instant creation = Instant.now();
    boolean isPublic = true;

    Conversation conversation = new Conversation(id, owner, title, creation, isPublic);

    Assert.assertEquals(id, conversation.getId());
    Assert.assertEquals(owner, conversation.getOwnerId());
    Assert.assertEquals(title, conversation.getTitle());
    Assert.assertEquals(creation, conversation.getCreationTime());
 //   Assert.assertEquals(isPublic, conversation.getIsPublic());
  
  }
  
  @Test
  public void testCompareTo() {
	Conversation conversation = new Conversation(UUID.randomUUID(), UUID.randomUUID(), "Test", Instant.now(), true);
    //Since Conversation and Message both implement Activity, we test the compareTo method
    Message message = new Message(UUID.randomUUID(), UUID.randomUUID(), UUID.randomUUID(), "test", Instant.now().plusSeconds(2));
    Assert.assertEquals(-1, conversation.compareTo(message));
	  
  }
}
