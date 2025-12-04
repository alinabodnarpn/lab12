package visitor.test;

import org.junit.jupiter.api.Test;
import com.example.visitor.Group;
import com.example.visitor.Signature;

import static org.junit.jupiter.api.Assertions.*;

public class GroupStampingTest {

    @Test
    public void testGroupStampsSignatures() {
        Group<Integer> group = new Group<>();
        Signature<Integer> s1 = new Signature<>(x -> {});
        Signature<Integer> s2 = new Signature<>(x -> {});

        group.addTask(s1).addTask(s2);
        group.apply(10);

        assertNotNull(s1.getHeader("group_id"));
        assertEquals("0", s1.getHeader("group_index"));

        assertNotNull(s2.getHeader("group_id"));
        assertEquals("1", s2.getHeader("group_index"));

        // Both should have same group_id
        assertEquals(s1.getHeader("group_id"), s2.getHeader("group_id"));
    }
}
