import edu.nju.software.ast.*;
import edu.nju.software.eval.Evaluator;
import edu.nju.software.stream.CharLookaheadStream;
import edu.nju.software.token.Lexer;
import org.junit.Assert;
import org.junit.Test;

public class EvalAndAtomTest {
    private void testFor(String input, LObject output) {
        Assert.assertEquals(output, Evaluator.eval(Parser.parse(Lexer.lex(new CharLookaheadStream(input)))));
    }

    @Test
    public void testReadString() {
        testFor("(read-string \"(+ 1 2)\")", new LList(new LSymbol("+"), new LInteger(1), new LInteger(2)));
    }

    @Test
    public void testEval() {
        testFor("(eval (read-string \"(+ 1 2)\"))", new LInteger(3));
    }

    @Test
    public void testEval2() {
        testFor("(eval (cons + (cons 1 (cons 2 nil))))", new LInteger(3));
    }

    @Test
    public void testCounter() {
        testFor(
                "(let* ((counter (atom 0)) " +
                "       (increment (fn* () (swap! counter + 1))) " +
                "       (get-count (fn* () (deref counter)))) " +
                "  (do (increment) (increment) (increment) (get-count)))",
                new LInteger(3)
        );
    }

    @Test
    public void testReset() {
        testFor("(let* ((x (atom 1)) (y (reset! x 2)) (z (reset! x 1))) (+ (deref x) (+ y z)))", new LInteger(4));
    }

    @Test
    public void testToggleSwitch() {
        testFor(
                "(let* ((switch (atom 0)) " +
                "       (toggle (fn* () (swap! switch (fn* (s) (if s 0 1)))))) " +
                "  (do (toggle) (toggle) (toggle) (deref switch)))",
                new LInteger(1)
        );
    }
}